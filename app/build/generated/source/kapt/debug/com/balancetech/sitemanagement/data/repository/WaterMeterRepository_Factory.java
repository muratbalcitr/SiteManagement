package com.balancetech.sitemanagement.data.repository;

import com.balancetech.sitemanagement.data.dao.WaterBillDao;
import com.balancetech.sitemanagement.data.dao.WaterMeterDao;
import com.balancetech.sitemanagement.data.datasource.RemoteDataSource;
import com.balancetech.sitemanagement.data.service.FirebaseFunctionsService;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
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
public final class WaterMeterRepository_Factory implements Factory<WaterMeterRepository> {
  private final Provider<WaterMeterDao> waterMeterDaoProvider;

  private final Provider<WaterBillDao> waterBillDaoProvider;

  private final Provider<FirebaseFunctionsService> functionsServiceProvider;

  private final Provider<RemoteDataSource> remoteDataSourceProvider;

  public WaterMeterRepository_Factory(Provider<WaterMeterDao> waterMeterDaoProvider,
      Provider<WaterBillDao> waterBillDaoProvider,
      Provider<FirebaseFunctionsService> functionsServiceProvider,
      Provider<RemoteDataSource> remoteDataSourceProvider) {
    this.waterMeterDaoProvider = waterMeterDaoProvider;
    this.waterBillDaoProvider = waterBillDaoProvider;
    this.functionsServiceProvider = functionsServiceProvider;
    this.remoteDataSourceProvider = remoteDataSourceProvider;
  }

  @Override
  public WaterMeterRepository get() {
    return newInstance(waterMeterDaoProvider.get(), waterBillDaoProvider.get(), functionsServiceProvider.get(), remoteDataSourceProvider.get());
  }

  public static WaterMeterRepository_Factory create(Provider<WaterMeterDao> waterMeterDaoProvider,
      Provider<WaterBillDao> waterBillDaoProvider,
      Provider<FirebaseFunctionsService> functionsServiceProvider,
      Provider<RemoteDataSource> remoteDataSourceProvider) {
    return new WaterMeterRepository_Factory(waterMeterDaoProvider, waterBillDaoProvider, functionsServiceProvider, remoteDataSourceProvider);
  }

  public static WaterMeterRepository newInstance(WaterMeterDao waterMeterDao,
      WaterBillDao waterBillDao, FirebaseFunctionsService functionsService,
      RemoteDataSource remoteDataSource) {
    return new WaterMeterRepository(waterMeterDao, waterBillDao, functionsService, remoteDataSource);
  }
}
