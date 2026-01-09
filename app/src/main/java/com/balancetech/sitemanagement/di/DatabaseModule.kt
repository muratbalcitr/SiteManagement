package com.balancetech.sitemanagement.di

import android.content.Context
import androidx.room.Room
import com.balancetech.sitemanagement.data.dao.*
import com.balancetech.sitemanagement.data.dao.UserUnitDao
import com.balancetech.sitemanagement.data.database.AppDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {
    @Provides
    @Singleton
    fun provideAppDatabase(@ApplicationContext context: Context): AppDatabase {
        return Room.databaseBuilder(
            context,
            AppDatabase::class.java,
            "site_management_database"
        )
        .addMigrations(AppDatabase.MIGRATION_1_2, AppDatabase.MIGRATION_2_3)
        .build()
    }

    @Provides
    fun provideUserDao(database: AppDatabase): UserDao = database.userDao()

    @Provides
    fun provideUserUnitDao(database: AppDatabase): UserUnitDao = database.userUnitDao()

    @Provides
    fun provideApartmentDao(database: AppDatabase): ApartmentDao = database.apartmentDao()

    @Provides
    fun provideBlockDao(database: AppDatabase): com.balancetech.sitemanagement.data.dao.BlockDao = database.blockDao()

    @Provides
    fun provideUnitDao(database: AppDatabase): UnitDao = database.unitDao()

    @Provides
    fun provideFeeDao(database: AppDatabase): FeeDao = database.feeDao()

    @Provides
    fun providePaymentDao(database: AppDatabase): PaymentDao = database.paymentDao()

    @Provides
    fun provideWaterMeterDao(database: AppDatabase): WaterMeterDao = database.waterMeterDao()

    @Provides
    fun provideWaterBillDao(database: AppDatabase): WaterBillDao = database.waterBillDao()

    @Provides
    fun provideExtraPaymentDao(database: AppDatabase): ExtraPaymentDao = database.extraPaymentDao()

    @Provides
    fun provideNotificationDao(database: AppDatabase): NotificationDao = database.notificationDao()
}
