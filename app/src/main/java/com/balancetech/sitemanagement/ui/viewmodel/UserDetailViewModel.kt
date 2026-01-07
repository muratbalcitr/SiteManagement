package com.balancetech.sitemanagement.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.balancetech.sitemanagement.data.datasource.LocalDataSource
import com.balancetech.sitemanagement.data.entity.ExtraPayment
import com.balancetech.sitemanagement.data.entity.Fee
import com.balancetech.sitemanagement.data.entity.Payment
import com.balancetech.sitemanagement.data.entity.Unit as UnitEntity
import com.balancetech.sitemanagement.data.entity.User
import com.balancetech.sitemanagement.data.entity.WaterBill
import com.balancetech.sitemanagement.data.repository.ExtraPaymentRepository
import com.balancetech.sitemanagement.data.repository.FeeRepository
import com.balancetech.sitemanagement.data.repository.PaymentRepository
import com.balancetech.sitemanagement.data.repository.UserRepository
import com.balancetech.sitemanagement.data.repository.WaterMeterRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class UserDetailViewModel @Inject constructor(
    private val feeRepository: FeeRepository,
    private val extraPaymentRepository: ExtraPaymentRepository,
    private val waterMeterRepository: WaterMeterRepository,
    private val paymentRepository: PaymentRepository,
    private val userRepository: UserRepository,
    private val localDataSource: LocalDataSource
) : ViewModel() {
    
    suspend fun getUserById(userId: String): User? {
        return localDataSource.getUserById(userId)
    }
    
    suspend fun getUnitById(unitId: String): UnitEntity? {
        return localDataSource.getUnitById(unitId)
    }
    
    fun getFeesByUnit(unitId: String): Flow<List<Fee>> {
        return feeRepository.getFeesByUnit(unitId)
    }
    
    fun getExtraPaymentsByUnit(unitId: String): Flow<List<ExtraPayment>> {
        return extraPaymentRepository.getExtraPaymentsByUnit(unitId)
    }
    
    fun getWaterBillsByUnit(unitId: String): Flow<List<WaterBill>> {
        return waterMeterRepository.getWaterBillsByUnit(unitId)
    }
    
    fun getPaymentsByUnit(unitId: String): Flow<List<Payment>> {
        return paymentRepository.getPaymentsByUnit(unitId)
    }
    
    suspend fun getUserUnits(userId: String): List<String> {
        return userRepository.getUserUnits(userId)
    }
    
    suspend fun getTotalDebt(unitId: String): Double {
        val fees = feeRepository.getFeesByUnit(unitId).first()
        val extraPayments = extraPaymentRepository.getExtraPaymentsByUnit(unitId).first()
        val waterBills = waterMeterRepository.getWaterBillsByUnit(unitId).first()
        
        var total = 0.0
        fees.forEach { fee ->
            total += (fee.amount - fee.paidAmount)
        }
        extraPayments.forEach { payment ->
            total += (payment.amount - payment.paidAmount)
        }
        waterBills.forEach { bill ->
            total += (bill.totalAmount - bill.paidAmount)
        }
        
        return total
    }
}

