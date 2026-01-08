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
        // Get unit and block information to create documentId
        val unit = localDataSource.getUnitById(unitId)
        val unitNumber = unit?.unitNumber ?: unitId // Fallback to unitId if unit not found
        val blockId = unit?.blockId
        
        // Create documentId: unit-block-{blockId}-{unitNumber} (e.g., "unit-block-b-8-B23")
        val paymentId = if (blockId != null) {
            "unit-block-$blockId-$unitNumber"
        } else {
            // Fallback if blockId is null
            "unit-block-unknown-$unitNumber"
        }
        
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
