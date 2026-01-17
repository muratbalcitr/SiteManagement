package com.balancetech.sitemanagement.ui.banktransactions

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.result.contract.ActivityResultContracts
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.balancetech.sitemanagement.databinding.FragmentBankTransactionsBinding
import com.balancetech.sitemanagement.ui.adapter.BankTransactionAdapter
import com.balancetech.sitemanagement.util.ExcelImportUtil
import com.google.android.material.snackbar.Snackbar
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class BankTransactionsFragment : Fragment() {
    private var _binding: FragmentBankTransactionsBinding? = null
    private val binding get() = _binding!!
    private lateinit var adapter: BankTransactionAdapter
    private var transactions: List<com.balancetech.sitemanagement.data.entity.BankTransaction> = emptyList()
    
    private val filePickerLauncher = registerForActivityResult(
        ActivityResultContracts.GetContent()
    ) { uri: Uri? ->
        uri?.let {
            importTransactionsFromFile(it)
        }
    }
    
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentBankTransactionsBinding.inflate(inflater, container, false)
        return binding.root
    }
    
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        
        setupToolbar()
        setupRecyclerView()
        setupFab()
    }
    
    private fun setupToolbar() {
        binding.toolbar.title = "Banka Hareketleri"
        binding.toolbar.setNavigationOnClickListener {
            findNavController().popBackStack()
        }
    }
    
    private fun setupRecyclerView() {
        adapter = BankTransactionAdapter()
        binding.transactionsRecyclerView.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = this@BankTransactionsFragment.adapter
        }
        
        updateEmptyState()
    }
    
    private fun setupFab() {
        binding.importFab.setOnClickListener {
            openFilePicker()
        }
    }
    
    private fun openFilePicker() {
        // Accept Excel (.xlsx, .xls) and CSV files
        filePickerLauncher.launch("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet,application/vnd.ms-excel,text/csv,*/*")
    }
    
    private fun importTransactionsFromFile(uri: Uri) {
        binding.progressBar.visibility = View.VISIBLE
        
        CoroutineScope(Dispatchers.Main).launch {
            try {
                val result = withContext(Dispatchers.IO) {
                    ExcelImportUtil.importBankTransactionsFromCsv(requireContext(), uri)
                }
                
                if (result.isSuccess) {
                    val (importedTransactions, importResult) = result.getOrNull()!!
                    transactions = importedTransactions.sortedByDescending { 
                        // Sort by date (newest first)
                        try {
                            val dateFormat = java.text.SimpleDateFormat("dd.MM.yyyy", java.util.Locale.getDefault())
                            dateFormat.parse(it.date)?.time ?: 0L
                        } catch (e: Exception) {
                            0L
                        }
                    }
                    
                    adapter.submitList(transactions)
                    updateEmptyState()
                    
                    val message = if (importResult.errorCount > 0) {
                        "${importResult.successCount} hareket yüklendi, ${importResult.errorCount} hata"
                    } else {
                        "${importResult.successCount} hareket başarıyla yüklendi"
                    }
                    
                    Snackbar.make(binding.root, message, Snackbar.LENGTH_LONG).show()
                } else {
                    val error = result.exceptionOrNull()?.message ?: "Bilinmeyen hata"
                    Snackbar.make(binding.root, "Hata: $error", Snackbar.LENGTH_LONG).show()
                }
            } catch (e: Exception) {
                Snackbar.make(binding.root, "Hata: ${e.message}", Snackbar.LENGTH_LONG).show()
            } finally {
                binding.progressBar.visibility = View.GONE
            }
        }
    }
    
    private fun updateEmptyState() {
        binding.emptyState.visibility = if (transactions.isEmpty()) {
            View.VISIBLE
        } else {
            View.GONE
        }
    }
    
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
