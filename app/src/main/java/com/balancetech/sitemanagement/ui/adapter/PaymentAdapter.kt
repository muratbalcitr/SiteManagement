package com.balancetech.sitemanagement.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.balancetech.sitemanagement.data.entity.Payment
import com.balancetech.sitemanagement.databinding.ItemPaymentBinding
import java.text.SimpleDateFormat
import java.util.*

class PaymentAdapter(
    private val onItemClick: (Payment) -> Unit
) : ListAdapter<Payment, PaymentAdapter.PaymentViewHolder>(PaymentDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PaymentViewHolder {
        val binding = ItemPaymentBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return PaymentViewHolder(binding)
    }

    override fun onBindViewHolder(holder: PaymentViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    inner class PaymentViewHolder(
        private val binding: ItemPaymentBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(payment: Payment) {
            binding.apply {
                amountText.text = String.format("%.2f ₺", payment.amount)
                
                val dateFormat = SimpleDateFormat("dd/MM/yyyy HH:mm", Locale.getDefault())
                dateText.text = dateFormat.format(Date(payment.paymentDate))
                
                paymentMethodText.text = when (payment.paymentMethod.lowercase()) {
                    "cash" -> "Nakit"
                    "bank_transfer" -> "Banka Transferi"
                    "online" -> "Online Ödeme"
                    "check" -> "Çek"
                    else -> payment.paymentMethod
                }
                
                // Description
                if (payment.description.isNullOrEmpty()) {
                    descriptionText.visibility = android.view.View.GONE
                } else {
                    descriptionText.text = payment.description
                    descriptionText.visibility = android.view.View.VISIBLE
                }
                
                // Payment type indicator
                val paymentType = when {
                    payment.feeId != null -> "Aidat Ödemesi"
                    payment.extraPaymentId != null -> "Ek Ödeme"
                    payment.waterBillId != null -> "Su Faturası"
                    else -> "Genel Ödeme"
                }
                paymentTypeText.text = paymentType
                
                root.setOnClickListener {
                    onItemClick(payment)
                }
            }
        }
    }

    class PaymentDiffCallback : DiffUtil.ItemCallback<Payment>() {
        override fun areItemsTheSame(oldItem: Payment, newItem: Payment): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Payment, newItem: Payment): Boolean {
            return oldItem == newItem
        }
    }
}

