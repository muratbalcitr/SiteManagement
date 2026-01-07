package com.balancetech.sitemanagement.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.balancetech.sitemanagement.data.model.PaymentStatus
import com.balancetech.sitemanagement.data.repository.FeeRepository
import com.balancetech.sitemanagement.data.repository.WaterMeterRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

@HiltViewModel
class ReportsViewModel @Inject constructor(
    private val feeRepository: FeeRepository,
    private val waterMeterRepository: WaterMeterRepository
) : ViewModel() {

    fun getTotalUnpaidFees(): Flow<Double> {
        return feeRepository.getAllFees().map { fees ->
            fees.filter { it.status != PaymentStatus.PAID }
                .sumOf { it.amount - it.paidAmount }
        }
    }

    fun getTotalUnpaidWaterBills(): Flow<Double> {
        // This would need to be implemented in WaterMeterRepository
        // For now, return empty flow
        return kotlinx.coroutines.flow.flowOf(0.0)
    }

    fun getMonthlyPaymentSummary(): Flow<Map<String, Double>> {
        // Return monthly payment summary
        return kotlinx.coroutines.flow.flowOf(emptyMap())
    }
}



