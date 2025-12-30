package com.balancetech.sitemanagement.di;

import com.balancetech.sitemanagement.data.dao.FeeDao;
import com.balancetech.sitemanagement.data.dao.UnitDao;
import com.balancetech.sitemanagement.data.dao.UserDao;
import com.balancetech.sitemanagement.data.datasource.LocalDataSource;
import com.balancetech.sitemanagement.data.datasource.RemoteDataSource;
import com.balancetech.sitemanagement.data.repository.FeeRepository;
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
public final class RepositoryModule_ProvideFeeRepositoryFactory implements Factory<FeeRepository> {
  private final Provider<FeeDao> feeDaoProvider;

  private final Provider<UnitDao> unitDaoProvider;

  private final Provider<LocalDataSource> localDataSourceProvider;

  private final Provider<RemoteDataSource> remoteDataSourceProvider;

  private final Provider<FirebaseFunctionsService> functionsServiceProvider;

  private final Provider<UserDao> userDaoProvider;

  public RepositoryModule_ProvideFeeRepositoryFactory(Provider<FeeDao> feeDaoProvider,
      Provider<UnitDao> unitDaoProvider, Provider<LocalDataSource> localDataSourceProvider,
      Provider<RemoteDataSource> remoteDataSourceProvider,
      Provider<FirebaseFunctionsService> functionsServiceProvider,
      Provider<UserDao> userDaoProvider) {
    this.feeDaoProvider = feeDaoProvider;
    this.unitDaoProvider = unitDaoProvider;
    this.localDataSourceProvider = localDataSourceProvider;
    this.remoteDataSourceProvider = remoteDataSourceProvider;
    this.functionsServiceProvider = functionsServiceProvider;
    this.userDaoProvider = userDaoProvider;
  }

  @Override
  public FeeRepository get() {
    return provideFeeRepository(feeDaoProvider.get(), unitDaoProvider.get(), localDataSourceProvider.get(), remoteDataSourceProvider.get(), functionsServiceProvider.get(), userDaoProvider.get());
  }

  public static RepositoryModule_ProvideFeeRepositoryFactory create(Provider<FeeDao> feeDaoProvider,
      Provider<UnitDao> unitDaoProvider, Provider<LocalDataSource> localDataSourceProvider,
      Provider<RemoteDataSource> remoteDataSourceProvider,
      Provider<FirebaseFunctionsService> functionsServiceProvider,
      Provider<UserDao> userDaoProvider) {
    return new RepositoryModule_ProvideFeeRepositoryFactory(feeDaoProvider, unitDaoProvider, localDataSourceProvider, remoteDataSourceProvider, functionsServiceProvider, userDaoProvider);
  }

  public static FeeRepository provideFeeRepository(FeeDao feeDao, UnitDao unitDao,
      LocalDataSource localDataSource, RemoteDataSource remoteDataSource,
      FirebaseFunctionsService functionsService, UserDao userDao) {
    return Preconditions.checkNotNullFromProvides(RepositoryModule.INSTANCE.provideFeeRepository(feeDao, unitDao, localDataSource, remoteDataSource, functionsService, userDao));
  }
}
