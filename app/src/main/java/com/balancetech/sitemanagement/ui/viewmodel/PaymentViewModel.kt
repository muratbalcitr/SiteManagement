package com.balancetech.sitemanagement.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.balancetech.sitemanagement.data.repository.AuthRepository
import com.balancetech.sitemanagement.data.repository.ExtraPaymentRepository
import com.balancetech.sitemanagement.data.repository.FeeRepository
import com.balancetech.sitemanagement.data.repository.PaymentRepository
import com.balancetech.sitemanagement.data.repository.WaterMeterRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PaymentViewModel @Inject constructor(
    private val paymentRepository: PaymentRepository,
    private val feeRepository: FeeRepository,
    private val extraPaymentRepository: ExtraPaymentRepository,
    private val waterMeterRepository: WaterMeterRepository,
    private val authRepository: AuthRepository
) : ViewModel() {
    private val _uiState = MutableStateFlow<PaymentUiState>(PaymentUiState.Idle)
    val uiState: StateFlow<PaymentUiState> = _uiState.asStateFlow()

    fun getPaymentsByUnit(unitId: String) = paymentRepository.getPaymentsByUnit(unitId)

    fun getAllPayments() = paymentRepository.getAllPayments()

    fun recordPayment(
        unitId: String,
        amount: Double,
        paymentMethod: String,
        description: String?,
        feeId: String? = null,
        extraPaymentId: String? = null,
        waterBillId: String? = null
    ) {
        viewModelScope.launch {
            _uiState.value = PaymentUiState.Loading
            val currentUser = authRepository.getCurrentUser()
            if (currentUser == null) {
                _uiState.value = PaymentUiState.Error("Kullanıcı bulunamadı")
                return@launch
            }
            
            // Check if payment exceeds fee amount for fees
            if (feeId != null) {
                val fee = feeRepository.getFeeById(feeId)
                if (fee != null) {
                    // Check if fee is already PAID - prevent duplicate payments
                    if (fee.status == com.balancetech.sitemanagement.data.model.PaymentStatus.PAID) {
                        _uiState.value = PaymentUiState.Error("Bu aidat zaten tamamen ödenmiş. Mükerrer ödeme yapılamaz.")
                        return@launch
                    }
                    
                    // Get existing payments for this fee to calculate actual paid amount
                    val existingPayments = paymentRepository.getPaymentsByFee(feeId).first()
                    val actualPaidAmount = existingPayments.sumOf { it.amount }
                    val remainingAmount = fee.amount - actualPaidAmount
                    
                    if (amount > remainingAmount) {
                        _uiState.value = PaymentUiState.Error("Ödeme tutarı kalan tutardan (${String.format("%.2f", remainingAmount)} ₺) fazla olamaz")
                        return@launch
                    }
                    
                    // Also check if total would exceed fee amount
                    val totalAfterPayment = actualPaidAmount + amount
                    if (totalAfterPayment > fee.amount) {
                        _uiState.value = PaymentUiState.Error("Toplam ödeme tutarı aidat tutarını (${String.format("%.2f", fee.amount)} ₺) aşamaz")
                        return@launch
                    }
                }
            }
            
            val result = paymentRepository.recordPayment(
                unitId = unitId,
                amount = amount,
                paymentMethod = paymentMethod,
                description = description,
                createdBy = currentUser.id,
                feeId = feeId,
                extraPaymentId = extraPaymentId,
                waterBillId = waterBillId
            )
            
            // If payment is for a fee, update fee payment status
            if (result.isSuccess && feeId != null) {
                feeRepository.recordPayment(feeId, amount)
            }
            
            // If payment is for an extra payment, update extra payment status
            if (result.isSuccess && extraPaymentId != null) {
                extraPaymentRepository.recordPayment(extraPaymentId, amount)
            }
            
            // If payment is for a water bill, update water bill payment status
            if (result.isSuccess && waterBillId != null) {
                waterMeterRepository.recordPayment(waterBillId, amount)
            }
            
            _uiState.value = if (result.isSuccess) {
                PaymentUiState.Success("Ödeme kaydedildi")
            } else {
                PaymentUiState.Error(result.exceptionOrNull()?.message ?: "Ödeme kaydedilemedi")
            }
        }
    }
}

sealed class PaymentUiState {
    object Idle : PaymentUiState()
    object Loading : PaymentUiState()
    data class Success(val message: String) : PaymentUiState()
    data class Error(val message: String) : PaymentUiState()
}

