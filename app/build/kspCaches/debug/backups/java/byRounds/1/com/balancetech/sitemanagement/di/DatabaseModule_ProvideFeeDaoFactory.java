package com.balancetech.sitemanagement.di;

import com.balancetech.sitemanagement.data.dao.FeeDao;
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
public final class DatabaseModule_ProvideFeeDaoFactory implements Factory<FeeDao> {
  private final Provider<AppDatabase> databaseProvider;

  public DatabaseModule_ProvideFeeDaoFactory(Provider<AppDatabase> databaseProvider) {
    this.databaseProvider = databaseProvider;
  }

  @Override
  public FeeDao get() {
    return provideFeeDao(databaseProvider.get());
  }

  public static DatabaseModule_ProvideFeeDaoFactory create(Provider<AppDatabase> databaseProvider) {
    return new DatabaseModule_ProvideFeeDaoFactory(databaseProvider);
  }

  public static FeeDao provideFeeDao(AppDatabase database) {
    return Preconditions.checkNotNullFromProvides(DatabaseModule.INSTANCE.provideFeeDao(database));
  }
}
