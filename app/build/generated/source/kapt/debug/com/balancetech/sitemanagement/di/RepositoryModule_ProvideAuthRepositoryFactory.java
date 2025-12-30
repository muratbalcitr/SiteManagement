package com.balancetech.sitemanagement.di;

import com.balancetech.sitemanagement.data.dao.UserDao;
import com.balancetech.sitemanagement.data.datasource.LocalDataSource;
import com.balancetech.sitemanagement.data.datasource.RemoteDataSource;
import com.balancetech.sitemanagement.data.repository.AuthRepository;
import com.google.firebase.auth.FirebaseAuth;
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
public final class RepositoryModule_ProvideAuthRepositoryFactory implements Factory<AuthRepository> {
  private final Provider<UserDao> userDaoProvider;

  private final Provider<FirebaseAuth> firebaseAuthProvider;

  private final Provider<LocalDataSource> localDataSourceProvider;

  private final Provider<RemoteDataSource> remoteDataSourceProvider;

  public RepositoryModule_ProvideAuthRepositoryFactory(Provider<UserDao> userDaoProvider,
      Provider<FirebaseAuth> firebaseAuthProvider,
      Provider<LocalDataSource> localDataSourceProvider,
      Provider<RemoteDataSource> remoteDataSourceProvider) {
    this.userDaoProvider = userDaoProvider;
    this.firebaseAuthProvider = firebaseAuthProvider;
    this.localDataSourceProvider = localDataSourceProvider;
    this.remoteDataSourceProvider = remoteDataSourceProvider;
  }

  @Override
  public AuthRepository get() {
    return provideAuthRepository(userDaoProvider.get(), firebaseAuthProvider.get(), localDataSourceProvider.get(), remoteDataSourceProvider.get());
  }

  public static RepositoryModule_ProvideAuthRepositoryFactory create(
      Provider<UserDao> userDaoProvider, Provider<FirebaseAuth> firebaseAuthProvider,
      Provider<LocalDataSource> localDataSourceProvider,
      Provider<RemoteDataSource> remoteDataSourceProvider) {
    return new RepositoryModule_ProvideAuthRepositoryFactory(userDaoProvider, firebaseAuthProvider, localDataSourceProvider, remoteDataSourceProvider);
  }

  public static AuthRepository provideAuthRepository(UserDao userDao, FirebaseAuth firebaseAuth,
      LocalDataSource localDataSource, RemoteDataSource remoteDataSource) {
    return Preconditions.checkNotNullFromProvides(RepositoryModule.INSTANCE.provideAuthRepository(userDao, firebaseAuth, localDataSource, remoteDataSource));
  }
}
