package com.balancetech.sitemanagement.util

import android.content.Context
import android.net.Uri
import com.balancetech.sitemanagement.data.entity.Unit as UnitEntity
import com.balancetech.sitemanagement.data.entity.BankTransaction
import com.balancetech.sitemanagement.data.model.OwnerType
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.io.BufferedReader
import java.io.InputStream
import java.io.InputStreamReader
import java.text.SimpleDateFormat
import java.util.Locale
import org.apache.poi.ss.usermodel.*
import org.apache.poi.xssf.usermodel.XSSFWorkbook

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
        val unitOwner = values[1].trim()
        // Daire İsmi (values[1]) - bilgilendirme amaçlı, kullanılmıyor
        val meterNumber = values[2].trim() // Yeni format: Daire Numarası, Daire İsmi, Sayaç Numarası

        val unitPrice = values[3].trim().toDoubleOrNull() ?: 0.0 // Yeni format

        
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
    
    /**
     * Import bank transactions from CSV/XLSX file
     * Expected format: Tarih, Fiş No, Açıklama, İşlem Tutarı, Bakiye
     * 
     * Example:
     * 29.12.2025,F39525,Gönd: AHMET OKYAY - DOĞALGAZ PROJE ÜCRETI,-75000.00,9438.17
     * 29.12.2025,F39525,MESAJ ÜCRETİ TUTARI,-1.97,9436.20
     * 
     * Supports both CSV and XLSX formats
     */
    suspend fun importBankTransactionsFromCsv(
        context: Context,
        uri: Uri
    ): Result<Pair<List<BankTransaction>, ImportResult>> = withContext(Dispatchers.IO) {
        // Detect file type by MIME type or extension
        val mimeType = context.contentResolver.getType(uri) ?: ""
        val fileName = getFileName(context, uri) ?: ""
        
        return@withContext when {
            mimeType.contains("spreadsheet") || 
            mimeType.contains("excel") || 
            fileName.endsWith(".xlsx", ignoreCase = true) ||
            fileName.endsWith(".xls", ignoreCase = true) -> {
                importBankTransactionsFromXlsx(context, uri)
            }
            else -> {
                importBankTransactionsFromCsvInternal(context, uri)
            }
        }
    }
    
    private suspend fun importBankTransactionsFromXlsx(
        context: Context,
        uri: Uri
    ): Result<Pair<List<BankTransaction>, ImportResult>> = withContext(Dispatchers.IO) {
        try {
            val transactions = mutableListOf<BankTransaction>()
            val errors = mutableListOf<String>()
            
            val inputStream: InputStream? = context.contentResolver.openInputStream(uri)
            if (inputStream == null) {
                return@withContext Result.failure(Exception("Dosya açılamadı"))
            }
            
            inputStream.use { stream ->
                val workbook: Workbook = try {
                    XSSFWorkbook(stream)
                } catch (e: Exception) {
                    return@withContext Result.failure(Exception("XLSX dosyası okunamadı: ${e.message}"))
                }
                
                try {
                    val sheet = workbook.getSheetAt(0) // First sheet
                    if (sheet == null) {
                        return@withContext Result.failure(Exception("Excel dosyası boş"))
                    }
                    
                    var rowIndex = 0
                    for (row in sheet) {
                        rowIndex++
                        
                        // Skip header row
                        if (rowIndex == 1) continue
                        
                        // Skip empty rows
                        if (row.getCell(0) == null || getCellValueAsString(row.getCell(0)).isBlank()) {
                            continue
                        }
                        
                        try {
                            val date = getCellValueAsString(row.getCell(0))
                            val receiptNo = getCellValueAsString(row.getCell(1))
                            val description = getCellValueAsString(row.getCell(2))
                            
                            // Get amount and balance - handle both numeric and string cells
                            val amount = getNumericValue(row.getCell(3))
                            val balance = getNumericValue(row.getCell(4))
                            
                            if (date.isBlank() || receiptNo.isBlank()) {
                                errors.add("Satır $rowIndex: Tarih ve Fiş No boş olamaz")
                                continue
                            }
                            
                            val transaction = BankTransaction(
                                date = date,
                                receiptNo = receiptNo,
                                description = description,
                                amount = amount,
                                balance = balance
                            )
                            
                            transactions.add(transaction)
                        } catch (e: Exception) {
                            errors.add("Satır $rowIndex: ${e.message ?: "Bilinmeyen hata"}")
                        }
                    }
                } finally {
                    workbook.close()
                }
            }
            
            val result = ImportResult(
                successCount = transactions.size,
                errorCount = errors.size,
                errors = errors
            )
            
            Result.success(Pair(transactions, result))
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
    
    private fun getCellValueAsString(cell: Cell?): String {
        if (cell == null) return ""
        
        return when (cell.cellType) {
            CellType.STRING -> cell.stringCellValue.trim()
            CellType.NUMERIC -> {
                if (DateUtil.isCellDateFormatted(cell)) {
                    val dateFormat = SimpleDateFormat("dd.MM.yyyy", Locale.getDefault())
                    dateFormat.format(cell.dateCellValue)
                } else {
                    // Format number without scientific notation
                    val num = cell.numericCellValue
                    if (num % 1 == 0.0) {
                        num.toLong().toString()
                    } else {
                        num.toString()
                    }
                }
            }
            CellType.BOOLEAN -> cell.booleanCellValue.toString()
            CellType.FORMULA -> {
                when (cell.cachedFormulaResultType) {
                    CellType.STRING -> cell.stringCellValue.trim()
                    CellType.NUMERIC -> {
                        val num = cell.numericCellValue
                        if (num % 1 == 0.0) {
                            num.toLong().toString()
                        } else {
                            num.toString()
                        }
                    }
                    CellType.BOOLEAN -> cell.booleanCellValue.toString()
                    else -> ""
                }
            }
            else -> ""
        }
    }
    
    /**
     * Get numeric value from cell, handling both numeric and string cells
     * For string cells, parses Turkish number format (comma as decimal separator)
     */
    private fun getNumericValue(cell: Cell?): Double {
        if (cell == null) return 0.0
        
        return when (cell.cellType) {
            CellType.NUMERIC -> cell.numericCellValue
            CellType.STRING -> {
                // Parse string value (may contain comma as decimal separator)
                val str = cell.stringCellValue.trim()
                parseAmount(str)
            }
            CellType.FORMULA -> {
                when (cell.cachedFormulaResultType) {
                    CellType.NUMERIC -> cell.numericCellValue
                    CellType.STRING -> {
                        val str = cell.stringCellValue.trim()
                        parseAmount(str)
                    }
                    else -> 0.0
                }
            }
            else -> 0.0
        }
    }
    
    private fun parseAmount(amountStr: String): Double {
        if (amountStr.isBlank()) return 0.0
        
        var cleaned = amountStr.trim()
        
        // Handle Turkish number format:
        // - If both dot and comma exist: dot is thousand separator, comma is decimal (e.g., 28.342,37)
        // - If only comma exists: comma is decimal separator (e.g., 28342,37)
        // - If only dot exists: dot is decimal separator (e.g., 28342.37)
        
        val hasComma = cleaned.contains(',')
        val hasDot = cleaned.contains('.')
        
        when {
            hasComma && hasDot -> {
                // Both exist: dot is thousand separator, comma is decimal
                // Example: 28.342,37 -> 28342.37
                cleaned = cleaned.replace(".", "") // Remove thousand separators
                cleaned = cleaned.replace(",", ".") // Replace comma with dot for decimal
            }
            hasComma && !hasDot -> {
                // Only comma: it's decimal separator
                // Example: 28342,37 -> 28342.37
                cleaned = cleaned.replace(",", ".")
            }
            !hasComma && hasDot -> {
                // Only dot: it's decimal separator (already correct)
                // Example: 28342.37 -> 28342.37
                // No change needed
            }
        }
        
        return cleaned.toDoubleOrNull() ?: 0.0
    }
    
    private fun getFileName(context: Context, uri: Uri): String? {
        var result: String? = null
        if (uri.scheme == "content") {
            val cursor = context.contentResolver.query(uri, null, null, null, null)
            cursor?.use {
                if (it.moveToFirst()) {
                    val nameIndex = it.getColumnIndex(android.provider.OpenableColumns.DISPLAY_NAME)
                    if (nameIndex >= 0) {
                        result = it.getString(nameIndex)
                    }
                }
            }
        }
        if (result == null) {
            result = uri.path
            val cut = result?.lastIndexOf('/')
            if (cut != null && cut != -1) {
                result = result?.substring(cut + 1)
            }
        }
        return result
    }
    
    private suspend fun importBankTransactionsFromCsvInternal(
        context: Context,
        uri: Uri
    ): Result<Pair<List<BankTransaction>, ImportResult>> = withContext(Dispatchers.IO) {
        try {
            val transactions = mutableListOf<BankTransaction>()
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
                        val transaction = parseBankTransactionLine(trimmedLine, lineNumber)
                        if (transaction != null) {
                            transactions.add(transaction)
                        } else {
                            errors.add("Satır $lineNumber: Geçersiz format")
                        }
                    } catch (e: Exception) {
                        errors.add("Satır $lineNumber: ${e.message ?: "Bilinmeyen hata"}")
                    }
                }
            }
            
            val result = ImportResult(
                successCount = transactions.size,
                errorCount = errors.size,
                errors = errors
            )
            
            Result.success(Pair(transactions, result))
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
    
    private fun parseBankTransactionLine(
        line: String,
        lineNumber: Int
    ): BankTransaction? {
        // Try different delimiters: tab, semicolon, comma
        val values = when {
            line.contains('\t') -> line.split('\t')
            line.contains(';') -> parseCsvLine(line) // Use existing CSV parser for semicolon
            else -> line.split(',').map { it.trim() }
        }
        
        if (values.size < 5) {
            throw Exception("Eksik sütun sayısı (en az 5 sütun gerekli: Tarih, Fiş No, Açıklama, İşlem Tutarı, Bakiye)")
        }
        
        val date = values[0].trim()
        val receiptNo = values[1].trim()
        val description = values[2].trim()
        
        // Parse amount - remove thousand separators and handle decimal
        val amountStr = values[3].trim()
            .replace(".", "") // Remove thousand separators
            .replace(",", ".") // Replace comma with dot for decimal
        val amount = amountStr.toDoubleOrNull() ?: throw Exception("Geçersiz işlem tutarı: ${values[3]}")
        
        // Parse balance - remove thousand separators and handle decimal
        val balanceStr = values[4].trim()
            .replace(".", "") // Remove thousand separators
            .replace(",", ".") // Replace comma with dot for decimal
        val balance = balanceStr.toDoubleOrNull() ?: throw Exception("Geçersiz bakiye: ${values[4]}")
        
        if (date.isEmpty() || receiptNo.isEmpty()) {
            throw Exception("Tarih ve Fiş No boş olamaz")
        }
        
        return BankTransaction(
            date = date,
            receiptNo = receiptNo,
            description = description,
            amount = amount,
            balance = balance
        )
    }
}

