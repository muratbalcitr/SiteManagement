package com.balancetech.sitemanagement.di;

import com.balancetech.sitemanagement.data.datasource.LocalDataSource;
import com.balancetech.sitemanagement.data.datasource.RemoteDataSource;
import com.balancetech.sitemanagement.data.repository.SyncRepository;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
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
public final class RepositoryModule_ProvideSyncRepositoryFactory implements Factory<SyncRepository> {
  private final Provider<LocalDataSource> localDataSourceProvider;

  private final Provider<RemoteDataSource> remoteDataSourceProvider;

  public RepositoryModule_ProvideSyncRepositoryFactory(
      Provider<LocalDataSource> localDataSourceProvider,
      Provider<RemoteDataSource> remoteDataSourceProvider) {
    this.localDataSourceProvider = localDataSourceProvider;
    this.remoteDataSourceProvider = remoteDataSourceProvider;
  }

  @Override
  public SyncRepository get() {
    return provideSyncRepository(localDataSourceProvider.get(), remoteDataSourceProvider.get());
  }

  public static RepositoryModule_ProvideSyncRepositoryFactory create(
      Provider<LocalDataSource> localDataSourceProvider,
      Provider<RemoteDataSource> remoteDataSourceProvider) {
    return new RepositoryModule_ProvideSyncRepositoryFactory(localDataSourceProvider, remoteDataSourceProvider);
  }

  public static SyncRepository provideSyncRepository(LocalDataSource localDataSource,
      RemoteDataSource remoteDataSource) {
    return Preconditions.checkNotNullFromProvides(RepositoryModule.INSTANCE.provideSyncRepository(localDataSource, remoteDataSource));
  }
}
