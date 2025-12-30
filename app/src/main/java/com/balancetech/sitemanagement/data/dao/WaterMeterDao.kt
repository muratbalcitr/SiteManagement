package com.balancetech.sitemanagement.data.dao

import androidx.room.*
import com.balancetech.sitemanagement.data.entity.WaterMeter
import kotlinx.coroutines.flow.Flow

@Dao
interface WaterMeterDao {
    @Query("SELECT * FROM water_meters WHERE id = :id")
    suspend fun getWaterMeterById(id: String): WaterMeter?

    @Query("SELECT * FROM water_meters WHERE unitId = :unitId")
    suspend fun getWaterMeterByUnit(unitId: String): WaterMeter?

    @Query("SELECT * FROM water_meters")
    fun getAllWaterMeters(): Flow<List<WaterMeter>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertWaterMeter(waterMeter: WaterMeter)

    @Update
    suspend fun updateWaterMeter(waterMeter: WaterMeter)

    @Delete
    suspend fun deleteWaterMeter(waterMeter: WaterMeter)
}
