package com.balancetech.sitemanagement.util

object StringUtils {
    /**
     * Converts a Turkish name to a URL-friendly slug
     * Example: "Ahmet Yılmaz" -> "ahmet-yilmaz"
     */
    fun nameToSlug(name: String): String {
        return name
            .lowercase()
            .trim()
            // Replace Turkish characters with English equivalents
            .replace("ı", "i")
            .replace("ğ", "g")
            .replace("ü", "u")
            .replace("ş", "s")
            .replace("ö", "o")
            .replace("ç", "c")
            // Replace spaces and special characters with hyphens
            .replace(Regex("[^a-z0-9]+"), "-")
            // Remove leading/trailing hyphens
            .trim('-')
            // Limit length to 50 characters
            .take(50)
    }
    
    /**
     * Generates a unique user ID from name
     * If slug already exists, appends a number
     */
    fun generateUserIdFromName(name: String, existingIds: Set<String> = emptySet()): String {
        var baseSlug = nameToSlug(name)
        var userId = baseSlug
        var counter = 1
        
        // If slug exists, append a number
        while (existingIds.contains(userId)) {
            userId = "$baseSlug-$counter"
            counter++
        }
        
        return userId
    }
}



