package com.balancetech.sitemanagement.ui.dialog

import android.app.Dialog
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.balancetech.sitemanagement.data.entity.Unit as UnitEntity
import com.balancetech.sitemanagement.data.entity.User
import com.balancetech.sitemanagement.data.model.UserRole
import com.balancetech.sitemanagement.databinding.DialogAddUserBinding
import com.balancetech.sitemanagement.ui.adapter.UnitCheckboxAdapter
import com.balancetech.sitemanagement.ui.viewmodel.UserViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class EditUserDialogFragment : DialogFragment() {
    private var _binding: DialogAddUserBinding? = null
    private val binding get() = _binding!!
    private val viewModel: UserViewModel by viewModels()
    private lateinit var unitCheckboxAdapter: UnitCheckboxAdapter

    private var onUserUpdated: (() -> Unit)? = null
    private var userToEdit: User? = null

    companion object {
        private const val ARG_USER = "user"
        
        fun newInstance(user: User): EditUserDialogFragment {
            return EditUserDialogFragment().apply {
                arguments = Bundle().apply {
                    putSerializable(ARG_USER, user)
                }
            }
        }
    }

    fun setOnUserUpdatedListener(listener: () -> Unit) {
        onUserUpdated = listener
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        _binding = DialogAddUserBinding.inflate(layoutInflater)
        
        val context = requireContext()
        val dialog = Dialog(context)
        dialog.setContentView(binding.root)
        dialog.window?.setLayout(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.WRAP_CONTENT
        )
        
        // Get user from arguments
        userToEdit = arguments?.getSerializable(ARG_USER) as? User
        
        if (userToEdit == null) {
            dismiss()
            return dialog
        }
        
        setupViews()
        observeViewModel()
        
        return dialog
    }

    private fun setupViews() {
        val user = userToEdit ?: return
        
        // Pre-fill form with user data
        binding.nameEditText.setText(user.name)
        binding.emailEditText.setText(user.email)
        binding.emailEditText.isEnabled = false // Email cannot be changed
        binding.phoneEditText.setText(user.phone ?: "")
        
        // Password field is optional for editing
        binding.passwordEditText.hint = "Şifre (Değiştirmek için doldurun)"
        binding.passwordEditText.text?.clear()
        
        // Load blocks and units
        viewModel.loadBlocks("apt-001") // TODO: Get from current user
        
        // Setup block spinner
        viewModel.blocks.observe(this) { blocks ->
            val blockNames = blocks.map { it.name }
            val blockAdapter = ArrayAdapter(
                requireContext(),
                android.R.layout.simple_spinner_item,
                blockNames
            )
            blockAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            binding.blockSpinner.adapter = blockAdapter
            
            // Load user's units and select appropriate block
            lifecycleScope.launch {
                val userUnitIds = viewModel.getUserUnits(user.id).toSet()
                if (userUnitIds.isNotEmpty()) {
                    val allUnits = viewModel.getAllUnits("apt-001")
                    val firstUserUnit = allUnits.find { it.id in userUnitIds }
                    firstUserUnit?.blockId?.let { blockId ->
                        val blockIndex = blocks.indexOfFirst { it.id == blockId }
                        if (blockIndex >= 0) {
                            binding.blockSpinner.setSelection(blockIndex)
                            viewModel.loadUnitsByBlock(blockId)
                        } else if (blocks.isNotEmpty()) {
                            viewModel.loadUnitsByBlock(blocks[0].id)
                        }
                    } ?: run {
                        if (blocks.isNotEmpty()) {
                            viewModel.loadUnitsByBlock(blocks[0].id)
                        }
                    }
                } else if (blocks.isNotEmpty()) {
                    viewModel.loadUnitsByBlock(blocks[0].id)
                }
            }
        }

        // Setup block selection listener
        binding.blockSpinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                val selectedBlock = viewModel.blocks.value?.get(position)
                if (selectedBlock != null) {
                    viewModel.loadUnitsByBlock(selectedBlock.id)
                }
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {}
        }

        // Setup units RecyclerView with checkboxes
        unitCheckboxAdapter = UnitCheckboxAdapter { unitId, isChecked ->
            // Handle unit selection
        }
        binding.unitsRecyclerView.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = unitCheckboxAdapter
        }
        
        viewModel.units.observe(this) { units ->
            unitCheckboxAdapter.submitList(units)
            
            // Load and set user's current units
            lifecycleScope.launch {
                val userUnitIds = viewModel.getUserUnits(user.id).toSet()
                unitCheckboxAdapter.setSelectedUnits(userUnitIds)
            }
        }

        binding.addButton.text = "Güncelle"
        binding.addButton.setOnClickListener {
            updateUser()
        }
        
        binding.cancelButton.setOnClickListener {
            dismiss()
        }
    }

    private fun observeViewModel() {
        viewModel.uiState.observe(this) { state ->
            when (state) {
                is com.balancetech.sitemanagement.ui.viewmodel.UserUiState.Loading -> {
                    binding.progressBar.visibility = View.VISIBLE
                    binding.addButton.isEnabled = false
                }
                is com.balancetech.sitemanagement.ui.viewmodel.UserUiState.Success -> {
                    binding.progressBar.visibility = View.GONE
                    binding.addButton.isEnabled = true
                    onUserUpdated?.invoke()
                    dismiss()
                }
                is com.balancetech.sitemanagement.ui.viewmodel.UserUiState.Error -> {
                    binding.progressBar.visibility = View.GONE
                    binding.addButton.isEnabled = true
                    binding.errorText.text = state.message
                    binding.errorText.visibility = View.VISIBLE
                }
                else -> {
                    binding.progressBar.visibility = View.GONE
                    binding.addButton.isEnabled = true
                    binding.errorText.visibility = View.GONE
                }
            }
        }
    }

    private fun updateUser() {
        val user = userToEdit ?: return
        
        val name = binding.nameEditText.text.toString().trim()
        val phone = binding.phoneEditText.text.toString().trim()
        val password = binding.passwordEditText.text.toString().trim()
        val selectedBlockIndex = binding.blockSpinner.selectedItemPosition

        if (name.isEmpty()) {
            binding.errorText.text = "Lütfen adı girin"
            binding.errorText.visibility = View.VISIBLE
            return
        }

        if (selectedBlockIndex < 0) {
            binding.errorText.text = "Lütfen bir blok seçin"
            binding.errorText.visibility = View.VISIBLE
            return
        }

        val selectedUnitIds = unitCheckboxAdapter.getSelectedUnits()
        if (selectedUnitIds.isEmpty()) {
            binding.errorText.text = "Lütfen en az bir daire seçin"
            binding.errorText.visibility = View.VISIBLE
            return
        }

        val units = viewModel.units.value ?: emptyList()
        val firstUnit = units.firstOrNull { it.id in selectedUnitIds }
        if (firstUnit == null) {
            binding.errorText.text = "Geçersiz daire seçimi"
            binding.errorText.visibility = View.VISIBLE
            return
        }

        // Update user with new data
        val updatedUser = user.copy(
            name = name,
            phone = phone.ifEmpty { null },
            password = if (password.isNotEmpty()) password else user.password, // Only update if new password provided
            apartmentId = firstUnit.apartmentId,
            unitId = firstUnit.id // Keep for backward compatibility
        )

        viewModel.updateUser(updatedUser, selectedUnitIds.toList())
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}

