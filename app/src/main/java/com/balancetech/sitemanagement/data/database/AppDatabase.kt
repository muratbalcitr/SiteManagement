package com.balancetech.sitemanagement.data.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.balancetech.sitemanagement.data.dao.*
import com.balancetech.sitemanagement.data.entity.*
import com.balancetech.sitemanagement.data.entity.Unit as UnitEntity

@Database(
    entities = [
        User::class,
        Apartment::class,
        Block::class,
        UnitEntity::class,
        UserUnit::class,
        Fee::class,
        ExtraPayment::class,
        WaterMeter::class,
        WaterBill::class,
        Payment::class,
        Notification::class
    ],
    version = 3,
    exportSchema = false
)
abstract class AppDatabase : RoomDatabase() {
    abstract fun userDao(): UserDao
    abstract fun userUnitDao(): UserUnitDao
    abstract fun apartmentDao(): ApartmentDao
    abstract fun blockDao(): com.balancetech.sitemanagement.data.dao.BlockDao
    abstract fun unitDao(): UnitDao
    abstract fun feeDao(): FeeDao
    abstract fun paymentDao(): PaymentDao
    abstract fun waterMeterDao(): WaterMeterDao
    abstract fun waterBillDao(): WaterBillDao
    abstract fun extraPaymentDao(): ExtraPaymentDao
    abstract fun notificationDao(): NotificationDao

    companion object {
        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getDatabase(context: Context): AppDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "site_management_database"
                )
                .addMigrations(MIGRATION_1_2, MIGRATION_2_3)
                .build()
                INSTANCE = instance
                instance
            }
        }
        
        val MIGRATION_1_2 = object : androidx.room.migration.Migration(1, 2) {
            override fun migrate(db: androidx.sqlite.db.SupportSQLiteDatabase) {
                // Create user_units table
                db.execSQL("""
                    CREATE TABLE IF NOT EXISTS user_units (
                        id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,
                        userId TEXT NOT NULL,
                        unitId TEXT NOT NULL,
                        createdAt INTEGER NOT NULL,
                        FOREIGN KEY(userId) REFERENCES users(id) ON DELETE CASCADE,
                        FOREIGN KEY(unitId) REFERENCES units(id) ON DELETE CASCADE
                    )
                """.trimIndent())
                
                // Create indices
                db.execSQL("CREATE INDEX IF NOT EXISTS index_user_units_userId ON user_units(userId)")
                db.execSQL("CREATE INDEX IF NOT EXISTS index_user_units_unitId ON user_units(unitId)")
                db.execSQL("CREATE UNIQUE INDEX IF NOT EXISTS index_user_units_userId_unitId ON user_units(userId, unitId)")
                
                // Migrate existing data: copy unitId from users table to user_units table
                db.execSQL("""
                    INSERT INTO user_units (userId, unitId, createdAt)
                    SELECT id, unitId, createdAt
                    FROM users
                    WHERE unitId IS NOT NULL
                """.trimIndent())
            }
        }
        
        val MIGRATION_2_3 = object : androidx.room.migration.Migration(2, 3) {
            override fun migrate(db: androidx.sqlite.db.SupportSQLiteDatabase) {
                // Add new columns to water_bills table for MESKİ calculation
                db.execSQL("ALTER TABLE water_bills ADD COLUMN wastewaterAmount REAL NOT NULL DEFAULT 0.0")
                db.execSQL("ALTER TABLE water_bills ADD COLUMN environmentalTax REAL NOT NULL DEFAULT 0.0")
                db.execSQL("ALTER TABLE water_bills ADD COLUMN vat REAL NOT NULL DEFAULT 0.0")
            }
        }
    }
}
