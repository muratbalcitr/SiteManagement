package com.balancetech.sitemanagement.di;

import com.balancetech.sitemanagement.data.dao.UserUnitDao;
import com.balancetech.sitemanagement.data.database.AppDatabase;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
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
public final class DatabaseModule_ProvideUserUnitDaoFactory implements Factory<UserUnitDao> {
  private final Provider<AppDatabase> databaseProvider;

  public DatabaseModule_ProvideUserUnitDaoFactory(Provider<AppDatabase> databaseProvider) {
    this.databaseProvider = databaseProvider;
  }

  @Override
  public UserUnitDao get() {
    return provideUserUnitDao(databaseProvider.get());
  }

  public static DatabaseModule_ProvideUserUnitDaoFactory create(
      Provider<AppDatabase> databaseProvider) {
    return new DatabaseModule_ProvideUserUnitDaoFactory(databaseProvider);
  }

  public static UserUnitDao provideUserUnitDao(AppDatabase database) {
    return Preconditions.checkNotNullFromProvides(DatabaseModule.INSTANCE.provideUserUnitDao(database));
  }
}
