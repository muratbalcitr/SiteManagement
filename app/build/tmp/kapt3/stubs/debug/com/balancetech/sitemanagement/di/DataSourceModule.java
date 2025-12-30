package com.balancetech.sitemanagement.di;

@dagger.Module
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u00c7\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0007\u00a8\u0006\u000b"}, d2 = {"Lcom/balancetech/sitemanagement/di/DataSourceModule;", "", "()V", "provideLocalDataSource", "Lcom/balancetech/sitemanagement/data/datasource/LocalDataSource;", "localDataSourceImpl", "Lcom/balancetech/sitemanagement/data/datasource/LocalDataSourceImpl;", "provideRemoteDataSource", "Lcom/balancetech/sitemanagement/data/datasource/RemoteDataSource;", "remoteDataSourceImpl", "Lcom/balancetech/sitemanagement/data/datasource/RemoteDataSourceImpl;", "app_debug"})
@dagger.hilt.InstallIn(value = {dagger.hilt.components.SingletonComponent.class})
public final class DataSourceModule {
    @org.jetbrains.annotations.NotNull
    public static final com.balancetech.sitemanagement.di.DataSourceModule INSTANCE = null;
    
    private DataSourceModule() {
        super();
    }
    
    @dagger.Provides
    @javax.inject.Singleton
    @org.jetbrains.annotations.NotNull
    public final com.balancetech.sitemanagement.data.datasource.LocalDataSource provideLocalDataSource(@org.jetbrains.annotations.NotNull
    com.balancetech.sitemanagement.data.datasource.LocalDataSourceImpl localDataSourceImpl) {
        return null;
    }
    
    @dagger.Provides
    @javax.inject.Singleton
    @org.jetbrains.annotations.NotNull
    public final com.balancetech.sitemanagement.data.datasource.RemoteDataSource provideRemoteDataSource(@org.jetbrains.annotations.NotNull
    com.balancetech.sitemanagement.data.datasource.RemoteDataSourceImpl remoteDataSourceImpl) {
        return null;
    }
}