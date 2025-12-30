package com.balancetech.sitemanagement.data.repository;

import com.balancetech.sitemanagement.data.dao.ExtraPaymentDao;
import com.balancetech.sitemanagement.data.datasource.RemoteDataSource;
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
public final class ExtraPaymentRepository_Factory implements Factory<ExtraPaymentRepository> {
  private final Provider<ExtraPaymentDao> extraPaymentDaoProvider;

  private final Provider<RemoteDataSource> remoteDataSourceProvider;

  public ExtraPaymentRepository_Factory(Provider<ExtraPaymentDao> extraPaymentDaoProvider,
      Provider<RemoteDataSource> remoteDataSourceProvider) {
    this.extraPaymentDaoProvider = extraPaymentDaoProvider;
    this.remoteDataSourceProvider = remoteDataSourceProvider;
  }

  @Override
  public ExtraPaymentRepository get() {
    return newInstance(extraPaymentDaoProvider.get(), remoteDataSourceProvider.get());
  }

  public static ExtraPaymentRepository_Factory create(
      Provider<ExtraPaymentDao> extraPaymentDaoProvider,
      Provider<RemoteDataSource> remoteDataSourceProvider) {
    return new ExtraPaymentRepository_Factory(extraPaymentDaoProvider, remoteDataSourceProvider);
  }

  public static ExtraPaymentRepository newInstance(ExtraPaymentDao extraPaymentDao,
      RemoteDataSource remoteDataSource) {
    return new ExtraPaymentRepository(extraPaymentDao, remoteDataSource);
  }
}
