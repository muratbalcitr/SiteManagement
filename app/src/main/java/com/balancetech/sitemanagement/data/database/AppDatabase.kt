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
        Fee::class,
        ExtraPayment::class,
        WaterMeter::class,
        WaterBill::class,
        Payment::class,
        Notification::class
    ],
    version = 1,
    exportSchema = false
)
abstract class AppDatabase : RoomDatabase() {
    abstract fun userDao(): UserDao
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
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }
}
