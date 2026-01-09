package com.balancetech.sitemanagement.data.repository

import com.balancetech.sitemanagement.data.dao.UserUnitDao
import com.balancetech.sitemanagement.data.datasource.LocalDataSource
import com.balancetech.sitemanagement.data.datasource.RemoteDataSource
import com.balancetech.sitemanagement.data.entity.UserUnit
import com.balancetech.sitemanagement.data.model.PaymentStatus
import com.balancetech.sitemanagement.data.repository.PaymentRepository
import com.balancetech.sitemanagement.data.service.FirebaseFunctionsService
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.tasks.await
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class SyncRepository @Inject constructor(
    private val localDataSource: LocalDataSource,
    private val remoteDataSource: RemoteDataSource,
    private val userUnitDao: UserUnitDao,
    private val functionsService: FirebaseFunctionsService,
    private val firestore: FirebaseFirestore,
    private val paymentRepository: PaymentRepository
) {
    /**
     * Sync all local data to Firebase
     */
    suspend fun syncAllToFirebase(): Result<String> {
        return try {
            val results = mutableListOf<String>()
            
            // Sync fees - Use updateFee for all fees to ensure paid status is properly synced
            // updateFee uses set() which creates or updates the document
            try {
                val fees = localDataSource.getAllFees().first()
                if (fees.isNotEmpty()) {
                    var successCount = 0
                    var errorCount = 0
                    val errors = mutableListOf<String>()
                    
                    // Use batch for efficiency, but update each fee individually to ensure status is synced
                    val batch = firestore.batch()
                    val feesCollection = firestore.collection("fees")
                    
                    fees.forEach { fee ->
                        try {
                            // Use set() which creates or updates - this ensures paid status is synced
                            batch.set(feesCollection.document(fee.id), fee)
                            android.util.Log.d("SyncRepository", "Queued fee ${fee.id} for sync (status: ${fee.status}, paidAmount: ${fee.paidAmount}, amount: ${fee.amount})")
                        } catch (e: Exception) {
                            errorCount++
                            val errorMsg = "Fee ${fee.id}: ${e.message}"
                            errors.add(errorMsg)
                            android.util.Log.e("SyncRepository", errorMsg, e)
                        }
                    }
                    
                    // Commit batch
                    try {
                        batch.commit().await()
                        successCount = fees.size - errorCount
                        android.util.Log.d("SyncRepository", "Successfully synced $successCount fees to Firebase")
                    } catch (e: Exception) {
                        android.util.Log.e("SyncRepository", "Error committing fees batch: ${e.message}", e)
                        // Fallback: try individual updates
                        fees.forEach { fee ->
                            try {
                                val result = remoteDataSource.updateFee(fee)
                                if (result.isSuccess) {
                                    successCount++
                                } else {
                                    errorCount++
                                    errors.add("Fee ${fee.id}: ${result.exceptionOrNull()?.message}")
                                }
                            } catch (e2: Exception) {
                                errorCount++
                                errors.add("Fee ${fee.id}: ${e2.message}")
                            }
                        }
                    }
                    
                    if (successCount > 0) {
                        results.add("$successCount aidat senkronize edildi")
                    }
                    if (errorCount > 0) {
                        results.add("$errorCount aidat senkronize edilemedi")
                        if (errors.size <= 5) {
                            errors.forEach { results.add("  - $it") }
                        } else {
                            errors.take(5).forEach { results.add("  - $it") }
                            results.add("  - ... ve ${errors.size - 5} hata daha")
                        }
                    }
                    
                    // Check for PAID fees without payment records and create them
                    try {
                        val paidFees = fees.filter { it.status == PaymentStatus.PAID && it.paidAmount > 0 }
                        var createdPaymentCount = 0
                        val currentUser = localDataSource.getCurrentUser()
                        val createdBy = currentUser?.id ?: "system"
                        
                        paidFees.forEach { fee ->
                            // Check if payment record exists for this fee
                            val existingPayments = paymentRepository.getPaymentsByFee(fee.id).first()
                            if (existingPayments.isEmpty()) {
                                // Create payment record for this fee
                                try {
                                    val result = paymentRepository.recordPayment(
                                        unitId = fee.unitId,
                                        amount = fee.paidAmount,
                                        paymentMethod = "unknown", // Default payment method
                                        description = "Otomatik oluşturuldu - ${fee.month}/${fee.year} aidat ödemesi",
                                        createdBy = createdBy,
                                        feeId = fee.id
                                    )
                                    if (result.isSuccess) {
                                        createdPaymentCount++
                                        android.util.Log.d("SyncRepository", "Created payment record for fee ${fee.id}")
                                    }
                                } catch (e: Exception) {
                                    android.util.Log.e("SyncRepository", "Error creating payment for fee ${fee.id}: ${e.message}", e)
                                }
                            }
                        }
                        
                        if (createdPaymentCount > 0) {
                            results.add("$createdPaymentCount eksik ödeme kaydı oluşturuldu (PAID aidatlar için)")
                        }
                    } catch (e: Exception) {
                        android.util.Log.e("SyncRepository", "Error checking paid fees for payment records: ${e.message}", e)
                    }
                }
            } catch (e: Exception) {
                android.util.Log.e("SyncRepository", "Error syncing fees: ${e.message}", e)
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
                        // Use updateWaterBill which uses set() to create or update
                        val result = remoteDataSource.updateWaterBill(bill)
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
                    
                    // Get all units to create a mapping by unitNumber and by ID
                    val allUnits = localDataSource.getUnitsByApartment(apartmentId)
                    val unitByIdMap = allUnits.associateBy { it.id }
                    val unitByNumberMap = allUnits.associateBy { it.unitNumber.uppercase() }
                    
                    // Create UserUnit relationships from user.unitId (for backward compatibility)
                    // This is done AFTER units are synced to satisfy foreign key constraints
                    val userUnits = mutableListOf<UserUnit>()
                    remoteUsers.forEach { user ->
                        if (user.unitId != null) {
                            // Try to find unit by ID first
                            var foundUnit = unitByIdMap[user.unitId]
                            
                            // If not found by ID, try to find by unitNumber (extract from unitId format)
                            if (foundUnit == null) {
                                // Try to extract unitNumber from unitId (e.g., "unit-block-a-6-A18" -> "A18")
                                val unitNumberMatch = Regex("([A-Z]\\d+)$").find(user.unitId.uppercase())
                                if (unitNumberMatch != null) {
                                    val unitNumber = unitNumberMatch.groupValues[1]
                                    foundUnit = unitByNumberMap[unitNumber]
                                    if (foundUnit != null) {
                                        android.util.Log.d("SyncRepository", "Matched user unitId ${user.unitId} to unit ${foundUnit.id} by unitNumber ${unitNumber}")
                                    }
                                }
                            }
                            
                            val unit = foundUnit
                            if (unit != null) {
                                // Check if UserUnit already exists
                                val existingUnitIds = userUnitDao.getUnitIdsByUserId(user.id).toSet()
                                if (unit.id !in existingUnitIds) {
                                    userUnits.add(UserUnit(userId = user.id, unitId = unit.id))
                                    android.util.Log.d("SyncRepository", "Created UserUnit relationship: user ${user.id} -> unit ${unit.id}")
                                }
                            } else {
                                android.util.Log.w("SyncRepository", "Unit ${user.unitId} not found for user ${user.id}, skipping UserUnit relationship")
                            }
                        }
                    }
                    if (userUnits.isNotEmpty()) {
                        userUnitDao.insertUserUnits(userUnits)
                        android.util.Log.d("SyncRepository", "Created ${userUnits.size} UserUnit relationships")
                    }
                    
                    results.add("${remoteUsers.size} kullanıcı indirildi")
                }
            } catch (e: Exception) {
                android.util.Log.e("SyncRepository", "Error syncing users: ${e.message}", e)
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
                    // Get all units to create a mapping by ID and by unitNumber
                    val allUnits = localDataSource.getUnitsByApartment(apartmentId)
                    val unitByIdMap = allUnits.associateBy { it.id }
                    val unitByNumberMap = allUnits.associateBy { it.unitNumber.uppercase() }
                    android.util.Log.d("SyncRepository", "Found ${allUnits.size} units locally")
                    
                    // Map fees to correct unit IDs
                    val validFees = remoteFees.mapNotNull { fee ->
                        // Try to find unit by ID first
                        val unitById = unitByIdMap[fee.unitId]
                        
                        // If not found by ID, try to find by unitNumber (extract from fee ID or unitId)
                        val unitByNumberFromUnitId = if (unitById == null) {
                            // Try to extract unitNumber from fee.unitId (e.g., "unit-block-b-10-B29" -> "B29")
                            val unitNumberMatch = Regex("([A-Z]\\d+)$").find(fee.unitId.uppercase())
                            if (unitNumberMatch != null) {
                                val unitNumber = unitNumberMatch.groupValues[1]
                                unitByNumberMap[unitNumber]
                            } else {
                                null
                            }
                        } else {
                            null
                        }
                        
                        // If still not found, try to extract from fee.id (e.g., "b29-1-2026" -> "B29")
                        val unitByNumberFromFeeId = if (unitById == null && unitByNumberFromUnitId == null) {
                            val feeIdMatch = Regex("^([a-z]\\d+)", RegexOption.IGNORE_CASE).find(fee.id)
                            if (feeIdMatch != null) {
                                val unitNumber = feeIdMatch.groupValues[1].uppercase()
                                unitByNumberMap[unitNumber]
                            } else {
                                null
                            }
                        } else {
                            null
                        }
                        
                        // Use the first non-null unit found
                        val unit = unitById ?: unitByNumberFromUnitId ?: unitByNumberFromFeeId
                        
                        if (unit != null) {
                            // Log which method found the unit
                            when {
                                unitById != null -> android.util.Log.d("SyncRepository", "Matched fee ${fee.id} to unit ${unit.id} by unitId")
                                unitByNumberFromUnitId != null -> android.util.Log.d("SyncRepository", "Matched fee unitId ${fee.unitId} to unit ${unit.id} by unitNumber")
                                unitByNumberFromFeeId != null -> android.util.Log.d("SyncRepository", "Matched fee ${fee.id} to unit ${unit.id} by unitNumber from fee.id")
                            }
                            
                            // Update fee with correct unitId
                            val correctedFee = fee.copy(unitId = unit.id)
                            android.util.Log.d("SyncRepository", "Fee ${fee.id} mapped to unit ${unit.id}")
                            correctedFee
                        } else {
                            android.util.Log.w("SyncRepository", "Unit not found for fee ${fee.id} (unitId: ${fee.unitId}), skipping")
                            null
                        }
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

