package com.balancetech.sitemanagement.data.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "blocks")
data class Block(
    @PrimaryKey
    val id: String,
    val apartmentId: String,
    val name: String,
    val floorCount: Int = 0,
    val createdAt: Long = System.currentTimeMillis()
)
