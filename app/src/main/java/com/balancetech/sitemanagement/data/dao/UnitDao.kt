package com.balancetech.sitemanagement.data.dao

import androidx.room.*
import com.balancetech.sitemanagement.data.entity.Unit as UnitEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface UnitDao {
    @Query("SELECT * FROM units WHERE id = :id")
    suspend fun getUnitById(id: String): UnitEntity?

    @Query("SELECT * FROM units WHERE apartmentId = :apartmentId AND isActive = 1")
    fun getUnitsByApartment(apartmentId: String): Flow<List<UnitEntity>>

    @Query("SELECT * FROM units WHERE blockId = :blockId AND isActive = 1")
    fun getUnitsByBlock(blockId: String): Flow<List<UnitEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertUnit(unit: UnitEntity)

    @Update
    suspend fun updateUnit(unit: UnitEntity)

    @Delete
    suspend fun deleteUnit(unit: UnitEntity)
}
