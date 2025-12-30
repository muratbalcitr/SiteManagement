package com.balancetech.sitemanagement.data.service

import com.google.firebase.functions.FirebaseFunctions
import kotlinx.coroutines.tasks.await
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Service class for calling Firebase Cloud Functions
 */
@Singleton
class FirebaseFunctionsService @Inject constructor(
    private val functions: FirebaseFunctions
) {
    
    /**
     * Create a new fee
     */
    suspend fun createFee(
        apartmentId: String,
        unitId: String,
        month: Int,
        year: Int,
        amount: Double,
        dueDate: Long
    ): Result<Map<String, Any?>> {
        return try {
            val data = hashMapOf(
                "apartmentId" to apartmentId,
                "unitId" to unitId,
                "month" to month,
                "year" to year,
                "amount" to amount,
                "dueDate" to dueDate
            )
            
            val result = functions.getHttpsCallable("createFee")
                .call(data)
                .await()
            
            val response = result.data as? Map<*, *>
            if (response != null && response["success"] == true) {
                Result.success(response as Map<String, Any?>)
            } else {
                Result.failure(Exception("Failed to create fee"))
            }
        } catch (e: Exception) {
            Result.failure(e)
        }
    }

    /**
     * Create fees for all units in an apartment
     */
    suspend fun createFeesForAllUnits(
        apartmentId: String,
        month: Int,
        year: Int,
        baseAmount: Double,
        dueDate: Long
    ): Result<Map<String, Any?>> {
        return try {
            val data = hashMapOf(
                "apartmentId" to apartmentId,
                "month" to month,
                "year" to year,
                "baseAmount" to baseAmount,
                "dueDate" to dueDate
            )
            
            val result = functions.getHttpsCallable("createFeesForAllUnits")
                .call(data)
                .await()
            
            val response = result.data as? Map<*, *>
            if (response != null && response["success"] == true) {
                Result.success(response as Map<String, Any?>)
            } else {
                Result.failure(Exception("Failed to create fees"))
            }
        } catch (e: Exception) {
            Result.failure(e)
        }
    }

    /**
     * Record a payment
     */
    suspend fun recordPayment(
        unitId: String,
        amount: Double,
        paymentMethod: String,
        description: String? = null,
        feeId: String? = null,
        extraPaymentId: String? = null,
        waterBillId: String? = null
    ): Result<Map<String, Any?>> {
        return try {
            val data = hashMapOf(
                "unitId" to unitId,
                "amount" to amount,
                "paymentMethod" to paymentMethod,
                "description" to description,
                "feeId" to feeId,
                "extraPaymentId" to extraPaymentId,
                "waterBillId" to waterBillId
            ).filterValues { it != null }
            
            val result = functions.getHttpsCallable("recordPayment")
                .call(data)
                .await()
            
            val response = result.data as? Map<*, *>
            if (response != null && response["success"] == true) {
                Result.success(response as Map<String, Any?>)
            } else {
                Result.failure(Exception("Failed to record payment"))
            }
        } catch (e: Exception) {
            Result.failure(e)
        }
    }

    /**
     * Record water meter reading
     */
    suspend fun recordWaterMeterReading(
        unitId: String,
        currentReading: Double
    ): Result<Map<String, Any?>> {
        return try {
            val data = hashMapOf(
                "unitId" to unitId,
                "currentReading" to currentReading
            )
            
            val result = functions.getHttpsCallable("recordWaterMeterReading")
                .call(data)
                .await()
            
            val response = result.data as? Map<*, *>
            if (response != null && response["success"] == true) {
                Result.success(response as Map<String, Any?>)
            } else {
                Result.failure(Exception("Failed to record water meter reading"))
            }
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
}

