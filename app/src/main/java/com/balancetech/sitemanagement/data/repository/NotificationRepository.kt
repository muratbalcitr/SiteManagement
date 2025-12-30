package com.balancetech.sitemanagement.data.repository

import com.balancetech.sitemanagement.data.dao.NotificationDao
import com.balancetech.sitemanagement.data.entity.Notification
import kotlinx.coroutines.flow.Flow
import java.util.UUID

class NotificationRepository(private val notificationDao: NotificationDao) {
    fun getNotificationsByUser(userId: String): Flow<List<Notification>> =
        notificationDao.getNotificationsByUser(userId)

    fun getUnreadNotificationsByUser(userId: String): Flow<List<Notification>> =
        notificationDao.getUnreadNotificationsByUser(userId)

    fun getUnreadNotificationCount(userId: String): Flow<Int> =
        notificationDao.getUnreadNotificationCount(userId)

    suspend fun createNotification(
        userId: String,
        title: String,
        message: String,
        type: String
    ): Result<Notification> {
        val notification = Notification(
            id = UUID.randomUUID().toString(),
            userId = userId,
            title = title,
            message = message,
            type = type
        )
        notificationDao.insertNotification(notification)
        return Result.success(notification)
    }

    suspend fun markAsRead(notificationId: String) {
        notificationDao.markAsRead(notificationId)
    }

    suspend fun markAllAsRead(userId: String) {
        notificationDao.markAllAsRead(userId)
    }
}
