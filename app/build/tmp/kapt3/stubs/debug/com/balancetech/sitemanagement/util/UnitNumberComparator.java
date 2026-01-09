package com.balancetech.sitemanagement.util;

/**
 * Utility class for comparing unit numbers in natural order
 * Handles formats like: A1, A2, A10, B1, B2, etc.
 */
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0016\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006J\u001c\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00040\t2\u0006\u0010\n\u001a\u00020\u0006H\u0002J*\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\f2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\f2\u0006\u0010\u000f\u001a\u00020\u0010H\u0086@\u00a2\u0006\u0002\u0010\u0011J*\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00130\f2\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00130\f2\u0006\u0010\u000f\u001a\u00020\u0010H\u0086@\u00a2\u0006\u0002\u0010\u0011\u00a8\u0006\u0015"}, d2 = {"Lcom/balancetech/sitemanagement/util/UnitNumberComparator;", "", "()V", "compareUnitNumbers", "", "unitNumber1", "", "unitNumber2", "parseUnitNumber", "Lkotlin/Pair;", "unitNumber", "sortWaterBillsByUnitNumber", "", "Lcom/balancetech/sitemanagement/data/entity/WaterBill;", "waterBills", "localDataSource", "Lcom/balancetech/sitemanagement/data/datasource/LocalDataSource;", "(Ljava/util/List;Lcom/balancetech/sitemanagement/data/datasource/LocalDataSource;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "sortWaterMetersByUnitNumber", "Lcom/balancetech/sitemanagement/data/entity/WaterMeter;", "waterMeters", "app_debug"})
public final class UnitNumberComparator {
    @org.jetbrains.annotations.NotNull
    public static final com.balancetech.sitemanagement.util.UnitNumberComparator INSTANCE = null;
    
    private UnitNumberComparator() {
        super();
    }
    
    /**
     * Compare two unit numbers in natural order
     * Examples:
     * - A1 < A2 < A10 (not A1 < A10 < A2)
     * - A1 < B1 < C1
     *
     * @param unitNumber1 First unit number (e.g., "A1")
     * @param unitNumber2 Second unit number (e.g., "A10")
     * @return Negative if unitNumber1 < unitNumber2, positive if unitNumber1 > unitNumber2, 0 if equal
     */
    public final int compareUnitNumbers(@org.jetbrains.annotations.NotNull
    java.lang.String unitNumber1, @org.jetbrains.annotations.NotNull
    java.lang.String unitNumber2) {
        return 0;
    }
    
    /**
     * Parse unit number into letter and number parts
     * Examples:
     * - "A1" -> ("A", 1)
     * - "A10" -> ("A", 10)
     * - "B23" -> ("B", 23)
     * - "123" -> ("", 123) // If no letter, empty string
     */
    private final kotlin.Pair<java.lang.String, java.lang.Integer> parseUnitNumber(java.lang.String unitNumber) {
        return null;
    }
    
    /**
     * Sort water meters by unit number
     */
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object sortWaterMetersByUnitNumber(@org.jetbrains.annotations.NotNull
    java.util.List<com.balancetech.sitemanagement.data.entity.WaterMeter> waterMeters, @org.jetbrains.annotations.NotNull
    com.balancetech.sitemanagement.data.datasource.LocalDataSource localDataSource, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super java.util.List<com.balancetech.sitemanagement.data.entity.WaterMeter>> $completion) {
        return null;
    }
    
    /**
     * Sort water bills by unit number, then by year and month
     */
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object sortWaterBillsByUnitNumber(@org.jetbrains.annotations.NotNull
    java.util.List<com.balancetech.sitemanagement.data.entity.WaterBill> waterBills, @org.jetbrains.annotations.NotNull
    com.balancetech.sitemanagement.data.datasource.LocalDataSource localDataSource, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super java.util.List<com.balancetech.sitemanagement.data.entity.WaterBill>> $completion) {
        return null;
    }
}