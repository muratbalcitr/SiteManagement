package com.balancetech.sitemanagement.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.balancetech.sitemanagement.data.datasource.LocalDataSource
import com.balancetech.sitemanagement.data.entity.Unit as UnitEntity
import com.balancetech.sitemanagement.data.model.PaymentStatus
import com.balancetech.sitemanagement.data.repository.FeeRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FeeViewModel @Inject constructor(
    private val feeRepository: FeeRepository,
    val localDataSource: LocalDataSource
) : ViewModel() {
    private val _uiState = MutableStateFlow<FeeUiState>(FeeUiState.Idle)
    val uiState: StateFlow<FeeUiState> = _uiState.asStateFlow()

    fun getFeesByUnit(unitId: String) = feeRepository.getFeesByUnit(unitId)

    fun getFeesByMonth(apartmentId: String, month: Int, year: Int) =
        feeRepository.getFeesByMonth(apartmentId, month, year)

    fun getFeesByStatus(unitId: String, status: PaymentStatus) =
        feeRepository.getFeesByStatus(unitId, status)

    fun getAllFees() = feeRepository.getAllFees()

    fun createFee(
        apartmentId: String,
        unitId: String,
        month: Int,
        year: Int,
        amount: Double,
        dueDate: Long
    ) {
        viewModelScope.launch {
            _uiState.value = FeeUiState.Loading
            val result = feeRepository.createFee(apartmentId, unitId, month, year, amount, dueDate)
            _uiState.value = if (result.isSuccess) {
                FeeUiState.Success("Aidat başarıyla oluşturuldu")
            } else {
                FeeUiState.Error(result.exceptionOrNull()?.message ?: "Aidat oluşturma başarısız")
            }
        }
    }

    fun createFeesForAllUnits(
        apartmentId: String,
        month: Int,
        year: Int,
        baseAmount: Double,
        dueDate: Long
    ) {
        viewModelScope.launch {
            _uiState.value = FeeUiState.Loading
            val result = feeRepository.createFeesForAllUnits(
                apartmentId, month, year, baseAmount, dueDate
            )
            _uiState.value = if (result.isSuccess) {
                val feesResult = result.getOrNull()
                val message = when {
                    feesResult == null -> "Aidat işlemi tamamlandı"
                    feesResult.createdCount > 0 && feesResult.updatedCount > 0 -> 
                        "${feesResult.createdCount} yeni aidat oluşturuldu, ${feesResult.updatedCount} aidat güncellendi"
                    feesResult.createdCount > 0 -> 
                        "${feesResult.createdCount} yeni aidat oluşturuldu"
                    feesResult.updatedCount > 0 -> 
                        "${feesResult.updatedCount} aidat güncellendi"
                    else -> "Aidat işlemi tamamlandı"
                }
                FeeUiState.Success(message)
            } else {
                FeeUiState.Error(result.exceptionOrNull()?.message ?: "Aidat oluşturma başarısız")
            }
        }
    }

    fun recordPayment(feeId: String, paymentAmount: Double) {
        viewModelScope.launch {
            _uiState.value = FeeUiState.Loading
            val result = feeRepository.recordPayment(feeId, paymentAmount)
            _uiState.value = if (result.isSuccess) {
                FeeUiState.Success("Ödeme kaydedildi")
            } else {
                FeeUiState.Error(result.exceptionOrNull()?.message ?: "Ödeme kaydetme başarısız")
            }
        }
    }
    
    suspend fun getAllUnits(apartmentId: String): List<UnitEntity> {
        return localDataSource.getUnitsByApartment(apartmentId)
    }
}

sealed class FeeUiState {
    object Idle : FeeUiState()
    object Loading : FeeUiState()
    data class Success(val message: String) : FeeUiState()
    data class Error(val message: String) : FeeUiState()
}
