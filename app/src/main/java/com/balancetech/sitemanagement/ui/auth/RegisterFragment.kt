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
import com.balancetech.sitemanagement.data.model.UserRole
import com.balancetech.sitemanagement.databinding.FragmentRegisterBinding
import com.balancetech.sitemanagement.ui.viewmodel.AuthViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class RegisterFragment : Fragment() {
    private var _binding: FragmentRegisterBinding? = null
    private val binding get() = _binding!!
    private val viewModel: AuthViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentRegisterBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.registerButton.setOnClickListener {
            val name = binding.nameEditText.text.toString()
            val email = binding.emailEditText.text.toString()
            val password = binding.passwordEditText.text.toString()

            if (name.isBlank() || email.isBlank() || password.isBlank()) {
                Toast.makeText(requireContext(), getString(R.string.please_fill_all_fields), Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            // Default to RESIDENT role for registration
            viewModel.register(email, password, name, null, UserRole.ADMIN)
        }

        binding.loginTextView.setOnClickListener {
            findNavController().navigate(R.id.action_registerFragment_to_loginFragment)
        }

        lifecycleScope.launch {
            viewModel.uiState.collect { state ->
                when (state) {
                    is com.balancetech.sitemanagement.ui.viewmodel.AuthUiState.Loading -> {
                        binding.registerButton.isEnabled = false
                    }
                    is com.balancetech.sitemanagement.ui.viewmodel.AuthUiState.Success -> {
                        binding.registerButton.isEnabled = true
                        findNavController().navigate(R.id.action_registerFragment_to_loginFragment)
                    }
                    is com.balancetech.sitemanagement.ui.viewmodel.AuthUiState.Error -> {
                        binding.registerButton.isEnabled = true
                        Toast.makeText(requireContext(), state.message, Toast.LENGTH_SHORT).show()
                    }
                    else -> {
                        binding.registerButton.isEnabled = true
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
