package com.balancetech.sitemanagement.data.datasource;

import com.balancetech.sitemanagement.data.dao.FeeDao;
import com.balancetech.sitemanagement.data.dao.NotificationDao;
import com.balancetech.sitemanagement.data.dao.PaymentDao;
import com.balancetech.sitemanagement.data.dao.UnitDao;
import com.balancetech.sitemanagement.data.dao.UserDao;
import com.balancetech.sitemanagement.data.dao.WaterBillDao;
import com.balancetech.sitemanagement.data.dao.WaterMeterDao;
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
public final class LocalDataSourceImpl_Factory implements Factory<LocalDataSourceImpl> {
  private final Provider<UserDao> userDaoProvider;

  private final Provider<FeeDao> feeDaoProvider;

  private final Provider<PaymentDao> paymentDaoProvider;

  private final Provider<WaterMeterDao> waterMeterDaoProvider;

  private final Provider<WaterBillDao> waterBillDaoProvider;

  private final Provider<NotificationDao> notificationDaoProvider;

  private final Provider<UnitDao> unitDaoProvider;

  public LocalDataSourceImpl_Factory(Provider<UserDao> userDaoProvider,
      Provider<FeeDao> feeDaoProvider, Provider<PaymentDao> paymentDaoProvider,
      Provider<WaterMeterDao> waterMeterDaoProvider, Provider<WaterBillDao> waterBillDaoProvider,
      Provider<NotificationDao> notificationDaoProvider, Provider<UnitDao> unitDaoProvider) {
    this.userDaoProvider = userDaoProvider;
    this.feeDaoProvider = feeDaoProvider;
    this.paymentDaoProvider = paymentDaoProvider;
    this.waterMeterDaoProvider = waterMeterDaoProvider;
    this.waterBillDaoProvider = waterBillDaoProvider;
    this.notificationDaoProvider = notificationDaoProvider;
    this.unitDaoProvider = unitDaoProvider;
  }

  @Override
  public LocalDataSourceImpl get() {
    return newInstance(userDaoProvider.get(), feeDaoProvider.get(), paymentDaoProvider.get(), waterMeterDaoProvider.get(), waterBillDaoProvider.get(), notificationDaoProvider.get(), unitDaoProvider.get());
  }

  public static LocalDataSourceImpl_Factory create(Provider<UserDao> userDaoProvider,
      Provider<FeeDao> feeDaoProvider, Provider<PaymentDao> paymentDaoProvider,
      Provider<WaterMeterDao> waterMeterDaoProvider, Provider<WaterBillDao> waterBillDaoProvider,
      Provider<NotificationDao> notificationDaoProvider, Provider<UnitDao> unitDaoProvider) {
    return new LocalDataSourceImpl_Factory(userDaoProvider, feeDaoProvider, paymentDaoProvider, waterMeterDaoProvider, waterBillDaoProvider, notificationDaoProvider, unitDaoProvider);
  }

  public static LocalDataSourceImpl newInstance(UserDao userDao, FeeDao feeDao,
      PaymentDao paymentDao, WaterMeterDao waterMeterDao, WaterBillDao waterBillDao,
      NotificationDao notificationDao, UnitDao unitDao) {
    return new LocalDataSourceImpl(userDao, feeDao, paymentDao, waterMeterDao, waterBillDao, notificationDao, unitDao);
  }
}
