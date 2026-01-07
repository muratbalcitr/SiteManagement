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
    private var currentUnitIds: List<String> = emptyList()

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
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
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
        feeAdapter = FeeAdapter(onItemClick = { fee ->
            // Show fee details
        }, onPaymentClick = { fee ->
            showPaymentDialog(
                fee.id, fee.amount - fee.paidAmount, PaymentEntryDialogFragment.PaymentType.FEE
            )
        })

        extraPaymentAdapter = ExtraPaymentAdapter(onItemClick = { payment ->
            // Show extra payment details
        }, onPaymentClick = { payment ->
            showPaymentDialog(
                payment.id,
                payment.amount - payment.paidAmount,
                PaymentEntryDialogFragment.PaymentType.EXTRA_PAYMENT
            )
        })

        waterBillAdapter = WaterBillAdapter(onItemClick = { bill ->
            // Show water bill details
        }, onPaymentClick = { bill ->
            showPaymentDialog(
                bill.id,
                bill.totalAmount - bill.paidAmount,
                PaymentEntryDialogFragment.PaymentType.WATER_BILL
            )
        })

        paymentAdapter = PaymentAdapter(
            onItemClick = { payment ->
                // Show payment details
            })

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
                // Get all units for this user
                currentUnitIds = viewModel.getUserUnits(userId)
                if (currentUnitIds.isEmpty() && it.unitId != null) {
                    // Fallback to old unitId for backward compatibility
                    currentUnitIds = listOf(it.unitId)
                }
                updateUserInfo(it)
                if (currentUnitIds.isNotEmpty()) {
                    loadUnitData(currentUnitIds)
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

    private fun loadUnitData(unitIds: List<String>) {
        lifecycleScope.launch {
            // Load all units info
            val units = unitIds.mapNotNull { viewModel.getUnitById(it) }
            if (units.isNotEmpty()) {
                val unitNumbers = units.joinToString(", ") { it.unitNumber }
                binding.unitNumberText.text = "Daireler: $unitNumbers"
                val totalArea = units.sumOf { it.area }
                binding.unitAreaText.text = "Toplam Alan: ${String.format("%.2f", totalArea)} m²"
            }

            // Load total debt for all units
            var totalDebt = 0.0
            unitIds.forEach { unitId ->
                totalDebt += viewModel.getTotalDebt(unitId)
            }
            binding.totalDebtText.text = String.format("Toplam Borç: %.2f ₺", totalDebt)

            // Show fees by default
            showFees()
        }
    }

    private fun showFees() {
        if (currentUnitIds.isEmpty()) return
        binding.recyclerView.adapter = feeAdapter
        lifecycleScope.launch {
            val allFees = mutableListOf<Fee>()
            currentUnitIds.forEach { unitId ->
                viewModel.getFeesByUnit(unitId).first().let { allFees.addAll(it) }
            }
            feeAdapter.submitList(allFees.sortedByDescending { it.year })
            binding.emptyState.visibility =
                if (allFees.isEmpty()) View.VISIBLE else View.GONE
        }
    }

    private fun showExtraPayments() {
        if (currentUnitIds.isEmpty()) return
        binding.recyclerView.adapter = extraPaymentAdapter
        lifecycleScope.launch {
            val allPayments = mutableListOf<ExtraPayment>()
            currentUnitIds.forEach { unitId ->
                viewModel.getExtraPaymentsByUnit(unitId).first().let { allPayments.addAll(it) }
            }
            extraPaymentAdapter.submitList(allPayments.sortedByDescending { it.createdAt })
            binding.emptyState.visibility = if (allPayments.isEmpty()) View.VISIBLE else View.GONE
        }
    }

    private fun showWaterBills() {
        if (currentUnitIds.isEmpty()) return
        binding.recyclerView.adapter = waterBillAdapter
        lifecycleScope.launch {
            val allBills = mutableListOf<WaterBill>()
            currentUnitIds.forEach { unitId ->
                viewModel.getWaterBillsByUnit(unitId).first().let { allBills.addAll(it) }
            }
            waterBillAdapter.submitList(allBills.sortedByDescending { it.year })
            binding.emptyState.visibility = if (allBills.isEmpty()) View.VISIBLE else View.GONE
        }
    }

    private fun showPayments() {
        if (currentUnitIds.isEmpty()) return
        binding.recyclerView.adapter = paymentAdapter
        lifecycleScope.launch {
            val allPayments = mutableListOf<Payment>()
            currentUnitIds.forEach { unitId ->
                viewModel.getPaymentsByUnit(unitId).first().let { allPayments.addAll(it) }
            }
            paymentAdapter.submitList(allPayments.sortedByDescending { it.paymentDate })
            binding.emptyState.visibility = if (allPayments.isEmpty()) View.VISIBLE else View.GONE
        }
    }

    private fun showPaymentDialog(
        id: String, remainingAmount: Double, paymentType: PaymentEntryDialogFragment.PaymentType
    ) {
        val unitId = currentUnitIds.firstOrNull() ?: return
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

