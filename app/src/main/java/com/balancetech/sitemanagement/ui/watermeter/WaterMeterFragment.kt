package com.balancetech.sitemanagement.ui.watermeter

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.balancetech.sitemanagement.databinding.FragmentWaterMeterBinding
import com.balancetech.sitemanagement.ui.adapter.WaterBillAdapter
import com.balancetech.sitemanagement.ui.adapter.WaterMeterAdapter
import com.balancetech.sitemanagement.ui.dialog.PaymentEntryDialogFragment
import com.balancetech.sitemanagement.ui.dialog.WaterMeterReadingDialogFragment
import com.balancetech.sitemanagement.ui.viewmodel.WaterMeterViewModel
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.tabs.TabLayout
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class WaterMeterFragment : Fragment() {
    private var _binding: FragmentWaterMeterBinding? = null
    private val binding get() = _binding!!
    private val viewModel: WaterMeterViewModel by viewModels()
    private lateinit var waterMeterAdapter: WaterMeterAdapter
    private lateinit var waterBillAdapter: WaterBillAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentWaterMeterBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        
        setupTabs()
        setupRecyclerViews()
        setupFab()
        observeViewModel()
    }

    private fun setupTabs() {
        binding.tabLayout.addTab(binding.tabLayout.newTab().setText("Su Sayaçları"))
        binding.tabLayout.addTab(binding.tabLayout.newTab().setText("Su Faturaları"))
        
        binding.tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab?) {
                when (tab?.position) {
                    0 -> {
                        binding.waterMeterRecyclerView.visibility = View.VISIBLE
                        binding.waterBillRecyclerView.visibility = View.GONE
                        binding.addWaterMeterFab.visibility = View.VISIBLE
                        binding.emptyStateMeters.visibility = View.GONE
                        binding.emptyStateBills.visibility = View.GONE
                    }
                    1 -> {
                        binding.waterMeterRecyclerView.visibility = View.GONE
                        binding.waterBillRecyclerView.visibility = View.VISIBLE
                        binding.addWaterMeterFab.visibility = View.GONE
                        binding.emptyStateMeters.visibility = View.GONE
                        binding.emptyStateBills.visibility = View.GONE
                    }
                }
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {}
            override fun onTabReselected(tab: TabLayout.Tab?) {}
        })
    }

    private fun setupRecyclerViews() {
        // Water Meter Adapter
        waterMeterAdapter = WaterMeterAdapter(
            onItemClick = { waterMeter ->
                showWaterMeterDetails(waterMeter)
            },
            onReadingClick = { waterMeter ->
                showReadingDialog(waterMeter.unitId, waterMeter.currentReading)
            },
            localDataSource = viewModel.localDataSource
        )
        
        binding.waterMeterRecyclerView.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = waterMeterAdapter
        }

        // Water Bill Adapter
        waterBillAdapter = WaterBillAdapter(
            onItemClick = { waterBill ->
                showWaterBillDetails(waterBill)
            },
            onPaymentClick = { waterBill ->
                showPaymentDialog(waterBill)
            }
        )
        
        binding.waterBillRecyclerView.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = waterBillAdapter
        }
    }

    private fun setupFab() {
        binding.addWaterMeterFab.setOnClickListener {
            showAddWaterMeterDialog()
        }
    }
    
    private fun showAddWaterMeterDialog() {
        com.balancetech.sitemanagement.ui.dialog.AddWaterMeterDialogFragment().apply {
            setOnWaterMeterAddedListener {
                // Refresh list - adapter will update automatically via Flow
                Snackbar.make(binding.root, "Su sayacı eklendi", Snackbar.LENGTH_SHORT).show()
            }
        }.show(parentFragmentManager, "AddWaterMeterDialog")
    }

    private fun observeViewModel() {
        // Observe water meters
        lifecycleScope.launch {
            viewModel.getAllWaterMeters().collect { waterMeters ->
                waterMeterAdapter.submitList(waterMeters)
                binding.emptyStateMeters.visibility = if (waterMeters.isEmpty()) View.VISIBLE else View.GONE
            }
        }

        // Observe water bills
        lifecycleScope.launch {
            viewModel.getAllWaterBills().collect { waterBills ->
                waterBillAdapter.submitList(waterBills)
                binding.emptyStateBills.visibility = if (waterBills.isEmpty()) View.VISIBLE else View.GONE
            }
        }

        // Observe UI state
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

    private fun showReadingDialog(unitId: String, previousReading: Double) {
        WaterMeterReadingDialogFragment.newInstance(unitId, previousReading).apply {
            setOnReadingRecordedListener {
                // Refresh list - adapter will update automatically via Flow
            }
        }.show(parentFragmentManager, "WaterMeterReadingDialog")
    }

    private fun showPaymentDialog(waterBill: com.balancetech.sitemanagement.data.entity.WaterBill) {
        val remainingAmount = waterBill.totalAmount - waterBill.paidAmount
        PaymentEntryDialogFragment.newInstance(
            unitId = waterBill.unitId,
            maxAmount = remainingAmount,
            paymentType = PaymentEntryDialogFragment.PaymentType.WATER_BILL,
            waterBillId = waterBill.id
        ).apply {
            setOnPaymentRecordedListener {
                // Refresh list
                loadWaterBills()
            }
        }.show(parentFragmentManager, "PaymentEntryDialog")
    }

    private fun loadWaterBills() {
        // Bills are automatically loaded via Flow in observeViewModel
    }

    private fun showWaterMeterDetails(waterMeter: com.balancetech.sitemanagement.data.entity.WaterMeter) {
        Snackbar.make(
            binding.root,
            "Sayaç No: ${waterMeter.meterNumber}\nGüncel Okuma: ${waterMeter.currentReading} m³",
            Snackbar.LENGTH_SHORT
        ).show()
    }

    private fun showWaterBillDetails(waterBill: com.balancetech.sitemanagement.data.entity.WaterBill) {
        Snackbar.make(
            binding.root,
            "Fatura: ${waterBill.month}/${waterBill.year}\nTutar: ${waterBill.totalAmount} ₺",
            Snackbar.LENGTH_SHORT
        ).show()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
