package com.balancetech.sitemanagement.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.balancetech.sitemanagement.data.repository.AuthRepository
import com.balancetech.sitemanagement.data.repository.NotificationRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NotificationViewModel @Inject constructor(
    private val notificationRepository: NotificationRepository,
    private val authRepository: AuthRepository
) : ViewModel() {
    private val _uiState = MutableStateFlow<NotificationUiState>(NotificationUiState.Idle)
    val uiState: StateFlow<NotificationUiState> = _uiState.asStateFlow()

    fun getNotifications() = authRepository.currentUser.value?.let { user ->
        notificationRepository.getNotificationsByUser(user.id)
    } ?: kotlinx.coroutines.flow.flowOf(emptyList())

    fun getUnreadNotifications() = authRepository.currentUser.value?.let { user ->
        notificationRepository.getUnreadNotificationsByUser(user.id)
    } ?: kotlinx.coroutines.flow.flowOf(emptyList())

    fun getUnreadNotificationCount() = authRepository.currentUser.value?.let { user ->
        notificationRepository.getUnreadNotificationCount(user.id)
    } ?: kotlinx.coroutines.flow.flowOf(0)

    fun markAsRead(notificationId: String) {
        viewModelScope.launch {
            notificationRepository.markAsRead(notificationId)
        }
    }

    fun markAllAsRead() {
        viewModelScope.launch {
            authRepository.currentUser.value?.let { user ->
                notificationRepository.markAllAsRead(user.id)
            }
        }
    }

    fun createNotification(
        userId: String,
        title: String,
        message: String,
        type: String
    ) {
        viewModelScope.launch {
            _uiState.value = NotificationUiState.Loading
            val result = notificationRepository.createNotification(userId, title, message, type)
            _uiState.value = if (result.isSuccess) {
                NotificationUiState.Success("Bildirim oluşturuldu")
            } else {
                NotificationUiState.Error(result.exceptionOrNull()?.message ?: "Bildirim oluşturulamadı")
            }
        }
    }
}

sealed class NotificationUiState {
    object Idle : NotificationUiState()
    object Loading : NotificationUiState()
    data class Success(val message: String) : NotificationUiState()
    data class Error(val message: String) : NotificationUiState()
}

