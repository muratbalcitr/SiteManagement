package com.balancetech.sitemanagement.di;

import com.balancetech.sitemanagement.data.dao.WaterBillDao;
import com.balancetech.sitemanagement.data.dao.WaterMeterDao;
import com.balancetech.sitemanagement.data.repository.WaterMeterRepository;
import com.balancetech.sitemanagement.data.service.FirebaseFunctionsService;
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
public final class RepositoryModule_ProvideWaterMeterRepositoryFactory implements Factory<WaterMeterRepository> {
  private final Provider<WaterMeterDao> waterMeterDaoProvider;

  private final Provider<WaterBillDao> waterBillDaoProvider;

  private final Provider<FirebaseFunctionsService> functionsServiceProvider;

  public RepositoryModule_ProvideWaterMeterRepositoryFactory(
      Provider<WaterMeterDao> waterMeterDaoProvider, Provider<WaterBillDao> waterBillDaoProvider,
      Provider<FirebaseFunctionsService> functionsServiceProvider) {
    this.waterMeterDaoProvider = waterMeterDaoProvider;
    this.waterBillDaoProvider = waterBillDaoProvider;
    this.functionsServiceProvider = functionsServiceProvider;
  }

  @Override
  public WaterMeterRepository get() {
    return provideWaterMeterRepository(waterMeterDaoProvider.get(), waterBillDaoProvider.get(), functionsServiceProvider.get());
  }

  public static RepositoryModule_ProvideWaterMeterRepositoryFactory create(
      Provider<WaterMeterDao> waterMeterDaoProvider, Provider<WaterBillDao> waterBillDaoProvider,
      Provider<FirebaseFunctionsService> functionsServiceProvider) {
    return new RepositoryModule_ProvideWaterMeterRepositoryFactory(waterMeterDaoProvider, waterBillDaoProvider, functionsServiceProvider);
  }

  public static WaterMeterRepository provideWaterMeterRepository(WaterMeterDao waterMeterDao,
      WaterBillDao waterBillDao, FirebaseFunctionsService functionsService) {
    return Preconditions.checkNotNullFromProvides(RepositoryModule.INSTANCE.provideWaterMeterRepository(waterMeterDao, waterBillDao, functionsService));
  }
}
