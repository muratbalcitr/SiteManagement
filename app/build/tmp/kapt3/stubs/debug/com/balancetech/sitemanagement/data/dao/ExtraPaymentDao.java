package com.balancetech.sitemanagement.data.dao;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\bg\u0018\u00002\u00020\u0001J\u0016\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u00a7@\u00a2\u0006\u0002\u0010\u0006J\u001c\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\t0\b2\u0006\u0010\n\u001a\u00020\u000bH\'J\u001c\u0010\f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\t0\b2\u0006\u0010\n\u001a\u00020\u000bH\'J\u0018\u0010\r\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u000e\u001a\u00020\u000bH\u00a7@\u00a2\u0006\u0002\u0010\u000fJ\u001c\u0010\u0010\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\t0\b2\u0006\u0010\u0011\u001a\u00020\u000bH\'J\u0016\u0010\u0012\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u00a7@\u00a2\u0006\u0002\u0010\u0006J\u0016\u0010\u0013\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u00a7@\u00a2\u0006\u0002\u0010\u0006\u00a8\u0006\u0014"}, d2 = {"Lcom/balancetech/sitemanagement/data/dao/ExtraPaymentDao;", "", "deleteExtraPayment", "", "extraPayment", "Lcom/balancetech/sitemanagement/data/entity/ExtraPayment;", "(Lcom/balancetech/sitemanagement/data/entity/ExtraPayment;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getAllExtraPayments", "Lkotlinx/coroutines/flow/Flow;", "", "apartmentId", "", "getBuildingWideExtraPayments", "getExtraPaymentById", "id", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getExtraPaymentsByUnit", "unitId", "insertExtraPayment", "updateExtraPayment", "app_debug"})
@androidx.room.Dao
public abstract interface ExtraPaymentDao {
    
    @androidx.room.Query(value = "SELECT * FROM extra_payments WHERE id = :id")
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object getExtraPaymentById(@org.jetbrains.annotations.NotNull
    java.lang.String id, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super com.balancetech.sitemanagement.data.entity.ExtraPayment> $completion);
    
    @androidx.room.Query(value = "SELECT * FROM extra_payments WHERE unitId = :unitId ORDER BY createdAt DESC")
    @org.jetbrains.annotations.NotNull
    public abstract kotlinx.coroutines.flow.Flow<java.util.List<com.balancetech.sitemanagement.data.entity.ExtraPayment>> getExtraPaymentsByUnit(@org.jetbrains.annotations.NotNull
    java.lang.String unitId);
    
    @androidx.room.Query(value = "SELECT * FROM extra_payments WHERE apartmentId = :apartmentId AND unitId IS NULL ORDER BY createdAt DESC")
    @org.jetbrains.annotations.NotNull
    public abstract kotlinx.coroutines.flow.Flow<java.util.List<com.balancetech.sitemanagement.data.entity.ExtraPayment>> getBuildingWideExtraPayments(@org.jetbrains.annotations.NotNull
    java.lang.String apartmentId);
    
    @androidx.room.Query(value = "SELECT * FROM extra_payments WHERE apartmentId = :apartmentId ORDER BY createdAt DESC")
    @org.jetbrains.annotations.NotNull
    public abstract kotlinx.coroutines.flow.Flow<java.util.List<com.balancetech.sitemanagement.data.entity.ExtraPayment>> getAllExtraPayments(@org.jetbrains.annotations.NotNull
    java.lang.String apartmentId);
    
    @androidx.room.Insert(onConflict = 1)
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object insertExtraPayment(@org.jetbrains.annotations.NotNull
    com.balancetech.sitemanagement.data.entity.ExtraPayment extraPayment, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Update
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object updateExtraPayment(@org.jetbrains.annotations.NotNull
    com.balancetech.sitemanagement.data.entity.ExtraPayment extraPayment, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Delete
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object deleteExtraPayment(@org.jetbrains.annotations.NotNull
    com.balancetech.sitemanagement.data.entity.ExtraPayment extraPayment, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
}