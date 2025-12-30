package com.balancetech.sitemanagement.data.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.balancetech.sitemanagement.data.model.PaymentStatus

@Entity(tableName = "water_bills")
data class WaterBill(
    @PrimaryKey
    val id: String,
    val unitId: String,
    val waterMeterId: String,
    val month: Int,
    val year: Int,
    val previousReading: Double,
    val currentReading: Double,
    val consumption: Double, // Tüketim (m³)
    val unitPrice: Double,
    val amount: Double, // Toplam tutar
    val sharedAmount: Double = 0.0, // Ortak kullanım payı
    val totalAmount: Double, // amount + sharedAmount
    val paidAmount: Double = 0.0,
    val status: PaymentStatus = PaymentStatus.UNPAID,
    val dueDate: Long,
    val createdAt: Long = System.currentTimeMillis()
)
