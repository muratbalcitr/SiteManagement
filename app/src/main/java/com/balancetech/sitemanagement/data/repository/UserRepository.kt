package com.balancetech.sitemanagement.data.repository

import com.balancetech.sitemanagement.data.dao.UserUnitDao
import com.balancetech.sitemanagement.data.datasource.LocalDataSource
import com.balancetech.sitemanagement.data.datasource.RemoteDataSource
import com.balancetech.sitemanagement.data.entity.User
import com.balancetech.sitemanagement.data.entity.UserUnit
import com.balancetech.sitemanagement.data.model.UserRole
import com.balancetech.sitemanagement.util.StringUtils
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch
import java.util.UUID
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class UserRepository @Inject constructor(
    private val localDataSource: LocalDataSource,
    private val remoteDataSource: RemoteDataSource,
    private val userUnitDao: UserUnitDao
) {
    /**
     * Get all active users (residents)
     */
    fun getAllActiveUsers(): Flow<List<User>> = localDataSource.getAllActiveUsers()

    /**
     * Get users by role
     */
    fun getUsersByRole(role: UserRole): Flow<List<User>> = localDataSource.getUsersByRole(role)

    /**
     * Get users by unit
     */
    fun getUsersByUnit(unitId: String): Flow<List<User>> = localDataSource.getUsersByUnit(unitId)

    /**
     * Get units for a user
     */
    suspend fun getUserUnits(userId: String): List<String> {
        return userUnitDao.getUnitIdsByUserId(userId)
    }

    /**
     * Create a new user (resident)
     * If unitIds is provided, creates user-unit relationships
     */
    suspend fun createUser(
        email: String,
        password: String,
        name: String,
        phone: String?,
        role: UserRole,
        apartmentId: String?,
        unitIds: List<String>
    ): Result<User> {
        // Check if user already exists
        val existingUser = localDataSource.getUserByEmail(email)
        if (existingUser != null) {
            // If user exists, add new units to existing user
            val existingUnitIds = userUnitDao.getUnitIdsByUserId(existingUser.id).toSet()
            val newUnitIds = unitIds.filter { it !in existingUnitIds }
            
            if (newUnitIds.isNotEmpty()) {
                // Verify that all units exist before creating UserUnit relationships
                val validUserUnits = newUnitIds.mapNotNull { unitId ->
                    val unitExists = localDataSource.getUnitById(unitId) != null
                    if (unitExists) {
                        UserUnit(userId = existingUser.id, unitId = unitId)
                    } else {
                        android.util.Log.w("UserRepository", "Unit $unitId not found, skipping UserUnit relationship")
                        null
                    }
                }
                if (validUserUnits.isNotEmpty()) {
                    userUnitDao.insertUserUnits(validUserUnits)
                }
            }
            
            return Result.success(existingUser)
        }

        // Generate user ID based on name
        val allUsers = localDataSource.getAllActiveUsers().first()
        val existingIds = allUsers.map { it.id }.toSet()
        val userId = StringUtils.generateUserIdFromName(name, existingIds)

        val user = User(
            id = userId,
            email = email,
            password = password, // In production, hash this
            name = name,
            phone = phone,
            role = role,
            apartmentId = apartmentId,
            unitId = unitIds.firstOrNull(), // Keep for backward compatibility
            isActive = true
        )

        // Save to local first (offline-first)
        localDataSource.insertUser(user)

        // Create user-unit relationships
        // Verify that all units exist before creating UserUnit relationships
        if (unitIds.isNotEmpty()) {
            val validUserUnits = unitIds.mapNotNull { unitId ->
                val unitExists = localDataSource.getUnitById(unitId) != null
                if (unitExists) {
                    UserUnit(userId = userId, unitId = unitId)
                } else {
                    android.util.Log.w("UserRepository", "Unit $unitId not found, skipping UserUnit relationship")
                    null
                }
            }
            if (validUserUnits.isNotEmpty()) {
                userUnitDao.insertUserUnits(validUserUnits)
            }
        }

        // Then sync to Firebase
        CoroutineScope(Dispatchers.IO).launch {
            try {
                remoteDataSource.createUser(user)
            } catch (e: Exception) {
                // Error logged but not thrown - offline-first strategy
            }
        }

        return Result.success(user)
    }
    
    /**
     * Create user with single unit (backward compatibility)
     */
    suspend fun createUser(
        email: String,
        password: String,
        name: String,
        phone: String?,
        role: UserRole,
        apartmentId: String?,
        unitId: String?
    ): Result<User> {
        return createUser(
            email = email,
            password = password,
            name = name,
            phone = phone,
            role = role,
            apartmentId = apartmentId,
            unitIds = if (unitId != null) listOf(unitId) else emptyList()
        )
    }

    /**
     * Update user and their units
     */
    suspend fun updateUser(user: User, unitIds: List<String>? = null): Result<User> {
        // Update local first
        localDataSource.updateUser(user)

        // Update user-unit relationships if provided
        // Verify that all units exist before creating UserUnit relationships
        if (unitIds != null) {
            // Delete existing relationships
            userUnitDao.deleteAllUserUnits(user.id)
            // Create new relationships
            if (unitIds.isNotEmpty()) {
                val validUserUnits = unitIds.mapNotNull { unitId ->
                    val unitExists = localDataSource.getUnitById(unitId) != null
                    if (unitExists) {
                        UserUnit(userId = user.id, unitId = unitId)
                    } else {
                        android.util.Log.w("UserRepository", "Unit $unitId not found, skipping UserUnit relationship")
                        null
                    }
                }
                if (validUserUnits.isNotEmpty()) {
                    userUnitDao.insertUserUnits(validUserUnits)
                }
            }
        }

        // Then sync to remote
        CoroutineScope(Dispatchers.IO).launch {
            try {
                remoteDataSource.updateUser(user)
            } catch (e: Exception) {
                // Error logged but not thrown
            }
        }

        return Result.success(user)
    }

    /**
     * Delete user (soft delete - set isActive to false)
     */
    suspend fun deleteUser(user: User): Result<kotlin.Unit> {
        val updatedUser = user.copy(isActive = false)
        val result = updateUser(updatedUser)
        return if (result.isSuccess) {
            Result.success(kotlin.Unit)
        } else {
            Result.failure(result.exceptionOrNull() ?: Exception("Silme hatası"))
        }
    }
}

