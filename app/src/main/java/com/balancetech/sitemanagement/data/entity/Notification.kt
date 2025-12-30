package com.balancetech.sitemanagement.data.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "notifications")
data class Notification(
    @PrimaryKey
    val id: String,
    val userId: String,
    val title: String,
    val message: String,
    val type: String, // "fee_created", "payment_reminder", "late_payment", "water_bill"
    val isRead: Boolean = false,
    val createdAt: Long = System.currentTimeMillis()
)
