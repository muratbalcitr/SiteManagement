package com.balancetech.sitemanagement.ui.viewmodel;

import com.balancetech.sitemanagement.data.repository.ExtraPaymentRepository;
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
public final class ExtraPaymentViewModel_Factory implements Factory<ExtraPaymentViewModel> {
  private final Provider<ExtraPaymentRepository> extraPaymentRepositoryProvider;

  public ExtraPaymentViewModel_Factory(
      Provider<ExtraPaymentRepository> extraPaymentRepositoryProvider) {
    this.extraPaymentRepositoryProvider = extraPaymentRepositoryProvider;
  }

  @Override
  public ExtraPaymentViewModel get() {
    return newInstance(extraPaymentRepositoryProvider.get());
  }

  public static ExtraPaymentViewModel_Factory create(
      Provider<ExtraPaymentRepository> extraPaymentRepositoryProvider) {
    return new ExtraPaymentViewModel_Factory(extraPaymentRepositoryProvider);
  }

  public static ExtraPaymentViewModel newInstance(ExtraPaymentRepository extraPaymentRepository) {
    return new ExtraPaymentViewModel(extraPaymentRepository);
  }
}
