package com.balancetech.sitemanagement.data.entity

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Index
import androidx.room.PrimaryKey

/**
 * Junction table for many-to-many relationship between User and Unit
 * Allows a user to have multiple units
 */
@Entity(
    tableName = "user_units",
    foreignKeys = [
        ForeignKey(
            entity = User::class,
            parentColumns = ["id"],
            childColumns = ["userId"],
            onDelete = ForeignKey.CASCADE
        ),
        ForeignKey(
            entity = Unit::class,
            parentColumns = ["id"],
            childColumns = ["unitId"],
            onDelete = ForeignKey.CASCADE
        )
    ],
    indices = [
        Index(value = ["userId"]),
        Index(value = ["unitId"]),
        Index(value = ["userId", "unitId"], unique = true)
    ]
)
data class UserUnit(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
    val userId: String,
    val unitId: String,
    val createdAt: Long = System.currentTimeMillis()
)

