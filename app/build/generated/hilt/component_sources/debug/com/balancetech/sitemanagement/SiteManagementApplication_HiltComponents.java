package com.balancetech.sitemanagement;

import com.balancetech.sitemanagement.di.DataSourceModule;
import com.balancetech.sitemanagement.di.DatabaseModule;
import com.balancetech.sitemanagement.di.FirebaseModule;
import com.balancetech.sitemanagement.di.RepositoryModule;
import com.balancetech.sitemanagement.ui.auth.LoginFragment_GeneratedInjector;
import com.balancetech.sitemanagement.ui.auth.RegisterFragment_GeneratedInjector;
import com.balancetech.sitemanagement.ui.dashboard.DashboardFragment_GeneratedInjector;
import com.balancetech.sitemanagement.ui.dialog.AddUserDialogFragment_GeneratedInjector;
import com.balancetech.sitemanagement.ui.dialog.AddWaterMeterDialogFragment_GeneratedInjector;
import com.balancetech.sitemanagement.ui.dialog.CreateExtraPaymentDialogFragment_GeneratedInjector;
import com.balancetech.sitemanagement.ui.dialog.CreateFeeDialogFragment_GeneratedInjector;
import com.balancetech.sitemanagement.ui.dialog.CreateFeesForAllUnitsDialogFragment_GeneratedInjector;
import com.balancetech.sitemanagement.ui.dialog.EditUserDialogFragment_GeneratedInjector;
import com.balancetech.sitemanagement.ui.dialog.PaymentEntryDialogFragment_GeneratedInjector;
import com.balancetech.sitemanagement.ui.dialog.WaterMeterReadingDialogFragment_GeneratedInjector;
import com.balancetech.sitemanagement.ui.extrapayments.ExtraPaymentsFragment_GeneratedInjector;
import com.balancetech.sitemanagement.ui.fees.FeesFragment_GeneratedInjector;
import com.balancetech.sitemanagement.ui.notifications.NotificationsFragment_GeneratedInjector;
import com.balancetech.sitemanagement.ui.payments.PaymentsFragment_GeneratedInjector;
import com.balancetech.sitemanagement.ui.reports.ReportsFragment_GeneratedInjector;
import com.balancetech.sitemanagement.ui.users.UserDetailFragment_GeneratedInjector;
import com.balancetech.sitemanagement.ui.users.UsersFragment_GeneratedInjector;
import com.balancetech.sitemanagement.ui.viewmodel.AuthViewModel_HiltModules;
import com.balancetech.sitemanagement.ui.viewmodel.DashboardViewModel_HiltModules;
import com.balancetech.sitemanagement.ui.viewmodel.ExtraPaymentViewModel_HiltModules;
import com.balancetech.sitemanagement.ui.viewmodel.FeeViewModel_HiltModules;
import com.balancetech.sitemanagement.ui.viewmodel.NotificationViewModel_HiltModules;
import com.balancetech.sitemanagement.ui.viewmodel.PaymentViewModel_HiltModules;
import com.balancetech.sitemanagement.ui.viewmodel.ReportsViewModel_HiltModules;
import com.balancetech.sitemanagement.ui.viewmodel.UserDetailViewModel_HiltModules;
import com.balancetech.sitemanagement.ui.viewmodel.UserViewModel_HiltModules;
import com.balancetech.sitemanagement.ui.viewmodel.WaterMeterViewModel_HiltModules;
import com.balancetech.sitemanagement.ui.watermeter.WaterMeterDetailFragment_GeneratedInjector;
import com.balancetech.sitemanagement.ui.watermeter.WaterMeterFragment_GeneratedInjector;
import dagger.Binds;
import dagger.Component;
import dagger.Module;
import dagger.Subcomponent;
import dagger.hilt.android.components.ActivityComponent;
import dagger.hilt.android.components.ActivityRetainedComponent;
import dagger.hilt.android.components.FragmentComponent;
import dagger.hilt.android.components.ServiceComponent;
import dagger.hilt.android.components.ViewComponent;
import dagger.hilt.android.components.ViewModelComponent;
import dagger.hilt.android.components.ViewWithFragmentComponent;
import dagger.hilt.android.flags.FragmentGetContextFix;
import dagger.hilt.android.flags.HiltWrapper_FragmentGetContextFix_FragmentGetContextFixModule;
import dagger.hilt.android.internal.builders.ActivityComponentBuilder;
import dagger.hilt.android.internal.builders.ActivityRetainedComponentBuilder;
import dagger.hilt.android.internal.builders.FragmentComponentBuilder;
import dagger.hilt.android.internal.builders.ServiceComponentBuilder;
import dagger.hilt.android.internal.builders.ViewComponentBuilder;
import dagger.hilt.android.internal.builders.ViewModelComponentBuilder;
import dagger.hilt.android.internal.builders.ViewWithFragmentComponentBuilder;
import dagger.hilt.android.internal.lifecycle.DefaultViewModelFactories;
import dagger.hilt.android.internal.lifecycle.HiltViewModelFactory;
import dagger.hilt.android.internal.lifecycle.HiltWrapper_DefaultViewModelFactories_ActivityModule;
import dagger.hilt.android.internal.lifecycle.HiltWrapper_HiltViewModelFactory_ActivityCreatorEntryPoint;
import dagger.hilt.android.internal.lifecycle.HiltWrapper_HiltViewModelFactory_ViewModelModule;
import dagger.hilt.android.internal.managers.ActivityComponentManager;
import dagger.hilt.android.internal.managers.FragmentComponentManager;
import dagger.hilt.android.internal.managers.HiltWrapper_ActivityRetainedComponentManager_ActivityRetainedComponentBuilderEntryPoint;
import dagger.hilt.android.internal.managers.HiltWrapper_ActivityRetainedComponentManager_ActivityRetainedLifecycleEntryPoint;
import dagger.hilt.android.internal.managers.HiltWrapper_ActivityRetainedComponentManager_LifecycleModule;
import dagger.hilt.android.internal.managers.ServiceComponentManager;
import dagger.hilt.android.internal.managers.ViewComponentManager;
import dagger.hilt.android.internal.modules.ApplicationContextModule;
import dagger.hilt.android.internal.modules.HiltWrapper_ActivityModule;
import dagger.hilt.android.scopes.ActivityRetainedScoped;
import dagger.hilt.android.scopes.ActivityScoped;
import dagger.hilt.android.scopes.FragmentScoped;
import dagger.hilt.android.scopes.ServiceScoped;
import dagger.hilt.android.scopes.ViewModelScoped;
import dagger.hilt.android.scopes.ViewScoped;
import dagger.hilt.components.SingletonComponent;
import dagger.hilt.internal.GeneratedComponent;
import dagger.hilt.migration.DisableInstallInCheck;
import javax.annotation.processing.Generated;
import javax.inject.Singleton;

@Generated("dagger.hilt.processor.internal.root.RootProcessor")
public final class SiteManagementApplication_HiltComponents {
  private SiteManagementApplication_HiltComponents() {
  }

  @Module(
      subcomponents = ServiceC.class
  )
  @DisableInstallInCheck
  @Generated("dagger.hilt.processor.internal.root.RootProcessor")
  abstract interface ServiceCBuilderModule {
    @Binds
    ServiceComponentBuilder bind(ServiceC.Builder builder);
  }

  @Module(
      subcomponents = ActivityRetainedC.class
  )
  @DisableInstallInCheck
  @Generated("dagger.hilt.processor.internal.root.RootProcessor")
  abstract interface ActivityRetainedCBuilderModule {
    @Binds
    ActivityRetainedComponentBuilder bind(ActivityRetainedC.Builder builder);
  }

  @Module(
      subcomponents = ActivityC.class
  )
  @DisableInstallInCheck
  @Generated("dagger.hilt.processor.internal.root.RootProcessor")
  abstract interface ActivityCBuilderModule {
    @Binds
    ActivityComponentBuilder bind(ActivityC.Builder builder);
  }

  @Module(
      subcomponents = ViewModelC.class
  )
  @DisableInstallInCheck
  @Generated("dagger.hilt.processor.internal.root.RootProcessor")
  abstract interface ViewModelCBuilderModule {
    @Binds
    ViewModelComponentBuilder bind(ViewModelC.Builder builder);
  }

  @Module(
      subcomponents = ViewC.class
  )
  @DisableInstallInCheck
  @Generated("dagger.hilt.processor.internal.root.RootProcessor")
  abstract interface ViewCBuilderModule {
    @Binds
    ViewComponentBuilder bind(ViewC.Builder builder);
  }

  @Module(
      subcomponents = FragmentC.class
  )
  @DisableInstallInCheck
  @Generated("dagger.hilt.processor.internal.root.RootProcessor")
  abstract interface FragmentCBuilderModule {
    @Binds
    FragmentComponentBuilder bind(FragmentC.Builder builder);
  }

  @Module(
      subcomponents = ViewWithFragmentC.class
  )
  @DisableInstallInCheck
  @Generated("dagger.hilt.processor.internal.root.RootProcessor")
  abstract interface ViewWithFragmentCBuilderModule {
    @Binds
    ViewWithFragmentComponentBuilder bind(ViewWithFragmentC.Builder builder);
  }

  @Component(
      modules = {
          ApplicationContextModule.class,
          DataSourceModule.class,
          DatabaseModule.class,
          FirebaseModule.class,
          HiltWrapper_FragmentGetContextFix_FragmentGetContextFixModule.class,
          RepositoryModule.class,
          ActivityRetainedCBuilderModule.class,
          ServiceCBuilderModule.class
      }
  )
  @Singleton
  public abstract static class SingletonC implements SiteManagementApplication.DatabaseSeedEntryPoint,
      SiteManagementApplication_GeneratedInjector,
      FragmentGetContextFix.FragmentGetContextFixEntryPoint,
      HiltWrapper_ActivityRetainedComponentManager_ActivityRetainedComponentBuilderEntryPoint,
      ServiceComponentManager.ServiceComponentBuilderEntryPoint,
      SingletonComponent,
      GeneratedComponent {
  }

  @Subcomponent
  @ServiceScoped
  public abstract static class ServiceC implements ServiceComponent,
      GeneratedComponent {
    @Subcomponent.Builder
    abstract interface Builder extends ServiceComponentBuilder {
    }
  }

  @Subcomponent(
      modules = {
          AuthViewModel_HiltModules.KeyModule.class,
          DashboardViewModel_HiltModules.KeyModule.class,
          ExtraPaymentViewModel_HiltModules.KeyModule.class,
          FeeViewModel_HiltModules.KeyModule.class,
          HiltWrapper_ActivityRetainedComponentManager_LifecycleModule.class,
          NotificationViewModel_HiltModules.KeyModule.class,
          PaymentViewModel_HiltModules.KeyModule.class,
          ReportsViewModel_HiltModules.KeyModule.class,
          ActivityCBuilderModule.class,
          ViewModelCBuilderModule.class,
          UserDetailViewModel_HiltModules.KeyModule.class,
          UserViewModel_HiltModules.KeyModule.class,
          WaterMeterViewModel_HiltModules.KeyModule.class
      }
  )
  @ActivityRetainedScoped
  public abstract static class ActivityRetainedC implements ActivityRetainedComponent,
      ActivityComponentManager.ActivityComponentBuilderEntryPoint,
      HiltWrapper_ActivityRetainedComponentManager_ActivityRetainedLifecycleEntryPoint,
      GeneratedComponent {
    @Subcomponent.Builder
    abstract interface Builder extends ActivityRetainedComponentBuilder {
    }
  }

  @Subcomponent(
      modules = {
          HiltWrapper_ActivityModule.class,
          HiltWrapper_DefaultViewModelFactories_ActivityModule.class,
          FragmentCBuilderModule.class,
          ViewCBuilderModule.class
      }
  )
  @ActivityScoped
  public abstract static class ActivityC implements MainActivity_GeneratedInjector,
      ActivityComponent,
      DefaultViewModelFactories.ActivityEntryPoint,
      HiltWrapper_HiltViewModelFactory_ActivityCreatorEntryPoint,
      FragmentComponentManager.FragmentComponentBuilderEntryPoint,
      ViewComponentManager.ViewComponentBuilderEntryPoint,
      GeneratedComponent {
    @Subcomponent.Builder
    abstract interface Builder extends ActivityComponentBuilder {
    }
  }

  @Subcomponent(
      modules = {
          AuthViewModel_HiltModules.BindsModule.class,
          DashboardViewModel_HiltModules.BindsModule.class,
          ExtraPaymentViewModel_HiltModules.BindsModule.class,
          FeeViewModel_HiltModules.BindsModule.class,
          HiltWrapper_HiltViewModelFactory_ViewModelModule.class,
          NotificationViewModel_HiltModules.BindsModule.class,
          PaymentViewModel_HiltModules.BindsModule.class,
          ReportsViewModel_HiltModules.BindsModule.class,
          UserDetailViewModel_HiltModules.BindsModule.class,
          UserViewModel_HiltModules.BindsModule.class,
          WaterMeterViewModel_HiltModules.BindsModule.class
      }
  )
  @ViewModelScoped
  public abstract static class ViewModelC implements ViewModelComponent,
      HiltViewModelFactory.ViewModelFactoriesEntryPoint,
      GeneratedComponent {
    @Subcomponent.Builder
    abstract interface Builder extends ViewModelComponentBuilder {
    }
  }

  @Subcomponent
  @ViewScoped
  public abstract static class ViewC implements ViewComponent,
      GeneratedComponent {
    @Subcomponent.Builder
    abstract interface Builder extends ViewComponentBuilder {
    }
  }

  @Subcomponent(
      modules = ViewWithFragmentCBuilderModule.class
  )
  @FragmentScoped
  public abstract static class FragmentC implements LoginFragment_GeneratedInjector,
      RegisterFragment_GeneratedInjector,
      DashboardFragment_GeneratedInjector,
      AddUserDialogFragment_GeneratedInjector,
      AddWaterMeterDialogFragment_GeneratedInjector,
      CreateExtraPaymentDialogFragment_GeneratedInjector,
      CreateFeeDialogFragment_GeneratedInjector,
      CreateFeesForAllUnitsDialogFragment_GeneratedInjector,
      EditUserDialogFragment_GeneratedInjector,
      PaymentEntryDialogFragment_GeneratedInjector,
      WaterMeterReadingDialogFragment_GeneratedInjector,
      ExtraPaymentsFragment_GeneratedInjector,
      FeesFragment_GeneratedInjector,
      NotificationsFragment_GeneratedInjector,
      PaymentsFragment_GeneratedInjector,
      ReportsFragment_GeneratedInjector,
      UserDetailFragment_GeneratedInjector,
      UsersFragment_GeneratedInjector,
      WaterMeterDetailFragment_GeneratedInjector,
      WaterMeterFragment_GeneratedInjector,
      FragmentComponent,
      DefaultViewModelFactories.FragmentEntryPoint,
      ViewComponentManager.ViewWithFragmentComponentBuilderEntryPoint,
      GeneratedComponent {
    @Subcomponent.Builder
    abstract interface Builder extends FragmentComponentBuilder {
    }
  }

  @Subcomponent
  @ViewScoped
  public abstract static class ViewWithFragmentC implements ViewWithFragmentComponent,
      GeneratedComponent {
    @Subcomponent.Builder
    abstract interface Builder extends ViewWithFragmentComponentBuilder {
    }
  }
}
