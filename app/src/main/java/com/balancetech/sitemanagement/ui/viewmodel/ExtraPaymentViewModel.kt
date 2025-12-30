package com.balancetech.sitemanagement.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.balancetech.sitemanagement.data.model.ExtraPaymentType
import com.balancetech.sitemanagement.data.repository.ExtraPaymentRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ExtraPaymentViewModel @Inject constructor(
    private val extraPaymentRepository: ExtraPaymentRepository
) : ViewModel() {
    private val _uiState = MutableStateFlow<ExtraPaymentUiState>(ExtraPaymentUiState.Idle)
    val uiState: StateFlow<ExtraPaymentUiState> = _uiState.asStateFlow()

    fun getExtraPaymentsByUnit(unitId: String) = extraPaymentRepository.getExtraPaymentsByUnit(unitId)

    fun getBuildingWideExtraPayments(apartmentId: String) = 
        extraPaymentRepository.getBuildingWideExtraPayments(apartmentId)
    
    fun getAllExtraPayments(apartmentId: String) = 
        extraPaymentRepository.getAllExtraPayments(apartmentId)

    fun createExtraPayment(
        apartmentId: String,
        unitId: String?,
        title: String,
        description: String?,
        amount: Double,
        type: ExtraPaymentType,
        installmentCount: Int,
        dueDate: Long
    ) {
        viewModelScope.launch {
            _uiState.value = ExtraPaymentUiState.Loading
            val result = extraPaymentRepository.createExtraPayment(
                apartmentId, unitId, title, description, amount, type, installmentCount, dueDate
            )
            _uiState.value = if (result.isSuccess) {
                ExtraPaymentUiState.Success("Ek ödeme başarıyla oluşturuldu")
            } else {
                ExtraPaymentUiState.Error(result.exceptionOrNull()?.message ?: "Ek ödeme oluşturma başarısız")
            }
        }
    }

    fun recordPayment(extraPaymentId: String, paymentAmount: Double) {
        viewModelScope.launch {
            _uiState.value = ExtraPaymentUiState.Loading
            val result = extraPaymentRepository.recordPayment(extraPaymentId, paymentAmount)
            _uiState.value = if (result.isSuccess) {
                ExtraPaymentUiState.Success("Ödeme kaydedildi")
            } else {
                ExtraPaymentUiState.Error(result.exceptionOrNull()?.message ?: "Ödeme kaydetme başarısız")
            }
        }
    }
}

sealed class ExtraPaymentUiState {
    object Idle : ExtraPaymentUiState()
    object Loading : ExtraPaymentUiState()
    data class Success(val message: String) : ExtraPaymentUiState()
    data class Error(val message: String) : ExtraPaymentUiState()
}

