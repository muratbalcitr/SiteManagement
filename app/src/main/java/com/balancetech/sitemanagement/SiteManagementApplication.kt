package com.balancetech.sitemanagement

import android.app.Application
import android.content.Context
import android.content.SharedPreferences
import com.balancetech.sitemanagement.data.dao.BlockDao
import com.balancetech.sitemanagement.data.dao.UnitDao
import com.balancetech.sitemanagement.util.DatabaseSeedUtil
import dagger.hilt.EntryPoint
import dagger.hilt.android.HiltAndroidApp
import dagger.hilt.android.EntryPointAccessors
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.launch

@HiltAndroidApp
class SiteManagementApplication : Application() {
    
    private val applicationScope = CoroutineScope(SupervisorJob() + Dispatchers.IO)
    private val prefs: SharedPreferences by lazy {
        getSharedPreferences("app_prefs", Context.MODE_PRIVATE)
    }
    
    companion object {
        private const val PREF_FIRST_LAUNCH = "is_first_launch"
    }
    
    override fun onCreate() {
        super.onCreate()
        
        // Seed database on app start if not already seeded
        applicationScope.launch {
            val entryPoint = EntryPointAccessors.fromApplication(
                applicationContext,
                DatabaseSeedEntryPoint::class.java
            )
            
            val blockDao = entryPoint.blockDao()
            val unitDao = entryPoint.unitDao()
            
            if (!DatabaseSeedUtil.isSeeded(blockDao)) {
                val result = DatabaseSeedUtil.seedBlocksAndUnits(blockDao, unitDao)
                if (result.isSuccess) {
                    android.util.Log.d("DatabaseSeed", result.getOrNull() ?: "Seeded")
                } else {
                    android.util.Log.e("DatabaseSeed", "Error: ${result.exceptionOrNull()?.message}")
                }
            }
            
            // Sync data from Firebase on first launch
            val isFirstLaunch = prefs.getBoolean(PREF_FIRST_LAUNCH, true)
            android.util.Log.d("SyncRepository", "İlk açılış kontrolü: $isFirstLaunch")
            if (isFirstLaunch) {
                try {
                    android.util.Log.d("SyncRepository", "Senkronizasyon başlatılıyor...")
                    val syncRepository = entryPoint.syncRepository()
                    val result = syncRepository.syncFromFirebase("apt-001")
                    if (result.isSuccess) {
                        android.util.Log.d("SyncRepository", "İlk açılış senkronizasyonu başarılı: ${result.getOrNull()}")
                    } else {
                        android.util.Log.e("SyncRepository", "Senkronizasyon hatası: ${result.exceptionOrNull()?.message}")
                        result.exceptionOrNull()?.printStackTrace()
                    }
                    // Mark as not first launch
                    prefs.edit().putBoolean(PREF_FIRST_LAUNCH, false).apply()
                    android.util.Log.d("SyncRepository", "İlk açılış flag'i false olarak işaretlendi")
                } catch (e: Exception) {
                    android.util.Log.e("SyncRepository", "Senkronizasyon hatası: ${e.message}", e)
                    e.printStackTrace()
                }
            } else {
                android.util.Log.d("SyncRepository", "İlk açılış değil, senkronizasyon atlanıyor")
            }
        }
    }
    
    @EntryPoint
    @dagger.hilt.InstallIn(dagger.hilt.components.SingletonComponent::class)
    interface DatabaseSeedEntryPoint {
        fun blockDao(): BlockDao
        fun unitDao(): UnitDao
        fun syncRepository(): com.balancetech.sitemanagement.data.repository.SyncRepository
    }
}
