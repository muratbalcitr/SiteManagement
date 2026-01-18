package com.balancetech.sitemanagement.data.repository

import com.balancetech.sitemanagement.data.dao.FeeDao
import com.balancetech.sitemanagement.data.dao.UnitDao
import com.balancetech.sitemanagement.data.dao.UserDao
import com.balancetech.sitemanagement.data.datasource.LocalDataSource
import com.balancetech.sitemanagement.data.datasource.RemoteDataSource
import com.balancetech.sitemanagement.data.entity.Fee
import com.balancetech.sitemanagement.data.model.PaymentStatus
import com.balancetech.sitemanagement.data.service.FirebaseFunctionsService
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.first
import java.util.Calendar
import java.util.UUID

/**
 * FeeRepository with offline-first strategy
 * Writes to local database first, then syncs to Firebase via Functions
 */
class FeeRepository(
    private val feeDao: FeeDao,
    private val unitDao: UnitDao,
    private val localDataSource: LocalDataSource,
    private val remoteDataSource: RemoteDataSource,
    private val functionsService: FirebaseFunctionsService,
    private val userDao: UserDao
) {
    fun getFeesByUnit(unitId: String): Flow<List<Fee>> = feeDao.getFeesByUnit(unitId)

    fun getFeesByMonth(apartmentId: String, month: Int, year: Int): Flow<List<Fee>> =
        feeDao.getFeesByMonth(apartmentId, month, year)

    fun getFeesByStatus(unitId: String, status: PaymentStatus): Flow<List<Fee>> =
        feeDao.getFeesByUnitAndStatus(unitId, status)

    fun getAllFees(): Flow<List<Fee>> = feeDao.getAllFees()

    suspend fun getFeeById(id: String): Fee? = feeDao.getFeeById(id)

    suspend fun createFee(
        apartmentId: String,
        unitId: String,
        month: Int,
        year: Int,
        amount: Double,
        dueDate: Long
    ): Result<Fee> {
        // Get unit to extract unit number for document ID
        val unit = localDataSource.getUnitById(unitId)
        val unitNumber = unit?.unitNumber?.lowercase() ?: unitId
        
        // Generate fee ID: unitNumber-month-year (e.g., "a1-1-2024")
        val feeId = "${unitNumber}-${month}-${year}"
        
        val fee = Fee(
            id = feeId,
            apartmentId = apartmentId,
            unitId = unitId,
            month = month,
            year = year,
            amount = amount,
            dueDate = dueDate
        )
        // Save to local first (offline-first)
        feeDao.insertFee(fee)
        
        // Then sync to Firebase via Functions (fire and forget - errors handled silently)
        CoroutineScope(Dispatchers.IO).launch {
            try {
                functionsService.createFee(apartmentId, unitId, month, year, amount, dueDate)
            } catch (e: Exception) {
                // Fallback to direct Firestore sync if Functions fails
                remoteDataSource.createFee(fee)
            }
        }
        
        return Result.success(fee)
    }

    data class CreateFeesResult(
        val createdCount: Int,
        val updatedCount: Int,
        val fees: List<Fee>
    )

    suspend fun createFeesForAllUnits(
        apartmentId: String,
        month: Int,
        year: Int,
        baseAmount: Double,
        dueDate: Long
    ): Result<CreateFeesResult> {
        val units = unitDao.getUnitsByApartment(apartmentId).first()
        val feesToCreate = mutableListOf<Fee>()
        val feesToUpdate = mutableListOf<Fee>()

        // Create fees for all active units (not just units with users)
        units.forEach { unit ->
            // Check if fee already exists for this unit, month, and year
            val existingFee = feeDao.getFeeByUnitMonthYear(unit.id, month, year)
            
            if (existingFee != null) {
                // Update existing fee - preserve paidAmount and status
                val feeAmount = baseAmount
                val updatedFee = existingFee.copy(
                    amount = feeAmount,
                    dueDate = dueDate,
                    updatedAt = System.currentTimeMillis()
                )
                feesToUpdate.add(updatedFee)
            } else {
                // Create new fee
                val feeAmount = baseAmount
                // Generate fee ID: unitNumber-month-year (e.g., "a1-1-2024")
                val unitNumber = unit.unitNumber.lowercase()
                val feeId = "${unitNumber}-${month}-${year}"
                
                val fee = Fee(
                    id = feeId,
                    apartmentId = apartmentId,
                    unitId = unit.id,
                    month = month,
                    year = year,
                    amount = feeAmount,
                    dueDate = dueDate
                )
                feesToCreate.add(fee)
            }
        }

        // Update existing fees
        if (feesToUpdate.isNotEmpty()) {
            feesToUpdate.forEach { fee ->
                feeDao.updateFee(fee)
            }
        }

        // Create new fees
        if (feesToCreate.isNotEmpty()) {
            feeDao.insertFees(feesToCreate)
        }

        // Sync to Firebase via Functions
        if (feesToCreate.isNotEmpty() || feesToUpdate.isNotEmpty()) {
            CoroutineScope(Dispatchers.IO).launch {
                try {
                    functionsService.createFeesForAllUnits(apartmentId, month, year, baseAmount, dueDate)
                } catch (e: Exception) {
                    // Fallback to direct Firestore sync if Functions fails
                    if (feesToCreate.isNotEmpty()) {
                        remoteDataSource.createFees(feesToCreate)
                    }
                    feesToUpdate.forEach { fee ->
                        remoteDataSource.updateFee(fee)
                    }
                }
            }
        }

        // Return result with counts
        val result = CreateFeesResult(
            createdCount = feesToCreate.size,
            updatedCount = feesToUpdate.size,
            fees = feesToCreate + feesToUpdate
        )
        return Result.success(result)
    }

    suspend fun updateFee(fee: Fee) {
        // Update local first
        feeDao.updateFee(fee)
        
        // Then sync to remote
        CoroutineScope(Dispatchers.IO).launch {
            remoteDataSource.updateFee(fee)
        }
    }

    suspend fun recordPayment(feeId: String, paymentAmount: Double): Result<Fee> {
        val fee = feeDao.getFeeById(feeId)
        return if (fee != null) {
            // Prevent duplicate payment if fee is already PAID
            if (fee.status == PaymentStatus.PAID) {
            return Result.failure(Exception("Bu aidat zaten tamamen ödenmiş. Mükerrer ödeme yapılamaz."))
            }
            
            val newPaidAmount = fee.paidAmount + paymentAmount
            val newStatus = when {
                newPaidAmount >= fee.amount -> PaymentStatus.PAID
                newPaidAmount > 0 -> PaymentStatus.PARTIALLY_PAID
                else -> PaymentStatus.UNPAID
            }
            val updatedFee = fee.copy(
                paidAmount = newPaidAmount,
                status = newStatus,
                updatedAt = System.currentTimeMillis()
            )
            // Update local first
            feeDao.updateFee(updatedFee)
            
            // Then sync to remote
            CoroutineScope(Dispatchers.IO).launch {
                remoteDataSource.updateFee(updatedFee)
            }
            
            Result.success(updatedFee)
        } else {
            Result.failure(Exception("Fee not found"))
        }
    }

    /**
     * Sync local data to Firebase
     */
    suspend fun syncToRemote(): Result<Unit> {
        return try {
            val localFees = feeDao.getAllFees().first()
            remoteDataSource.createFees(localFees)
            Result.success(Unit)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }

    /**
     * Sync Firebase data to local
     */
    suspend fun syncFromRemote(): Result<Unit> {
        return try {
            val remoteFees = remoteDataSource.getAllFees()
            feeDao.insertFees(remoteFees)
            Result.success(Unit)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
}
