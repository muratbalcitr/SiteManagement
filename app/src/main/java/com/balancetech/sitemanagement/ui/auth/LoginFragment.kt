package com.balancetech.sitemanagement.ui.auth

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.balancetech.sitemanagement.R
import com.balancetech.sitemanagement.databinding.FragmentLoginBinding
import com.balancetech.sitemanagement.ui.viewmodel.AuthViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class LoginFragment : Fragment() {
    private var _binding: FragmentLoginBinding? = null
    private val binding get() = _binding!!
    private val viewModel: AuthViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentLoginBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Check if user is already logged in
        checkAutoLogin()

        binding.loginButton.setOnClickListener {
            val email = binding.emailEditText.text.toString()
            val password = binding.passwordEditText.text.toString()

            if (email.isBlank() || password.isBlank()) {
                Toast.makeText(requireContext(), getString(R.string.please_fill_all_fields), Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            viewModel.login(email, password)
        }

        binding.registerTextView.setOnClickListener {
            findNavController().navigate(R.id.action_loginFragment_to_registerFragment)
        }

        lifecycleScope.launch {
            viewModel.uiState.collect { state ->
                when (state) {
                    is com.balancetech.sitemanagement.ui.viewmodel.AuthUiState.Loading -> {
                        binding.progressBar.visibility = View.VISIBLE
                        binding.loginButton.isEnabled = false
                    }
                    is com.balancetech.sitemanagement.ui.viewmodel.AuthUiState.Success -> {
                        binding.progressBar.visibility = View.GONE
                        binding.loginButton.isEnabled = true
                        // Only navigate if we're still on login fragment
                        val currentDestination = findNavController().currentDestination?.id
                        if (currentDestination == R.id.loginFragment) {
                            try {
                                findNavController().navigate(R.id.action_loginFragment_to_dashboardFragment)
                            } catch (e: Exception) {
                                // Navigation might fail if already navigated, ignore
                                android.util.Log.d("LoginFragment", "Navigation skipped: ${e.message}")
                            }
                        }
                    }
                    is com.balancetech.sitemanagement.ui.viewmodel.AuthUiState.Error -> {
                        binding.progressBar.visibility = View.GONE
                        binding.loginButton.isEnabled = true
                        Toast.makeText(requireContext(), state.message, Toast.LENGTH_SHORT).show()
                    }
                    else -> {
                        binding.progressBar.visibility = View.GONE
                        binding.loginButton.isEnabled = true
                    }
                }
            }
        }
        
        // Observe current user to auto-navigate if logged in
        lifecycleScope.launch {
            viewModel.currentUser.collect { user ->
                val currentDestination = findNavController().currentDestination?.id
                if (user != null && currentDestination == R.id.loginFragment) {
                    // User is logged in and we're on login fragment, navigate to dashboard
                    try {
                        findNavController().navigate(R.id.action_loginFragment_to_dashboardFragment)
                    } catch (e: Exception) {
                        // Navigation might fail if already navigated, ignore
                        android.util.Log.d("LoginFragment", "Navigation skipped: ${e.message}")
                    }
                }
            }
        }
    }
    
    private fun checkAutoLogin() {
        lifecycleScope.launch {
            // Check if user is already logged in via Firebase Auth persistence
            if (viewModel.isLoggedIn()) {
                // User is already logged in, navigate to dashboard only if we're on login fragment
                val currentDestination = findNavController().currentDestination?.id
                if (currentDestination == R.id.loginFragment) {
                    try {
                        findNavController().navigate(R.id.action_loginFragment_to_dashboardFragment)
                    } catch (e: Exception) {
                        // Navigation might fail if already navigated, ignore
                        android.util.Log.d("LoginFragment", "Navigation skipped: ${e.message}")
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
