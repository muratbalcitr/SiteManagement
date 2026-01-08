package com.balancetech.sitemanagement.di;

import com.balancetech.sitemanagement.data.dao.PaymentDao;
import com.balancetech.sitemanagement.data.datasource.LocalDataSource;
import com.balancetech.sitemanagement.data.repository.PaymentRepository;
import com.balancetech.sitemanagement.data.service.FirebaseFunctionsService;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

@ScopeMetadata("javax.inject.Singleton")
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
public final class RepositoryModule_ProvidePaymentRepositoryFactory implements Factory<PaymentRepository> {
  private final Provider<PaymentDao> paymentDaoProvider;

  private final Provider<FirebaseFunctionsService> functionsServiceProvider;

  private final Provider<LocalDataSource> localDataSourceProvider;

  public RepositoryModule_ProvidePaymentRepositoryFactory(Provider<PaymentDao> paymentDaoProvider,
      Provider<FirebaseFunctionsService> functionsServiceProvider,
      Provider<LocalDataSource> localDataSourceProvider) {
    this.paymentDaoProvider = paymentDaoProvider;
    this.functionsServiceProvider = functionsServiceProvider;
    this.localDataSourceProvider = localDataSourceProvider;
  }

  @Override
  public PaymentRepository get() {
    return providePaymentRepository(paymentDaoProvider.get(), functionsServiceProvider.get(), localDataSourceProvider.get());
  }

  public static RepositoryModule_ProvidePaymentRepositoryFactory create(
      Provider<PaymentDao> paymentDaoProvider,
      Provider<FirebaseFunctionsService> functionsServiceProvider,
      Provider<LocalDataSource> localDataSourceProvider) {
    return new RepositoryModule_ProvidePaymentRepositoryFactory(paymentDaoProvider, functionsServiceProvider, localDataSourceProvider);
  }

  public static PaymentRepository providePaymentRepository(PaymentDao paymentDao,
      FirebaseFunctionsService functionsService, LocalDataSource localDataSource) {
    return Preconditions.checkNotNullFromProvides(RepositoryModule.INSTANCE.providePaymentRepository(paymentDao, functionsService, localDataSource));
  }
}
