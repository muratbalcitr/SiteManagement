package com.balancetech.sitemanagement.di;

import com.balancetech.sitemanagement.data.datasource.RemoteDataSource;
import com.balancetech.sitemanagement.data.datasource.RemoteDataSourceImpl;
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
public final class DataSourceModule_ProvideRemoteDataSourceFactory implements Factory<RemoteDataSource> {
  private final Provider<RemoteDataSourceImpl> remoteDataSourceImplProvider;

  public DataSourceModule_ProvideRemoteDataSourceFactory(
      Provider<RemoteDataSourceImpl> remoteDataSourceImplProvider) {
    this.remoteDataSourceImplProvider = remoteDataSourceImplProvider;
  }

  @Override
  public RemoteDataSource get() {
    return provideRemoteDataSource(remoteDataSourceImplProvider.get());
  }

  public static DataSourceModule_ProvideRemoteDataSourceFactory create(
      Provider<RemoteDataSourceImpl> remoteDataSourceImplProvider) {
    return new DataSourceModule_ProvideRemoteDataSourceFactory(remoteDataSourceImplProvider);
  }

  public static RemoteDataSource provideRemoteDataSource(
      RemoteDataSourceImpl remoteDataSourceImpl) {
    return Preconditions.checkNotNullFromProvides(DataSourceModule.INSTANCE.provideRemoteDataSource(remoteDataSourceImpl));
  }
}
