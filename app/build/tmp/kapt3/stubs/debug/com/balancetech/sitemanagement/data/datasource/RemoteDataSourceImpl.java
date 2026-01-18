package com.balancetech.sitemanagement.data.datasource;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u009a\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\"\u0018\u00002\u00020\u0001B\u0017\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J$\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00130\u00122\u0006\u0010\u0014\u001a\u00020\u0013H\u0096@\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\u0004\b\u0015\u0010\u0016J0\u0010\u0017\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00130\u00180\u00122\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00130\u0018H\u0096@\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\u0004\b\u001a\u0010\u001bJ$\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001d0\u00122\u0006\u0010\u001e\u001a\u00020\u001dH\u0096@\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\u0004\b\u001f\u0010 J$\u0010!\u001a\b\u0012\u0004\u0012\u00020\"0\u00122\u0006\u0010#\u001a\u00020\"H\u0096@\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\u0004\b$\u0010%J0\u0010&\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\"0\u00180\u00122\f\u0010\'\u001a\b\u0012\u0004\u0012\u00020\"0\u0018H\u0096@\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\u0004\b(\u0010\u001bJ$\u0010)\u001a\b\u0012\u0004\u0012\u00020*0\u00122\u0006\u0010+\u001a\u00020*H\u0096@\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\u0004\b,\u0010-J$\u0010.\u001a\b\u0012\u0004\u0012\u00020/0\u00122\u0006\u00100\u001a\u00020/H\u0096@\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\u0004\b1\u00102J$\u00103\u001a\b\u0012\u0004\u0012\u0002040\u00122\u0006\u00105\u001a\u000204H\u0096@\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\u0004\b6\u00107J$\u00108\u001a\b\u0012\u0004\u0012\u0002090\u00122\u0006\u0010:\u001a\u000209H\u0096@\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\u0004\b;\u0010<J$\u0010=\u001a\b\u0012\u0004\u0012\u00020>0\u00122\u0006\u0010?\u001a\u00020>H\u0096@\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\u0004\b@\u0010AJ$\u0010B\u001a\b\u0012\u0004\u0012\u00020C0\u00122\u0006\u0010D\u001a\u00020CH\u0096@\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\u0004\bE\u0010FJ$\u0010G\u001a\b\u0012\u0004\u0012\u00020H0\u00122\u0006\u0010I\u001a\u00020JH\u0096@\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\u0004\bK\u0010LJ\u0012\u0010M\u001a\u0004\u0018\u00010\u00132\u0006\u0010N\u001a\u00020OH\u0002J\u0012\u0010P\u001a\u0004\u0018\u00010\u001d2\u0006\u0010N\u001a\u00020OH\u0002J\u0012\u0010Q\u001a\u0004\u0018\u00010\"2\u0006\u0010N\u001a\u00020OH\u0002J\u0012\u0010R\u001a\u0004\u0018\u00010*2\u0006\u0010N\u001a\u00020OH\u0002J\u0012\u0010S\u001a\u0004\u0018\u0001042\u0006\u0010N\u001a\u00020OH\u0002J\u0012\u0010T\u001a\u0004\u0018\u0001092\u0006\u0010N\u001a\u00020OH\u0002J\u0012\u0010U\u001a\u0004\u0018\u00010>2\u0006\u0010N\u001a\u00020OH\u0002J\u0012\u0010V\u001a\u0004\u0018\u00010C2\u0006\u0010N\u001a\u00020OH\u0002J\u0012\u0010W\u001a\u0004\u0018\u00010/2\u0006\u0010N\u001a\u00020OH\u0002J\u0014\u0010X\u001a\b\u0012\u0004\u0012\u00020\u00130\u0018H\u0096@\u00a2\u0006\u0002\u0010YJ\u001c\u0010Z\u001a\b\u0012\u0004\u0012\u00020\u001d0\u00182\u0006\u0010[\u001a\u00020JH\u0096@\u00a2\u0006\u0002\u0010LJ\u0014\u0010\\\u001a\b\u0012\u0004\u0012\u00020\"0\u0018H\u0096@\u00a2\u0006\u0002\u0010YJ\u0014\u0010]\u001a\b\u0012\u0004\u0012\u0002040\u0018H\u0096@\u00a2\u0006\u0002\u0010YJ\u0014\u0010^\u001a\b\u0012\u0004\u0012\u00020>0\u0018H\u0096@\u00a2\u0006\u0002\u0010YJ\u0014\u0010_\u001a\b\u0012\u0004\u0012\u00020C0\u0018H\u0096@\u00a2\u0006\u0002\u0010YJ\u0014\u0010`\u001a\b\u0012\u0004\u0012\u00020/0\u0018H\u0096@\u00a2\u0006\u0002\u0010YJ\u0018\u0010a\u001a\u0004\u0018\u00010\"2\u0006\u0010b\u001a\u00020JH\u0096@\u00a2\u0006\u0002\u0010LJ,\u0010c\u001a\b\u0012\u0004\u0012\u00020\"0\u00182\u0006\u0010[\u001a\u00020J2\u0006\u0010d\u001a\u00020e2\u0006\u0010f\u001a\u00020eH\u0096@\u00a2\u0006\u0002\u0010gJ\u001c\u0010h\u001a\b\u0012\u0004\u0012\u00020\"0\u00182\u0006\u0010i\u001a\u00020JH\u0096@\u00a2\u0006\u0002\u0010LJ$\u0010j\u001a\b\u0012\u0004\u0012\u00020\"0\u00182\u0006\u0010i\u001a\u00020J2\u0006\u0010k\u001a\u00020lH\u0096@\u00a2\u0006\u0002\u0010mJ\u001c\u0010n\u001a\b\u0012\u0004\u0012\u00020*0\u00182\u0006\u0010o\u001a\u00020JH\u0096@\u00a2\u0006\u0002\u0010LJ\u001c\u0010p\u001a\b\u0012\u0004\u0012\u0002040\u00182\u0006\u0010q\u001a\u00020JH\u0096@\u00a2\u0006\u0002\u0010LJ\u001c\u0010r\u001a\b\u0012\u0004\u0012\u0002040\u00182\u0006\u0010i\u001a\u00020JH\u0096@\u00a2\u0006\u0002\u0010LJ\u0018\u0010s\u001a\u0004\u0018\u0001092\u0006\u0010b\u001a\u00020JH\u0096@\u00a2\u0006\u0002\u0010LJ\u001c\u0010t\u001a\b\u0012\u0004\u0012\u0002090\u00182\u0006\u0010[\u001a\u00020JH\u0096@\u00a2\u0006\u0002\u0010LJ\u0016\u0010u\u001a\u00020e2\u0006\u0010o\u001a\u00020JH\u0096@\u00a2\u0006\u0002\u0010LJ\u001c\u0010v\u001a\b\u0012\u0004\u0012\u00020*0\u00182\u0006\u0010o\u001a\u00020JH\u0096@\u00a2\u0006\u0002\u0010LJ\u0018\u0010w\u001a\u0004\u0018\u00010>2\u0006\u0010x\u001a\u00020JH\u0096@\u00a2\u0006\u0002\u0010LJ\u0018\u0010y\u001a\u0004\u0018\u00010C2\u0006\u0010b\u001a\u00020JH\u0096@\u00a2\u0006\u0002\u0010LJ\u001c\u0010z\u001a\b\u0012\u0004\u0012\u00020C0\u00182\u0006\u0010i\u001a\u00020JH\u0096@\u00a2\u0006\u0002\u0010LJ\u0018\u0010{\u001a\u0004\u0018\u00010/2\u0006\u0010i\u001a\u00020JH\u0096@\u00a2\u0006\u0002\u0010LJ$\u0010|\u001a\b\u0012\u0004\u0012\u00020H0\u00122\u0006\u0010o\u001a\u00020JH\u0096@\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\u0004\b}\u0010LJ.\u0010~\u001a\b\u0012\u0004\u0012\u00020H0\u00122\u0006\u0010\u007f\u001a\u00020J2\u0006\u0010o\u001a\u00020JH\u0096@\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\u0006\b\u0080\u0001\u0010\u0081\u0001J\u001e\u0010\u0082\u0001\u001a\b\u0012\u0004\u0012\u00020H0\u0012H\u0096@\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\u0005\b\u0083\u0001\u0010YJ&\u0010\u0084\u0001\u001a\b\u0012\u0004\u0012\u00020\u001d0\u00122\u0006\u0010\u001e\u001a\u00020\u001dH\u0096@\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\u0005\b\u0085\u0001\u0010 J&\u0010\u0086\u0001\u001a\b\u0012\u0004\u0012\u00020\"0\u00122\u0006\u0010#\u001a\u00020\"H\u0096@\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\u0005\b\u0087\u0001\u0010%J&\u0010\u0088\u0001\u001a\b\u0012\u0004\u0012\u0002090\u00122\u0006\u0010:\u001a\u000209H\u0096@\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\u0005\b\u0089\u0001\u0010<J&\u0010\u008a\u0001\u001a\b\u0012\u0004\u0012\u00020>0\u00122\u0006\u0010?\u001a\u00020>H\u0096@\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\u0005\b\u008b\u0001\u0010AJ&\u0010\u008c\u0001\u001a\b\u0012\u0004\u0012\u00020C0\u00122\u0006\u0010D\u001a\u00020CH\u0096@\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\u0005\b\u008d\u0001\u0010FR\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u0082\u0002\u000b\n\u0002\b!\n\u0005\b\u00a1\u001e0\u0001\u00a8\u0006\u008e\u0001"}, d2 = {"Lcom/balancetech/sitemanagement/data/datasource/RemoteDataSourceImpl;", "Lcom/balancetech/sitemanagement/data/datasource/RemoteDataSource;", "firestore", "Lcom/google/firebase/firestore/FirebaseFirestore;", "firebaseAuth", "Lcom/google/firebase/auth/FirebaseAuth;", "(Lcom/google/firebase/firestore/FirebaseFirestore;Lcom/google/firebase/auth/FirebaseAuth;)V", "bankTransactionsCollection", "Lcom/google/firebase/firestore/CollectionReference;", "extraPaymentsCollection", "feesCollection", "notificationsCollection", "paymentsCollection", "unitsCollection", "usersCollection", "waterBillsCollection", "waterMetersCollection", "createBankTransaction", "Lkotlin/Result;", "Lcom/balancetech/sitemanagement/data/entity/BankTransaction;", "transaction", "createBankTransaction-gIAlu-s", "(Lcom/balancetech/sitemanagement/data/entity/BankTransaction;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "createBankTransactions", "", "transactions", "createBankTransactions-gIAlu-s", "(Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "createExtraPayment", "Lcom/balancetech/sitemanagement/data/entity/ExtraPayment;", "extraPayment", "createExtraPayment-gIAlu-s", "(Lcom/balancetech/sitemanagement/data/entity/ExtraPayment;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "createFee", "Lcom/balancetech/sitemanagement/data/entity/Fee;", "fee", "createFee-gIAlu-s", "(Lcom/balancetech/sitemanagement/data/entity/Fee;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "createFees", "fees", "createFees-gIAlu-s", "createNotification", "Lcom/balancetech/sitemanagement/data/entity/Notification;", "notification", "createNotification-gIAlu-s", "(Lcom/balancetech/sitemanagement/data/entity/Notification;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "createOrUpdateWaterMeter", "Lcom/balancetech/sitemanagement/data/entity/WaterMeter;", "waterMeter", "createOrUpdateWaterMeter-gIAlu-s", "(Lcom/balancetech/sitemanagement/data/entity/WaterMeter;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "createPayment", "Lcom/balancetech/sitemanagement/data/entity/Payment;", "payment", "createPayment-gIAlu-s", "(Lcom/balancetech/sitemanagement/data/entity/Payment;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "createUnit", "Lcom/balancetech/sitemanagement/data/entity/Unit;", "unit", "createUnit-gIAlu-s", "(Lcom/balancetech/sitemanagement/data/entity/Unit;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "createUser", "Lcom/balancetech/sitemanagement/data/entity/User;", "user", "createUser-gIAlu-s", "(Lcom/balancetech/sitemanagement/data/entity/User;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "createWaterBill", "Lcom/balancetech/sitemanagement/data/entity/WaterBill;", "waterBill", "createWaterBill-gIAlu-s", "(Lcom/balancetech/sitemanagement/data/entity/WaterBill;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteWaterBill", "", "waterBillId", "", "deleteWaterBill-gIAlu-s", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "docToBankTransaction", "doc", "Lcom/google/firebase/firestore/DocumentSnapshot;", "docToExtraPayment", "docToFee", "docToNotification", "docToPayment", "docToUnit", "docToUser", "docToWaterBill", "docToWaterMeter", "getAllBankTransactions", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getAllExtraPayments", "apartmentId", "getAllFees", "getAllPayments", "getAllUsers", "getAllWaterBills", "getAllWaterMeters", "getFeeById", "id", "getFeesByMonth", "month", "", "year", "(Ljava/lang/String;IILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getFeesByUnit", "unitId", "getFeesByUnitAndStatus", "status", "Lcom/balancetech/sitemanagement/data/model/PaymentStatus;", "(Ljava/lang/String;Lcom/balancetech/sitemanagement/data/model/PaymentStatus;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getNotificationsByUser", "userId", "getPaymentsByFee", "feeId", "getPaymentsByUnit", "getUnitById", "getUnitsByApartment", "getUnreadNotificationCount", "getUnreadNotificationsByUser", "getUserByEmail", "email", "getWaterBillById", "getWaterBillsByUnit", "getWaterMeterByUnit", "markAllAsRead", "markAllAsRead-gIAlu-s", "markAsRead", "notificationId", "markAsRead-0E7RQCE", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "syncAllData", "syncAllData-IoAF18A", "updateExtraPayment", "updateExtraPayment-gIAlu-s", "updateFee", "updateFee-gIAlu-s", "updateUnit", "updateUnit-gIAlu-s", "updateUser", "updateUser-gIAlu-s", "updateWaterBill", "updateWaterBill-gIAlu-s", "app_debug"})
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
    @org.jetbrains.annotations.NotNull
    private final com.google.firebase.firestore.CollectionReference bankTransactionsCollection = null;
    
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
    
    private final com.balancetech.sitemanagement.data.entity.Unit docToUnit(com.google.firebase.firestore.DocumentSnapshot doc) {
        return null;
    }
    
    private final com.balancetech.sitemanagement.data.entity.Payment docToPayment(com.google.firebase.firestore.DocumentSnapshot doc) {
        return null;
    }
    
    private final com.balancetech.sitemanagement.data.entity.WaterMeter docToWaterMeter(com.google.firebase.firestore.DocumentSnapshot doc) {
        return null;
    }
    
    private final com.balancetech.sitemanagement.data.entity.WaterBill docToWaterBill(com.google.firebase.firestore.DocumentSnapshot doc) {
        return null;
    }
    
    private final com.balancetech.sitemanagement.data.entity.ExtraPayment docToExtraPayment(com.google.firebase.firestore.DocumentSnapshot doc) {
        return null;
    }
    
    private final com.balancetech.sitemanagement.data.entity.Notification docToNotification(com.google.firebase.firestore.DocumentSnapshot doc) {
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
    
    @java.lang.Override
    @org.jetbrains.annotations.Nullable
    public java.lang.Object getAllBankTransactions(@org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super java.util.List<com.balancetech.sitemanagement.data.entity.BankTransaction>> $completion) {
        return null;
    }
    
    private final com.balancetech.sitemanagement.data.entity.BankTransaction docToBankTransaction(com.google.firebase.firestore.DocumentSnapshot doc) {
        return null;
    }
}