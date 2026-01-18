package com.balancetech.sitemanagement

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import androidx.navigation.NavOptions
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.balancetech.sitemanagement.data.repository.AuthRepository
import com.balancetech.sitemanagement.ui.viewmodel.AuthViewModel
import com.google.firebase.auth.FirebaseAuth
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    
    @Inject
    lateinit var authRepository: AuthRepository
    
    @Inject
    lateinit var firebaseAuth: FirebaseAuth
    
    private var authStateListener: FirebaseAuth.AuthStateListener? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val navHostFragment = supportFragmentManager
            .findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        val navController = navHostFragment.navController

        setupActionBarWithNavController(navController)
        
        // Setup bottom navigation
        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottomNavigationView)
        bottomNavigationView.setupWithNavController(navController)
        
        // Hide bottom navigation on login/register screens
        navController.addOnDestinationChangedListener { _, destination, _ ->
            when (destination.id) {
                R.id.loginFragment, R.id.registerFragment -> {
                    bottomNavigationView.visibility = android.view.View.GONE
                }
                else -> {
                    bottomNavigationView.visibility = android.view.View.VISIBLE
                }
            }
        }
        
        // Check if user is already logged in
        checkAuthState(navController)
        
        // Set up auth state listener to handle automatic login
        setupAuthStateListener(navController)
    }
    
    private fun checkAuthState(navController: androidx.navigation.NavController) {
        lifecycleScope.launch {
            // Initialize current user from Firebase Auth state
            authRepository.initializeCurrentUser()
            
            // Check if user is logged in
            if (authRepository.isLoggedIn()) {
                // User is already logged in, navigate to dashboard
                val currentDestination = navController.currentDestination?.id
                if (currentDestination == com.balancetech.sitemanagement.R.id.loginFragment || 
                    currentDestination == null) {
                    try {
                        navController.navigate(com.balancetech.sitemanagement.R.id.action_loginFragment_to_dashboardFragment)
                    } catch (e: Exception) {
                        // Navigation might fail if graph is not ready, ignore
                        android.util.Log.d("MainActivity", "Navigation skipped: ${e.message}")
                    }
                }
            }
        }
    }
    
    private fun setupAuthStateListener(navController: androidx.navigation.NavController) {
        authStateListener = FirebaseAuth.AuthStateListener { firebaseAuth ->
            lifecycleScope.launch {
                val firebaseUser = firebaseAuth.currentUser
                if (firebaseUser != null) {
                    // User is signed in, initialize and navigate if needed
                    authRepository.initializeCurrentUser()
                    val currentDestination = navController.currentDestination?.id
                    // Only navigate if we're on login fragment and not already on dashboard
                    if (currentDestination == R.id.loginFragment) {
                        try {
                            navController.navigate(R.id.action_loginFragment_to_dashboardFragment)
                        } catch (e: Exception) {
                            android.util.Log.d("MainActivity", "Navigation skipped: ${e.message}")
                        }
                    }
                } else {
                    // User is signed out, navigate to login if needed
                    val currentDestination = navController.currentDestination?.id
                    if (currentDestination != null && 
                        currentDestination != R.id.loginFragment &&
                        currentDestination != R.id.registerFragment) {
                        try {
                            // Use popUpTo to clear back stack and navigate to login
                            val navOptions = NavOptions.Builder()
                                .setPopUpTo(R.id.nav_graph, true)
                                .build()
                            navController.navigate(R.id.loginFragment,null, navOptions)
                        } catch (e: Exception) {
                            android.util.Log.d("MainActivity", "Navigation skipped: ${e.message}")
                        }
                    }
                }
            }
        }
        
        firebaseAuth.addAuthStateListener(authStateListener!!)
    }

    override fun onSupportNavigateUp(): Boolean {
        val navHostFragment = supportFragmentManager
            .findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        return navHostFragment.navController.navigateUp() || super.onSupportNavigateUp()
    }
    
    override fun onDestroy() {
        super.onDestroy()
        authStateListener?.let {
            firebaseAuth.removeAuthStateListener(it)
        }
    }
}

