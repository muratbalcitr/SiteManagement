package com.balancetech.sitemanagement.data.datasource;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0094\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u0002\n\u0002\b\u0012\u0018\u00002\u00020\u0001B\u0017\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J$\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u00112\u0006\u0010\u0013\u001a\u00020\u0012H\u0096@\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\u0004\b\u0014\u0010\u0015J$\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00170\u00112\u0006\u0010\u0018\u001a\u00020\u0017H\u0096@\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\u0004\b\u0019\u0010\u001aJ0\u0010\u001b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00170\u001c0\u00112\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00170\u001cH\u0096@\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\u0004\b\u001e\u0010\u001fJ$\u0010 \u001a\b\u0012\u0004\u0012\u00020!0\u00112\u0006\u0010\"\u001a\u00020!H\u0096@\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\u0004\b#\u0010$J$\u0010%\u001a\b\u0012\u0004\u0012\u00020&0\u00112\u0006\u0010\'\u001a\u00020&H\u0096@\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\u0004\b(\u0010)J$\u0010*\u001a\b\u0012\u0004\u0012\u00020+0\u00112\u0006\u0010,\u001a\u00020+H\u0096@\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\u0004\b-\u0010.J$\u0010/\u001a\b\u0012\u0004\u0012\u0002000\u00112\u0006\u00101\u001a\u000200H\u0096@\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\u0004\b2\u00103J$\u00104\u001a\b\u0012\u0004\u0012\u0002050\u00112\u0006\u00106\u001a\u000205H\u0096@\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\u0004\b7\u00108J$\u00109\u001a\b\u0012\u0004\u0012\u00020:0\u00112\u0006\u0010;\u001a\u00020:H\u0096@\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\u0004\b<\u0010=J\u0012\u0010>\u001a\u0004\u0018\u00010\u00172\u0006\u0010?\u001a\u00020@H\u0002J\u0012\u0010A\u001a\u0004\u0018\u0001052\u0006\u0010?\u001a\u00020@H\u0002J\u001c\u0010B\u001a\b\u0012\u0004\u0012\u00020\u00120\u001c2\u0006\u0010C\u001a\u00020DH\u0096@\u00a2\u0006\u0002\u0010EJ\u0014\u0010F\u001a\b\u0012\u0004\u0012\u00020\u00170\u001cH\u0096@\u00a2\u0006\u0002\u0010GJ\u0014\u0010H\u001a\b\u0012\u0004\u0012\u00020+0\u001cH\u0096@\u00a2\u0006\u0002\u0010GJ\u0014\u0010I\u001a\b\u0012\u0004\u0012\u0002050\u001cH\u0096@\u00a2\u0006\u0002\u0010GJ\u0014\u0010J\u001a\b\u0012\u0004\u0012\u00020:0\u001cH\u0096@\u00a2\u0006\u0002\u0010GJ\u0014\u0010K\u001a\b\u0012\u0004\u0012\u00020&0\u001cH\u0096@\u00a2\u0006\u0002\u0010GJ\u0018\u0010L\u001a\u0004\u0018\u00010\u00172\u0006\u0010M\u001a\u00020DH\u0096@\u00a2\u0006\u0002\u0010EJ,\u0010N\u001a\b\u0012\u0004\u0012\u00020\u00170\u001c2\u0006\u0010C\u001a\u00020D2\u0006\u0010O\u001a\u00020P2\u0006\u0010Q\u001a\u00020PH\u0096@\u00a2\u0006\u0002\u0010RJ\u001c\u0010S\u001a\b\u0012\u0004\u0012\u00020\u00170\u001c2\u0006\u0010T\u001a\u00020DH\u0096@\u00a2\u0006\u0002\u0010EJ$\u0010U\u001a\b\u0012\u0004\u0012\u00020\u00170\u001c2\u0006\u0010T\u001a\u00020D2\u0006\u0010V\u001a\u00020WH\u0096@\u00a2\u0006\u0002\u0010XJ\u001c\u0010Y\u001a\b\u0012\u0004\u0012\u00020!0\u001c2\u0006\u0010Z\u001a\u00020DH\u0096@\u00a2\u0006\u0002\u0010EJ\u001c\u0010[\u001a\b\u0012\u0004\u0012\u00020+0\u001c2\u0006\u0010\\\u001a\u00020DH\u0096@\u00a2\u0006\u0002\u0010EJ\u001c\u0010]\u001a\b\u0012\u0004\u0012\u00020+0\u001c2\u0006\u0010T\u001a\u00020DH\u0096@\u00a2\u0006\u0002\u0010EJ\u0018\u0010^\u001a\u0004\u0018\u0001002\u0006\u0010M\u001a\u00020DH\u0096@\u00a2\u0006\u0002\u0010EJ\u001c\u0010_\u001a\b\u0012\u0004\u0012\u0002000\u001c2\u0006\u0010C\u001a\u00020DH\u0096@\u00a2\u0006\u0002\u0010EJ\u0016\u0010`\u001a\u00020P2\u0006\u0010Z\u001a\u00020DH\u0096@\u00a2\u0006\u0002\u0010EJ\u001c\u0010a\u001a\b\u0012\u0004\u0012\u00020!0\u001c2\u0006\u0010Z\u001a\u00020DH\u0096@\u00a2\u0006\u0002\u0010EJ\u0018\u0010b\u001a\u0004\u0018\u0001052\u0006\u0010c\u001a\u00020DH\u0096@\u00a2\u0006\u0002\u0010EJ\u0018\u0010d\u001a\u0004\u0018\u00010:2\u0006\u0010M\u001a\u00020DH\u0096@\u00a2\u0006\u0002\u0010EJ\u001c\u0010e\u001a\b\u0012\u0004\u0012\u00020:0\u001c2\u0006\u0010T\u001a\u00020DH\u0096@\u00a2\u0006\u0002\u0010EJ\u0018\u0010f\u001a\u0004\u0018\u00010&2\u0006\u0010T\u001a\u00020DH\u0096@\u00a2\u0006\u0002\u0010EJ$\u0010g\u001a\b\u0012\u0004\u0012\u00020h0\u00112\u0006\u0010Z\u001a\u00020DH\u0096@\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\u0004\bi\u0010EJ,\u0010j\u001a\b\u0012\u0004\u0012\u00020h0\u00112\u0006\u0010k\u001a\u00020D2\u0006\u0010Z\u001a\u00020DH\u0096@\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\u0004\bl\u0010mJ\u001c\u0010n\u001a\b\u0012\u0004\u0012\u00020h0\u0011H\u0096@\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\u0004\bo\u0010GJ$\u0010p\u001a\b\u0012\u0004\u0012\u00020\u00120\u00112\u0006\u0010\u0013\u001a\u00020\u0012H\u0096@\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\u0004\bq\u0010\u0015J$\u0010r\u001a\b\u0012\u0004\u0012\u00020\u00170\u00112\u0006\u0010\u0018\u001a\u00020\u0017H\u0096@\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\u0004\bs\u0010\u001aJ$\u0010t\u001a\b\u0012\u0004\u0012\u0002000\u00112\u0006\u00101\u001a\u000200H\u0096@\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\u0004\bu\u00103J$\u0010v\u001a\b\u0012\u0004\u0012\u0002050\u00112\u0006\u00106\u001a\u000205H\u0096@\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\u0004\bw\u00108J$\u0010x\u001a\b\u0012\u0004\u0012\u00020:0\u00112\u0006\u0010;\u001a\u00020:H\u0096@\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\u0004\by\u0010=R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u0082\u0002\u000b\n\u0002\b!\n\u0005\b\u00a1\u001e0\u0001\u00a8\u0006z"}, d2 = {"Lcom/balancetech/sitemanagement/data/datasource/RemoteDataSourceImpl;", "Lcom/balancetech/sitemanagement/data/datasource/RemoteDataSource;", "firestore", "Lcom/google/firebase/firestore/FirebaseFirestore;", "firebaseAuth", "Lcom/google/firebase/auth/FirebaseAuth;", "(Lcom/google/firebase/firestore/FirebaseFirestore;Lcom/google/firebase/auth/FirebaseAuth;)V", "extraPaymentsCollection", "Lcom/google/firebase/firestore/CollectionReference;", "feesCollection", "notificationsCollection", "paymentsCollection", "unitsCollection", "usersCollection", "waterBillsCollection", "waterMetersCollection", "createExtraPayment", "Lkotlin/Result;", "Lcom/balancetech/sitemanagement/data/entity/ExtraPayment;", "extraPayment", "createExtraPayment-gIAlu-s", "(Lcom/balancetech/sitemanagement/data/entity/ExtraPayment;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "createFee", "Lcom/balancetech/sitemanagement/data/entity/Fee;", "fee", "createFee-gIAlu-s", "(Lcom/balancetech/sitemanagement/data/entity/Fee;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "createFees", "", "fees", "createFees-gIAlu-s", "(Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "createNotification", "Lcom/balancetech/sitemanagement/data/entity/Notification;", "notification", "createNotification-gIAlu-s", "(Lcom/balancetech/sitemanagement/data/entity/Notification;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "createOrUpdateWaterMeter", "Lcom/balancetech/sitemanagement/data/entity/WaterMeter;", "waterMeter", "createOrUpdateWaterMeter-gIAlu-s", "(Lcom/balancetech/sitemanagement/data/entity/WaterMeter;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "createPayment", "Lcom/balancetech/sitemanagement/data/entity/Payment;", "payment", "createPayment-gIAlu-s", "(Lcom/balancetech/sitemanagement/data/entity/Payment;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "createUnit", "Lcom/balancetech/sitemanagement/data/entity/Unit;", "unit", "createUnit-gIAlu-s", "(Lcom/balancetech/sitemanagement/data/entity/Unit;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "createUser", "Lcom/balancetech/sitemanagement/data/entity/User;", "user", "createUser-gIAlu-s", "(Lcom/balancetech/sitemanagement/data/entity/User;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "createWaterBill", "Lcom/balancetech/sitemanagement/data/entity/WaterBill;", "waterBill", "createWaterBill-gIAlu-s", "(Lcom/balancetech/sitemanagement/data/entity/WaterBill;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "docToFee", "doc", "Lcom/google/firebase/firestore/DocumentSnapshot;", "docToUser", "getAllExtraPayments", "apartmentId", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getAllFees", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getAllPayments", "getAllUsers", "getAllWaterBills", "getAllWaterMeters", "getFeeById", "id", "getFeesByMonth", "month", "", "year", "(Ljava/lang/String;IILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getFeesByUnit", "unitId", "getFeesByUnitAndStatus", "status", "Lcom/balancetech/sitemanagement/data/model/PaymentStatus;", "(Ljava/lang/String;Lcom/balancetech/sitemanagement/data/model/PaymentStatus;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getNotificationsByUser", "userId", "getPaymentsByFee", "feeId", "getPaymentsByUnit", "getUnitById", "getUnitsByApartment", "getUnreadNotificationCount", "getUnreadNotificationsByUser", "getUserByEmail", "email", "getWaterBillById", "getWaterBillsByUnit", "getWaterMeterByUnit", "markAllAsRead", "", "markAllAsRead-gIAlu-s", "markAsRead", "notificationId", "markAsRead-0E7RQCE", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "syncAllData", "syncAllData-IoAF18A", "updateExtraPayment", "updateExtraPayment-gIAlu-s", "updateFee", "updateFee-gIAlu-s", "updateUnit", "updateUnit-gIAlu-s", "updateUser", "updateUser-gIAlu-s", "updateWaterBill", "updateWaterBill-gIAlu-s", "app_debug"})
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
    @org.jetbrains.annotations.NotNull
    private final com.google.firebase.firestore.CollectionReference extraPaymentsCollection = null;
    
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
    public java.lang.Object getAllUsers(@org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super java.util.List<com.balancetech.sitemanagement.data.entity.User>> $completion) {
        return null;
    }
    
    private final com.balancetech.sitemanagement.data.entity.User docToUser(com.google.firebase.firestore.DocumentSnapshot doc) {
        return null;
    }
    
    private final com.balancetech.sitemanagement.data.entity.Fee docToFee(com.google.firebase.firestore.DocumentSnapshot doc) {
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
    public java.lang.Object getAllWaterBills(@org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super java.util.List<com.balancetech.sitemanagement.data.entity.WaterBill>> $completion) {
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
    
    @java.lang.Override
    @org.jetbrains.annotations.Nullable
    public java.lang.Object getAllExtraPayments(@org.jetbrains.annotations.NotNull
    java.lang.String apartmentId, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super java.util.List<com.balancetech.sitemanagement.data.entity.ExtraPayment>> $completion) {
        return null;
    }
}