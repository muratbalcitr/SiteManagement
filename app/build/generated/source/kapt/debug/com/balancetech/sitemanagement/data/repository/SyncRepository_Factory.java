package com.balancetech.sitemanagement.data.repository;

import com.balancetech.sitemanagement.data.datasource.LocalDataSource;
import com.balancetech.sitemanagement.data.datasource.RemoteDataSource;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

@ScopeMetadata("javax.inject.Singleton")
@QualifierMetadata
@DaggerGenerated
@Generated(
    value = "dagger.internal.codegen.ComponentProcessor",
    comments = "https://dagger.dev"
)
@SuppressWarnings({
    "unchecked",
    "rawtypes",
    "KotlinInternal",
    "KotlinInternalInJava"
})
public final class SyncRepository_Factory implements Factory<SyncRepository> {
  private final Provider<LocalDataSource> localDataSourceProvider;

  private final Provider<RemoteDataSource> remoteDataSourceProvider;

  public SyncRepository_Factory(Provider<LocalDataSource> localDataSourceProvider,
      Provider<RemoteDataSource> remoteDataSourceProvider) {
    this.localDataSourceProvider = localDataSourceProvider;
    this.remoteDataSourceProvider = remoteDataSourceProvider;
  }

  @Override
  public SyncRepository get() {
    return newInstance(localDataSourceProvider.get(), remoteDataSourceProvider.get());
  }

  public static SyncRepository_Factory create(Provider<LocalDataSource> localDataSourceProvider,
      Provider<RemoteDataSource> remoteDataSourceProvider) {
    return new SyncRepository_Factory(localDataSourceProvider, remoteDataSourceProvider);
  }

  public static SyncRepository newInstance(LocalDataSource localDataSource,
      RemoteDataSource remoteDataSource) {
    return new SyncRepository(localDataSource, remoteDataSource);
  }
}
