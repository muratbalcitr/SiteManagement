package com.balancetech.sitemanagement.di

import com.balancetech.sitemanagement.data.datasource.LocalDataSource
import com.balancetech.sitemanagement.data.datasource.LocalDataSourceImpl
import com.balancetech.sitemanagement.data.datasource.RemoteDataSource
import com.balancetech.sitemanagement.data.datasource.RemoteDataSourceImpl
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DataSourceModule {
    
    @Provides
    @Singleton
    fun provideLocalDataSource(
        localDataSourceImpl: LocalDataSourceImpl
    ): LocalDataSource {
        return localDataSourceImpl
    }

    @Provides
    @Singleton
    fun provideRemoteDataSource(
        remoteDataSourceImpl: RemoteDataSourceImpl
    ): RemoteDataSource {
        return remoteDataSourceImpl
    }
}



