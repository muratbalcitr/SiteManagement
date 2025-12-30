package com.balancetech.sitemanagement.data.datasource;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0084\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0002\n\u0002\b\u000e\u0018\u00002\u00020\u0001B\u0017\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J$\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u00102\u0006\u0010\u0012\u001a\u00020\u0011H\u0096@\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\u0004\b\u0013\u0010\u0014J0\u0010\u0015\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110\u00160\u00102\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00110\u0016H\u0096@\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\u0004\b\u0018\u0010\u0019J$\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u001b0\u00102\u0006\u0010\u001c\u001a\u00020\u001bH\u0096@\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\u0004\b\u001d\u0010\u001eJ$\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020 0\u00102\u0006\u0010!\u001a\u00020 H\u0096@\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\u0004\b\"\u0010#J$\u0010$\u001a\b\u0012\u0004\u0012\u00020%0\u00102\u0006\u0010&\u001a\u00020%H\u0096@\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\u0004\b\'\u0010(J$\u0010)\u001a\b\u0012\u0004\u0012\u00020*0\u00102\u0006\u0010+\u001a\u00020*H\u0096@\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\u0004\b,\u0010-J$\u0010.\u001a\b\u0012\u0004\u0012\u00020/0\u00102\u0006\u00100\u001a\u00020/H\u0096@\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\u0004\b1\u00102J\u0014\u00103\u001a\b\u0012\u0004\u0012\u00020\u00110\u0016H\u0096@\u00a2\u0006\u0002\u00104J\u0014\u00105\u001a\b\u0012\u0004\u0012\u00020%0\u0016H\u0096@\u00a2\u0006\u0002\u00104J\u0014\u00106\u001a\b\u0012\u0004\u0012\u00020 0\u0016H\u0096@\u00a2\u0006\u0002\u00104J\u0018\u00107\u001a\u0004\u0018\u00010\u00112\u0006\u00108\u001a\u000209H\u0096@\u00a2\u0006\u0002\u0010:J,\u0010;\u001a\b\u0012\u0004\u0012\u00020\u00110\u00162\u0006\u0010<\u001a\u0002092\u0006\u0010=\u001a\u00020>2\u0006\u0010?\u001a\u00020>H\u0096@\u00a2\u0006\u0002\u0010@J\u001c\u0010A\u001a\b\u0012\u0004\u0012\u00020\u00110\u00162\u0006\u0010B\u001a\u000209H\u0096@\u00a2\u0006\u0002\u0010:J$\u0010C\u001a\b\u0012\u0004\u0012\u00020\u00110\u00162\u0006\u0010B\u001a\u0002092\u0006\u0010D\u001a\u00020EH\u0096@\u00a2\u0006\u0002\u0010FJ\u001c\u0010G\u001a\b\u0012\u0004\u0012\u00020\u001b0\u00162\u0006\u0010H\u001a\u000209H\u0096@\u00a2\u0006\u0002\u0010:J\u001c\u0010I\u001a\b\u0012\u0004\u0012\u00020%0\u00162\u0006\u0010J\u001a\u000209H\u0096@\u00a2\u0006\u0002\u0010:J\u001c\u0010K\u001a\b\u0012\u0004\u0012\u00020%0\u00162\u0006\u0010B\u001a\u000209H\u0096@\u00a2\u0006\u0002\u0010:J\u0018\u0010L\u001a\u0004\u0018\u00010M2\u0006\u00108\u001a\u000209H\u0096@\u00a2\u0006\u0002\u0010:J\u001c\u0010N\u001a\b\u0012\u0004\u0012\u00020M0\u00162\u0006\u0010<\u001a\u000209H\u0096@\u00a2\u0006\u0002\u0010:J\u0016\u0010O\u001a\u00020>2\u0006\u0010H\u001a\u000209H\u0096@\u00a2\u0006\u0002\u0010:J\u001c\u0010P\u001a\b\u0012\u0004\u0012\u00020\u001b0\u00162\u0006\u0010H\u001a\u000209H\u0096@\u00a2\u0006\u0002\u0010:J\u0018\u0010Q\u001a\u0004\u0018\u00010*2\u0006\u0010R\u001a\u000209H\u0096@\u00a2\u0006\u0002\u0010:J\u0018\u0010S\u001a\u0004\u0018\u00010/2\u0006\u00108\u001a\u000209H\u0096@\u00a2\u0006\u0002\u0010:J\u001c\u0010T\u001a\b\u0012\u0004\u0012\u00020/0\u00162\u0006\u0010B\u001a\u000209H\u0096@\u00a2\u0006\u0002\u0010:J\u0018\u0010U\u001a\u0004\u0018\u00010 2\u0006\u0010B\u001a\u000209H\u0096@\u00a2\u0006\u0002\u0010:J$\u0010V\u001a\b\u0012\u0004\u0012\u00020W0\u00102\u0006\u0010H\u001a\u000209H\u0096@\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\u0004\bX\u0010:J,\u0010Y\u001a\b\u0012\u0004\u0012\u00020W0\u00102\u0006\u0010Z\u001a\u0002092\u0006\u0010H\u001a\u000209H\u0096@\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\u0004\b[\u0010\\J\u001c\u0010]\u001a\b\u0012\u0004\u0012\u00020W0\u0010H\u0096@\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\u0004\b^\u00104J$\u0010_\u001a\b\u0012\u0004\u0012\u00020\u00110\u00102\u0006\u0010\u0012\u001a\u00020\u0011H\u0096@\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\u0004\b`\u0010\u0014J$\u0010a\u001a\b\u0012\u0004\u0012\u00020*0\u00102\u0006\u0010+\u001a\u00020*H\u0096@\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\u0004\bb\u0010-J$\u0010c\u001a\b\u0012\u0004\u0012\u00020/0\u00102\u0006\u00100\u001a\u00020/H\u0096@\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\u0004\bd\u00102R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u0082\u0002\u000b\n\u0002\b!\n\u0005\b\u00a1\u001e0\u0001\u00a8\u0006e"}, d2 = {"Lcom/balancetech/sitemanagement/data/datasource/RemoteDataSourceImpl;", "Lcom/balancetech/sitemanagement/data/datasource/RemoteDataSource;", "firestore", "Lcom/google/firebase/firestore/FirebaseFirestore;", "firebaseAuth", "Lcom/google/firebase/auth/FirebaseAuth;", "(Lcom/google/firebase/firestore/FirebaseFirestore;Lcom/google/firebase/auth/FirebaseAuth;)V", "feesCollection", "Lcom/google/firebase/firestore/CollectionReference;", "notificationsCollection", "paymentsCollection", "unitsCollection", "usersCollection", "waterBillsCollection", "waterMetersCollection", "createFee", "Lkotlin/Result;", "Lcom/balancetech/sitemanagement/data/entity/Fee;", "fee", "createFee-gIAlu-s", "(Lcom/balancetech/sitemanagement/data/entity/Fee;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "createFees", "", "fees", "createFees-gIAlu-s", "(Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "createNotification", "Lcom/balancetech/sitemanagement/data/entity/Notification;", "notification", "createNotification-gIAlu-s", "(Lcom/balancetech/sitemanagement/data/entity/Notification;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "createOrUpdateWaterMeter", "Lcom/balancetech/sitemanagement/data/entity/WaterMeter;", "waterMeter", "createOrUpdateWaterMeter-gIAlu-s", "(Lcom/balancetech/sitemanagement/data/entity/WaterMeter;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "createPayment", "Lcom/balancetech/sitemanagement/data/entity/Payment;", "payment", "createPayment-gIAlu-s", "(Lcom/balancetech/sitemanagement/data/entity/Payment;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "createUser", "Lcom/balancetech/sitemanagement/data/entity/User;", "user", "createUser-gIAlu-s", "(Lcom/balancetech/sitemanagement/data/entity/User;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "createWaterBill", "Lcom/balancetech/sitemanagement/data/entity/WaterBill;", "waterBill", "createWaterBill-gIAlu-s", "(Lcom/balancetech/sitemanagement/data/entity/WaterBill;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getAllFees", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getAllPayments", "getAllWaterMeters", "getFeeById", "id", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getFeesByMonth", "apartmentId", "month", "", "year", "(Ljava/lang/String;IILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getFeesByUnit", "unitId", "getFeesByUnitAndStatus", "status", "Lcom/balancetech/sitemanagement/data/model/PaymentStatus;", "(Ljava/lang/String;Lcom/balancetech/sitemanagement/data/model/PaymentStatus;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getNotificationsByUser", "userId", "getPaymentsByFee", "feeId", "getPaymentsByUnit", "getUnitById", "Lcom/balancetech/sitemanagement/data/entity/Unit;", "getUnitsByApartment", "getUnreadNotificationCount", "getUnreadNotificationsByUser", "getUserByEmail", "email", "getWaterBillById", "getWaterBillsByUnit", "getWaterMeterByUnit", "markAllAsRead", "", "markAllAsRead-gIAlu-s", "markAsRead", "notificationId", "markAsRead-0E7RQCE", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "syncAllData", "syncAllData-IoAF18A", "updateFee", "updateFee-gIAlu-s", "updateUser", "updateUser-gIAlu-s", "updateWaterBill", "updateWaterBill-gIAlu-s", "app_debug"})
public final class RemoteDataSourceImpl implements com.balancetech.sitemanagement.data.datasource.RemoteDataSource {
    @org.jetbrains.annotations.NotNull
    private final com.google.firebase.firestore.FirebaseFirestore firestore = null;
    @org.jetbrains.annotations.NotNull
    private final com.google.firebase.auth.FirebaseAuth firebaseAuth = null;
    @org.jetbrains.annotations.NotNull
    private final com.google.firebase.firestore.CollectionReference usersCollection = null;
    @org.jetbrains.annotations.NotNull
    private final com.google.firebase.firestore.CollectionReference feesCollection = null;
    @org.jetbrains.annotations.NotNull
    private final com.google.firebase.firestore.CollectionReference paymentsCollection = null;
    @org.jetbrains.annotations.NotNull
    private final com.google.firebase.firestore.CollectionReference waterMetersCollection = null;
    @org.jetbrains.annotations.NotNull
    private final com.google.firebase.firestore.CollectionReference waterBillsCollection = null;
    @org.jetbrains.annotations.NotNull
    private final com.google.firebase.firestore.CollectionReference notificationsCollection = null;
    @org.jetbrains.annotations.NotNull
    private final com.google.firebase.firestore.CollectionReference unitsCollection = null;
    
    @javax.inject.Inject
    public RemoteDataSourceImpl(@org.jetbrains.annotations.NotNull
    com.google.firebase.firestore.FirebaseFirestore firestore, @org.jetbrains.annotations.NotNull
    com.google.firebase.auth.FirebaseAuth firebaseAuth) {
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
    public java.lang.Object getFeesByUnit(@org.jetbrains.annotations.NotNull
    java.lang.String unitId, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super java.util.List<com.balancetech.sitemanagement.data.entity.Fee>> $completion) {
        return null;
    }
    
    @java.lang.Override
    @org.jetbrains.annotations.Nullable
    public java.lang.Object getFeesByMonth(@org.jetbrains.annotations.NotNull
    java.lang.String apartmentId, int month, int year, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super java.util.List<com.balancetech.sitemanagement.data.entity.Fee>> $completion) {
        return null;
    }
    
    @java.lang.Override
    @org.jetbrains.annotations.Nullable
    public java.lang.Object getFeesByUnitAndStatus(@org.jetbrains.annotations.NotNull
    java.lang.String unitId, @org.jetbrains.annotations.NotNull
    com.balancetech.sitemanagement.data.model.PaymentStatus status, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super java.util.List<com.balancetech.sitemanagement.data.entity.Fee>> $completion) {
        return null;
    }
    
    @java.lang.Override
    @org.jetbrains.annotations.Nullable
    public java.lang.Object getAllFees(@org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super java.util.List<com.balancetech.sitemanagement.data.entity.Fee>> $completion) {
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
    public java.lang.Object getPaymentsByUnit(@org.jetbrains.annotations.NotNull
    java.lang.String unitId, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super java.util.List<com.balancetech.sitemanagement.data.entity.Payment>> $completion) {
        return null;
    }
    
    @java.lang.Override
    @org.jetbrains.annotations.Nullable
    public java.lang.Object getPaymentsByFee(@org.jetbrains.annotations.NotNull
    java.lang.String feeId, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super java.util.List<com.balancetech.sitemanagement.data.entity.Payment>> $completion) {
        return null;
    }
    
    @java.lang.Override
    @org.jetbrains.annotations.Nullable
    public java.lang.Object getAllPayments(@org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super java.util.List<com.balancetech.sitemanagement.data.entity.Payment>> $completion) {
        return null;
    }
    
    @java.lang.Override
    @org.jetbrains.annotations.Nullable
    public java.lang.Object getAllWaterMeters(@org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super java.util.List<com.balancetech.sitemanagement.data.entity.WaterMeter>> $completion) {
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
    public java.lang.Object getWaterBillsByUnit(@org.jetbrains.annotations.NotNull
    java.lang.String unitId, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super java.util.List<com.balancetech.sitemanagement.data.entity.WaterBill>> $completion) {
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
    public java.lang.Object getNotificationsByUser(@org.jetbrains.annotations.NotNull
    java.lang.String userId, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super java.util.List<com.balancetech.sitemanagement.data.entity.Notification>> $completion) {
        return null;
    }
    
    @java.lang.Override
    @org.jetbrains.annotations.Nullable
    public java.lang.Object getUnreadNotificationsByUser(@org.jetbrains.annotations.NotNull
    java.lang.String userId, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super java.util.List<com.balancetech.sitemanagement.data.entity.Notification>> $completion) {
        return null;
    }
    
    @java.lang.Override
    @org.jetbrains.annotations.Nullable
    public java.lang.Object getUnreadNotificationCount(@org.jetbrains.annotations.NotNull
    java.lang.String userId, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super java.lang.Integer> $completion) {
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
}