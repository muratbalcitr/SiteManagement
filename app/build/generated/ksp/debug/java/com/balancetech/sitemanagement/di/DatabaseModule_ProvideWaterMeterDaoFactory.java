package com.balancetech.sitemanagement.di;

import com.balancetech.sitemanagement.data.dao.WaterMeterDao;
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
public final class DatabaseModule_ProvideWaterMeterDaoFactory implements Factory<WaterMeterDao> {
  private final Provider<AppDatabase> databaseProvider;

  public DatabaseModule_ProvideWaterMeterDaoFactory(Provider<AppDatabase> databaseProvider) {
    this.databaseProvider = databaseProvider;
  }

  @Override
  public WaterMeterDao get() {
    return provideWaterMeterDao(databaseProvider.get());
  }

  public static DatabaseModule_ProvideWaterMeterDaoFactory create(
      Provider<AppDatabase> databaseProvider) {
    return new DatabaseModule_ProvideWaterMeterDaoFactory(databaseProvider);
  }

  public static WaterMeterDao provideWaterMeterDao(AppDatabase database) {
    return Preconditions.checkNotNullFromProvides(DatabaseModule.INSTANCE.provideWaterMeterDao(database));
  }
}
