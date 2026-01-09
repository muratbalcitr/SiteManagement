package com.balancetech.sitemanagement.data.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "water_meters")
data class WaterMeter(
    @PrimaryKey
    val id: String,
    val unitId: String,
    val meterNumber: String, // Sayaç numarası
    val previousReading: Double = 0.0, // Önceki okuma
    val currentReading: Double = 0.0, // Güncel okuma
    val unitPrice: Double = 0.0, // m³ birim fiyat
    val lastReadingDate: Long = System.currentTimeMillis(),
    val createdAt: Long = System.currentTimeMillis(),
    val unitOwner: String? = null, // Daire Adı

)
