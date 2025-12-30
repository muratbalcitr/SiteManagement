package com.balancetech.sitemanagement.ui.viewmodel;

import com.balancetech.sitemanagement.data.repository.AuthRepository;
import com.balancetech.sitemanagement.data.repository.FeeRepository;
import com.balancetech.sitemanagement.data.repository.PaymentRepository;
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

  public DashboardViewModel_Factory(Provider<AuthRepository> authRepositoryProvider,
      Provider<FeeRepository> feeRepositoryProvider,
      Provider<PaymentRepository> paymentRepositoryProvider) {
    this.authRepositoryProvider = authRepositoryProvider;
    this.feeRepositoryProvider = feeRepositoryProvider;
    this.paymentRepositoryProvider = paymentRepositoryProvider;
  }

  @Override
  public DashboardViewModel get() {
    return newInstance(authRepositoryProvider.get(), feeRepositoryProvider.get(), paymentRepositoryProvider.get());
  }

  public static DashboardViewModel_Factory create(Provider<AuthRepository> authRepositoryProvider,
      Provider<FeeRepository> feeRepositoryProvider,
      Provider<PaymentRepository> paymentRepositoryProvider) {
    return new DashboardViewModel_Factory(authRepositoryProvider, feeRepositoryProvider, paymentRepositoryProvider);
  }

  public static DashboardViewModel newInstance(AuthRepository authRepository,
      FeeRepository feeRepository, PaymentRepository paymentRepository) {
    return new DashboardViewModel(authRepository, feeRepository, paymentRepository);
  }
}
