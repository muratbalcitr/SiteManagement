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
import com.balancetech.sitemanagement.databinding.FragmentDashboardBinding
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
            findNavController().navigate(R.id.action_dashboardFragment_to_feesFragment)
        }

        binding.waterMeterCard.setOnClickListener {
            findNavController().navigate(R.id.action_dashboardFragment_to_waterMeterFragment)
        }

        binding.paymentsCard.setOnClickListener {
            findNavController().navigate(R.id.action_dashboardFragment_to_paymentsFragment)
        }

        binding.extraPaymentsCard.setOnClickListener {
            findNavController().navigate(R.id.action_dashboardFragment_to_extraPaymentsFragment)
        }

        binding.usersCard.setOnClickListener {
            findNavController().navigate(R.id.action_dashboardFragment_to_usersFragment)
        }

        // Sync button
        binding.syncButton.setOnClickListener {
            viewModel.syncToFirebase()
        }

        // Observe total debt and credit
        viewLifecycleOwner.lifecycleScope.launch {
            viewModel.totalDebt.collect { debt ->
                _binding?.totalDebtTextView?.text = String.format("%.2f ₺", debt)
            }
        }

        viewLifecycleOwner.lifecycleScope.launch {
            viewModel.totalCredit.collect { credit ->
                _binding?.totalCreditTextView?.text = String.format("%.2f ₺", credit)
            }
        }

        // Observe sync state
        viewLifecycleOwner.lifecycleScope.launch {
            viewModel.syncState.collect { state ->
                val currentBinding = _binding ?: return@collect
                when (state) {
                    is SyncState.Idle -> {
                        currentBinding.syncButton.isEnabled = true
                        currentBinding.syncButton.text = "🔄 Firebase ile Senkronize Et"
                    }
                    is SyncState.Syncing -> {
                        currentBinding.syncButton.isEnabled = false
                        currentBinding.syncButton.text = "Senkronize ediliyor..."
                    }
                    is SyncState.Success -> {
                        currentBinding.syncButton.isEnabled = true
                        currentBinding.syncButton.text = "🔄 Firebase ile Senkronize Et"
                        Snackbar.make(
                            currentBinding.root,
                            state.message,
                            Snackbar.LENGTH_LONG
                        ).show()
                    }
                    is SyncState.Error -> {
                        currentBinding.syncButton.isEnabled = true
                        currentBinding.syncButton.text = "🔄 Firebase ile Senkronize Et"
                        Snackbar.make(
                            currentBinding.root,
                            "Hata: ${state.message}",
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
