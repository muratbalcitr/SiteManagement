package com.balancetech.sitemanagement.data.repository

import com.balancetech.sitemanagement.data.datasource.LocalDataSource
import com.balancetech.sitemanagement.data.datasource.RemoteDataSource
import com.balancetech.sitemanagement.data.entity.User
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
    private val remoteDataSource: RemoteDataSource
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
     * Create a new user (resident)
     * If unitId is provided, uses unit name (block + unit number) as document ID
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
        // Check if user already exists
        val existingUser = localDataSource.getUserByEmail(email)
        if (existingUser != null) {
            return Result.failure(Exception("Bu e-posta adresi zaten kullanılıyor"))
        }

        // Generate user ID
        val userId = if (unitId != null) {
            // If unitId is provided, get unit info and use unitNumber as document ID
            // Unit number format is already "A1", "B5", etc. from DatabaseSeedUtil
            val unit = localDataSource.getUnitById(unitId)
            if (unit != null) {
                // Use unitNumber directly as document ID (e.g., "A1", "B5")
                // Make it lowercase for consistency
                unit.unitNumber.lowercase()
            } else {
                // Fallback to name-based slug if unit not found
                val allUsers = localDataSource.getAllActiveUsers().first()
                val existingIds = allUsers.map { it.id }.toSet()
                StringUtils.generateUserIdFromName(name, existingIds)
            }
        } else {
            // If no unitId, use name-based slug
            val allUsers = localDataSource.getAllActiveUsers().first()
            val existingIds = allUsers.map { it.id }.toSet()
            StringUtils.generateUserIdFromName(name, existingIds)
        }

        val user = User(
            id = userId,
            email = email,
            password = password, // In production, hash this
            name = name,
            phone = phone,
            role = role,
            apartmentId = apartmentId,
            unitId = unitId,
            isActive = true
        )

        // Save to local first (offline-first)
        localDataSource.insertUser(user)

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
     * Update user
     */
    suspend fun updateUser(user: User): Result<User> {
        // Update local first
        localDataSource.updateUser(user)

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

