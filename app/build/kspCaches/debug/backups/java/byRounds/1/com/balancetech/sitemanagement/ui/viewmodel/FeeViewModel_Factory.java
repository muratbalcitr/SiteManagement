package com.balancetech.sitemanagement.ui.viewmodel;

import com.balancetech.sitemanagement.data.repository.FeeRepository;
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
public final class FeeViewModel_Factory implements Factory<FeeViewModel> {
  private final Provider<FeeRepository> feeRepositoryProvider;

  public FeeViewModel_Factory(Provider<FeeRepository> feeRepositoryProvider) {
    this.feeRepositoryProvider = feeRepositoryProvider;
  }

  @Override
  public FeeViewModel get() {
    return newInstance(feeRepositoryProvider.get());
  }

  public static FeeViewModel_Factory create(Provider<FeeRepository> feeRepositoryProvider) {
    return new FeeViewModel_Factory(feeRepositoryProvider);
  }

  public static FeeViewModel newInstance(FeeRepository feeRepository) {
    return new FeeViewModel(feeRepository);
  }
}
