package com.balancetech.sitemanagement.di;

import com.balancetech.sitemanagement.data.dao.ExtraPaymentDao;
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
public final class DatabaseModule_ProvideExtraPaymentDaoFactory implements Factory<ExtraPaymentDao> {
  private final Provider<AppDatabase> databaseProvider;

  public DatabaseModule_ProvideExtraPaymentDaoFactory(Provider<AppDatabase> databaseProvider) {
    this.databaseProvider = databaseProvider;
  }

  @Override
  public ExtraPaymentDao get() {
    return provideExtraPaymentDao(databaseProvider.get());
  }

  public static DatabaseModule_ProvideExtraPaymentDaoFactory create(
      Provider<AppDatabase> databaseProvider) {
    return new DatabaseModule_ProvideExtraPaymentDaoFactory(databaseProvider);
  }

  public static ExtraPaymentDao provideExtraPaymentDao(AppDatabase database) {
    return Preconditions.checkNotNullFromProvides(DatabaseModule.INSTANCE.provideExtraPaymentDao(database));
  }
}
