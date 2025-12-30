package com.balancetech.sitemanagement.di;

@dagger.Module
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u00c7\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0012\u0010\u0007\u001a\u00020\u00062\b\b\u0001\u0010\b\u001a\u00020\tH\u0007J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u0005\u001a\u00020\u0006H\u0007\u00a8\u0006\u001c"}, d2 = {"Lcom/balancetech/sitemanagement/di/DatabaseModule;", "", "()V", "provideApartmentDao", "Lcom/balancetech/sitemanagement/data/dao/ApartmentDao;", "database", "Lcom/balancetech/sitemanagement/data/database/AppDatabase;", "provideAppDatabase", "context", "Landroid/content/Context;", "provideBlockDao", "Lcom/balancetech/sitemanagement/data/dao/BlockDao;", "provideExtraPaymentDao", "Lcom/balancetech/sitemanagement/data/dao/ExtraPaymentDao;", "provideFeeDao", "Lcom/balancetech/sitemanagement/data/dao/FeeDao;", "provideNotificationDao", "Lcom/balancetech/sitemanagement/data/dao/NotificationDao;", "providePaymentDao", "Lcom/balancetech/sitemanagement/data/dao/PaymentDao;", "provideUnitDao", "Lcom/balancetech/sitemanagement/data/dao/UnitDao;", "provideUserDao", "Lcom/balancetech/sitemanagement/data/dao/UserDao;", "provideWaterBillDao", "Lcom/balancetech/sitemanagement/data/dao/WaterBillDao;", "provideWaterMeterDao", "Lcom/balancetech/sitemanagement/data/dao/WaterMeterDao;", "app_debug"})
@dagger.hilt.InstallIn(value = {dagger.hilt.components.SingletonComponent.class})
public final class DatabaseModule {
    @org.jetbrains.annotations.NotNull
    public static final com.balancetech.sitemanagement.di.DatabaseModule INSTANCE = null;
    
    private DatabaseModule() {
        super();
    }
    
    @dagger.Provides
    @javax.inject.Singleton
    @org.jetbrains.annotations.NotNull
    public final com.balancetech.sitemanagement.data.database.AppDatabase provideAppDatabase(@dagger.hilt.android.qualifiers.ApplicationContext
    @org.jetbrains.annotations.NotNull
    android.content.Context context) {
        return null;
    }
    
    @dagger.Provides
    @org.jetbrains.annotations.NotNull
    public final com.balancetech.sitemanagement.data.dao.UserDao provideUserDao(@org.jetbrains.annotations.NotNull
    com.balancetech.sitemanagement.data.database.AppDatabase database) {
        return null;
    }
    
    @dagger.Provides
    @org.jetbrains.annotations.NotNull
    public final com.balancetech.sitemanagement.data.dao.ApartmentDao provideApartmentDao(@org.jetbrains.annotations.NotNull
    com.balancetech.sitemanagement.data.database.AppDatabase database) {
        return null;
    }
    
    @dagger.Provides
    @org.jetbrains.annotations.NotNull
    public final com.balancetech.sitemanagement.data.dao.BlockDao provideBlockDao(@org.jetbrains.annotations.NotNull
    com.balancetech.sitemanagement.data.database.AppDatabase database) {
        return null;
    }
    
    @dagger.Provides
    @org.jetbrains.annotations.NotNull
    public final com.balancetech.sitemanagement.data.dao.UnitDao provideUnitDao(@org.jetbrains.annotations.NotNull
    com.balancetech.sitemanagement.data.database.AppDatabase database) {
        return null;
    }
    
    @dagger.Provides
    @org.jetbrains.annotations.NotNull
    public final com.balancetech.sitemanagement.data.dao.FeeDao provideFeeDao(@org.jetbrains.annotations.NotNull
    com.balancetech.sitemanagement.data.database.AppDatabase database) {
        return null;
    }
    
    @dagger.Provides
    @org.jetbrains.annotations.NotNull
    public final com.balancetech.sitemanagement.data.dao.PaymentDao providePaymentDao(@org.jetbrains.annotations.NotNull
    com.balancetech.sitemanagement.data.database.AppDatabase database) {
        return null;
    }
    
    @dagger.Provides
    @org.jetbrains.annotations.NotNull
    public final com.balancetech.sitemanagement.data.dao.WaterMeterDao provideWaterMeterDao(@org.jetbrains.annotations.NotNull
    com.balancetech.sitemanagement.data.database.AppDatabase database) {
        return null;
    }
    
    @dagger.Provides
    @org.jetbrains.annotations.NotNull
    public final com.balancetech.sitemanagement.data.dao.WaterBillDao provideWaterBillDao(@org.jetbrains.annotations.NotNull
    com.balancetech.sitemanagement.data.database.AppDatabase database) {
        return null;
    }
    
    @dagger.Provides
    @org.jetbrains.annotations.NotNull
    public final com.balancetech.sitemanagement.data.dao.ExtraPaymentDao provideExtraPaymentDao(@org.jetbrains.annotations.NotNull
    com.balancetech.sitemanagement.data.database.AppDatabase database) {
        return null;
    }
    
    @dagger.Provides
    @org.jetbrains.annotations.NotNull
    public final com.balancetech.sitemanagement.data.dao.NotificationDao provideNotificationDao(@org.jetbrains.annotations.NotNull
    com.balancetech.sitemanagement.data.database.AppDatabase database) {
        return null;
    }
}