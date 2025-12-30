package com.balancetech.sitemanagement;

import android.app.Activity;
import android.app.Service;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.SavedStateHandle;
import androidx.lifecycle.ViewModel;
import com.balancetech.sitemanagement.data.dao.BlockDao;
import com.balancetech.sitemanagement.data.dao.ExtraPaymentDao;
import com.balancetech.sitemanagement.data.dao.FeeDao;
import com.balancetech.sitemanagement.data.dao.NotificationDao;
import com.balancetech.sitemanagement.data.dao.PaymentDao;
import com.balancetech.sitemanagement.data.dao.UnitDao;
import com.balancetech.sitemanagement.data.dao.UserDao;
import com.balancetech.sitemanagement.data.dao.WaterBillDao;
import com.balancetech.sitemanagement.data.dao.WaterMeterDao;
import com.balancetech.sitemanagement.data.database.AppDatabase;
import com.balancetech.sitemanagement.data.datasource.LocalDataSource;
import com.balancetech.sitemanagement.data.datasource.LocalDataSourceImpl;
import com.balancetech.sitemanagement.data.datasource.RemoteDataSource;
import com.balancetech.sitemanagement.data.datasource.RemoteDataSourceImpl;
import com.balancetech.sitemanagement.data.repository.AuthRepository;
import com.balancetech.sitemanagement.data.repository.ExtraPaymentRepository;
import com.balancetech.sitemanagement.data.repository.FeeRepository;
import com.balancetech.sitemanagement.data.repository.NotificationRepository;
import com.balancetech.sitemanagement.data.repository.PaymentRepository;
import com.balancetech.sitemanagement.data.repository.SyncRepository;
import com.balancetech.sitemanagement.data.repository.UserRepository;
import com.balancetech.sitemanagement.data.repository.WaterMeterRepository;
import com.balancetech.sitemanagement.data.service.FirebaseFunctionsService;
import com.balancetech.sitemanagement.di.DataSourceModule;
import com.balancetech.sitemanagement.di.DataSourceModule_ProvideLocalDataSourceFactory;
import com.balancetech.sitemanagement.di.DataSourceModule_ProvideRemoteDataSourceFactory;
import com.balancetech.sitemanagement.di.DatabaseModule;
import com.balancetech.sitemanagement.di.DatabaseModule_ProvideAppDatabaseFactory;
import com.balancetech.sitemanagement.di.DatabaseModule_ProvideBlockDaoFactory;
import com.balancetech.sitemanagement.di.DatabaseModule_ProvideExtraPaymentDaoFactory;
import com.balancetech.sitemanagement.di.DatabaseModule_ProvideFeeDaoFactory;
import com.balancetech.sitemanagement.di.DatabaseModule_ProvideNotificationDaoFactory;
import com.balancetech.sitemanagement.di.DatabaseModule_ProvidePaymentDaoFactory;
import com.balancetech.sitemanagement.di.DatabaseModule_ProvideUnitDaoFactory;
import com.balancetech.sitemanagement.di.DatabaseModule_ProvideUserDaoFactory;
import com.balancetech.sitemanagement.di.DatabaseModule_ProvideWaterBillDaoFactory;
import com.balancetech.sitemanagement.di.DatabaseModule_ProvideWaterMeterDaoFactory;
import com.balancetech.sitemanagement.di.FirebaseModule;
import com.balancetech.sitemanagement.di.FirebaseModule_ProvideFirebaseAuthFactory;
import com.balancetech.sitemanagement.di.FirebaseModule_ProvideFirebaseFirestoreFactory;
import com.balancetech.sitemanagement.di.FirebaseModule_ProvideFirebaseFunctionsFactory;
import com.balancetech.sitemanagement.di.FirebaseModule_ProvideFirebaseFunctionsServiceFactory;
import com.balancetech.sitemanagement.di.RepositoryModule;
import com.balancetech.sitemanagement.di.RepositoryModule_ProvideAuthRepositoryFactory;
import com.balancetech.sitemanagement.di.RepositoryModule_ProvideExtraPaymentRepositoryFactory;
import com.balancetech.sitemanagement.di.RepositoryModule_ProvideFeeRepositoryFactory;
import com.balancetech.sitemanagement.di.RepositoryModule_ProvideNotificationRepositoryFactory;
import com.balancetech.sitemanagement.di.RepositoryModule_ProvidePaymentRepositoryFactory;
import com.balancetech.sitemanagement.di.RepositoryModule_ProvideSyncRepositoryFactory;
import com.balancetech.sitemanagement.di.RepositoryModule_ProvideUserRepositoryFactory;
import com.balancetech.sitemanagement.di.RepositoryModule_ProvideWaterMeterRepositoryFactory;
import com.balancetech.sitemanagement.ui.auth.LoginFragment;
import com.balancetech.sitemanagement.ui.auth.RegisterFragment;
import com.balancetech.sitemanagement.ui.dashboard.DashboardFragment;
import com.balancetech.sitemanagement.ui.dialog.AddUserDialogFragment;
import com.balancetech.sitemanagement.ui.dialog.CreateExtraPaymentDialogFragment;
import com.balancetech.sitemanagement.ui.dialog.CreateFeeDialogFragment;
import com.balancetech.sitemanagement.ui.dialog.CreateFeesForAllUnitsDialogFragment;
import com.balancetech.sitemanagement.ui.dialog.EditUserDialogFragment;
import com.balancetech.sitemanagement.ui.dialog.PaymentEntryDialogFragment;
import com.balancetech.sitemanagement.ui.dialog.WaterMeterReadingDialogFragment;
import com.balancetech.sitemanagement.ui.extrapayments.ExtraPaymentsFragment;
import com.balancetech.sitemanagement.ui.fees.FeesFragment;
import com.balancetech.sitemanagement.ui.notifications.NotificationsFragment;
import com.balancetech.sitemanagement.ui.payments.PaymentsFragment;
import com.balancetech.sitemanagement.ui.reports.ReportsFragment;
import com.balancetech.sitemanagement.ui.users.UserDetailFragment;
import com.balancetech.sitemanagement.ui.users.UsersFragment;
import com.balancetech.sitemanagement.ui.viewmodel.AuthViewModel;
import com.balancetech.sitemanagement.ui.viewmodel.AuthViewModel_HiltModules_KeyModule_ProvideFactory;
import com.balancetech.sitemanagement.ui.viewmodel.DashboardViewModel;
import com.balancetech.sitemanagement.ui.viewmodel.DashboardViewModel_HiltModules_KeyModule_ProvideFactory;
import com.balancetech.sitemanagement.ui.viewmodel.ExtraPaymentViewModel;
import com.balancetech.sitemanagement.ui.viewmodel.ExtraPaymentViewModel_HiltModules_KeyModule_ProvideFactory;
import com.balancetech.sitemanagement.ui.viewmodel.FeeViewModel;
import com.balancetech.sitemanagement.ui.viewmodel.FeeViewModel_HiltModules_KeyModule_ProvideFactory;
import com.balancetech.sitemanagement.ui.viewmodel.NotificationViewModel;
import com.balancetech.sitemanagement.ui.viewmodel.NotificationViewModel_HiltModules_KeyModule_ProvideFactory;
import com.balancetech.sitemanagement.ui.viewmodel.PaymentViewModel;
import com.balancetech.sitemanagement.ui.viewmodel.PaymentViewModel_HiltModules_KeyModule_ProvideFactory;
import com.balancetech.sitemanagement.ui.viewmodel.ReportsViewModel;
import com.balancetech.sitemanagement.ui.viewmodel.ReportsViewModel_HiltModules_KeyModule_ProvideFactory;
import com.balancetech.sitemanagement.ui.viewmodel.UserDetailViewModel;
import com.balancetech.sitemanagement.ui.viewmodel.UserDetailViewModel_HiltModules_KeyModule_ProvideFactory;
import com.balancetech.sitemanagement.ui.viewmodel.UserViewModel;
import com.balancetech.sitemanagement.ui.viewmodel.UserViewModel_HiltModules_KeyModule_ProvideFactory;
import com.balancetech.sitemanagement.ui.viewmodel.WaterMeterViewModel;
import com.balancetech.sitemanagement.ui.viewmodel.WaterMeterViewModel_HiltModules_KeyModule_ProvideFactory;
import com.balancetech.sitemanagement.ui.watermeter.WaterMeterFragment;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.functions.FirebaseFunctions;
import dagger.hilt.android.ActivityRetainedLifecycle;
import dagger.hilt.android.ViewModelLifecycle;
import dagger.hilt.android.flags.HiltWrapper_FragmentGetContextFix_FragmentGetContextFixModule;
import dagger.hilt.android.internal.builders.ActivityComponentBuilder;
import dagger.hilt.android.internal.builders.ActivityRetainedComponentBuilder;
import dagger.hilt.android.internal.builders.FragmentComponentBuilder;
import dagger.hilt.android.internal.builders.ServiceComponentBuilder;
import dagger.hilt.android.internal.builders.ViewComponentBuilder;
import dagger.hilt.android.internal.builders.ViewModelComponentBuilder;
import dagger.hilt.android.internal.builders.ViewWithFragmentComponentBuilder;
import dagger.hilt.android.internal.lifecycle.DefaultViewModelFactories;
import dagger.hilt.android.internal.lifecycle.DefaultViewModelFactories_InternalFactoryFactory_Factory;
import dagger.hilt.android.internal.managers.ActivityRetainedComponentManager_LifecycleModule_ProvideActivityRetainedLifecycleFactory;
import dagger.hilt.android.internal.modules.ApplicationContextModule;
import dagger.hilt.android.internal.modules.ApplicationContextModule_ProvideContextFactory;
import dagger.internal.DaggerGenerated;
import dagger.internal.DoubleCheck;
import dagger.internal.Preconditions;
import java.util.Map;
import java.util.Set;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

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
public final class DaggerSiteManagementApplication_HiltComponents_SingletonC {
  private DaggerSiteManagementApplication_HiltComponents_SingletonC() {
  }

  public static Builder builder() {
    return new Builder();
  }

  public static final class Builder {
    private ApplicationContextModule applicationContextModule;

    private Builder() {
    }

    public Builder applicationContextModule(ApplicationContextModule applicationContextModule) {
      this.applicationContextModule = Preconditions.checkNotNull(applicationContextModule);
      return this;
    }

    /**
     * @deprecated This module is declared, but an instance is not used in the component. This method is a no-op. For more, see https://dagger.dev/unused-modules.
     */
    @Deprecated
    public Builder dataSourceModule(DataSourceModule dataSourceModule) {
      Preconditions.checkNotNull(dataSourceModule);
      return this;
    }

    /**
     * @deprecated This module is declared, but an instance is not used in the component. This method is a no-op. For more, see https://dagger.dev/unused-modules.
     */
    @Deprecated
    public Builder databaseModule(DatabaseModule databaseModule) {
      Preconditions.checkNotNull(databaseModule);
      return this;
    }

    /**
     * @deprecated This module is declared, but an instance is not used in the component. This method is a no-op. For more, see https://dagger.dev/unused-modules.
     */
    @Deprecated
    public Builder firebaseModule(FirebaseModule firebaseModule) {
      Preconditions.checkNotNull(firebaseModule);
      return this;
    }

    /**
     * @deprecated This module is declared, but an instance is not used in the component. This method is a no-op. For more, see https://dagger.dev/unused-modules.
     */
    @Deprecated
    public Builder hiltWrapper_FragmentGetContextFix_FragmentGetContextFixModule(
        HiltWrapper_FragmentGetContextFix_FragmentGetContextFixModule hiltWrapper_FragmentGetContextFix_FragmentGetContextFixModule) {
      Preconditions.checkNotNull(hiltWrapper_FragmentGetContextFix_FragmentGetContextFixModule);
      return this;
    }

    /**
     * @deprecated This module is declared, but an instance is not used in the component. This method is a no-op. For more, see https://dagger.dev/unused-modules.
     */
    @Deprecated
    public Builder repositoryModule(RepositoryModule repositoryModule) {
      Preconditions.checkNotNull(repositoryModule);
      return this;
    }

    public SiteManagementApplication_HiltComponents.SingletonC build() {
      Preconditions.checkBuilderRequirement(applicationContextModule, ApplicationContextModule.class);
      return new SingletonCImpl(applicationContextModule);
    }
  }

  private static final class ActivityRetainedCBuilder implements SiteManagementApplication_HiltComponents.ActivityRetainedC.Builder {
    private final SingletonCImpl singletonCImpl;

    private ActivityRetainedCBuilder(SingletonCImpl singletonCImpl) {
      this.singletonCImpl = singletonCImpl;
    }

    @Override
    public SiteManagementApplication_HiltComponents.ActivityRetainedC build() {
      return new ActivityRetainedCImpl(singletonCImpl);
    }
  }

  private static final class ActivityCBuilder implements SiteManagementApplication_HiltComponents.ActivityC.Builder {
    private final SingletonCImpl singletonCImpl;

    private final ActivityRetainedCImpl activityRetainedCImpl;

    private Activity activity;

    private ActivityCBuilder(SingletonCImpl singletonCImpl,
        ActivityRetainedCImpl activityRetainedCImpl) {
      this.singletonCImpl = singletonCImpl;
      this.activityRetainedCImpl = activityRetainedCImpl;
    }

    @Override
    public ActivityCBuilder activity(Activity activity) {
      this.activity = Preconditions.checkNotNull(activity);
      return this;
    }

    @Override
    public SiteManagementApplication_HiltComponents.ActivityC build() {
      Preconditions.checkBuilderRequirement(activity, Activity.class);
      return new ActivityCImpl(singletonCImpl, activityRetainedCImpl, activity);
    }
  }

  private static final class FragmentCBuilder implements SiteManagementApplication_HiltComponents.FragmentC.Builder {
    private final SingletonCImpl singletonCImpl;

    private final ActivityRetainedCImpl activityRetainedCImpl;

    private final ActivityCImpl activityCImpl;

    private Fragment fragment;

    private FragmentCBuilder(SingletonCImpl singletonCImpl,
        ActivityRetainedCImpl activityRetainedCImpl, ActivityCImpl activityCImpl) {
      this.singletonCImpl = singletonCImpl;
      this.activityRetainedCImpl = activityRetainedCImpl;
      this.activityCImpl = activityCImpl;
    }

    @Override
    public FragmentCBuilder fragment(Fragment fragment) {
      this.fragment = Preconditions.checkNotNull(fragment);
      return this;
    }

    @Override
    public SiteManagementApplication_HiltComponents.FragmentC build() {
      Preconditions.checkBuilderRequirement(fragment, Fragment.class);
      return new FragmentCImpl(singletonCImpl, activityRetainedCImpl, activityCImpl, fragment);
    }
  }

  private static final class ViewWithFragmentCBuilder implements SiteManagementApplication_HiltComponents.ViewWithFragmentC.Builder {
    private final SingletonCImpl singletonCImpl;

    private final ActivityRetainedCImpl activityRetainedCImpl;

    private final ActivityCImpl activityCImpl;

    private final FragmentCImpl fragmentCImpl;

    private View view;

    private ViewWithFragmentCBuilder(SingletonCImpl singletonCImpl,
        ActivityRetainedCImpl activityRetainedCImpl, ActivityCImpl activityCImpl,
        FragmentCImpl fragmentCImpl) {
      this.singletonCImpl = singletonCImpl;
      this.activityRetainedCImpl = activityRetainedCImpl;
      this.activityCImpl = activityCImpl;
      this.fragmentCImpl = fragmentCImpl;
    }

    @Override
    public ViewWithFragmentCBuilder view(View view) {
      this.view = Preconditions.checkNotNull(view);
      return this;
    }

    @Override
    public SiteManagementApplication_HiltComponents.ViewWithFragmentC build() {
      Preconditions.checkBuilderRequirement(view, View.class);
      return new ViewWithFragmentCImpl(singletonCImpl, activityRetainedCImpl, activityCImpl, fragmentCImpl, view);
    }
  }

  private static final class ViewCBuilder implements SiteManagementApplication_HiltComponents.ViewC.Builder {
    private final SingletonCImpl singletonCImpl;

    private final ActivityRetainedCImpl activityRetainedCImpl;

    private final ActivityCImpl activityCImpl;

    private View view;

    private ViewCBuilder(SingletonCImpl singletonCImpl, ActivityRetainedCImpl activityRetainedCImpl,
        ActivityCImpl activityCImpl) {
      this.singletonCImpl = singletonCImpl;
      this.activityRetainedCImpl = activityRetainedCImpl;
      this.activityCImpl = activityCImpl;
    }

    @Override
    public ViewCBuilder view(View view) {
      this.view = Preconditions.checkNotNull(view);
      return this;
    }

    @Override
    public SiteManagementApplication_HiltComponents.ViewC build() {
      Preconditions.checkBuilderRequirement(view, View.class);
      return new ViewCImpl(singletonCImpl, activityRetainedCImpl, activityCImpl, view);
    }
  }

  private static final class ViewModelCBuilder implements SiteManagementApplication_HiltComponents.ViewModelC.Builder {
    private final SingletonCImpl singletonCImpl;

    private final ActivityRetainedCImpl activityRetainedCImpl;

    private SavedStateHandle savedStateHandle;

    private ViewModelLifecycle viewModelLifecycle;

    private ViewModelCBuilder(SingletonCImpl singletonCImpl,
        ActivityRetainedCImpl activityRetainedCImpl) {
      this.singletonCImpl = singletonCImpl;
      this.activityRetainedCImpl = activityRetainedCImpl;
    }

    @Override
    public ViewModelCBuilder savedStateHandle(SavedStateHandle handle) {
      this.savedStateHandle = Preconditions.checkNotNull(handle);
      return this;
    }

    @Override
    public ViewModelCBuilder viewModelLifecycle(ViewModelLifecycle viewModelLifecycle) {
      this.viewModelLifecycle = Preconditions.checkNotNull(viewModelLifecycle);
      return this;
    }

    @Override
    public SiteManagementApplication_HiltComponents.ViewModelC build() {
      Preconditions.checkBuilderRequirement(savedStateHandle, SavedStateHandle.class);
      Preconditions.checkBuilderRequirement(viewModelLifecycle, ViewModelLifecycle.class);
      return new ViewModelCImpl(singletonCImpl, activityRetainedCImpl, savedStateHandle, viewModelLifecycle);
    }
  }

  private static final class ServiceCBuilder implements SiteManagementApplication_HiltComponents.ServiceC.Builder {
    private final SingletonCImpl singletonCImpl;

    private Service service;

    private ServiceCBuilder(SingletonCImpl singletonCImpl) {
      this.singletonCImpl = singletonCImpl;
    }

    @Override
    public ServiceCBuilder service(Service service) {
      this.service = Preconditions.checkNotNull(service);
      return this;
    }

    @Override
    public SiteManagementApplication_HiltComponents.ServiceC build() {
      Preconditions.checkBuilderRequirement(service, Service.class);
      return new ServiceCImpl(singletonCImpl, service);
    }
  }

  private static final class ViewWithFragmentCImpl extends SiteManagementApplication_HiltComponents.ViewWithFragmentC {
    private final SingletonCImpl singletonCImpl;

    private final ActivityRetainedCImpl activityRetainedCImpl;

    private final ActivityCImpl activityCImpl;

    private final FragmentCImpl fragmentCImpl;

    private final ViewWithFragmentCImpl viewWithFragmentCImpl = this;

    private ViewWithFragmentCImpl(SingletonCImpl singletonCImpl,
        ActivityRetainedCImpl activityRetainedCImpl, ActivityCImpl activityCImpl,
        FragmentCImpl fragmentCImpl, View viewParam) {
      this.singletonCImpl = singletonCImpl;
      this.activityRetainedCImpl = activityRetainedCImpl;
      this.activityCImpl = activityCImpl;
      this.fragmentCImpl = fragmentCImpl;


    }
  }

  private static final class FragmentCImpl extends SiteManagementApplication_HiltComponents.FragmentC {
    private final SingletonCImpl singletonCImpl;

    private final ActivityRetainedCImpl activityRetainedCImpl;

    private final ActivityCImpl activityCImpl;

    private final FragmentCImpl fragmentCImpl = this;

    private FragmentCImpl(SingletonCImpl singletonCImpl,
        ActivityRetainedCImpl activityRetainedCImpl, ActivityCImpl activityCImpl,
        Fragment fragmentParam) {
      this.singletonCImpl = singletonCImpl;
      this.activityRetainedCImpl = activityRetainedCImpl;
      this.activityCImpl = activityCImpl;


    }

    @Override
    public void injectLoginFragment(LoginFragment loginFragment) {
    }

    @Override
    public void injectRegisterFragment(RegisterFragment registerFragment) {
    }

    @Override
    public void injectDashboardFragment(DashboardFragment dashboardFragment) {
    }

    @Override
    public void injectAddUserDialogFragment(AddUserDialogFragment addUserDialogFragment) {
    }

    @Override
    public void injectCreateExtraPaymentDialogFragment(
        CreateExtraPaymentDialogFragment createExtraPaymentDialogFragment) {
    }

    @Override
    public void injectCreateFeeDialogFragment(CreateFeeDialogFragment createFeeDialogFragment) {
    }

    @Override
    public void injectCreateFeesForAllUnitsDialogFragment(
        CreateFeesForAllUnitsDialogFragment createFeesForAllUnitsDialogFragment) {
    }

    @Override
    public void injectEditUserDialogFragment(EditUserDialogFragment editUserDialogFragment) {
    }

    @Override
    public void injectPaymentEntryDialogFragment(
        PaymentEntryDialogFragment paymentEntryDialogFragment) {
    }

    @Override
    public void injectWaterMeterReadingDialogFragment(
        WaterMeterReadingDialogFragment waterMeterReadingDialogFragment) {
    }

    @Override
    public void injectExtraPaymentsFragment(ExtraPaymentsFragment extraPaymentsFragment) {
    }

    @Override
    public void injectFeesFragment(FeesFragment feesFragment) {
    }

    @Override
    public void injectNotificationsFragment(NotificationsFragment notificationsFragment) {
    }

    @Override
    public void injectPaymentsFragment(PaymentsFragment paymentsFragment) {
    }

    @Override
    public void injectReportsFragment(ReportsFragment reportsFragment) {
    }

    @Override
    public void injectUserDetailFragment(UserDetailFragment userDetailFragment) {
    }

    @Override
    public void injectUsersFragment(UsersFragment usersFragment) {
    }

    @Override
    public void injectWaterMeterFragment(WaterMeterFragment waterMeterFragment) {
    }

    @Override
    public DefaultViewModelFactories.InternalFactoryFactory getHiltInternalFactoryFactory() {
      return activityCImpl.getHiltInternalFactoryFactory();
    }

    @Override
    public ViewWithFragmentComponentBuilder viewWithFragmentComponentBuilder() {
      return new ViewWithFragmentCBuilder(singletonCImpl, activityRetainedCImpl, activityCImpl, fragmentCImpl);
    }
  }

  private static final class ViewCImpl extends SiteManagementApplication_HiltComponents.ViewC {
    private final SingletonCImpl singletonCImpl;

    private final ActivityRetainedCImpl activityRetainedCImpl;

    private final ActivityCImpl activityCImpl;

    private final ViewCImpl viewCImpl = this;

    private ViewCImpl(SingletonCImpl singletonCImpl, ActivityRetainedCImpl activityRetainedCImpl,
        ActivityCImpl activityCImpl, View viewParam) {
      this.singletonCImpl = singletonCImpl;
      this.activityRetainedCImpl = activityRetainedCImpl;
      this.activityCImpl = activityCImpl;


    }
  }

  private static final class ActivityCImpl extends SiteManagementApplication_HiltComponents.ActivityC {
    private final SingletonCImpl singletonCImpl;

    private final ActivityRetainedCImpl activityRetainedCImpl;

    private final ActivityCImpl activityCImpl = this;

    private ActivityCImpl(SingletonCImpl singletonCImpl,
        ActivityRetainedCImpl activityRetainedCImpl, Activity activityParam) {
      this.singletonCImpl = singletonCImpl;
      this.activityRetainedCImpl = activityRetainedCImpl;


    }

    @Override
    public void injectMainActivity(MainActivity mainActivity) {
    }

    @Override
    public DefaultViewModelFactories.InternalFactoryFactory getHiltInternalFactoryFactory() {
      return DefaultViewModelFactories_InternalFactoryFactory_Factory.newInstance(getViewModelKeys(), new ViewModelCBuilder(singletonCImpl, activityRetainedCImpl));
    }

    @Override
    public Set<String> getViewModelKeys() {
      return ImmutableSet.<String>of(AuthViewModel_HiltModules_KeyModule_ProvideFactory.provide(), DashboardViewModel_HiltModules_KeyModule_ProvideFactory.provide(), ExtraPaymentViewModel_HiltModules_KeyModule_ProvideFactory.provide(), FeeViewModel_HiltModules_KeyModule_ProvideFactory.provide(), NotificationViewModel_HiltModules_KeyModule_ProvideFactory.provide(), PaymentViewModel_HiltModules_KeyModule_ProvideFactory.provide(), ReportsViewModel_HiltModules_KeyModule_ProvideFactory.provide(), UserDetailViewModel_HiltModules_KeyModule_ProvideFactory.provide(), UserViewModel_HiltModules_KeyModule_ProvideFactory.provide(), WaterMeterViewModel_HiltModules_KeyModule_ProvideFactory.provide());
    }

    @Override
    public ViewModelComponentBuilder getViewModelComponentBuilder() {
      return new ViewModelCBuilder(singletonCImpl, activityRetainedCImpl);
    }

    @Override
    public FragmentComponentBuilder fragmentComponentBuilder() {
      return new FragmentCBuilder(singletonCImpl, activityRetainedCImpl, activityCImpl);
    }

    @Override
    public ViewComponentBuilder viewComponentBuilder() {
      return new ViewCBuilder(singletonCImpl, activityRetainedCImpl, activityCImpl);
    }
  }

  private static final class ViewModelCImpl extends SiteManagementApplication_HiltComponents.ViewModelC {
    private final SingletonCImpl singletonCImpl;

    private final ActivityRetainedCImpl activityRetainedCImpl;

    private final ViewModelCImpl viewModelCImpl = this;

    private Provider<AuthViewModel> authViewModelProvider;

    private Provider<DashboardViewModel> dashboardViewModelProvider;

    private Provider<ExtraPaymentViewModel> extraPaymentViewModelProvider;

    private Provider<FeeViewModel> feeViewModelProvider;

    private Provider<NotificationViewModel> notificationViewModelProvider;

    private Provider<PaymentViewModel> paymentViewModelProvider;

    private Provider<ReportsViewModel> reportsViewModelProvider;

    private Provider<UserDetailViewModel> userDetailViewModelProvider;

    private Provider<UserViewModel> userViewModelProvider;

    private Provider<WaterMeterViewModel> waterMeterViewModelProvider;

    private ViewModelCImpl(SingletonCImpl singletonCImpl,
        ActivityRetainedCImpl activityRetainedCImpl, SavedStateHandle savedStateHandleParam,
        ViewModelLifecycle viewModelLifecycleParam) {
      this.singletonCImpl = singletonCImpl;
      this.activityRetainedCImpl = activityRetainedCImpl;

      initialize(savedStateHandleParam, viewModelLifecycleParam);

    }

    @SuppressWarnings("unchecked")
    private void initialize(final SavedStateHandle savedStateHandleParam,
        final ViewModelLifecycle viewModelLifecycleParam) {
      this.authViewModelProvider = new SwitchingProvider<>(singletonCImpl, activityRetainedCImpl, viewModelCImpl, 0);
      this.dashboardViewModelProvider = new SwitchingProvider<>(singletonCImpl, activityRetainedCImpl, viewModelCImpl, 1);
      this.extraPaymentViewModelProvider = new SwitchingProvider<>(singletonCImpl, activityRetainedCImpl, viewModelCImpl, 2);
      this.feeViewModelProvider = new SwitchingProvider<>(singletonCImpl, activityRetainedCImpl, viewModelCImpl, 3);
      this.notificationViewModelProvider = new SwitchingProvider<>(singletonCImpl, activityRetainedCImpl, viewModelCImpl, 4);
      this.paymentViewModelProvider = new SwitchingProvider<>(singletonCImpl, activityRetainedCImpl, viewModelCImpl, 5);
      this.reportsViewModelProvider = new SwitchingProvider<>(singletonCImpl, activityRetainedCImpl, viewModelCImpl, 6);
      this.userDetailViewModelProvider = new SwitchingProvider<>(singletonCImpl, activityRetainedCImpl, viewModelCImpl, 7);
      this.userViewModelProvider = new SwitchingProvider<>(singletonCImpl, activityRetainedCImpl, viewModelCImpl, 8);
      this.waterMeterViewModelProvider = new SwitchingProvider<>(singletonCImpl, activityRetainedCImpl, viewModelCImpl, 9);
    }

    @Override
    public Map<String, Provider<ViewModel>> getHiltViewModelMap() {
      return ImmutableMap.<String, Provider<ViewModel>>builderWithExpectedSize(10).put("com.balancetech.sitemanagement.ui.viewmodel.AuthViewModel", ((Provider) authViewModelProvider)).put("com.balancetech.sitemanagement.ui.viewmodel.DashboardViewModel", ((Provider) dashboardViewModelProvider)).put("com.balancetech.sitemanagement.ui.viewmodel.ExtraPaymentViewModel", ((Provider) extraPaymentViewModelProvider)).put("com.balancetech.sitemanagement.ui.viewmodel.FeeViewModel", ((Provider) feeViewModelProvider)).put("com.balancetech.sitemanagement.ui.viewmodel.NotificationViewModel", ((Provider) notificationViewModelProvider)).put("com.balancetech.sitemanagement.ui.viewmodel.PaymentViewModel", ((Provider) paymentViewModelProvider)).put("com.balancetech.sitemanagement.ui.viewmodel.ReportsViewModel", ((Provider) reportsViewModelProvider)).put("com.balancetech.sitemanagement.ui.viewmodel.UserDetailViewModel", ((Provider) userDetailViewModelProvider)).put("com.balancetech.sitemanagement.ui.viewmodel.UserViewModel", ((Provider) userViewModelProvider)).put("com.balancetech.sitemanagement.ui.viewmodel.WaterMeterViewModel", ((Provider) waterMeterViewModelProvider)).build();
    }

    private static final class SwitchingProvider<T> implements Provider<T> {
      private final SingletonCImpl singletonCImpl;

      private final ActivityRetainedCImpl activityRetainedCImpl;

      private final ViewModelCImpl viewModelCImpl;

      private final int id;

      SwitchingProvider(SingletonCImpl singletonCImpl, ActivityRetainedCImpl activityRetainedCImpl,
          ViewModelCImpl viewModelCImpl, int id) {
        this.singletonCImpl = singletonCImpl;
        this.activityRetainedCImpl = activityRetainedCImpl;
        this.viewModelCImpl = viewModelCImpl;
        this.id = id;
      }

      @SuppressWarnings("unchecked")
      @Override
      public T get() {
        switch (id) {
          case 0: // com.balancetech.sitemanagement.ui.viewmodel.AuthViewModel 
          return (T) new AuthViewModel(singletonCImpl.provideAuthRepositoryProvider.get());

          case 1: // com.balancetech.sitemanagement.ui.viewmodel.DashboardViewModel 
          return (T) new DashboardViewModel(singletonCImpl.provideAuthRepositoryProvider.get(), singletonCImpl.provideFeeRepositoryProvider.get(), singletonCImpl.providePaymentRepositoryProvider.get(), singletonCImpl.provideExtraPaymentRepositoryProvider.get(), singletonCImpl.provideWaterMeterRepositoryProvider.get(), singletonCImpl.provideSyncRepositoryProvider.get());

          case 2: // com.balancetech.sitemanagement.ui.viewmodel.ExtraPaymentViewModel 
          return (T) new ExtraPaymentViewModel(singletonCImpl.provideExtraPaymentRepositoryProvider.get());

          case 3: // com.balancetech.sitemanagement.ui.viewmodel.FeeViewModel 
          return (T) new FeeViewModel(singletonCImpl.provideFeeRepositoryProvider.get(), singletonCImpl.provideLocalDataSourceProvider.get());

          case 4: // com.balancetech.sitemanagement.ui.viewmodel.NotificationViewModel 
          return (T) new NotificationViewModel(singletonCImpl.provideNotificationRepositoryProvider.get(), singletonCImpl.provideAuthRepositoryProvider.get());

          case 5: // com.balancetech.sitemanagement.ui.viewmodel.PaymentViewModel 
          return (T) new PaymentViewModel(singletonCImpl.providePaymentRepositoryProvider.get(), singletonCImpl.provideFeeRepositoryProvider.get(), singletonCImpl.provideExtraPaymentRepositoryProvider.get(), singletonCImpl.provideWaterMeterRepositoryProvider.get(), singletonCImpl.provideAuthRepositoryProvider.get());

          case 6: // com.balancetech.sitemanagement.ui.viewmodel.ReportsViewModel 
          return (T) new ReportsViewModel(singletonCImpl.provideFeeRepositoryProvider.get(), singletonCImpl.provideWaterMeterRepositoryProvider.get());

          case 7: // com.balancetech.sitemanagement.ui.viewmodel.UserDetailViewModel 
          return (T) new UserDetailViewModel(singletonCImpl.provideFeeRepositoryProvider.get(), singletonCImpl.provideExtraPaymentRepositoryProvider.get(), singletonCImpl.provideWaterMeterRepositoryProvider.get(), singletonCImpl.providePaymentRepositoryProvider.get(), singletonCImpl.provideLocalDataSourceProvider.get());

          case 8: // com.balancetech.sitemanagement.ui.viewmodel.UserViewModel 
          return (T) new UserViewModel(singletonCImpl.provideUserRepositoryProvider.get(), singletonCImpl.provideLocalDataSourceProvider.get());

          case 9: // com.balancetech.sitemanagement.ui.viewmodel.WaterMeterViewModel 
          return (T) new WaterMeterViewModel(singletonCImpl.provideWaterMeterRepositoryProvider.get());

          default: throw new AssertionError(id);
        }
      }
    }
  }

  private static final class ActivityRetainedCImpl extends SiteManagementApplication_HiltComponents.ActivityRetainedC {
    private final SingletonCImpl singletonCImpl;

    private final ActivityRetainedCImpl activityRetainedCImpl = this;

    private Provider<ActivityRetainedLifecycle> provideActivityRetainedLifecycleProvider;

    private ActivityRetainedCImpl(SingletonCImpl singletonCImpl) {
      this.singletonCImpl = singletonCImpl;

      initialize();

    }

    @SuppressWarnings("unchecked")
    private void initialize() {
      this.provideActivityRetainedLifecycleProvider = DoubleCheck.provider(new SwitchingProvider<ActivityRetainedLifecycle>(singletonCImpl, activityRetainedCImpl, 0));
    }

    @Override
    public ActivityComponentBuilder activityComponentBuilder() {
      return new ActivityCBuilder(singletonCImpl, activityRetainedCImpl);
    }

    @Override
    public ActivityRetainedLifecycle getActivityRetainedLifecycle() {
      return provideActivityRetainedLifecycleProvider.get();
    }

    private static final class SwitchingProvider<T> implements Provider<T> {
      private final SingletonCImpl singletonCImpl;

      private final ActivityRetainedCImpl activityRetainedCImpl;

      private final int id;

      SwitchingProvider(SingletonCImpl singletonCImpl, ActivityRetainedCImpl activityRetainedCImpl,
          int id) {
        this.singletonCImpl = singletonCImpl;
        this.activityRetainedCImpl = activityRetainedCImpl;
        this.id = id;
      }

      @SuppressWarnings("unchecked")
      @Override
      public T get() {
        switch (id) {
          case 0: // dagger.hilt.android.ActivityRetainedLifecycle 
          return (T) ActivityRetainedComponentManager_LifecycleModule_ProvideActivityRetainedLifecycleFactory.provideActivityRetainedLifecycle();

          default: throw new AssertionError(id);
        }
      }
    }
  }

  private static final class ServiceCImpl extends SiteManagementApplication_HiltComponents.ServiceC {
    private final SingletonCImpl singletonCImpl;

    private final ServiceCImpl serviceCImpl = this;

    private ServiceCImpl(SingletonCImpl singletonCImpl, Service serviceParam) {
      this.singletonCImpl = singletonCImpl;


    }
  }

  private static final class SingletonCImpl extends SiteManagementApplication_HiltComponents.SingletonC {
    private final ApplicationContextModule applicationContextModule;

    private final SingletonCImpl singletonCImpl = this;

    private Provider<AppDatabase> provideAppDatabaseProvider;

    private Provider<FirebaseAuth> provideFirebaseAuthProvider;

    private Provider<LocalDataSource> provideLocalDataSourceProvider;

    private Provider<FirebaseFirestore> provideFirebaseFirestoreProvider;

    private Provider<RemoteDataSource> provideRemoteDataSourceProvider;

    private Provider<AuthRepository> provideAuthRepositoryProvider;

    private Provider<FirebaseFunctions> provideFirebaseFunctionsProvider;

    private Provider<FirebaseFunctionsService> provideFirebaseFunctionsServiceProvider;

    private Provider<FeeRepository> provideFeeRepositoryProvider;

    private Provider<PaymentRepository> providePaymentRepositoryProvider;

    private Provider<ExtraPaymentRepository> provideExtraPaymentRepositoryProvider;

    private Provider<WaterMeterRepository> provideWaterMeterRepositoryProvider;

    private Provider<SyncRepository> provideSyncRepositoryProvider;

    private Provider<NotificationRepository> provideNotificationRepositoryProvider;

    private Provider<UserRepository> provideUserRepositoryProvider;

    private SingletonCImpl(ApplicationContextModule applicationContextModuleParam) {
      this.applicationContextModule = applicationContextModuleParam;
      initialize(applicationContextModuleParam);

    }

    private UserDao userDao() {
      return DatabaseModule_ProvideUserDaoFactory.provideUserDao(provideAppDatabaseProvider.get());
    }

    private FeeDao feeDao() {
      return DatabaseModule_ProvideFeeDaoFactory.provideFeeDao(provideAppDatabaseProvider.get());
    }

    private PaymentDao paymentDao() {
      return DatabaseModule_ProvidePaymentDaoFactory.providePaymentDao(provideAppDatabaseProvider.get());
    }

    private WaterMeterDao waterMeterDao() {
      return DatabaseModule_ProvideWaterMeterDaoFactory.provideWaterMeterDao(provideAppDatabaseProvider.get());
    }

    private WaterBillDao waterBillDao() {
      return DatabaseModule_ProvideWaterBillDaoFactory.provideWaterBillDao(provideAppDatabaseProvider.get());
    }

    private NotificationDao notificationDao() {
      return DatabaseModule_ProvideNotificationDaoFactory.provideNotificationDao(provideAppDatabaseProvider.get());
    }

    private LocalDataSourceImpl localDataSourceImpl() {
      return new LocalDataSourceImpl(userDao(), feeDao(), paymentDao(), waterMeterDao(), waterBillDao(), notificationDao(), unitDao(), blockDao());
    }

    private RemoteDataSourceImpl remoteDataSourceImpl() {
      return new RemoteDataSourceImpl(provideFirebaseFirestoreProvider.get(), provideFirebaseAuthProvider.get());
    }

    private ExtraPaymentDao extraPaymentDao() {
      return DatabaseModule_ProvideExtraPaymentDaoFactory.provideExtraPaymentDao(provideAppDatabaseProvider.get());
    }

    @SuppressWarnings("unchecked")
    private void initialize(final ApplicationContextModule applicationContextModuleParam) {
      this.provideAppDatabaseProvider = DoubleCheck.provider(new SwitchingProvider<AppDatabase>(singletonCImpl, 0));
      this.provideFirebaseAuthProvider = DoubleCheck.provider(new SwitchingProvider<FirebaseAuth>(singletonCImpl, 2));
      this.provideLocalDataSourceProvider = DoubleCheck.provider(new SwitchingProvider<LocalDataSource>(singletonCImpl, 3));
      this.provideFirebaseFirestoreProvider = DoubleCheck.provider(new SwitchingProvider<FirebaseFirestore>(singletonCImpl, 5));
      this.provideRemoteDataSourceProvider = DoubleCheck.provider(new SwitchingProvider<RemoteDataSource>(singletonCImpl, 4));
      this.provideAuthRepositoryProvider = DoubleCheck.provider(new SwitchingProvider<AuthRepository>(singletonCImpl, 1));
      this.provideFirebaseFunctionsProvider = DoubleCheck.provider(new SwitchingProvider<FirebaseFunctions>(singletonCImpl, 8));
      this.provideFirebaseFunctionsServiceProvider = DoubleCheck.provider(new SwitchingProvider<FirebaseFunctionsService>(singletonCImpl, 7));
      this.provideFeeRepositoryProvider = DoubleCheck.provider(new SwitchingProvider<FeeRepository>(singletonCImpl, 6));
      this.providePaymentRepositoryProvider = DoubleCheck.provider(new SwitchingProvider<PaymentRepository>(singletonCImpl, 9));
      this.provideExtraPaymentRepositoryProvider = DoubleCheck.provider(new SwitchingProvider<ExtraPaymentRepository>(singletonCImpl, 10));
      this.provideWaterMeterRepositoryProvider = DoubleCheck.provider(new SwitchingProvider<WaterMeterRepository>(singletonCImpl, 11));
      this.provideSyncRepositoryProvider = DoubleCheck.provider(new SwitchingProvider<SyncRepository>(singletonCImpl, 12));
      this.provideNotificationRepositoryProvider = DoubleCheck.provider(new SwitchingProvider<NotificationRepository>(singletonCImpl, 13));
      this.provideUserRepositoryProvider = DoubleCheck.provider(new SwitchingProvider<UserRepository>(singletonCImpl, 14));
    }

    @Override
    public BlockDao blockDao() {
      return DatabaseModule_ProvideBlockDaoFactory.provideBlockDao(provideAppDatabaseProvider.get());
    }

    @Override
    public UnitDao unitDao() {
      return DatabaseModule_ProvideUnitDaoFactory.provideUnitDao(provideAppDatabaseProvider.get());
    }

    @Override
    public void injectSiteManagementApplication(
        SiteManagementApplication siteManagementApplication) {
    }

    @Override
    public Set<Boolean> getDisableFragmentGetContextFix() {
      return ImmutableSet.<Boolean>of();
    }

    @Override
    public ActivityRetainedComponentBuilder retainedComponentBuilder() {
      return new ActivityRetainedCBuilder(singletonCImpl);
    }

    @Override
    public ServiceComponentBuilder serviceComponentBuilder() {
      return new ServiceCBuilder(singletonCImpl);
    }

    private static final class SwitchingProvider<T> implements Provider<T> {
      private final SingletonCImpl singletonCImpl;

      private final int id;

      SwitchingProvider(SingletonCImpl singletonCImpl, int id) {
        this.singletonCImpl = singletonCImpl;
        this.id = id;
      }

      @SuppressWarnings("unchecked")
      @Override
      public T get() {
        switch (id) {
          case 0: // com.balancetech.sitemanagement.data.database.AppDatabase 
          return (T) DatabaseModule_ProvideAppDatabaseFactory.provideAppDatabase(ApplicationContextModule_ProvideContextFactory.provideContext(singletonCImpl.applicationContextModule));

          case 1: // com.balancetech.sitemanagement.data.repository.AuthRepository 
          return (T) RepositoryModule_ProvideAuthRepositoryFactory.provideAuthRepository(singletonCImpl.userDao(), singletonCImpl.provideFirebaseAuthProvider.get(), singletonCImpl.provideLocalDataSourceProvider.get(), singletonCImpl.provideRemoteDataSourceProvider.get());

          case 2: // com.google.firebase.auth.FirebaseAuth 
          return (T) FirebaseModule_ProvideFirebaseAuthFactory.provideFirebaseAuth();

          case 3: // com.balancetech.sitemanagement.data.datasource.LocalDataSource 
          return (T) DataSourceModule_ProvideLocalDataSourceFactory.provideLocalDataSource(singletonCImpl.localDataSourceImpl());

          case 4: // com.balancetech.sitemanagement.data.datasource.RemoteDataSource 
          return (T) DataSourceModule_ProvideRemoteDataSourceFactory.provideRemoteDataSource(singletonCImpl.remoteDataSourceImpl());

          case 5: // com.google.firebase.firestore.FirebaseFirestore 
          return (T) FirebaseModule_ProvideFirebaseFirestoreFactory.provideFirebaseFirestore();

          case 6: // com.balancetech.sitemanagement.data.repository.FeeRepository 
          return (T) RepositoryModule_ProvideFeeRepositoryFactory.provideFeeRepository(singletonCImpl.feeDao(), singletonCImpl.unitDao(), singletonCImpl.provideLocalDataSourceProvider.get(), singletonCImpl.provideRemoteDataSourceProvider.get(), singletonCImpl.provideFirebaseFunctionsServiceProvider.get(), singletonCImpl.userDao());

          case 7: // com.balancetech.sitemanagement.data.service.FirebaseFunctionsService 
          return (T) FirebaseModule_ProvideFirebaseFunctionsServiceFactory.provideFirebaseFunctionsService(singletonCImpl.provideFirebaseFunctionsProvider.get());

          case 8: // com.google.firebase.functions.FirebaseFunctions 
          return (T) FirebaseModule_ProvideFirebaseFunctionsFactory.provideFirebaseFunctions();

          case 9: // com.balancetech.sitemanagement.data.repository.PaymentRepository 
          return (T) RepositoryModule_ProvidePaymentRepositoryFactory.providePaymentRepository(singletonCImpl.paymentDao(), singletonCImpl.provideFirebaseFunctionsServiceProvider.get());

          case 10: // com.balancetech.sitemanagement.data.repository.ExtraPaymentRepository 
          return (T) RepositoryModule_ProvideExtraPaymentRepositoryFactory.provideExtraPaymentRepository(singletonCImpl.extraPaymentDao());

          case 11: // com.balancetech.sitemanagement.data.repository.WaterMeterRepository 
          return (T) RepositoryModule_ProvideWaterMeterRepositoryFactory.provideWaterMeterRepository(singletonCImpl.waterMeterDao(), singletonCImpl.waterBillDao(), singletonCImpl.provideFirebaseFunctionsServiceProvider.get());

          case 12: // com.balancetech.sitemanagement.data.repository.SyncRepository 
          return (T) RepositoryModule_ProvideSyncRepositoryFactory.provideSyncRepository(singletonCImpl.provideLocalDataSourceProvider.get(), singletonCImpl.provideRemoteDataSourceProvider.get());

          case 13: // com.balancetech.sitemanagement.data.repository.NotificationRepository 
          return (T) RepositoryModule_ProvideNotificationRepositoryFactory.provideNotificationRepository(singletonCImpl.notificationDao());

          case 14: // com.balancetech.sitemanagement.data.repository.UserRepository 
          return (T) RepositoryModule_ProvideUserRepositoryFactory.provideUserRepository(singletonCImpl.provideLocalDataSourceProvider.get(), singletonCImpl.provideRemoteDataSourceProvider.get());

          default: throw new AssertionError(id);
        }
      }
    }
  }
}
