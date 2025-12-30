package com.balancetech.sitemanagement.data.dao

import androidx.room.*
import com.balancetech.sitemanagement.data.entity.Block
import kotlinx.coroutines.flow.Flow

@Dao
interface BlockDao {
    @Query("SELECT * FROM blocks WHERE id = :id")
    suspend fun getBlockById(id: String): Block?

    @Query("SELECT * FROM blocks WHERE apartmentId = :apartmentId")
    fun getBlocksByApartment(apartmentId: String): Flow<List<Block>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertBlock(block: Block)

    @Update
    suspend fun updateBlock(block: Block)

    @Delete
    suspend fun deleteBlock(block: Block)
}
