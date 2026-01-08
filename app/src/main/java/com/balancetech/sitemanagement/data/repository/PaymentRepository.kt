package com.balancetech.sitemanagement.data.repository

import com.balancetech.sitemanagement.data.dao.PaymentDao
import com.balancetech.sitemanagement.data.datasource.LocalDataSource
import com.balancetech.sitemanagement.data.entity.Payment
import com.balancetech.sitemanagement.data.service.FirebaseFunctionsService
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.flow.Flow

class PaymentRepository(
    private val paymentDao: PaymentDao,
    private val functionsService: FirebaseFunctionsService,
    private val localDataSource: LocalDataSource
) {
    fun getPaymentsByUnit(unitId: String): Flow<List<Payment>> =
        paymentDao.getPaymentsByUnit(unitId)

    fun getPaymentsByFee(feeId: String): Flow<List<Payment>> =
        paymentDao.getPaymentsByFee(feeId)

    fun getPaymentsByExtraPayment(extraPaymentId: String): Flow<List<Payment>> =
        paymentDao.getPaymentsByExtraPayment(extraPaymentId)

    fun getPaymentsByWaterBill(waterBillId: String): Flow<List<Payment>> =
        paymentDao.getPaymentsByWaterBill(waterBillId)

    fun getAllPayments(): Flow<List<Payment>> = paymentDao.getAllPayments()

    suspend fun recordPayment(
        unitId: String,
        amount: Double,
        paymentMethod: String,
        description: String?,
        createdBy: String,
        feeId: String? = null,
        extraPaymentId: String? = null,
        waterBillId: String? = null
    ): Result<Payment> {
        // Get unit information to create documentId based on unit number
        val unit = localDataSource.getUnitById(unitId)
        val unitNumber = unit?.unitNumber ?: unitId // Fallback to unitId if unit not found
        
        // Create documentId: unitNumber_timestamp (e.g., "A1_1705321234567")
        val timestamp = System.currentTimeMillis()
        val paymentId = "${unitNumber}_$timestamp"
        
        val payment = Payment(
            id = paymentId,
            unitId = unitId,
            feeId = feeId,
            extraPaymentId = extraPaymentId,
            waterBillId = waterBillId,
            amount = amount,
            paymentMethod = paymentMethod,
            description = description,
            createdBy = createdBy
        )
        // Save to local first (offline-first)
        paymentDao.insertPayment(payment)
        
        // Then sync to Firebase via Functions
        CoroutineScope(Dispatchers.IO).launch {
            try {
                functionsService.recordPayment(
                    unitId = unitId,
                    amount = amount,
                    paymentMethod = paymentMethod,
                    description = description,
                    feeId = feeId,
                    extraPaymentId = extraPaymentId,
                    waterBillId = waterBillId,
                    paymentId = paymentId // Pass paymentId to Firebase
                )
            } catch (e: Exception) {
                // Error logged but not thrown - offline-first strategy
            }
        }
        
        return Result.success(payment)
    }
}
