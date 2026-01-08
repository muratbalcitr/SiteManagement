package com.balancetech.sitemanagement.ui.fees

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.balancetech.sitemanagement.R
import com.balancetech.sitemanagement.data.entity.Unit as UnitEntity
import com.balancetech.sitemanagement.data.model.PaymentStatus
import com.balancetech.sitemanagement.databinding.FragmentFeesBinding
import com.balancetech.sitemanagement.ui.adapter.FeeAdapter
import com.balancetech.sitemanagement.ui.adapter.FeeMonthAdapter
import com.balancetech.sitemanagement.data.model.FeeMonthSummary
import com.balancetech.sitemanagement.ui.dialog.CreateFeeDialogFragment
import com.balancetech.sitemanagement.ui.dialog.PaymentEntryDialogFragment
import com.balancetech.sitemanagement.ui.viewmodel.FeeViewModel
import com.balancetech.sitemanagement.util.ExcelExportUtil
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.tabs.TabLayout
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch

@AndroidEntryPoint
class FeesFragment : Fragment() {
    private var _binding: FragmentFeesBinding? = null
    private val binding get() = _binding!!
    private val viewModel: FeeViewModel by viewModels()
    private lateinit var adapter: FeeAdapter
    private lateinit var monthAdapter: FeeMonthAdapter
    private var currentFilter: PaymentStatus? = null
    private var isMonthView: Boolean = true // Default to month view

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentFeesBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        
        setupToolbar()
        setupTabs()
        setupRecyclerView()
        observeViewModel()
        setupFab()
    }
    
    private fun setupToolbar() {
        binding.toolbar.setNavigationOnClickListener {
            if (!isMonthView) {
                // Go back to month view
                isMonthView = true
                binding.feesRecyclerView.adapter = monthAdapter
                binding.toolbar.title = "Aidatlar"
                binding.toolbar.navigationIcon = null
                observeViewModel()
            }
        }
        
        // Setup toolbar menu item clicks
        binding.toolbar.setOnMenuItemClickListener { menuItem ->
            when (menuItem.itemId) {
                R.id.action_export_excel -> {
                    exportToExcel()
                    true
                }
                R.id.action_create_fees_for_all -> {
                    showCreateFeesForAllUnitsDialog()
                    true
                }
                else -> false
            }
        }
    }
    
    private fun setupTabs() {
        binding.tabLayout.addTab(binding.tabLayout.newTab().setText(getString(R.string.unpaid)))
        binding.tabLayout.addTab(binding.tabLayout.newTab().setText(getString(R.string.partially_paid)))
        binding.tabLayout.addTab(binding.tabLayout.newTab().setText(getString(R.string.paid)))
        
        binding.tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab?) {
                currentFilter = when (tab?.position) {
                    0 -> PaymentStatus.UNPAID
                    1 -> PaymentStatus.PARTIALLY_PAID
                    2 -> PaymentStatus.PAID
                    else -> null
                }
                // Reset to month view when tab changes
                isMonthView = true
                binding.feesRecyclerView.adapter = monthAdapter
                observeViewModel()
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {}
            override fun onTabReselected(tab: TabLayout.Tab?) {}
        })
        
        // Set default to first tab (Ödemeyenler)
        currentFilter = PaymentStatus.UNPAID
    }

    private fun setupRecyclerView() {
        adapter = FeeAdapter(
            onItemClick = { fee ->
                // Show fee details if needed
            },
            onPaymentClick = { fee ->
                showPaymentDialog(fee.id, fee.amount - fee.paidAmount)
            },
            localDataSource = viewModel.localDataSource
        )
        
        monthAdapter = FeeMonthAdapter(
            onItemClick = { summary ->
                // Show detailed fees for this month
                showMonthDetails(summary)
            }
        )
        
        binding.feesRecyclerView.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = monthAdapter // Start with month view
        }
    }
    
    private fun showMonthDetails(summary: FeeMonthSummary) {
        // Switch to detail view showing individual fees for this month
        isMonthView = false
        binding.feesRecyclerView.adapter = adapter
        
        // Update toolbar title and show back button
        binding.toolbar.title = "${summary.monthName} ${summary.year} - Detay"
        binding.toolbar.setNavigationIcon( android.R.drawable.arrow_down_float)
        
        lifecycleScope.launch {
            val filteredFees = if (currentFilter != null) {
                summary.fees.filter { fee ->
                    when (currentFilter) {
                        PaymentStatus.UNPAID -> {
                            // Ödemeyenler: Status UNPAID veya paidAmount < amount
                            fee.status == PaymentStatus.UNPAID && fee.paidAmount < fee.amount
                        }
                        PaymentStatus.PARTIALLY_PAID -> {
                            // Kısmi ödeyenler: Status PARTIALLY_PAID veya (paidAmount > 0 && paidAmount < amount)
                            fee.status == PaymentStatus.PARTIALLY_PAID || 
                            (fee.paidAmount > 0 && fee.paidAmount < fee.amount && fee.status != PaymentStatus.PAID)
                        }
                        PaymentStatus.PAID -> {
                            // Ödeyenler: Status PAID veya paidAmount >= amount
                            fee.status == PaymentStatus.PAID || fee.paidAmount >= fee.amount
                        }
                        else -> true
                    }
                }
            } else {
                summary.fees
            }
            adapter.submitList(filteredFees)
            binding.emptyState.visibility = if (filteredFees.isEmpty()) View.VISIBLE else View.GONE
        }
    }

    private fun observeViewModel() {
        lifecycleScope.launch {
            viewModel.getAllFees().map { fees ->
                currentFilter?.let { filter ->
                    fees.filter { fee ->
                        when (filter) {
                            PaymentStatus.UNPAID -> {
                                // Ödemeyenler: Status UNPAID veya paidAmount < amount
                                fee.status == PaymentStatus.UNPAID && fee.paidAmount < fee.amount
                            }
                            PaymentStatus.PARTIALLY_PAID -> {
                                // Kısmi ödeyenler: Status PARTIALLY_PAID veya (paidAmount > 0 && paidAmount < amount)
                                fee.status == PaymentStatus.PARTIALLY_PAID || 
                                (fee.paidAmount > 0 && fee.paidAmount < fee.amount && fee.status != PaymentStatus.PAID)
                            }
                            PaymentStatus.PAID -> {
                                // Ödeyenler: Status PAID veya paidAmount >= amount
                                fee.status == PaymentStatus.PAID || fee.paidAmount >= fee.amount
                            }
                        }
                    }
                } ?: fees
            }.collect { filteredFees ->
                if (isMonthView) {
                    // Group fees by month and year
                    val monthGroups = filteredFees.groupBy { Pair(it.month, it.year) }
                    val monthSummaries = monthGroups.map { (monthYear, feesList) ->
                        FeeMonthSummary(
                            month = monthYear.first,
                            year = monthYear.second,
                            fees = feesList
                        )
                    }.sortedWith(compareByDescending<FeeMonthSummary> { it.year }
                        .thenByDescending { it.month })
                    
                    monthAdapter.submitList(monthSummaries)
                    binding.emptyState.visibility = if (monthSummaries.isEmpty()) View.VISIBLE else View.GONE
                } else {
                    adapter.submitList(filteredFees)
                    binding.emptyState.visibility = if (filteredFees.isEmpty()) View.VISIBLE else View.GONE
                }
            }
        }

        lifecycleScope.launch {
            viewModel.uiState.collect { state ->
                when (state) {
                    is com.balancetech.sitemanagement.ui.viewmodel.FeeUiState.Loading -> {
                        // Loading state handled in dialogs
                    }
                    is com.balancetech.sitemanagement.ui.viewmodel.FeeUiState.Success -> {
                        Snackbar.make(binding.root, state.message, Snackbar.LENGTH_SHORT).show()
                    }
                    is com.balancetech.sitemanagement.ui.viewmodel.FeeUiState.Error -> {
                        Snackbar.make(binding.root, "Hata: ${state.message}", Snackbar.LENGTH_LONG).show()
                    }
                    else -> {}
                }
            }
        }
    }

    private fun setupFab() {
        binding.addFeeFab.setOnClickListener {
            showCreateFeeDialog()
        }
    }
    
    private fun showCreateFeesForAllUnitsDialog() {
        com.balancetech.sitemanagement.ui.dialog.CreateFeesForAllUnitsDialogFragment().apply {
            setOnFeesCreatedListener {
                // Refresh list - adapter will update automatically via Flow
                Snackbar.make(binding.root, "Tüm dairelere aidat oluşturuldu", Snackbar.LENGTH_SHORT).show()
            }
        }.show(parentFragmentManager, "CreateFeesForAllUnitsDialog")
    }
    
    private fun exportToExcel() {
        lifecycleScope.launch {
            try {
                val fees = viewModel.getAllFees().first()
                if (fees.isEmpty()) {
                    Snackbar.make(binding.root, "Aktarılacak aidat bulunamadı", Snackbar.LENGTH_SHORT).show()
                    return@launch
                }
                
                // Get units for mapping
                val unitsMap = mutableMapOf<String, UnitEntity>()
                try {
                    val allUnits = viewModel.getAllUnits("apt-001") // TODO: Get from current user
                    allUnits.forEach { unit ->
                        unitsMap[unit.id] = unit
                    }
                } catch (e: Exception) {
                    android.util.Log.e("FeesFragment", "Error getting units: ${e.message}", e)
                    // Continue even if units can't be loaded - fees will show with N/A for unit info
                }
                
                val result = ExcelExportUtil.exportFeesToExcel(requireContext(), fees, unitsMap)
                
                if (result.isSuccess) {
                    val uri = result.getOrNull()
                    if (uri != null) {
                        try {
                            shareFile(uri)
                            Snackbar.make(binding.root, "Excel dosyası oluşturuldu", Snackbar.LENGTH_SHORT).show()
                        } catch (e: Exception) {
                            android.util.Log.e("FeesFragment", "Error sharing file: ${e.message}", e)
                            Snackbar.make(binding.root, "Dosya oluşturuldu ancak paylaşılamadı: ${e.message}", Snackbar.LENGTH_LONG).show()
                        }
                    } else {
                        Snackbar.make(binding.root, "Dosya URI oluşturulamadı", Snackbar.LENGTH_LONG).show()
                    }
                } else {
                    val exception = result.exceptionOrNull()
                    android.util.Log.e("FeesFragment", "Error exporting to Excel: ${exception?.message}", exception)
                    Snackbar.make(binding.root, "Hata: ${exception?.message ?: "Bilinmeyen hata"}", Snackbar.LENGTH_LONG).show()
                }
            } catch (e: Exception) {
                android.util.Log.e("FeesFragment", "Error in exportToExcel: ${e.message}", e)
                Snackbar.make(binding.root, "Hata: ${e.message ?: "Bilinmeyen hata"}", Snackbar.LENGTH_LONG).show()
            }
        }
    }
    
    private fun shareFile(uri: Uri) {
        val intent = Intent(Intent.ACTION_SEND).apply {
            type = "text/csv"
            putExtra(Intent.EXTRA_STREAM, uri)
            addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION)
        }
        startActivity(Intent.createChooser(intent, "Dosyayı Paylaş"))
    }

    private fun showCreateFeeDialog() {
        CreateFeeDialogFragment().apply {
            setOnFeeCreatedListener { 
                // Refresh list - adapter will update automatically via Flow
            }
        }.show(parentFragmentManager, "CreateFeeDialog")
    }

    private fun showPaymentDialog(feeId: String, remainingAmount: Double) {
        // Get fee to extract unitId - use first() to get current list
        lifecycleScope.launch {
            val fees = viewModel.getAllFees().first()
            val fee = fees.find { it.id == feeId }
            fee?.let {
                PaymentEntryDialogFragment.newInstance(
                    unitId = it.unitId,
                    maxAmount = remainingAmount,
                    paymentType = PaymentEntryDialogFragment.PaymentType.FEE,
                    feeId = feeId
                ).apply {
                    setOnPaymentRecordedListener {
                        // Fee payment status will be updated automatically in PaymentViewModel
                    }
                }.show(parentFragmentManager, "PaymentEntryDialog")
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
