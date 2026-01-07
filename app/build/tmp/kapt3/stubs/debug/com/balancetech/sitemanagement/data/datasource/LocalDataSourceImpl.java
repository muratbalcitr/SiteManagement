package com.balancetech.sitemanagement.data.datasource;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u00a6\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\"\u0018\u00002\u00020\u0001BO\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u0011\u0012\u0006\u0010\u0012\u001a\u00020\u0013\u00a2\u0006\u0002\u0010\u0014J\u0014\u0010\u0015\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00180\u00170\u0016H\u0016J\u0014\u0010\u0019\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001a0\u00170\u0016H\u0016J\u0014\u0010\u001b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001c0\u00170\u0016H\u0016J\u0014\u0010\u001d\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001e0\u00170\u0016H\u0016J\u001c\u0010\u001f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020 0\u00170\u00162\u0006\u0010!\u001a\u00020\"H\u0016J\u0010\u0010#\u001a\u0004\u0018\u00010\u0018H\u0096@\u00a2\u0006\u0002\u0010$J\u0018\u0010%\u001a\u0004\u0018\u00010\u001a2\u0006\u0010&\u001a\u00020\"H\u0096@\u00a2\u0006\u0002\u0010\'J,\u0010(\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001a0\u00170\u00162\u0006\u0010!\u001a\u00020\"2\u0006\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020*H\u0016J\u001c\u0010,\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001a0\u00170\u00162\u0006\u0010-\u001a\u00020\"H\u0016J$\u0010.\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001a0\u00170\u00162\u0006\u0010-\u001a\u00020\"2\u0006\u0010/\u001a\u000200H\u0016J\u001c\u00101\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002020\u00170\u00162\u0006\u00103\u001a\u00020\"H\u0016J\u001c\u00104\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001c0\u00170\u00162\u0006\u00105\u001a\u00020\"H\u0016J\u001c\u00106\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001c0\u00170\u00162\u0006\u0010-\u001a\u00020\"H\u0016J\u0018\u00107\u001a\u0004\u0018\u0001082\u0006\u0010&\u001a\u00020\"H\u0096@\u00a2\u0006\u0002\u0010\'J\u001c\u00109\u001a\b\u0012\u0004\u0012\u0002080\u00172\u0006\u0010!\u001a\u00020\"H\u0096@\u00a2\u0006\u0002\u0010\'J\u001c\u0010:\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002080\u00170\u00162\u0006\u0010;\u001a\u00020\"H\u0016J\u0016\u0010<\u001a\b\u0012\u0004\u0012\u00020*0\u00162\u0006\u00103\u001a\u00020\"H\u0016J\u001c\u0010=\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002020\u00170\u00162\u0006\u00103\u001a\u00020\"H\u0016J\u0018\u0010>\u001a\u0004\u0018\u00010\u00182\u0006\u0010?\u001a\u00020\"H\u0096@\u00a2\u0006\u0002\u0010\'J\u0018\u0010@\u001a\u0004\u0018\u00010\u00182\u0006\u0010&\u001a\u00020\"H\u0096@\u00a2\u0006\u0002\u0010\'J\u001c\u0010A\u001a\b\u0012\u0004\u0012\u00020\"0\u00172\u0006\u0010-\u001a\u00020\"H\u0096@\u00a2\u0006\u0002\u0010\'J\u001c\u0010B\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00180\u00170\u00162\u0006\u0010C\u001a\u00020DH\u0016J\u001c\u0010E\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00180\u00170\u00162\u0006\u0010-\u001a\u00020\"H\u0016J\u0018\u0010F\u001a\u0004\u0018\u00010G2\u0006\u0010&\u001a\u00020\"H\u0096@\u00a2\u0006\u0002\u0010\'J\u001c\u0010H\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020G0\u00170\u00162\u0006\u0010-\u001a\u00020\"H\u0016J\u0018\u0010I\u001a\u0004\u0018\u00010\u001e2\u0006\u0010-\u001a\u00020\"H\u0096@\u00a2\u0006\u0002\u0010\'J\u0016\u0010J\u001a\u00020K2\u0006\u0010L\u001a\u00020 H\u0096@\u00a2\u0006\u0002\u0010MJ\u0016\u0010N\u001a\u00020K2\u0006\u0010O\u001a\u00020\u001aH\u0096@\u00a2\u0006\u0002\u0010PJ\u001c\u0010Q\u001a\u00020K2\f\u0010R\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0017H\u0096@\u00a2\u0006\u0002\u0010SJ\u0016\u0010T\u001a\u00020K2\u0006\u0010U\u001a\u000202H\u0096@\u00a2\u0006\u0002\u0010VJ\u0016\u0010W\u001a\u00020K2\u0006\u0010X\u001a\u00020\u001cH\u0096@\u00a2\u0006\u0002\u0010YJ\u0016\u0010Z\u001a\u00020K2\u0006\u0010[\u001a\u000208H\u0096@\u00a2\u0006\u0002\u0010\\J\u0016\u0010]\u001a\u00020K2\u0006\u0010^\u001a\u00020\u0018H\u0096@\u00a2\u0006\u0002\u0010_J\u0016\u0010`\u001a\u00020K2\u0006\u0010a\u001a\u00020GH\u0096@\u00a2\u0006\u0002\u0010bJ\u0016\u0010c\u001a\u00020K2\u0006\u0010d\u001a\u00020\u001eH\u0096@\u00a2\u0006\u0002\u0010eJ\u0016\u0010f\u001a\u00020K2\u0006\u00103\u001a\u00020\"H\u0096@\u00a2\u0006\u0002\u0010\'J\u0016\u0010g\u001a\u00020K2\u0006\u0010h\u001a\u00020\"H\u0096@\u00a2\u0006\u0002\u0010\'J\u0016\u0010i\u001a\u00020K2\u0006\u0010O\u001a\u00020\u001aH\u0096@\u00a2\u0006\u0002\u0010PJ\u0016\u0010j\u001a\u00020K2\u0006\u0010^\u001a\u00020\u0018H\u0096@\u00a2\u0006\u0002\u0010_J\u0016\u0010k\u001a\u00020K2\u0006\u0010a\u001a\u00020GH\u0096@\u00a2\u0006\u0002\u0010bJ\u0016\u0010l\u001a\u00020K2\u0006\u0010d\u001a\u00020\u001eH\u0096@\u00a2\u0006\u0002\u0010eR\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006m"}, d2 = {"Lcom/balancetech/sitemanagement/data/datasource/LocalDataSourceImpl;", "Lcom/balancetech/sitemanagement/data/datasource/LocalDataSource;", "userDao", "Lcom/balancetech/sitemanagement/data/dao/UserDao;", "feeDao", "Lcom/balancetech/sitemanagement/data/dao/FeeDao;", "paymentDao", "Lcom/balancetech/sitemanagement/data/dao/PaymentDao;", "waterMeterDao", "Lcom/balancetech/sitemanagement/data/dao/WaterMeterDao;", "waterBillDao", "Lcom/balancetech/sitemanagement/data/dao/WaterBillDao;", "notificationDao", "Lcom/balancetech/sitemanagement/data/dao/NotificationDao;", "unitDao", "Lcom/balancetech/sitemanagement/data/dao/UnitDao;", "blockDao", "Lcom/balancetech/sitemanagement/data/dao/BlockDao;", "userUnitDao", "Lcom/balancetech/sitemanagement/data/dao/UserUnitDao;", "(Lcom/balancetech/sitemanagement/data/dao/UserDao;Lcom/balancetech/sitemanagement/data/dao/FeeDao;Lcom/balancetech/sitemanagement/data/dao/PaymentDao;Lcom/balancetech/sitemanagement/data/dao/WaterMeterDao;Lcom/balancetech/sitemanagement/data/dao/WaterBillDao;Lcom/balancetech/sitemanagement/data/dao/NotificationDao;Lcom/balancetech/sitemanagement/data/dao/UnitDao;Lcom/balancetech/sitemanagement/data/dao/BlockDao;Lcom/balancetech/sitemanagement/data/dao/UserUnitDao;)V", "getAllActiveUsers", "Lkotlinx/coroutines/flow/Flow;", "", "Lcom/balancetech/sitemanagement/data/entity/User;", "getAllFees", "Lcom/balancetech/sitemanagement/data/entity/Fee;", "getAllPayments", "Lcom/balancetech/sitemanagement/data/entity/Payment;", "getAllWaterMeters", "Lcom/balancetech/sitemanagement/data/entity/WaterMeter;", "getBlocksByApartment", "Lcom/balancetech/sitemanagement/data/entity/Block;", "apartmentId", "", "getCurrentUser", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getFeeById", "id", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getFeesByMonth", "month", "", "year", "getFeesByUnit", "unitId", "getFeesByUnitAndStatus", "status", "Lcom/balancetech/sitemanagement/data/model/PaymentStatus;", "getNotificationsByUser", "Lcom/balancetech/sitemanagement/data/entity/Notification;", "userId", "getPaymentsByFee", "feeId", "getPaymentsByUnit", "getUnitById", "Lcom/balancetech/sitemanagement/data/entity/Unit;", "getUnitsByApartment", "getUnitsByBlock", "blockId", "getUnreadNotificationCount", "getUnreadNotificationsByUser", "getUserByEmail", "email", "getUserById", "getUserIdsByUnitId", "getUsersByRole", "role", "Lcom/balancetech/sitemanagement/data/model/UserRole;", "getUsersByUnit", "getWaterBillById", "Lcom/balancetech/sitemanagement/data/entity/WaterBill;", "getWaterBillsByUnit", "getWaterMeterByUnit", "insertBlock", "", "block", "(Lcom/balancetech/sitemanagement/data/entity/Block;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "insertFee", "fee", "(Lcom/balancetech/sitemanagement/data/entity/Fee;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "insertFees", "fees", "(Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "insertNotification", "notification", "(Lcom/balancetech/sitemanagement/data/entity/Notification;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "insertPayment", "payment", "(Lcom/balancetech/sitemanagement/data/entity/Payment;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "insertUnit", "unit", "(Lcom/balancetech/sitemanagement/data/entity/Unit;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "insertUser", "user", "(Lcom/balancetech/sitemanagement/data/entity/User;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "insertWaterBill", "waterBill", "(Lcom/balancetech/sitemanagement/data/entity/WaterBill;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "insertWaterMeter", "waterMeter", "(Lcom/balancetech/sitemanagement/data/entity/WaterMeter;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "markAllAsRead", "markAsRead", "notificationId", "updateFee", "updateUser", "updateWaterBill", "updateWaterMeter", "app_debug"})
public final class LocalDataSourceImpl implements com.balancetech.sitemanagement.data.datasource.LocalDataSource {
    @org.jetbrains.annotations.NotNull
    private final com.balancetech.sitemanagement.data.dao.UserDao userDao = null;
    @org.jetbrains.annotations.NotNull
    private final com.balancetech.sitemanagement.data.dao.FeeDao feeDao = null;
    @org.jetbrains.annotations.NotNull
    private final com.balancetech.sitemanagement.data.dao.PaymentDao paymentDao = null;
    @org.jetbrains.annotations.NotNull
    private final com.balancetech.sitemanagement.data.dao.WaterMeterDao waterMeterDao = null;
    @org.jetbrains.annotations.NotNull
    private final com.balancetech.sitemanagement.data.dao.WaterBillDao waterBillDao = null;
    @org.jetbrains.annotations.NotNull
    private final com.balancetech.sitemanagement.data.dao.NotificationDao notificationDao = null;
    @org.jetbrains.annotations.NotNull
    private final com.balancetech.sitemanagement.data.dao.UnitDao unitDao = null;
    @org.jetbrains.annotations.NotNull
    private final com.balancetech.sitemanagement.data.dao.BlockDao blockDao = null;
    @org.jetbrains.annotations.NotNull
    private final com.balancetech.sitemanagement.data.dao.UserUnitDao userUnitDao = null;
    
    @javax.inject.Inject
    public LocalDataSourceImpl(@org.jetbrains.annotations.NotNull
    com.balancetech.sitemanagement.data.dao.UserDao userDao, @org.jetbrains.annotations.NotNull
    com.balancetech.sitemanagement.data.dao.FeeDao feeDao, @org.jetbrains.annotations.NotNull
    com.balancetech.sitemanagement.data.dao.PaymentDao paymentDao, @org.jetbrains.annotations.NotNull
    com.balancetech.sitemanagement.data.dao.WaterMeterDao waterMeterDao, @org.jetbrains.annotations.NotNull
    com.balancetech.sitemanagement.data.dao.WaterBillDao waterBillDao, @org.jetbrains.annotations.NotNull
    com.balancetech.sitemanagement.data.dao.NotificationDao notificationDao, @org.jetbrains.annotations.NotNull
    com.balancetech.sitemanagement.data.dao.UnitDao unitDao, @org.jetbrains.annotations.NotNull
    com.balancetech.sitemanagement.data.dao.BlockDao blockDao, @org.jetbrains.annotations.NotNull
    com.balancetech.sitemanagement.data.dao.UserUnitDao userUnitDao) {
        super();
    }
    
    @java.lang.Override
    @org.jetbrains.annotations.Nullable
    public java.lang.Object getUserByEmail(@org.jetbrains.annotations.NotNull
    java.lang.String email, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super com.balancetech.sitemanagement.data.entity.User> $completion) {
        return null;
    }
    
    @java.lang.Override
    @org.jetbrains.annotations.Nullable
    public java.lang.Object getUserById(@org.jetbrains.annotations.NotNull
    java.lang.String id, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super com.balancetech.sitemanagement.data.entity.User> $completion) {
        return null;
    }
    
    @java.lang.Override
    @org.jetbrains.annotations.Nullable
    public java.lang.Object insertUser(@org.jetbrains.annotations.NotNull
    com.balancetech.sitemanagement.data.entity.User user, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    @java.lang.Override
    @org.jetbrains.annotations.Nullable
    public java.lang.Object getCurrentUser(@org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super com.balancetech.sitemanagement.data.entity.User> $completion) {
        return null;
    }
    
    @java.lang.Override
    @org.jetbrains.annotations.NotNull
    public kotlinx.coroutines.flow.Flow<java.util.List<com.balancetech.sitemanagement.data.entity.User>> getAllActiveUsers() {
        return null;
    }
    
    @java.lang.Override
    @org.jetbrains.annotations.NotNull
    public kotlinx.coroutines.flow.Flow<java.util.List<com.balancetech.sitemanagement.data.entity.User>> getUsersByRole(@org.jetbrains.annotations.NotNull
    com.balancetech.sitemanagement.data.model.UserRole role) {
        return null;
    }
    
    @java.lang.Override
    @org.jetbrains.annotations.NotNull
    public kotlinx.coroutines.flow.Flow<java.util.List<com.balancetech.sitemanagement.data.entity.User>> getUsersByUnit(@org.jetbrains.annotations.NotNull
    java.lang.String unitId) {
        return null;
    }
    
    @java.lang.Override
    @org.jetbrains.annotations.Nullable
    public java.lang.Object getUserIdsByUnitId(@org.jetbrains.annotations.NotNull
    java.lang.String unitId, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super java.util.List<java.lang.String>> $completion) {
        return null;
    }
    
    @java.lang.Override
    @org.jetbrains.annotations.Nullable
    public java.lang.Object updateUser(@org.jetbrains.annotations.NotNull
    com.balancetech.sitemanagement.data.entity.User user, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    @java.lang.Override
    @org.jetbrains.annotations.NotNull
    public kotlinx.coroutines.flow.Flow<java.util.List<com.balancetech.sitemanagement.data.entity.Fee>> getFeesByUnit(@org.jetbrains.annotations.NotNull
    java.lang.String unitId) {
        return null;
    }
    
    @java.lang.Override
    @org.jetbrains.annotations.NotNull
    public kotlinx.coroutines.flow.Flow<java.util.List<com.balancetech.sitemanagement.data.entity.Fee>> getFeesByMonth(@org.jetbrains.annotations.NotNull
    java.lang.String apartmentId, int month, int year) {
        return null;
    }
    
    @java.lang.Override
    @org.jetbrains.annotations.NotNull
    public kotlinx.coroutines.flow.Flow<java.util.List<com.balancetech.sitemanagement.data.entity.Fee>> getFeesByUnitAndStatus(@org.jetbrains.annotations.NotNull
    java.lang.String unitId, @org.jetbrains.annotations.NotNull
    com.balancetech.sitemanagement.data.model.PaymentStatus status) {
        return null;
    }
    
    @java.lang.Override
    @org.jetbrains.annotations.NotNull
    public kotlinx.coroutines.flow.Flow<java.util.List<com.balancetech.sitemanagement.data.entity.Fee>> getAllFees() {
        return null;
    }
    
    @java.lang.Override
    @org.jetbrains.annotations.Nullable
    public java.lang.Object getFeeById(@org.jetbrains.annotations.NotNull
    java.lang.String id, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super com.balancetech.sitemanagement.data.entity.Fee> $completion) {
        return null;
    }
    
    @java.lang.Override
    @org.jetbrains.annotations.Nullable
    public java.lang.Object insertFee(@org.jetbrains.annotations.NotNull
    com.balancetech.sitemanagement.data.entity.Fee fee, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    @java.lang.Override
    @org.jetbrains.annotations.Nullable
    public java.lang.Object insertFees(@org.jetbrains.annotations.NotNull
    java.util.List<com.balancetech.sitemanagement.data.entity.Fee> fees, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    @java.lang.Override
    @org.jetbrains.annotations.Nullable
    public java.lang.Object updateFee(@org.jetbrains.annotations.NotNull
    com.balancetech.sitemanagement.data.entity.Fee fee, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    @java.lang.Override
    @org.jetbrains.annotations.NotNull
    public kotlinx.coroutines.flow.Flow<java.util.List<com.balancetech.sitemanagement.data.entity.Payment>> getPaymentsByUnit(@org.jetbrains.annotations.NotNull
    java.lang.String unitId) {
        return null;
    }
    
    @java.lang.Override
    @org.jetbrains.annotations.NotNull
    public kotlinx.coroutines.flow.Flow<java.util.List<com.balancetech.sitemanagement.data.entity.Payment>> getPaymentsByFee(@org.jetbrains.annotations.NotNull
    java.lang.String feeId) {
        return null;
    }
    
    @java.lang.Override
    @org.jetbrains.annotations.NotNull
    public kotlinx.coroutines.flow.Flow<java.util.List<com.balancetech.sitemanagement.data.entity.Payment>> getAllPayments() {
        return null;
    }
    
    @java.lang.Override
    @org.jetbrains.annotations.Nullable
    public java.lang.Object insertPayment(@org.jetbrains.annotations.NotNull
    com.balancetech.sitemanagement.data.entity.Payment payment, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    @java.lang.Override
    @org.jetbrains.annotations.NotNull
    public kotlinx.coroutines.flow.Flow<java.util.List<com.balancetech.sitemanagement.data.entity.WaterMeter>> getAllWaterMeters() {
        return null;
    }
    
    @java.lang.Override
    @org.jetbrains.annotations.Nullable
    public java.lang.Object getWaterMeterByUnit(@org.jetbrains.annotations.NotNull
    java.lang.String unitId, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super com.balancetech.sitemanagement.data.entity.WaterMeter> $completion) {
        return null;
    }
    
    @java.lang.Override
    @org.jetbrains.annotations.Nullable
    public java.lang.Object insertWaterMeter(@org.jetbrains.annotations.NotNull
    com.balancetech.sitemanagement.data.entity.WaterMeter waterMeter, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    @java.lang.Override
    @org.jetbrains.annotations.Nullable
    public java.lang.Object updateWaterMeter(@org.jetbrains.annotations.NotNull
    com.balancetech.sitemanagement.data.entity.WaterMeter waterMeter, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    @java.lang.Override
    @org.jetbrains.annotations.NotNull
    public kotlinx.coroutines.flow.Flow<java.util.List<com.balancetech.sitemanagement.data.entity.WaterBill>> getWaterBillsByUnit(@org.jetbrains.annotations.NotNull
    java.lang.String unitId) {
        return null;
    }
    
    @java.lang.Override
    @org.jetbrains.annotations.Nullable
    public java.lang.Object getWaterBillById(@org.jetbrains.annotations.NotNull
    java.lang.String id, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super com.balancetech.sitemanagement.data.entity.WaterBill> $completion) {
        return null;
    }
    
    @java.lang.Override
    @org.jetbrains.annotations.Nullable
    public java.lang.Object insertWaterBill(@org.jetbrains.annotations.NotNull
    com.balancetech.sitemanagement.data.entity.WaterBill waterBill, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    @java.lang.Override
    @org.jetbrains.annotations.Nullable
    public java.lang.Object updateWaterBill(@org.jetbrains.annotations.NotNull
    com.balancetech.sitemanagement.data.entity.WaterBill waterBill, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    @java.lang.Override
    @org.jetbrains.annotations.NotNull
    public kotlinx.coroutines.flow.Flow<java.util.List<com.balancetech.sitemanagement.data.entity.Notification>> getNotificationsByUser(@org.jetbrains.annotations.NotNull
    java.lang.String userId) {
        return null;
    }
    
    @java.lang.Override
    @org.jetbrains.annotations.NotNull
    public kotlinx.coroutines.flow.Flow<java.util.List<com.balancetech.sitemanagement.data.entity.Notification>> getUnreadNotificationsByUser(@org.jetbrains.annotations.NotNull
    java.lang.String userId) {
        return null;
    }
    
    @java.lang.Override
    @org.jetbrains.annotations.NotNull
    public kotlinx.coroutines.flow.Flow<java.lang.Integer> getUnreadNotificationCount(@org.jetbrains.annotations.NotNull
    java.lang.String userId) {
        return null;
    }
    
    @java.lang.Override
    @org.jetbrains.annotations.Nullable
    public java.lang.Object insertNotification(@org.jetbrains.annotations.NotNull
    com.balancetech.sitemanagement.data.entity.Notification notification, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    @java.lang.Override
    @org.jetbrains.annotations.Nullable
    public java.lang.Object markAsRead(@org.jetbrains.annotations.NotNull
    java.lang.String notificationId, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    @java.lang.Override
    @org.jetbrains.annotations.Nullable
    public java.lang.Object markAllAsRead(@org.jetbrains.annotations.NotNull
    java.lang.String userId, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    @java.lang.Override
    @org.jetbrains.annotations.Nullable
    public java.lang.Object getUnitsByApartment(@org.jetbrains.annotations.NotNull
    java.lang.String apartmentId, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super java.util.List<com.balancetech.sitemanagement.data.entity.Unit>> $completion) {
        return null;
    }
    
    @java.lang.Override
    @org.jetbrains.annotations.Nullable
    public java.lang.Object getUnitById(@org.jetbrains.annotations.NotNull
    java.lang.String id, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super com.balancetech.sitemanagement.data.entity.Unit> $completion) {
        return null;
    }
    
    @java.lang.Override
    @org.jetbrains.annotations.NotNull
    public kotlinx.coroutines.flow.Flow<java.util.List<com.balancetech.sitemanagement.data.entity.Unit>> getUnitsByBlock(@org.jetbrains.annotations.NotNull
    java.lang.String blockId) {
        return null;
    }
    
    @java.lang.Override
    @org.jetbrains.annotations.NotNull
    public kotlinx.coroutines.flow.Flow<java.util.List<com.balancetech.sitemanagement.data.entity.Block>> getBlocksByApartment(@org.jetbrains.annotations.NotNull
    java.lang.String apartmentId) {
        return null;
    }
    
    @java.lang.Override
    @org.jetbrains.annotations.Nullable
    public java.lang.Object insertBlock(@org.jetbrains.annotations.NotNull
    com.balancetech.sitemanagement.data.entity.Block block, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    @java.lang.Override
    @org.jetbrains.annotations.Nullable
    public java.lang.Object insertUnit(@org.jetbrains.annotations.NotNull
    com.balancetech.sitemanagement.data.entity.Unit unit, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
}