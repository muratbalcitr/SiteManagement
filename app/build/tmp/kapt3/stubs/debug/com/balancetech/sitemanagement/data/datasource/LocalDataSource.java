package com.balancetech.sitemanagement.data.datasource;

/**
 * Local data source interface for Room Database operations
 */
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\'\bf\u0018\u00002\u00020\u0001J\u0016\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u00a6@\u00a2\u0006\u0002\u0010\u0006J\u0014\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\bH&J\u0014\u0010\u000b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\t0\bH&J\u0014\u0010\r\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\t0\bH&J\u0014\u0010\u000f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00100\t0\bH&J\u0018\u0010\u0011\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u00a6@\u00a2\u0006\u0002\u0010\u0015J\u001c\u0010\u0016\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00120\t0\b2\u0006\u0010\u0017\u001a\u00020\u0014H&J\u0010\u0010\u0018\u001a\u0004\u0018\u00010\nH\u00a6@\u00a2\u0006\u0002\u0010\u0019J\u0018\u0010\u001a\u001a\u0004\u0018\u00010\f2\u0006\u0010\u0013\u001a\u00020\u0014H\u00a6@\u00a2\u0006\u0002\u0010\u0015J,\u0010\u001b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\t0\b2\u0006\u0010\u0017\u001a\u00020\u00142\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001dH&J\u001c\u0010\u001f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\t0\b2\u0006\u0010 \u001a\u00020\u0014H&J$\u0010!\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\t0\b2\u0006\u0010 \u001a\u00020\u00142\u0006\u0010\"\u001a\u00020#H&J\u001c\u0010$\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020%0\t0\b2\u0006\u0010&\u001a\u00020\u0014H&J\u001c\u0010\'\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\t0\b2\u0006\u0010(\u001a\u00020\u0014H&J\u001c\u0010)\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\t0\b2\u0006\u0010 \u001a\u00020\u0014H&J\u0018\u0010*\u001a\u0004\u0018\u00010+2\u0006\u0010\u0013\u001a\u00020\u0014H\u00a6@\u00a2\u0006\u0002\u0010\u0015J\u001c\u0010,\u001a\b\u0012\u0004\u0012\u00020+0\t2\u0006\u0010\u0017\u001a\u00020\u0014H\u00a6@\u00a2\u0006\u0002\u0010\u0015J\u001c\u0010-\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020+0\t0\b2\u0006\u0010.\u001a\u00020\u0014H&J\u0016\u0010/\u001a\b\u0012\u0004\u0012\u00020\u001d0\b2\u0006\u0010&\u001a\u00020\u0014H&J\u001c\u00100\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020%0\t0\b2\u0006\u0010&\u001a\u00020\u0014H&J\u0018\u00101\u001a\u0004\u0018\u00010\n2\u0006\u00102\u001a\u00020\u0014H\u00a6@\u00a2\u0006\u0002\u0010\u0015J\u0018\u00103\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0013\u001a\u00020\u0014H\u00a6@\u00a2\u0006\u0002\u0010\u0015J\u001c\u00104\u001a\b\u0012\u0004\u0012\u00020\u00140\t2\u0006\u0010 \u001a\u00020\u0014H\u00a6@\u00a2\u0006\u0002\u0010\u0015J\u001c\u00105\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\b2\u0006\u00106\u001a\u000207H&J\u001c\u00108\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\b2\u0006\u0010 \u001a\u00020\u0014H&J\u0018\u00109\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0013\u001a\u00020\u0014H\u00a6@\u00a2\u0006\u0002\u0010\u0015J\u001c\u0010:\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\t0\b2\u0006\u0010 \u001a\u00020\u0014H&J\u0018\u0010;\u001a\u0004\u0018\u00010\u00102\u0006\u0010 \u001a\u00020\u0014H\u00a6@\u00a2\u0006\u0002\u0010\u0015J\u0016\u0010<\u001a\u00020\u00032\u0006\u0010=\u001a\u00020\u0012H\u00a6@\u00a2\u0006\u0002\u0010>J\u0016\u0010?\u001a\u00020\u00032\u0006\u0010@\u001a\u00020AH\u00a6@\u00a2\u0006\u0002\u0010BJ\u0016\u0010C\u001a\u00020\u00032\u0006\u0010D\u001a\u00020\fH\u00a6@\u00a2\u0006\u0002\u0010EJ\u001c\u0010F\u001a\u00020\u00032\f\u0010G\u001a\b\u0012\u0004\u0012\u00020\f0\tH\u00a6@\u00a2\u0006\u0002\u0010HJ\u0016\u0010I\u001a\u00020\u00032\u0006\u0010J\u001a\u00020%H\u00a6@\u00a2\u0006\u0002\u0010KJ\u0016\u0010L\u001a\u00020\u00032\u0006\u0010M\u001a\u00020\u000eH\u00a6@\u00a2\u0006\u0002\u0010NJ\u001c\u0010O\u001a\u00020\u00032\f\u0010P\u001a\b\u0012\u0004\u0012\u00020\u000e0\tH\u00a6@\u00a2\u0006\u0002\u0010HJ\u0016\u0010Q\u001a\u00020\u00032\u0006\u0010R\u001a\u00020+H\u00a6@\u00a2\u0006\u0002\u0010SJ\u0016\u0010T\u001a\u00020\u00032\u0006\u0010U\u001a\u00020\nH\u00a6@\u00a2\u0006\u0002\u0010VJ\u001c\u0010W\u001a\u00020\u00032\f\u0010X\u001a\b\u0012\u0004\u0012\u00020\n0\tH\u00a6@\u00a2\u0006\u0002\u0010HJ\u0016\u0010Y\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u00a6@\u00a2\u0006\u0002\u0010\u0006J\u001c\u0010Z\u001a\u00020\u00032\f\u0010[\u001a\b\u0012\u0004\u0012\u00020\u00050\tH\u00a6@\u00a2\u0006\u0002\u0010HJ\u0016\u0010\\\u001a\u00020\u00032\u0006\u0010]\u001a\u00020\u0010H\u00a6@\u00a2\u0006\u0002\u0010^J\u001c\u0010_\u001a\u00020\u00032\f\u0010`\u001a\b\u0012\u0004\u0012\u00020\u00100\tH\u00a6@\u00a2\u0006\u0002\u0010HJ\u0016\u0010a\u001a\u00020\u00032\u0006\u0010&\u001a\u00020\u0014H\u00a6@\u00a2\u0006\u0002\u0010\u0015J\u0016\u0010b\u001a\u00020\u00032\u0006\u0010c\u001a\u00020\u0014H\u00a6@\u00a2\u0006\u0002\u0010\u0015J\u0016\u0010d\u001a\u00020\u00032\u0006\u0010D\u001a\u00020\fH\u00a6@\u00a2\u0006\u0002\u0010EJ\u0016\u0010e\u001a\u00020\u00032\u0006\u0010U\u001a\u00020\nH\u00a6@\u00a2\u0006\u0002\u0010VJ\u0016\u0010f\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u00a6@\u00a2\u0006\u0002\u0010\u0006J\u0016\u0010g\u001a\u00020\u00032\u0006\u0010]\u001a\u00020\u0010H\u00a6@\u00a2\u0006\u0002\u0010^\u00a8\u0006h"}, d2 = {"Lcom/balancetech/sitemanagement/data/datasource/LocalDataSource;", "", "deleteWaterBill", "", "waterBill", "Lcom/balancetech/sitemanagement/data/entity/WaterBill;", "(Lcom/balancetech/sitemanagement/data/entity/WaterBill;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getAllActiveUsers", "Lkotlinx/coroutines/flow/Flow;", "", "Lcom/balancetech/sitemanagement/data/entity/User;", "getAllFees", "Lcom/balancetech/sitemanagement/data/entity/Fee;", "getAllPayments", "Lcom/balancetech/sitemanagement/data/entity/Payment;", "getAllWaterMeters", "Lcom/balancetech/sitemanagement/data/entity/WaterMeter;", "getBlockById", "Lcom/balancetech/sitemanagement/data/entity/Block;", "id", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getBlocksByApartment", "apartmentId", "getCurrentUser", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getFeeById", "getFeesByMonth", "month", "", "year", "getFeesByUnit", "unitId", "getFeesByUnitAndStatus", "status", "Lcom/balancetech/sitemanagement/data/model/PaymentStatus;", "getNotificationsByUser", "Lcom/balancetech/sitemanagement/data/entity/Notification;", "userId", "getPaymentsByFee", "feeId", "getPaymentsByUnit", "getUnitById", "Lcom/balancetech/sitemanagement/data/entity/Unit;", "getUnitsByApartment", "getUnitsByBlock", "blockId", "getUnreadNotificationCount", "getUnreadNotificationsByUser", "getUserByEmail", "email", "getUserById", "getUserIdsByUnitId", "getUsersByRole", "role", "Lcom/balancetech/sitemanagement/data/model/UserRole;", "getUsersByUnit", "getWaterBillById", "getWaterBillsByUnit", "getWaterMeterByUnit", "insertBlock", "block", "(Lcom/balancetech/sitemanagement/data/entity/Block;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "insertExtraPayment", "extraPayment", "Lcom/balancetech/sitemanagement/data/entity/ExtraPayment;", "(Lcom/balancetech/sitemanagement/data/entity/ExtraPayment;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "insertFee", "fee", "(Lcom/balancetech/sitemanagement/data/entity/Fee;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "insertFees", "fees", "(Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "insertNotification", "notification", "(Lcom/balancetech/sitemanagement/data/entity/Notification;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "insertPayment", "payment", "(Lcom/balancetech/sitemanagement/data/entity/Payment;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "insertPayments", "payments", "insertUnit", "unit", "(Lcom/balancetech/sitemanagement/data/entity/Unit;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "insertUser", "user", "(Lcom/balancetech/sitemanagement/data/entity/User;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "insertUsers", "users", "insertWaterBill", "insertWaterBills", "waterBills", "insertWaterMeter", "waterMeter", "(Lcom/balancetech/sitemanagement/data/entity/WaterMeter;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "insertWaterMeters", "waterMeters", "markAllAsRead", "markAsRead", "notificationId", "updateFee", "updateUser", "updateWaterBill", "updateWaterMeter", "app_debug"})
public abstract interface LocalDataSource {
    
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object getUserByEmail(@org.jetbrains.annotations.NotNull
    java.lang.String email, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super com.balancetech.sitemanagement.data.entity.User> $completion);
    
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object getUserById(@org.jetbrains.annotations.NotNull
    java.lang.String id, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super com.balancetech.sitemanagement.data.entity.User> $completion);
    
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object insertUser(@org.jetbrains.annotations.NotNull
    com.balancetech.sitemanagement.data.entity.User user, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object insertUsers(@org.jetbrains.annotations.NotNull
    java.util.List<com.balancetech.sitemanagement.data.entity.User> users, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object getCurrentUser(@org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super com.balancetech.sitemanagement.data.entity.User> $completion);
    
    @org.jetbrains.annotations.NotNull
    public abstract kotlinx.coroutines.flow.Flow<java.util.List<com.balancetech.sitemanagement.data.entity.User>> getAllActiveUsers();
    
    @org.jetbrains.annotations.NotNull
    public abstract kotlinx.coroutines.flow.Flow<java.util.List<com.balancetech.sitemanagement.data.entity.User>> getUsersByRole(@org.jetbrains.annotations.NotNull
    com.balancetech.sitemanagement.data.model.UserRole role);
    
    @org.jetbrains.annotations.NotNull
    public abstract kotlinx.coroutines.flow.Flow<java.util.List<com.balancetech.sitemanagement.data.entity.User>> getUsersByUnit(@org.jetbrains.annotations.NotNull
    java.lang.String unitId);
    
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object getUserIdsByUnitId(@org.jetbrains.annotations.NotNull
    java.lang.String unitId, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super java.util.List<java.lang.String>> $completion);
    
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object updateUser(@org.jetbrains.annotations.NotNull
    com.balancetech.sitemanagement.data.entity.User user, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @org.jetbrains.annotations.NotNull
    public abstract kotlinx.coroutines.flow.Flow<java.util.List<com.balancetech.sitemanagement.data.entity.Fee>> getFeesByUnit(@org.jetbrains.annotations.NotNull
    java.lang.String unitId);
    
    @org.jetbrains.annotations.NotNull
    public abstract kotlinx.coroutines.flow.Flow<java.util.List<com.balancetech.sitemanagement.data.entity.Fee>> getFeesByMonth(@org.jetbrains.annotations.NotNull
    java.lang.String apartmentId, int month, int year);
    
    @org.jetbrains.annotations.NotNull
    public abstract kotlinx.coroutines.flow.Flow<java.util.List<com.balancetech.sitemanagement.data.entity.Fee>> getFeesByUnitAndStatus(@org.jetbrains.annotations.NotNull
    java.lang.String unitId, @org.jetbrains.annotations.NotNull
    com.balancetech.sitemanagement.data.model.PaymentStatus status);
    
    @org.jetbrains.annotations.NotNull
    public abstract kotlinx.coroutines.flow.Flow<java.util.List<com.balancetech.sitemanagement.data.entity.Fee>> getAllFees();
    
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object getFeeById(@org.jetbrains.annotations.NotNull
    java.lang.String id, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super com.balancetech.sitemanagement.data.entity.Fee> $completion);
    
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object insertFee(@org.jetbrains.annotations.NotNull
    com.balancetech.sitemanagement.data.entity.Fee fee, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object insertFees(@org.jetbrains.annotations.NotNull
    java.util.List<com.balancetech.sitemanagement.data.entity.Fee> fees, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object updateFee(@org.jetbrains.annotations.NotNull
    com.balancetech.sitemanagement.data.entity.Fee fee, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @org.jetbrains.annotations.NotNull
    public abstract kotlinx.coroutines.flow.Flow<java.util.List<com.balancetech.sitemanagement.data.entity.Payment>> getPaymentsByUnit(@org.jetbrains.annotations.NotNull
    java.lang.String unitId);
    
    @org.jetbrains.annotations.NotNull
    public abstract kotlinx.coroutines.flow.Flow<java.util.List<com.balancetech.sitemanagement.data.entity.Payment>> getPaymentsByFee(@org.jetbrains.annotations.NotNull
    java.lang.String feeId);
    
    @org.jetbrains.annotations.NotNull
    public abstract kotlinx.coroutines.flow.Flow<java.util.List<com.balancetech.sitemanagement.data.entity.Payment>> getAllPayments();
    
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object insertPayment(@org.jetbrains.annotations.NotNull
    com.balancetech.sitemanagement.data.entity.Payment payment, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object insertPayments(@org.jetbrains.annotations.NotNull
    java.util.List<com.balancetech.sitemanagement.data.entity.Payment> payments, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @org.jetbrains.annotations.NotNull
    public abstract kotlinx.coroutines.flow.Flow<java.util.List<com.balancetech.sitemanagement.data.entity.WaterMeter>> getAllWaterMeters();
    
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object getWaterMeterByUnit(@org.jetbrains.annotations.NotNull
    java.lang.String unitId, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super com.balancetech.sitemanagement.data.entity.WaterMeter> $completion);
    
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object insertWaterMeter(@org.jetbrains.annotations.NotNull
    com.balancetech.sitemanagement.data.entity.WaterMeter waterMeter, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object insertWaterMeters(@org.jetbrains.annotations.NotNull
    java.util.List<com.balancetech.sitemanagement.data.entity.WaterMeter> waterMeters, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object updateWaterMeter(@org.jetbrains.annotations.NotNull
    com.balancetech.sitemanagement.data.entity.WaterMeter waterMeter, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @org.jetbrains.annotations.NotNull
    public abstract kotlinx.coroutines.flow.Flow<java.util.List<com.balancetech.sitemanagement.data.entity.WaterBill>> getWaterBillsByUnit(@org.jetbrains.annotations.NotNull
    java.lang.String unitId);
    
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object getWaterBillById(@org.jetbrains.annotations.NotNull
    java.lang.String id, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super com.balancetech.sitemanagement.data.entity.WaterBill> $completion);
    
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object insertWaterBill(@org.jetbrains.annotations.NotNull
    com.balancetech.sitemanagement.data.entity.WaterBill waterBill, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object insertWaterBills(@org.jetbrains.annotations.NotNull
    java.util.List<com.balancetech.sitemanagement.data.entity.WaterBill> waterBills, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object updateWaterBill(@org.jetbrains.annotations.NotNull
    com.balancetech.sitemanagement.data.entity.WaterBill waterBill, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object deleteWaterBill(@org.jetbrains.annotations.NotNull
    com.balancetech.sitemanagement.data.entity.WaterBill waterBill, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @org.jetbrains.annotations.NotNull
    public abstract kotlinx.coroutines.flow.Flow<java.util.List<com.balancetech.sitemanagement.data.entity.Notification>> getNotificationsByUser(@org.jetbrains.annotations.NotNull
    java.lang.String userId);
    
    @org.jetbrains.annotations.NotNull
    public abstract kotlinx.coroutines.flow.Flow<java.util.List<com.balancetech.sitemanagement.data.entity.Notification>> getUnreadNotificationsByUser(@org.jetbrains.annotations.NotNull
    java.lang.String userId);
    
    @org.jetbrains.annotations.NotNull
    public abstract kotlinx.coroutines.flow.Flow<java.lang.Integer> getUnreadNotificationCount(@org.jetbrains.annotations.NotNull
    java.lang.String userId);
    
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object insertNotification(@org.jetbrains.annotations.NotNull
    com.balancetech.sitemanagement.data.entity.Notification notification, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object markAsRead(@org.jetbrains.annotations.NotNull
    java.lang.String notificationId, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object markAllAsRead(@org.jetbrains.annotations.NotNull
    java.lang.String userId, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object getUnitsByApartment(@org.jetbrains.annotations.NotNull
    java.lang.String apartmentId, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super java.util.List<com.balancetech.sitemanagement.data.entity.Unit>> $completion);
    
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object getUnitById(@org.jetbrains.annotations.NotNull
    java.lang.String id, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super com.balancetech.sitemanagement.data.entity.Unit> $completion);
    
    @org.jetbrains.annotations.NotNull
    public abstract kotlinx.coroutines.flow.Flow<java.util.List<com.balancetech.sitemanagement.data.entity.Unit>> getUnitsByBlock(@org.jetbrains.annotations.NotNull
    java.lang.String blockId);
    
    @org.jetbrains.annotations.NotNull
    public abstract kotlinx.coroutines.flow.Flow<java.util.List<com.balancetech.sitemanagement.data.entity.Block>> getBlocksByApartment(@org.jetbrains.annotations.NotNull
    java.lang.String apartmentId);
    
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object getBlockById(@org.jetbrains.annotations.NotNull
    java.lang.String id, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super com.balancetech.sitemanagement.data.entity.Block> $completion);
    
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object insertBlock(@org.jetbrains.annotations.NotNull
    com.balancetech.sitemanagement.data.entity.Block block, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object insertUnit(@org.jetbrains.annotations.NotNull
    com.balancetech.sitemanagement.data.entity.Unit unit, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object insertExtraPayment(@org.jetbrains.annotations.NotNull
    com.balancetech.sitemanagement.data.entity.ExtraPayment extraPayment, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
}