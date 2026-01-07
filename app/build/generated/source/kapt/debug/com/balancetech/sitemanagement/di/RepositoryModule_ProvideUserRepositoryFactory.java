package com.balancetech.sitemanagement.di;

import com.balancetech.sitemanagement.data.dao.UserUnitDao;
import com.balancetech.sitemanagement.data.datasource.LocalDataSource;
import com.balancetech.sitemanagement.data.datasource.RemoteDataSource;
import com.balancetech.sitemanagement.data.repository.UserRepository;
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
public final class RepositoryModule_ProvideUserRepositoryFactory implements Factory<UserRepository> {
  private final Provider<LocalDataSource> localDataSourceProvider;

  private final Provider<RemoteDataSource> remoteDataSourceProvider;

  private final Provider<UserUnitDao> userUnitDaoProvider;

  public RepositoryModule_ProvideUserRepositoryFactory(
      Provider<LocalDataSource> localDataSourceProvider,
      Provider<RemoteDataSource> remoteDataSourceProvider,
      Provider<UserUnitDao> userUnitDaoProvider) {
    this.localDataSourceProvider = localDataSourceProvider;
    this.remoteDataSourceProvider = remoteDataSourceProvider;
    this.userUnitDaoProvider = userUnitDaoProvider;
  }

  @Override
  public UserRepository get() {
    return provideUserRepository(localDataSourceProvider.get(), remoteDataSourceProvider.get(), userUnitDaoProvider.get());
  }

  public static RepositoryModule_ProvideUserRepositoryFactory create(
      Provider<LocalDataSource> localDataSourceProvider,
      Provider<RemoteDataSource> remoteDataSourceProvider,
      Provider<UserUnitDao> userUnitDaoProvider) {
    return new RepositoryModule_ProvideUserRepositoryFactory(localDataSourceProvider, remoteDataSourceProvider, userUnitDaoProvider);
  }

  public static UserRepository provideUserRepository(LocalDataSource localDataSource,
      RemoteDataSource remoteDataSource, UserUnitDao userUnitDao) {
    return Preconditions.checkNotNullFromProvides(RepositoryModule.INSTANCE.provideUserRepository(localDataSource, remoteDataSource, userUnitDao));
  }
}
