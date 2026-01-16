package com.balancetech.sitemanagement.data.model;

/**
 * Represents a summary of fees for a specific month
 */
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\tJ\t\u0010\u001c\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u001d\u001a\u00020\u0003H\u00c6\u0003J\u000f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u00c6\u0003J\t\u0010\u001f\u001a\u00020\u0003H\u00c6\u0003J7\u0010 \u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\b\b\u0002\u0010\b\u001a\u00020\u0003H\u00c6\u0001J\u0013\u0010!\u001a\u00020\"2\b\u0010#\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010$\u001a\u00020\u0003H\u00d6\u0001J\t\u0010%\u001a\u00020\u0010H\u00d6\u0001R\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\b\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0011\u0010\u000f\u001a\u00020\u00108F\u00a2\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0013\u001a\u00020\u00148F\u00a2\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\u0017\u001a\u00020\u00148F\u00a2\u0006\u0006\u001a\u0004\b\u0018\u0010\u0016R\u0011\u0010\u0019\u001a\u00020\u00148F\u00a2\u0006\u0006\u001a\u0004\b\u001a\u0010\u0016R\u0011\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\r\u00a8\u0006&"}, d2 = {"Lcom/balancetech/sitemanagement/data/model/FeeMonthSummary;", "", "month", "", "year", "fees", "", "Lcom/balancetech/sitemanagement/data/entity/Fee;", "filteredCount", "(IILjava/util/List;I)V", "getFees", "()Ljava/util/List;", "getFilteredCount", "()I", "getMonth", "monthName", "", "getMonthName", "()Ljava/lang/String;", "totalAmount", "", "getTotalAmount", "()D", "totalPaidAmount", "getTotalPaidAmount", "totalRemainingAmount", "getTotalRemainingAmount", "getYear", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "toString", "app_debug"})
public final class FeeMonthSummary {
    private final int month = 0;
    private final int year = 0;
    @org.jetbrains.annotations.NotNull
    private final java.util.List<com.balancetech.sitemanagement.data.entity.Fee> fees = null;
    private final int filteredCount = 0;
    
    public FeeMonthSummary(int month, int year, @org.jetbrains.annotations.NotNull
    java.util.List<com.balancetech.sitemanagement.data.entity.Fee> fees, int filteredCount) {
        super();
    }
    
    public final int getMonth() {
        return 0;
    }
    
    public final int getYear() {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.util.List<com.balancetech.sitemanagement.data.entity.Fee> getFees() {
        return null;
    }
    
    public final int getFilteredCount() {
        return 0;
    }
    
    public final double getTotalAmount() {
        return 0.0;
    }
    
    public final double getTotalPaidAmount() {
        return 0.0;
    }
    
    public final double getTotalRemainingAmount() {
        return 0.0;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getMonthName() {
        return null;
    }
    
    public final int component1() {
        return 0;
    }
    
    public final int component2() {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.util.List<com.balancetech.sitemanagement.data.entity.Fee> component3() {
        return null;
    }
    
    public final int component4() {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.balancetech.sitemanagement.data.model.FeeMonthSummary copy(int month, int year, @org.jetbrains.annotations.NotNull
    java.util.List<com.balancetech.sitemanagement.data.entity.Fee> fees, int filteredCount) {
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