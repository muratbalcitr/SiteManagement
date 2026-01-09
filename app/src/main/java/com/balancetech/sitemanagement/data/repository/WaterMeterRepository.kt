package com.balancetech.sitemanagement.data.repository

import com.balancetech.sitemanagement.data.dao.WaterMeterDao
import com.balancetech.sitemanagement.data.dao.WaterBillDao
import com.balancetech.sitemanagement.data.datasource.LocalDataSource
import com.balancetech.sitemanagement.data.datasource.RemoteDataSource
import com.balancetech.sitemanagement.data.entity.WaterMeter
import com.balancetech.sitemanagement.data.entity.WaterBill
import com.balancetech.sitemanagement.data.model.PaymentStatus
import com.balancetech.sitemanagement.data.service.FirebaseFunctionsService
import com.balancetech.sitemanagement.util.MeskiBillCalculator
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.flow.Flow
import java.util.Calendar
import java.util.UUID
import javax.inject.Inject

class WaterMeterRepository @Inject constructor(
    private val waterMeterDao: WaterMeterDao,
    private val waterBillDao: WaterBillDao,
    private val functionsService: FirebaseFunctionsService,
    private val remoteDataSource: RemoteDataSource,
    private val localDataSource: LocalDataSource
) {
    fun getAllWaterMeters(): Flow<List<WaterMeter>> = waterMeterDao.getAllWaterMeters()

    suspend fun getWaterMeterByUnit(unitId: String): WaterMeter? =
        waterMeterDao.getWaterMeterByUnit(unitId)

    fun getWaterBillsByUnit(unitId: String): Flow<List<WaterBill>> =
        waterBillDao.getWaterBillsByUnit(unitId)
    
    fun getAllWaterBills(): Flow<List<WaterBill>> = waterBillDao.getAllWaterBills()

    suspend fun createOrUpdateWaterMeter(
        unitId: String,
        meterNumber: String,
        unitPrice: Double
    ): Result<WaterMeter> {
        // Get unit to get unitNumber for document ID
        val unit = localDataSource.getUnitById(unitId)
            ?: return Result.failure(Exception("Unit not found"))
        
        // Use unitNumber as document ID (e.g., "A1", "B2")
        val documentId = unit.unitNumber
        
        val existing = waterMeterDao.getWaterMeterByUnit(unitId)
        val waterMeter = if (existing != null) {
            existing.copy(
                id = documentId, // Update ID to unitNumber format
                meterNumber = meterNumber,
                unitPrice = unitPrice
            )
        } else {
            WaterMeter(
                id = documentId, // Use unitNumber as document ID
                unitId = unitId,
                meterNumber = meterNumber,
                unitPrice = unitPrice,
                unitOwner = unit.ownerName.toString(),
                createdAt = System.currentTimeMillis()
            )
        }
        // Save to local first
        waterMeterDao.insertWaterMeter(waterMeter)
        
        // Then sync to Firebase
        CoroutineScope(Dispatchers.IO).launch {
            try {
                remoteDataSource.createOrUpdateWaterMeter(waterMeter)
            } catch (e: Exception) {
                // Error logged but not thrown - offline-first strategy
            }
        }
        
        return Result.success(waterMeter)
    }

    suspend fun recordReading(
        unitId: String,
        currentReading: Double
    ): Result<WaterBill> {
        val waterMeter = waterMeterDao.getWaterMeterByUnit(unitId)
            ?: return Result.failure(Exception("Water meter not found"))

        val previousReading = waterMeter.currentReading
        val consumption = currentReading - previousReading

        if (consumption < 0) {
            return Result.failure(Exception("Current reading cannot be less than previous reading"))
        }

        val calendar = Calendar.getInstance()
        val month = calendar.get(Calendar.MONTH) + 1
        val year = calendar.get(Calendar.YEAR)

        // Get unit to get unitNumber for document ID
        val unit = localDataSource.getUnitById(unitId)
            ?: return Result.failure(Exception("Unit not found"))
        
        // Use unitNumber-month-year as document ID (e.g., "A1-1-2024", "B2-2-2024")
        // This ensures each unit has one bill per month/year
        val documentId = "${unit.unitNumber}-${month}-${year}"

        // MESKİ standartlarına göre fatura hesaplama
        val billCalculation = MeskiBillCalculator.calculateWaterBill(consumption)
        
        // Check if bill already exists for this month/year
        val existingBill = waterBillDao.getWaterBillById(documentId)
        val waterBill = if (existingBill != null) {
            // Update existing bill
            existingBill.copy(
                previousReading = previousReading,
                currentReading = currentReading,
                consumption = consumption,
                amount = billCalculation.waterAmount,
                wastewaterAmount = billCalculation.wastewaterAmount,
                environmentalTax = billCalculation.environmentalTax,
                vat = billCalculation.vat,
                totalAmount = billCalculation.totalAmount,
                dueDate = System.currentTimeMillis() + (30 * 24 * 60 * 60 * 1000L)
            )
        } else {
            // Create new bill
            WaterBill(
                id = documentId, // Use unitNumber-month-year as document ID
                unitId = unitId,
                waterMeterId = waterMeter.id,
                month = month,
                year = year,
                previousReading = previousReading,
                currentReading = currentReading,
                consumption = consumption,
                unitPrice = waterMeter.unitPrice, // Deprecated, ama geriye dönük uyumluluk için tutuluyor
                amount = billCalculation.waterAmount, // Su bedeli
                wastewaterAmount = billCalculation.wastewaterAmount, // Atık su bedeli
                environmentalTax = billCalculation.environmentalTax, // ÇTV
                vat = billCalculation.vat, // KDV
                sharedAmount = 0.0, // Ortak kullanım payı (ileride eklenebilir)
                totalAmount = billCalculation.totalAmount, // Toplam tutar
                dueDate = System.currentTimeMillis() + (30 * 24 * 60 * 60 * 1000L) // 30 days from now
            )
        }

        // Update water meter with new reading
        val updatedMeter = waterMeter.copy(
            previousReading = waterMeter.currentReading,
            currentReading = currentReading,
            lastReadingDate = System.currentTimeMillis()
        )
        waterMeterDao.updateWaterMeter(updatedMeter)

        // Save to local first (offline-first)
        if (existingBill != null) {
            waterBillDao.updateWaterBill(waterBill)
        } else {
            waterBillDao.insertWaterBill(waterBill)
        }
        
        // Then sync to Firebase via Functions (pass documentId)
        CoroutineScope(Dispatchers.IO).launch {
            try {
                functionsService.recordWaterMeterReading(unitId, currentReading, documentId)
            } catch (e: Exception) {
                // Error logged but not thrown - offline-first strategy
            }
        }
        
        return Result.success(waterBill)
    }

    suspend fun recordPayment(waterBillId: String, paymentAmount: Double): Result<WaterBill> {
        val bill = waterBillDao.getWaterBillById(waterBillId)
        return if (bill != null) {
            val newPaidAmount = bill.paidAmount + paymentAmount
            val newStatus = when {
                newPaidAmount >= bill.totalAmount -> PaymentStatus.PAID
                newPaidAmount > 0 -> PaymentStatus.PARTIALLY_PAID
                else -> PaymentStatus.UNPAID
            }
            val updatedBill = bill.copy(
                paidAmount = newPaidAmount,
                status = newStatus
            )
            // Update local first
            waterBillDao.updateWaterBill(updatedBill)
            
            // Then sync to Firebase
            CoroutineScope(Dispatchers.IO).launch {
                try {
                    remoteDataSource.updateWaterBill(updatedBill)
                } catch (e: Exception) {
                    // Error logged but not thrown
                }
            }
            
            Result.success(updatedBill)
        } else {
            Result.failure(Exception("Water bill not found"))
        }
    }
    
    suspend fun deleteWaterBill(waterBillId: String): Result<Unit> {
        val bill = waterBillDao.getWaterBillById(waterBillId)
        return if (bill != null) {
            try {
                // Delete from Firebase first (to ensure consistency)
                val deleteResult = remoteDataSource.deleteWaterBill(waterBillId)
                if (deleteResult.isFailure) {
                    android.util.Log.w("WaterMeterRepository", "Failed to delete water bill from Firebase: ${deleteResult.exceptionOrNull()?.message}")
                    // Continue with local deletion even if Firebase fails (offline-first)
                }
                
                // Delete from local database
                waterBillDao.deleteWaterBill(bill)
                
                Result.success(Unit)
            } catch (e: Exception) {
                android.util.Log.e("WaterMeterRepository", "Error deleting water bill: ${e.message}", e)
                Result.failure(e)
            }
        } else {
            Result.failure(Exception("Water bill not found"))
        }
    }
}
