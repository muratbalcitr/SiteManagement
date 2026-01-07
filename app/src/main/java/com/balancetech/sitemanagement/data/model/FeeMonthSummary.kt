package com.balancetech.sitemanagement.data.model

import com.balancetech.sitemanagement.data.entity.Fee

/**
 * Represents a summary of fees for a specific month
 */
data class FeeMonthSummary(
    val month: Int,
    val year: Int,
    val fees: List<Fee>
) {
    val totalAmount: Double
        get() = fees.sumOf { it.amount }
    
    val totalPaidAmount: Double
        get() = fees.sumOf { it.paidAmount }
    
    val totalRemainingAmount: Double
        get() = totalAmount - totalPaidAmount
    
    val monthName: String
        get() = when (month) {
            1 -> "Ocak"
            2 -> "Şubat"
            3 -> "Mart"
            4 -> "Nisan"
            5 -> "Mayıs"
            6 -> "Haziran"
            7 -> "Temmuz"
            8 -> "Ağustos"
            9 -> "Eylül"
            10 -> "Ekim"
            11 -> "Kasım"
            12 -> "Aralık"
            else -> month.toString()
        }
}

