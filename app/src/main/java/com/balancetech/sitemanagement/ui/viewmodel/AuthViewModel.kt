package com.balancetech.sitemanagement.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.balancetech.sitemanagement.data.model.UserRole
import com.balancetech.sitemanagement.data.repository.AuthRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AuthViewModel @Inject constructor(
    private val authRepository: AuthRepository
) : ViewModel() {
    private val _uiState = MutableStateFlow<AuthUiState>(AuthUiState.Idle)
    val uiState: StateFlow<AuthUiState> = _uiState.asStateFlow()

    val currentUser = authRepository.currentUser

    init {
        // Initialize current user from Firebase Auth state
        viewModelScope.launch {
            authRepository.initializeCurrentUser()
        }
    }

    fun login(email: String, password: String) {
        viewModelScope.launch {
            _uiState.value = AuthUiState.Loading
            val result = authRepository.login(email, password)
            _uiState.value = if (result.isSuccess) {
                AuthUiState.Success("Giriş başarılı")
            } else {
                AuthUiState.Error(result.exceptionOrNull()?.message ?: "Giriş başarısız")
            }
        }
    }

    fun register(
        email: String,
        password: String,
        name: String,
        phone: String?,
        role: UserRole
    ) {
        viewModelScope.launch {
            _uiState.value = AuthUiState.Loading
            val result = authRepository.register(email, password, name, phone, role)
            _uiState.value = if (result.isSuccess) {
                AuthUiState.Success("Kayıt başarılı. Giriş yapabilirsiniz.")
            } else {
                AuthUiState.Error(result.exceptionOrNull()?.message ?: "Kayıt başarısız")
            }
        }
    }

    fun logout() {
        viewModelScope.launch {
            authRepository.logout()
            _uiState.value = AuthUiState.Idle
        }
    }

    fun isLoggedIn(): Boolean = authRepository.isLoggedIn()
}

sealed class AuthUiState {
    object Idle : AuthUiState()
    object Loading : AuthUiState()
    data class Success(val message: String) : AuthUiState()
    data class Error(val message: String) : AuthUiState()
}
