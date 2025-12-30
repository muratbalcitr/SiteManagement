package com.balancetech.sitemanagement.data.repository;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0006\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J`\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\t2\u0006\u0010\u000b\u001a\u00020\t2\b\u0010\f\u001a\u0004\u0018\u00010\t2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0086@\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\u0004\b\u0015\u0010\u0016J\u001a\u0010\u0017\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00190\u00182\u0006\u0010\b\u001a\u00020\tJ\u001a\u0010\u001a\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00190\u00182\u0006\u0010\b\u001a\u00020\tJ\u001a\u0010\u001b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00190\u00182\u0006\u0010\n\u001a\u00020\tJ,\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\u001d\u001a\u00020\t2\u0006\u0010\u001e\u001a\u00020\u000eH\u0086@\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\u0004\b\u001f\u0010 J\u0016\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020\u0007H\u0086@\u00a2\u0006\u0002\u0010$R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u0082\u0002\u000b\n\u0002\b!\n\u0005\b\u00a1\u001e0\u0001\u00a8\u0006%"}, d2 = {"Lcom/balancetech/sitemanagement/data/repository/ExtraPaymentRepository;", "", "extraPaymentDao", "Lcom/balancetech/sitemanagement/data/dao/ExtraPaymentDao;", "(Lcom/balancetech/sitemanagement/data/dao/ExtraPaymentDao;)V", "createExtraPayment", "Lkotlin/Result;", "Lcom/balancetech/sitemanagement/data/entity/ExtraPayment;", "apartmentId", "", "unitId", "title", "description", "amount", "", "type", "Lcom/balancetech/sitemanagement/data/model/ExtraPaymentType;", "installmentCount", "", "dueDate", "", "createExtraPayment-tZkwj4A", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;DLcom/balancetech/sitemanagement/data/model/ExtraPaymentType;IJLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getAllExtraPayments", "Lkotlinx/coroutines/flow/Flow;", "", "getBuildingWideExtraPayments", "getExtraPaymentsByUnit", "recordPayment", "extraPaymentId", "paymentAmount", "recordPayment-0E7RQCE", "(Ljava/lang/String;DLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateExtraPayment", "", "extraPayment", "(Lcom/balancetech/sitemanagement/data/entity/ExtraPayment;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_debug"})
public final class ExtraPaymentRepository {
    @org.jetbrains.annotations.NotNull
    private final com.balancetech.sitemanagement.data.dao.ExtraPaymentDao extraPaymentDao = null;
    
    public ExtraPaymentRepository(@org.jetbrains.annotations.NotNull
    com.balancetech.sitemanagement.data.dao.ExtraPaymentDao extraPaymentDao) {
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