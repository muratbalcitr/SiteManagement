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
                        val blockId = unit?.blockId ?: "unknown"
                        
                        // Create paymentId in correct format: unit-block-{blockId}-{unitNumber}
                        val paymentId = "unit-block-$blockId-$unitNumber"
                        
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
            
            // IMPORTANT: Sync units FIRST before users and user_units
            // This ensures foreign key constraints are satisfied
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
            
            // Sync users from remote (after units are synced)
            try {
                val remoteUsers = remoteDataSource.getAllUsers()
                if (remoteUsers.isNotEmpty()) {
                    localDataSource.insertUsers(remoteUsers)
                    
                    // Create UserUnit relationships from user.unitId (for backward compatibility)
                    // This is done AFTER units are synced to satisfy foreign key constraints
                    val userUnits = mutableListOf<UserUnit>()
                    remoteUsers.forEach { user ->
                        if (user.unitId != null) {
                            // Verify that the unit exists before creating UserUnit relationship
                            val unitExists = localDataSource.getUnitById(user.unitId) != null
                            if (unitExists) {
                                // Check if UserUnit already exists
                                val existingUnitIds = userUnitDao.getUnitIdsByUserId(user.id).toSet()
                                if (user.unitId !in existingUnitIds) {
                                    userUnits.add(UserUnit(userId = user.id, unitId = user.unitId))
                                }
                            } else {
                                android.util.Log.w("SyncRepository", "Unit ${user.unitId} not found for user ${user.id}, skipping UserUnit relationship")
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
            
            // IMPORTANT: Sync order matters for foreign key constraints:
            // 1. Units (already synced)
            // 2. Users (already synced)
            // 3. UserUnits (already synced)
            // 4. WaterMeters (depends on Units)
            // 5. Fees (depends on Units)
            // 6. ExtraPayments (depends on Units)
            // 7. WaterBills (depends on Units and WaterMeters)
            // 8. Payments (depends on Units, Fees, ExtraPayments, WaterBills)
            
            // Sync water meters from remote (depends on Units)
            try {
                val remoteWaterMeters = remoteDataSource.getAllWaterMeters()
                if (remoteWaterMeters.isNotEmpty()) {
                    // Verify units exist before inserting water meters
                    val validWaterMeters = remoteWaterMeters.filter { waterMeter ->
                        val unitExists = localDataSource.getUnitById(waterMeter.unitId) != null
                        if (!unitExists) {
                            android.util.Log.w("SyncRepository", "Unit ${waterMeter.unitId} not found for water meter ${waterMeter.id}, skipping")
                        }
                        unitExists
                    }
                    if (validWaterMeters.isNotEmpty()) {
                        validWaterMeters.forEach { localDataSource.insertWaterMeter(it) }
                        results.add("${validWaterMeters.size} su sayacı indirildi")
                    }
                }
            } catch (e: Exception) {
                results.add("Su sayacı indirme hatası: ${e.message}")
            }
            
            // Sync fees from remote (depends on Units)
            try {
                android.util.Log.d("SyncRepository", "Starting fees sync from Firebase...")
                val remoteFees = remoteDataSource.getAllFees()
                android.util.Log.d("SyncRepository", "Fetched ${remoteFees.size} fees from Firebase")
                
                if (remoteFees.isNotEmpty()) {
                    // Get all unit IDs that exist locally
                    val allUnits = localDataSource.getUnitsByApartment(apartmentId)
                    val existingUnitIds = allUnits.map { it.id }.toSet()
                    android.util.Log.d("SyncRepository", "Found ${existingUnitIds.size} units locally")
                    
                    // Verify units exist before inserting fees
                    val validFees = remoteFees.filter { fee ->
                        val unitExists = existingUnitIds.contains(fee.unitId)
                        if (!unitExists) {
                            android.util.Log.w("SyncRepository", "Unit ${fee.unitId} not found for fee ${fee.id} (unitNumber might be different), skipping")
                        } else {
                            android.util.Log.d("SyncRepository", "Fee ${fee.id} is valid for unit ${fee.unitId}")
                        }
                        unitExists
                    }
                    
                    android.util.Log.d("SyncRepository", "Valid fees: ${validFees.size} out of ${remoteFees.size}")
                    
                    if (validFees.isNotEmpty()) {
                        localDataSource.insertFees(validFees)
                        results.add("${validFees.size} aidat indirildi")
                        android.util.Log.d("SyncRepository", "Successfully inserted ${validFees.size} fees")
                    } else {
                        android.util.Log.w("SyncRepository", "No valid fees to insert. Check if units are synced first.")
                        results.add("Aidat indirilemedi: Daireler önce senkronize edilmeli")
                    }
                } else {
                    android.util.Log.w("SyncRepository", "No fees found in Firebase")
                    results.add("Firebase'de aidat bulunamadı")
                }
            } catch (e: Exception) {
                android.util.Log.e("SyncRepository", "Error syncing fees: ${e.message}", e)
                e.printStackTrace()
                results.add("Aidat indirme hatası: ${e.message}")
            }
            
            // Sync extra payments from remote (depends on Units)
            try {
                val remoteExtraPayments = remoteDataSource.getAllExtraPayments(apartmentId)
                if (remoteExtraPayments.isNotEmpty()) {
                    // Verify units exist before inserting extra payments (unitId can be null for apartment-wide payments)
                    val validExtraPayments = remoteExtraPayments.filter { extraPayment ->
                        if (extraPayment.unitId != null) {
                            val unitExists = localDataSource.getUnitById(extraPayment.unitId) != null
                            if (!unitExists) {
                                android.util.Log.w("SyncRepository", "Unit ${extraPayment.unitId} not found for extra payment ${extraPayment.id}, skipping")
                            }
                            unitExists
                        } else {
                            // Apartment-wide payment, no unit required
                            true
                        }
                    }
                    if (validExtraPayments.isNotEmpty()) {
                        validExtraPayments.forEach { localDataSource.insertExtraPayment(it) }
                        results.add("${validExtraPayments.size} ek ödeme indirildi")
                    }
                }
            } catch (e: Exception) {
                results.add("Ek ödeme indirme hatası: ${e.message}")
            }
            
            // Sync water bills from remote (depends on Units and WaterMeters)
            try {
                val remoteWaterBills = remoteDataSource.getAllWaterBills()
                if (remoteWaterBills.isNotEmpty()) {
                    // Verify units and water meters exist before inserting water bills
                    val validWaterBills = remoteWaterBills.filter { waterBill ->
                        val unitExists = localDataSource.getUnitById(waterBill.unitId) != null
                        val waterMeterExists = localDataSource.getWaterMeterByUnit(waterBill.unitId) != null
                        if (!unitExists) {
                            android.util.Log.w("SyncRepository", "Unit ${waterBill.unitId} not found for water bill ${waterBill.id}, skipping")
                        } else if (!waterMeterExists) {
                            android.util.Log.w("SyncRepository", "Water meter not found for unit ${waterBill.unitId} in water bill ${waterBill.id}, skipping")
                        }
                        unitExists && waterMeterExists
                    }
                    if (validWaterBills.isNotEmpty()) {
                        validWaterBills.forEach { localDataSource.insertWaterBill(it) }
                        results.add("${validWaterBills.size} su faturası indirildi")
                    }
                }
            } catch (e: Exception) {
                results.add("Su faturası indirme hatası: ${e.message}")
            }
            
            // Sync payments from remote (depends on Units, Fees, ExtraPayments, WaterBills)
            try {
                val remotePayments = remoteDataSource.getAllPayments()
                if (remotePayments.isNotEmpty()) {
                    // Verify dependencies exist before inserting payments
                    val validPayments = remotePayments.filter { payment ->
                        val unitExists = localDataSource.getUnitById(payment.unitId) != null
                        if (!unitExists) {
                            android.util.Log.w("SyncRepository", "Unit ${payment.unitId} not found for payment ${payment.id}, skipping")
                            return@filter false
                        }
                        
                        // Check optional dependencies
                        if (payment.feeId != null) {
                            val feeExists = localDataSource.getFeeById(payment.feeId) != null
                            if (!feeExists) {
                                android.util.Log.w("SyncRepository", "Fee ${payment.feeId} not found for payment ${payment.id}, skipping")
                                return@filter false
                            }
                        }
                        
                        // ExtraPayment check is optional - if it doesn't exist, payment can still be valid
                        // (ExtraPayment doesn't have foreign key constraint in Room)
                        
                        if (payment.waterBillId != null) {
                            val waterBillExists = localDataSource.getWaterBillById(payment.waterBillId) != null
                            if (!waterBillExists) {
                                android.util.Log.w("SyncRepository", "Water bill ${payment.waterBillId} not found for payment ${payment.id}, skipping")
                                return@filter false
                            }
                        }
                        
                        true
                    }
                    if (validPayments.isNotEmpty()) {
                        localDataSource.insertPayments(validPayments)
                        results.add("${validPayments.size} ödeme indirildi")
                    }
                }
            } catch (e: Exception) {
                results.add("Ödeme indirme hatası: ${e.message}")
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

