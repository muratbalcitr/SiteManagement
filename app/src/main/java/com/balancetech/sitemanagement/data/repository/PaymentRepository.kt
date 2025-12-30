package com.balancetech.sitemanagement.data.repository

import com.balancetech.sitemanagement.data.dao.PaymentDao
import com.balancetech.sitemanagement.data.entity.Payment
import com.balancetech.sitemanagement.data.service.FirebaseFunctionsService
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.flow.Flow
import java.util.UUID

class PaymentRepository(
    private val paymentDao: PaymentDao,
    private val functionsService: FirebaseFunctionsService
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
        val payment = Payment(
            id = UUID.randomUUID().toString(),
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
                    waterBillId = waterBillId
                )
            } catch (e: Exception) {
                // Error logged but not thrown - offline-first strategy
            }
        }
        
        return Result.success(payment)
    }
}
