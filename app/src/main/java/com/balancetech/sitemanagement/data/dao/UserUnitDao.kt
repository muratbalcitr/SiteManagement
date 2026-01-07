package com.balancetech.sitemanagement.data.dao

import androidx.room.*
import com.balancetech.sitemanagement.data.entity.UserUnit
import kotlinx.coroutines.flow.Flow

@Dao
interface UserUnitDao {
    @Query("SELECT * FROM user_units WHERE userId = :userId")
    fun getUserUnitsByUserId(userId: String): Flow<List<UserUnit>>
    
    @Query("SELECT * FROM user_units WHERE unitId = :unitId")
    fun getUserUnitsByUnitId(unitId: String): Flow<List<UserUnit>>
    
    @Query("SELECT unitId FROM user_units WHERE userId = :userId")
    suspend fun getUnitIdsByUserId(userId: String): List<String>
    
    @Query("SELECT userId FROM user_units WHERE unitId = :unitId")
    suspend fun getUserIdsByUnitId(unitId: String): List<String>
    
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertUserUnit(userUnit: UserUnit)
    
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertUserUnits(userUnits: List<UserUnit>)
    
    @Delete
    suspend fun deleteUserUnit(userUnit: UserUnit)
    
    @Query("DELETE FROM user_units WHERE userId = :userId AND unitId = :unitId")
    suspend fun deleteUserUnit(userId: String, unitId: String)
    
    @Query("DELETE FROM user_units WHERE userId = :userId")
    suspend fun deleteAllUserUnits(userId: String)
}

