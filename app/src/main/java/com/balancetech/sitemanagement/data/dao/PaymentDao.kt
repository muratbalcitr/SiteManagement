package com.balancetech.sitemanagement.data.dao

import androidx.room.*
import com.balancetech.sitemanagement.data.entity.Payment
import kotlinx.coroutines.flow.Flow

@Dao
interface PaymentDao {
    @Query("SELECT * FROM payments WHERE id = :id")
    suspend fun getPaymentById(id: String): Payment?

    @Query("SELECT * FROM payments WHERE unitId = :unitId ORDER BY paymentDate DESC")
    fun getPaymentsByUnit(unitId: String): Flow<List<Payment>>

    @Query("SELECT * FROM payments WHERE feeId = :feeId")
    fun getPaymentsByFee(feeId: String): Flow<List<Payment>>

    @Query("SELECT * FROM payments WHERE extraPaymentId = :extraPaymentId")
    fun getPaymentsByExtraPayment(extraPaymentId: String): Flow<List<Payment>>

    @Query("SELECT * FROM payments WHERE waterBillId = :waterBillId")
    fun getPaymentsByWaterBill(waterBillId: String): Flow<List<Payment>>

    @Query("SELECT * FROM payments ORDER BY paymentDate DESC")
    fun getAllPayments(): Flow<List<Payment>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertPayment(payment: Payment)

    @Update
    suspend fun updatePayment(payment: Payment)

    @Delete
    suspend fun deletePayment(payment: Payment)
}
