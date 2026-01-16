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

    // Total Debt (Toplam Borç) - Tüm tutarlar (ödenen + ödenmemiş)
    // If unitId is provided, only calculate for that unit
    fun getTotalDebt(unitId: String? = null): Flow<Double> = combine(
        feeRepository.getAllFees(),
        extraPaymentRepository.getAllExtraPayments("apt-001"), // TODO: Get from current user
        waterMeterRepository.getAllWaterBills()
    ) { fees, extraPayments, waterBills ->
        var debt = 0.0

        // Filter by unitId if provided (for residents)
        val filteredFees = if (unitId != null) fees.filter { it.unitId == unitId } else fees
        val filteredExtraPayments = if (unitId != null) {
            extraPayments.filter { it.unitId == unitId }
        } else {
            extraPayments
        }
        val filteredWaterBills = if (unitId != null) {
            waterBills.filter { it.unitId == unitId }
        } else {
            waterBills
        }

        // All fees (aidatlar) - include both paid and unpaid
        filteredFees.forEach { debt += it.amount }

        // All extra payments (ek ödemeler) - include both paid and unpaid
        filteredExtraPayments.forEach { debt += it.amount }

        // All water bills (su faturaları) - include both paid and unpaid
        filteredWaterBills.forEach { debt += it.totalAmount }

        debt
    }

    val totalDebt: Flow<Double> = getTotalDebt()

    // Total Credit (Toplam Alacak) - Ödenen toplam tutar
    fun getTotalCredit(unitId: String? = null): Flow<Double> = paymentRepository.getAllPayments()
        .map { payments ->
            val filteredPayments = if (unitId != null) {
                payments.filter { it.unitId == unitId }
            } else {
                payments
            }
            filteredPayments.sumOf { it.amount }
        }

    val totalCredit: Flow<Double> = getTotalCredit()

    // Remaining Payment (Kalan Ödeme) - Toplam Borç - Toplam Ödenen
    fun getRemainingPayment(unitId: String? = null): Flow<Double> = combine(
        getTotalDebt(unitId),
        getTotalCredit(unitId)
    ) { debt, credit ->
        debt - credit
    }

    val remainingPayment: Flow<Double> = getRemainingPayment()

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
    
    fun syncFromFirebase(apartmentId: String = "apt-001") {
        viewModelScope.launch {
            _syncState.value = SyncState.Syncing
            val result = syncRepository.syncFromFirebase(apartmentId)
            _syncState.value = if (result.isSuccess) {
                SyncState.Success(result.getOrNull() ?: "Veriler indirildi")
            } else {
                SyncState.Error(result.exceptionOrNull()?.message ?: "Veri indirme hatası")
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
