package com.balancetech.sitemanagement.data.dao

import androidx.room.*
import com.balancetech.sitemanagement.data.entity.User
import com.balancetech.sitemanagement.data.model.UserRole
import kotlinx.coroutines.flow.Flow

@Dao
interface UserDao {
    @Query("SELECT * FROM users WHERE id = :id")
    suspend fun getUserById(id: String): User?

    @Query("SELECT * FROM users WHERE email = :email")
    suspend fun getUserByEmail(email: String): User?

    @Query("SELECT * FROM users WHERE role = :role")
    fun getUsersByRole(role: UserRole): Flow<List<User>>

    @Query("SELECT * FROM users WHERE unitId = :unitId")
    fun getUsersByUnit(unitId: String): Flow<List<User>>

    @Query("SELECT * FROM users WHERE isActive = 1")
    fun getAllActiveUsers(): Flow<List<User>>

    // Note: Current user is managed by AuthRepository via StateFlow
    // This method is kept for compatibility but returns null
    suspend fun getCurrentUser(): User? = null

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertUser(user: User)

    @Update
    suspend fun updateUser(user: User)

    @Delete
    suspend fun deleteUser(user: User)
}
