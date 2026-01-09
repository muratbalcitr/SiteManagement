package com.balancetech.sitemanagement.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.balancetech.sitemanagement.data.datasource.LocalDataSource
import com.balancetech.sitemanagement.data.entity.WaterMeter
import com.balancetech.sitemanagement.databinding.ItemWaterMeterBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.text.SimpleDateFormat
import java.util.*

class WaterMeterAdapter(
    private val onItemClick: (WaterMeter) -> Unit,
    private val onReadingClick: (WaterMeter) -> Unit,
    private val localDataSource: LocalDataSource
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
                meterNumberText.text = "Sayaç: ${waterMeter.meterNumber}"
                currentReadingText.text = String.format("Güncel: %.2f m³", waterMeter.currentReading)
                previousReadingText.text = String.format("Önceki: %.2f m³", waterMeter.previousReading)
                
                val consumption = waterMeter.currentReading - waterMeter.previousReading
                consumptionText.text = String.format("Tüketim: %.2f m³", consumption)
                
                val dateFormat = SimpleDateFormat("dd/MM/yyyy", Locale.getDefault())
                lastReadingDateText.text = "Son: ${dateFormat.format(Date(waterMeter.lastReadingDate))}"
                
                unitPriceText.text = String.format("Fiyat: %.2f ₺/m³", waterMeter.unitPrice)
                
                // Load unit information
                CoroutineScope(Dispatchers.Main).launch {
                    val unit = localDataSource.getUnitById(waterMeter.unitId)
                    if (unit != null) {
                        // Format unit number (e.g., "A1" -> "A/1", "B5" -> "B/5")
                        val unitNumber = unit.unitNumber.let { num ->
                            if (num.length > 1 && num[0].isLetter() && num.substring(1).all { it.isDigit() }) {
                                "${num[0]}/${num.substring(1)}"
                            } else {
                                num
                            }
                        }
                        // Format with owner name if available
                        val unitDisplayText = if (unit.ownerName != null && unit.ownerName.isNotEmpty()) {
                            "$unitNumber - ${unit.ownerName}"
                        } else {
                            unitNumber
                        }
                        // Check if unitNumberText exists (it should be in the layout)
                        try {
                            val unitNumberTextView = binding.root.findViewById<android.widget.TextView>(com.balancetech.sitemanagement.R.id.unitNumberText)
                            unitNumberTextView?.text = "Daire: $unitDisplayText"
                        } catch (e: Exception) {
                            // TextView might not exist in older layouts
                        }
                    } else {
                        try {
                            val unitNumberTextView = binding.root.findViewById<android.widget.TextView>(com.balancetech.sitemanagement.R.id.unitNumberText)
                            unitNumberTextView?.text = "Daire: Bilinmiyor"
                        } catch (e: Exception) {
                            // TextView might not exist
                        }
                    }
                }
                
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



