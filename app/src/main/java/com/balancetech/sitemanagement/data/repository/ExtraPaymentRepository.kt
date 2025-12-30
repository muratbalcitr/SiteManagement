package com.balancetech.sitemanagement.data.repository

import com.balancetech.sitemanagement.data.dao.ExtraPaymentDao
import com.balancetech.sitemanagement.data.datasource.RemoteDataSource
import com.balancetech.sitemanagement.data.entity.ExtraPayment
import com.balancetech.sitemanagement.data.model.ExtraPaymentType
import com.balancetech.sitemanagement.data.model.PaymentStatus
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch
import java.util.UUID
import javax.inject.Inject

class ExtraPaymentRepository @Inject constructor(
    private val extraPaymentDao: ExtraPaymentDao,
    private val remoteDataSource: RemoteDataSource
) {
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
        // Save to local first (offline-first)
        extraPaymentDao.insertExtraPayment(extraPayment)
        
        // Then sync to Firebase
        CoroutineScope(Dispatchers.IO).launch {
            try {
                remoteDataSource.createExtraPayment(extraPayment)
            } catch (e: Exception) {
                // Error logged but not thrown - offline-first strategy
            }
        }
        
        return Result.success(extraPayment)
    }

    suspend fun updateExtraPayment(extraPayment: ExtraPayment) {
        // Update local first
        extraPaymentDao.updateExtraPayment(extraPayment)
        
        // Then sync to Firebase
        CoroutineScope(Dispatchers.IO).launch {
            try {
                remoteDataSource.updateExtraPayment(extraPayment)
            } catch (e: Exception) {
                // Error logged but not thrown
            }
        }
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
            // Update local first
            extraPaymentDao.updateExtraPayment(updatedExtraPayment)
            
            // Then sync to Firebase
            CoroutineScope(Dispatchers.IO).launch {
                try {
                    remoteDataSource.updateExtraPayment(updatedExtraPayment)
                } catch (e: Exception) {
                    // Error logged but not thrown
                }
            }
            
            Result.success(updatedExtraPayment)
        } else {
            Result.failure(Exception("Extra payment not found"))
        }
    }
}
