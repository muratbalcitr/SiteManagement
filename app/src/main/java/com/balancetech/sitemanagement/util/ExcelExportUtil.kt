package com.balancetech.sitemanagement.util

import android.content.Context
import android.net.Uri
import android.os.Build
import androidx.core.content.FileProvider
import com.balancetech.sitemanagement.data.entity.Fee
import com.balancetech.sitemanagement.data.entity.User
import com.balancetech.sitemanagement.data.entity.Unit as UnitEntity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.io.File
import java.io.FileWriter
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

/**
 * Utility class for exporting data to Excel (CSV format)
 * CSV files can be opened in Excel
 */
object ExcelExportUtil {
    
    private const val FILE_PROVIDER_AUTHORITY = "com.balancetech.sitemanagement.fileprovider"
    
    /**
     * Export users list to Excel (CSV format)
     */
    suspend fun exportUsersToExcel(
        context: Context,
        users: List<User>,
        units: Map<String, UnitEntity> = emptyMap()
    ): Result<Uri> = withContext(Dispatchers.IO) {
        try {
            val fileName = "Daire_Sakinleri_${getCurrentTimestamp()}.csv"
            val file = createFile(context, fileName)
            
            FileWriter(file).use { writer ->
                // Write BOM for Excel UTF-8 support
                writer.write("\uFEFF")
                
                // Write header
                writer.appendLine("Ad Soyad,E-posta,Telefon,Rol,Daire ID,Daire Numarası,Blok,Olusturma Tarihi")
                
                // Write data
                users.forEach { user ->
                    val unit = user.unitId?.let { units[it] }
                    val unitNumber = unit?.unitNumber ?: "N/A"
                    val blockName = unit?.blockId ?: "N/A"
                    val createdAt = formatDate(user.createdAt)
                    
                    writer.appendLine(
                        "${escapeCsv(user.name)}," +
                        "${escapeCsv(user.email)}," +
                        "${escapeCsv(user.phone ?: "")}," +
                        "${escapeCsv(user.role.name)}," +
                        "${escapeCsv(user.unitId ?: "")}," +
                        "${escapeCsv(unitNumber)}," +
                        "${escapeCsv(blockName)}," +
                        "${escapeCsv(createdAt)}"
                    )
                }
            }
            
            val uri = getFileUri(context, file)
            Result.success(uri)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
    
    /**
     * Export units list to Excel (CSV format)
     * Format: Blok, Daire Numarası, Kat, Alan (m²), Arsa Payı, Sahip Tipi, Sahip Adı, Sahip Telefonu
     */
    suspend fun exportUnitsToExcel(
        context: Context,
        units: List<UnitEntity>
    ): Result<Uri> = withContext(Dispatchers.IO) {
        try {
            val fileName = "Daire_Listesi_${getCurrentTimestamp()}.csv"
            val file = createFile(context, fileName)
            
            FileWriter(file).use { writer ->
                // Write BOM for Excel UTF-8 support
                writer.write("\uFEFF")
                
                // Write header - matching import format
                writer.appendLine("Blok,Daire Numarası,Kat,Alan (m²),Arsa Payı,Sahip Tipi,Sahip Adı,Sahip Telefonu")
                
                // Write data
                units.forEach { unit ->
                    // Extract block name from blockId (e.g., "block-a" -> "A")
                    val blockName = when {
                        unit.blockId?.contains("block-a", ignoreCase = true) == true -> "A"
                        unit.blockId?.contains("block-b", ignoreCase = true) == true -> "B"
                        unit.blockId != null -> unit.blockId.replace("block-", "").uppercase()
                        else -> ""
                    }
                    
                    writer.appendLine(
                        "${escapeCsv(blockName)}," +
                        "${escapeCsv(unit.unitNumber)}," +
                        "${unit.floor}," +
                        "${unit.area}," +
                        "${unit.landShare}," +
                        "${escapeCsv(unit.ownerType.name)}," +
                        "${escapeCsv(unit.ownerName ?: "")}," +
                        "${escapeCsv(unit.ownerPhone ?: "")}"
                    )
                }
            }
            
            val uri = getFileUri(context, file)
            Result.success(uri)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
    
    /**
     * Export fees list to Excel (CSV format)
     */
    suspend fun exportFeesToExcel(
        context: Context,
        fees: List<Fee>,
        units: Map<String, UnitEntity> = emptyMap()
    ): Result<Uri> = withContext(Dispatchers.IO) {
        try {
            val fileName = "Aidat_Listesi_${getCurrentTimestamp()}.csv"
            val file = createFile(context, fileName)
            
            FileWriter(file).use { writer ->
                // Write BOM for Excel UTF-8 support
                writer.write("\uFEFF")
                
                // Write header
                writer.appendLine("Daire ID,Daire Numarası,Blok,Ay,Yıl,Tutar,Ödenen Tutar,Kalan Tutar,Durum,Son Ödeme Tarihi,Olusturma Tarihi")
                
                // Write data
                fees.forEach { fee ->
                    val unit = units[fee.unitId]
                    val unitNumber = unit?.unitNumber ?: "N/A"
                    val blockName = unit?.blockId ?: "N/A"
                    val remainingAmount = fee.amount - fee.paidAmount
                    val monthName = getMonthName(fee.month)
                    val dueDate = formatDate(fee.dueDate)
                    val createdAt = formatDate(fee.createdAt)
                    
                    writer.appendLine(
                        "${escapeCsv(fee.unitId)}," +
                        "${escapeCsv(unitNumber)}," +
                        "${escapeCsv(blockName)}," +
                        "${escapeCsv(monthName)}," +
                        "${fee.year}," +
                        "${fee.amount}," +
                        "${fee.paidAmount}," +
                        "${remainingAmount}," +
                        "${escapeCsv(fee.status.name)}," +
                        "${escapeCsv(dueDate)}," +
                        "${escapeCsv(createdAt)}"
                    )
                }
            }
            
            val uri = getFileUri(context, file)
            Result.success(uri)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
    
    private fun createFile(context: Context, fileName: String): File {
        val directory = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
            // Android 10+ uses MediaStore
            context.getExternalFilesDir(null) ?: context.filesDir
        } else {
            // Android 9 and below
            File(context.getExternalFilesDir(null), "exports").apply {
                if (!exists()) mkdirs()
            }
        }
        
        return File(directory, fileName)
    }
    
    private fun getFileUri(context: Context, file: File): Uri {
        return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            FileProvider.getUriForFile(context, FILE_PROVIDER_AUTHORITY, file)
        } else {
            Uri.fromFile(file)
        }
    }
    
    private fun escapeCsv(value: String): String {
        return if (value.contains(",") || value.contains("\"") || value.contains("\n")) {
            "\"${value.replace("\"", "\"\"")}\""
        } else {
            value
        }
    }
    
    private fun formatDate(timestamp: Long): String {
        val sdf = SimpleDateFormat("dd.MM.yyyy HH:mm", Locale("tr", "TR"))
        return sdf.format(Date(timestamp))
    }
    
    private fun getMonthName(month: Int): String {
        val months = arrayOf(
            "Ocak", "Şubat", "Mart", "Nisan", "Mayıs", "Haziran",
            "Temmuz", "Ağustos", "Eylül", "Ekim", "Kasım", "Aralık"
        )
        return if (month in 1..12) months[month - 1] else "Bilinmeyen"
    }
    
    private fun getCurrentTimestamp(): String {
        val sdf = SimpleDateFormat("yyyyMMdd_HHmmss", Locale.getDefault())
        return sdf.format(Date())
    }
    
    private fun FileWriter.appendLine(line: String) {
        append(line)
        append("\n")
    }
}

