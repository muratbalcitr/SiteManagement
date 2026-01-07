package com.balancetech.sitemanagement.util;

/**
 * Utility class for exporting data to Excel (CSV format)
 * CSV files can be opened in Excel
 */
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0018\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0004H\u0002J\u0010\u0010\n\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u0004H\u0002JH\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r2\u0006\u0010\u0007\u001a\u00020\b2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u00102\u0014\b\u0002\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00140\u0013H\u0086@\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\u0004\b\u0015\u0010\u0016J2\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u000e0\r2\u0006\u0010\u0007\u001a\u00020\b2\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00140\u0010H\u0086@\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\u0004\b\u0018\u0010\u0019JH\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u000e0\r2\u0006\u0010\u0007\u001a\u00020\b2\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001c0\u00102\u0014\b\u0002\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00140\u0013H\u0086@\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\u0004\b\u001d\u0010\u0016J\u0010\u0010\u001e\u001a\u00020\u00042\u0006\u0010\u001f\u001a\u00020 H\u0002J\b\u0010!\u001a\u00020\u0004H\u0002J\u0018\u0010\"\u001a\u00020\u000e2\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010#\u001a\u00020\u0006H\u0002J\u0010\u0010$\u001a\u00020\u00042\u0006\u0010%\u001a\u00020&H\u0002J\u0014\u0010\'\u001a\u00020(*\u00020)2\u0006\u0010*\u001a\u00020\u0004H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000\u0082\u0002\u000b\n\u0002\b!\n\u0005\b\u00a1\u001e0\u0001\u00a8\u0006+"}, d2 = {"Lcom/balancetech/sitemanagement/util/ExcelExportUtil;", "", "()V", "FILE_PROVIDER_AUTHORITY", "", "createFile", "Ljava/io/File;", "context", "Landroid/content/Context;", "fileName", "escapeCsv", "value", "exportFeesToExcel", "Lkotlin/Result;", "Landroid/net/Uri;", "fees", "", "Lcom/balancetech/sitemanagement/data/entity/Fee;", "units", "", "Lcom/balancetech/sitemanagement/data/entity/Unit;", "exportFeesToExcel-BWLJW6A", "(Landroid/content/Context;Ljava/util/List;Ljava/util/Map;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "exportUnitsToExcel", "exportUnitsToExcel-0E7RQCE", "(Landroid/content/Context;Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "exportUsersToExcel", "users", "Lcom/balancetech/sitemanagement/data/entity/User;", "exportUsersToExcel-BWLJW6A", "formatDate", "timestamp", "", "getCurrentTimestamp", "getFileUri", "file", "getMonthName", "month", "", "appendLine", "", "Ljava/io/FileWriter;", "line", "app_debug"})
public final class ExcelExportUtil {
    @org.jetbrains.annotations.NotNull
    private static final java.lang.String FILE_PROVIDER_AUTHORITY = "com.balancetech.sitemanagement.fileprovider";
    @org.jetbrains.annotations.NotNull
    public static final com.balancetech.sitemanagement.util.ExcelExportUtil INSTANCE = null;
    
    private ExcelExportUtil() {
        super();
    }
    
    private final java.io.File createFile(android.content.Context context, java.lang.String fileName) {
        return null;
    }
    
    private final android.net.Uri getFileUri(android.content.Context context, java.io.File file) {
        return null;
    }
    
    private final java.lang.String escapeCsv(java.lang.String value) {
        return null;
    }
    
    private final java.lang.String formatDate(long timestamp) {
        return null;
    }
    
    private final java.lang.String getMonthName(int month) {
        return null;
    }
    
    private final java.lang.String getCurrentTimestamp() {
        return null;
    }
    
    private final void appendLine(java.io.FileWriter $this$appendLine, java.lang.String line) {
    }
}