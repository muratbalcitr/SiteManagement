package com.balancetech.sitemanagement.ui.dashboard

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.balancetech.sitemanagement.R
import com.balancetech.sitemanagement.data.model.UserRole
import com.balancetech.sitemanagement.databinding.FragmentDashboardBinding
import com.balancetech.sitemanagement.ui.viewmodel.AuthViewModel
import com.balancetech.sitemanagement.ui.viewmodel.DashboardViewModel
import com.balancetech.sitemanagement.ui.viewmodel.SyncState
import com.google.android.material.snackbar.Snackbar
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class DashboardFragment : Fragment() {
    private var _binding: FragmentDashboardBinding? = null
    private val binding get() = _binding!!
    private val viewModel: DashboardViewModel by viewModels()
    private val authViewModel: AuthViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentDashboardBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.feesCard.setOnClickListener {
            // For residents, show only their own fees
            lifecycleScope.launch {
                val currentUser = authViewModel.currentUser.value
                if (currentUser?.role == UserRole.RESIDENT && currentUser.unitId != null) {
                    // Navigate to user detail page (fees tab) for residents
                    findNavController().navigate(
                        R.id.action_dashboardFragment_to_userDetailFragment,
                        Bundle().apply {
                            putString("user_id", currentUser.id)
                        }
                    )
                } else {
                    // For admin, show all fees
                    findNavController().navigate(R.id.action_dashboardFragment_to_feesFragment)
                }
            }
        }

        binding.waterMeterCard.setOnClickListener {
            // For residents, show only their own water meters
            lifecycleScope.launch {
                val currentUser = authViewModel.currentUser.value
                if (currentUser?.role == UserRole.RESIDENT && currentUser.unitId != null) {
                    // Navigate to user detail page (water bills tab) for residents
                    findNavController().navigate(
                        R.id.action_dashboardFragment_to_userDetailFragment,
                        Bundle().apply {
                            putString("user_id", currentUser.id)
                        }
                    )
                } else {
                    // For admin, show all water meters
                    findNavController().navigate(R.id.action_dashboardFragment_to_waterMeterFragment)
                }
            }
        }

        binding.paymentsCard.setOnClickListener {
            // For residents, show only their own payments
            lifecycleScope.launch {
                val currentUser = authViewModel.currentUser.value
                if (currentUser?.role == UserRole.RESIDENT && currentUser.unitId != null) {
                    // Navigate to user detail page (payments tab) for residents
                    findNavController().navigate(
                        R.id.action_dashboardFragment_to_userDetailFragment,
                        Bundle().apply {
                            putString("user_id", currentUser.id)
                        }
                    )
                } else {
                    // For admin, show all payments
                    findNavController().navigate(R.id.action_dashboardFragment_to_paymentsFragment)
                }
            }
        }

        binding.extraPaymentsCard.setOnClickListener {
            // For residents, show only their own extra payments
            lifecycleScope.launch {
                val currentUser = authViewModel.currentUser.value
                if (currentUser?.role == UserRole.RESIDENT && currentUser.unitId != null) {
                    // Navigate to user detail page (extra payments tab) for residents
                    findNavController().navigate(
                        R.id.action_dashboardFragment_to_userDetailFragment,
                        Bundle().apply {
                            putString("user_id", currentUser.id)
                        }
                    )
                } else {
                    // For admin, show all extra payments
                    findNavController().navigate(R.id.action_dashboardFragment_to_extraPaymentsFragment)
                }
            }
        }

        binding.usersCard.setOnClickListener {
            findNavController().navigate(R.id.action_dashboardFragment_to_usersFragment)
        }

        binding.bankTransactionsCard.setOnClickListener {
            findNavController().navigate(R.id.action_dashboardFragment_to_bankTransactionsFragment)
        }

        // Profile card - show for all users, navigate to own profile for residents
        binding.profileCard.setOnClickListener {
            lifecycleScope.launch {
                val currentUser = authViewModel.currentUser.value
                if (currentUser != null) {
                    // Navigate to user detail page
                    findNavController().navigate(
                        R.id.action_dashboardFragment_to_userDetailFragment,
                        Bundle().apply {
                            putString("user_id", currentUser.id)
                        }
                    )
                }
            }
        }

        // Sync button - Download data from Firebase and update screen
        binding.syncButton.setOnClickListener {
            viewModel.syncFromFirebase("apt-001")
            viewModel.syncToFirebase()
        }

        // Load current user info for profile card
        lifecycleScope.launch {
            authViewModel.currentUser.collect { user ->
                user?.let {
                    binding.profileNameText.text = it.name
                    binding.profileEmailText.text = it.email
                    
                    // Show/hide admin-only features based on role
                    if (it.role == UserRole.RESIDENT) {
                        // Hide admin-only cards for residents
                        binding.usersCard.visibility = View.GONE
                        binding.syncButton.visibility = View.GONE
                    } else {
                        // Show all features for admin
                        binding.usersCard.visibility = View.VISIBLE
                        binding.syncButton.visibility = View.VISIBLE
                    }
                }
            }
        }

        // Observe total debt and credit (filtered by user's unit if resident)
        viewLifecycleOwner.lifecycleScope.launch {
            authViewModel.currentUser.collect { user ->
                user?.let {
                    val unitId = if (it.role == UserRole.RESIDENT) it.unitId else null
                    
                    // Observe debt for this user's unit (or all if admin)
                    viewModel.getTotalDebt(unitId).collect { debt ->
                        _binding?.totalDebtTextView?.text = String.format(getString(R.string.currency_format), debt)
                    }
                }
            }
        }

        viewLifecycleOwner.lifecycleScope.launch {
            authViewModel.currentUser.collect { user ->
                user?.let {
                    val unitId = if (it.role == UserRole.RESIDENT) it.unitId else null
                    
                    // Observe credit for this user's unit (or all if admin)
                    viewModel.getTotalCredit(unitId).collect { credit ->
                        _binding?.totalCreditTextView?.text = String.format(getString(R.string.currency_format), credit)
                    }
                }
            }
        }

        // Observe remaining payment (filtered by user's unit if resident)
        viewLifecycleOwner.lifecycleScope.launch {
            authViewModel.currentUser.collect { user ->
                user?.let {
                    val unitId = if (it.role == UserRole.RESIDENT) it.unitId else null
                    
                    // Observe remaining payment for this user's unit (or all if admin)
                    viewModel.getRemainingPayment(unitId).collect { remaining ->
                        _binding?.remainingPaymentTextView?.text = String.format(getString(R.string.currency_format), remaining)
                    }
                }
            }
        }

        // Observe sync state
        viewLifecycleOwner.lifecycleScope.launch {
            viewModel.syncState.collect { state ->
                val currentBinding = _binding ?: return@collect
                when (state) {
                    is SyncState.Idle -> {
                        currentBinding.syncButton.isEnabled = true
                        currentBinding.syncButton.text = getString(R.string.sync_to_server)
                    }
                    is SyncState.Syncing -> {
                        currentBinding.syncButton.isEnabled = false
                        currentBinding.syncButton.text = getString(R.string.syncing)
                    }
                    is SyncState.Success -> {
                        currentBinding.syncButton.isEnabled = true
                        currentBinding.syncButton.text = getString(R.string.sync_to_server)
                        Snackbar.make(
                            currentBinding.root,
                            state.message,
                            Snackbar.LENGTH_LONG
                        ).show()
                        // Refresh dashboard data after successful sync
                        // Flow'lar otomatik olarak güncellenecek çünkü veriler değişti
                    }
                    is SyncState.Error -> {
                        currentBinding.syncButton.isEnabled = true
                        currentBinding.syncButton.text = getString(R.string.sync_to_server)
                        Snackbar.make(
                            currentBinding.root,
                            getString(R.string.error_sync, state.message),
                            Snackbar.LENGTH_LONG
                        ).show()
                    }
                }
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
