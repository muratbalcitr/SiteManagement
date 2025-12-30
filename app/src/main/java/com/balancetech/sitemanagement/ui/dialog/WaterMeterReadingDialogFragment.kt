package com.balancetech.sitemanagement.ui.dialog

import android.app.Dialog
import android.os.Bundle
import android.widget.Toast
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.balancetech.sitemanagement.databinding.DialogWaterMeterReadingBinding
import com.balancetech.sitemanagement.ui.viewmodel.WaterMeterViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class WaterMeterReadingDialogFragment : DialogFragment() {
    private var _binding: DialogWaterMeterReadingBinding? = null
    private val binding get() = _binding!!
    private val viewModel: WaterMeterViewModel by viewModels()
    
    private var onReadingRecordedListener: (() -> Unit)? = null
    
    companion object {
        private const val ARG_UNIT_ID = "unit_id"
        private const val ARG_PREVIOUS_READING = "previous_reading"
        
        fun newInstance(unitId: String, previousReading: Double): WaterMeterReadingDialogFragment {
            return WaterMeterReadingDialogFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_UNIT_ID, unitId)
                    putDouble(ARG_PREVIOUS_READING, previousReading)
                }
            }
        }
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        _binding = DialogWaterMeterReadingBinding.inflate(layoutInflater)
        
        val dialog = Dialog(requireContext())
        dialog.setContentView(binding.root)
        dialog.window?.setLayout(
            android.view.ViewGroup.LayoutParams.MATCH_PARENT,
            android.view.ViewGroup.LayoutParams.WRAP_CONTENT
        )
        
        val previousReading = arguments?.getDouble(ARG_PREVIOUS_READING) ?: 0.0
        binding.previousReadingText.text = String.format("Önceki Okuma: %.2f m³", previousReading)
        
        setupButtons()
        observeViewModel()
        
        return dialog
    }

    private fun setupButtons() {
        binding.recordButton.setOnClickListener {
            recordReading()
        }
        
        binding.cancelButton.setOnClickListener {
            dismiss()
        }
    }

    private fun recordReading() {
        val unitId = arguments?.getString(ARG_UNIT_ID) ?: return
        val previousReading = arguments?.getDouble(ARG_PREVIOUS_READING) ?: 0.0
        val currentReadingText = binding.currentReadingEditText.text.toString().trim()
        
        if (currentReadingText.isEmpty()) {
            Toast.makeText(requireContext(), "Lütfen güncel okumayı girin", Toast.LENGTH_SHORT).show()
            return
        }
        
        val currentReading = currentReadingText.toDoubleOrNull()
        if (currentReading == null || currentReading < 0) {
            Toast.makeText(requireContext(), "Geçerli bir okuma değeri girin", Toast.LENGTH_SHORT).show()
            return
        }
        
        if (currentReading < previousReading) {
            Toast.makeText(requireContext(), "Güncel okuma önceki okumadan küçük olamaz", Toast.LENGTH_SHORT).show()
            return
        }
        
        viewModel.recordReading(unitId, currentReading)
    }

    private fun observeViewModel() {
        lifecycleScope.launch {
            viewModel.uiState.collect { state ->
                when (state) {
                    is com.balancetech.sitemanagement.ui.viewmodel.WaterMeterUiState.Success -> {
                        Toast.makeText(requireContext(), state.message, Toast.LENGTH_SHORT).show()
                        onReadingRecordedListener?.invoke()
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

    fun setOnReadingRecordedListener(listener: () -> Unit) {
        onReadingRecordedListener = listener
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}

