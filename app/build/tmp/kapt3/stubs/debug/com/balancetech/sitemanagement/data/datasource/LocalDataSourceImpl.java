package com.balancetech.sitemanagement.data.datasource;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u00b4\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b)\u0018\u00002\u00020\u0001BW\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u0011\u0012\u0006\u0010\u0012\u001a\u00020\u0013\u0012\u0006\u0010\u0014\u001a\u00020\u0015\u00a2\u0006\u0002\u0010\u0016J\u0014\u0010\u0017\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001a0\u00190\u0018H\u0016J\u0014\u0010\u001b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001c0\u00190\u0018H\u0016J\u0014\u0010\u001d\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001e0\u00190\u0018H\u0016J\u0014\u0010\u001f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020 0\u00190\u0018H\u0016J\u001c\u0010!\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\"0\u00190\u00182\u0006\u0010#\u001a\u00020$H\u0016J\u0010\u0010%\u001a\u0004\u0018\u00010\u001aH\u0096@\u00a2\u0006\u0002\u0010&J\u0018\u0010\'\u001a\u0004\u0018\u00010\u001c2\u0006\u0010(\u001a\u00020$H\u0096@\u00a2\u0006\u0002\u0010)J,\u0010*\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001c0\u00190\u00182\u0006\u0010#\u001a\u00020$2\u0006\u0010+\u001a\u00020,2\u0006\u0010-\u001a\u00020,H\u0016J\u001c\u0010.\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001c0\u00190\u00182\u0006\u0010/\u001a\u00020$H\u0016J$\u00100\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001c0\u00190\u00182\u0006\u0010/\u001a\u00020$2\u0006\u00101\u001a\u000202H\u0016J\u001c\u00103\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002040\u00190\u00182\u0006\u00105\u001a\u00020$H\u0016J\u001c\u00106\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001e0\u00190\u00182\u0006\u00107\u001a\u00020$H\u0016J\u001c\u00108\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001e0\u00190\u00182\u0006\u0010/\u001a\u00020$H\u0016J\u0018\u00109\u001a\u0004\u0018\u00010:2\u0006\u0010(\u001a\u00020$H\u0096@\u00a2\u0006\u0002\u0010)J\u001c\u0010;\u001a\b\u0012\u0004\u0012\u00020:0\u00192\u0006\u0010#\u001a\u00020$H\u0096@\u00a2\u0006\u0002\u0010)J\u001c\u0010<\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020:0\u00190\u00182\u0006\u0010=\u001a\u00020$H\u0016J\u0016\u0010>\u001a\b\u0012\u0004\u0012\u00020,0\u00182\u0006\u00105\u001a\u00020$H\u0016J\u001c\u0010?\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002040\u00190\u00182\u0006\u00105\u001a\u00020$H\u0016J\u0018\u0010@\u001a\u0004\u0018\u00010\u001a2\u0006\u0010A\u001a\u00020$H\u0096@\u00a2\u0006\u0002\u0010)J\u0018\u0010B\u001a\u0004\u0018\u00010\u001a2\u0006\u0010(\u001a\u00020$H\u0096@\u00a2\u0006\u0002\u0010)J\u001c\u0010C\u001a\b\u0012\u0004\u0012\u00020$0\u00192\u0006\u0010/\u001a\u00020$H\u0096@\u00a2\u0006\u0002\u0010)J\u001c\u0010D\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001a0\u00190\u00182\u0006\u0010E\u001a\u00020FH\u0016J\u001c\u0010G\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001a0\u00190\u00182\u0006\u0010/\u001a\u00020$H\u0016J\u0018\u0010H\u001a\u0004\u0018\u00010I2\u0006\u0010(\u001a\u00020$H\u0096@\u00a2\u0006\u0002\u0010)J\u001c\u0010J\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020I0\u00190\u00182\u0006\u0010/\u001a\u00020$H\u0016J\u0018\u0010K\u001a\u0004\u0018\u00010 2\u0006\u0010/\u001a\u00020$H\u0096@\u00a2\u0006\u0002\u0010)J\u0016\u0010L\u001a\u00020M2\u0006\u0010N\u001a\u00020\"H\u0096@\u00a2\u0006\u0002\u0010OJ\u0016\u0010P\u001a\u00020M2\u0006\u0010Q\u001a\u00020RH\u0096@\u00a2\u0006\u0002\u0010SJ\u0016\u0010T\u001a\u00020M2\u0006\u0010U\u001a\u00020\u001cH\u0096@\u00a2\u0006\u0002\u0010VJ\u001c\u0010W\u001a\u00020M2\f\u0010X\u001a\b\u0012\u0004\u0012\u00020\u001c0\u0019H\u0096@\u00a2\u0006\u0002\u0010YJ\u0016\u0010Z\u001a\u00020M2\u0006\u0010[\u001a\u000204H\u0096@\u00a2\u0006\u0002\u0010\\J\u0016\u0010]\u001a\u00020M2\u0006\u0010^\u001a\u00020\u001eH\u0096@\u00a2\u0006\u0002\u0010_J\u001c\u0010`\u001a\u00020M2\f\u0010a\u001a\b\u0012\u0004\u0012\u00020\u001e0\u0019H\u0096@\u00a2\u0006\u0002\u0010YJ\u0016\u0010b\u001a\u00020M2\u0006\u0010c\u001a\u00020:H\u0096@\u00a2\u0006\u0002\u0010dJ\u0016\u0010e\u001a\u00020M2\u0006\u0010f\u001a\u00020\u001aH\u0096@\u00a2\u0006\u0002\u0010gJ\u001c\u0010h\u001a\u00020M2\f\u0010i\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0019H\u0096@\u00a2\u0006\u0002\u0010YJ\u0016\u0010j\u001a\u00020M2\u0006\u0010k\u001a\u00020IH\u0096@\u00a2\u0006\u0002\u0010lJ\u001c\u0010m\u001a\u00020M2\f\u0010n\u001a\b\u0012\u0004\u0012\u00020I0\u0019H\u0096@\u00a2\u0006\u0002\u0010YJ\u0016\u0010o\u001a\u00020M2\u0006\u0010p\u001a\u00020 H\u0096@\u00a2\u0006\u0002\u0010qJ\u001c\u0010r\u001a\u00020M2\f\u0010s\u001a\b\u0012\u0004\u0012\u00020 0\u0019H\u0096@\u00a2\u0006\u0002\u0010YJ\u0016\u0010t\u001a\u00020M2\u0006\u00105\u001a\u00020$H\u0096@\u00a2\u0006\u0002\u0010)J\u0016\u0010u\u001a\u00020M2\u0006\u0010v\u001a\u00020$H\u0096@\u00a2\u0006\u0002\u0010)J\u0016\u0010w\u001a\u00020M2\u0006\u0010U\u001a\u00020\u001cH\u0096@\u00a2\u0006\u0002\u0010VJ\u0016\u0010x\u001a\u00020M2\u0006\u0010f\u001a\u00020\u001aH\u0096@\u00a2\u0006\u0002\u0010gJ\u0016\u0010y\u001a\u00020M2\u0006\u0010k\u001a\u00020IH\u0096@\u00a2\u0006\u0002\u0010lJ\u0016\u0010z\u001a\u00020M2\u0006\u0010p\u001a\u00020 H\u0096@\u00a2\u0006\u0002\u0010qR\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006{"}, d2 = {"Lcom/balancetech/sitemanagement/data/datasource/LocalDataSourceImpl;", "Lcom/balancetech/sitemanagement/data/datasource/LocalDataSource;", "userDao", "Lcom/balancetech/sitemanagement/data/dao/UserDao;", "feeDao", "Lcom/balancetech/sitemanagement/data/dao/FeeDao;", "paymentDao", "Lcom/balancetech/sitemanagement/data/dao/PaymentDao;", "waterMeterDao", "Lcom/balancetech/sitemanagement/data/dao/WaterMeterDao;", "waterBillDao", "Lcom/balancetech/sitemanagement/data/dao/WaterBillDao;", "notificationDao", "Lcom/balancetech/sitemanagement/data/dao/NotificationDao;", "unitDao", "Lcom/balancetech/sitemanagement/data/dao/UnitDao;", "blockDao", "Lcom/balancetech/sitemanagement/data/dao/BlockDao;", "userUnitDao", "Lcom/balancetech/sitemanagement/data/dao/UserUnitDao;", "extraPaymentDao", "Lcom/balancetech/sitemanagement/data/dao/ExtraPaymentDao;", "(Lcom/balancetech/sitemanagement/data/dao/UserDao;Lcom/balancetech/sitemanagement/data/dao/FeeDao;Lcom/balancetech/sitemanagement/data/dao/PaymentDao;Lcom/balancetech/sitemanagement/data/dao/WaterMeterDao;Lcom/balancetech/sitemanagement/data/dao/WaterBillDao;Lcom/balancetech/sitemanagement/data/dao/NotificationDao;Lcom/balancetech/sitemanagement/data/dao/UnitDao;Lcom/balancetech/sitemanagement/data/dao/BlockDao;Lcom/balancetech/sitemanagement/data/dao/UserUnitDao;Lcom/balancetech/sitemanagement/data/dao/ExtraPaymentDao;)V", "getAllActiveUsers", "Lkotlinx/coroutines/flow/Flow;", "", "Lcom/balancetech/sitemanagement/data/entity/User;", "getAllFees", "Lcom/balancetech/sitemanagement/data/entity/Fee;", "getAllPayments", "Lcom/balancetech/sitemanagement/data/entity/Payment;", "getAllWaterMeters", "Lcom/balancetech/sitemanagement/data/entity/WaterMeter;", "getBlocksByApartment", "Lcom/balancetech/sitemanagement/data/entity/Block;", "apartmentId", "", "getCurrentUser", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getFeeById", "id", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getFeesByMonth", "month", "", "year", "getFeesByUnit", "unitId", "getFeesByUnitAndStatus", "status", "Lcom/balancetech/sitemanagement/data/model/PaymentStatus;", "getNotificationsByUser", "Lcom/balancetech/sitemanagement/data/entity/Notification;", "userId", "getPaymentsByFee", "feeId", "getPaymentsByUnit", "getUnitById", "Lcom/balancetech/sitemanagement/data/entity/Unit;", "getUnitsByApartment", "getUnitsByBlock", "blockId", "getUnreadNotificationCount", "getUnreadNotificationsByUser", "getUserByEmail", "email", "getUserById", "getUserIdsByUnitId", "getUsersByRole", "role", "Lcom/balancetech/sitemanagement/data/model/UserRole;", "getUsersByUnit", "getWaterBillById", "Lcom/balancetech/sitemanagement/data/entity/WaterBill;", "getWaterBillsByUnit", "getWaterMeterByUnit", "insertBlock", "", "block", "(Lcom/balancetech/sitemanagement/data/entity/Block;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "insertExtraPayment", "extraPayment", "Lcom/balancetech/sitemanagement/data/entity/ExtraPayment;", "(Lcom/balancetech/sitemanagement/data/entity/ExtraPayment;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "insertFee", "fee", "(Lcom/balancetech/sitemanagement/data/entity/Fee;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "insertFees", "fees", "(Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "insertNotification", "notification", "(Lcom/balancetech/sitemanagement/data/entity/Notification;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "insertPayment", "payment", "(Lcom/balancetech/sitemanagement/data/entity/Payment;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "insertPayments", "payments", "insertUnit", "unit", "(Lcom/balancetech/sitemanagement/data/entity/Unit;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "insertUser", "user", "(Lcom/balancetech/sitemanagement/data/entity/User;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "insertUsers", "users", "insertWaterBill", "waterBill", "(Lcom/balancetech/sitemanagement/data/entity/WaterBill;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "insertWaterBills", "waterBills", "insertWaterMeter", "waterMeter", "(Lcom/balancetech/sitemanagement/data/entity/WaterMeter;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "insertWaterMeters", "waterMeters", "markAllAsRead", "markAsRead", "notificationId", "updateFee", "updateUser", "updateWaterBill", "updateWaterMeter", "app_debug"})
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
    @org.jetbrains.annotations.NotNull
    private final com.balancetech.sitemanagement.data.dao.ExtraPaymentDao extraPaymentDao = null;
    
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
    com.balancetech.sitemanagement.data.dao.UserUnitDao userUnitDao, @org.jetbrains.annotations.NotNull
    com.balancetech.sitemanagement.data.dao.ExtraPaymentDao extraPaymentDao) {
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
    public java.lang.Object insertUsers(@org.jetbrains.annotations.NotNull
    java.util.List<com.balancetech.sitemanagement.data.entity.User> users, @org.jetbrains.annotations.NotNull
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
    @org.jetbrains.annotations.Nullable
    public java.lang.Object insertPayments(@org.jetbrains.annotations.NotNull
    java.util.List<com.balancetech.sitemanagement.data.entity.Payment> payments, @org.jetbrains.annotations.NotNull
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
    public java.lang.Object insertWaterMeters(@org.jetbrains.annotations.NotNull
    java.util.List<com.balancetech.sitemanagement.data.entity.WaterMeter> waterMeters, @org.jetbrains.annotations.NotNull
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
    public java.lang.Object insertWaterBills(@org.jetbrains.annotations.NotNull
    java.util.List<com.balancetech.sitemanagement.data.entity.WaterBill> waterBills, @org.jetbrains.annotations.NotNull
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
    
    @java.lang.Override
    @org.jetbrains.annotations.Nullable
    public java.lang.Object insertExtraPayment(@org.jetbrains.annotations.NotNull
    com.balancetech.sitemanagement.data.entity.ExtraPayment extraPayment, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
}