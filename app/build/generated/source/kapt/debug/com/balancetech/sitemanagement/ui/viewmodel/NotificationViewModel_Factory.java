package com.balancetech.sitemanagement.ui.viewmodel;

import com.balancetech.sitemanagement.data.repository.AuthRepository;
import com.balancetech.sitemanagement.data.repository.NotificationRepository;
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
public final class NotificationViewModel_Factory implements Factory<NotificationViewModel> {
  private final Provider<NotificationRepository> notificationRepositoryProvider;

  private final Provider<AuthRepository> authRepositoryProvider;

  public NotificationViewModel_Factory(
      Provider<NotificationRepository> notificationRepositoryProvider,
      Provider<AuthRepository> authRepositoryProvider) {
    this.notificationRepositoryProvider = notificationRepositoryProvider;
    this.authRepositoryProvider = authRepositoryProvider;
  }

  @Override
  public NotificationViewModel get() {
    return newInstance(notificationRepositoryProvider.get(), authRepositoryProvider.get());
  }

  public static NotificationViewModel_Factory create(
      Provider<NotificationRepository> notificationRepositoryProvider,
      Provider<AuthRepository> authRepositoryProvider) {
    return new NotificationViewModel_Factory(notificationRepositoryProvider, authRepositoryProvider);
  }

  public static NotificationViewModel newInstance(NotificationRepository notificationRepository,
      AuthRepository authRepository) {
    return new NotificationViewModel(notificationRepository, authRepository);
  }
}
