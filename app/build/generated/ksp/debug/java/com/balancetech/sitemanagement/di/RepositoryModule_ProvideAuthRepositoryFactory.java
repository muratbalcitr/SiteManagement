package com.balancetech.sitemanagement.di;

import com.balancetech.sitemanagement.data.dao.UserDao;
import com.balancetech.sitemanagement.data.repository.AuthRepository;
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

  public RepositoryModule_ProvideAuthRepositoryFactory(Provider<UserDao> userDaoProvider) {
    this.userDaoProvider = userDaoProvider;
  }

  @Override
  public AuthRepository get() {
    return provideAuthRepository(userDaoProvider.get());
  }

  public static RepositoryModule_ProvideAuthRepositoryFactory create(
      Provider<UserDao> userDaoProvider) {
    return new RepositoryModule_ProvideAuthRepositoryFactory(userDaoProvider);
  }

  public static AuthRepository provideAuthRepository(UserDao userDao) {
    return Preconditions.checkNotNullFromProvides(RepositoryModule.INSTANCE.provideAuthRepository(userDao));
  }
}
