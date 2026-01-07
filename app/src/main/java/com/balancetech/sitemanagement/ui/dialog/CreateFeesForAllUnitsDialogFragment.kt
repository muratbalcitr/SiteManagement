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
import com.balancetech.sitemanagement.databinding.DialogCreateFeesForAllUnitsBinding
import com.balancetech.sitemanagement.ui.viewmodel.FeeViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import java.text.SimpleDateFormat
import java.util.*

@AndroidEntryPoint
class CreateFeesForAllUnitsDialogFragment : DialogFragment() {
    private var _binding: DialogCreateFeesForAllUnitsBinding? = null
    private val binding get() = _binding!!
    private val viewModel: FeeViewModel by viewModels()
    
    private var onFeesCreatedListener: (() -> Unit)? = null
    private var selectedDueDate: Long = System.currentTimeMillis()
    private var selectedMonth: Int = Calendar.getInstance().get(Calendar.MONTH) + 1
    private var selectedYear: Int = Calendar.getInstance().get(Calendar.YEAR)
    
    private  val APARTMENT_ID = "apt-001" // TODO: Get from current user

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        _binding = DialogCreateFeesForAllUnitsBinding.inflate(layoutInflater)
        
        val dialog = Dialog(requireContext())
        dialog.setContentView(binding.root)
        dialog.window?.setLayout(
            android.view.ViewGroup.LayoutParams.MATCH_PARENT,
            android.view.ViewGroup.LayoutParams.WRAP_CONTENT
        )
        
        setupMonthSpinner()
        setupYearSpinner()
        setupDueDatePicker()
        setupButtons()
        observeViewModel()
        
        return dialog
    }

    private fun setupMonthSpinner() {
        val months = arrayOf(
            "Ocak", "Şubat", "Mart", "Nisan", "Mayıs", "Haziran",
            "Temmuz", "Ağustos", "Eylül", "Ekim", "Kasım", "Aralık"
        )
        val adapter = ArrayAdapter(requireContext(), android.R.layout.simple_spinner_item, months)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        binding.monthSpinner.adapter = adapter
        binding.monthSpinner.setSelection(selectedMonth - 1)
    }

    private fun setupYearSpinner() {
        val currentYear = Calendar.getInstance().get(Calendar.YEAR)
        val years = (currentYear - 1..currentYear + 1).toList()
        val adapter = ArrayAdapter(requireContext(), android.R.layout.simple_spinner_item, years)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        binding.yearSpinner.adapter = adapter
        binding.yearSpinner.setSelection(years.indexOf(currentYear))
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
            createFeesForAllUnits()
        }
        
        binding.cancelButton.setOnClickListener {
            dismiss()
        }
    }

    private fun createFeesForAllUnits() {
        val amountText = binding.baseAmountEditText.text.toString().trim()
        
        if (amountText.isEmpty()) {
            Toast.makeText(requireContext(), "Lütfen temel tutarı girin", Toast.LENGTH_SHORT).show()
            return
        }
        
        val baseAmount = amountText.toDoubleOrNull()
        if (baseAmount == null || baseAmount <= 0) {
            Toast.makeText(requireContext(), "Geçerli bir tutar girin", Toast.LENGTH_SHORT).show()
            return
        }
        
        selectedMonth = binding.monthSpinner.selectedItemPosition + 1
        selectedYear = binding.yearSpinner.selectedItem as Int
        
        // Show confirmation dialog
        android.app.AlertDialog.Builder(requireContext())
            .setTitle("Tüm Dairelere Aidat Oluştur")
            .setMessage("Tüm dairelere ${selectedMonth}. ay ${selectedYear} için aidat oluşturulacak. Devam etmek istiyor musunuz?")
            .setPositiveButton("Evet") { _, _ ->
                viewModel.createFeesForAllUnits(
                    apartmentId = APARTMENT_ID,
                    month = selectedMonth,
                    year = selectedYear,
                    baseAmount = baseAmount,
                    dueDate = selectedDueDate
                )
            }
            .setNegativeButton("Hayır", null)
            .show()
    }

    private fun observeViewModel() {
        lifecycleScope.launch {
            viewModel.uiState.collect { state ->
                when (state) {
                    is com.balancetech.sitemanagement.ui.viewmodel.FeeUiState.Loading -> {
                        binding.progressBar.visibility = View.VISIBLE
                        binding.createButton.isEnabled = false
                    }
                    is com.balancetech.sitemanagement.ui.viewmodel.FeeUiState.Success -> {
                        binding.progressBar.visibility = View.GONE
                        binding.createButton.isEnabled = true
                        Toast.makeText(requireContext(), state.message, Toast.LENGTH_SHORT).show()
                        onFeesCreatedListener?.invoke()
                        dismiss()
                    }
                    is com.balancetech.sitemanagement.ui.viewmodel.FeeUiState.Error -> {
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

    fun setOnFeesCreatedListener(listener: () -> Unit) {
        onFeesCreatedListener = listener
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}



