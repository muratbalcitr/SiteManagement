package com.balancetech.sitemanagement;

@dagger.hilt.android.HiltAndroidApp
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001:\u0001\u0007B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0005\u001a\u00020\u0006H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\b"}, d2 = {"Lcom/balancetech/sitemanagement/SiteManagementApplication;", "Landroid/app/Application;", "()V", "applicationScope", "Lkotlinx/coroutines/CoroutineScope;", "onCreate", "", "DatabaseSeedEntryPoint", "app_debug"})
public final class SiteManagementApplication extends android.app.Application {
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.CoroutineScope applicationScope = null;
    
    public SiteManagementApplication() {
        super();
    }
    
    @java.lang.Override
    public void onCreate() {
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0005H&\u00a8\u0006\u0006"}, d2 = {"Lcom/balancetech/sitemanagement/SiteManagementApplication$DatabaseSeedEntryPoint;", "", "blockDao", "Lcom/balancetech/sitemanagement/data/dao/BlockDao;", "unitDao", "Lcom/balancetech/sitemanagement/data/dao/UnitDao;", "app_debug"})
    @dagger.hilt.EntryPoint
    @dagger.hilt.InstallIn(value = {dagger.hilt.components.SingletonComponent.class})
    public static abstract interface DatabaseSeedEntryPoint {
        
        @org.jetbrains.annotations.NotNull
        public abstract com.balancetech.sitemanagement.data.dao.BlockDao blockDao();
        
        @org.jetbrains.annotations.NotNull
        public abstract com.balancetech.sitemanagement.data.dao.UnitDao unitDao();
    }
}