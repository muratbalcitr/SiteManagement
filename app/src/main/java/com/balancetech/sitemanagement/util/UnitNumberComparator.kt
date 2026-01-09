package com.balancetech.sitemanagement.util

import com.balancetech.sitemanagement.data.entity.WaterMeter
import com.balancetech.sitemanagement.data.entity.WaterBill
import com.balancetech.sitemanagement.data.entity.Unit
import com.balancetech.sitemanagement.data.datasource.LocalDataSource

/**
 * Utility class for comparing unit numbers in natural order
 * Handles formats like: A1, A2, A10, B1, B2, etc.
 */
object UnitNumberComparator {
    
    /**
     * Compare two unit numbers in natural order
     * Examples:
     * - A1 < A2 < A10 (not A1 < A10 < A2)
     * - A1 < B1 < C1
     * 
     * @param unitNumber1 First unit number (e.g., "A1")
     * @param unitNumber2 Second unit number (e.g., "A10")
     * @return Negative if unitNumber1 < unitNumber2, positive if unitNumber1 > unitNumber2, 0 if equal
     */
    fun compareUnitNumbers(unitNumber1: String, unitNumber2: String): Int {
        // Extract letter and number parts
        val (letter1, num1) = parseUnitNumber(unitNumber1)
        val (letter2, num2) = parseUnitNumber(unitNumber2)
        
        // First compare by letter
        val letterComparison = letter1.compareTo(letter2, ignoreCase = true)
        if (letterComparison != 0) {
            return letterComparison
        }
        
        // If letters are same, compare by number
        return num1.compareTo(num2)
    }
    
    /**
     * Parse unit number into letter and number parts
     * Examples:
     * - "A1" -> ("A", 1)
     * - "A10" -> ("A", 10)
     * - "B23" -> ("B", 23)
     * - "123" -> ("", 123) // If no letter, empty string
     */
    private fun parseUnitNumber(unitNumber: String): Pair<String, Int> {
        val trimmed = unitNumber.trim()
        if (trimmed.isEmpty()) {
            return Pair("", 0)
        }
        
        // Find where the number starts
        var numberStartIndex = 0
        while (numberStartIndex < trimmed.length && !trimmed[numberStartIndex].isDigit()) {
            numberStartIndex++
        }
        
        val letterPart = trimmed.substring(0, numberStartIndex)
        val numberPart = if (numberStartIndex < trimmed.length) {
            trimmed.substring(numberStartIndex).toIntOrNull() ?: 0
        } else {
            0
        }
        
        return Pair(letterPart, numberPart)
    }
    
    /**
     * Sort water meters by unit number
     */
    suspend fun sortWaterMetersByUnitNumber(
        waterMeters: List<WaterMeter>,
        localDataSource: LocalDataSource
    ): List<WaterMeter> {
        // Collect all unique unit IDs
        val unitIds = waterMeters.map { it.unitId }.distinct()
        
        // Fetch all units first (outside the comparator)
        val unitMap = mutableMapOf<String, Unit?>()
        for (unitId in unitIds) {
            unitMap[unitId] = localDataSource.getUnitById(unitId)
        }
        
        // Now sort using the pre-fetched units
        return waterMeters.sortedWith { meter1, meter2 ->
            val unit1 = unitMap[meter1.unitId]
            val unit2 = unitMap[meter2.unitId]
            
            val unitNumber1 = unit1?.unitNumber ?: meter1.id
            val unitNumber2 = unit2?.unitNumber ?: meter2.id
            
            compareUnitNumbers(unitNumber1, unitNumber2)
        }
    }
    
    /**
     * Sort water bills by unit number, then by year and month
     */
    suspend fun sortWaterBillsByUnitNumber(
        waterBills: List<WaterBill>,
        localDataSource: LocalDataSource
    ): List<WaterBill> {
        // Collect all unique unit IDs
        val unitIds = waterBills.map { it.unitId }.distinct()
        
        // Fetch all units first (outside the comparator)
        val unitMap = mutableMapOf<String, Unit?>()
        for (unitId in unitIds) {
            unitMap[unitId] = localDataSource.getUnitById(unitId)
        }
        
        // Now sort using the pre-fetched units
        return waterBills.sortedWith { bill1, bill2 ->
            val unit1 = unitMap[bill1.unitId]
            val unit2 = unitMap[bill2.unitId]
            
            val unitNumber1 = unit1?.unitNumber ?: bill1.id
            val unitNumber2 = unit2?.unitNumber ?: bill2.id
            
            // First compare by unit number
            val unitComparison = compareUnitNumbers(unitNumber1, unitNumber2)
            if (unitComparison != 0) {
                return@sortedWith unitComparison
            }
            
            // If same unit, compare by year (descending)
            val yearComparison = bill2.year.compareTo(bill1.year)
            if (yearComparison != 0) {
                return@sortedWith yearComparison
            }
            
            // If same year, compare by month (descending)
            bill2.month.compareTo(bill1.month)
        }
    }
}

