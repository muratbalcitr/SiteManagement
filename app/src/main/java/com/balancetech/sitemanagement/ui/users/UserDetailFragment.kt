package com.balancetech.sitemanagement.ui.users

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.navigation.fragment.findNavController
import com.balancetech.sitemanagement.data.entity.ExtraPayment
import com.balancetech.sitemanagement.data.entity.Fee
import com.balancetech.sitemanagement.data.entity.Payment
import com.balancetech.sitemanagement.data.entity.User
import com.balancetech.sitemanagement.data.entity.WaterBill
import com.balancetech.sitemanagement.data.model.PaymentStatus
import com.balancetech.sitemanagement.databinding.FragmentUserDetailBinding
import com.balancetech.sitemanagement.ui.adapter.ExtraPaymentAdapter
import com.balancetech.sitemanagement.ui.adapter.FeeAdapter
import com.balancetech.sitemanagement.ui.adapter.PaymentAdapter
import com.balancetech.sitemanagement.ui.adapter.WaterBillAdapter
import com.balancetech.sitemanagement.ui.dialog.PaymentEntryDialogFragment
import com.balancetech.sitemanagement.ui.viewmodel.UserDetailViewModel
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.tabs.TabLayout
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch

@AndroidEntryPoint
class UserDetailFragment : Fragment() {
    private var _binding: FragmentUserDetailBinding? = null
    private val binding get() = _binding!!
    private val viewModel: UserDetailViewModel by viewModels()
    
    private lateinit var feeAdapter: FeeAdapter
    private lateinit var extraPaymentAdapter: ExtraPaymentAdapter
    private lateinit var waterBillAdapter: WaterBillAdapter
    private lateinit var paymentAdapter: PaymentAdapter
    private var currentUser: User? = null
    private var currentUnitId: String? = null
    
    companion object {
        private const val ARG_USER_ID = "user_id"
        
        fun newInstance(userId: String): UserDetailFragment {
            return UserDetailFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_USER_ID, userId)
                }
            }
        }
    }
    
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentUserDetailBinding.inflate(inflater, container, false)
        return binding.root
    }
    
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        
        val userId = arguments?.getString(ARG_USER_ID) ?: return
        
        binding.toolbar.setNavigationOnClickListener {
            findNavController().navigateUp()
        }
        
        setupTabs()
        setupRecyclerView()
        observeViewModel(userId)
    }
    
    private fun setupTabs() {
        binding.tabLayout.addTab(binding.tabLayout.newTab().setText("Aidatlar"))
        binding.tabLayout.addTab(binding.tabLayout.newTab().setText("Ek Ödemeler"))
        binding.tabLayout.addTab(binding.tabLayout.newTab().setText("Su Faturaları"))
        binding.tabLayout.addTab(binding.tabLayout.newTab().setText("Ödemeler"))
        
        binding.tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab?) {
                when (tab?.position) {
                    0 -> showFees()
                    1 -> showExtraPayments()
                    2 -> showWaterBills()
                    3 -> showPayments()
                }
            }
            override fun onTabUnselected(tab: TabLayout.Tab?) {}
            override fun onTabReselected(tab: TabLayout.Tab?) {}
        })
    }
    
    private fun setupRecyclerView() {
        feeAdapter = FeeAdapter(
            onItemClick = { fee ->
                // Show fee details
            },
            onPaymentClick = { fee ->
                showPaymentDialog(fee.id, fee.amount - fee.paidAmount, PaymentEntryDialogFragment.PaymentType.FEE)
            }
        )
        
        extraPaymentAdapter = ExtraPaymentAdapter(
            onItemClick = { payment ->
                // Show extra payment details
            },
            onPaymentClick = { payment ->
                showPaymentDialog(payment.id, payment.amount - payment.paidAmount, PaymentEntryDialogFragment.PaymentType.EXTRA_PAYMENT)
            }
        )
        
        waterBillAdapter = WaterBillAdapter(
            onItemClick = { bill ->
                // Show water bill details
            },
            onPaymentClick = { bill ->
                showPaymentDialog(bill.id, bill.totalAmount - bill.paidAmount, PaymentEntryDialogFragment.PaymentType.WATER_BILL)
            }
        )
        
        paymentAdapter = PaymentAdapter(
            onItemClick = { payment ->
                // Show payment details
            }
        )
        
        binding.recyclerView.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = feeAdapter
        }
    }
    
    private fun observeViewModel(userId: String) {
        // Load user
        lifecycleScope.launch {
            val user = viewModel.getUserById(userId)
            user?.let {
                currentUser = it
                currentUnitId = it.unitId
                updateUserInfo(it)
                if (it.unitId != null) {
                    loadUnitData(it.unitId)
                }
            }
        }
    }
    
    private fun updateUserInfo(user: User) {
        binding.apply {
            userNameText.text = user.name
            userEmailText.text = user.email
            userPhoneText.text = user.phone ?: "Telefon yok"
        }
    }
    
    private fun loadUnitData(unitId: String) {
        lifecycleScope.launch {
            // Load unit info
            val unit = viewModel.getUnitById(unitId)
            unit?.let {
                binding.unitNumberText.text = "Daire: ${it.unitNumber}"
                binding.unitAreaText.text = "Alan: ${it.area} m²"
            }
            
            // Load total debt
            val totalDebt = viewModel.getTotalDebt(unitId)
            binding.totalDebtText.text = String.format("Toplam Borç: %.2f ₺", totalDebt)
            
            // Show fees by default
            showFees()
        }
    }
    
    private fun showFees() {
        val unitId = currentUnitId ?: return
        binding.recyclerView.adapter = feeAdapter
        lifecycleScope.launch {
            viewModel.getFeesByUnit(unitId).collect { fees ->
                feeAdapter.submitList(fees)
                binding.emptyState.visibility = if (fees.isEmpty()) View.VISIBLE else View.GONE
            }
        }
    }
    
    private fun showExtraPayments() {
        val unitId = currentUnitId ?: return
        binding.recyclerView.adapter = extraPaymentAdapter
        lifecycleScope.launch {
            viewModel.getExtraPaymentsByUnit(unitId).collect { payments ->
                extraPaymentAdapter.submitList(payments)
                binding.emptyState.visibility = if (payments.isEmpty()) View.VISIBLE else View.GONE
            }
        }
    }
    
    private fun showWaterBills() {
        val unitId = currentUnitId ?: return
        binding.recyclerView.adapter = waterBillAdapter
        lifecycleScope.launch {
            viewModel.getWaterBillsByUnit(unitId).collect { bills ->
                waterBillAdapter.submitList(bills)
                binding.emptyState.visibility = if (bills.isEmpty()) View.VISIBLE else View.GONE
            }
        }
    }
    
    private fun showPayments() {
        val unitId = currentUnitId ?: return
        binding.recyclerView.adapter = paymentAdapter
        lifecycleScope.launch {
            viewModel.getPaymentsByUnit(unitId).collect { payments ->
                paymentAdapter.submitList(payments.sortedByDescending { it.paymentDate })
                binding.emptyState.visibility = if (payments.isEmpty()) View.VISIBLE else View.GONE
            }
        }
    }
    
    private fun showPaymentDialog(id: String, remainingAmount: Double, paymentType: PaymentEntryDialogFragment.PaymentType) {
        val unitId = currentUnitId ?: return
        lifecycleScope.launch {
            val dialog = when (paymentType) {
                PaymentEntryDialogFragment.PaymentType.FEE -> {
                    PaymentEntryDialogFragment.newInstance(
                        unitId = unitId,
                        maxAmount = remainingAmount,
                        paymentType = PaymentEntryDialogFragment.PaymentType.FEE,
                        feeId = id
                    )
                }
                PaymentEntryDialogFragment.PaymentType.EXTRA_PAYMENT -> {
                    PaymentEntryDialogFragment.newInstance(
                        unitId = unitId,
                        maxAmount = remainingAmount,
                        paymentType = PaymentEntryDialogFragment.PaymentType.EXTRA_PAYMENT,
                        extraPaymentId = id
                    )
                }
                PaymentEntryDialogFragment.PaymentType.WATER_BILL -> {
                    PaymentEntryDialogFragment.newInstance(
                        unitId = unitId,
                        maxAmount = remainingAmount,
                        paymentType = PaymentEntryDialogFragment.PaymentType.WATER_BILL,
                        waterBillId = id
                    )
                }
                else -> null
            }
            
            dialog?.apply {
                setOnPaymentRecordedListener {
                    // Refresh current tab
                    when (binding.tabLayout.selectedTabPosition) {
                        0 -> showFees()
                        1 -> showExtraPayments()
                        2 -> showWaterBills()
                        3 -> showPayments()
                    }
                }
            }?.show(parentFragmentManager, "PaymentEntryDialog")
        }
    }
    
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}

