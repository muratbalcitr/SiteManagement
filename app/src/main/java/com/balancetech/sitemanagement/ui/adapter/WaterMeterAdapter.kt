package com.balancetech.sitemanagement.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.balancetech.sitemanagement.data.entity.WaterMeter
import com.balancetech.sitemanagement.databinding.ItemWaterMeterBinding
import java.text.SimpleDateFormat
import java.util.*

class WaterMeterAdapter(
    private val onItemClick: (WaterMeter) -> Unit,
    private val onReadingClick: (WaterMeter) -> Unit
) : ListAdapter<WaterMeter, WaterMeterAdapter.WaterMeterViewHolder>(WaterMeterDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WaterMeterViewHolder {
        val binding = ItemWaterMeterBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return WaterMeterViewHolder(binding)
    }

    override fun onBindViewHolder(holder: WaterMeterViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    inner class WaterMeterViewHolder(
        private val binding: ItemWaterMeterBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(waterMeter: WaterMeter) {
            binding.apply {
                meterNumberText.text = "Sayaç No: ${waterMeter.meterNumber}"
                currentReadingText.text = String.format("Güncel Okuma: %.2f m³", waterMeter.currentReading)
                previousReadingText.text = String.format("Önceki Okuma: %.2f m³", waterMeter.previousReading)
                
                val consumption = waterMeter.currentReading - waterMeter.previousReading
                consumptionText.text = String.format("Tüketim: %.2f m³", consumption)
                
                val dateFormat = SimpleDateFormat("dd/MM/yyyy", Locale.getDefault())
                lastReadingDateText.text = "Son Okuma: ${dateFormat.format(Date(waterMeter.lastReadingDate))}"
                
                unitPriceText.text = String.format("Birim Fiyat: %.2f ₺/m³", waterMeter.unitPrice)
                
                root.setOnClickListener {
                    onItemClick(waterMeter)
                }
                
                recordReadingButton.setOnClickListener {
                    onReadingClick(waterMeter)
                }
            }
        }
    }

    class WaterMeterDiffCallback : DiffUtil.ItemCallback<WaterMeter>() {
        override fun areItemsTheSame(oldItem: WaterMeter, newItem: WaterMeter): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: WaterMeter, newItem: WaterMeter): Boolean {
            return oldItem == newItem
        }
    }
}

