package com.balancetech.sitemanagement.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.balancetech.sitemanagement.data.entity.Unit
import com.balancetech.sitemanagement.databinding.ItemUnitCheckboxBinding

class UnitCheckboxAdapter(
    private val onUnitChecked: (String, Boolean) -> Unit
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
                unitCheckbox.text = "Daire ${unit.unitNumber}${if (unit.ownerName != null) " - ${unit.ownerName}" else ""}"
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

