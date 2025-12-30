package com.balancetech.sitemanagement.data.dao;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\bg\u0018\u00002\u00020\u0001J\u0016\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u00a7@\u00a2\u0006\u0002\u0010\u0006J\u0014\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\t0\bH\'J\u0018\u0010\n\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u000b\u001a\u00020\fH\u00a7@\u00a2\u0006\u0002\u0010\rJ(\u0010\u000e\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u000f\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0011H\u00a7@\u00a2\u0006\u0002\u0010\u0013J$\u0010\u0014\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\t0\b2\u0006\u0010\u0015\u001a\u00020\f2\u0006\u0010\u0016\u001a\u00020\u0017H\'J,\u0010\u0018\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\t0\b2\u0006\u0010\u0015\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0011H\'J\u001c\u0010\u0019\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\t0\b2\u0006\u0010\u000f\u001a\u00020\fH\'J$\u0010\u001a\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\t0\b2\u0006\u0010\u000f\u001a\u00020\f2\u0006\u0010\u0016\u001a\u00020\u0017H\'J\u0016\u0010\u001b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u00a7@\u00a2\u0006\u0002\u0010\u0006J\u001c\u0010\u001c\u001a\u00020\u00032\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00050\tH\u00a7@\u00a2\u0006\u0002\u0010\u001eJ\u0016\u0010\u001f\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u00a7@\u00a2\u0006\u0002\u0010\u0006\u00a8\u0006 "}, d2 = {"Lcom/balancetech/sitemanagement/data/dao/FeeDao;", "", "deleteFee", "", "fee", "Lcom/balancetech/sitemanagement/data/entity/Fee;", "(Lcom/balancetech/sitemanagement/data/entity/Fee;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getAllFees", "Lkotlinx/coroutines/flow/Flow;", "", "getFeeById", "id", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getFeeByUnitMonthYear", "unitId", "month", "", "year", "(Ljava/lang/String;IILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getFeesByApartmentAndStatus", "apartmentId", "status", "Lcom/balancetech/sitemanagement/data/model/PaymentStatus;", "getFeesByMonth", "getFeesByUnit", "getFeesByUnitAndStatus", "insertFee", "insertFees", "fees", "(Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateFee", "app_debug"})
@androidx.room.Dao
public abstract interface FeeDao {
    
    @androidx.room.Query(value = "SELECT * FROM fees WHERE id = :id")
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object getFeeById(@org.jetbrains.annotations.NotNull
    java.lang.String id, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super com.balancetech.sitemanagement.data.entity.Fee> $completion);
    
    @androidx.room.Query(value = "SELECT * FROM fees WHERE unitId = :unitId ORDER BY year DESC, month DESC")
    @org.jetbrains.annotations.NotNull
    public abstract kotlinx.coroutines.flow.Flow<java.util.List<com.balancetech.sitemanagement.data.entity.Fee>> getFeesByUnit(@org.jetbrains.annotations.NotNull
    java.lang.String unitId);
    
    @androidx.room.Query(value = "SELECT * FROM fees WHERE apartmentId = :apartmentId AND month = :month AND year = :year")
    @org.jetbrains.annotations.NotNull
    public abstract kotlinx.coroutines.flow.Flow<java.util.List<com.balancetech.sitemanagement.data.entity.Fee>> getFeesByMonth(@org.jetbrains.annotations.NotNull
    java.lang.String apartmentId, int month, int year);
    
    @androidx.room.Query(value = "SELECT * FROM fees WHERE unitId = :unitId AND status = :status")
    @org.jetbrains.annotations.NotNull
    public abstract kotlinx.coroutines.flow.Flow<java.util.List<com.balancetech.sitemanagement.data.entity.Fee>> getFeesByUnitAndStatus(@org.jetbrains.annotations.NotNull
    java.lang.String unitId, @org.jetbrains.annotations.NotNull
    com.balancetech.sitemanagement.data.model.PaymentStatus status);
    
    @androidx.room.Query(value = "SELECT * FROM fees WHERE unitId = :unitId AND month = :month AND year = :year")
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object getFeeByUnitMonthYear(@org.jetbrains.annotations.NotNull
    java.lang.String unitId, int month, int year, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super com.balancetech.sitemanagement.data.entity.Fee> $completion);
    
    @androidx.room.Query(value = "SELECT * FROM fees WHERE apartmentId = :apartmentId AND status = :status")
    @org.jetbrains.annotations.NotNull
    public abstract kotlinx.coroutines.flow.Flow<java.util.List<com.balancetech.sitemanagement.data.entity.Fee>> getFeesByApartmentAndStatus(@org.jetbrains.annotations.NotNull
    java.lang.String apartmentId, @org.jetbrains.annotations.NotNull
    com.balancetech.sitemanagement.data.model.PaymentStatus status);
    
    @androidx.room.Query(value = "SELECT * FROM fees ORDER BY year DESC, month DESC")
    @org.jetbrains.annotations.NotNull
    public abstract kotlinx.coroutines.flow.Flow<java.util.List<com.balancetech.sitemanagement.data.entity.Fee>> getAllFees();
    
    @androidx.room.Insert(onConflict = 1)
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object insertFee(@org.jetbrains.annotations.NotNull
    com.balancetech.sitemanagement.data.entity.Fee fee, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Insert(onConflict = 1)
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object insertFees(@org.jetbrains.annotations.NotNull
    java.util.List<com.balancetech.sitemanagement.data.entity.Fee> fees, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Update
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object updateFee(@org.jetbrains.annotations.NotNull
    com.balancetech.sitemanagement.data.entity.Fee fee, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Delete
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object deleteFee(@org.jetbrains.annotations.NotNull
    com.balancetech.sitemanagement.data.entity.Fee fee, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
}