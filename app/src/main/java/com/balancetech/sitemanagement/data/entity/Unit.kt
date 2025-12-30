package com.balancetech.sitemanagement.data.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.balancetech.sitemanagement.data.model.OwnerType

@Entity(tableName = "units")
data class Unit(
    @PrimaryKey
    val id: String,
    val apartmentId: String,
    val blockId: String?,
    val unitNumber: String, // Daire numarası (örn: "1", "2A")
    val floor: Int,
    val area: Double, // m²
    val landShare: Double, // Arsa payı
    val ownerType: OwnerType,
    val ownerName: String?,
    val ownerPhone: String?,
    val createdAt: Long = System.currentTimeMillis(),
    val isActive: Boolean = true
)
