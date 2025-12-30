package com.balancetech.sitemanagement.data.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.balancetech.sitemanagement.data.model.UserRole
import java.io.Serializable

@Entity(tableName = "users")
data class User(
    @PrimaryKey
    val id: String,
    val email: String,
    val password: String, // In production, this should be hashed
    val name: String,
    val phone: String?,
    val role: UserRole,
    val apartmentId: String? = null, // For residents, link to their apartment
    val unitId: String? = null, // For residents, link to their unit
    val createdAt: Long = System.currentTimeMillis(),
    val isActive: Boolean = true
) : Serializable
