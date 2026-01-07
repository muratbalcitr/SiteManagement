package com.balancetech.sitemanagement.ui.viewmodel;

import com.balancetech.sitemanagement.data.repository.AuthRepository;
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
public final class PaymentViewModel_Factory implements Factory<PaymentViewModel> {
  private final Provider<PaymentRepository> paymentRepositoryProvider;

  private final Provider<FeeRepository> feeRepositoryProvider;

  private final Provider<ExtraPaymentRepository> extraPaymentRepositoryProvider;

  private final Provider<WaterMeterRepository> waterMeterRepositoryProvider;

  private final Provider<AuthRepository> authRepositoryProvider;

  public PaymentViewModel_Factory(Provider<PaymentRepository> paymentRepositoryProvider,
      Provider<FeeRepository> feeRepositoryProvider,
      Provider<ExtraPaymentRepository> extraPaymentRepositoryProvider,
      Provider<WaterMeterRepository> waterMeterRepositoryProvider,
      Provider<AuthRepository> authRepositoryProvider) {
    this.paymentRepositoryProvider = paymentRepositoryProvider;
    this.feeRepositoryProvider = feeRepositoryProvider;
    this.extraPaymentRepositoryProvider = extraPaymentRepositoryProvider;
    this.waterMeterRepositoryProvider = waterMeterRepositoryProvider;
    this.authRepositoryProvider = authRepositoryProvider;
  }

  @Override
  public PaymentViewModel get() {
    return newInstance(paymentRepositoryProvider.get(), feeRepositoryProvider.get(), extraPaymentRepositoryProvider.get(), waterMeterRepositoryProvider.get(), authRepositoryProvider.get());
  }

  public static PaymentViewModel_Factory create(
      Provider<PaymentRepository> paymentRepositoryProvider,
      Provider<FeeRepository> feeRepositoryProvider,
      Provider<ExtraPaymentRepository> extraPaymentRepositoryProvider,
      Provider<WaterMeterRepository> waterMeterRepositoryProvider,
      Provider<AuthRepository> authRepositoryProvider) {
    return new PaymentViewModel_Factory(paymentRepositoryProvider, feeRepositoryProvider, extraPaymentRepositoryProvider, waterMeterRepositoryProvider, authRepositoryProvider);
  }

  public static PaymentViewModel newInstance(PaymentRepository paymentRepository,
      FeeRepository feeRepository, ExtraPaymentRepository extraPaymentRepository,
      WaterMeterRepository waterMeterRepository, AuthRepository authRepository) {
    return new PaymentViewModel(paymentRepository, feeRepository, extraPaymentRepository, waterMeterRepository, authRepository);
  }
}
