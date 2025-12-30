package com.balancetech.sitemanagement.data.repository;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0006\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0017\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J`\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\r\u001a\u00020\u000b2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0086@\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\u0004\b\u0017\u0010\u0018J\u001a\u0010\u0019\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\u001b0\u001a2\u0006\u0010\n\u001a\u00020\u000bJ\u001a\u0010\u001c\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\u001b0\u001a2\u0006\u0010\n\u001a\u00020\u000bJ\u001a\u0010\u001d\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\u001b0\u001a2\u0006\u0010\f\u001a\u00020\u000bJ,\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010\u001f\u001a\u00020\u000b2\u0006\u0010 \u001a\u00020\u0010H\u0086@\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\u0004\b!\u0010\"J\u0016\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020\tH\u0086@\u00a2\u0006\u0002\u0010&R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u0082\u0002\u000b\n\u0002\b!\n\u0005\b\u00a1\u001e0\u0001\u00a8\u0006\'"}, d2 = {"Lcom/balancetech/sitemanagement/data/repository/ExtraPaymentRepository;", "", "extraPaymentDao", "Lcom/balancetech/sitemanagement/data/dao/ExtraPaymentDao;", "remoteDataSource", "Lcom/balancetech/sitemanagement/data/datasource/RemoteDataSource;", "(Lcom/balancetech/sitemanagement/data/dao/ExtraPaymentDao;Lcom/balancetech/sitemanagement/data/datasource/RemoteDataSource;)V", "createExtraPayment", "Lkotlin/Result;", "Lcom/balancetech/sitemanagement/data/entity/ExtraPayment;", "apartmentId", "", "unitId", "title", "description", "amount", "", "type", "Lcom/balancetech/sitemanagement/data/model/ExtraPaymentType;", "installmentCount", "", "dueDate", "", "createExtraPayment-tZkwj4A", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;DLcom/balancetech/sitemanagement/data/model/ExtraPaymentType;IJLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getAllExtraPayments", "Lkotlinx/coroutines/flow/Flow;", "", "getBuildingWideExtraPayments", "getExtraPaymentsByUnit", "recordPayment", "extraPaymentId", "paymentAmount", "recordPayment-0E7RQCE", "(Ljava/lang/String;DLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateExtraPayment", "", "extraPayment", "(Lcom/balancetech/sitemanagement/data/entity/ExtraPayment;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_debug"})
public final class ExtraPaymentRepository {
    @org.jetbrains.annotations.NotNull
    private final com.balancetech.sitemanagement.data.dao.ExtraPaymentDao extraPaymentDao = null;
    @org.jetbrains.annotations.NotNull
    private final com.balancetech.sitemanagement.data.datasource.RemoteDataSource remoteDataSource = null;
    
    @javax.inject.Inject
    public ExtraPaymentRepository(@org.jetbrains.annotations.NotNull
    com.balancetech.sitemanagement.data.dao.ExtraPaymentDao extraPaymentDao, @org.jetbrains.annotations.NotNull
    com.balancetech.sitemanagement.data.datasource.RemoteDataSource remoteDataSource) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.Flow<java.util.List<com.balancetech.sitemanagement.data.entity.ExtraPayment>> getExtraPaymentsByUnit(@org.jetbrains.annotations.NotNull
    java.lang.String unitId) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.Flow<java.util.List<com.balancetech.sitemanagement.data.entity.ExtraPayment>> getBuildingWideExtraPayments(@org.jetbrains.annotations.NotNull
    java.lang.String apartmentId) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.Flow<java.util.List<com.balancetech.sitemanagement.data.entity.ExtraPayment>> getAllExtraPayments(@org.jetbrains.annotations.NotNull
    java.lang.String apartmentId) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object updateExtraPayment(@org.jetbrains.annotations.NotNull
    com.balancetech.sitemanagement.data.entity.ExtraPayment extraPayment, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
}