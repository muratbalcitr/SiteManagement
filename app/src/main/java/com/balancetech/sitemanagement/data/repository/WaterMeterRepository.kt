package com.balancetech.sitemanagement.data.repository

import com.balancetech.sitemanagement.data.dao.WaterMeterDao
import com.balancetech.sitemanagement.data.dao.WaterBillDao
import com.balancetech.sitemanagement.data.datasource.RemoteDataSource
import com.balancetech.sitemanagement.data.entity.WaterMeter
import com.balancetech.sitemanagement.data.entity.WaterBill
import com.balancetech.sitemanagement.data.model.PaymentStatus
import com.balancetech.sitemanagement.data.service.FirebaseFunctionsService
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
    private val remoteDataSource: RemoteDataSource
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
        val existing = waterMeterDao.getWaterMeterByUnit(unitId)
        val waterMeter = if (existing != null) {
            existing.copy(
                meterNumber = meterNumber,
                unitPrice = unitPrice
            )
        } else {
            WaterMeter(
                id = UUID.randomUUID().toString(),
                unitId = unitId,
                meterNumber = meterNumber,
                unitPrice = unitPrice
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

        val amount = consumption * waterMeter.unitPrice
        val totalAmount = amount // Can add shared amount later

        val waterBill = WaterBill(
            id = UUID.randomUUID().toString(),
            unitId = unitId,
            waterMeterId = waterMeter.id,
            month = month,
            year = year,
            previousReading = previousReading,
            currentReading = currentReading,
            consumption = consumption,
            unitPrice = waterMeter.unitPrice,
            amount = amount,
            totalAmount = totalAmount,
            dueDate = System.currentTimeMillis() + (30 * 24 * 60 * 60 * 1000L) // 30 days from now
        )

        // Update water meter with new reading
        val updatedMeter = waterMeter.copy(
            previousReading = waterMeter.currentReading,
            currentReading = currentReading,
            lastReadingDate = System.currentTimeMillis()
        )
        waterMeterDao.updateWaterMeter(updatedMeter)

        // Save to local first (offline-first)
        waterBillDao.insertWaterBill(waterBill)
        
        // Then sync to Firebase via Functions
        CoroutineScope(Dispatchers.IO).launch {
            try {
                functionsService.recordWaterMeterReading(unitId, currentReading)
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
}
