package com.balancetech.sitemanagement.data.model

import java.io.Serializable

enum class UserRole : Serializable {
    ADMIN,      // Yönetici
    RESIDENT,   // Daire Sakini
    AUDITOR     // Denetçi
}
