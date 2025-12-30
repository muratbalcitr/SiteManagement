package com.balancetech.sitemanagement.data.dao

import androidx.room.*
import com.balancetech.sitemanagement.data.entity.WaterBill
import kotlinx.coroutines.flow.Flow

@Dao
interface WaterBillDao {
    @Query("SELECT * FROM water_bills WHERE id = :id")
    suspend fun getWaterBillById(id: String): WaterBill?

    @Query("SELECT * FROM water_bills WHERE unitId = :unitId ORDER BY year DESC, month DESC")
    fun getWaterBillsByUnit(unitId: String): Flow<List<WaterBill>>

    @Query("SELECT * FROM water_bills WHERE month = :month AND year = :year")
    fun getWaterBillsByMonth(month: Int, year: Int): Flow<List<WaterBill>>
    
    @Query("SELECT * FROM water_bills ORDER BY year DESC, month DESC")
    fun getAllWaterBills(): Flow<List<WaterBill>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertWaterBill(waterBill: WaterBill)

    @Update
    suspend fun updateWaterBill(waterBill: WaterBill)

    @Delete
    suspend fun deleteWaterBill(waterBill: WaterBill)
}
