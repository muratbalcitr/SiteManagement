package com.balancetech.sitemanagement.ui.viewmodel;

import com.balancetech.sitemanagement.data.repository.AuthRepository;
import com.balancetech.sitemanagement.data.repository.ExtraPaymentRepository;
import com.balancetech.sitemanagement.data.repository.FeeRepository;
import com.balancetech.sitemanagement.data.repository.PaymentRepository;
import com.balancetech.sitemanagement.data.repository.SyncRepository;
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
public final class DashboardViewModel_Factory implements Factory<DashboardViewModel> {
  private final Provider<AuthRepository> authRepositoryProvider;

  private final Provider<FeeRepository> feeRepositoryProvider;

  private final Provider<PaymentRepository> paymentRepositoryProvider;

  private final Provider<ExtraPaymentRepository> extraPaymentRepositoryProvider;

  private final Provider<WaterMeterRepository> waterMeterRepositoryProvider;

  private final Provider<SyncRepository> syncRepositoryProvider;

  public DashboardViewModel_Factory(Provider<AuthRepository> authRepositoryProvider,
      Provider<FeeRepository> feeRepositoryProvider,
      Provider<PaymentRepository> paymentRepositoryProvider,
      Provider<ExtraPaymentRepository> extraPaymentRepositoryProvider,
      Provider<WaterMeterRepository> waterMeterRepositoryProvider,
      Provider<SyncRepository> syncRepositoryProvider) {
    this.authRepositoryProvider = authRepositoryProvider;
    this.feeRepositoryProvider = feeRepositoryProvider;
    this.paymentRepositoryProvider = paymentRepositoryProvider;
    this.extraPaymentRepositoryProvider = extraPaymentRepositoryProvider;
    this.waterMeterRepositoryProvider = waterMeterRepositoryProvider;
    this.syncRepositoryProvider = syncRepositoryProvider;
  }

  @Override
  public DashboardViewModel get() {
    return newInstance(authRepositoryProvider.get(), feeRepositoryProvider.get(), paymentRepositoryProvider.get(), extraPaymentRepositoryProvider.get(), waterMeterRepositoryProvider.get(), syncRepositoryProvider.get());
  }

  public static DashboardViewModel_Factory create(Provider<AuthRepository> authRepositoryProvider,
      Provider<FeeRepository> feeRepositoryProvider,
      Provider<PaymentRepository> paymentRepositoryProvider,
      Provider<ExtraPaymentRepository> extraPaymentRepositoryProvider,
      Provider<WaterMeterRepository> waterMeterRepositoryProvider,
      Provider<SyncRepository> syncRepositoryProvider) {
    return new DashboardViewModel_Factory(authRepositoryProvider, feeRepositoryProvider, paymentRepositoryProvider, extraPaymentRepositoryProvider, waterMeterRepositoryProvider, syncRepositoryProvider);
  }

  public static DashboardViewModel newInstance(AuthRepository authRepository,
      FeeRepository feeRepository, PaymentRepository paymentRepository,
      ExtraPaymentRepository extraPaymentRepository, WaterMeterRepository waterMeterRepository,
      SyncRepository syncRepository) {
    return new DashboardViewModel(authRepository, feeRepository, paymentRepository, extraPaymentRepository, waterMeterRepository, syncRepository);
  }
}
