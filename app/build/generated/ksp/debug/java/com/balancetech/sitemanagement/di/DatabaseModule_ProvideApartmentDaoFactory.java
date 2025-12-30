package com.balancetech.sitemanagement.di;

import com.balancetech.sitemanagement.data.dao.ApartmentDao;
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
public final class DatabaseModule_ProvideApartmentDaoFactory implements Factory<ApartmentDao> {
  private final Provider<AppDatabase> databaseProvider;

  public DatabaseModule_ProvideApartmentDaoFactory(Provider<AppDatabase> databaseProvider) {
    this.databaseProvider = databaseProvider;
  }

  @Override
  public ApartmentDao get() {
    return provideApartmentDao(databaseProvider.get());
  }

  public static DatabaseModule_ProvideApartmentDaoFactory create(
      Provider<AppDatabase> databaseProvider) {
    return new DatabaseModule_ProvideApartmentDaoFactory(databaseProvider);
  }

  public static ApartmentDao provideApartmentDao(AppDatabase database) {
    return Preconditions.checkNotNullFromProvides(DatabaseModule.INSTANCE.provideApartmentDao(database));
  }
}
