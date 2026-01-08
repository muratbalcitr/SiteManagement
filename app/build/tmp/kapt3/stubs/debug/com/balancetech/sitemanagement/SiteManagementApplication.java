package com.balancetech.sitemanagement;

@dagger.hilt.android.HiltAndroidApp
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0007\u0018\u0000 \r2\u00020\u0001:\u0002\r\u000eB\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u000b\u001a\u00020\fH\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001b\u0010\u0005\u001a\u00020\u00068BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\b\u00a8\u0006\u000f"}, d2 = {"Lcom/balancetech/sitemanagement/SiteManagementApplication;", "Landroid/app/Application;", "()V", "applicationScope", "Lkotlinx/coroutines/CoroutineScope;", "prefs", "Landroid/content/SharedPreferences;", "getPrefs", "()Landroid/content/SharedPreferences;", "prefs$delegate", "Lkotlin/Lazy;", "onCreate", "", "Companion", "DatabaseSeedEntryPoint", "app_debug"})
public final class SiteManagementApplication extends android.app.Application {
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.CoroutineScope applicationScope = null;
    @org.jetbrains.annotations.NotNull
    private final kotlin.Lazy prefs$delegate = null;
    @org.jetbrains.annotations.NotNull
    private static final java.lang.String PREF_FIRST_LAUNCH = "is_first_launch";
    @org.jetbrains.annotations.NotNull
    public static final com.balancetech.sitemanagement.SiteManagementApplication.Companion Companion = null;
    
    public SiteManagementApplication() {
        super();
    }
    
    private final android.content.SharedPreferences getPrefs() {
        return null;
    }
    
    @java.lang.Override
    public void onCreate() {
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0005"}, d2 = {"Lcom/balancetech/sitemanagement/SiteManagementApplication$Companion;", "", "()V", "PREF_FIRST_LAUNCH", "", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0005H&J\b\u0010\u0006\u001a\u00020\u0007H&\u00a8\u0006\b"}, d2 = {"Lcom/balancetech/sitemanagement/SiteManagementApplication$DatabaseSeedEntryPoint;", "", "blockDao", "Lcom/balancetech/sitemanagement/data/dao/BlockDao;", "syncRepository", "Lcom/balancetech/sitemanagement/data/repository/SyncRepository;", "unitDao", "Lcom/balancetech/sitemanagement/data/dao/UnitDao;", "app_debug"})
    @dagger.hilt.EntryPoint
    @dagger.hilt.InstallIn(value = {dagger.hilt.components.SingletonComponent.class})
    public static abstract interface DatabaseSeedEntryPoint {
        
        @org.jetbrains.annotations.NotNull
        public abstract com.balancetech.sitemanagement.data.dao.BlockDao blockDao();
        
        @org.jetbrains.annotations.NotNull
        public abstract com.balancetech.sitemanagement.data.dao.UnitDao unitDao();
        
        @org.jetbrains.annotations.NotNull
        public abstract com.balancetech.sitemanagement.data.repository.SyncRepository syncRepository();
    }
}