package com.balancetech.sitemanagement.data.datasource;

/**
 * Local data source interface for Room Database operations
 */
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b)\bf\u0018\u00002\u00020\u0001J\u0014\u0010\u0002\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u0003H&J\u0014\u0010\u0006\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00040\u0003H&J\u0014\u0010\b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\u00040\u0003H&J\u0014\u0010\n\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\u00040\u0003H&J\u001c\u0010\f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\u00040\u00032\u0006\u0010\u000e\u001a\u00020\u000fH&J\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0005H\u00a6@\u00a2\u0006\u0002\u0010\u0011J\u0018\u0010\u0012\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0013\u001a\u00020\u000fH\u00a6@\u00a2\u0006\u0002\u0010\u0014J,\u0010\u0015\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00040\u00032\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0017H&J\u001c\u0010\u0019\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00040\u00032\u0006\u0010\u001a\u001a\u00020\u000fH&J$\u0010\u001b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00040\u00032\u0006\u0010\u001a\u001a\u00020\u000f2\u0006\u0010\u001c\u001a\u00020\u001dH&J\u001c\u0010\u001e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001f0\u00040\u00032\u0006\u0010 \u001a\u00020\u000fH&J\u001c\u0010!\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\u00040\u00032\u0006\u0010\"\u001a\u00020\u000fH&J\u001c\u0010#\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\u00040\u00032\u0006\u0010\u001a\u001a\u00020\u000fH&J\u0018\u0010$\u001a\u0004\u0018\u00010%2\u0006\u0010\u0013\u001a\u00020\u000fH\u00a6@\u00a2\u0006\u0002\u0010\u0014J\u001c\u0010&\u001a\b\u0012\u0004\u0012\u00020%0\u00042\u0006\u0010\u000e\u001a\u00020\u000fH\u00a6@\u00a2\u0006\u0002\u0010\u0014J\u001c\u0010\'\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020%0\u00040\u00032\u0006\u0010(\u001a\u00020\u000fH&J\u0016\u0010)\u001a\b\u0012\u0004\u0012\u00020\u00170\u00032\u0006\u0010 \u001a\u00020\u000fH&J\u001c\u0010*\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001f0\u00040\u00032\u0006\u0010 \u001a\u00020\u000fH&J\u0018\u0010+\u001a\u0004\u0018\u00010\u00052\u0006\u0010,\u001a\u00020\u000fH\u00a6@\u00a2\u0006\u0002\u0010\u0014J\u0018\u0010-\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0013\u001a\u00020\u000fH\u00a6@\u00a2\u0006\u0002\u0010\u0014J\u001c\u0010.\u001a\b\u0012\u0004\u0012\u00020\u000f0\u00042\u0006\u0010\u001a\u001a\u00020\u000fH\u00a6@\u00a2\u0006\u0002\u0010\u0014J\u001c\u0010/\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u00032\u0006\u00100\u001a\u000201H&J\u001c\u00102\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u00032\u0006\u0010\u001a\u001a\u00020\u000fH&J\u0018\u00103\u001a\u0004\u0018\u0001042\u0006\u0010\u0013\u001a\u00020\u000fH\u00a6@\u00a2\u0006\u0002\u0010\u0014J\u001c\u00105\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002040\u00040\u00032\u0006\u0010\u001a\u001a\u00020\u000fH&J\u0018\u00106\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u001a\u001a\u00020\u000fH\u00a6@\u00a2\u0006\u0002\u0010\u0014J\u0016\u00107\u001a\u0002082\u0006\u00109\u001a\u00020\rH\u00a6@\u00a2\u0006\u0002\u0010:J\u0016\u0010;\u001a\u0002082\u0006\u0010<\u001a\u00020=H\u00a6@\u00a2\u0006\u0002\u0010>J\u0016\u0010?\u001a\u0002082\u0006\u0010@\u001a\u00020\u0007H\u00a6@\u00a2\u0006\u0002\u0010AJ\u001c\u0010B\u001a\u0002082\f\u0010C\u001a\b\u0012\u0004\u0012\u00020\u00070\u0004H\u00a6@\u00a2\u0006\u0002\u0010DJ\u0016\u0010E\u001a\u0002082\u0006\u0010F\u001a\u00020\u001fH\u00a6@\u00a2\u0006\u0002\u0010GJ\u0016\u0010H\u001a\u0002082\u0006\u0010I\u001a\u00020\tH\u00a6@\u00a2\u0006\u0002\u0010JJ\u001c\u0010K\u001a\u0002082\f\u0010L\u001a\b\u0012\u0004\u0012\u00020\t0\u0004H\u00a6@\u00a2\u0006\u0002\u0010DJ\u0016\u0010M\u001a\u0002082\u0006\u0010N\u001a\u00020%H\u00a6@\u00a2\u0006\u0002\u0010OJ\u0016\u0010P\u001a\u0002082\u0006\u0010Q\u001a\u00020\u0005H\u00a6@\u00a2\u0006\u0002\u0010RJ\u001c\u0010S\u001a\u0002082\f\u0010T\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u00a6@\u00a2\u0006\u0002\u0010DJ\u0016\u0010U\u001a\u0002082\u0006\u0010V\u001a\u000204H\u00a6@\u00a2\u0006\u0002\u0010WJ\u001c\u0010X\u001a\u0002082\f\u0010Y\u001a\b\u0012\u0004\u0012\u0002040\u0004H\u00a6@\u00a2\u0006\u0002\u0010DJ\u0016\u0010Z\u001a\u0002082\u0006\u0010[\u001a\u00020\u000bH\u00a6@\u00a2\u0006\u0002\u0010\\J\u001c\u0010]\u001a\u0002082\f\u0010^\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0004H\u00a6@\u00a2\u0006\u0002\u0010DJ\u0016\u0010_\u001a\u0002082\u0006\u0010 \u001a\u00020\u000fH\u00a6@\u00a2\u0006\u0002\u0010\u0014J\u0016\u0010`\u001a\u0002082\u0006\u0010a\u001a\u00020\u000fH\u00a6@\u00a2\u0006\u0002\u0010\u0014J\u0016\u0010b\u001a\u0002082\u0006\u0010@\u001a\u00020\u0007H\u00a6@\u00a2\u0006\u0002\u0010AJ\u0016\u0010c\u001a\u0002082\u0006\u0010Q\u001a\u00020\u0005H\u00a6@\u00a2\u0006\u0002\u0010RJ\u0016\u0010d\u001a\u0002082\u0006\u0010V\u001a\u000204H\u00a6@\u00a2\u0006\u0002\u0010WJ\u0016\u0010e\u001a\u0002082\u0006\u0010[\u001a\u00020\u000bH\u00a6@\u00a2\u0006\u0002\u0010\\\u00a8\u0006f"}, d2 = {"Lcom/balancetech/sitemanagement/data/datasource/LocalDataSource;", "", "getAllActiveUsers", "Lkotlinx/coroutines/flow/Flow;", "", "Lcom/balancetech/sitemanagement/data/entity/User;", "getAllFees", "Lcom/balancetech/sitemanagement/data/entity/Fee;", "getAllPayments", "Lcom/balancetech/sitemanagement/data/entity/Payment;", "getAllWaterMeters", "Lcom/balancetech/sitemanagement/data/entity/WaterMeter;", "getBlocksByApartment", "Lcom/balancetech/sitemanagement/data/entity/Block;", "apartmentId", "", "getCurrentUser", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getFeeById", "id", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getFeesByMonth", "month", "", "year", "getFeesByUnit", "unitId", "getFeesByUnitAndStatus", "status", "Lcom/balancetech/sitemanagement/data/model/PaymentStatus;", "getNotificationsByUser", "Lcom/balancetech/sitemanagement/data/entity/Notification;", "userId", "getPaymentsByFee", "feeId", "getPaymentsByUnit", "getUnitById", "Lcom/balancetech/sitemanagement/data/entity/Unit;", "getUnitsByApartment", "getUnitsByBlock", "blockId", "getUnreadNotificationCount", "getUnreadNotificationsByUser", "getUserByEmail", "email", "getUserById", "getUserIdsByUnitId", "getUsersByRole", "role", "Lcom/balancetech/sitemanagement/data/model/UserRole;", "getUsersByUnit", "getWaterBillById", "Lcom/balancetech/sitemanagement/data/entity/WaterBill;", "getWaterBillsByUnit", "getWaterMeterByUnit", "insertBlock", "", "block", "(Lcom/balancetech/sitemanagement/data/entity/Block;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "insertExtraPayment", "extraPayment", "Lcom/balancetech/sitemanagement/data/entity/ExtraPayment;", "(Lcom/balancetech/sitemanagement/data/entity/ExtraPayment;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "insertFee", "fee", "(Lcom/balancetech/sitemanagement/data/entity/Fee;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "insertFees", "fees", "(Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "insertNotification", "notification", "(Lcom/balancetech/sitemanagement/data/entity/Notification;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "insertPayment", "payment", "(Lcom/balancetech/sitemanagement/data/entity/Payment;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "insertPayments", "payments", "insertUnit", "unit", "(Lcom/balancetech/sitemanagement/data/entity/Unit;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "insertUser", "user", "(Lcom/balancetech/sitemanagement/data/entity/User;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "insertUsers", "users", "insertWaterBill", "waterBill", "(Lcom/balancetech/sitemanagement/data/entity/WaterBill;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "insertWaterBills", "waterBills", "insertWaterMeter", "waterMeter", "(Lcom/balancetech/sitemanagement/data/entity/WaterMeter;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "insertWaterMeters", "waterMeters", "markAllAsRead", "markAsRead", "notificationId", "updateFee", "updateUser", "updateWaterBill", "updateWaterMeter", "app_debug"})
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