package com.balancetech.sitemanagement.di

import com.balancetech.sitemanagement.data.dao.*
import com.balancetech.sitemanagement.data.dao.UserUnitDao
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
        functionsService: com.balancetech.sitemanagement.data.service.FirebaseFunctionsService,
        remoteDataSource: RemoteDataSource,
        localDataSource: LocalDataSource
    ): WaterMeterRepository {
        return WaterMeterRepository(waterMeterDao, waterBillDao, functionsService, remoteDataSource, localDataSource)
    }

    @Provides
    @Singleton
    fun providePaymentRepository(
        paymentDao: PaymentDao,
        functionsService: com.balancetech.sitemanagement.data.service.FirebaseFunctionsService,
        localDataSource: LocalDataSource
    ): PaymentRepository {
        return PaymentRepository(paymentDao, functionsService, localDataSource)
    }

    @Provides
    @Singleton
    fun provideExtraPaymentRepository(
        extraPaymentDao: ExtraPaymentDao,
        remoteDataSource: RemoteDataSource
    ): ExtraPaymentRepository {
        return ExtraPaymentRepository(extraPaymentDao, remoteDataSource)
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
        remoteDataSource: RemoteDataSource,
        userUnitDao: UserUnitDao,
        functionsService: com.balancetech.sitemanagement.data.service.FirebaseFunctionsService,
        firestore: com.google.firebase.firestore.FirebaseFirestore
    ): SyncRepository {
        return SyncRepository(localDataSource, remoteDataSource, userUnitDao, functionsService, firestore)
    }

    @Provides
    @Singleton
    fun provideUserRepository(
        localDataSource: LocalDataSource,
        remoteDataSource: RemoteDataSource,
        userUnitDao: UserUnitDao
    ): UserRepository {
        return UserRepository(localDataSource, remoteDataSource, userUnitDao)
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
