package com.balancetech.sitemanagement.ui.viewmodel;

import com.balancetech.sitemanagement.data.repository.FeeRepository;
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
public final class ReportsViewModel_Factory implements Factory<ReportsViewModel> {
  private final Provider<FeeRepository> feeRepositoryProvider;

  private final Provider<WaterMeterRepository> waterMeterRepositoryProvider;

  public ReportsViewModel_Factory(Provider<FeeRepository> feeRepositoryProvider,
      Provider<WaterMeterRepository> waterMeterRepositoryProvider) {
    this.feeRepositoryProvider = feeRepositoryProvider;
    this.waterMeterRepositoryProvider = waterMeterRepositoryProvider;
  }

  @Override
  public ReportsViewModel get() {
    return newInstance(feeRepositoryProvider.get(), waterMeterRepositoryProvider.get());
  }

  public static ReportsViewModel_Factory create(Provider<FeeRepository> feeRepositoryProvider,
      Provider<WaterMeterRepository> waterMeterRepositoryProvider) {
    return new ReportsViewModel_Factory(feeRepositoryProvider, waterMeterRepositoryProvider);
  }

  public static ReportsViewModel newInstance(FeeRepository feeRepository,
      WaterMeterRepository waterMeterRepository) {
    return new ReportsViewModel(feeRepository, waterMeterRepository);
  }
}
