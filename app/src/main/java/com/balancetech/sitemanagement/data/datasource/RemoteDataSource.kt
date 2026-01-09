package com.balancetech.sitemanagement.data.datasource

import com.balancetech.sitemanagement.data.entity.*
import com.balancetech.sitemanagement.data.entity.Unit as UnitEntity
import com.balancetech.sitemanagement.data.model.PaymentStatus
import kotlinx.coroutines.flow.Flow

/**
 * Remote data source interface for Firebase Firestore operations
 */
interface RemoteDataSource {
    // User operations
    suspend fun getUserByEmail(email: String): User?
    suspend fun getAllUsers(): List<User>
    suspend fun createUser(user: User): Result<User>
    suspend fun updateUser(user: User): Result<User>
    
    // Fee operations
    suspend fun getFeesByUnit(unitId: String): List<Fee>
    suspend fun getFeesByMonth(apartmentId: String, month: Int, year: Int): List<Fee>
    suspend fun getFeesByUnitAndStatus(unitId: String, status: PaymentStatus): List<Fee>
    suspend fun getAllFees(): List<Fee>
    suspend fun getFeeById(id: String): Fee?
    suspend fun createFee(fee: Fee): Result<Fee>
    suspend fun createFees(fees: List<Fee>): Result<List<Fee>>
    suspend fun updateFee(fee: Fee): Result<Fee>
    
    // Payment operations
    suspend fun getPaymentsByUnit(unitId: String): List<Payment>
    suspend fun getPaymentsByFee(feeId: String): List<Payment>
    suspend fun getAllPayments(): List<Payment>
    suspend fun createPayment(payment: Payment): Result<Payment>
    
    // Water Meter operations
    suspend fun getAllWaterMeters(): List<WaterMeter>
    suspend fun getWaterMeterByUnit(unitId: String): WaterMeter?
    suspend fun createOrUpdateWaterMeter(waterMeter: WaterMeter): Result<WaterMeter>
    
    // Water Bill operations
    suspend fun getWaterBillsByUnit(unitId: String): List<WaterBill>
    suspend fun getAllWaterBills(): List<WaterBill>
    suspend fun getWaterBillById(id: String): WaterBill?
    suspend fun createWaterBill(waterBill: WaterBill): Result<WaterBill>
    suspend fun updateWaterBill(waterBill: WaterBill): Result<WaterBill>
    suspend fun deleteWaterBill(waterBillId: String): Result<Unit>
    
    // Notification operations
    suspend fun getNotificationsByUser(userId: String): List<Notification>
    suspend fun getUnreadNotificationsByUser(userId: String): List<Notification>
    suspend fun getUnreadNotificationCount(userId: String): Int
    suspend fun createNotification(notification: Notification): Result<Notification>
    suspend fun markAsRead(notificationId: String, userId: String): Result<Unit>
    suspend fun markAllAsRead(userId: String): Result<Unit>
    
    // Unit operations
    suspend fun getUnitsByApartment(apartmentId: String): List<UnitEntity>
    suspend fun getUnitById(id: String): UnitEntity?
    suspend fun createUnit(unit: UnitEntity): Result<UnitEntity>
    suspend fun updateUnit(unit: UnitEntity): Result<UnitEntity>
    
    // Extra Payment operations
    suspend fun getAllExtraPayments(apartmentId: String): List<ExtraPayment>
    suspend fun createExtraPayment(extraPayment: ExtraPayment): Result<ExtraPayment>
    suspend fun updateExtraPayment(extraPayment: ExtraPayment): Result<ExtraPayment>
    
    // Sync operations
    suspend fun syncAllData(): Result<kotlin.Unit>
}

