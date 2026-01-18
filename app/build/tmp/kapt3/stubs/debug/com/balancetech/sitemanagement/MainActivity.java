package com.balancetech.sitemanagement;

@dagger.hilt.android.AndroidEntryPoint
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0002J\u0012\u0010\u0015\u001a\u00020\u00122\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0014J\b\u0010\u0018\u001a\u00020\u0012H\u0014J\b\u0010\u0019\u001a\u00020\u001aH\u0016J\u0010\u0010\u001b\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0002R\u001e\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001e\u0010\u000b\u001a\u00020\f8\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010\u00a8\u0006\u001c"}, d2 = {"Lcom/balancetech/sitemanagement/MainActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "()V", "authRepository", "Lcom/balancetech/sitemanagement/data/repository/AuthRepository;", "getAuthRepository", "()Lcom/balancetech/sitemanagement/data/repository/AuthRepository;", "setAuthRepository", "(Lcom/balancetech/sitemanagement/data/repository/AuthRepository;)V", "authStateListener", "Lcom/google/firebase/auth/FirebaseAuth$AuthStateListener;", "firebaseAuth", "Lcom/google/firebase/auth/FirebaseAuth;", "getFirebaseAuth", "()Lcom/google/firebase/auth/FirebaseAuth;", "setFirebaseAuth", "(Lcom/google/firebase/auth/FirebaseAuth;)V", "checkAuthState", "", "navController", "Landroidx/navigation/NavController;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onSupportNavigateUp", "", "setupAuthStateListener", "app_debug"})
public final class MainActivity extends androidx.appcompat.app.AppCompatActivity {
    @javax.inject.Inject
    public com.balancetech.sitemanagement.data.repository.AuthRepository authRepository;
    @javax.inject.Inject
    public com.google.firebase.auth.FirebaseAuth firebaseAuth;
    @org.jetbrains.annotations.Nullable
    private com.google.firebase.auth.FirebaseAuth.AuthStateListener authStateListener;
    
    public MainActivity() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.balancetech.sitemanagement.data.repository.AuthRepository getAuthRepository() {
        return null;
    }
    
    public final void setAuthRepository(@org.jetbrains.annotations.NotNull
    com.balancetech.sitemanagement.data.repository.AuthRepository p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.google.firebase.auth.FirebaseAuth getFirebaseAuth() {
        return null;
    }
    
    public final void setFirebaseAuth(@org.jetbrains.annotations.NotNull
    com.google.firebase.auth.FirebaseAuth p0) {
    }
    
    @java.lang.Override
    protected void onCreate(@org.jetbrains.annotations.Nullable
    android.os.Bundle savedInstanceState) {
    }
    
    private final void checkAuthState(androidx.navigation.NavController navController) {
    }
    
    private final void setupAuthStateListener(androidx.navigation.NavController navController) {
    }
    
    @java.lang.Override
    public boolean onSupportNavigateUp() {
        return false;
    }
    
    @java.lang.Override
    protected void onDestroy() {
    }
}