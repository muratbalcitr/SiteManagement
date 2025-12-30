package com.balancetech.sitemanagement.ui.extrapayments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.balancetech.sitemanagement.data.entity.ExtraPayment
import com.balancetech.sitemanagement.databinding.FragmentExtraPaymentsBinding
import com.balancetech.sitemanagement.ui.adapter.ExtraPaymentAdapter
import com.balancetech.sitemanagement.ui.dialog.CreateExtraPaymentDialogFragment
import com.balancetech.sitemanagement.ui.dialog.PaymentEntryDialogFragment
import com.balancetech.sitemanagement.ui.viewmodel.ExtraPaymentViewModel
import com.google.android.material.snackbar.Snackbar
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch

@AndroidEntryPoint
class ExtraPaymentsFragment : Fragment() {
    private var _binding: FragmentExtraPaymentsBinding? = null
    private val binding get() = _binding!!
    private val viewModel: ExtraPaymentViewModel by viewModels()
    private lateinit var adapter: ExtraPaymentAdapter

    private val APARTMENT_ID = "apt-001" // TODO: Get from current user

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        _binding = FragmentExtraPaymentsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupRecyclerView()
        setupFab()
        observeViewModel()
        loadExtraPayments()
    }

    private fun setupRecyclerView() {
        adapter = ExtraPaymentAdapter(onItemClick = { extraPayment ->
            // Show extra payment details if needed
            showExtraPaymentDetails(extraPayment)
        }, onPaymentClick = { extraPayment ->
            showPaymentDialog(extraPayment)
        })

        binding.extraPaymentsRecyclerView.apply {
            layoutManager = LinearLayoutManager(requireContext())
            this.adapter = this@ExtraPaymentsFragment.adapter
        }
    }

    private fun setupFab() {
        binding.addExtraPaymentFab.setOnClickListener {
            showCreateExtraPaymentDialog()
        }
    }

    private fun loadExtraPayments() {
        lifecycleScope.launch {
            // Load all extra payments (both unit-specific and building-wide)
            viewModel.getAllExtraPayments(APARTMENT_ID).collect { payments ->
                updateList(payments)
            }
        }
    }

    private fun updateList(extraPayments: List<ExtraPayment>) {
        adapter.submitList(extraPayments)
        binding.emptyState.visibility = if (extraPayments.isEmpty()) View.VISIBLE else View.GONE
    }

    private fun observeViewModel() {
        lifecycleScope.launch {
            viewModel.uiState.collect { state ->
                when (state) {
                    is com.balancetech.sitemanagement.ui.viewmodel.ExtraPaymentUiState.Loading -> {
                        binding.progressBar.visibility = View.VISIBLE
                    }

                    is com.balancetech.sitemanagement.ui.viewmodel.ExtraPaymentUiState.Success -> {
                        binding.progressBar.visibility = View.GONE
                        Snackbar.make(binding.root, state.message, Snackbar.LENGTH_SHORT).show()
                        loadExtraPayments() // Refresh list
                    }

                    is com.balancetech.sitemanagement.ui.viewmodel.ExtraPaymentUiState.Error -> {
                        binding.progressBar.visibility = View.GONE
                        Snackbar.make(binding.root, "Hata: ${state.message}", Snackbar.LENGTH_LONG)
                            .show()
                    }

                    else -> {
                        binding.progressBar.visibility = View.GONE
                    }
                }
            }
        }
    }

    private fun showCreateExtraPaymentDialog() {
        CreateExtraPaymentDialogFragment().apply {
            setOnExtraPaymentCreatedListener {
                loadExtraPayments()
            }
        }.show(parentFragmentManager, "CreateExtraPaymentDialog")
    }

    private fun showPaymentDialog(extraPayment: ExtraPayment) {
        val remainingAmount = extraPayment.amount - extraPayment.paidAmount
        PaymentEntryDialogFragment.newInstance(
            unitId = extraPayment.unitId ?: "",
            maxAmount = remainingAmount,
            paymentType = PaymentEntryDialogFragment.PaymentType.EXTRA_PAYMENT,
            extraPaymentId = extraPayment.id
        ).apply {
            setOnPaymentRecordedListener {
                loadExtraPayments()
            }
        }.show(parentFragmentManager, "PaymentEntryDialog")
    }

    private fun showExtraPaymentDetails(extraPayment: ExtraPayment) {
        // TODO: Show details dialog or navigate to detail screen
        Snackbar.make(
            binding.root, "${extraPayment.title}: ${extraPayment.amount} ₺", Snackbar.LENGTH_SHORT
        ).show()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
