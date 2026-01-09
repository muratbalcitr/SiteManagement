package com.balancetech.sitemanagement.ui.viewmodel;

import com.balancetech.sitemanagement.data.datasource.LocalDataSource;
import com.balancetech.sitemanagement.data.repository.WaterMeterRepository;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

@ScopeMetadata
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
public final class WaterMeterViewModel_Factory implements Factory<WaterMeterViewModel> {
  private final Provider<WaterMeterRepository> waterMeterRepositoryProvider;

  private final Provider<LocalDataSource> localDataSourceProvider;

  public WaterMeterViewModel_Factory(Provider<WaterMeterRepository> waterMeterRepositoryProvider,
      Provider<LocalDataSource> localDataSourceProvider) {
    this.waterMeterRepositoryProvider = waterMeterRepositoryProvider;
    this.localDataSourceProvider = localDataSourceProvider;
  }

  @Override
  public WaterMeterViewModel get() {
    return newInstance(waterMeterRepositoryProvider.get(), localDataSourceProvider.get());
  }

  public static WaterMeterViewModel_Factory create(
      Provider<WaterMeterRepository> waterMeterRepositoryProvider,
      Provider<LocalDataSource> localDataSourceProvider) {
    return new WaterMeterViewModel_Factory(waterMeterRepositoryProvider, localDataSourceProvider);
  }

  public static WaterMeterViewModel newInstance(WaterMeterRepository waterMeterRepository,
      LocalDataSource localDataSource) {
    return new WaterMeterViewModel(waterMeterRepository, localDataSource);
  }
}
