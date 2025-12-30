package com.balancetech.sitemanagement.data.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.balancetech.sitemanagement.data.model.ExtraPaymentType
import com.balancetech.sitemanagement.data.model.PaymentStatus

@Entity(tableName = "extra_payments")
data class ExtraPayment(
    @PrimaryKey
    val id: String,
    val apartmentId: String,
    val unitId: String?, // null ise tüm apartman için
    val title: String, // Örn: "Asansör bakım", "Tadilat"
    val description: String?,
    val amount: Double,
    val type: ExtraPaymentType,
    val installmentCount: Int = 1, // Taksit sayısı
    val currentInstallment: Int = 1, // Mevcut taksit
    val paidAmount: Double = 0.0,
    val status: PaymentStatus = PaymentStatus.UNPAID,
    val dueDate: Long,
    val createdAt: Long = System.currentTimeMillis(),
    val updatedAt: Long = System.currentTimeMillis()
)
