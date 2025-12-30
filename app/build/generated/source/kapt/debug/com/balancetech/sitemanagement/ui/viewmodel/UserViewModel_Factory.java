package com.balancetech.sitemanagement.ui.viewmodel;

import com.balancetech.sitemanagement.data.datasource.LocalDataSource;
import com.balancetech.sitemanagement.data.datasource.RemoteDataSource;
import com.balancetech.sitemanagement.data.repository.UserRepository;
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
public final class UserViewModel_Factory implements Factory<UserViewModel> {
  private final Provider<UserRepository> userRepositoryProvider;

  private final Provider<LocalDataSource> localDataSourceProvider;

  private final Provider<RemoteDataSource> remoteDataSourceProvider;

  public UserViewModel_Factory(Provider<UserRepository> userRepositoryProvider,
      Provider<LocalDataSource> localDataSourceProvider,
      Provider<RemoteDataSource> remoteDataSourceProvider) {
    this.userRepositoryProvider = userRepositoryProvider;
    this.localDataSourceProvider = localDataSourceProvider;
    this.remoteDataSourceProvider = remoteDataSourceProvider;
  }

  @Override
  public UserViewModel get() {
    return newInstance(userRepositoryProvider.get(), localDataSourceProvider.get(), remoteDataSourceProvider.get());
  }

  public static UserViewModel_Factory create(Provider<UserRepository> userRepositoryProvider,
      Provider<LocalDataSource> localDataSourceProvider,
      Provider<RemoteDataSource> remoteDataSourceProvider) {
    return new UserViewModel_Factory(userRepositoryProvider, localDataSourceProvider, remoteDataSourceProvider);
  }

  public static UserViewModel newInstance(UserRepository userRepository,
      LocalDataSource localDataSource, RemoteDataSource remoteDataSource) {
    return new UserViewModel(userRepository, localDataSource, remoteDataSource);
  }
}
