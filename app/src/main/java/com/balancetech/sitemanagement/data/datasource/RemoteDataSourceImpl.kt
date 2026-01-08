package com.balancetech.sitemanagement.data.datasource

import com.balancetech.sitemanagement.data.entity.*
import com.balancetech.sitemanagement.data.entity.Unit as UnitEntity
import com.balancetech.sitemanagement.data.model.PaymentStatus
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.Query
import kotlinx.coroutines.tasks.await
import javax.inject.Inject

class RemoteDataSourceImpl @Inject constructor(
    private val firestore: FirebaseFirestore,
    private val firebaseAuth: FirebaseAuth
) : RemoteDataSource {

    // Collections
    private val usersCollection = firestore.collection("users")
    private val feesCollection = firestore.collection("fees")
    private val paymentsCollection = firestore.collection("payments")
    private val waterMetersCollection = firestore.collection("water_meters")
    private val waterBillsCollection = firestore.collection("water_bills")
    private val notificationsCollection = firestore.collection("notifications")
    private val unitsCollection = firestore.collection("units")
    private val extraPaymentsCollection = firestore.collection("extra_payments")

    // User operations
    override suspend fun getUserByEmail(email: String): User? {
        return try {
            val snapshot = usersCollection.whereEqualTo("email", email).limit(1).get().await()
            snapshot.documents.firstOrNull()?.toObject(User::class.java)
        } catch (e: Exception) {
            null
        }
    }

    override suspend fun getAllUsers(): List<User> {
        return try {
            usersCollection.get().await().toObjects(User::class.java)
        } catch (e: Exception) {
            emptyList()
        }
    }

    override suspend fun createUser(user: User): Result<User> {
        return try {
            usersCollection.document(user.id).set(user).await()
            Result.success(user)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }

    override suspend fun updateUser(user: User): Result<User> {
        return try {
            usersCollection.document(user.id).set(user).await()
            Result.success(user)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }

    // Fee operations
    override suspend fun getFeesByUnit(unitId: String): List<Fee> {
        return try {
            feesCollection
                .whereEqualTo("unitId", unitId)
                .orderBy("year", Query.Direction.DESCENDING)
                .orderBy("month", Query.Direction.DESCENDING)
                .get()
                .await()
                .toObjects(Fee::class.java)
        } catch (e: Exception) {
            emptyList()
        }
    }

    override suspend fun getFeesByMonth(apartmentId: String, month: Int, year: Int): List<Fee> {
        return try {
            feesCollection
                .whereEqualTo("apartmentId", apartmentId)
                .whereEqualTo("month", month)
                .whereEqualTo("year", year)
                .get()
                .await()
                .toObjects(Fee::class.java)
        } catch (e: Exception) {
            emptyList()
        }
    }

    override suspend fun getFeesByUnitAndStatus(unitId: String, status: PaymentStatus): List<Fee> {
        return try {
            feesCollection
                .whereEqualTo("unitId", unitId)
                .whereEqualTo("status", status.name)
                .get()
                .await()
                .toObjects(Fee::class.java)
        } catch (e: Exception) {
            emptyList()
        }
    }

    override suspend fun getAllFees(): List<Fee> {
        return try {
            feesCollection
                .orderBy("year", Query.Direction.DESCENDING)
                .orderBy("month", Query.Direction.DESCENDING)
                .get()
                .await()
                .toObjects(Fee::class.java)
        } catch (e: Exception) {
            emptyList()
        }
    }

    override suspend fun getFeeById(id: String): Fee? {
        return try {
            feesCollection.document(id).get().await().toObject(Fee::class.java)
        } catch (e: Exception) {
            null
        }
    }

    override suspend fun createFee(fee: Fee): Result<Fee> {
        return try {
            feesCollection.document(fee.id).set(fee).await()
            Result.success(fee)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }

    override suspend fun createFees(fees: List<Fee>): Result<List<Fee>> {
        return try {
            val batch = firestore.batch()
            fees.forEach { fee ->
                batch.set(feesCollection.document(fee.id), fee)
            }
            batch.commit().await()
            Result.success(fees)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }

    override suspend fun updateFee(fee: Fee): Result<Fee> {
        return try {
            feesCollection.document(fee.id).set(fee).await()
            Result.success(fee)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }

    // Payment operations
    override suspend fun getPaymentsByUnit(unitId: String): List<Payment> {
        return try {
            paymentsCollection
                .whereEqualTo("unitId", unitId)
                .orderBy("paymentDate", Query.Direction.DESCENDING)
                .get()
                .await()
                .toObjects(Payment::class.java)
        } catch (e: Exception) {
            emptyList()
        }
    }

    override suspend fun getPaymentsByFee(feeId: String): List<Payment> {
        return try {
            paymentsCollection
                .whereEqualTo("feeId", feeId)
                .get()
                .await()
                .toObjects(Payment::class.java)
        } catch (e: Exception) {
            emptyList()
        }
    }

    override suspend fun getAllPayments(): List<Payment> {
        return try {
            paymentsCollection
                .orderBy("paymentDate", Query.Direction.DESCENDING)
                .get()
                .await()
                .toObjects(Payment::class.java)
        } catch (e: Exception) {
            emptyList()
        }
    }

    override suspend fun createPayment(payment: Payment): Result<Payment> {
        return try {
            paymentsCollection.document(payment.id).set(payment).await()
            Result.success(payment)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }

    // Water Meter operations
    override suspend fun getAllWaterMeters(): List<WaterMeter> {
        return try {
            waterMetersCollection.get().await().toObjects(WaterMeter::class.java)
        } catch (e: Exception) {
            emptyList()
        }
    }

    override suspend fun getWaterMeterByUnit(unitId: String): WaterMeter? {
        return try {
            waterMetersCollection
                .whereEqualTo("unitId", unitId)
                .limit(1)
                .get()
                .await()
                .documents.firstOrNull()
                ?.toObject(WaterMeter::class.java)
        } catch (e: Exception) {
            null
        }
    }

    override suspend fun createOrUpdateWaterMeter(waterMeter: WaterMeter): Result<WaterMeter> {
        return try {
            waterMetersCollection.document(waterMeter.id).set(waterMeter).await()
            Result.success(waterMeter)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }

    // Water Bill operations
    override suspend fun getWaterBillsByUnit(unitId: String): List<WaterBill> {
        return try {
            waterBillsCollection
                .whereEqualTo("unitId", unitId)
                .orderBy("year", Query.Direction.DESCENDING)
                .orderBy("month", Query.Direction.DESCENDING)
                .get()
                .await()
                .toObjects(WaterBill::class.java)
        } catch (e: Exception) {
            emptyList()
        }
    }

    override suspend fun getWaterBillById(id: String): WaterBill? {
        return try {
            waterBillsCollection.document(id).get().await().toObject(WaterBill::class.java)
        } catch (e: Exception) {
            null
        }
    }

    override suspend fun getAllWaterBills(): List<WaterBill> {
        return try {
            waterBillsCollection
                .orderBy("year", Query.Direction.DESCENDING)
                .orderBy("month", Query.Direction.DESCENDING)
                .get()
                .await()
                .toObjects(WaterBill::class.java)
        } catch (e: Exception) {
            emptyList()
        }
    }

    override suspend fun createWaterBill(waterBill: WaterBill): Result<WaterBill> {
        return try {
            waterBillsCollection.document(waterBill.id).set(waterBill).await()
            Result.success(waterBill)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }

    override suspend fun updateWaterBill(waterBill: WaterBill): Result<WaterBill> {
        return try {
            waterBillsCollection.document(waterBill.id).set(waterBill).await()
            Result.success(waterBill)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }

    // Notification operations
    override suspend fun getNotificationsByUser(userId: String): List<Notification> {
        return try {
            notificationsCollection
                .whereEqualTo("userId", userId)
                .orderBy("createdAt", Query.Direction.DESCENDING)
                .get()
                .await()
                .toObjects(Notification::class.java)
        } catch (e: Exception) {
            emptyList()
        }
    }

    override suspend fun getUnreadNotificationsByUser(userId: String): List<Notification> {
        return try {
            notificationsCollection
                .whereEqualTo("userId", userId)
                .whereEqualTo("isRead", false)
                .orderBy("createdAt", Query.Direction.DESCENDING)
                .get()
                .await()
                .toObjects(Notification::class.java)
        } catch (e: Exception) {
            emptyList()
        }
    }

    override suspend fun getUnreadNotificationCount(userId: String): Int {
        return try {
            notificationsCollection
                .whereEqualTo("userId", userId)
                .whereEqualTo("isRead", false)
                .get()
                .await()
                .size()
        } catch (e: Exception) {
            0
        }
    }

    override suspend fun createNotification(notification: Notification): Result<Notification> {
        return try {
            notificationsCollection.document(notification.id).set(notification).await()
            Result.success(notification)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }

    override suspend fun markAsRead(notificationId: String, userId: String): Result<kotlin.Unit> {
        return try {
            notificationsCollection.document(notificationId).update("isRead", true).await()
            Result.success(Unit)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }

    override suspend fun markAllAsRead(userId: String): Result<kotlin.Unit> {
        return try {
            val batch = firestore.batch()
            val notifications = getUnreadNotificationsByUser(userId)
            notifications.forEach { notification ->
                batch.update(notificationsCollection.document(notification.id), "isRead", true)
            }
            batch.commit().await()
            Result.success(Unit)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }

    // Unit operations
    override suspend fun getUnitsByApartment(apartmentId: String): List<UnitEntity> {
        return try {
            unitsCollection
                .whereEqualTo("apartmentId", apartmentId)
                .whereEqualTo("isActive", true)
                .get()
                .await()
                .toObjects(UnitEntity::class.java)
        } catch (e: Exception) {
            emptyList()
        }
    }

    override suspend fun getUnitById(id: String): UnitEntity? {
        return try {
            unitsCollection.document(id).get().await().toObject(UnitEntity::class.java)
        } catch (e: Exception) {
            null
        }
    }

    override suspend fun createUnit(unit: UnitEntity): Result<UnitEntity> {
        return try {
            unitsCollection.document(unit.id).set(unit).await()
            Result.success(unit)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }

    override suspend fun updateUnit(unit: UnitEntity): Result<UnitEntity> {
        return try {
            unitsCollection.document(unit.id).set(unit).await()
            Result.success(unit)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }

    // Extra Payment operations
    override suspend fun getAllExtraPayments(apartmentId: String): List<ExtraPayment> {
        return try {
            extraPaymentsCollection
                .whereEqualTo("apartmentId", apartmentId)
                .orderBy("createdAt", Query.Direction.DESCENDING)
                .get()
                .await()
                .toObjects(ExtraPayment::class.java)
        } catch (e: Exception) {
            emptyList()
        }
    }

    override suspend fun createExtraPayment(extraPayment: ExtraPayment): Result<ExtraPayment> {
        return try {
            extraPaymentsCollection.document(extraPayment.id).set(extraPayment).await()
            Result.success(extraPayment)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }

    override suspend fun updateExtraPayment(extraPayment: ExtraPayment): Result<ExtraPayment> {
        return try {
            extraPaymentsCollection.document(extraPayment.id).set(extraPayment).await()
            Result.success(extraPayment)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }

    // Sync operations
    override suspend fun syncAllData(): Result<kotlin.Unit> {
        return try {
            // This will be implemented to sync all local data to Firebase
            // For now, return success
            Result.success(kotlin.Unit)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
}

