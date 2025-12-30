package com.balancetech.sitemanagement.di;

import com.balancetech.sitemanagement.data.dao.UnitDao;
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
public final class DatabaseModule_ProvideUnitDaoFactory implements Factory<UnitDao> {
  private final Provider<AppDatabase> databaseProvider;

  public DatabaseModule_ProvideUnitDaoFactory(Provider<AppDatabase> databaseProvider) {
    this.databaseProvider = databaseProvider;
  }

  @Override
  public UnitDao get() {
    return provideUnitDao(databaseProvider.get());
  }

  public static DatabaseModule_ProvideUnitDaoFactory create(
      Provider<AppDatabase> databaseProvider) {
    return new DatabaseModule_ProvideUnitDaoFactory(databaseProvider);
  }

  public static UnitDao provideUnitDao(AppDatabase database) {
    return Preconditions.checkNotNullFromProvides(DatabaseModule.INSTANCE.provideUnitDao(database));
  }
}
