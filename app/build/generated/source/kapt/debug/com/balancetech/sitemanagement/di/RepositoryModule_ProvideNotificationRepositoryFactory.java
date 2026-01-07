package com.balancetech.sitemanagement.di;

import com.balancetech.sitemanagement.data.dao.NotificationDao;
import com.balancetech.sitemanagement.data.repository.NotificationRepository;
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
public final class RepositoryModule_ProvideNotificationRepositoryFactory implements Factory<NotificationRepository> {
  private final Provider<NotificationDao> notificationDaoProvider;

  public RepositoryModule_ProvideNotificationRepositoryFactory(
      Provider<NotificationDao> notificationDaoProvider) {
    this.notificationDaoProvider = notificationDaoProvider;
  }

  @Override
  public NotificationRepository get() {
    return provideNotificationRepository(notificationDaoProvider.get());
  }

  public static RepositoryModule_ProvideNotificationRepositoryFactory create(
      Provider<NotificationDao> notificationDaoProvider) {
    return new RepositoryModule_ProvideNotificationRepositoryFactory(notificationDaoProvider);
  }

  public static NotificationRepository provideNotificationRepository(
      NotificationDao notificationDao) {
    return Preconditions.checkNotNullFromProvides(RepositoryModule.INSTANCE.provideNotificationRepository(notificationDao));
  }
}
