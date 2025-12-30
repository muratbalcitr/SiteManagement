package com.balancetech.sitemanagement.data.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "apartments")
data class Apartment(
    @PrimaryKey
    val id: String,
    val name: String,
    val address: String,
    val blockCount: Int = 1,
    val totalUnits: Int = 0,
    val createdAt: Long = System.currentTimeMillis(),
    val isActive: Boolean = true
)
