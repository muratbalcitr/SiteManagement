package com.balancetech.sitemanagement.ui.dialog

import android.app.Dialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.balancetech.sitemanagement.data.entity.Unit as UnitEntity
import com.balancetech.sitemanagement.data.model.UserRole
import com.balancetech.sitemanagement.databinding.DialogAddUserBinding
import com.balancetech.sitemanagement.ui.adapter.UnitCheckboxAdapter
import com.balancetech.sitemanagement.ui.viewmodel.UserViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AddUserDialogFragment : DialogFragment() {
    private var _binding: DialogAddUserBinding? = null
    private val binding get() = _binding!!
    private val viewModel: UserViewModel by viewModels()
    private lateinit var unitCheckboxAdapter: UnitCheckboxAdapter

    private var onUserAdded: (() -> Unit)? = null

    fun setOnUserAddedListener(listener: () -> Unit) {
        onUserAdded = listener
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        _binding = DialogAddUserBinding.inflate(layoutInflater)
        
        val dialog = Dialog(requireContext())
        dialog.setContentView(binding.root)
        dialog.window?.setLayout(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.WRAP_CONTENT
        )
        
        setupViews()
        observeViewModel()
        
        return dialog
    }

    private fun setupViews() {
        // Setup units RecyclerView with checkboxes first
        unitCheckboxAdapter = UnitCheckboxAdapter { unitId, isChecked ->
            // Handle unit selection
        }
        binding.unitsRecyclerView.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = unitCheckboxAdapter
        }
        
        // Load blocks for spinner
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
            
            // Select first block by default and load its units
            if (blocks.isNotEmpty()) {
                viewModel.loadUnitsByBlock(blocks[0].id)
            }
        }

        // Setup block selection listener
        binding.blockSpinner.onItemSelectedListener = object : android.widget.AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: android.widget.AdapterView<*>?, view: android.view.View?, position: Int, id: Long) {
                val selectedBlock = viewModel.blocks.value?.get(position)
                if (selectedBlock != null) {
                    viewModel.loadUnitsByBlock(selectedBlock.id)
                    // Clear unit selection when block changes
                    unitCheckboxAdapter.setSelectedUnits(emptySet())
                }
            }

            override fun onNothingSelected(parent: android.widget.AdapterView<*>?) {}
        }
        
        viewModel.units.observe(this) { units ->
            unitCheckboxAdapter.submitList(units)
        }

        binding.addButton.setOnClickListener {
            addUser()
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
                    onUserAdded?.invoke()
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

    private fun addUser() {
        val name = binding.nameEditText.text.toString().trim()
        val email = binding.emailEditText.text.toString().trim()
        val phone = binding.phoneEditText.text.toString().trim()
        val password = binding.passwordEditText.text.toString().trim()
        val selectedBlockIndex = binding.blockSpinner.selectedItemPosition

        if (name.isEmpty() || email.isEmpty() || password.isEmpty()) {
            binding.errorText.text = "Lütfen tüm zorunlu alanları doldurun"
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

        viewModel.createUser(
            email = email,
            password = password,
            name = name,
            phone = phone.ifEmpty { null },
            role = UserRole.RESIDENT,
            apartmentId = firstUnit.apartmentId,
            unitIds = selectedUnitIds.toList()
        )
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}

