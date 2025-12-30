package com.balancetech.sitemanagement.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.balancetech.sitemanagement.data.entity.Notification
import com.balancetech.sitemanagement.databinding.ItemNotificationBinding
import java.text.SimpleDateFormat
import java.util.*

class NotificationAdapter(
    private val onItemClick: (Notification) -> Unit
) : ListAdapter<Notification, NotificationAdapter.NotificationViewHolder>(NotificationDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NotificationViewHolder {
        val binding = ItemNotificationBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return NotificationViewHolder(binding)
    }

    override fun onBindViewHolder(holder: NotificationViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    inner class NotificationViewHolder(
        private val binding: ItemNotificationBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(notification: Notification) {
            binding.apply {
                titleText.text = notification.title
                messageText.text = notification.message
                
                val dateFormat = SimpleDateFormat("dd/MM/yyyy HH:mm", Locale.getDefault())
                dateText.text = dateFormat.format(Date(notification.createdAt))
                
                // Type badge
                typeBadge.text = when (notification.type) {
                    "fee_created" -> "Aidat"
                    "payment_reminder" -> "Hatırlatma"
                    "late_payment" -> "Gecikme"
                    "water_bill" -> "Su Faturası"
                    else -> "Genel"
                }
                
                // Read status indicator
                if (notification.isRead) {
                    root.alpha = 0.7f
                } else {
                    root.alpha = 1.0f
                    unreadIndicator.visibility = android.view.View.VISIBLE
                }
                
                root.setOnClickListener {
                    onItemClick(notification)
                }
            }
        }
    }

    class NotificationDiffCallback : DiffUtil.ItemCallback<Notification>() {
        override fun areItemsTheSame(oldItem: Notification, newItem: Notification): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Notification, newItem: Notification): Boolean {
            return oldItem == newItem
        }
    }
}

