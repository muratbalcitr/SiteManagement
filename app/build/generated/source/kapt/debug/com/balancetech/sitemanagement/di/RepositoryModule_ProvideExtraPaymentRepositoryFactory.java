package com.balancetech.sitemanagement.di;

import com.balancetech.sitemanagement.data.dao.ExtraPaymentDao;
import com.balancetech.sitemanagement.data.datasource.RemoteDataSource;
import com.balancetech.sitemanagement.data.repository.ExtraPaymentRepository;
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
public final class RepositoryModule_ProvideExtraPaymentRepositoryFactory implements Factory<ExtraPaymentRepository> {
  private final Provider<ExtraPaymentDao> extraPaymentDaoProvider;

  private final Provider<RemoteDataSource> remoteDataSourceProvider;

  public RepositoryModule_ProvideExtraPaymentRepositoryFactory(
      Provider<ExtraPaymentDao> extraPaymentDaoProvider,
      Provider<RemoteDataSource> remoteDataSourceProvider) {
    this.extraPaymentDaoProvider = extraPaymentDaoProvider;
    this.remoteDataSourceProvider = remoteDataSourceProvider;
  }

  @Override
  public ExtraPaymentRepository get() {
    return provideExtraPaymentRepository(extraPaymentDaoProvider.get(), remoteDataSourceProvider.get());
  }

  public static RepositoryModule_ProvideExtraPaymentRepositoryFactory create(
      Provider<ExtraPaymentDao> extraPaymentDaoProvider,
      Provider<RemoteDataSource> remoteDataSourceProvider) {
    return new RepositoryModule_ProvideExtraPaymentRepositoryFactory(extraPaymentDaoProvider, remoteDataSourceProvider);
  }

  public static ExtraPaymentRepository provideExtraPaymentRepository(
      ExtraPaymentDao extraPaymentDao, RemoteDataSource remoteDataSource) {
    return Preconditions.checkNotNullFromProvides(RepositoryModule.INSTANCE.provideExtraPaymentRepository(extraPaymentDao, remoteDataSource));
  }
}
