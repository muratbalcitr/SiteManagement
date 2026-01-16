package com.balancetech.sitemanagement.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.balancetech.sitemanagement.data.model.FeeMonthSummary
import com.balancetech.sitemanagement.data.model.PaymentStatus
import com.balancetech.sitemanagement.databinding.ItemFeeMonthBinding

class FeeMonthAdapter(
    private val onItemClick: (FeeMonthSummary) -> Unit
) : ListAdapter<FeeMonthSummary, FeeMonthAdapter.FeeMonthViewHolder>(FeeMonthDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FeeMonthViewHolder {
        val binding = ItemFeeMonthBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return FeeMonthViewHolder(binding)
    }

    override fun onBindViewHolder(holder: FeeMonthViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    inner class FeeMonthViewHolder(
        private val binding: ItemFeeMonthBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(summary: FeeMonthSummary) {

            binding.apply {
                monthYearText.text = "${summary.monthName} ${summary.year}"
                
                totalAmountText.text = String.format("%.2f ₺", summary.totalAmount)
                paidAmountText.text = String.format("%.2f ₺", summary.totalPaidAmount)
                
                // Show remaining amount only if there are unpaid fees
                // Hide for months where all fees are partially paid or fully paid
                val hasUnpaidFees = summary.fees.any { it.status == PaymentStatus.UNPAID }
                if (hasUnpaidFees && summary.totalRemainingAmount > 0) {
                    remainingAmountText.visibility = android.view.View.VISIBLE
                    remainingAmountText.text = String.format("%.2f ₺", summary.totalRemainingAmount)
                } else {
                    // Hide remaining amount for months with only partially paid or fully paid fees
                    remainingAmountText.visibility = android.view.View.GONE
                }
                
                 // Show filtered fee count (not all fees)
                feeCountText.text = "${summary.filteredCount} daire"
                
                root.setOnClickListener {
                    onItemClick(summary)
                }
            }
        }
    }

    class FeeMonthDiffCallback : DiffUtil.ItemCallback<FeeMonthSummary>() {
        override fun areItemsTheSame(oldItem: FeeMonthSummary, newItem: FeeMonthSummary): Boolean {
            return oldItem.month == newItem.month && oldItem.year == newItem.year
        }

        override fun areContentsTheSame(oldItem: FeeMonthSummary, newItem: FeeMonthSummary): Boolean {
            return oldItem == newItem
        }
    }
}

