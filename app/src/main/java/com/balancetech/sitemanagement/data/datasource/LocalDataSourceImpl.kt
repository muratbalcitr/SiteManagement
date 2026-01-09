package com.balancetech.sitemanagement.data.datasource

import com.balancetech.sitemanagement.data.dao.*
import com.balancetech.sitemanagement.data.entity.*
import com.balancetech.sitemanagement.data.entity.Unit as UnitEntity
import com.balancetech.sitemanagement.data.model.PaymentStatus
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.first
import javax.inject.Inject

class LocalDataSourceImpl @Inject constructor(
    private val userDao: UserDao,
    private val feeDao: FeeDao,
    private val paymentDao: PaymentDao,
    private val waterMeterDao: WaterMeterDao,
    private val waterBillDao: WaterBillDao,
    private val notificationDao: NotificationDao,
    private val unitDao: UnitDao,
    private val blockDao: com.balancetech.sitemanagement.data.dao.BlockDao,
    private val userUnitDao: UserUnitDao,
    private val extraPaymentDao: ExtraPaymentDao
) : LocalDataSource {
    
    // User operations
    override suspend fun getUserByEmail(email: String): User? = userDao.getUserByEmail(email)
    override suspend fun getUserById(id: String): User? = userDao.getUserById(id)
    override suspend fun insertUser(user: User) = userDao.insertUser(user)
    override suspend fun insertUsers(users: List<User>) {
        users.forEach { userDao.insertUser(it) }
    }
    override suspend fun getCurrentUser(): User? = userDao.getCurrentUser()
    override fun getAllActiveUsers(): Flow<List<User>> = userDao.getAllActiveUsers()
    override fun getUsersByRole(role: com.balancetech.sitemanagement.data.model.UserRole): Flow<List<User>> = userDao.getUsersByRole(role)
    override fun getUsersByUnit(unitId: String): Flow<List<User>> = userDao.getUsersByUnit(unitId)
    override suspend fun getUserIdsByUnitId(unitId: String): List<String> = userUnitDao.getUserIdsByUnitId(unitId)
    override suspend fun updateUser(user: User) = userDao.updateUser(user)
    
    // Fee operations
    override fun getFeesByUnit(unitId: String): Flow<List<Fee>> = feeDao.getFeesByUnit(unitId)
    override fun getFeesByMonth(apartmentId: String, month: Int, year: Int): Flow<List<Fee>> = 
        feeDao.getFeesByMonth(apartmentId, month, year)
    override fun getFeesByUnitAndStatus(unitId: String, status: PaymentStatus): Flow<List<Fee>> = 
        feeDao.getFeesByUnitAndStatus(unitId, status)
    override fun getAllFees(): Flow<List<Fee>> = feeDao.getAllFees()
    override suspend fun getFeeById(id: String): Fee? = feeDao.getFeeById(id)
    override suspend fun insertFee(fee: Fee) = feeDao.insertFee(fee)
    override suspend fun insertFees(fees: List<Fee>) = feeDao.insertFees(fees)
    override suspend fun updateFee(fee: Fee) = feeDao.updateFee(fee)
    
    // Payment operations
    override fun getPaymentsByUnit(unitId: String): Flow<List<Payment>> = paymentDao.getPaymentsByUnit(unitId)
    override fun getPaymentsByFee(feeId: String): Flow<List<Payment>> = paymentDao.getPaymentsByFee(feeId)
    override fun getAllPayments(): Flow<List<Payment>> = paymentDao.getAllPayments()
    override suspend fun insertPayment(payment: Payment) = paymentDao.insertPayment(payment)
    override suspend fun insertPayments(payments: List<Payment>) {
        payments.forEach { paymentDao.insertPayment(it) }
    }
    
    // Water Meter operations
    override fun getAllWaterMeters(): Flow<List<WaterMeter>> = waterMeterDao.getAllWaterMeters()
    override suspend fun getWaterMeterByUnit(unitId: String): WaterMeter? = waterMeterDao.getWaterMeterByUnit(unitId)
    override suspend fun insertWaterMeter(waterMeter: WaterMeter) = waterMeterDao.insertWaterMeter(waterMeter)
    override suspend fun insertWaterMeters(waterMeters: List<WaterMeter>) {
        waterMeters.forEach { waterMeterDao.insertWaterMeter(it) }
    }
    override suspend fun updateWaterMeter(waterMeter: WaterMeter) = waterMeterDao.updateWaterMeter(waterMeter)
    
    // Water Bill operations
    override fun getWaterBillsByUnit(unitId: String): Flow<List<WaterBill>> = waterBillDao.getWaterBillsByUnit(unitId)
    override suspend fun getWaterBillById(id: String): WaterBill? = waterBillDao.getWaterBillById(id)
    override suspend fun insertWaterBill(waterBill: WaterBill) = waterBillDao.insertWaterBill(waterBill)
    override suspend fun insertWaterBills(waterBills: List<WaterBill>) {
        waterBills.forEach { waterBillDao.insertWaterBill(it) }
    }
    override suspend fun updateWaterBill(waterBill: WaterBill) = waterBillDao.updateWaterBill(waterBill)
    override suspend fun deleteWaterBill(waterBill: WaterBill) = waterBillDao.deleteWaterBill(waterBill)
    
    // Notification operations
    override fun getNotificationsByUser(userId: String): Flow<List<Notification>> = notificationDao.getNotificationsByUser(userId)
    override fun getUnreadNotificationsByUser(userId: String): Flow<List<Notification>> = notificationDao.getUnreadNotificationsByUser(userId)
    override fun getUnreadNotificationCount(userId: String): Flow<Int> = notificationDao.getUnreadNotificationCount(userId)
    override suspend fun insertNotification(notification: Notification) = notificationDao.insertNotification(notification)
    override suspend fun markAsRead(notificationId: String) = notificationDao.markAsRead(notificationId)
    override suspend fun markAllAsRead(userId: String) = notificationDao.markAllAsRead(userId)
    
    // Unit operations
    override suspend fun getUnitsByApartment(apartmentId: String): List<UnitEntity> = unitDao.getUnitsByApartment(apartmentId).first()
    override suspend fun getUnitById(id: String): UnitEntity? = unitDao.getUnitById(id)
    override fun getUnitsByBlock(blockId: String): Flow<List<UnitEntity>> = unitDao.getUnitsByBlock(blockId)
    
    // Block operations
    override fun getBlocksByApartment(apartmentId: String): Flow<List<Block>> = blockDao.getBlocksByApartment(apartmentId)
    override suspend fun getBlockById(id: String): Block? = blockDao.getBlockById(id)
    override suspend fun insertBlock(block: Block) = blockDao.insertBlock(block)
    override suspend fun insertUnit(unit: UnitEntity) = unitDao.insertUnit(unit)
    
    // Extra Payment operations
    override suspend fun insertExtraPayment(extraPayment: com.balancetech.sitemanagement.data.entity.ExtraPayment) = 
        extraPaymentDao.insertExtraPayment(extraPayment)
}

