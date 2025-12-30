package com.balancetech.sitemanagement.data.datasource

import com.balancetech.sitemanagement.data.entity.*
import com.balancetech.sitemanagement.data.entity.Unit as UnitEntity
import com.balancetech.sitemanagement.data.model.PaymentStatus
import kotlinx.coroutines.flow.Flow

/**
 * Local data source interface for Room Database operations
 */
interface LocalDataSource {
    // User operations
    suspend fun getUserByEmail(email: String): User?
    suspend fun getUserById(id: String): User?
    suspend fun insertUser(user: User)
    suspend fun getCurrentUser(): User?
    fun getAllActiveUsers(): Flow<List<User>>
    fun getUsersByRole(role: com.balancetech.sitemanagement.data.model.UserRole): Flow<List<User>>
    fun getUsersByUnit(unitId: String): Flow<List<User>>
    suspend fun updateUser(user: User)
    
    // Fee operations
    fun getFeesByUnit(unitId: String): Flow<List<Fee>>
    fun getFeesByMonth(apartmentId: String, month: Int, year: Int): Flow<List<Fee>>
    fun getFeesByUnitAndStatus(unitId: String, status: PaymentStatus): Flow<List<Fee>>
    fun getAllFees(): Flow<List<Fee>>
    suspend fun getFeeById(id: String): Fee?
    suspend fun insertFee(fee: Fee)
    suspend fun insertFees(fees: List<Fee>)
    suspend fun updateFee(fee: Fee)
    
    // Payment operations
    fun getPaymentsByUnit(unitId: String): Flow<List<Payment>>
    fun getPaymentsByFee(feeId: String): Flow<List<Payment>>
    fun getAllPayments(): Flow<List<Payment>>
    suspend fun insertPayment(payment: Payment)
    
    // Water Meter operations
    fun getAllWaterMeters(): Flow<List<WaterMeter>>
    suspend fun getWaterMeterByUnit(unitId: String): WaterMeter?
    suspend fun insertWaterMeter(waterMeter: WaterMeter)
    suspend fun updateWaterMeter(waterMeter: WaterMeter)
    
    // Water Bill operations
    fun getWaterBillsByUnit(unitId: String): Flow<List<WaterBill>>
    suspend fun getWaterBillById(id: String): WaterBill?
    suspend fun insertWaterBill(waterBill: WaterBill)
    suspend fun updateWaterBill(waterBill: WaterBill)
    
    // Notification operations
    fun getNotificationsByUser(userId: String): Flow<List<Notification>>
    fun getUnreadNotificationsByUser(userId: String): Flow<List<Notification>>
    fun getUnreadNotificationCount(userId: String): Flow<Int>
    suspend fun insertNotification(notification: Notification)
    suspend fun markAsRead(notificationId: String)
    suspend fun markAllAsRead(userId: String)
    
    // Unit operations
    suspend fun getUnitsByApartment(apartmentId: String): List<UnitEntity>
    suspend fun getUnitById(id: String): UnitEntity?
    fun getUnitsByBlock(blockId: String): Flow<List<UnitEntity>>
    
    // Block operations
    fun getBlocksByApartment(apartmentId: String): Flow<List<Block>>
    suspend fun insertBlock(block: Block)
    suspend fun insertUnit(unit: UnitEntity)
}

