package com.balancetech.sitemanagement.util

import android.content.Context
import android.net.Uri
import com.balancetech.sitemanagement.data.entity.Unit as UnitEntity
import com.balancetech.sitemanagement.data.model.OwnerType
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.io.BufferedReader
import java.io.InputStream
import java.io.InputStreamReader

/**
 * Utility class for importing data from Excel (CSV format)
 */
object ExcelImportUtil {
    
    data class ImportResult(
        val successCount: Int,
        val errorCount: Int,
        val errors: List<String>
    )
    
    /**
     * Import units from CSV file
     * Expected CSV format (matching export format):
     * Blok, Daire Numarası, Kat, Alan (m²), Arsa Payı, Sahip Tipi, Sahip Adı, Sahip Telefonu
     * 
     * Example:
     * A,1,1,100.0,0.0278,OWNER,Ahmet Yılmaz,5551234567
     * A,2,1,100.0,0.0278,TENANT,Mehmet Demir,5559876543
     * 
     * This format matches the exportUnitsToExcel format exactly
     */
    suspend fun importUnitsFromCsv(
        context: Context,
        uri: Uri,
        apartmentId: String
    ): Result<Pair<List<UnitEntity>, ImportResult>> = withContext(Dispatchers.IO) {
        try {
            val units = mutableListOf<UnitEntity>()
            val errors = mutableListOf<String>()
            var lineNumber = 0
            
            val inputStream: InputStream? = context.contentResolver.openInputStream(uri)
            if (inputStream == null) {
                return@withContext Result.failure(Exception("Dosya açılamadı"))
            }
            
            BufferedReader(InputStreamReader(inputStream, "UTF-8")).use { reader ->
                // Skip BOM if present
                reader.mark(1)
                val firstChar = reader.read()
                if (firstChar.toChar() != 0xFEFF.toChar()) {
                    reader.reset()
                }
                
                // Read header line (skip it)
                val headerLine = reader.readLine()
                if (headerLine == null) {
                    return@withContext Result.failure(Exception("Dosya boş"))
                }
                
                // Read data lines
                var line: String?
                while (reader.readLine().also { line = it } != null) {
                    lineNumber++
                    val trimmedLine = line!!.trim()
                    if (trimmedLine.isEmpty()) continue
                    
                    try {
                        val unit = parseUnitLine(trimmedLine, apartmentId, lineNumber)
                        if (unit != null) {
                            units.add(unit)
                        } else {
                            errors.add("Satır $lineNumber: Geçersiz format")
                        }
                    } catch (e: Exception) {
                        errors.add("Satır $lineNumber: ${e.message ?: "Bilinmeyen hata"}")
                    }
                }
            }
            
            val result = ImportResult(
                successCount = units.size,
                errorCount = errors.size,
                errors = errors
            )
            
            Result.success(Pair(units, result))
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
    
    private fun parseUnitLine(
        line: String,
        apartmentId: String,
        lineNumber: Int
    ): UnitEntity? {
        // Parse CSV line (handle quoted values)
        val values = parseCsvLine(line)
        
        if (values.size < 4) {
            throw Exception("Eksik sütun sayısı (en az 4 sütun gerekli: Blok, Daire Numarası, Kat, Alan)")
        }
        
        val blockName = values[0].trim()
        var unitNumber = values[1].trim()
        val floor = values[2].trim().toIntOrNull() ?: throw Exception("Geçersiz kat numarası")
        val area = values[3].trim().toDoubleOrNull() ?: throw Exception("Geçersiz alan değeri")
        
        // Ensure unitNumber includes block prefix (e.g., "A1", "B5")
        // If unitNumber is just a number, prepend block name
        if (unitNumber.all { it.isDigit() }) {
            unitNumber = "${blockName.uppercase()}$unitNumber"
        }
        
        // Optional fields
        val landShare = if (values.size > 4) {
            values[4].trim().toDoubleOrNull() ?: (1.0 / 36.0) // Default to 1/36 if not provided
        } else {
            1.0 / 36.0 // Default
        }
        
        val ownerType = if (values.size > 5) {
            try {
                OwnerType.valueOf(values[5].trim().uppercase())
            } catch (e: Exception) {
                OwnerType.OWNER // Default
            }
        } else {
            OwnerType.OWNER // Default
        }
        
        val ownerName = if (values.size > 6 && values[6].trim().isNotEmpty()) {
            values[6].trim()
        } else {
            null
        }
        
        val ownerPhone = if (values.size > 7 && values[7].trim().isNotEmpty()) {
            values[7].trim()
        } else {
            null
        }
        
        // Generate block ID from block name
        val blockId = when (blockName.uppercase()) {
            "A" -> "block-a"
            "B" -> "block-b"
            else -> "block-${blockName.lowercase()}"
        }
        
        // Generate unit ID
        val unitId = "unit-${blockId}-${floor}-${unitNumber}"
        
        return UnitEntity(
            id = unitId,
            apartmentId = apartmentId,
            blockId = blockId,
            unitNumber = unitNumber,
            floor = floor,
            area = area,
            landShare = landShare,
            ownerType = ownerType,
            ownerName = ownerName,
            ownerPhone = ownerPhone,
            createdAt = System.currentTimeMillis(),
            isActive = true
        )
    }
    
    private fun parseCsvLine(line: String): List<String> {
        val values = mutableListOf<String>()
        var current = StringBuilder()
        var inQuotes = false
        var i = 0
        
        while (i < line.length) {
            val char = line[i]
            
            when {
                char == '"' -> {
                    if (inQuotes && i + 1 < line.length && line[i + 1] == '"') {
                        // Escaped quote
                        current.append('"')
                        i += 2 // Skip both quotes
                        continue
                    } else {
                        // Toggle quote state
                        inQuotes = !inQuotes
                    }
                }
                char == ';' && !inQuotes -> {
                    // End of field
                    values.add(current.toString())
                    current = StringBuilder()
                }
                else -> {
                    current.append(char)
                }
            }
            i++
        }
        
        // Add last field
        values.add(current.toString())
        
        return values
    }
    
    /**
     * Import water meters from CSV file
     * Expected CSV format:
     * Daire Numarası, Daire İsmi, Sayaç Numarası, Birim Fiyat (₺/m³)
     * 
     * Example:
     * A1,Ahmet Yılmaz,12345,5.50
     * A2,Mehmet Demir,12346,5.50
     * B1,Ayşe Kaya,12347,5.50
     * 
     * Note: Daire İsmi sütunu bilgilendirme amaçlıdır, import işleminde kullanılmaz.
     * Daire eşleştirmesi Daire Numarası ile yapılır.
     */
    suspend fun importWaterMetersFromCsv(
        context: Context,
        uri: Uri,
        apartmentId: String,
        getUnitIdByNumber: (String) -> String? // Function to get unitId from unitNumber
    ): Result<Pair<List<com.balancetech.sitemanagement.data.entity.WaterMeter>, ImportResult>> = withContext(Dispatchers.IO) {
        try {
            val waterMeters = mutableListOf<com.balancetech.sitemanagement.data.entity.WaterMeter>()
            val errors = mutableListOf<String>()
            var lineNumber = 0
            
            val inputStream: InputStream? = context.contentResolver.openInputStream(uri)
            if (inputStream == null) {
                return@withContext Result.failure(Exception("Dosya açılamadı"))
            }
            
            BufferedReader(InputStreamReader(inputStream, "UTF-8")).use { reader ->
                // Skip BOM if present
                reader.mark(1)
                val firstChar = reader.read()
                if (firstChar.toChar() != 0xFEFF.toChar()) {
                    reader.reset()
                }
                
                // Read header line (skip it)
                val headerLine = reader.readLine()
                if (headerLine == null) {
                    return@withContext Result.failure(Exception("Dosya boş"))
                }
                
                // Read data lines
                var line: String?
                while (reader.readLine().also { line = it } != null) {
                    lineNumber++
                    val trimmedLine = line!!.trim()
                    if (trimmedLine.isEmpty()) continue
                    
                    try {
                        val waterMeter = parseWaterMeterLine(trimmedLine, apartmentId, lineNumber, getUnitIdByNumber)
                        if (waterMeter != null) {
                            waterMeters.add(waterMeter)
                        } else {
                            errors.add("Satır $lineNumber: Geçersiz format veya daire bulunamadı")
                        }
                    } catch (e: Exception) {
                        errors.add("Satır $lineNumber: ${e.message ?: "Bilinmeyen hata"}")
                    }
                }
            }
            
            val result = ImportResult(
                successCount = waterMeters.size,
                errorCount = errors.size,
                errors = errors
            )
            
            Result.success(Pair(waterMeters, result))
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
    
    private fun parseWaterMeterLine(
        line: String,
        apartmentId: String,
        lineNumber: Int,
        getUnitIdByNumber: (String) -> String?
    ): com.balancetech.sitemanagement.data.entity.WaterMeter? {
        val values = parseCsvLine(line)
        
        if (values.size < 2) {
            throw Exception("Eksik sütun sayısı (en az 2 sütun gerekli: Daire Numarası, Sayaç Numarası)")
        }
        
        val unitNumber = values[0].trim()
        // Daire İsmi (values[1]) - bilgilendirme amaçlı, kullanılmıyor
        val meterNumber = if (values.size >= 3) {
            values[2].trim() // Yeni format: Daire Numarası, Daire İsmi, Sayaç Numarası
        } else {
            values[1].trim() // Eski format: Daire Numarası, Sayaç Numarası
        }
        val unitPrice = if (values.size >= 4) {
            values[3].trim().toDoubleOrNull() ?: 0.0 // Yeni format
        } else if (values.size >= 3) {
            values[2].trim().toDoubleOrNull() ?: 0.0 // Eski format
        } else {
            0.0
        }
        
        if (meterNumber.isEmpty()) {
            throw Exception("Sayaç numarası boş olamaz")
        }
        
        // Get unitId from unitNumber
        val unitId = getUnitIdByNumber(unitNumber)
        if (unitId == null) {
            throw Exception("Daire '$unitNumber' bulunamadı")
        }
        
        // Generate water meter ID
        val waterMeterId = "water-meter-${unitId}-${meterNumber}"
        
        return com.balancetech.sitemanagement.data.entity.WaterMeter(
            id = waterMeterId,
            unitId = unitId,
            meterNumber = meterNumber,
            unitPrice = unitPrice,
            previousReading = 0.0,
            currentReading = 0.0,
            lastReadingDate = System.currentTimeMillis(),
            createdAt = System.currentTimeMillis()
        )
    }
}

