package com.balancetech.sitemanagement.ui.notifications

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.balancetech.sitemanagement.databinding.FragmentNotificationsBinding
import com.balancetech.sitemanagement.ui.adapter.NotificationAdapter
import com.balancetech.sitemanagement.ui.viewmodel.NotificationViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class NotificationsFragment : Fragment() {
    private var _binding: FragmentNotificationsBinding? = null
    private val binding get() = _binding!!
    private val viewModel: NotificationViewModel by viewModels()
    private lateinit var adapter: NotificationAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentNotificationsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        
        setupRecyclerView()
        observeViewModel()
        setupMarkAllReadButton()
    }

    private fun setupRecyclerView() {
        adapter = NotificationAdapter(
            onItemClick = { notification ->
                if (!notification.isRead) {
                    viewModel.markAsRead(notification.id)
                }
            }
        )
        
        binding.notificationsRecyclerView.apply {
            layoutManager = LinearLayoutManager(requireContext())
            this.adapter = this@NotificationsFragment.adapter
        }
    }

    private fun observeViewModel() {
        lifecycleScope.launch {
            viewModel.getNotifications().collect { notifications ->
                adapter.submitList(notifications)
                if (notifications.isEmpty()) {
                    binding.emptyStateText.visibility = View.VISIBLE
                    binding.notificationsRecyclerView.visibility = View.GONE
                } else {
                    binding.emptyStateText.visibility = View.GONE
                    binding.notificationsRecyclerView.visibility = View.VISIBLE
                }
            }
        }

        lifecycleScope.launch {
            viewModel.getUnreadNotificationCount().collect { count ->
                // Update badge or UI if needed
            }
        }
    }

    private fun setupMarkAllReadButton() {
        binding.markAllReadButton.setOnClickListener {
            viewModel.markAllAsRead()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}



