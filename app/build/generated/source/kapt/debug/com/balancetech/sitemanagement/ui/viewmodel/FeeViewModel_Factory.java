package com.balancetech.sitemanagement.ui.viewmodel;

import com.balancetech.sitemanagement.data.datasource.LocalDataSource;
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

  private final Provider<LocalDataSource> localDataSourceProvider;

  public FeeViewModel_Factory(Provider<FeeRepository> feeRepositoryProvider,
      Provider<LocalDataSource> localDataSourceProvider) {
    this.feeRepositoryProvider = feeRepositoryProvider;
    this.localDataSourceProvider = localDataSourceProvider;
  }

  @Override
  public FeeViewModel get() {
    return newInstance(feeRepositoryProvider.get(), localDataSourceProvider.get());
  }

  public static FeeViewModel_Factory create(Provider<FeeRepository> feeRepositoryProvider,
      Provider<LocalDataSource> localDataSourceProvider) {
    return new FeeViewModel_Factory(feeRepositoryProvider, localDataSourceProvider);
  }

  public static FeeViewModel newInstance(FeeRepository feeRepository,
      LocalDataSource localDataSource) {
    return new FeeViewModel(feeRepository, localDataSource);
  }
}
