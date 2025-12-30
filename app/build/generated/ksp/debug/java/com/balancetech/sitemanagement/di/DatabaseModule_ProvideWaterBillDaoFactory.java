package com.balancetech.sitemanagement.di;

import com.balancetech.sitemanagement.data.dao.WaterBillDao;
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
public final class DatabaseModule_ProvideWaterBillDaoFactory implements Factory<WaterBillDao> {
  private final Provider<AppDatabase> databaseProvider;

  public DatabaseModule_ProvideWaterBillDaoFactory(Provider<AppDatabase> databaseProvider) {
    this.databaseProvider = databaseProvider;
  }

  @Override
  public WaterBillDao get() {
    return provideWaterBillDao(databaseProvider.get());
  }

  public static DatabaseModule_ProvideWaterBillDaoFactory create(
      Provider<AppDatabase> databaseProvider) {
    return new DatabaseModule_ProvideWaterBillDaoFactory(databaseProvider);
  }

  public static WaterBillDao provideWaterBillDao(AppDatabase database) {
    return Preconditions.checkNotNullFromProvides(DatabaseModule.INSTANCE.provideWaterBillDao(database));
  }
}
