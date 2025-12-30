package com.balancetech.sitemanagement.data.repository;

import com.balancetech.sitemanagement.data.dao.UserDao;
import com.balancetech.sitemanagement.data.datasource.LocalDataSource;
import com.balancetech.sitemanagement.data.datasource.RemoteDataSource;
import com.google.firebase.auth.FirebaseAuth;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
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
public final class AuthRepository_Factory implements Factory<AuthRepository> {
  private final Provider<UserDao> userDaoProvider;

  private final Provider<FirebaseAuth> firebaseAuthProvider;

  private final Provider<LocalDataSource> localDataSourceProvider;

  private final Provider<RemoteDataSource> remoteDataSourceProvider;

  public AuthRepository_Factory(Provider<UserDao> userDaoProvider,
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
    return newInstance(userDaoProvider.get(), firebaseAuthProvider.get(), localDataSourceProvider.get(), remoteDataSourceProvider.get());
  }

  public static AuthRepository_Factory create(Provider<UserDao> userDaoProvider,
      Provider<FirebaseAuth> firebaseAuthProvider,
      Provider<LocalDataSource> localDataSourceProvider,
      Provider<RemoteDataSource> remoteDataSourceProvider) {
    return new AuthRepository_Factory(userDaoProvider, firebaseAuthProvider, localDataSourceProvider, remoteDataSourceProvider);
  }

  public static AuthRepository newInstance(UserDao userDao, FirebaseAuth firebaseAuth,
      LocalDataSource localDataSource, RemoteDataSource remoteDataSource) {
    return new AuthRepository(userDao, firebaseAuth, localDataSource, remoteDataSource);
  }
}
