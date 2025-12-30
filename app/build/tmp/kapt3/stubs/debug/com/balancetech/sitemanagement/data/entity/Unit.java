package com.balancetech.sitemanagement.data.entity;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b$\b\u0087\b\u0018\u00002\u00020\u0001Bo\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\u0006\u0010\f\u001a\u00020\r\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0011\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0013\u00a2\u0006\u0002\u0010\u0014J\t\u0010&\u001a\u00020\u0003H\u00c6\u0003J\u000b\u0010\'\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\t\u0010(\u001a\u00020\u0011H\u00c6\u0003J\t\u0010)\u001a\u00020\u0013H\u00c6\u0003J\t\u0010*\u001a\u00020\u0003H\u00c6\u0003J\u000b\u0010+\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\t\u0010,\u001a\u00020\u0003H\u00c6\u0003J\t\u0010-\u001a\u00020\bH\u00c6\u0003J\t\u0010.\u001a\u00020\nH\u00c6\u0003J\t\u0010/\u001a\u00020\nH\u00c6\u0003J\t\u00100\u001a\u00020\rH\u00c6\u0003J\u000b\u00101\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\u0087\u0001\u00102\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\n2\b\b\u0002\u0010\f\u001a\u00020\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u0013H\u00c6\u0001J\u0013\u00103\u001a\u00020\u00132\b\u00104\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u00105\u001a\u00020\bH\u00d6\u0001J\t\u00106\u001a\u00020\u0003H\u00d6\u0001R\u0011\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\t\u001a\u00020\n\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0016R\u0011\u0010\u0010\u001a\u00020\u0011\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0011\u0010\u0007\u001a\u00020\b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0016R\u0011\u0010\u0012\u001a\u00020\u0013\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u001fR\u0011\u0010\u000b\u001a\u00020\n\u00a2\u0006\b\n\u0000\u001a\u0004\b \u0010\u0018R\u0013\u0010\u000e\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b!\u0010\u0016R\u0013\u0010\u000f\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u0016R\u0011\u0010\f\u001a\u00020\r\u00a2\u0006\b\n\u0000\u001a\u0004\b#\u0010$R\u0011\u0010\u0006\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b%\u0010\u0016\u00a8\u00067"}, d2 = {"Lcom/balancetech/sitemanagement/data/entity/Unit;", "", "id", "", "apartmentId", "blockId", "unitNumber", "floor", "", "area", "", "landShare", "ownerType", "Lcom/balancetech/sitemanagement/data/model/OwnerType;", "ownerName", "ownerPhone", "createdAt", "", "isActive", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IDDLcom/balancetech/sitemanagement/data/model/OwnerType;Ljava/lang/String;Ljava/lang/String;JZ)V", "getApartmentId", "()Ljava/lang/String;", "getArea", "()D", "getBlockId", "getCreatedAt", "()J", "getFloor", "()I", "getId", "()Z", "getLandShare", "getOwnerName", "getOwnerPhone", "getOwnerType", "()Lcom/balancetech/sitemanagement/data/model/OwnerType;", "getUnitNumber", "component1", "component10", "component11", "component12", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "other", "hashCode", "toString", "app_debug"})
@androidx.room.Entity(tableName = "units")
public final class Unit {
    @androidx.room.PrimaryKey
    @org.jetbrains.annotations.NotNull
    private final java.lang.String id = null;
    @org.jetbrains.annotations.NotNull
    private final java.lang.String apartmentId = null;
    @org.jetbrains.annotations.Nullable
    private final java.lang.String blockId = null;
    @org.jetbrains.annotations.NotNull
    private final java.lang.String unitNumber = null;
    private final int floor = 0;
    private final double area = 0.0;
    private final double landShare = 0.0;
    @org.jetbrains.annotations.NotNull
    private final com.balancetech.sitemanagement.data.model.OwnerType ownerType = null;
    @org.jetbrains.annotations.Nullable
    private final java.lang.String ownerName = null;
    @org.jetbrains.annotations.Nullable
    private final java.lang.String ownerPhone = null;
    private final long createdAt = 0L;
    private final boolean isActive = false;
    
    public Unit(@org.jetbrains.annotations.NotNull
    java.lang.String id, @org.jetbrains.annotations.NotNull
    java.lang.String apartmentId, @org.jetbrains.annotations.Nullable
    java.lang.String blockId, @org.jetbrains.annotations.NotNull
    java.lang.String unitNumber, int floor, double area, double landShare, @org.jetbrains.annotations.NotNull
    com.balancetech.sitemanagement.data.model.OwnerType ownerType, @org.jetbrains.annotations.Nullable
    java.lang.String ownerName, @org.jetbrains.annotations.Nullable
    java.lang.String ownerPhone, long createdAt, boolean isActive) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getId() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getApartmentId() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.String getBlockId() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getUnitNumber() {
        return null;
    }
    
    public final int getFloor() {
        return 0;
    }
    
    public final double getArea() {
        return 0.0;
    }
    
    public final double getLandShare() {
        return 0.0;
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.balancetech.sitemanagement.data.model.OwnerType getOwnerType() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.String getOwnerName() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.String getOwnerPhone() {
        return null;
    }
    
    public final long getCreatedAt() {
        return 0L;
    }
    
    public final boolean isActive() {
        return false;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String component1() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.String component10() {
        return null;
    }
    
    public final long component11() {
        return 0L;
    }
    
    public final boolean component12() {
        return false;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String component2() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.String component3() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String component4() {
        return null;
    }
    
    public final int component5() {
        return 0;
    }
    
    public final double component6() {
        return 0.0;
    }
    
    public final double component7() {
        return 0.0;
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.balancetech.sitemanagement.data.model.OwnerType component8() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.String component9() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.balancetech.sitemanagement.data.entity.Unit copy(@org.jetbrains.annotations.NotNull
    java.lang.String id, @org.jetbrains.annotations.NotNull
    java.lang.String apartmentId, @org.jetbrains.annotations.Nullable
    java.lang.String blockId, @org.jetbrains.annotations.NotNull
    java.lang.String unitNumber, int floor, double area, double landShare, @org.jetbrains.annotations.NotNull
    com.balancetech.sitemanagement.data.model.OwnerType ownerType, @org.jetbrains.annotations.Nullable
    java.lang.String ownerName, @org.jetbrains.annotations.Nullable
    java.lang.String ownerPhone, long createdAt, boolean isActive) {
        return null;
    }
    
    @java.lang.Override
    public boolean equals(@org.jetbrains.annotations.Nullable
    java.lang.Object other) {
        return false;
    }
    
    @java.lang.Override
    public int hashCode() {
        return 0;
    }
    
    @java.lang.Override
    @org.jetbrains.annotations.NotNull
    public java.lang.String toString() {
        return null;
    }
}