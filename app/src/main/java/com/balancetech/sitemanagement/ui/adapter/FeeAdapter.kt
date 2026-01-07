package com.balancetech.sitemanagement.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.balancetech.sitemanagement.data.datasource.LocalDataSource
import com.balancetech.sitemanagement.data.entity.Fee
import com.balancetech.sitemanagement.data.model.PaymentStatus
import com.balancetech.sitemanagement.databinding.ItemFeeBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.text.SimpleDateFormat
import java.util.*

class FeeAdapter(
    private val onItemClick: (Fee) -> Unit,
    private val onPaymentClick: (Fee) -> Unit,
    private val localDataSource: LocalDataSource
) : ListAdapter<Fee, FeeAdapter.FeeViewHolder>(FeeDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FeeViewHolder {
        val binding = ItemFeeBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return FeeViewHolder(binding)
    }

    override fun onBindViewHolder(holder: FeeViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    inner class FeeViewHolder(
        private val binding: ItemFeeBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(fee: Fee) {
            binding.apply {
                val monthNames = arrayOf(
                    "Ocak", "Şubat", "Mart", "Nisan", "Mayıs", "Haziran",
                    "Temmuz", "Ağustos", "Eylül", "Ekim", "Kasım", "Aralık"
                )
                
                feeMonthYear.text = "${monthNames.getOrNull(fee.month - 1) ?: fee.month.toString()} ${fee.year}"
                feeAmount.text = String.format("%.2f ₺", fee.amount)
                paidAmount.text = String.format("Ödenen: %.2f ₺", fee.paidAmount)
                
                val remainingAmount = fee.amount - fee.paidAmount
                remainingAmountText.text = String.format("Kalan: %.2f ₺", remainingAmount)
                
                val dateFormat = SimpleDateFormat("dd/MM/yyyy", Locale.getDefault())
                dueDateText.text = "Son Ödeme: ${dateFormat.format(Date(fee.dueDate))}"
                
                // Load unit and owner information
                CoroutineScope(Dispatchers.Main).launch {
                    val unit = localDataSource.getUnitById(fee.unitId)
                    if (unit != null) {
                        // Format unit number (e.g., "A1" -> "A/1", "B5" -> "B/5")
                        val unitNumber = unit.unitNumber.let { num ->
                            if (num.length > 1 && num[0].isLetter() && num.substring(1).all { it.isDigit() }) {
                                "${num[0]}/${num.substring(1)}"
                            } else {
                                num
                            }
                        }
                        unitNumberText.text = "Daire: $unitNumber"
                        
                        // Get owner name(s) from UserUnit table
                        try {
                            val userUnitIds = localDataSource.getUserIdsByUnitId(fee.unitId)
                            
                            if (userUnitIds.isNotEmpty()) {
                                val users = userUnitIds.mapNotNull { userId ->
                                    localDataSource.getUserById(userId)
                                }
                                val ownerNames = users.map { it.name }.distinct()
                                ownerNameText.text = if (ownerNames.isNotEmpty()) {
                                    ownerNames.joinToString(", ")
                                } else {
                                    unit.ownerName ?: "-"
                                }
                            } else {
                                // Fallback to unit.ownerName if no users found
                                ownerNameText.text = unit.ownerName ?: "-"
                            }
                        } catch (e: Exception) {
                            // Fallback to unit.ownerName if error
                            ownerNameText.text = unit.ownerName ?: "-"
                        }
                    } else {
                        unitNumberText.text = "Daire: -"
                        ownerNameText.text = "-"
                    }
                }
                
                // Status badge
                when (fee.status) {
                    PaymentStatus.PAID -> {
                        statusBadge.text = "Ödendi"
                        statusBadge.setBackgroundColor(
                            root.context.getColor(android.R.color.holo_green_light)
                        )
                    }
                    PaymentStatus.PARTIALLY_PAID -> {
                        statusBadge.text = "Kısmi Ödendi"
                        statusBadge.setBackgroundColor(
                            root.context.getColor(android.R.color.holo_orange_light)
                        )
                    }
                    PaymentStatus.UNPAID -> {
                        statusBadge.text = "Ödenmedi"
                        statusBadge.setBackgroundColor(
                            root.context.getColor(android.R.color.holo_red_light)
                        )
                    }
                }
                
                // Enable/disable payment button based on payment status
                val isFullyPaid = fee.status == PaymentStatus.PAID || (fee.paidAmount >= fee.amount)
                paymentButton.isEnabled = !isFullyPaid
                paymentButton.alpha = if (isFullyPaid) 0.5f else 1.0f
                
                root.setOnClickListener {
                    onItemClick(fee)
                }
                
                paymentButton.setOnClickListener {
                    if (!isFullyPaid) {
                        onPaymentClick(fee)
                    }
                }
            }
        }
    }

    class FeeDiffCallback : DiffUtil.ItemCallback<Fee>() {
        override fun areItemsTheSame(oldItem: Fee, newItem: Fee): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Fee, newItem: Fee): Boolean {
            return oldItem == newItem
        }
    }
}

