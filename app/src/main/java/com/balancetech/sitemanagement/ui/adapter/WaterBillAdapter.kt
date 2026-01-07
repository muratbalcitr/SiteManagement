package com.balancetech.sitemanagement.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.balancetech.sitemanagement.data.entity.WaterBill
import com.balancetech.sitemanagement.data.model.PaymentStatus
import com.balancetech.sitemanagement.databinding.ItemWaterBillBinding
import java.text.SimpleDateFormat
import java.util.*

class WaterBillAdapter(
    private val onItemClick: (WaterBill) -> Unit,
    private val onPaymentClick: (WaterBill) -> Unit
) : ListAdapter<WaterBill, WaterBillAdapter.WaterBillViewHolder>(WaterBillDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WaterBillViewHolder {
        val binding = ItemWaterBillBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return WaterBillViewHolder(binding)
    }

    override fun onBindViewHolder(holder: WaterBillViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    inner class WaterBillViewHolder(
        private val binding: ItemWaterBillBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(waterBill: WaterBill) {
            binding.apply {
                val monthNames = arrayOf(
                    "Ocak", "Şubat", "Mart", "Nisan", "Mayıs", "Haziran",
                    "Temmuz", "Ağustos", "Eylül", "Ekim", "Kasım", "Aralık"
                )
                
                billMonthYear.text = "${monthNames.getOrNull(waterBill.month - 1) ?: waterBill.month.toString()} ${waterBill.year}"
                totalAmountText.text = String.format("%.2f ₺", waterBill.totalAmount)
                consumptionText.text = String.format("Tüketim: %.2f m³", waterBill.consumption)
                paidAmountText.text = String.format("Ödenen: %.2f ₺", waterBill.paidAmount)
                
                val remainingAmount = waterBill.totalAmount - waterBill.paidAmount
                remainingAmountText.text = String.format("Kalan: %.2f ₺", remainingAmount)
                
                val dateFormat = SimpleDateFormat("dd/MM/yyyy", Locale.getDefault())
                dueDateText.text = "Son Ödeme: ${dateFormat.format(Date(waterBill.dueDate))}"
                
                // Status badge
                when (waterBill.status) {
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
                
                root.setOnClickListener {
                    onItemClick(waterBill)
                }
                
                paymentButton.setOnClickListener {
                    onPaymentClick(waterBill)
                }
            }
        }
    }

    class WaterBillDiffCallback : DiffUtil.ItemCallback<WaterBill>() {
        override fun areItemsTheSame(oldItem: WaterBill, newItem: WaterBill): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: WaterBill, newItem: WaterBill): Boolean {
            return oldItem == newItem
        }
    }
}


