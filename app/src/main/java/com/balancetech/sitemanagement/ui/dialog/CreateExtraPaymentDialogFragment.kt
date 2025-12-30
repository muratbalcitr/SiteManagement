package com.balancetech.sitemanagement.ui.dialog

import android.app.DatePickerDialog
import android.app.Dialog
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.balancetech.sitemanagement.data.model.ExtraPaymentType
import com.balancetech.sitemanagement.databinding.DialogCreateExtraPaymentBinding
import com.balancetech.sitemanagement.ui.viewmodel.ExtraPaymentViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import java.text.SimpleDateFormat
import java.util.*

@AndroidEntryPoint
class CreateExtraPaymentDialogFragment : DialogFragment() {
    private var _binding: DialogCreateExtraPaymentBinding? = null
    private val binding get() = _binding!!
    private val viewModel: ExtraPaymentViewModel by viewModels()
    
    private var onExtraPaymentCreatedListener: (() -> Unit)? = null
    private var selectedDueDate: Long = System.currentTimeMillis()
    
    private   val APARTMENT_ID = "apt-001" // TODO: Get from current user

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        _binding = DialogCreateExtraPaymentBinding.inflate(layoutInflater)
        
        val dialog = Dialog(requireContext())
        dialog.setContentView(binding.root)
        dialog.window?.setLayout(
            android.view.ViewGroup.LayoutParams.MATCH_PARENT,
            android.view.ViewGroup.LayoutParams.WRAP_CONTENT
        )
        
        setupTypeSpinner()
        setupDueDatePicker()
        setupButtons()
        observeViewModel()
        
        return dialog
    }

    private fun setupTypeSpinner() {
        val types = arrayOf("Bakım", "Tadilat", "Diğer")
        val adapter = ArrayAdapter(requireContext(), android.R.layout.simple_spinner_item, types)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        binding.typeSpinner.adapter = adapter
    }

    private fun setupDueDatePicker() {
        val calendar = Calendar.getInstance()
        calendar.timeInMillis = selectedDueDate
        
        binding.dueDateButton.setOnClickListener {
            DatePickerDialog(
                requireContext(),
                { _, year, month, dayOfMonth ->
                    val selectedCalendar = Calendar.getInstance()
                    selectedCalendar.set(year, month, dayOfMonth)
                    selectedDueDate = selectedCalendar.timeInMillis
                    updateDueDateButton()
                },
                calendar.get(Calendar.YEAR),
                calendar.get(Calendar.MONTH),
                calendar.get(Calendar.DAY_OF_MONTH)
            ).show()
        }
        updateDueDateButton()
    }

    private fun updateDueDateButton() {
        val dateFormat = SimpleDateFormat("dd/MM/yyyy", Locale.getDefault())
        binding.dueDateButton.text = dateFormat.format(Date(selectedDueDate))
    }

    private fun setupButtons() {
        binding.createButton.setOnClickListener {
            createExtraPayment()
        }
        
        binding.cancelButton.setOnClickListener {
            dismiss()
        }
    }

    private fun createExtraPayment() {
        val title = binding.titleEditText.text.toString().trim()
        val description = binding.descriptionEditText.text.toString().trim()
        val amountText = binding.amountEditText.text.toString().trim()
        val installmentText = binding.installmentEditText.text.toString().trim()
        val unitId = binding.unitIdEditText.text.toString().trim()
        
        if (title.isEmpty() || amountText.isEmpty()) {
            Toast.makeText(requireContext(), "Lütfen başlık ve tutarı girin", Toast.LENGTH_SHORT).show()
            return
        }
        
        val amount = amountText.toDoubleOrNull()
        if (amount == null || amount <= 0) {
            Toast.makeText(requireContext(), "Geçerli bir tutar girin", Toast.LENGTH_SHORT).show()
            return
        }
        
        val installmentCount = if (installmentText.isEmpty()) {
            1
        } else {
            installmentText.toIntOrNull() ?: 1
        }
        
        if (installmentCount < 1) {
            Toast.makeText(requireContext(), "Taksit sayısı en az 1 olmalıdır", Toast.LENGTH_SHORT).show()
            return
        }
        
        val selectedType = when (binding.typeSpinner.selectedItemPosition) {
            0 -> ExtraPaymentType.MAINTENANCE
            1 -> ExtraPaymentType.REPAIR
            else -> ExtraPaymentType.OTHER
        }
        
        viewModel.createExtraPayment(
            apartmentId = APARTMENT_ID,
            unitId = if (unitId.isEmpty()) null else unitId,
            title = title,
            description = if (description.isEmpty()) null else description,
            amount = amount,
            type = selectedType,
            installmentCount = installmentCount,
            dueDate = selectedDueDate
        )
    }

    private fun observeViewModel() {
        lifecycleScope.launch {
            viewModel.uiState.collect { state ->
                when (state) {
                    is com.balancetech.sitemanagement.ui.viewmodel.ExtraPaymentUiState.Loading -> {
                        binding.progressBar.visibility = View.VISIBLE
                        binding.createButton.isEnabled = false
                    }
                    is com.balancetech.sitemanagement.ui.viewmodel.ExtraPaymentUiState.Success -> {
                        binding.progressBar.visibility = View.GONE
                        binding.createButton.isEnabled = true
                        Toast.makeText(requireContext(), state.message, Toast.LENGTH_SHORT).show()
                        onExtraPaymentCreatedListener?.invoke()
                        dismiss()
                    }
                    is com.balancetech.sitemanagement.ui.viewmodel.ExtraPaymentUiState.Error -> {
                        binding.progressBar.visibility = View.GONE
                        binding.createButton.isEnabled = true
                        Toast.makeText(requireContext(), state.message, Toast.LENGTH_LONG).show()
                    }
                    else -> {
                        binding.progressBar.visibility = View.GONE
                        binding.createButton.isEnabled = true
                    }
                }
            }
        }
    }

    fun setOnExtraPaymentCreatedListener(listener: () -> Unit) {
        onExtraPaymentCreatedListener = listener
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}

