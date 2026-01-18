package com.balancetech.sitemanagement.di

import com.balancetech.sitemanagement.data.service.FirebaseFunctionsService
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.functions.FirebaseFunctions
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object FirebaseModule {
    
    @Provides
    @Singleton
    fun provideFirebaseFirestore(): FirebaseFirestore {
        return FirebaseFirestore.getInstance()
    }

    @Provides
    @Singleton
    fun provideFirebaseAuth(): FirebaseAuth {
        val auth = FirebaseAuth.getInstance()
        // Firebase Auth persistence is enabled by default on Android
        // This ensures users stay logged in across app restarts
        // The auth state is automatically persisted to local storage
        return auth
    }

    @Provides
    @Singleton
    fun provideFirebaseFunctions(): FirebaseFunctions {
        return FirebaseFunctions.getInstance()
    }

    @Provides
    @Singleton
    fun provideFirebaseFunctionsService(
        functions: FirebaseFunctions
    ): FirebaseFunctionsService {
        return FirebaseFunctionsService(functions)
    }
}

