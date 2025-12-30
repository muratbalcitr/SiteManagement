package com.balancetech.sitemanagement.di

import com.balancetech.sitemanagement.data.dao.*
import com.balancetech.sitemanagement.data.datasource.LocalDataSource
import com.balancetech.sitemanagement.data.datasource.RemoteDataSource
import com.balancetech.sitemanagement.data.repository.*
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    @Singleton
    fun provideFeeRepository(
        feeDao: FeeDao, 
        unitDao: UnitDao,
        localDataSource: LocalDataSource,
        remoteDataSource: RemoteDataSource,
        functionsService: com.balancetech.sitemanagement.data.service.FirebaseFunctionsService,
        userDao: UserDao
    ): FeeRepository {
        return FeeRepository(feeDao, unitDao, localDataSource, remoteDataSource, functionsService, userDao)
    }

    @Provides
    @Singleton
    fun provideWaterMeterRepository(
        waterMeterDao: WaterMeterDao,
        waterBillDao: WaterBillDao,
        functionsService: com.balancetech.sitemanagement.data.service.FirebaseFunctionsService
    ): WaterMeterRepository {
        return WaterMeterRepository(waterMeterDao, waterBillDao, functionsService)
    }

    @Provides
    @Singleton
    fun providePaymentRepository(
        paymentDao: PaymentDao,
        functionsService: com.balancetech.sitemanagement.data.service.FirebaseFunctionsService
    ): PaymentRepository {
        return PaymentRepository(paymentDao, functionsService)
    }

    @Provides
    @Singleton
    fun provideExtraPaymentRepository(extraPaymentDao: ExtraPaymentDao): ExtraPaymentRepository {
        return ExtraPaymentRepository(extraPaymentDao)
    }

    @Provides
    @Singleton
    fun provideNotificationRepository(notificationDao: NotificationDao): NotificationRepository {
        return NotificationRepository(notificationDao)
    }

    @Provides
    @Singleton
    fun provideSyncRepository(
        localDataSource: LocalDataSource,
        remoteDataSource: RemoteDataSource
    ): SyncRepository {
        return SyncRepository(localDataSource, remoteDataSource)
    }

    @Provides
    @Singleton
    fun provideUserRepository(
        localDataSource: LocalDataSource,
        remoteDataSource: RemoteDataSource
    ): UserRepository {
        return UserRepository(localDataSource, remoteDataSource)
    }

    @Provides
    @Singleton
    fun provideAuthRepository(
        userDao: UserDao,
        firebaseAuth: com.google.firebase.auth.FirebaseAuth,
        localDataSource: LocalDataSource,
        remoteDataSource: RemoteDataSource
    ): AuthRepository {
        return AuthRepository(userDao, firebaseAuth, localDataSource, remoteDataSource)
    }

}
