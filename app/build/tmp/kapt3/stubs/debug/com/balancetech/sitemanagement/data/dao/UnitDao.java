package com.balancetech.sitemanagement.data.dao;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\u0006\bg\u0018\u00002\u00020\u0001J\u0016\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u00a7@\u00a2\u0006\u0002\u0010\u0006J\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00052\u0006\u0010\b\u001a\u00020\tH\u00a7@\u00a2\u0006\u0002\u0010\nJ\u001c\u0010\u000b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\r0\f2\u0006\u0010\u000e\u001a\u00020\tH\'J\u001c\u0010\u000f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\r0\f2\u0006\u0010\u0010\u001a\u00020\tH\'J\u0016\u0010\u0011\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u00a7@\u00a2\u0006\u0002\u0010\u0006J\u0016\u0010\u0012\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u00a7@\u00a2\u0006\u0002\u0010\u0006\u00a8\u0006\u0013"}, d2 = {"Lcom/balancetech/sitemanagement/data/dao/UnitDao;", "", "deleteUnit", "", "unit", "Lcom/balancetech/sitemanagement/data/entity/Unit;", "(Lcom/balancetech/sitemanagement/data/entity/Unit;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getUnitById", "id", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getUnitsByApartment", "Lkotlinx/coroutines/flow/Flow;", "", "apartmentId", "getUnitsByBlock", "blockId", "insertUnit", "updateUnit", "app_debug"})
@androidx.room.Dao
public abstract interface UnitDao {
    
    @androidx.room.Query(value = "SELECT * FROM units WHERE id = :id")
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object getUnitById(@org.jetbrains.annotations.NotNull
    java.lang.String id, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super com.balancetech.sitemanagement.data.entity.Unit> $completion);
    
    @androidx.room.Query(value = "SELECT * FROM units WHERE apartmentId = :apartmentId AND isActive = 1")
    @org.jetbrains.annotations.NotNull
    public abstract kotlinx.coroutines.flow.Flow<java.util.List<com.balancetech.sitemanagement.data.entity.Unit>> getUnitsByApartment(@org.jetbrains.annotations.NotNull
    java.lang.String apartmentId);
    
    @androidx.room.Query(value = "SELECT * FROM units WHERE blockId = :blockId AND isActive = 1")
    @org.jetbrains.annotations.NotNull
    public abstract kotlinx.coroutines.flow.Flow<java.util.List<com.balancetech.sitemanagement.data.entity.Unit>> getUnitsByBlock(@org.jetbrains.annotations.NotNull
    java.lang.String blockId);
    
    @androidx.room.Insert(onConflict = 1)
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object insertUnit(@org.jetbrains.annotations.NotNull
    com.balancetech.sitemanagement.data.entity.Unit unit, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Update
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object updateUnit(@org.jetbrains.annotations.NotNull
    com.balancetech.sitemanagement.data.entity.Unit unit, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Delete
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object deleteUnit(@org.jetbrains.annotations.NotNull
    com.balancetech.sitemanagement.data.entity.Unit unit, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
}