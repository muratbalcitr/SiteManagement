package com.balancetech.sitemanagement.ui.reports

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.balancetech.sitemanagement.databinding.FragmentReportsBinding
import com.balancetech.sitemanagement.ui.viewmodel.ReportsViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class ReportsFragment : Fragment() {
    private var _binding: FragmentReportsBinding? = null
    private val binding get() = _binding!!
    private val viewModel: ReportsViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentReportsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        
        observeViewModel()
        setupSummaryCards()
    }

    private fun setupSummaryCards() {
        // Summary cards will be populated from ViewModel
    }

    private fun observeViewModel() {
        lifecycleScope.launch {
            viewModel.getTotalUnpaidFees().collect { total ->
                binding.totalUnpaidFeesText.text = String.format("%.2f ₺", total)
            }
        }

        lifecycleScope.launch {
            viewModel.getTotalUnpaidWaterBills().collect { total ->
                binding.totalUnpaidWaterBillsText.text = String.format("%.2f ₺", total)
            }
        }

        lifecycleScope.launch {
            viewModel.getMonthlyPaymentSummary().collect { summary ->
                // Update charts or summary views
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}



