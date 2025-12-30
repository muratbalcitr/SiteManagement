package com.balancetech.sitemanagement.data.repository;

@javax.inject.Singleton
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u00a2\u0006\u0002\u0010\nJ\u0010\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0013H\u0002J\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016J\b\u0010\u0010\u001a\u0004\u0018\u00010\rJ\u000e\u0010\u0017\u001a\u00020\u0018H\u0086@\u00a2\u0006\u0002\u0010\u0019J\u0006\u0010\u001a\u001a\u00020\u001bJ,\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\r0\u001d2\u0006\u0010\u001e\u001a\u00020\u00132\u0006\u0010\u001f\u001a\u00020\u0013H\u0086@\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\u0004\b \u0010!J\u000e\u0010\"\u001a\u00020\u0018H\u0086@\u00a2\u0006\u0002\u0010\u0019JF\u0010#\u001a\b\u0012\u0004\u0012\u00020\r0\u001d2\u0006\u0010\u001e\u001a\u00020\u00132\u0006\u0010\u001f\u001a\u00020\u00132\u0006\u0010$\u001a\u00020\u00132\b\u0010%\u001a\u0004\u0018\u00010\u00132\u0006\u0010&\u001a\u00020\'H\u0086@\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\u0004\b(\u0010)R\u0016\u0010\u000b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\r0\fX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0019\u0010\u000e\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\r0\u000f\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u0082\u0002\u000b\n\u0002\b!\n\u0005\b\u00a1\u001e0\u0001\u00a8\u0006*"}, d2 = {"Lcom/balancetech/sitemanagement/data/repository/AuthRepository;", "", "userDao", "Lcom/balancetech/sitemanagement/data/dao/UserDao;", "firebaseAuth", "Lcom/google/firebase/auth/FirebaseAuth;", "localDataSource", "Lcom/balancetech/sitemanagement/data/datasource/LocalDataSource;", "remoteDataSource", "Lcom/balancetech/sitemanagement/data/datasource/RemoteDataSource;", "(Lcom/balancetech/sitemanagement/data/dao/UserDao;Lcom/google/firebase/auth/FirebaseAuth;Lcom/balancetech/sitemanagement/data/datasource/LocalDataSource;Lcom/balancetech/sitemanagement/data/datasource/RemoteDataSource;)V", "_currentUser", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lcom/balancetech/sitemanagement/data/entity/User;", "currentUser", "Lkotlinx/coroutines/flow/StateFlow;", "getCurrentUser", "()Lkotlinx/coroutines/flow/StateFlow;", "getAuthErrorMessage", "", "errorCode", "getCurrentFirebaseUser", "Lcom/google/firebase/auth/FirebaseUser;", "initializeCurrentUser", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "isLoggedIn", "", "login", "Lkotlin/Result;", "email", "password", "login-0E7RQCE", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "logout", "register", "name", "phone", "role", "Lcom/balancetech/sitemanagement/data/model/UserRole;", "register-hUnOzRk", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/balancetech/sitemanagement/data/model/UserRole;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_debug"})
public final class AuthRepository {
    @org.jetbrains.annotations.NotNull
    private final com.balancetech.sitemanagement.data.dao.UserDao userDao = null;
    @org.jetbrains.annotations.NotNull
    private final com.google.firebase.auth.FirebaseAuth firebaseAuth = null;
    @org.jetbrains.annotations.NotNull
    private final com.balancetech.sitemanagement.data.datasource.LocalDataSource localDataSource = null;
    @org.jetbrains.annotations.NotNull
    private final com.balancetech.sitemanagement.data.datasource.RemoteDataSource remoteDataSource = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.MutableStateFlow<com.balancetech.sitemanagement.data.entity.User> _currentUser = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.StateFlow<com.balancetech.sitemanagement.data.entity.User> currentUser = null;
    
    @javax.inject.Inject
    public AuthRepository(@org.jetbrains.annotations.NotNull
    com.balancetech.sitemanagement.data.dao.UserDao userDao, @org.jetbrains.annotations.NotNull
    com.google.firebase.auth.FirebaseAuth firebaseAuth, @org.jetbrains.annotations.NotNull
    com.balancetech.sitemanagement.data.datasource.LocalDataSource localDataSource, @org.jetbrains.annotations.NotNull
    com.balancetech.sitemanagement.data.datasource.RemoteDataSource remoteDataSource) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.StateFlow<com.balancetech.sitemanagement.data.entity.User> getCurrentUser() {
        return null;
    }
    
    /**
     * Logout current user
     */
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object logout(@org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    /**
     * Get current logged in user
     */
    @org.jetbrains.annotations.Nullable
    public final com.balancetech.sitemanagement.data.entity.User getCurrentUser() {
        return null;
    }
    
    /**
     * Check if user is logged in
     */
    public final boolean isLoggedIn() {
        return false;
    }
    
    /**
     * Get current Firebase user
     */
    @org.jetbrains.annotations.Nullable
    public final com.google.firebase.auth.FirebaseUser getCurrentFirebaseUser() {
        return null;
    }
    
    /**
     * Initialize current user from Firebase Auth state
     */
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object initializeCurrentUser(@org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    /**
     * Convert Firebase Auth error code to user-friendly message
     */
    private final java.lang.String getAuthErrorMessage(java.lang.String errorCode) {
        return null;
    }
}