package com.balancetech.sitemanagement.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.balancetech.sitemanagement.R
import com.balancetech.sitemanagement.data.entity.Unit
import com.balancetech.sitemanagement.databinding.ItemUnitCheckboxBinding

class UnitCheckboxAdapter(
    private val onUnitChecked: (String, Boolean) -> kotlin.Unit
) : ListAdapter<Unit, UnitCheckboxAdapter.UnitViewHolder>(UnitDiffCallback()) {

    private val selectedUnitIds = mutableSetOf<String>()

    fun setSelectedUnits(unitIds: Set<String>) {
        selectedUnitIds.clear()
        selectedUnitIds.addAll(unitIds)
        notifyDataSetChanged()
    }

    fun getSelectedUnits(): Set<String> = selectedUnitIds.toSet()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UnitViewHolder {
        val binding = ItemUnitCheckboxBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return UnitViewHolder(binding)
    }

    override fun onBindViewHolder(holder: UnitViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    inner class UnitViewHolder(
        private val binding: ItemUnitCheckboxBinding
    ) : RecyclerView.ViewHolder(binding.root) {

            fun bind(unit: Unit) {
                binding.apply {
                    unitCheckbox.text = if (unit.ownerName != null) {
                        binding.root.context.getString(R.string.unit_with_owner_format, unit.unitNumber, unit.ownerName)
                    } else {
                        binding.root.context.getString(R.string.unit_format, unit.unitNumber)
                    }
                    unitCheckbox.isChecked = selectedUnitIds.contains(unit.id)
                
                unitCheckbox.setOnCheckedChangeListener { _, isChecked ->
                    if (isChecked) {
                        selectedUnitIds.add(unit.id)
                    } else {
                        selectedUnitIds.remove(unit.id)
                    }
                    onUnitChecked(unit.id, isChecked)
                }
            }
        }
    }

    class UnitDiffCallback : DiffUtil.ItemCallback<Unit>() {
        override fun areItemsTheSame(oldItem: Unit, newItem: Unit): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Unit, newItem: Unit): Boolean {
            return oldItem == newItem
        }
    }
}

