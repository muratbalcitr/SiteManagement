package com.balancetech.sitemanagement.data.datasource;

/**
 * Remote data source interface for Firebase Firestore operations
 */
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000e\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\"\bf\u0018\u00002\u00020\u0001J$\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0005\u001a\u00020\u0004H\u00a6@\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\u0004\b\u0006\u0010\u0007J$\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u00032\u0006\u0010\n\u001a\u00020\tH\u00a6@\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\u0004\b\u000b\u0010\fJ0\u0010\r\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\u000e0\u00032\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\t0\u000eH\u00a6@\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\u0004\b\u0010\u0010\u0011J$\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00130\u00032\u0006\u0010\u0014\u001a\u00020\u0013H\u00a6@\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\u0004\b\u0015\u0010\u0016J$\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00180\u00032\u0006\u0010\u0019\u001a\u00020\u0018H\u00a6@\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\u0004\b\u001a\u0010\u001bJ$\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001d0\u00032\u0006\u0010\u001e\u001a\u00020\u001dH\u00a6@\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\u0004\b\u001f\u0010 J$\u0010!\u001a\b\u0012\u0004\u0012\u00020\"0\u00032\u0006\u0010#\u001a\u00020\"H\u00a6@\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\u0004\b$\u0010%J$\u0010&\u001a\b\u0012\u0004\u0012\u00020\'0\u00032\u0006\u0010(\u001a\u00020\'H\u00a6@\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\u0004\b)\u0010*J$\u0010+\u001a\b\u0012\u0004\u0012\u00020,0\u00032\u0006\u0010-\u001a\u00020,H\u00a6@\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\u0004\b.\u0010/J$\u00100\u001a\b\u0012\u0004\u0012\u0002010\u00032\u0006\u00102\u001a\u000203H\u00a6@\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\u0004\b4\u00105J\u001c\u00106\u001a\b\u0012\u0004\u0012\u00020\u00040\u000e2\u0006\u00107\u001a\u000203H\u00a6@\u00a2\u0006\u0002\u00105J\u0014\u00108\u001a\b\u0012\u0004\u0012\u00020\t0\u000eH\u00a6@\u00a2\u0006\u0002\u00109J\u0014\u0010:\u001a\b\u0012\u0004\u0012\u00020\u001d0\u000eH\u00a6@\u00a2\u0006\u0002\u00109J\u0014\u0010;\u001a\b\u0012\u0004\u0012\u00020\'0\u000eH\u00a6@\u00a2\u0006\u0002\u00109J\u0014\u0010<\u001a\b\u0012\u0004\u0012\u00020,0\u000eH\u00a6@\u00a2\u0006\u0002\u00109J\u0014\u0010=\u001a\b\u0012\u0004\u0012\u00020\u00180\u000eH\u00a6@\u00a2\u0006\u0002\u00109J\u0018\u0010>\u001a\u0004\u0018\u00010\t2\u0006\u0010?\u001a\u000203H\u00a6@\u00a2\u0006\u0002\u00105J,\u0010@\u001a\b\u0012\u0004\u0012\u00020\t0\u000e2\u0006\u00107\u001a\u0002032\u0006\u0010A\u001a\u00020B2\u0006\u0010C\u001a\u00020BH\u00a6@\u00a2\u0006\u0002\u0010DJ\u001c\u0010E\u001a\b\u0012\u0004\u0012\u00020\t0\u000e2\u0006\u0010F\u001a\u000203H\u00a6@\u00a2\u0006\u0002\u00105J$\u0010G\u001a\b\u0012\u0004\u0012\u00020\t0\u000e2\u0006\u0010F\u001a\u0002032\u0006\u0010H\u001a\u00020IH\u00a6@\u00a2\u0006\u0002\u0010JJ\u001c\u0010K\u001a\b\u0012\u0004\u0012\u00020\u00130\u000e2\u0006\u0010L\u001a\u000203H\u00a6@\u00a2\u0006\u0002\u00105J\u001c\u0010M\u001a\b\u0012\u0004\u0012\u00020\u001d0\u000e2\u0006\u0010N\u001a\u000203H\u00a6@\u00a2\u0006\u0002\u00105J\u001c\u0010O\u001a\b\u0012\u0004\u0012\u00020\u001d0\u000e2\u0006\u0010F\u001a\u000203H\u00a6@\u00a2\u0006\u0002\u00105J\u0018\u0010P\u001a\u0004\u0018\u00010\"2\u0006\u0010?\u001a\u000203H\u00a6@\u00a2\u0006\u0002\u00105J\u001c\u0010Q\u001a\b\u0012\u0004\u0012\u00020\"0\u000e2\u0006\u00107\u001a\u000203H\u00a6@\u00a2\u0006\u0002\u00105J\u0016\u0010R\u001a\u00020B2\u0006\u0010L\u001a\u000203H\u00a6@\u00a2\u0006\u0002\u00105J\u001c\u0010S\u001a\b\u0012\u0004\u0012\u00020\u00130\u000e2\u0006\u0010L\u001a\u000203H\u00a6@\u00a2\u0006\u0002\u00105J\u0018\u0010T\u001a\u0004\u0018\u00010\'2\u0006\u0010U\u001a\u000203H\u00a6@\u00a2\u0006\u0002\u00105J\u0018\u0010V\u001a\u0004\u0018\u00010,2\u0006\u0010?\u001a\u000203H\u00a6@\u00a2\u0006\u0002\u00105J\u001c\u0010W\u001a\b\u0012\u0004\u0012\u00020,0\u000e2\u0006\u0010F\u001a\u000203H\u00a6@\u00a2\u0006\u0002\u00105J\u0018\u0010X\u001a\u0004\u0018\u00010\u00182\u0006\u0010F\u001a\u000203H\u00a6@\u00a2\u0006\u0002\u00105J$\u0010Y\u001a\b\u0012\u0004\u0012\u0002010\u00032\u0006\u0010L\u001a\u000203H\u00a6@\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\u0004\bZ\u00105J,\u0010[\u001a\b\u0012\u0004\u0012\u0002010\u00032\u0006\u0010\\\u001a\u0002032\u0006\u0010L\u001a\u000203H\u00a6@\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\u0004\b]\u0010^J\u001c\u0010_\u001a\b\u0012\u0004\u0012\u0002010\u0003H\u00a6@\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\u0004\b`\u00109J$\u0010a\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0005\u001a\u00020\u0004H\u00a6@\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\u0004\bb\u0010\u0007J$\u0010c\u001a\b\u0012\u0004\u0012\u00020\t0\u00032\u0006\u0010\n\u001a\u00020\tH\u00a6@\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\u0004\bd\u0010\fJ$\u0010e\u001a\b\u0012\u0004\u0012\u00020\"0\u00032\u0006\u0010#\u001a\u00020\"H\u00a6@\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\u0004\bf\u0010%J$\u0010g\u001a\b\u0012\u0004\u0012\u00020\'0\u00032\u0006\u0010(\u001a\u00020\'H\u00a6@\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\u0004\bh\u0010*J$\u0010i\u001a\b\u0012\u0004\u0012\u00020,0\u00032\u0006\u0010-\u001a\u00020,H\u00a6@\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\u0004\bj\u0010/\u0082\u0002\u000b\n\u0002\b!\n\u0005\b\u00a1\u001e0\u0001\u00a8\u0006k"}, d2 = {"Lcom/balancetech/sitemanagement/data/datasource/RemoteDataSource;", "", "createExtraPayment", "Lkotlin/Result;", "Lcom/balancetech/sitemanagement/data/entity/ExtraPayment;", "extraPayment", "createExtraPayment-gIAlu-s", "(Lcom/balancetech/sitemanagement/data/entity/ExtraPayment;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "createFee", "Lcom/balancetech/sitemanagement/data/entity/Fee;", "fee", "createFee-gIAlu-s", "(Lcom/balancetech/sitemanagement/data/entity/Fee;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "createFees", "", "fees", "createFees-gIAlu-s", "(Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "createNotification", "Lcom/balancetech/sitemanagement/data/entity/Notification;", "notification", "createNotification-gIAlu-s", "(Lcom/balancetech/sitemanagement/data/entity/Notification;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "createOrUpdateWaterMeter", "Lcom/balancetech/sitemanagement/data/entity/WaterMeter;", "waterMeter", "createOrUpdateWaterMeter-gIAlu-s", "(Lcom/balancetech/sitemanagement/data/entity/WaterMeter;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "createPayment", "Lcom/balancetech/sitemanagement/data/entity/Payment;", "payment", "createPayment-gIAlu-s", "(Lcom/balancetech/sitemanagement/data/entity/Payment;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "createUnit", "Lcom/balancetech/sitemanagement/data/entity/Unit;", "unit", "createUnit-gIAlu-s", "(Lcom/balancetech/sitemanagement/data/entity/Unit;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "createUser", "Lcom/balancetech/sitemanagement/data/entity/User;", "user", "createUser-gIAlu-s", "(Lcom/balancetech/sitemanagement/data/entity/User;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "createWaterBill", "Lcom/balancetech/sitemanagement/data/entity/WaterBill;", "waterBill", "createWaterBill-gIAlu-s", "(Lcom/balancetech/sitemanagement/data/entity/WaterBill;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteWaterBill", "", "waterBillId", "", "deleteWaterBill-gIAlu-s", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getAllExtraPayments", "apartmentId", "getAllFees", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getAllPayments", "getAllUsers", "getAllWaterBills", "getAllWaterMeters", "getFeeById", "id", "getFeesByMonth", "month", "", "year", "(Ljava/lang/String;IILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getFeesByUnit", "unitId", "getFeesByUnitAndStatus", "status", "Lcom/balancetech/sitemanagement/data/model/PaymentStatus;", "(Ljava/lang/String;Lcom/balancetech/sitemanagement/data/model/PaymentStatus;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getNotificationsByUser", "userId", "getPaymentsByFee", "feeId", "getPaymentsByUnit", "getUnitById", "getUnitsByApartment", "getUnreadNotificationCount", "getUnreadNotificationsByUser", "getUserByEmail", "email", "getWaterBillById", "getWaterBillsByUnit", "getWaterMeterByUnit", "markAllAsRead", "markAllAsRead-gIAlu-s", "markAsRead", "notificationId", "markAsRead-0E7RQCE", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "syncAllData", "syncAllData-IoAF18A", "updateExtraPayment", "updateExtraPayment-gIAlu-s", "updateFee", "updateFee-gIAlu-s", "updateUnit", "updateUnit-gIAlu-s", "updateUser", "updateUser-gIAlu-s", "updateWaterBill", "updateWaterBill-gIAlu-s", "app_debug"})
public abstract interface RemoteDataSource {
    
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object getUserByEmail(@org.jetbrains.annotations.NotNull
    java.lang.String email, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super com.balancetech.sitemanagement.data.entity.User> $completion);
    
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object getAllUsers(@org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super java.util.List<com.balancetech.sitemanagement.data.entity.User>> $completion);
    
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object getFeesByUnit(@org.jetbrains.annotations.NotNull
    java.lang.String unitId, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super java.util.List<com.balancetech.sitemanagement.data.entity.Fee>> $completion);
    
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object getFeesByMonth(@org.jetbrains.annotations.NotNull
    java.lang.String apartmentId, int month, int year, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super java.util.List<com.balancetech.sitemanagement.data.entity.Fee>> $completion);
    
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object getFeesByUnitAndStatus(@org.jetbrains.annotations.NotNull
    java.lang.String unitId, @org.jetbrains.annotations.NotNull
    com.balancetech.sitemanagement.data.model.PaymentStatus status, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super java.util.List<com.balancetech.sitemanagement.data.entity.Fee>> $completion);
    
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object getAllFees(@org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super java.util.List<com.balancetech.sitemanagement.data.entity.Fee>> $completion);
    
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object getFeeById(@org.jetbrains.annotations.NotNull
    java.lang.String id, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super com.balancetech.sitemanagement.data.entity.Fee> $completion);
    
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object getPaymentsByUnit(@org.jetbrains.annotations.NotNull
    java.lang.String unitId, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super java.util.List<com.balancetech.sitemanagement.data.entity.Payment>> $completion);
    
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object getPaymentsByFee(@org.jetbrains.annotations.NotNull
    java.lang.String feeId, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super java.util.List<com.balancetech.sitemanagement.data.entity.Payment>> $completion);
    
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object getAllPayments(@org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super java.util.List<com.balancetech.sitemanagement.data.entity.Payment>> $completion);
    
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object getAllWaterMeters(@org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super java.util.List<com.balancetech.sitemanagement.data.entity.WaterMeter>> $completion);
    
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object getWaterMeterByUnit(@org.jetbrains.annotations.NotNull
    java.lang.String unitId, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super com.balancetech.sitemanagement.data.entity.WaterMeter> $completion);
    
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object getWaterBillsByUnit(@org.jetbrains.annotations.NotNull
    java.lang.String unitId, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super java.util.List<com.balancetech.sitemanagement.data.entity.WaterBill>> $completion);
    
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object getAllWaterBills(@org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super java.util.List<com.balancetech.sitemanagement.data.entity.WaterBill>> $completion);
    
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object getWaterBillById(@org.jetbrains.annotations.NotNull
    java.lang.String id, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super com.balancetech.sitemanagement.data.entity.WaterBill> $completion);
    
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object getNotificationsByUser(@org.jetbrains.annotations.NotNull
    java.lang.String userId, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super java.util.List<com.balancetech.sitemanagement.data.entity.Notification>> $completion);
    
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object getUnreadNotificationsByUser(@org.jetbrains.annotations.NotNull
    java.lang.String userId, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super java.util.List<com.balancetech.sitemanagement.data.entity.Notification>> $completion);
    
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object getUnreadNotificationCount(@org.jetbrains.annotations.NotNull
    java.lang.String userId, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super java.lang.Integer> $completion);
    
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object getUnitsByApartment(@org.jetbrains.annotations.NotNull
    java.lang.String apartmentId, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super java.util.List<com.balancetech.sitemanagement.data.entity.Unit>> $completion);
    
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object getUnitById(@org.jetbrains.annotations.NotNull
    java.lang.String id, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super com.balancetech.sitemanagement.data.entity.Unit> $completion);
    
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object getAllExtraPayments(@org.jetbrains.annotations.NotNull
    java.lang.String apartmentId, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super java.util.List<com.balancetech.sitemanagement.data.entity.ExtraPayment>> $completion);
}