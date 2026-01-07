package com.balancetech.sitemanagement.util;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u001e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00042\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00040\u0007J\u000e\u0010\b\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004\u00a8\u0006\t"}, d2 = {"Lcom/balancetech/sitemanagement/util/StringUtils;", "", "()V", "generateUserIdFromName", "", "name", "existingIds", "", "nameToSlug", "app_debug"})
public final class StringUtils {
    @org.jetbrains.annotations.NotNull
    public static final com.balancetech.sitemanagement.util.StringUtils INSTANCE = null;
    
    private StringUtils() {
        super();
    }
    
    /**
     * Converts a Turkish name to a URL-friendly slug
     * Example: "Ahmet Yılmaz" -> "ahmet-yilmaz"
     */
    @org.jetbrains.annotations.NotNull
    public final java.lang.String nameToSlug(@org.jetbrains.annotations.NotNull
    java.lang.String name) {
        return null;
    }
    
    /**
     * Generates a unique user ID from name
     * If slug already exists, appends a number
     */
    @org.jetbrains.annotations.NotNull
    public final java.lang.String generateUserIdFromName(@org.jetbrains.annotations.NotNull
    java.lang.String name, @org.jetbrains.annotations.NotNull
    java.util.Set<java.lang.String> existingIds) {
        return null;
    }
}