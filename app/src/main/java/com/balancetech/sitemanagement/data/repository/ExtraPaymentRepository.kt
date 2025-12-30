package com.balancetech.sitemanagement.data.repository

import com.balancetech.sitemanagement.data.dao.ExtraPaymentDao
import com.balancetech.sitemanagement.data.entity.ExtraPayment
import com.balancetech.sitemanagement.data.model.ExtraPaymentType
import com.balancetech.sitemanagement.data.model.PaymentStatus
import kotlinx.coroutines.flow.Flow
import java.util.UUID

class ExtraPaymentRepository(private val extraPaymentDao: ExtraPaymentDao) {
    fun getExtraPaymentsByUnit(unitId: String): Flow<List<ExtraPayment>> =
        extraPaymentDao.getExtraPaymentsByUnit(unitId)

    fun getBuildingWideExtraPayments(apartmentId: String): Flow<List<ExtraPayment>> =
        extraPaymentDao.getBuildingWideExtraPayments(apartmentId)

    
    fun getAllExtraPayments(apartmentId: String): Flow<List<ExtraPayment>> =
        extraPaymentDao.getAllExtraPayments(apartmentId)

    suspend fun createExtraPayment(
        apartmentId: String,
        unitId: String?,
        title: String,
        description: String?,
        amount: Double,
        type: ExtraPaymentType,
        installmentCount: Int,
        dueDate: Long
    ): Result<ExtraPayment> {
        val extraPayment = ExtraPayment(
            id = UUID.randomUUID().toString(),
            apartmentId = apartmentId,
            unitId = unitId,
            title = title,
            description = description,
            amount = amount,
            type = type,
            installmentCount = installmentCount,
            currentInstallment = 1,
            dueDate = dueDate
        )
        extraPaymentDao.insertExtraPayment(extraPayment)
        return Result.success(extraPayment)
    }

    suspend fun updateExtraPayment(extraPayment: ExtraPayment) {
        extraPaymentDao.updateExtraPayment(extraPayment)
    }

    suspend fun recordPayment(extraPaymentId: String, paymentAmount: Double): Result<ExtraPayment> {
        val extraPayment = extraPaymentDao.getExtraPaymentById(extraPaymentId)
        return if (extraPayment != null) {
            val newPaidAmount = extraPayment.paidAmount + paymentAmount
            val newStatus = when {
                newPaidAmount >= extraPayment.amount -> PaymentStatus.PAID
                newPaidAmount > 0 -> PaymentStatus.PARTIALLY_PAID
                else -> PaymentStatus.UNPAID
            }
            val updatedExtraPayment = extraPayment.copy(
                paidAmount = newPaidAmount,
                status = newStatus,
                updatedAt = System.currentTimeMillis()
            )
            extraPaymentDao.updateExtraPayment(updatedExtraPayment)
            Result.success(updatedExtraPayment)
        } else {
            Result.failure(Exception("Extra payment not found"))
        }
    }
}
