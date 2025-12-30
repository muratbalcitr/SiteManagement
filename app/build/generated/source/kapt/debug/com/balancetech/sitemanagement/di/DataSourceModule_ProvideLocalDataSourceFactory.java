package com.balancetech.sitemanagement.di;

import com.balancetech.sitemanagement.data.datasource.LocalDataSource;
import com.balancetech.sitemanagement.data.datasource.LocalDataSourceImpl;
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
public final class DataSourceModule_ProvideLocalDataSourceFactory implements Factory<LocalDataSource> {
  private final Provider<LocalDataSourceImpl> localDataSourceImplProvider;

  public DataSourceModule_ProvideLocalDataSourceFactory(
      Provider<LocalDataSourceImpl> localDataSourceImplProvider) {
    this.localDataSourceImplProvider = localDataSourceImplProvider;
  }

  @Override
  public LocalDataSource get() {
    return provideLocalDataSource(localDataSourceImplProvider.get());
  }

  public static DataSourceModule_ProvideLocalDataSourceFactory create(
      Provider<LocalDataSourceImpl> localDataSourceImplProvider) {
    return new DataSourceModule_ProvideLocalDataSourceFactory(localDataSourceImplProvider);
  }

  public static LocalDataSource provideLocalDataSource(LocalDataSourceImpl localDataSourceImpl) {
    return Preconditions.checkNotNullFromProvides(DataSourceModule.INSTANCE.provideLocalDataSource(localDataSourceImpl));
  }
}
