package com.balancetech.sitemanagement.data.repository

import com.balancetech.sitemanagement.data.dao.UserDao
import com.balancetech.sitemanagement.data.datasource.LocalDataSource
import com.balancetech.sitemanagement.data.datasource.RemoteDataSource
import com.balancetech.sitemanagement.data.entity.User
import com.balancetech.sitemanagement.util.StringUtils
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseAuthException
import com.google.firebase.auth.FirebaseUser
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.tasks.await
import java.util.UUID
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class AuthRepository @Inject constructor(
    private val userDao: UserDao,
    private val firebaseAuth: FirebaseAuth,
    private val localDataSource: LocalDataSource,
    private val remoteDataSource: RemoteDataSource
) {
    private val _currentUser = MutableStateFlow<User?>(null)
    val currentUser: StateFlow<User?> = _currentUser.asStateFlow()

    /**
     * Login with email and password using Firebase Authentication
     */
    suspend fun login(email: String, password: String): Result<User> {
        return try {
            // Authenticate with Firebase
            val authResult = firebaseAuth.signInWithEmailAndPassword(email, password).await()
            val firebaseUser = authResult.user
            
            if (firebaseUser == null) {
                return Result.failure(Exception("Firebase authentication failed"))
            }

            // Get user from local database
            var user = localDataSource.getUserByEmail(email)
            
            // If user doesn't exist locally, try to get from remote
            if (user == null) {
                user = remoteDataSource.getUserByEmail(email)
                // If found in remote, save to local
                if (user != null) {
                    localDataSource.insertUser(user)
                }
            }

            // If still no user, create one from Firebase user info
            if (user == null) {
                val userName = firebaseUser.displayName ?: "Kullanıcı"
                // Generate user ID from name (slug format) for Firestore
                val allUsers = localDataSource.getAllActiveUsers().first()
                val existingIds = allUsers.map { it.id }.toSet()
                val userId = StringUtils.generateUserIdFromName(userName, existingIds)
                
                user = User(
                    id = userId, // Use slug as ID for Firestore
                    email = firebaseUser.email ?: email,
                    password = "", // Don't store password
                    name = userName,
                    phone = firebaseUser.phoneNumber,
                    role = com.balancetech.sitemanagement.data.model.UserRole.RESIDENT,
                    isActive = true
                )
                localDataSource.insertUser(user)
                // Also save to remote
                remoteDataSource.createUser(user)
            }

            _currentUser.value = user
            Result.success(user)
        } catch (e: FirebaseAuthException) {
            Result.failure(Exception(getAuthErrorMessage(e.errorCode)))
        } catch (e: Exception) {
            Result.failure(e)
        }
    }

    /**
     * Register new user with email and password using Firebase Authentication
     */
    suspend fun register(
        email: String,
        password: String,
        name: String,
        phone: String?,
        role: com.balancetech.sitemanagement.data.model.UserRole
    ): Result<User> {
        return try {
            // Check if user already exists locally
            val existingUser = localDataSource.getUserByEmail(email)
            if (existingUser != null) {
                return Result.failure(Exception("Bu e-posta adresi zaten kullanılıyor"))
            }

            // Create user in Firebase Authentication
            val authResult = firebaseAuth.createUserWithEmailAndPassword(email, password).await()
            val firebaseUser = authResult.user

            if (firebaseUser == null) {
                return Result.failure(Exception("Firebase kullanıcı oluşturma başarısız"))
            }

            // Update Firebase user profile
            val profileUpdates = com.google.firebase.auth.UserProfileChangeRequest.Builder()
                .setDisplayName(name)
                .build()
            firebaseUser.updateProfile(profileUpdates).await()

            // Generate user ID from name (slug format) for Firestore
            val allUsers = localDataSource.getAllActiveUsers().first()
            val existingIds = allUsers.map { it.id }.toSet()
            val userId = StringUtils.generateUserIdFromName(name, existingIds)

            // Create user entity
            val user = User(
                id = userId, // Use slug as ID for Firestore
                email = email,
                password = "", // Don't store password
                name = name,
                phone = phone,
                role = role,
                isActive = true
            )

            // Save to local database first (offline-first)
            localDataSource.insertUser(user)

            // Then sync to Firebase Firestore
            val remoteResult = remoteDataSource.createUser(user)
            if (remoteResult.isFailure) {
                // Log error but don't fail registration
                android.util.Log.e("AuthRepository", "Failed to sync user to Firestore: ${remoteResult.exceptionOrNull()?.message}")
            }

            _currentUser.value = user
            Result.success(user)
        } catch (e: FirebaseAuthException) {
            Result.failure(Exception(getAuthErrorMessage(e.errorCode)))
        } catch (e: Exception) {
            Result.failure(e)
        }
    }

    /**
     * Logout current user
     */
    suspend fun logout() {
        try {
            firebaseAuth.signOut()
            _currentUser.value = null
        } catch (e: Exception) {
            android.util.Log.e("AuthRepository", "Logout error: ${e.message}")
        }
    }

    /**
     * Get current logged in user
     */
    fun getCurrentUser(): User? = _currentUser.value

    /**
     * Check if user is logged in
     */
    fun isLoggedIn(): Boolean {
        return firebaseAuth.currentUser != null && _currentUser.value != null
    }

    /**
     * Get current Firebase user
     */
    fun getCurrentFirebaseUser(): FirebaseUser? = firebaseAuth.currentUser

    /**
     * Initialize current user from Firebase Auth state
     */
    suspend fun initializeCurrentUser() {
        val firebaseUser = firebaseAuth.currentUser
        if (firebaseUser != null) {
            val email = firebaseUser.email
            if (email != null) {
                var user = localDataSource.getUserByEmail(email)
                if (user == null) {
                    user = remoteDataSource.getUserByEmail(email)
                    if (user != null) {
                        localDataSource.insertUser(user)
                    }
                }
                _currentUser.value = user
            }
        }
    }

    /**
     * Convert Firebase Auth error code to user-friendly message
     */
    private fun getAuthErrorMessage(errorCode: String): String {
        return when (errorCode) {
            "ERROR_INVALID_EMAIL" -> "Geçersiz e-posta adresi"
            "ERROR_WRONG_PASSWORD" -> "Yanlış şifre"
            "ERROR_USER_NOT_FOUND" -> "Kullanıcı bulunamadı"
            "ERROR_USER_DISABLED" -> "Bu kullanıcı devre dışı bırakılmış"
            "ERROR_TOO_MANY_REQUESTS" -> "Çok fazla deneme. Lütfen daha sonra tekrar deneyin"
            "ERROR_EMAIL_ALREADY_IN_USE" -> "Bu e-posta adresi zaten kullanılıyor"
            "ERROR_WEAK_PASSWORD" -> "Şifre çok zayıf. En az 6 karakter olmalı"
            "ERROR_NETWORK_REQUEST_FAILED" -> "Ağ hatası. İnternet bağlantınızı kontrol edin"
            else -> "Kimlik doğrulama hatası: $errorCode"
        }
    }
}
