package com.balancetech.sitemanagement.di;

import com.balancetech.sitemanagement.data.dao.BlockDao;
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
public final class DatabaseModule_ProvideBlockDaoFactory implements Factory<BlockDao> {
  private final Provider<AppDatabase> databaseProvider;

  public DatabaseModule_ProvideBlockDaoFactory(Provider<AppDatabase> databaseProvider) {
    this.databaseProvider = databaseProvider;
  }

  @Override
  public BlockDao get() {
    return provideBlockDao(databaseProvider.get());
  }

  public static DatabaseModule_ProvideBlockDaoFactory create(
      Provider<AppDatabase> databaseProvider) {
    return new DatabaseModule_ProvideBlockDaoFactory(databaseProvider);
  }

  public static BlockDao provideBlockDao(AppDatabase database) {
    return Preconditions.checkNotNullFromProvides(DatabaseModule.INSTANCE.provideBlockDao(database));
  }
}
