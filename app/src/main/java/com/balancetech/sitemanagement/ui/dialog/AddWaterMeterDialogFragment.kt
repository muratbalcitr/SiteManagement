package com.balancetech.sitemanagement.ui.dialog

import android.app.Dialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.balancetech.sitemanagement.databinding.DialogAddWaterMeterBinding
import com.balancetech.sitemanagement.ui.viewmodel.WaterMeterViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class AddWaterMeterDialogFragment : DialogFragment() {
    private var _binding: DialogAddWaterMeterBinding? = null
    private val binding get() = _binding!!
    private val viewModel: WaterMeterViewModel by viewModels()
    
    private var onWaterMeterAddedListener: (() -> Unit)? = null
    
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        _binding = DialogAddWaterMeterBinding.inflate(layoutInflater)
        
        val dialog = Dialog(requireContext())
        dialog.setContentView(binding.root)
        dialog.window?.setLayout(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.WRAP_CONTENT
        )
        
        setupViews()
        observeViewModel()
        
        return dialog
    }
    
    private fun setupViews() {
        // Load units for spinner
        lifecycleScope.launch {
            val units = viewModel.getAllUnits("apt-001") // TODO: Get from current user
            val unitNames = units.map { "${it.unitNumber} - ${it.blockId?.uppercase() ?: ""}" }
            
            val adapter = ArrayAdapter(
                requireContext(),
                android.R.layout.simple_spinner_item,
                unitNames
            )
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            binding.unitSpinner.adapter = adapter
            
            // Store units list for later use
            binding.unitSpinner.tag = units
        }
        
        binding.saveButton.setOnClickListener {
            saveWaterMeter()
        }
        
        binding.cancelButton.setOnClickListener {
            dismiss()
        }
    }
    
    private fun saveWaterMeter() {
        val units = binding.unitSpinner.tag as? List<com.balancetech.sitemanagement.data.entity.Unit>
        val selectedPosition = binding.unitSpinner.selectedItemPosition
        
        if (units == null || selectedPosition < 0 || selectedPosition >= units.size) {
            Toast.makeText(requireContext(), "Lütfen bir daire seçin", Toast.LENGTH_SHORT).show()
            return
        }
        
        val selectedUnit = units[selectedPosition]
        val meterNumber = binding.meterNumberEditText.text.toString().trim()
        val unitPriceText = binding.unitPriceEditText.text.toString().trim()
        
        if (meterNumber.isEmpty()) {
            Toast.makeText(requireContext(), "Lütfen sayaç numarasını girin", Toast.LENGTH_SHORT).show()
            return
        }
        
        val unitPrice = unitPriceText.toDoubleOrNull()
        if (unitPrice == null || unitPrice < 0) {
            Toast.makeText(requireContext(), "Geçerli bir birim fiyat girin", Toast.LENGTH_SHORT).show()
            return
        }
        
        viewModel.createOrUpdateWaterMeter(
            unitId = selectedUnit.id,
            meterNumber = meterNumber,
            unitPrice = unitPrice
        )
    }
    
    private fun observeViewModel() {
        lifecycleScope.launch {
            viewModel.uiState.collect { state ->
                when (state) {
                    is com.balancetech.sitemanagement.ui.viewmodel.WaterMeterUiState.Success -> {
                        Toast.makeText(requireContext(), state.message, Toast.LENGTH_SHORT).show()
                        onWaterMeterAddedListener?.invoke()
                        dismiss()
                    }
                    is com.balancetech.sitemanagement.ui.viewmodel.WaterMeterUiState.Error -> {
                        Toast.makeText(requireContext(), state.message, Toast.LENGTH_SHORT).show()
                    }
                    else -> {}
                }
            }
        }
    }
    
    fun setOnWaterMeterAddedListener(listener: () -> Unit) {
        onWaterMeterAddedListener = listener
    }
    
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}

