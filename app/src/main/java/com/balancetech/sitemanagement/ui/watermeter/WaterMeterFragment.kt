package com.balancetech.sitemanagement.ui.watermeter

import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import androidx.activity.result.contract.ActivityResultContracts
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.balancetech.sitemanagement.R
import com.balancetech.sitemanagement.databinding.FragmentWaterMeterBinding
import com.balancetech.sitemanagement.ui.adapter.WaterBillAdapter
import com.balancetech.sitemanagement.ui.adapter.WaterMeterAdapter
import com.balancetech.sitemanagement.ui.dialog.PaymentEntryDialogFragment
import com.balancetech.sitemanagement.ui.dialog.WaterMeterReadingDialogFragment
import com.balancetech.sitemanagement.ui.viewmodel.WaterMeterViewModel
import com.balancetech.sitemanagement.util.ExcelExportUtil
import com.balancetech.sitemanagement.util.ExcelImportUtil
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.tabs.TabLayout
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch

@AndroidEntryPoint
class WaterMeterFragment : Fragment() {
    private var _binding: FragmentWaterMeterBinding? = null
    private val binding get() = _binding!!
    private val viewModel: WaterMeterViewModel by viewModels()
    private lateinit var waterMeterAdapter: WaterMeterAdapter
    private lateinit var waterBillAdapter: WaterBillAdapter
    
    private val importFileLauncher = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()
    ) { result ->
        if (result.resultCode == Activity.RESULT_OK) {
            result.data?.data?.let { uri ->
                importWaterMetersFromExcel(uri)
            }
        }
    }

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
        
        setupToolbar()
        setupTabs()
        setupRecyclerViews()
        setupFab()
        observeViewModel()
    }
    
    private fun setupToolbar() {
        binding.toolbar.inflateMenu(R.menu.water_meter_toolbar_menu)
        binding.toolbar.setOnMenuItemClickListener { item ->
            when (item.itemId) {
                R.id.action_import_water_meters -> {
                    openFilePicker()
                    true
                }
                R.id.action_export_water_meters -> {
                    exportWaterMetersToExcel()
                    true
                }
                else -> false
            }
        }
    }
    
    private fun openFilePicker() {
        val intent = Intent(Intent.ACTION_GET_CONTENT).apply {
            type = "*/*"
            addCategory(Intent.CATEGORY_OPENABLE)
        }
        val chooser = Intent.createChooser(intent, "Su Sayacı Dosyası Seçin")
        importFileLauncher.launch(chooser)
    }
    
    private fun importWaterMetersFromExcel(uri: Uri) {
        lifecycleScope.launch {
            try {
                binding.progressBar.visibility = View.VISIBLE
                
                // Get all units to create a lookup map
                val units = viewModel.localDataSource.getUnitsByApartment("apt-001") // TODO: Get from current user
                val unitMap = units.associateBy { it.unitNumber }
                
                val result = ExcelImportUtil.importWaterMetersFromCsv(
                    requireContext(),
                    uri,
                    "apt-001", // TODO: Get from current user
                    getUnitIdByNumber = { unitNumber ->
                        unitMap[unitNumber]?.id
                    }
                )
                
                if (result.isSuccess) {
                    val (waterMeters, importResult) = result.getOrNull()!!
                    
                    if (waterMeters.isNotEmpty()) {
                        val message = buildString {
                            append("${importResult.successCount} su sayacı içe aktarılacak")
                            if (importResult.errorCount > 0) {
                                append("\n${importResult.errorCount} satırda hata var")
                            }
                            if (importResult.errors.isNotEmpty()) {
                                append("\n\nHatalar:\n")
                                importResult.errors.take(5).forEach { error ->
                                    append("• $error\n")
                                }
                                if (importResult.errors.size > 5) {
                                    append("... ve ${importResult.errors.size - 5} hata daha")
                                }
                            }
                        }
                        
                        MaterialAlertDialogBuilder(requireContext())
                            .setTitle("Su Sayaçlarını İçe Aktar")
                            .setMessage(message)
                            .setPositiveButton("İçe Aktar") { _, _ ->
                                lifecycleScope.launch {
                                    viewModel.importWaterMeters(waterMeters)
                                }
                            }
                            .setNegativeButton("İptal", null)
                            .show()
                    } else {
                        Snackbar.make(
                            binding.root,
                            "İçe aktarılacak su sayacı bulunamadı",
                            Snackbar.LENGTH_SHORT
                        ).show()
                    }
                } else {
                    Snackbar.make(
                        binding.root,
                        "Hata: ${result.exceptionOrNull()?.message}",
                        Snackbar.LENGTH_LONG
                    ).show()
                }
            } catch (e: Exception) {
                Snackbar.make(
                    binding.root,
                    "Hata: ${e.message}",
                    Snackbar.LENGTH_LONG
                ).show()
            } finally {
                binding.progressBar.visibility = View.GONE
            }
        }
    }
    
    private fun exportWaterMetersToExcel() {
        lifecycleScope.launch {
            try {
                binding.progressBar.visibility = View.VISIBLE
                
                // Get all water meters
                val waterMeters = viewModel.getAllWaterMeters().first()
                if (waterMeters.isEmpty()) {
                    Snackbar.make(binding.root, "Aktarılacak su sayacı bulunamadı", Snackbar.LENGTH_SHORT).show()
                    binding.progressBar.visibility = View.GONE
                    return@launch
                }
                
                // Get all units to map unitId to unit info
                val units = viewModel.localDataSource.getUnitsByApartment("apt-001") // TODO: Get from current user
                val unitsMap = units.associateBy { it.id }
                
                val result = ExcelExportUtil.exportWaterMetersToExcel(requireContext(), waterMeters, unitsMap)
                
                if (result.isSuccess) {
                    val uri = result.getOrNull()
                    if (uri != null) {
                        shareFile(uri)
                        Snackbar.make(binding.root, "Su sayacı listesi Excel dosyası oluşturuldu", Snackbar.LENGTH_SHORT).show()
                    }
                } else {
                    Snackbar.make(binding.root, "Hata: ${result.exceptionOrNull()?.message}", Snackbar.LENGTH_LONG).show()
                }
            } catch (e: Exception) {
                Snackbar.make(binding.root, "Hata: ${e.message}", Snackbar.LENGTH_LONG).show()
            } finally {
                binding.progressBar.visibility = View.GONE
            }
        }
    }
    
    private fun shareFile(uri: Uri) {
        val shareIntent = Intent(Intent.ACTION_SEND).apply {
            type = "text/csv"
            putExtra(Intent.EXTRA_STREAM, uri)
            addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION)
        }
        startActivity(Intent.createChooser(shareIntent, "Dosyayı Paylaş"))
    }

    private fun setupTabs() {
        binding.emptyStateMeters.visibility = View.GONE
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
            layoutManager = androidx.recyclerview.widget.GridLayoutManager(requireContext(), 2)
            adapter = waterMeterAdapter
        }

        // Water Bill Adapter
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
                // Sort by unit number in natural order (A1, A2, A3, A10, not A1, A10, A2)
                val sortedMeters = com.balancetech.sitemanagement.util.UnitNumberComparator
                    .sortWaterMetersByUnitNumber(waterMeters, viewModel.localDataSource)
                waterMeterAdapter.submitList(sortedMeters)
            }
        }

        // Observe water bills
        lifecycleScope.launch {
            viewModel.getAllWaterBills().collect { waterBills ->
                // Sort by unit number, then by year and month
                val sortedBills = com.balancetech.sitemanagement.util.UnitNumberComparator
                    .sortWaterBillsByUnitNumber(waterBills, viewModel.localDataSource)
                waterBillAdapter.submitList(sortedBills)
              //  binding.emptyStateBills.visibility = if (waterBills.isEmpty()) View.VISIBLE else View.GONE
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
        // Navigate to detail fragment
        findNavController().navigate(
            R.id.action_waterMeterFragment_to_waterMeterDetailFragment,
            Bundle().apply {
                putString("water_meter_id", waterMeter.id)
                putString("unit_id", waterMeter.unitId)
            }
        )
    }

    private fun showWaterBillDetails(waterBill: com.balancetech.sitemanagement.data.entity.WaterBill) {
        Snackbar.make(
            binding.root,
            "Fatura: ${waterBill.month}/${waterBill.year}\nTutar: ${waterBill.totalAmount} ₺",
            Snackbar.LENGTH_SHORT
        ).show()
    }
    
    private fun deleteWaterBill(waterBill: com.balancetech.sitemanagement.data.entity.WaterBill) {
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
