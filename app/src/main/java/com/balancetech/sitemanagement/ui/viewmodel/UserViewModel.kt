package com.balancetech.sitemanagement.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.asLiveData
import com.balancetech.sitemanagement.data.datasource.LocalDataSource
import com.balancetech.sitemanagement.data.datasource.RemoteDataSource
import com.balancetech.sitemanagement.data.entity.Unit as UnitEntity
import com.balancetech.sitemanagement.data.entity.User
import com.balancetech.sitemanagement.data.model.UserRole
import com.balancetech.sitemanagement.data.repository.UserRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import java.util.UUID
import javax.inject.Inject

@HiltViewModel
class UserViewModel @Inject constructor(
    private val userRepository: UserRepository,
    private val localDataSource: LocalDataSource,
    private val remoteDataSource: RemoteDataSource
) : ViewModel() {
    private val _uiState = MutableStateFlow<UserUiState>(UserUiState.Idle)
    val uiState: LiveData<UserUiState> = _uiState.asLiveData()

    private val _users = MutableStateFlow<List<User>>(emptyList())
    val users: StateFlow<List<User>> = _users.asStateFlow()

    private val _units = MutableLiveData<List<UnitEntity>>(emptyList())
    val units: LiveData<List<UnitEntity>> = _units

    private val _blocks = MutableLiveData<List<com.balancetech.sitemanagement.data.entity.Block>>(emptyList())
    val blocks: LiveData<List<com.balancetech.sitemanagement.data.entity.Block>> = _blocks

    init {
        loadUsers()
    }

    fun loadUsers() {
        viewModelScope.launch {
            userRepository.getAllActiveUsers().collect { userList ->
                _users.value = userList.filter { it.role == UserRole.RESIDENT }
            }
        }
    }

    fun loadBlocks(apartmentId: String) {
        viewModelScope.launch {
            try {
                localDataSource.getBlocksByApartment(apartmentId).collect { blocksList ->
                    _blocks.value = blocksList
                }
            } catch (e: Exception) {
                _uiState.value = UserUiState.Error("Bloklar yüklenirken hata: ${e.message}")
            }
        }
    }

    fun loadUnitsByBlock(blockId: String) {
        viewModelScope.launch {
            try {
                localDataSource.getUnitsByBlock(blockId).collect { unitsList ->
                    _units.value = unitsList
                }
            } catch (e: Exception) {
                _uiState.value = UserUiState.Error("Daireler yüklenirken hata: ${e.message}")
            }
        }
    }

    fun createUser(
        email: String,
        password: String,
        name: String,
        phone: String?,
        role: UserRole,
        apartmentId: String?,
        unitIds: List<String>
    ) {
        viewModelScope.launch {
            _uiState.value = UserUiState.Loading
            val result = userRepository.createUser(
                email = email,
                password = password,
                name = name,
                phone = phone,
                role = role,
                apartmentId = apartmentId,
                unitIds = unitIds
            )
            _uiState.value = if (result.isSuccess) {
                UserUiState.Success("Daire sakini başarıyla eklendi")
            } else {
                UserUiState.Error(result.exceptionOrNull()?.message ?: "Kullanıcı eklenirken hata oluştu")
            }
        }
    }
    
    // Backward compatibility
    fun createUser(
        email: String,
        password: String,
        name: String,
        phone: String?,
        role: UserRole,
        apartmentId: String?,
        unitId: String?
    ) {
        createUser(
            email = email,
            password = password,
            name = name,
            phone = phone,
            role = role,
            apartmentId = apartmentId,
            unitIds = if (unitId != null) listOf(unitId) else emptyList()
        )
    }

    fun updateUser(user: User, unitIds: List<String>? = null) {
        viewModelScope.launch {
            _uiState.value = UserUiState.Loading
            val result = userRepository.updateUser(user, unitIds)
            _uiState.value = if (result.isSuccess) {
                UserUiState.Success("Kullanıcı güncellendi")
            } else {
                UserUiState.Error(result.exceptionOrNull()?.message ?: "Güncelleme hatası")
            }
        }
    }
    
    suspend fun getUserUnits(userId: String): List<String> {
        return userRepository.getUserUnits(userId)
    }

    fun deleteUser(user: User) {
        viewModelScope.launch {
            _uiState.value = UserUiState.Loading
            val result = userRepository.deleteUser(user)
            _uiState.value = if (result.isSuccess) {
                UserUiState.Success("Kullanıcı silindi")
            } else {
                UserUiState.Error(result.exceptionOrNull()?.message ?: "Silme hatası")
            }
        }
    }
    
    suspend fun getAllUnits(apartmentId: String): List<UnitEntity> {
        return localDataSource.getUnitsByApartment(apartmentId)
    }
    
    fun importUnits(units: List<UnitEntity>) {
        viewModelScope.launch {
            _uiState.value = UserUiState.Loading
            try {
                var createdUserCount = 0
                var updatedUserCount = 0
                
                // Önce tüm daireleri grupla (aynı sahip adına göre)
                val unitsByOwner = units.groupBy { it.ownerName?.trim()?.lowercase() }
                
                units.forEach { unit ->
                    localDataSource.insertUnit(unit)
                }
                
                // Her sahip için kullanıcı oluştur veya güncelle
                unitsByOwner.forEach { (ownerNameKey, ownerUnits) ->
                    if (ownerNameKey != null && ownerNameKey.isNotBlank()) {
                        // İlk daireden sahip bilgilerini al
                        val firstUnit = ownerUnits.first()
                        val ownerName = firstUnit.ownerName ?: return@forEach
                        
                        // Email oluştur (ownerName'den)
                        val email = "${ownerName.lowercase().replace(" ", ".")}@kucukyali.com"
                        
                        // Tüm daire ID'lerini topla
                        val unitIds = ownerUnits.map { it.id }
                        
                        // Kullanıcı zaten var mı kontrol et
                        val existingUser = localDataSource.getUserByEmail(email)
                        if (existingUser == null) {
                            // Yeni kullanıcı oluştur (tüm dairelerle birlikte)
                            val result = userRepository.createUser(
                                email = email,
                                password = "", // Şifre sonra ayarlanabilir
                                name = ownerName,
                                phone = firstUnit.ownerPhone,
                                role = UserRole.RESIDENT,
                                apartmentId = firstUnit.apartmentId,
                                unitIds = unitIds
                            )
                            if (result.isSuccess) {
                                createdUserCount++
                            }
                        } else {
                            // Mevcut kullanıcıya yeni daireleri ekle
                            val existingUnitIds = userRepository.getUserUnits(existingUser.id).toSet()
                            val newUnitIds = unitIds.filter { it !in existingUnitIds }
                            
                            if (newUnitIds.isNotEmpty()) {
                                val allUnitIds = (existingUnitIds + newUnitIds).toList()
                                val result = userRepository.updateUser(existingUser, allUnitIds)
                                if (result.isSuccess) {
                                    updatedUserCount++
                                }
                            }
                        }
                    }
                }
                
                val message = when {
                    createdUserCount > 0 && updatedUserCount > 0 -> {
                        "${units.size} daire, $createdUserCount yeni kullanıcı ve $updatedUserCount mevcut kullanıcı başarıyla içe aktarıldı"
                    }
                    createdUserCount > 0 -> {
                        "${units.size} daire ve $createdUserCount kullanıcı başarıyla içe aktarıldı"
                    }
                    updatedUserCount > 0 -> {
                        "${units.size} daire ve $updatedUserCount mevcut kullanıcı güncellendi"
                    }
                    else -> {
                        "${units.size} daire başarıyla içe aktarıldı"
                    }
                }
                _uiState.value = UserUiState.Success(message)
                // Kullanıcı listesini yenile
                loadUsers()
            } catch (e: Exception) {
                _uiState.value = UserUiState.Error("Daireler içe aktarılırken hata: ${e.message}")
            }
        }
    }
}

sealed class UserUiState {
    object Idle : UserUiState()
    object Loading : UserUiState()
    data class Success(val message: String) : UserUiState()
    data class Error(val message: String) : UserUiState()
}

