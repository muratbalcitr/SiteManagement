package com.balancetech.sitemanagement.util

import com.balancetech.sitemanagement.data.dao.BlockDao
import com.balancetech.sitemanagement.data.dao.UnitDao
import com.balancetech.sitemanagement.data.entity.Block
import com.balancetech.sitemanagement.data.entity.Unit as UnitEntity
import com.balancetech.sitemanagement.data.model.OwnerType
import kotlinx.coroutines.flow.first

/**
 * Utility class for seeding initial database data
 * Creates A and B blocks with 36 units each (72 units total)
 */
object DatabaseSeedUtil {
    
    private const val APARTMENT_ID = "apt-001"
    private const val BLOCK_A_ID = "block-a"
    private const val BLOCK_B_ID = "block-b"
    private const val UNITS_PER_BLOCK = 36
    
    /**
     * Seed blocks and units for the apartment
     * This should be called once when the app is first installed
     */
    suspend fun seedBlocksAndUnits(
        blockDao: BlockDao,
        unitDao: UnitDao
    ): Result<String> {
        return try {
            // Check if blocks already exist
            val existingBlocks = blockDao.getBlocksByApartment(APARTMENT_ID).first()
            if (existingBlocks.isNotEmpty()) {
                return Result.success("Bloklar ve daireler zaten mevcut")
            }
            
            // Create blocks
            val blockA = Block(
                id = BLOCK_A_ID,
                apartmentId = APARTMENT_ID,
                name = "A Blok",
                floorCount = 12, // 12 floors with 3 units per floor = 36 units
                createdAt = System.currentTimeMillis()
            )
            
            val blockB = Block(
                id = BLOCK_B_ID,
                apartmentId = APARTMENT_ID,
                name = "B Blok",
                floorCount = 12, // 12 floors with 3 units per floor = 36 units
                createdAt = System.currentTimeMillis()
            )
            
            blockDao.insertBlock(blockA)
            blockDao.insertBlock(blockB)
            
            // Create units for Block A (36 units)
            val unitsA = createUnitsForBlock(BLOCK_A_ID, "A", UNITS_PER_BLOCK)
            unitsA.forEach { unit ->
                unitDao.insertUnit(unit)
            }
            
            // Create units for Block B (36 units)
            val unitsB = createUnitsForBlock(BLOCK_B_ID, "B", UNITS_PER_BLOCK)
            unitsB.forEach { unit ->
                unitDao.insertUnit(unit)
            }
            
            Result.success("2 blok ve 72 daire başarıyla oluşturuldu")
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
    
    /**
     * Create units for a block
     * @param blockId The ID of the block
     * @param blockPrefix The prefix for unit numbers (A or B)
     * @param unitCount Number of units to create (36)
     */
    private fun createUnitsForBlock(
        blockId: String,
        blockPrefix: String,
        unitCount: Int
    ): List<UnitEntity> {
        val units = mutableListOf<UnitEntity>()
        
        // 12 floors with 3 units per floor = 36 units
        val floors = 12
        val unitsPerFloor = 3
        
        var unitCounter = 1 // Sequential unit number (1-36)
        
        for (floor in 1..floors) {
            for (unitInFloor in 1..unitsPerFloor) {
                // Format: A1, A2, A3, ..., A36 for A block
                //         B1, B2, B3, ..., B36 for B block
                val unitNumber = "${blockPrefix}${unitCounter}"
                
                val unit = UnitEntity(
                    id = "unit-${blockId}-${floor}-${unitInFloor}",
                    apartmentId = APARTMENT_ID,
                    blockId = blockId,
                    unitNumber = unitNumber,
                    floor = floor,
                    area = 100.0, // Default area in m²
                    landShare = 1.0 / unitCount, // Equal land share
                    ownerType = OwnerType.OWNER, // Default to owner
                    ownerName = null, // Will be filled when user is assigned
                    ownerPhone = null,
                    createdAt = System.currentTimeMillis(),
                    isActive = true
                )
                
                units.add(unit)
                unitCounter++
            }
        }
        
        return units
    }
    
    /**
     * Check if database is already seeded
     */
    suspend fun isSeeded(blockDao: BlockDao): Boolean {
        return try {
            val blocks = blockDao.getBlocksByApartment(APARTMENT_ID).first()
            blocks.isNotEmpty()
        } catch (e: Exception) {
            false
        }
    }
}

