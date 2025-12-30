package com.balancetech.sitemanagement.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.balancetech.sitemanagement.data.model.PaymentStatus
import com.balancetech.sitemanagement.data.repository.AuthRepository
import com.balancetech.sitemanagement.data.repository.ExtraPaymentRepository
import com.balancetech.sitemanagement.data.repository.FeeRepository
import com.balancetech.sitemanagement.data.repository.PaymentRepository
import com.balancetech.sitemanagement.data.repository.SyncRepository
import com.balancetech.sitemanagement.data.repository.WaterMeterRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DashboardViewModel @Inject constructor(
    private val authRepository: AuthRepository,
    private val feeRepository: FeeRepository,
    private val paymentRepository: PaymentRepository,
    private val extraPaymentRepository: ExtraPaymentRepository,
    private val waterMeterRepository: WaterMeterRepository,
    private val syncRepository: SyncRepository
) : ViewModel() {
    private val _uiState = MutableStateFlow<DashboardUiState>(DashboardUiState.Idle)
    val uiState: StateFlow<DashboardUiState> = _uiState.asStateFlow()
    
    private val _syncState = MutableStateFlow<SyncState>(SyncState.Idle)
    val syncState: StateFlow<SyncState> = _syncState.asStateFlow()

    val currentUser = authRepository.currentUser

    // Total Debt (Toplam Borç) - Ödenmemiş tutarlar
    val totalDebt: Flow<Double> = combine(
        feeRepository.getAllFees(),
        extraPaymentRepository.getAllExtraPayments("apt-001"), // TODO: Get from current user
        waterMeterRepository.getAllWaterBills()
    ) { fees, extraPayments, waterBills ->
        var debt = 0.0

        // Unpaid fees (aidatlar)
        fees.filter { it.status != PaymentStatus.PAID }
            .forEach { debt += (it.amount - it.paidAmount) }

        // Unpaid extra payments (ek ödemeler)
        extraPayments.filter { it.status != PaymentStatus.PAID }
            .forEach { debt += (it.amount - it.paidAmount) }

        // Unpaid water bills (su faturaları)
        waterBills.filter { it.status != PaymentStatus.PAID }
            .forEach { debt += (it.totalAmount - it.paidAmount) }

        debt
    }

    // Total Credit (Toplam Alacak) - Ödenen toplam tutar
    val totalCredit: Flow<Double> = paymentRepository.getAllPayments()
        .map { payments ->
            payments.sumOf { it.amount }
        }

    fun loadDashboardData(unitId: String) {
        viewModelScope.launch {
            _uiState.value = DashboardUiState.Loading
            // Data is automatically loaded via Flow
            _uiState.value = DashboardUiState.Success
        }
    }
    
    fun syncToFirebase() {
        viewModelScope.launch {
            _syncState.value = SyncState.Syncing
            val result = syncRepository.syncAllToFirebase()
            _syncState.value = if (result.isSuccess) {
                SyncState.Success(result.getOrNull() ?: "Senkronizasyon tamamlandı")
            } else {
                SyncState.Error(result.exceptionOrNull()?.message ?: "Senkronizasyon hatası")
            }
        }
    }
}

sealed class DashboardUiState {
    object Idle : DashboardUiState()
    object Loading : DashboardUiState()
    object Success : DashboardUiState()
    data class Error(val message: String) : DashboardUiState()
}

sealed class SyncState {
    object Idle : SyncState()
    object Syncing : SyncState()
    data class Success(val message: String) : SyncState()
    data class Error(val message: String) : SyncState()
}
