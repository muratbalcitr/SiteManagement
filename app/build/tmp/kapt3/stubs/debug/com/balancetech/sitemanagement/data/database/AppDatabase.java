package com.balancetech.sitemanagement.data.database;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\'\u0018\u0000 \u00192\u00020\u0001:\u0001\u0019B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H&J\b\u0010\u0005\u001a\u00020\u0006H&J\b\u0010\u0007\u001a\u00020\bH&J\b\u0010\t\u001a\u00020\nH&J\b\u0010\u000b\u001a\u00020\fH&J\b\u0010\r\u001a\u00020\u000eH&J\b\u0010\u000f\u001a\u00020\u0010H&J\b\u0010\u0011\u001a\u00020\u0012H&J\b\u0010\u0013\u001a\u00020\u0014H&J\b\u0010\u0015\u001a\u00020\u0016H&J\b\u0010\u0017\u001a\u00020\u0018H&\u00a8\u0006\u001a"}, d2 = {"Lcom/balancetech/sitemanagement/data/database/AppDatabase;", "Landroidx/room/RoomDatabase;", "()V", "apartmentDao", "Lcom/balancetech/sitemanagement/data/dao/ApartmentDao;", "blockDao", "Lcom/balancetech/sitemanagement/data/dao/BlockDao;", "extraPaymentDao", "Lcom/balancetech/sitemanagement/data/dao/ExtraPaymentDao;", "feeDao", "Lcom/balancetech/sitemanagement/data/dao/FeeDao;", "notificationDao", "Lcom/balancetech/sitemanagement/data/dao/NotificationDao;", "paymentDao", "Lcom/balancetech/sitemanagement/data/dao/PaymentDao;", "unitDao", "Lcom/balancetech/sitemanagement/data/dao/UnitDao;", "userDao", "Lcom/balancetech/sitemanagement/data/dao/UserDao;", "userUnitDao", "Lcom/balancetech/sitemanagement/data/dao/UserUnitDao;", "waterBillDao", "Lcom/balancetech/sitemanagement/data/dao/WaterBillDao;", "waterMeterDao", "Lcom/balancetech/sitemanagement/data/dao/WaterMeterDao;", "Companion", "app_debug"})
@androidx.room.Database(entities = {com.balancetech.sitemanagement.data.entity.User.class, com.balancetech.sitemanagement.data.entity.Apartment.class, com.balancetech.sitemanagement.data.entity.Block.class, com.balancetech.sitemanagement.data.entity.Unit.class, com.balancetech.sitemanagement.data.entity.UserUnit.class, com.balancetech.sitemanagement.data.entity.Fee.class, com.balancetech.sitemanagement.data.entity.ExtraPayment.class, com.balancetech.sitemanagement.data.entity.WaterMeter.class, com.balancetech.sitemanagement.data.entity.WaterBill.class, com.balancetech.sitemanagement.data.entity.Payment.class, com.balancetech.sitemanagement.data.entity.Notification.class}, version = 2, exportSchema = false)
public abstract class AppDatabase extends androidx.room.RoomDatabase {
    @kotlin.jvm.Volatile
    @org.jetbrains.annotations.Nullable
    private static volatile com.balancetech.sitemanagement.data.database.AppDatabase INSTANCE;
    @org.jetbrains.annotations.NotNull
    private static final androidx.room.migration.Migration MIGRATION_1_2 = null;
    @org.jetbrains.annotations.NotNull
    public static final com.balancetech.sitemanagement.data.database.AppDatabase.Companion Companion = null;
    
    public AppDatabase() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public abstract com.balancetech.sitemanagement.data.dao.UserDao userDao();
    
    @org.jetbrains.annotations.NotNull
    public abstract com.balancetech.sitemanagement.data.dao.UserUnitDao userUnitDao();
    
    @org.jetbrains.annotations.NotNull
    public abstract com.balancetech.sitemanagement.data.dao.ApartmentDao apartmentDao();
    
    @org.jetbrains.annotations.NotNull
    public abstract com.balancetech.sitemanagement.data.dao.BlockDao blockDao();
    
    @org.jetbrains.annotations.NotNull
    public abstract com.balancetech.sitemanagement.data.dao.UnitDao unitDao();
    
    @org.jetbrains.annotations.NotNull
    public abstract com.balancetech.sitemanagement.data.dao.FeeDao feeDao();
    
    @org.jetbrains.annotations.NotNull
    public abstract com.balancetech.sitemanagement.data.dao.PaymentDao paymentDao();
    
    @org.jetbrains.annotations.NotNull
    public abstract com.balancetech.sitemanagement.data.dao.WaterMeterDao waterMeterDao();
    
    @org.jetbrains.annotations.NotNull
    public abstract com.balancetech.sitemanagement.data.dao.WaterBillDao waterBillDao();
    
    @org.jetbrains.annotations.NotNull
    public abstract com.balancetech.sitemanagement.data.dao.ExtraPaymentDao extraPaymentDao();
    
    @org.jetbrains.annotations.NotNull
    public abstract com.balancetech.sitemanagement.data.dao.NotificationDao notificationDao();
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\tR\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\n"}, d2 = {"Lcom/balancetech/sitemanagement/data/database/AppDatabase$Companion;", "", "()V", "INSTANCE", "Lcom/balancetech/sitemanagement/data/database/AppDatabase;", "MIGRATION_1_2", "Landroidx/room/migration/Migration;", "getDatabase", "context", "Landroid/content/Context;", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
        
        @org.jetbrains.annotations.NotNull
        public final com.balancetech.sitemanagement.data.database.AppDatabase getDatabase(@org.jetbrains.annotations.NotNull
        android.content.Context context) {
            return null;
        }
    }
}