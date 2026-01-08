package com.balancetech.sitemanagement.data.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.balancetech.sitemanagement.data.model.PaymentStatus
import java.io.Serializable

@Entity(tableName = "fees")
data class Fee(
    @PrimaryKey
    val id: String,
    val apartmentId: String,
    val unitId: String,
    val month: Int, // 1-12
    val year: Int,
    val amount: Double, // Aidat tutarı
    val paidAmount: Double = 0.0,
    val status: PaymentStatus = PaymentStatus.UNPAID,
    val dueDate: Long, // Son ödeme tarihi
    val createdAt: Long = System.currentTimeMillis(),
    val updatedAt: Long = System.currentTimeMillis()
): Serializable
