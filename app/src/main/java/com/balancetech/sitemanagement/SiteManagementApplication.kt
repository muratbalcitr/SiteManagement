package com.balancetech.sitemanagement

import android.app.Application
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
        }
    }
    
    @EntryPoint
    @dagger.hilt.InstallIn(dagger.hilt.components.SingletonComponent::class)
    interface DatabaseSeedEntryPoint {
        fun blockDao(): BlockDao
        fun unitDao(): UnitDao
    }
}
