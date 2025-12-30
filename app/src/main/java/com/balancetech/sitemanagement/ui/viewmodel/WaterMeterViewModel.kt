package com.balancetech.sitemanagement.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.balancetech.sitemanagement.data.repository.WaterMeterRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class WaterMeterViewModel @Inject constructor(
    private val waterMeterRepository: WaterMeterRepository
) : ViewModel() {
    private val _uiState = MutableStateFlow<WaterMeterUiState>(WaterMeterUiState.Idle)
    val uiState: StateFlow<WaterMeterUiState> = _uiState.asStateFlow()

    fun getAllWaterMeters() = waterMeterRepository.getAllWaterMeters()

    fun getWaterMeterByUnit(unitId: String) {
        viewModelScope.launch {
            waterMeterRepository.getWaterMeterByUnit(unitId)
        }
    }

    fun getWaterBillsByUnit(unitId: String) = waterMeterRepository.getWaterBillsByUnit(unitId)
    
    fun getAllWaterBills() = waterMeterRepository.getAllWaterBills()

    fun createOrUpdateWaterMeter(
        unitId: String,
        meterNumber: String,
        unitPrice: Double
    ) {
        viewModelScope.launch {
            _uiState.value = WaterMeterUiState.Loading
            val result = waterMeterRepository.createOrUpdateWaterMeter(unitId, meterNumber, unitPrice)
            _uiState.value = if (result.isSuccess) {
                WaterMeterUiState.Success("Water meter saved")
            } else {
                WaterMeterUiState.Error(result.exceptionOrNull()?.message ?: "Failed to save water meter")
            }
        }
    }

    fun recordReading(unitId: String, currentReading: Double) {
        viewModelScope.launch {
            _uiState.value = WaterMeterUiState.Loading
            val result = waterMeterRepository.recordReading(unitId, currentReading)
            _uiState.value = if (result.isSuccess) {
                WaterMeterUiState.Success("Reading recorded and bill created")
            } else {
                WaterMeterUiState.Error(result.exceptionOrNull()?.message ?: "Failed to record reading")
            }
        }
    }

    fun recordPayment(waterBillId: String, paymentAmount: Double) {
        viewModelScope.launch {
            _uiState.value = WaterMeterUiState.Loading
            val result = waterMeterRepository.recordPayment(waterBillId, paymentAmount)
            _uiState.value = if (result.isSuccess) {
                WaterMeterUiState.Success("Payment recorded")
            } else {
                WaterMeterUiState.Error(result.exceptionOrNull()?.message ?: "Failed to record payment")
            }
        }
    }
}

sealed class WaterMeterUiState {
    object Idle : WaterMeterUiState()
    object Loading : WaterMeterUiState()
    data class Success(val message: String) : WaterMeterUiState()
    data class Error(val message: String) : WaterMeterUiState()
}
