package com.balancetech.sitemanagement.ui.viewmodel;

import com.balancetech.sitemanagement.data.datasource.LocalDataSource;
import com.balancetech.sitemanagement.data.repository.ExtraPaymentRepository;
import com.balancetech.sitemanagement.data.repository.FeeRepository;
import com.balancetech.sitemanagement.data.repository.PaymentRepository;
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
public final class UserDetailViewModel_Factory implements Factory<UserDetailViewModel> {
  private final Provider<FeeRepository> feeRepositoryProvider;

  private final Provider<ExtraPaymentRepository> extraPaymentRepositoryProvider;

  private final Provider<WaterMeterRepository> waterMeterRepositoryProvider;

  private final Provider<PaymentRepository> paymentRepositoryProvider;

  private final Provider<LocalDataSource> localDataSourceProvider;

  public UserDetailViewModel_Factory(Provider<FeeRepository> feeRepositoryProvider,
      Provider<ExtraPaymentRepository> extraPaymentRepositoryProvider,
      Provider<WaterMeterRepository> waterMeterRepositoryProvider,
      Provider<PaymentRepository> paymentRepositoryProvider,
      Provider<LocalDataSource> localDataSourceProvider) {
    this.feeRepositoryProvider = feeRepositoryProvider;
    this.extraPaymentRepositoryProvider = extraPaymentRepositoryProvider;
    this.waterMeterRepositoryProvider = waterMeterRepositoryProvider;
    this.paymentRepositoryProvider = paymentRepositoryProvider;
    this.localDataSourceProvider = localDataSourceProvider;
  }

  @Override
  public UserDetailViewModel get() {
    return newInstance(feeRepositoryProvider.get(), extraPaymentRepositoryProvider.get(), waterMeterRepositoryProvider.get(), paymentRepositoryProvider.get(), localDataSourceProvider.get());
  }

  public static UserDetailViewModel_Factory create(Provider<FeeRepository> feeRepositoryProvider,
      Provider<ExtraPaymentRepository> extraPaymentRepositoryProvider,
      Provider<WaterMeterRepository> waterMeterRepositoryProvider,
      Provider<PaymentRepository> paymentRepositoryProvider,
      Provider<LocalDataSource> localDataSourceProvider) {
    return new UserDetailViewModel_Factory(feeRepositoryProvider, extraPaymentRepositoryProvider, waterMeterRepositoryProvider, paymentRepositoryProvider, localDataSourceProvider);
  }

  public static UserDetailViewModel newInstance(FeeRepository feeRepository,
      ExtraPaymentRepository extraPaymentRepository, WaterMeterRepository waterMeterRepository,
      PaymentRepository paymentRepository, LocalDataSource localDataSource) {
    return new UserDetailViewModel(feeRepository, extraPaymentRepository, waterMeterRepository, paymentRepository, localDataSource);
  }
}
