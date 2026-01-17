package com.balancetech.sitemanagement.data.entity

import java.io.Serializable

/**
 * Banka hareketi entity'si
 * Excel/CSV dosyasından okunan banka hareketlerini temsil eder
 */
data class BankTransaction(
    val date: String, // Tarih (format: DD.MM.YYYY)
    val receiptNo: String, // Fiş No
    val description: String, // Açıklama
    val amount: Double, // İşlem Tutarı (pozitif: gelir, negatif: gider)
    val balance: Double, // Bakiye
    val createdAt: Long = System.currentTimeMillis()
) : Serializable {
    val id: String
        get() = "${date}_${receiptNo}_${createdAt}" // Unique ID
    
    val isIncome: Boolean
        get() = amount > 0
    
    val isExpense: Boolean
        get() = amount < 0
}
