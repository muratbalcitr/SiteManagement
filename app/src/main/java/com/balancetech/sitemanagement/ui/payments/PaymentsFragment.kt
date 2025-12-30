package com.balancetech.sitemanagement.ui.payments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.balancetech.sitemanagement.data.entity.Payment
import com.balancetech.sitemanagement.databinding.FragmentPaymentsBinding
import com.balancetech.sitemanagement.ui.adapter.PaymentAdapter
import com.balancetech.sitemanagement.ui.viewmodel.PaymentViewModel
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.google.android.material.snackbar.Snackbar
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch

@AndroidEntryPoint
class PaymentsFragment : Fragment() {
    private var _binding: FragmentPaymentsBinding? = null
    private val binding get() = _binding!!
    private val viewModel: PaymentViewModel by viewModels()
    private lateinit var adapter: PaymentAdapter
    
    private var currentFilter: PaymentFilter = PaymentFilter.ALL

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentPaymentsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        
        setupRecyclerView()
        setupFilterButtons()
        observeViewModel()
    }

    private fun setupRecyclerView() {
        adapter = PaymentAdapter(
            onItemClick = { payment ->
                showPaymentDetails(payment)
            }
        )
        
        binding.paymentsRecyclerView.apply {
            layoutManager = LinearLayoutManager(requireContext())
            this.adapter = this@PaymentsFragment.adapter
        }
    }

    private fun setupFilterButtons() {
        binding.filterAllButton.setOnClickListener {
            currentFilter = PaymentFilter.ALL
            updateFilterButtons()
            observeViewModel()
        }
        
        binding.filterFeeButton.setOnClickListener {
            currentFilter = PaymentFilter.FEE
            updateFilterButtons()
            observeViewModel()
        }
        
        binding.filterExtraPaymentButton.setOnClickListener {
            currentFilter = PaymentFilter.EXTRA_PAYMENT
            updateFilterButtons()
            observeViewModel()
        }
        
        binding.filterWaterBillButton.setOnClickListener {
            currentFilter = PaymentFilter.WATER_BILL
            updateFilterButtons()
            observeViewModel()
        }
        
        binding.filterGeneralButton.setOnClickListener {
            currentFilter = PaymentFilter.GENERAL
            updateFilterButtons()
            observeViewModel()
        }
    }

    private fun updateFilterButtons() {
        binding.filterAllButton.isSelected = currentFilter == PaymentFilter.ALL
        binding.filterFeeButton.isSelected = currentFilter == PaymentFilter.FEE
        binding.filterExtraPaymentButton.isSelected = currentFilter == PaymentFilter.EXTRA_PAYMENT
        binding.filterWaterBillButton.isSelected = currentFilter == PaymentFilter.WATER_BILL
        binding.filterGeneralButton.isSelected = currentFilter == PaymentFilter.GENERAL
    }

    private fun observeViewModel() {
        lifecycleScope.launch {
            viewModel.getAllPayments().map { payments ->
                when (currentFilter) {
                    PaymentFilter.ALL -> payments
                    PaymentFilter.FEE -> payments.filter { it.feeId != null }
                    PaymentFilter.EXTRA_PAYMENT -> payments.filter { it.extraPaymentId != null }
                    PaymentFilter.WATER_BILL -> payments.filter { it.waterBillId != null }
                    PaymentFilter.GENERAL -> payments.filter { 
                        it.feeId == null && it.extraPaymentId == null && it.waterBillId == null 
                    }
                }
            }.collect { filteredPayments ->
                adapter.submitList(filteredPayments.sortedByDescending { it.paymentDate })
                binding.emptyState.visibility = if (filteredPayments.isEmpty()) View.VISIBLE else View.GONE
            }
        }

        lifecycleScope.launch {
            viewModel.uiState.collect { state ->
                when (state) {
                    is com.balancetech.sitemanagement.ui.viewmodel.PaymentUiState.Loading -> {
                        binding.progressBar.visibility = View.VISIBLE
                    }
                    is com.balancetech.sitemanagement.ui.viewmodel.PaymentUiState.Success -> {
                        binding.progressBar.visibility = View.GONE
                        Snackbar.make(binding.root, state.message, Snackbar.LENGTH_SHORT).show()
                    }
                    is com.balancetech.sitemanagement.ui.viewmodel.PaymentUiState.Error -> {
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

    private fun showPaymentDetails(payment: Payment) {
        val paymentType = when {
            payment.feeId != null -> "Aidat Ödemesi"
            payment.extraPaymentId != null -> "Ek Ödeme"
            payment.waterBillId != null -> "Su Faturası"
            else -> "Genel Ödeme"
        }
        
        val paymentMethod = when (payment.paymentMethod.lowercase()) {
            "cash" -> "Nakit"
            "bank_transfer" -> "Banka Transferi"
            "online" -> "Online Ödeme"
            "check" -> "Çek"
            else -> payment.paymentMethod
        }
        
        val dateFormat = java.text.SimpleDateFormat("dd/MM/yyyy HH:mm", java.util.Locale.getDefault())
        
        MaterialAlertDialogBuilder(requireContext())
            .setTitle("Ödeme Detayları")
            .setMessage(
                """
                Tutar: ${String.format("%.2f", payment.amount)} ₺
                Tip: $paymentType
                Ödeme Yöntemi: $paymentMethod
                Tarih: ${dateFormat.format(java.util.Date(payment.paymentDate))}
                Açıklama: ${payment.description ?: "Yok"}
                Daire ID: ${payment.unitId}
                """.trimIndent()
            )
            .setPositiveButton("Tamam", null)
            .show()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private enum class PaymentFilter {
        ALL, FEE, EXTRA_PAYMENT, WATER_BILL, GENERAL
    }
}
