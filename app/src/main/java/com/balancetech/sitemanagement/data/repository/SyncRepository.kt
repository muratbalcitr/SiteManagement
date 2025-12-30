package com.balancetech.sitemanagement.data.repository

import com.balancetech.sitemanagement.data.datasource.LocalDataSource
import com.balancetech.sitemanagement.data.datasource.RemoteDataSource
import kotlinx.coroutines.flow.first
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class SyncRepository @Inject constructor(
    private val localDataSource: LocalDataSource,
    private val remoteDataSource: RemoteDataSource
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
            
            // Sync payments
            try {
                val payments = localDataSource.getAllPayments().first()
                var successCount = 0
                payments.forEach { payment ->
                    val result = remoteDataSource.createPayment(payment)
                    if (result.isSuccess) {
                        successCount++
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
    suspend fun syncFromFirebase(): Result<String> {
        return try {
            val results = mutableListOf<String>()
            
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

