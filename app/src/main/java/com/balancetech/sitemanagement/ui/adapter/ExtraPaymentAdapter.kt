package com.balancetech.sitemanagement.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.balancetech.sitemanagement.data.entity.ExtraPayment
import com.balancetech.sitemanagement.databinding.ItemExtraPaymentBinding
import java.text.SimpleDateFormat
import java.util.*

class ExtraPaymentAdapter(
    private val onItemClick: (ExtraPayment) -> Unit,
    private val onPaymentClick: (ExtraPayment) -> Unit
) : ListAdapter<ExtraPayment, ExtraPaymentAdapter.ExtraPaymentViewHolder>(ExtraPaymentDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ExtraPaymentViewHolder {
        val binding = ItemExtraPaymentBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return ExtraPaymentViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ExtraPaymentViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    inner class ExtraPaymentViewHolder(
        private val binding: ItemExtraPaymentBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(extraPayment: ExtraPayment) {
            binding.apply {
                titleText.text = extraPayment.title
                descriptionText.text = extraPayment.description ?: ""
                descriptionText.visibility = if (extraPayment.description.isNullOrEmpty()) {
                    android.view.View.GONE
                } else {
                    android.view.View.VISIBLE
                }
                
                amountText.text = "${extraPayment.amount} ₺"
                paidAmountText.text = "Ödenen: ${extraPayment.paidAmount} ₺"
                remainingAmountText.text = "Kalan: ${extraPayment.amount - extraPayment.paidAmount} ₺"
                
                // Status badge
                when (extraPayment.status) {
                    com.balancetech.sitemanagement.data.model.PaymentStatus.PAID -> {
                        statusBadge.text = "Ödendi"
                        statusBadge.setBackgroundColor(android.graphics.Color.parseColor("#4CAF50"))
                    }
                    com.balancetech.sitemanagement.data.model.PaymentStatus.PARTIALLY_PAID -> {
                        statusBadge.text = "Kısmen Ödendi"
                        statusBadge.setBackgroundColor(android.graphics.Color.parseColor("#FF9800"))
                    }
                    else -> {
                        statusBadge.text = "Ödenmedi"
                        statusBadge.setBackgroundColor(android.graphics.Color.parseColor("#F44336"))
                    }
                }
                
                // Type badge
                typeText.text = when (extraPayment.type) {
                    com.balancetech.sitemanagement.data.model.ExtraPaymentType.MAINTENANCE -> "Bakım"
                    com.balancetech.sitemanagement.data.model.ExtraPaymentType.REPAIR -> "Tadilat"
                    com.balancetech.sitemanagement.data.model.ExtraPaymentType.OTHER -> "Diğer"
                }
                
                // Installment info
                if (extraPayment.installmentCount > 1) {
                    installmentText.text = "Taksit: ${extraPayment.currentInstallment}/${extraPayment.installmentCount}"
                    installmentText.visibility = android.view.View.VISIBLE
                } else {
                    installmentText.visibility = android.view.View.GONE
                }
                
                // Due date
                val dateFormat = SimpleDateFormat("dd/MM/yyyy", Locale.getDefault())
                dueDateText.text = "Son Ödeme: ${dateFormat.format(Date(extraPayment.dueDate))}"
                
                // Unit info
                if (extraPayment.unitId != null) {
                    unitInfoText.text = "Daire: ${extraPayment.unitId}"
                    unitInfoText.visibility = android.view.View.VISIBLE
                } else {
                    unitInfoText.text = "Tüm Apartman"
                    unitInfoText.visibility = android.view.View.VISIBLE
                }
                
                root.setOnClickListener { onItemClick(extraPayment) }
                paymentButton.setOnClickListener { onPaymentClick(extraPayment) }
            }
        }
    }

    class ExtraPaymentDiffCallback : DiffUtil.ItemCallback<ExtraPayment>() {
        override fun areItemsTheSame(oldItem: ExtraPayment, newItem: ExtraPayment): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: ExtraPayment, newItem: ExtraPayment): Boolean {
            return oldItem == newItem
        }
    }
}

