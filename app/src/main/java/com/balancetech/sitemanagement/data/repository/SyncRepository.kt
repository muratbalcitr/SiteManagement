package com.balancetech.sitemanagement.data.repository

import com.balancetech.sitemanagement.data.dao.UserUnitDao
import com.balancetech.sitemanagement.data.datasource.LocalDataSource
import com.balancetech.sitemanagement.data.datasource.RemoteDataSource
import com.balancetech.sitemanagement.data.entity.UserUnit
import com.balancetech.sitemanagement.data.service.FirebaseFunctionsService
import kotlinx.coroutines.flow.first
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class SyncRepository @Inject constructor(
    private val localDataSource: LocalDataSource,
    private val remoteDataSource: RemoteDataSource,
    private val userUnitDao: UserUnitDao,
    private val functionsService: FirebaseFunctionsService
) {
    /**
     * Sync all local data to Firebase
     */
    suspend fun syncAllToFirebase(): Result<String> {
        return try {
            val results = mutableListOf<String>()
            
            // Sync fees
            try {
                val fees = localDataSource.getAllFees().first()
                if (fees.isNotEmpty()) {
                    val result = remoteDataSource.createFees(fees)
                    if (result.isSuccess) {
                        results.add("${fees.size} aidat senkronize edildi")
                    } else {
                        results.add("Aidat senkronizasyonu hatası: ${result.exceptionOrNull()?.message}")
                    }
                }
            } catch (e: Exception) {
                results.add("Aidat senkronizasyonu hatası: ${e.message}")
            }
            
            // Sync payments - Use Firebase Functions to ensure correct documentId format
            try {
                val payments = localDataSource.getAllPayments().first()
                var successCount = 0
                payments.forEach { payment ->
                    try {
                        // Get unit to create correct paymentId format
                        val unit = localDataSource.getUnitById(payment.unitId)
                        val unitNumber = unit?.unitNumber ?: payment.unitId
                        
                        // Create paymentId in correct format: unitNumber_timestamp
                        val timestamp = payment.paymentDate.takeIf { it > 0 } ?: payment.createdAt.takeIf { it > 0 } ?: System.currentTimeMillis()
                        val paymentId = "${unitNumber}_$timestamp"
                        
                        // Use Firebase Functions to sync payment with correct documentId
                        val result = functionsService.recordPayment(
                            unitId = payment.unitId,
                            amount = payment.amount,
                            paymentMethod = payment.paymentMethod,
                            description = payment.description,
                            feeId = payment.feeId,
                            extraPaymentId = payment.extraPaymentId,
                            waterBillId = payment.waterBillId,
                            paymentId = paymentId
                        )
                        if (result.isSuccess) {
                            successCount++
                        }
                    } catch (e: Exception) {
                        // Log individual payment error but continue
                        android.util.Log.e("SyncRepository", "Error syncing payment ${payment.id}: ${e.message}")
                    }
                }
                if (successCount > 0) {
                    results.add("$successCount ödeme senkronize edildi")
                }
            } catch (e: Exception) {
                results.add("Ödeme senkronizasyonu hatası: ${e.message}")
            }
            
            // Sync water meters
            try {
                val waterMeters = localDataSource.getAllWaterMeters().first()
                var successCount = 0
                waterMeters.forEach { meter ->
                    val result = remoteDataSource.createOrUpdateWaterMeter(meter)
                    if (result.isSuccess) {
                        successCount++
                    }
                }
                if (successCount > 0) {
                    results.add("$successCount su sayacı senkronize edildi")
                }
            } catch (e: Exception) {
                results.add("Su sayacı senkronizasyonu hatası: ${e.message}")
            }
            
            // Sync water bills
            try {
                // Get all units first
                val units = localDataSource.getUnitsByApartment("apt-001") // TODO: Get from current user
                var totalBills = 0
                units.forEach { unit ->
                    val bills = localDataSource.getWaterBillsByUnit(unit.id).first()
                    bills.forEach { bill ->
                        val result = remoteDataSource.createWaterBill(bill)
                        if (result.isSuccess) {
                            totalBills++
                        }
                    }
                }
                if (totalBills > 0) {
                    results.add("$totalBills su faturası senkronize edildi")
                }
            } catch (e: Exception) {
                results.add("Su faturası senkronizasyonu hatası: ${e.message}")
            }
            
            // Sync notifications
            try {
                // Get current user's notifications
                val currentUser = localDataSource.getCurrentUser()
                if (currentUser != null) {
                    val notifications = localDataSource.getNotificationsByUser(currentUser.id).first()
                    var successCount = 0
                    notifications.forEach { notification ->
                        val result = remoteDataSource.createNotification(notification)
                        if (result.isSuccess) {
                            successCount++
                        }
                    }
                    if (successCount > 0) {
                        results.add("$successCount bildirim senkronize edildi")
                    }
                }
            } catch (e: Exception) {
                results.add("Bildirim senkronizasyonu hatası: ${e.message}")
            }
            
            val message = if (results.isEmpty()) {
                "Senkronize edilecek veri bulunamadı"
            } else {
                results.joinToString("\n")
            }
            
            Result.success(message)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
    
    /**
     * Sync data from Firebase to local
     */
    suspend fun syncFromFirebase(apartmentId: String = "apt-001"): Result<String> {
        return try {
            val results = mutableListOf<String>()
            
            // Sync users from remote
            try {
                val remoteUsers = remoteDataSource.getAllUsers()
                if (remoteUsers.isNotEmpty()) {
                    localDataSource.insertUsers(remoteUsers)
                    
                    // Create UserUnit relationships from user.unitId (for backward compatibility)
                    val userUnits = mutableListOf<UserUnit>()
                    remoteUsers.forEach { user ->
                        if (user.unitId != null) {
                            // Check if UserUnit already exists
                            val existingUnitIds = userUnitDao.getUnitIdsByUserId(user.id).toSet()
                            if (user.unitId !in existingUnitIds) {
                                userUnits.add(UserUnit(userId = user.id, unitId = user.unitId))
                            }
                        }
                    }
                    if (userUnits.isNotEmpty()) {
                        userUnitDao.insertUserUnits(userUnits)
                    }
                    
                    results.add("${remoteUsers.size} kullanıcı indirildi")
                }
            } catch (e: Exception) {
                results.add("Kullanıcı indirme hatası: ${e.message}")
            }
            
            // Sync units from remote
            try {
                val remoteUnits = remoteDataSource.getUnitsByApartment(apartmentId)
                if (remoteUnits.isNotEmpty()) {
                    remoteUnits.forEach { localDataSource.insertUnit(it) }
                    results.add("${remoteUnits.size} daire indirildi")
                }
            } catch (e: Exception) {
                results.add("Daire indirme hatası: ${e.message}")
            }
            
            // Sync fees from remote
            try {
                val remoteFees = remoteDataSource.getAllFees()
                if (remoteFees.isNotEmpty()) {
                    localDataSource.insertFees(remoteFees)
                    results.add("${remoteFees.size} aidat indirildi")
                }
            } catch (e: Exception) {
                results.add("Aidat indirme hatası: ${e.message}")
            }
            
            // Sync payments from remote
            try {
                val remotePayments = remoteDataSource.getAllPayments()
                if (remotePayments.isNotEmpty()) {
                    localDataSource.insertPayments(remotePayments)
                    results.add("${remotePayments.size} ödeme indirildi")
                }
            } catch (e: Exception) {
                results.add("Ödeme indirme hatası: ${e.message}")
            }
            
            // Sync water meters from remote
            try {
                val remoteWaterMeters = remoteDataSource.getAllWaterMeters()
                if (remoteWaterMeters.isNotEmpty()) {
                    localDataSource.insertWaterMeters(remoteWaterMeters)
                    results.add("${remoteWaterMeters.size} su sayacı indirildi")
                }
            } catch (e: Exception) {
                results.add("Su sayacı indirme hatası: ${e.message}")
            }
            
            // Sync water bills from remote
            try {
                val remoteWaterBills = remoteDataSource.getAllWaterBills()
                if (remoteWaterBills.isNotEmpty()) {
                    localDataSource.insertWaterBills(remoteWaterBills)
                    results.add("${remoteWaterBills.size} su faturası indirildi")
                }
            } catch (e: Exception) {
                results.add("Su faturası indirme hatası: ${e.message}")
            }
            
            // Sync extra payments from remote
            try {
                val remoteExtraPayments = remoteDataSource.getAllExtraPayments(apartmentId)
                if (remoteExtraPayments.isNotEmpty()) {
                    remoteExtraPayments.forEach { 
                        localDataSource.insertExtraPayment(it) 
                    }
                    results.add("${remoteExtraPayments.size} ek ödeme indirildi")
                }
            } catch (e: Exception) {
                results.add("Ek ödeme indirme hatası: ${e.message}")
            }
            
            // Sync notifications from remote (for current user)
            try {
                val currentUser = localDataSource.getCurrentUser()
                if (currentUser != null) {
                    val remoteNotifications = remoteDataSource.getNotificationsByUser(currentUser.id)
                    if (remoteNotifications.isNotEmpty()) {
                        remoteNotifications.forEach { localDataSource.insertNotification(it) }
                        results.add("${remoteNotifications.size} bildirim indirildi")
                    }
                }
            } catch (e: Exception) {
                results.add("Bildirim indirme hatası: ${e.message}")
            }
            
            val message = if (results.isEmpty()) {
                "İndirilecek veri bulunamadı"
            } else {
                results.joinToString("\n")
            }
            
            Result.success(message)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
}

