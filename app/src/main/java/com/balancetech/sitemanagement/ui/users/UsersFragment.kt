package com.balancetech.sitemanagement.ui.users

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.content.FileProvider
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.balancetech.sitemanagement.data.entity.User
import com.balancetech.sitemanagement.data.entity.Unit as UnitEntity
import com.balancetech.sitemanagement.databinding.FragmentUsersBinding
import com.balancetech.sitemanagement.ui.adapter.UserAdapter
import com.balancetech.sitemanagement.ui.dialog.AddUserDialogFragment
import com.balancetech.sitemanagement.ui.dialog.EditUserDialogFragment
import com.balancetech.sitemanagement.R
import com.balancetech.sitemanagement.ui.viewmodel.UserViewModel
import com.balancetech.sitemanagement.util.ExcelExportUtil
import com.balancetech.sitemanagement.util.ExcelImportUtil
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.google.android.material.snackbar.Snackbar
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch

@AndroidEntryPoint
class UsersFragment : Fragment() {
    private var _binding: FragmentUsersBinding? = null
    private val binding get() = _binding!!
    private val viewModel: UserViewModel by viewModels()
    private lateinit var userAdapter: UserAdapter
    
    private val filePickerLauncher = registerForActivityResult(
        ActivityResultContracts.GetContent()
    ) { uri: Uri? ->
        uri?.let { importFromExcel(it) }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentUsersBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupToolbar()
        setupRecyclerView()
        setupFab()
        observeViewModel()
    }
    
    private fun setupToolbar() {
        binding.toolbar.inflateMenu(R.menu.users_menu)
        binding.toolbar.setOnMenuItemClickListener { menuItem ->
            when (menuItem.itemId) {
                R.id.importButton -> {
                    openFilePicker()
                    true
                }
                R.id.exportUsersButton -> {
                    exportUsersToExcel()
                    true
                }
                R.id.exportUnitsButton -> {
                    exportUnitsToExcel()
                    true
                }
                else -> false
            }
        }
    }

    private fun setupRecyclerView() {
        userAdapter = UserAdapter(
            onItemClick = { user ->
                // Show user details or navigate to detail screen
                showUserDetails(user)
            },
            onEditClick = { user ->
                // Edit user
                editUser(user)
            },
            onDeleteClick = { user ->
                // Delete user
                deleteUser(user)
            }
        )

        binding.usersRecyclerView.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = userAdapter
        }
    }

    private fun setupFab() {
        binding.addUserFab.setOnClickListener {
            showAddUserDialog()
        }
    }
    
    private fun openFilePicker() {
        // Support CSV and Excel files
        filePickerLauncher.launch("*/*")
    }
    
    private fun importFromExcel(uri: Uri) {
        lifecycleScope.launch {
            try {
                binding.progressBar.visibility = View.VISIBLE
                
                val result = ExcelImportUtil.importUnitsFromCsv(
                    requireContext(),
                    uri,
                    "apt-001" // TODO: Get from current user
                )
                
                if (result.isSuccess) {
                    val (units, importResult) = result.getOrNull()!!
                    
                    if (units.isNotEmpty()) {
                        // Show confirmation dialog
                        val message = buildString {
                            append("${importResult.successCount} daire içe aktarılacak")
                            if (importResult.errorCount > 0) {
                                append("\n${importResult.errorCount} satırda hata var")
                            }
                            if (importResult.errors.isNotEmpty()) {
                                append("\n\nHatalar:\n")
                                importResult.errors.take(5).forEach { error ->
                                    append("• $error\n")
                                }
                                if (importResult.errors.size > 5) {
                                    append("... ve ${importResult.errors.size - 5} hata daha")
                                }
                            }
                        }
                        
                        MaterialAlertDialogBuilder(requireContext())
                            .setTitle("Daireleri İçe Aktar")
                            .setMessage(message)
                            .setPositiveButton("İçe Aktar") { _, _ ->
                                lifecycleScope.launch {
                                    viewModel.importUnits(units)
                                    // Import sonrası kullanıcı listesini yenile
                                    viewModel.loadUsers()
                                }
                            }
                            .setNegativeButton("İptal", null)
                            .show()
                    } else {
                        Snackbar.make(
                            binding.root,
                            "İçe aktarılacak daire bulunamadı",
                            Snackbar.LENGTH_SHORT
                        ).show()
                    }
                } else {
                    Snackbar.make(
                        binding.root,
                        "Hata: ${result.exceptionOrNull()?.message}",
                        Snackbar.LENGTH_LONG
                    ).show()
                }
            } catch (e: Exception) {
                Snackbar.make(
                    binding.root,
                    "Hata: ${e.message}",
                    Snackbar.LENGTH_LONG
                ).show()
            } finally {
                binding.progressBar.visibility = View.GONE
            }
        }
    }
    
    private fun exportUsersToExcel() {
        lifecycleScope.launch {
            try {
                val users = viewModel.users.value
                if (users.isEmpty()) {
                    Snackbar.make(binding.root, "Aktarılacak kullanıcı bulunamadı", Snackbar.LENGTH_SHORT).show()
                    return@launch
                }
                
                // Get units for mapping - load all units from apartment
                val unitsMap = mutableMapOf<String, UnitEntity>()
                val allUnits = viewModel.getAllUnits("apt-001") // TODO: Get from current user
                allUnits.forEach { unit ->
                    unitsMap[unit.id] = unit
                }
                
                val result = ExcelExportUtil.exportUsersToExcel(requireContext(), users, unitsMap)
                
                if (result.isSuccess) {
                    val uri = result.getOrNull()
                    if (uri != null) {
                        shareFile(uri)
                        Snackbar.make(binding.root, "Kullanıcı listesi Excel dosyası oluşturuldu", Snackbar.LENGTH_SHORT).show()
                    }
                } else {
                    Snackbar.make(binding.root, "Hata: ${result.exceptionOrNull()?.message}", Snackbar.LENGTH_LONG).show()
                }
            } catch (e: Exception) {
                Snackbar.make(binding.root, "Hata: ${e.message}", Snackbar.LENGTH_LONG).show()
            }
        }
    }
    
    private fun exportUnitsToExcel() {
        lifecycleScope.launch {
            try {
                val allUnits = viewModel.getAllUnits("apt-001") // TODO: Get from current user
                if (allUnits.isEmpty()) {
                    Snackbar.make(binding.root, "Aktarılacak daire bulunamadı", Snackbar.LENGTH_SHORT).show()
                    return@launch
                }
                
                val result = ExcelExportUtil.exportUnitsToExcel(requireContext(), allUnits)
                
                if (result.isSuccess) {
                    val uri = result.getOrNull()
                    if (uri != null) {
                        shareFile(uri)
                        Snackbar.make(binding.root, "Daire listesi Excel dosyası oluşturuldu", Snackbar.LENGTH_SHORT).show()
                    }
                } else {
                    Snackbar.make(binding.root, "Hata: ${result.exceptionOrNull()?.message}", Snackbar.LENGTH_LONG).show()
                }
            } catch (e: Exception) {
                Snackbar.make(binding.root, "Hata: ${e.message}", Snackbar.LENGTH_LONG).show()
            }
        }
    }
    
    private fun shareFile(uri: Uri) {
        val intent = Intent(Intent.ACTION_SEND).apply {
            type = "text/csv"
            putExtra(Intent.EXTRA_STREAM, uri)
            addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION)
        }
        startActivity(Intent.createChooser(intent, "Dosyayı Paylaş"))
    }

    private fun observeViewModel() {
        // Observe users list
        lifecycleScope.launch {
            viewModel.users.collect { users ->
                userAdapter.submitList(users)
                binding.emptyState.visibility = if (users.isEmpty()) View.VISIBLE else View.GONE
            }
        }

        // Observe UI state
        viewModel.uiState.observe(viewLifecycleOwner) { state ->
            when (state) {
                is com.balancetech.sitemanagement.ui.viewmodel.UserUiState.Loading -> {
                    binding.progressBar.visibility = View.VISIBLE
                }
                is com.balancetech.sitemanagement.ui.viewmodel.UserUiState.Success -> {
                    binding.progressBar.visibility = View.GONE
                    Snackbar.make(binding.root, state.message, Snackbar.LENGTH_SHORT).show()
                }
                is com.balancetech.sitemanagement.ui.viewmodel.UserUiState.Error -> {
                    binding.progressBar.visibility = View.GONE
                    Snackbar.make(binding.root, "Hata: ${state.message}", Snackbar.LENGTH_LONG).show()
                }
                else -> {
                    binding.progressBar.visibility = View.GONE
                }
            }
        }
    }

    private fun showAddUserDialog() {
        val dialog = AddUserDialogFragment()
        dialog.setOnUserAddedListener {
            viewModel.loadUsers()
        }
        dialog.show(parentFragmentManager, "AddUserDialog")
    }

    private fun showUserDetails(user: User) {
        // Navigate to user detail fragment
        findNavController().navigate(
            com.balancetech.sitemanagement.R.id.action_usersFragment_to_userDetailFragment,
            Bundle().apply {
                putString("user_id", user.id)
            }
        )
    }

    private fun editUser(user: User) {
        val dialog = EditUserDialogFragment.newInstance(user)
        dialog.setOnUserUpdatedListener {
            viewModel.loadUsers()
        }
        dialog.show(parentFragmentManager, "EditUserDialog")
    }

    private fun deleteUser(user: User) {
        MaterialAlertDialogBuilder(requireContext())
            .setTitle("Kullanıcıyı Sil")
            .setMessage("${user.name} adlı kullanıcıyı silmek istediğinize emin misiniz?")
            .setPositiveButton("Sil") { _, _ ->
                viewModel.deleteUser(user)
            }
            .setNegativeButton("İptal", null)
            .show()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}

