package com.balancetech.sitemanagement.data.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "payments")
data class Payment(
    @PrimaryKey
    val id: String,
    val unitId: String,
    val feeId: String?, // Aidat ödemesi için
    val extraPaymentId: String?, // Ek ödeme için
    val waterBillId: String?, // Su faturası için
    val amount: Double,
    val paymentDate: Long = System.currentTimeMillis(),
    val paymentMethod: String, // "cash", "bank_transfer", "online", etc.
    val description: String?,
    val createdBy: String, // User ID
    val createdAt: Long = System.currentTimeMillis()
)
