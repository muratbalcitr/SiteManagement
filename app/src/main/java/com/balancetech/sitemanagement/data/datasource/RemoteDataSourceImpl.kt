package com.balancetech.sitemanagement.data.datasource

import com.balancetech.sitemanagement.data.entity.*
import com.balancetech.sitemanagement.data.entity.Unit as UnitEntity
import com.balancetech.sitemanagement.data.model.PaymentStatus
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.Query
import com.google.firebase.Timestamp
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
    private val bankTransactionsCollection = firestore.collection("bank_transactions")

    // User operations
    override suspend fun getUserByEmail(email: String): User? {
        return try {
            val snapshot = usersCollection.whereEqualTo("email", email).limit(1).get().await()
            snapshot.documents.firstOrNull()?.let { doc ->
                docToUser(doc)
            }
        } catch (e: Exception) {
            null
        }
    }

    override suspend fun getAllUsers(): List<User> {
        return try {
            usersCollection.get().await().documents.mapNotNull { doc ->
                docToUser(doc)
            }
        } catch (e: Exception) {
            emptyList()
        }
    }
    
    private fun docToUser(doc: com.google.firebase.firestore.DocumentSnapshot): User? {
        return try {
            val data = doc.data ?: return null
            val roleString = data["role"] as? String ?: "RESIDENT"
            val role = try {
                com.balancetech.sitemanagement.data.model.UserRole.valueOf(roleString)
            } catch (e: Exception) {
                com.balancetech.sitemanagement.data.model.UserRole.RESIDENT
            }
            
            User(
                id =  (data["unitId"] as? String).toString(),
                 email = data["email"] as? String ?: "",
                password = data["password"] as? String ?: "",
                name = data["name"] as? String ?: "",
                phone = data["phone"] as? String,
                role = role,
                apartmentId = data["apartmentId"] as? String,
                unitId = data["unitId"] as? String,
                createdAt = (data["createdAt"] as? Long) ?: System.currentTimeMillis(),
                isActive = (data["isActive"] as? Boolean) ?: true
            )
        } catch (e: Exception) {
            null
        }
    }
    
    private fun docToFee(doc: com.google.firebase.firestore.DocumentSnapshot): Fee? {
        return try {
            val data = doc.data ?: return null
            
            // Handle Timestamp conversion
            fun getLongValue(key: String): Long {
                val value = data[key]
                return when (value) {
                    is Long -> value
                    is Timestamp -> value.toDate().time
                    is Number -> value.toLong()
                    else -> System.currentTimeMillis()
                }
            }
            
            val statusString = data["status"] as? String ?: "UNPAID"
            val status = try {
                com.balancetech.sitemanagement.data.model.PaymentStatus.valueOf(statusString)
            } catch (e: Exception) {
                com.balancetech.sitemanagement.data.model.PaymentStatus.UNPAID
            }
            
            val fee = Fee(
                id = doc.id,
                apartmentId = data["apartmentId"] as? String ?: "",
                unitId = data["unitId"] as? String ?: "",
                month = (data["month"] as? Number)?.toInt() ?: 1,
                year = (data["year"] as? Number)?.toInt() ?: 2024,
                amount = (data["amount"] as? Number)?.toDouble() ?: 0.0,
                paidAmount = (data["paidAmount"] as? Number)?.toDouble() ?: 0.0,
                status = status,
                dueDate = getLongValue("dueDate"),
                createdAt = getLongValue("createdAt"),
                updatedAt = getLongValue("updatedAt")
            )
            
            android.util.Log.d("RemoteDataSource", "Converted fee: ${fee.id}, unitId: ${fee.unitId}, month: ${fee.month}, year: ${fee.year}")
            fee
        } catch (e: Exception) {
            android.util.Log.e("RemoteDataSource", "Error converting document to Fee (docId: ${doc.id}): ${e.message}", e)
            android.util.Log.e("RemoteDataSource", "Document data: ${doc.data}")
            null
        }
    }
    
    private fun docToUnit(doc: com.google.firebase.firestore.DocumentSnapshot): UnitEntity? {
        return try {
            val data = doc.data ?: return null
            val ownerTypeString = data["ownerType"] as? String ?: "OWNER"
            val ownerType = try {
                com.balancetech.sitemanagement.data.model.OwnerType.valueOf(ownerTypeString)
            } catch (e: Exception) {
                com.balancetech.sitemanagement.data.model.OwnerType.OWNER
            }
            
            UnitEntity(
                id = doc.id,
                apartmentId = data["apartmentId"] as? String ?: "",
                blockId = data["blockId"] as? String,
                unitNumber = data["unitNumber"] as? String ?: "",
                floor = (data["floor"] as? Number)?.toInt() ?: 0,
                area = (data["area"] as? Number)?.toDouble() ?: 0.0,
                landShare = (data["landShare"] as? Number)?.toDouble() ?: 0.0,
                ownerType = ownerType,
                ownerName = data["ownerName"] as? String,
                ownerPhone = data["ownerPhone"] as? String,
                createdAt = (data["createdAt"] as? Long) ?: System.currentTimeMillis(),
                isActive = (data["isActive"] as? Boolean) ?: true
            )
        } catch (e: Exception) {
            android.util.Log.e("RemoteDataSource", "Error converting document to Unit: ${e.message}", e)
            null
        }
    }
    
    private fun docToPayment(doc: com.google.firebase.firestore.DocumentSnapshot): Payment? {
        return try {
            val data = doc.data ?: return null
            
            Payment(
                id = doc.id,
                unitId = data["unitId"] as? String ?: "",
                feeId = data["feeId"] as? String,
                extraPaymentId = data["extraPaymentId"] as? String,
                waterBillId = data["waterBillId"] as? String,
                amount = (data["amount"] as? Number)?.toDouble() ?: 0.0,
                paymentDate = (data["paymentDate"] as? Long) ?: System.currentTimeMillis(),
                paymentMethod = data["paymentMethod"] as? String ?: "cash",
                description = data["description"] as? String,
                createdBy = data["createdBy"] as? String ?: "",
                createdAt = (data["createdAt"] as? Long) ?: System.currentTimeMillis()
            )
        } catch (e: Exception) {
            android.util.Log.e("RemoteDataSource", "Error converting document to Payment: ${e.message}", e)
            null
        }
    }
    
    private fun docToWaterMeter(doc: com.google.firebase.firestore.DocumentSnapshot): WaterMeter? {
        return try {
            val data = doc.data ?: return null
            
            WaterMeter(
                id = doc.id,
                unitId = data["unitId"] as? String ?: "",
                meterNumber = data["meterNumber"] as? String ?: "",
                previousReading = (data["previousReading"] as? Number)?.toDouble() ?: 0.0,
                currentReading = (data["currentReading"] as? Number)?.toDouble() ?: 0.0,
                unitPrice = (data["unitPrice"] as? Number)?.toDouble() ?: 0.0,
                lastReadingDate = (data["lastReadingDate"] as? Long) ?: System.currentTimeMillis(),
                createdAt = (data["createdAt"] as? Long) ?: System.currentTimeMillis()
            )
        } catch (e: Exception) {
            android.util.Log.e("RemoteDataSource", "Error converting document to WaterMeter: ${e.message}", e)
            null
        }
    }
    
    private fun docToWaterBill(doc: com.google.firebase.firestore.DocumentSnapshot): WaterBill? {
        return try {
            val data = doc.data ?: return null
            val statusString = data["status"] as? String ?: "UNPAID"
            val status = try {
                com.balancetech.sitemanagement.data.model.PaymentStatus.valueOf(statusString)
            } catch (e: Exception) {
                com.balancetech.sitemanagement.data.model.PaymentStatus.UNPAID
            }
            
            WaterBill(
                id = doc.id,
                unitId = data["unitId"] as? String ?: "",
                waterMeterId = data["waterMeterId"] as? String ?: "",
                month = (data["month"] as? Number)?.toInt() ?: 1,
                year = (data["year"] as? Number)?.toInt() ?: 2024,
                previousReading = (data["previousReading"] as? Number)?.toDouble() ?: 0.0,
                currentReading = (data["currentReading"] as? Number)?.toDouble() ?: 0.0,
                consumption = (data["consumption"] as? Number)?.toDouble() ?: 0.0,
                unitPrice = (data["unitPrice"] as? Number)?.toDouble() ?: 0.0,
                amount = (data["amount"] as? Number)?.toDouble() ?: 0.0,
                wastewaterAmount = (data["wastewaterAmount"] as? Number)?.toDouble() ?: 0.0,
                environmentalTax = (data["environmentalTax"] as? Number)?.toDouble() ?: 0.0,
                vat = (data["vat"] as? Number)?.toDouble() ?: 0.0,
                sharedAmount = (data["sharedAmount"] as? Number)?.toDouble() ?: 0.0,
                totalAmount = (data["totalAmount"] as? Number)?.toDouble() ?: 0.0,
                paidAmount = (data["paidAmount"] as? Number)?.toDouble() ?: 0.0,
                status = status,
                dueDate = (data["dueDate"] as? Long) ?: System.currentTimeMillis(),
                createdAt = (data["createdAt"] as? Long) ?: System.currentTimeMillis()
            )
        } catch (e: Exception) {
            android.util.Log.e("RemoteDataSource", "Error converting document to WaterBill: ${e.message}", e)
            null
        }
    }
    
    private fun docToExtraPayment(doc: com.google.firebase.firestore.DocumentSnapshot): ExtraPayment? {
        return try {
            val data = doc.data ?: return null
            val typeString = data["type"] as? String ?: "OTHER"
            val type = try {
                com.balancetech.sitemanagement.data.model.ExtraPaymentType.valueOf(typeString)
            } catch (e: Exception) {
                com.balancetech.sitemanagement.data.model.ExtraPaymentType.OTHER
            }
            val statusString = data["status"] as? String ?: "UNPAID"
            val status = try {
                com.balancetech.sitemanagement.data.model.PaymentStatus.valueOf(statusString)
            } catch (e: Exception) {
                com.balancetech.sitemanagement.data.model.PaymentStatus.UNPAID
            }
            
            ExtraPayment(
                id = doc.id,
                apartmentId = data["apartmentId"] as? String ?: "",
                unitId = data["unitId"] as? String,
                title = data["title"] as? String ?: "",
                description = data["description"] as? String,
                amount = (data["amount"] as? Number)?.toDouble() ?: 0.0,
                type = type,
                installmentCount = (data["installmentCount"] as? Number)?.toInt() ?: 1,
                currentInstallment = (data["currentInstallment"] as? Number)?.toInt() ?: 1,
                paidAmount = (data["paidAmount"] as? Number)?.toDouble() ?: 0.0,
                status = status,
                dueDate = (data["dueDate"] as? Long) ?: System.currentTimeMillis(),
                createdAt = (data["createdAt"] as? Long) ?: System.currentTimeMillis(),
                updatedAt = (data["updatedAt"] as? Long) ?: System.currentTimeMillis()
            )
        } catch (e: Exception) {
            android.util.Log.e("RemoteDataSource", "Error converting document to ExtraPayment: ${e.message}", e)
            null
        }
    }
    
    private fun docToNotification(doc: com.google.firebase.firestore.DocumentSnapshot): Notification? {
        return try {
            val data = doc.data ?: return null
            
            Notification(
                id = doc.id,
                userId = data["userId"] as? String ?: "",
                title = data["title"] as? String ?: "",
                message = data["message"] as? String ?: "",
                type = data["type"] as? String ?: "",
                isRead = (data["isRead"] as? Boolean) ?: false,
                createdAt = (data["createdAt"] as? Long) ?: System.currentTimeMillis()
            )
        } catch (e: Exception) {
            android.util.Log.e("RemoteDataSource", "Error converting document to Notification: ${e.message}", e)
            null
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
            // Fetch without orderBy to avoid index requirement, sort in memory
            feesCollection
                .whereEqualTo("unitId", unitId)
                .get()
                .await()
                .documents
                .mapNotNull { doc -> docToFee(doc) }
                .sortedWith(compareByDescending<Fee> { it.year }
                    .thenByDescending { it.month })
        } catch (e: Exception) {
            android.util.Log.e("RemoteDataSource", "Error fetching fees by unit: ${e.message}", e)
            emptyList()
        }
    }

    override suspend fun getFeesByMonth(apartmentId: String, month: Int, year: Int): List<Fee> {
        return try {
            // Use apartmentId and year filter, then filter by month in memory
            // This avoids the need for a composite index on (apartmentId, month, year)
            feesCollection
                .whereEqualTo("apartmentId", apartmentId)
                .whereEqualTo("year", year)
                .get()
                .await()
                .documents
                .mapNotNull { doc -> docToFee(doc) }
                .filter { it.month == month }
        } catch (e: Exception) {
            // If the query still fails, try without filters and filter in memory
            try {
                feesCollection
                    .whereEqualTo("apartmentId", apartmentId)
                    .get()
                    .await()
                    .documents
                    .mapNotNull { doc -> docToFee(doc) }
                    .filter { it.month == month && it.year == year }
            } catch (e2: Exception) {
                emptyList()
            }
        }
    }

    override suspend fun getFeesByUnitAndStatus(unitId: String, status: PaymentStatus): List<Fee> {
        return try {
            feesCollection
                .whereEqualTo("unitId", unitId)
                .whereEqualTo("status", status.name)
                .get()
                .await()
                .documents
                .mapNotNull { doc -> docToFee(doc) }
        } catch (e: Exception) {
            emptyList()
        }
    }

    override suspend fun getAllFees(): List<Fee> {
        return try {
            android.util.Log.d("RemoteDataSource", "Fetching all fees from Firebase...")
            // Fetch all fees without orderBy to avoid index requirement
            // Sort in memory instead
            val snapshot = feesCollection.get().await()
            android.util.Log.d("RemoteDataSource", "Fetched ${snapshot.documents.size} fee documents from Firebase")
            
            val fees = snapshot.documents.mapNotNull { doc ->
                val fee = docToFee(doc)
                if (fee == null) {
                    android.util.Log.w("RemoteDataSource", "Failed to convert fee document: ${doc.id}")
                }
                fee
            }
            
            android.util.Log.d("RemoteDataSource", "Successfully converted ${fees.size} fees")
            fees.sortedWith(compareByDescending<Fee> { it.year }
                .thenByDescending { it.month })
        } catch (e: Exception) {
            android.util.Log.e("RemoteDataSource", "Error fetching all fees: ${e.message}", e)
            e.printStackTrace()
            emptyList()
        }
    }

    override suspend fun getFeeById(id: String): Fee? {
        return try {
            val doc = feesCollection.document(id).get().await()
            if (doc.exists()) {
                docToFee(doc)
            } else {
                null
            }
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
                .get()
                .await()
                .documents
                .mapNotNull { doc -> docToPayment(doc) }
                .sortedByDescending { it.paymentDate }
        } catch (e: Exception) {
            android.util.Log.e("RemoteDataSource", "Error fetching payments by unit: ${e.message}", e)
            emptyList()
        }
    }

    override suspend fun getPaymentsByFee(feeId: String): List<Payment> {
        return try {
            paymentsCollection
                .whereEqualTo("feeId", feeId)
                .get()
                .await()
                .documents
                .mapNotNull { doc -> docToPayment(doc) }
        } catch (e: Exception) {
            android.util.Log.e("RemoteDataSource", "Error fetching payments by fee: ${e.message}", e)
            emptyList()
        }
    }

    override suspend fun getAllPayments(): List<Payment> {
        return try {
            paymentsCollection
                .get()
                .await()
                .documents
                .mapNotNull { doc -> docToPayment(doc) }
                .sortedByDescending { it.paymentDate }
        } catch (e: Exception) {
            android.util.Log.e("RemoteDataSource", "Error fetching all payments: ${e.message}", e)
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
            waterMetersCollection
                .get()
                .await()
                .documents
                .mapNotNull { doc -> docToWaterMeter(doc) }
        } catch (e: Exception) {
            android.util.Log.e("RemoteDataSource", "Error fetching all water meters: ${e.message}", e)
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
                ?.let { doc -> docToWaterMeter(doc) }
        } catch (e: Exception) {
            android.util.Log.e("RemoteDataSource", "Error fetching water meter by unit: ${e.message}", e)
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
                .get()
                .await()
                .documents
                .mapNotNull { doc -> docToWaterBill(doc) }
                .sortedWith(compareByDescending<WaterBill> { it.year }
                    .thenByDescending { it.month })
        } catch (e: Exception) {
            android.util.Log.e("RemoteDataSource", "Error fetching water bills by unit: ${e.message}", e)
            emptyList()
        }
    }

    override suspend fun getWaterBillById(id: String): WaterBill? {
        return try {
            val doc = waterBillsCollection.document(id).get().await()
            if (doc.exists()) {
                docToWaterBill(doc)
            } else {
                null
            }
        } catch (e: Exception) {
            android.util.Log.e("RemoteDataSource", "Error fetching water bill by id: ${e.message}", e)
            null
        }
    }

    override suspend fun getAllWaterBills(): List<WaterBill> {
        return try {
            waterBillsCollection
                .get()
                .await()
                .documents
                .mapNotNull { doc -> docToWaterBill(doc) }
                .sortedWith(compareByDescending<WaterBill> { it.year }
                    .thenByDescending { it.month })
        } catch (e: Exception) {
            android.util.Log.e("RemoteDataSource", "Error fetching all water bills: ${e.message}", e)
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

    override suspend fun deleteWaterBill(waterBillId: String): Result<Unit> {
        return try {
            waterBillsCollection.document(waterBillId).delete().await()
            Result.success(Unit)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }

    // Notification operations
    override suspend fun getNotificationsByUser(userId: String): List<Notification> {
        return try {
            notificationsCollection
                .whereEqualTo("userId", userId)
                .get()
                .await()
                .documents
                .mapNotNull { doc -> docToNotification(doc) }
                .sortedByDescending { it.createdAt }
        } catch (e: Exception) {
            android.util.Log.e("RemoteDataSource", "Error fetching notifications by user: ${e.message}", e)
            emptyList()
        }
    }

    override suspend fun getUnreadNotificationsByUser(userId: String): List<Notification> {
        return try {
            notificationsCollection
                .whereEqualTo("userId", userId)
                .whereEqualTo("isRead", false)
                .get()
                .await()
                .documents
                .mapNotNull { doc -> docToNotification(doc) }
                .sortedByDescending { it.createdAt }
        } catch (e: Exception) {
            android.util.Log.e("RemoteDataSource", "Error fetching unread notifications: ${e.message}", e)
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
                .documents
                .mapNotNull { doc -> docToUnit(doc) }
        } catch (e: Exception) {
            emptyList()
        }
    }

    override suspend fun getUnitById(id: String): UnitEntity? {
        return try {
            val doc = unitsCollection.document(id).get().await()
            if (doc.exists()) {
                docToUnit(doc)
            } else {
                null
            }
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
                .get()
                .await()
                .documents
                .mapNotNull { doc -> docToExtraPayment(doc) }
                .sortedByDescending { it.createdAt }
        } catch (e: Exception) {
            android.util.Log.e("RemoteDataSource", "Error fetching extra payments: ${e.message}", e)
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

    // Bank Transaction operations
    override suspend fun createBankTransaction(transaction: com.balancetech.sitemanagement.data.entity.BankTransaction): Result<com.balancetech.sitemanagement.data.entity.BankTransaction> {
        return try {
            bankTransactionsCollection.document(transaction.id).set(transaction).await()
            Result.success(transaction)
        } catch (e: Exception) {
            android.util.Log.e("RemoteDataSource", "Error creating bank transaction: ${e.message}", e)
            Result.failure(e)
        }
    }

    override suspend fun createBankTransactions(transactions: List<com.balancetech.sitemanagement.data.entity.BankTransaction>): Result<List<com.balancetech.sitemanagement.data.entity.BankTransaction>> {
        return try {
            val batch = firestore.batch()
            transactions.forEach { transaction ->
                batch.set(bankTransactionsCollection.document(transaction.id), transaction)
            }
            batch.commit().await()
            Result.success(transactions)
        } catch (e: Exception) {
            android.util.Log.e("RemoteDataSource", "Error creating bank transactions: ${e.message}", e)
            Result.failure(e)
        }
    }

    override suspend fun getAllBankTransactions(): List<com.balancetech.sitemanagement.data.entity.BankTransaction> {
        return try {
            bankTransactionsCollection
                .orderBy("createdAt", Query.Direction.DESCENDING)
                .get()
                .await()
                .documents
                .mapNotNull { doc -> docToBankTransaction(doc) }
        } catch (e: Exception) {
            android.util.Log.e("RemoteDataSource", "Error fetching bank transactions: ${e.message}", e)
            emptyList()
        }
    }

    private fun docToBankTransaction(doc: com.google.firebase.firestore.DocumentSnapshot): com.balancetech.sitemanagement.data.entity.BankTransaction? {
        return try {
            val data = doc.data ?: return null
            
            com.balancetech.sitemanagement.data.entity.BankTransaction(
                date = data["date"] as? String ?: "",
                receiptNo = data["receiptNo"] as? String ?: "",
                description = data["description"] as? String ?: "",
                amount = (data["amount"] as? Number)?.toDouble() ?: 0.0,
                balance = (data["balance"] as? Number)?.toDouble() ?: 0.0,
                createdAt = (data["createdAt"] as? Long) ?: System.currentTimeMillis()
            )
        } catch (e: Exception) {
            android.util.Log.e("RemoteDataSource", "Error converting document to BankTransaction: ${e.message}", e)
            null
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

