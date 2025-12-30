package com.balancetech.sitemanagement.ui.viewmodel;

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

  public WaterMeterViewModel_Factory(Provider<WaterMeterRepository> waterMeterRepositoryProvider) {
    this.waterMeterRepositoryProvider = waterMeterRepositoryProvider;
  }

  @Override
  public WaterMeterViewModel get() {
    return newInstance(waterMeterRepositoryProvider.get());
  }

  public static WaterMeterViewModel_Factory create(
      Provider<WaterMeterRepository> waterMeterRepositoryProvider) {
    return new WaterMeterViewModel_Factory(waterMeterRepositoryProvider);
  }

  public static WaterMeterViewModel newInstance(WaterMeterRepository waterMeterRepository) {
    return new WaterMeterViewModel(waterMeterRepository);
  }
}
