package com.balancetech.sitemanagement.ui.watermeter

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.balancetech.sitemanagement.R
import com.balancetech.sitemanagement.data.entity.WaterBill
import com.balancetech.sitemanagement.data.entity.WaterMeter
import com.balancetech.sitemanagement.databinding.FragmentWaterMeterDetailBinding
import com.balancetech.sitemanagement.ui.adapter.WaterBillAdapter
import com.balancetech.sitemanagement.ui.dialog.PaymentEntryDialogFragment
import com.balancetech.sitemanagement.ui.viewmodel.WaterMeterViewModel
import com.balancetech.sitemanagement.util.MeskiBillCalculator
import com.google.android.material.snackbar.Snackbar
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class WaterMeterDetailFragment : Fragment() {
    private var _binding: FragmentWaterMeterDetailBinding? = null
    private val binding get() = _binding!!
    private val viewModel: WaterMeterViewModel by viewModels()
    
    private lateinit var waterBillAdapter: WaterBillAdapter
    private var waterMeter: WaterMeter? = null
    private var unitNumber: String = ""

    companion object {
        private const val ARG_WATER_METER_ID = "water_meter_id"
        private const val ARG_UNIT_ID = "unit_id"

        fun newInstance(waterMeterId: String, unitId: String): WaterMeterDetailFragment {
            return WaterMeterDetailFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_WATER_METER_ID, waterMeterId)
                    putString(ARG_UNIT_ID, unitId)
                }
            }
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentWaterMeterDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        
        val unitId = arguments?.getString(ARG_UNIT_ID) ?: return
        
        binding.toolbar.setNavigationOnClickListener {
            findNavController().navigateUp()
        }
        
        setupRecyclerView()
        loadWaterMeter(unitId)
        observeViewModel(unitId)
    }
    
    private fun setupRecyclerView() {
        waterBillAdapter = WaterBillAdapter(
            onItemClick = { waterBill ->
                showWaterBillDetails(waterBill)
            },
            onPaymentClick = { waterBill ->
                showPaymentDialog(waterBill)
            },
            onDeleteClick = { waterBill ->
                deleteWaterBill(waterBill)
            }
        )
        
        binding.waterBillsRecyclerView.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = waterBillAdapter
        }
    }
    
    private fun loadWaterMeter(unitId: String) {
        lifecycleScope.launch {
            // Get unit info
            val unit = viewModel.localDataSource.getUnitById(unitId)
            if (unit != null) {
                val formattedUnitNumber = unit.unitNumber.let { num ->
                    if (num.length > 1 && num[0].isLetter() && num.substring(1).all { it.isDigit() }) {
                        "${num[0]}/${num.substring(1)}"
                    } else {
                        num
                    }
                }
                unitNumber = formattedUnitNumber
                binding.unitNumberText.text = requireContext().getString(R.string.unit_number_format, formattedUnitNumber)
            }
            
            // Get water meter
            val meter = viewModel.localDataSource.getWaterMeterByUnit(unitId)
            waterMeter = meter
            if (meter != null) {
                binding.meterNumberText.text = requireContext().getString(R.string.meter_number_format, meter.meterNumber)
                binding.currentReadingText.text = String.format(requireContext().getString(R.string.current_reading_format), meter.currentReading)
                binding.previousReadingText.text = String.format(requireContext().getString(R.string.previous_reading_format), meter.previousReading)
                
                val consumption = meter.currentReading - meter.previousReading
                binding.consumptionText.text = String.format(requireContext().getString(R.string.consumption_format), consumption)
                binding.unitPriceText.text = String.format(requireContext().getString(R.string.unit_price_format), meter.unitPrice)
            }
        }
    }
    
    private fun observeViewModel(unitId: String) {
        lifecycleScope.launch {
            viewModel.getWaterBillsByUnit(unitId).collect { waterBills ->
                waterBillAdapter.submitList(waterBills.sortedWith(compareByDescending<WaterBill> { it.year }
                    .thenByDescending { it.month }))
                binding.emptyState.visibility = if (waterBills.isEmpty()) View.VISIBLE else View.GONE
            }
        }
        
        lifecycleScope.launch {
            viewModel.uiState.collect { state ->
                when (state) {
                    is com.balancetech.sitemanagement.ui.viewmodel.WaterMeterUiState.Loading -> {
                        binding.progressBar.visibility = View.VISIBLE
                    }
                    is com.balancetech.sitemanagement.ui.viewmodel.WaterMeterUiState.Success -> {
                        binding.progressBar.visibility = View.GONE
                        Snackbar.make(binding.root, state.message, Snackbar.LENGTH_SHORT).show()
                    }
                    is com.balancetech.sitemanagement.ui.viewmodel.WaterMeterUiState.Error -> {
                        binding.progressBar.visibility = View.GONE
                        Snackbar.make(binding.root, "Hata: ${state.message}", Snackbar.LENGTH_LONG).show()
                    }
                    else -> {
                        binding.progressBar.visibility = View.GONE
                    }
                }
            }
        }
    }
    
    private fun showWaterBillDetails(waterBill: WaterBill) {
        val monthNames = resources.getStringArray(R.array.month_names)
        val monthName = monthNames.getOrNull(waterBill.month - 1) ?: waterBill.month.toString()
        val remaining = waterBill.totalAmount - waterBill.paidAmount
        
        // Create BillCalculationResult from WaterBill
        val subtotal = waterBill.amount + waterBill.wastewaterAmount + waterBill.environmentalTax
        val billResult = MeskiBillCalculator.BillCalculationResult(
            consumption = waterBill.consumption,
            waterAmount = waterBill.amount,
            wastewaterAmount = waterBill.wastewaterAmount,
            environmentalTax = waterBill.environmentalTax,
            subtotal = subtotal,
            vat = waterBill.vat,
            totalAmount = waterBill.totalAmount,
            breakdown = emptyList() // Breakdown not needed for display
        )
        
        // Use formatBillDetails to format the bill details
        val formattedDetails = MeskiBillCalculator.formatBillDetails(billResult)
        
        // Add month/year, paid amount, and remaining amount
        val details = buildString {
            append("$monthName ${waterBill.year}\n\n")
            append(formattedDetails)
            append("\nÖdenen: ${String.format("%.2f", waterBill.paidAmount)} ₺\n")
            append("Kalan: ${String.format("%.2f", remaining)} ₺")
        }
        
        Snackbar.make(
            binding.root,
            details,
            Snackbar.LENGTH_LONG
        ).show()
    }
    
    private fun showPaymentDialog(waterBill: WaterBill) {
        val remainingAmount = waterBill.totalAmount - waterBill.paidAmount
        PaymentEntryDialogFragment.newInstance(
            unitId = waterBill.unitId,
            maxAmount = remainingAmount,
            paymentType = PaymentEntryDialogFragment.PaymentType.WATER_BILL,
            waterBillId = waterBill.id
        ).apply {
            setOnPaymentRecordedListener {
                // Refresh list - adapter will update automatically via Flow
            }
        }.show(parentFragmentManager, "PaymentEntryDialog")
    }
    
    private fun deleteWaterBill(waterBill: WaterBill) {
        val monthNames = resources.getStringArray(R.array.month_names)
        val monthName = monthNames.getOrNull(waterBill.month - 1) ?: waterBill.month.toString()
        
        com.google.android.material.dialog.MaterialAlertDialogBuilder(requireContext())
            .setTitle("Faturayı Sil")
            .setMessage("$monthName ${waterBill.year} faturasını silmek istediğinize emin misiniz?")
            .setPositiveButton("Sil") { _, _ ->
                viewModel.deleteWaterBill(waterBill.id)
            }
            .setNegativeButton("İptal", null)
            .show()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}

