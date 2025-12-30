package com.balancetech.sitemanagement.data.dao

import androidx.room.*
import com.balancetech.sitemanagement.data.entity.ExtraPayment
import kotlinx.coroutines.flow.Flow

@Dao
interface ExtraPaymentDao {
    @Query("SELECT * FROM extra_payments WHERE id = :id")
    suspend fun getExtraPaymentById(id: String): ExtraPayment?

    @Query("SELECT * FROM extra_payments WHERE unitId = :unitId ORDER BY createdAt DESC")
    fun getExtraPaymentsByUnit(unitId: String): Flow<List<ExtraPayment>>

    @Query("SELECT * FROM extra_payments WHERE apartmentId = :apartmentId AND unitId IS NULL ORDER BY createdAt DESC")
    fun getBuildingWideExtraPayments(apartmentId: String): Flow<List<ExtraPayment>>
    
    @Query("SELECT * FROM extra_payments WHERE apartmentId = :apartmentId ORDER BY createdAt DESC")
    fun getAllExtraPayments(apartmentId: String): Flow<List<ExtraPayment>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertExtraPayment(extraPayment: ExtraPayment)

    @Update
    suspend fun updateExtraPayment(extraPayment: ExtraPayment)

    @Delete
    suspend fun deleteExtraPayment(extraPayment: ExtraPayment)
}
