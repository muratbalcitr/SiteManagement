package com.balancetech.sitemanagement.util;

/**
 * Utility class for importing data from Excel (CSV format)
 */
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001:\u0001\"B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J>\u0010\u0003\u001a\u001a\u0012\u0016\u0012\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\u0004\u0012\u00020\b0\u00050\u00042\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0086@\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\u0004\b\r\u0010\u000eJF\u0010\u000f\u001a\u001a\u0012\u0016\u0012\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00100\u0006\u0012\u0004\u0012\u00020\b0\u00050\u00042\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0011\u001a\u00020\u0012H\u0086@\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\u0004\b\u0013\u0010\u0014J\\\u0010\u0015\u001a\u001a\u0012\u0016\u0012\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00160\u0006\u0012\u0004\u0012\u00020\b0\u00050\u00042\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0011\u001a\u00020\u00122\u0014\u0010\u0017\u001a\u0010\u0012\u0004\u0012\u00020\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u00120\u0018H\u0086@\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\u0004\b\u0019\u0010\u001aJ\u001a\u0010\u001b\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u001c\u001a\u00020\u00122\u0006\u0010\u001d\u001a\u00020\u001eH\u0002J\u0016\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00120\u00062\u0006\u0010\u001c\u001a\u00020\u0012H\u0002J\"\u0010 \u001a\u0004\u0018\u00010\u00102\u0006\u0010\u001c\u001a\u00020\u00122\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u001d\u001a\u00020\u001eH\u0002J8\u0010!\u001a\u0004\u0018\u00010\u00162\u0006\u0010\u001c\u001a\u00020\u00122\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u001d\u001a\u00020\u001e2\u0014\u0010\u0017\u001a\u0010\u0012\u0004\u0012\u00020\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u00120\u0018H\u0002\u0082\u0002\u000b\n\u0002\b!\n\u0005\b\u00a1\u001e0\u0001\u00a8\u0006#"}, d2 = {"Lcom/balancetech/sitemanagement/util/ExcelImportUtil;", "", "()V", "importBankTransactionsFromCsv", "Lkotlin/Result;", "Lkotlin/Pair;", "", "Lcom/balancetech/sitemanagement/data/entity/BankTransaction;", "Lcom/balancetech/sitemanagement/util/ExcelImportUtil$ImportResult;", "context", "Landroid/content/Context;", "uri", "Landroid/net/Uri;", "importBankTransactionsFromCsv-0E7RQCE", "(Landroid/content/Context;Landroid/net/Uri;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "importUnitsFromCsv", "Lcom/balancetech/sitemanagement/data/entity/Unit;", "apartmentId", "", "importUnitsFromCsv-BWLJW6A", "(Landroid/content/Context;Landroid/net/Uri;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "importWaterMetersFromCsv", "Lcom/balancetech/sitemanagement/data/entity/WaterMeter;", "getUnitIdByNumber", "Lkotlin/Function1;", "importWaterMetersFromCsv-yxL6bBk", "(Landroid/content/Context;Landroid/net/Uri;Ljava/lang/String;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "parseBankTransactionLine", "line", "lineNumber", "", "parseCsvLine", "parseUnitLine", "parseWaterMeterLine", "ImportResult", "app_debug"})
public final class ExcelImportUtil {
    @org.jetbrains.annotations.NotNull
    public static final com.balancetech.sitemanagement.util.ExcelImportUtil INSTANCE = null;
    
    private ExcelImportUtil() {
        super();
    }
    
    private final com.balancetech.sitemanagement.data.entity.Unit parseUnitLine(java.lang.String line, java.lang.String apartmentId, int lineNumber) {
        return null;
    }
    
    private final java.util.List<java.lang.String> parseCsvLine(java.lang.String line) {
        return null;
    }
    
    private final com.balancetech.sitemanagement.data.entity.WaterMeter parseWaterMeterLine(java.lang.String line, java.lang.String apartmentId, int lineNumber, kotlin.jvm.functions.Function1<? super java.lang.String, java.lang.String> getUnitIdByNumber) {
        return null;
    }
    
    private final com.balancetech.sitemanagement.data.entity.BankTransaction parseBankTransactionLine(java.lang.String line, int lineNumber) {
        return null;
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006\u00a2\u0006\u0002\u0010\bJ\t\u0010\u000e\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u000f\u001a\u00020\u0003H\u00c6\u0003J\u000f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u00c6\u0003J-\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u00c6\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u0015\u001a\u00020\u0003H\u00d6\u0001J\t\u0010\u0016\u001a\u00020\u0007H\u00d6\u0001R\u0011\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\n\u00a8\u0006\u0017"}, d2 = {"Lcom/balancetech/sitemanagement/util/ExcelImportUtil$ImportResult;", "", "successCount", "", "errorCount", "errors", "", "", "(IILjava/util/List;)V", "getErrorCount", "()I", "getErrors", "()Ljava/util/List;", "getSuccessCount", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "app_debug"})
    public static final class ImportResult {
        private final int successCount = 0;
        private final int errorCount = 0;
        @org.jetbrains.annotations.NotNull
        private final java.util.List<java.lang.String> errors = null;
        
        public ImportResult(int successCount, int errorCount, @org.jetbrains.annotations.NotNull
        java.util.List<java.lang.String> errors) {
            super();
        }
        
        public final int getSuccessCount() {
            return 0;
        }
        
        public final int getErrorCount() {
            return 0;
        }
        
        @org.jetbrains.annotations.NotNull
        public final java.util.List<java.lang.String> getErrors() {
            return null;
        }
        
        public final int component1() {
            return 0;
        }
        
        public final int component2() {
            return 0;
        }
        
        @org.jetbrains.annotations.NotNull
        public final java.util.List<java.lang.String> component3() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull
        public final com.balancetech.sitemanagement.util.ExcelImportUtil.ImportResult copy(int successCount, int errorCount, @org.jetbrains.annotations.NotNull
        java.util.List<java.lang.String> errors) {
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
}