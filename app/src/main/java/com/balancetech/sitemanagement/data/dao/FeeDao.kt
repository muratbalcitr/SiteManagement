package com.balancetech.sitemanagement.data.dao

import androidx.room.*
import com.balancetech.sitemanagement.data.entity.Fee
import com.balancetech.sitemanagement.data.model.PaymentStatus
import kotlinx.coroutines.flow.Flow

@Dao
interface FeeDao {
    @Query("SELECT * FROM fees WHERE id = :id")
    suspend fun getFeeById(id: String): Fee?

    @Query("SELECT * FROM fees WHERE unitId = :unitId ORDER BY year DESC, month DESC")
    fun getFeesByUnit(unitId: String): Flow<List<Fee>>

    @Query("SELECT * FROM fees WHERE apartmentId = :apartmentId AND month = :month AND year = :year")
    fun getFeesByMonth(apartmentId: String, month: Int, year: Int): Flow<List<Fee>>

    @Query("SELECT * FROM fees WHERE unitId = :unitId AND status = :status")
    fun getFeesByUnitAndStatus(unitId: String, status: PaymentStatus): Flow<List<Fee>>

    @Query("SELECT * FROM fees WHERE unitId = :unitId AND month = :month AND year = :year")
    suspend fun getFeeByUnitMonthYear(unitId: String, month: Int, year: Int): Fee?

    @Query("SELECT * FROM fees WHERE apartmentId = :apartmentId AND status = :status")
    fun getFeesByApartmentAndStatus(apartmentId: String, status: PaymentStatus): Flow<List<Fee>>

    @Query("SELECT * FROM fees ORDER BY year DESC, month DESC")
    fun getAllFees(): Flow<List<Fee>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertFee(fee: Fee)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertFees(fees: List<Fee>)

    @Update
    suspend fun updateFee(fee: Fee)

    @Delete
    suspend fun deleteFee(fee: Fee)
}
