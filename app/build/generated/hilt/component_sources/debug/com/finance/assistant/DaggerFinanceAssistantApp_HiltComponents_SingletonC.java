package com.finance.assistant;

import android.app.Activity;
import android.app.Service;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.SavedStateHandle;
import androidx.lifecycle.ViewModel;
import com.finance.assistant.data.remote.OllamaApiService;
import com.finance.assistant.data.repository.CashGapDataRepository;
import com.finance.assistant.data.repository.FeedDataRepository;
import com.finance.assistant.data.repository.ForecastDataRepository;
import com.finance.assistant.data.repository.HomeDataRepository;
import com.finance.assistant.data.repository.LLMRepository;
import com.finance.assistant.data.repository.MockAssistantRepository;
import com.finance.assistant.data.repository.PaymentConfirmationDataRepository;
import com.finance.assistant.data.repository.RescheduleDataRepository;
import com.finance.assistant.di.LLMModule_ProvideGsonFactory;
import com.finance.assistant.di.LLMModule_ProvideLLMRepositoryFactory;
import com.finance.assistant.di.LLMModule_ProvideLoggingInterceptorFactory;
import com.finance.assistant.di.LLMModule_ProvideOkHttpClientFactory;
import com.finance.assistant.di.LLMModule_ProvideOllamaApiServiceFactory;
import com.finance.assistant.di.LLMModule_ProvideOllamaBaseUrlFactory;
import com.finance.assistant.di.LLMModule_ProvideOllamaModelNameFactory;
import com.finance.assistant.ui.screens.viewmodel.AssistantViewModel;
import com.finance.assistant.ui.screens.viewmodel.AssistantViewModel_HiltModules;
import com.finance.assistant.ui.screens.viewmodel.AssistantViewModel_HiltModules_BindsModule_Binds_LazyMapKey;
import com.finance.assistant.ui.screens.viewmodel.AssistantViewModel_HiltModules_KeyModule_Provide_LazyMapKey;
import com.finance.assistant.ui.screens.viewmodel.CashGapViewModel;
import com.finance.assistant.ui.screens.viewmodel.CashGapViewModel_HiltModules;
import com.finance.assistant.ui.screens.viewmodel.CashGapViewModel_HiltModules_BindsModule_Binds_LazyMapKey;
import com.finance.assistant.ui.screens.viewmodel.CashGapViewModel_HiltModules_KeyModule_Provide_LazyMapKey;
import com.finance.assistant.ui.screens.viewmodel.FeedViewModel;
import com.finance.assistant.ui.screens.viewmodel.FeedViewModel_HiltModules;
import com.finance.assistant.ui.screens.viewmodel.FeedViewModel_HiltModules_BindsModule_Binds_LazyMapKey;
import com.finance.assistant.ui.screens.viewmodel.FeedViewModel_HiltModules_KeyModule_Provide_LazyMapKey;
import com.finance.assistant.ui.screens.viewmodel.ForecastViewModel;
import com.finance.assistant.ui.screens.viewmodel.ForecastViewModel_HiltModules;
import com.finance.assistant.ui.screens.viewmodel.ForecastViewModel_HiltModules_BindsModule_Binds_LazyMapKey;
import com.finance.assistant.ui.screens.viewmodel.ForecastViewModel_HiltModules_KeyModule_Provide_LazyMapKey;
import com.finance.assistant.ui.screens.viewmodel.HomeViewModel;
import com.finance.assistant.ui.screens.viewmodel.HomeViewModel_HiltModules;
import com.finance.assistant.ui.screens.viewmodel.HomeViewModel_HiltModules_BindsModule_Binds_LazyMapKey;
import com.finance.assistant.ui.screens.viewmodel.HomeViewModel_HiltModules_KeyModule_Provide_LazyMapKey;
import com.finance.assistant.ui.screens.viewmodel.PaymentConfirmationViewModel;
import com.finance.assistant.ui.screens.viewmodel.PaymentConfirmationViewModel_HiltModules;
import com.finance.assistant.ui.screens.viewmodel.PaymentConfirmationViewModel_HiltModules_BindsModule_Binds_LazyMapKey;
import com.finance.assistant.ui.screens.viewmodel.PaymentConfirmationViewModel_HiltModules_KeyModule_Provide_LazyMapKey;
import com.finance.assistant.ui.screens.viewmodel.RescheduleViewModel;
import com.finance.assistant.ui.screens.viewmodel.RescheduleViewModel_HiltModules;
import com.finance.assistant.ui.screens.viewmodel.RescheduleViewModel_HiltModules_BindsModule_Binds_LazyMapKey;
import com.finance.assistant.ui.screens.viewmodel.RescheduleViewModel_HiltModules_KeyModule_Provide_LazyMapKey;
import com.google.gson.Gson;
import dagger.hilt.android.ActivityRetainedLifecycle;
import dagger.hilt.android.ViewModelLifecycle;
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
import dagger.hilt.android.internal.managers.SavedStateHandleHolder;
import dagger.hilt.android.internal.modules.ApplicationContextModule;
import dagger.hilt.android.internal.modules.ApplicationContextModule_ProvideContextFactory;
import dagger.internal.DaggerGenerated;
import dagger.internal.DoubleCheck;
import dagger.internal.LazyClassKeyMap;
import dagger.internal.MapBuilder;
import dagger.internal.Preconditions;
import dagger.internal.Provider;
import java.util.Collections;
import java.util.Map;
import java.util.Set;
import javax.annotation.processing.Generated;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;

@DaggerGenerated
@Generated(
    value = "dagger.internal.codegen.ComponentProcessor",
    comments = "https://dagger.dev"
)
@SuppressWarnings({
    "unchecked",
    "rawtypes",
    "KotlinInternal",
    "KotlinInternalInJava",
    "cast",
    "deprecation",
    "nullness:initialization.field.uninitialized"
})
public final class DaggerFinanceAssistantApp_HiltComponents_SingletonC {
  private DaggerFinanceAssistantApp_HiltComponents_SingletonC() {
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

    public FinanceAssistantApp_HiltComponents.SingletonC build() {
      Preconditions.checkBuilderRequirement(applicationContextModule, ApplicationContextModule.class);
      return new SingletonCImpl(applicationContextModule);
    }
  }

  private static final class ActivityRetainedCBuilder implements FinanceAssistantApp_HiltComponents.ActivityRetainedC.Builder {
    private final SingletonCImpl singletonCImpl;

    private SavedStateHandleHolder savedStateHandleHolder;

    private ActivityRetainedCBuilder(SingletonCImpl singletonCImpl) {
      this.singletonCImpl = singletonCImpl;
    }

    @Override
    public ActivityRetainedCBuilder savedStateHandleHolder(
        SavedStateHandleHolder savedStateHandleHolder) {
      this.savedStateHandleHolder = Preconditions.checkNotNull(savedStateHandleHolder);
      return this;
    }

    @Override
    public FinanceAssistantApp_HiltComponents.ActivityRetainedC build() {
      Preconditions.checkBuilderRequirement(savedStateHandleHolder, SavedStateHandleHolder.class);
      return new ActivityRetainedCImpl(singletonCImpl, savedStateHandleHolder);
    }
  }

  private static final class ActivityCBuilder implements FinanceAssistantApp_HiltComponents.ActivityC.Builder {
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
    public FinanceAssistantApp_HiltComponents.ActivityC build() {
      Preconditions.checkBuilderRequirement(activity, Activity.class);
      return new ActivityCImpl(singletonCImpl, activityRetainedCImpl, activity);
    }
  }

  private static final class FragmentCBuilder implements FinanceAssistantApp_HiltComponents.FragmentC.Builder {
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
    public FinanceAssistantApp_HiltComponents.FragmentC build() {
      Preconditions.checkBuilderRequirement(fragment, Fragment.class);
      return new FragmentCImpl(singletonCImpl, activityRetainedCImpl, activityCImpl, fragment);
    }
  }

  private static final class ViewWithFragmentCBuilder implements FinanceAssistantApp_HiltComponents.ViewWithFragmentC.Builder {
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
    public FinanceAssistantApp_HiltComponents.ViewWithFragmentC build() {
      Preconditions.checkBuilderRequirement(view, View.class);
      return new ViewWithFragmentCImpl(singletonCImpl, activityRetainedCImpl, activityCImpl, fragmentCImpl, view);
    }
  }

  private static final class ViewCBuilder implements FinanceAssistantApp_HiltComponents.ViewC.Builder {
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
    public FinanceAssistantApp_HiltComponents.ViewC build() {
      Preconditions.checkBuilderRequirement(view, View.class);
      return new ViewCImpl(singletonCImpl, activityRetainedCImpl, activityCImpl, view);
    }
  }

  private static final class ViewModelCBuilder implements FinanceAssistantApp_HiltComponents.ViewModelC.Builder {
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
    public FinanceAssistantApp_HiltComponents.ViewModelC build() {
      Preconditions.checkBuilderRequirement(savedStateHandle, SavedStateHandle.class);
      Preconditions.checkBuilderRequirement(viewModelLifecycle, ViewModelLifecycle.class);
      return new ViewModelCImpl(singletonCImpl, activityRetainedCImpl, savedStateHandle, viewModelLifecycle);
    }
  }

  private static final class ServiceCBuilder implements FinanceAssistantApp_HiltComponents.ServiceC.Builder {
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
    public FinanceAssistantApp_HiltComponents.ServiceC build() {
      Preconditions.checkBuilderRequirement(service, Service.class);
      return new ServiceCImpl(singletonCImpl, service);
    }
  }

  private static final class ViewWithFragmentCImpl extends FinanceAssistantApp_HiltComponents.ViewWithFragmentC {
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

  private static final class FragmentCImpl extends FinanceAssistantApp_HiltComponents.FragmentC {
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
    public DefaultViewModelFactories.InternalFactoryFactory getHiltInternalFactoryFactory() {
      return activityCImpl.getHiltInternalFactoryFactory();
    }

    @Override
    public ViewWithFragmentComponentBuilder viewWithFragmentComponentBuilder() {
      return new ViewWithFragmentCBuilder(singletonCImpl, activityRetainedCImpl, activityCImpl, fragmentCImpl);
    }
  }

  private static final class ViewCImpl extends FinanceAssistantApp_HiltComponents.ViewC {
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

  private static final class ActivityCImpl extends FinanceAssistantApp_HiltComponents.ActivityC {
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
    public Map<Class<?>, Boolean> getViewModelKeys() {
      return LazyClassKeyMap.<Boolean>of(MapBuilder.<String, Boolean>newMapBuilder(7).put(AssistantViewModel_HiltModules_KeyModule_Provide_LazyMapKey.lazyClassKeyName, AssistantViewModel_HiltModules.KeyModule.provide()).put(CashGapViewModel_HiltModules_KeyModule_Provide_LazyMapKey.lazyClassKeyName, CashGapViewModel_HiltModules.KeyModule.provide()).put(FeedViewModel_HiltModules_KeyModule_Provide_LazyMapKey.lazyClassKeyName, FeedViewModel_HiltModules.KeyModule.provide()).put(ForecastViewModel_HiltModules_KeyModule_Provide_LazyMapKey.lazyClassKeyName, ForecastViewModel_HiltModules.KeyModule.provide()).put(HomeViewModel_HiltModules_KeyModule_Provide_LazyMapKey.lazyClassKeyName, HomeViewModel_HiltModules.KeyModule.provide()).put(PaymentConfirmationViewModel_HiltModules_KeyModule_Provide_LazyMapKey.lazyClassKeyName, PaymentConfirmationViewModel_HiltModules.KeyModule.provide()).put(RescheduleViewModel_HiltModules_KeyModule_Provide_LazyMapKey.lazyClassKeyName, RescheduleViewModel_HiltModules.KeyModule.provide()).build());
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

  private static final class ViewModelCImpl extends FinanceAssistantApp_HiltComponents.ViewModelC {
    private final SingletonCImpl singletonCImpl;

    private final ActivityRetainedCImpl activityRetainedCImpl;

    private final ViewModelCImpl viewModelCImpl = this;

    private Provider<AssistantViewModel> assistantViewModelProvider;

    private Provider<CashGapViewModel> cashGapViewModelProvider;

    private Provider<FeedViewModel> feedViewModelProvider;

    private Provider<ForecastViewModel> forecastViewModelProvider;

    private Provider<HomeViewModel> homeViewModelProvider;

    private Provider<PaymentConfirmationViewModel> paymentConfirmationViewModelProvider;

    private Provider<RescheduleViewModel> rescheduleViewModelProvider;

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
      this.assistantViewModelProvider = new SwitchingProvider<>(singletonCImpl, activityRetainedCImpl, viewModelCImpl, 0);
      this.cashGapViewModelProvider = new SwitchingProvider<>(singletonCImpl, activityRetainedCImpl, viewModelCImpl, 1);
      this.feedViewModelProvider = new SwitchingProvider<>(singletonCImpl, activityRetainedCImpl, viewModelCImpl, 2);
      this.forecastViewModelProvider = new SwitchingProvider<>(singletonCImpl, activityRetainedCImpl, viewModelCImpl, 3);
      this.homeViewModelProvider = new SwitchingProvider<>(singletonCImpl, activityRetainedCImpl, viewModelCImpl, 4);
      this.paymentConfirmationViewModelProvider = new SwitchingProvider<>(singletonCImpl, activityRetainedCImpl, viewModelCImpl, 5);
      this.rescheduleViewModelProvider = new SwitchingProvider<>(singletonCImpl, activityRetainedCImpl, viewModelCImpl, 6);
    }

    @Override
    public Map<Class<?>, javax.inject.Provider<ViewModel>> getHiltViewModelMap() {
      return LazyClassKeyMap.<javax.inject.Provider<ViewModel>>of(MapBuilder.<String, javax.inject.Provider<ViewModel>>newMapBuilder(7).put(AssistantViewModel_HiltModules_BindsModule_Binds_LazyMapKey.lazyClassKeyName, ((Provider) assistantViewModelProvider)).put(CashGapViewModel_HiltModules_BindsModule_Binds_LazyMapKey.lazyClassKeyName, ((Provider) cashGapViewModelProvider)).put(FeedViewModel_HiltModules_BindsModule_Binds_LazyMapKey.lazyClassKeyName, ((Provider) feedViewModelProvider)).put(ForecastViewModel_HiltModules_BindsModule_Binds_LazyMapKey.lazyClassKeyName, ((Provider) forecastViewModelProvider)).put(HomeViewModel_HiltModules_BindsModule_Binds_LazyMapKey.lazyClassKeyName, ((Provider) homeViewModelProvider)).put(PaymentConfirmationViewModel_HiltModules_BindsModule_Binds_LazyMapKey.lazyClassKeyName, ((Provider) paymentConfirmationViewModelProvider)).put(RescheduleViewModel_HiltModules_BindsModule_Binds_LazyMapKey.lazyClassKeyName, ((Provider) rescheduleViewModelProvider)).build());
    }

    @Override
    public Map<Class<?>, Object> getHiltViewModelAssistedMap() {
      return Collections.<Class<?>, Object>emptyMap();
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
          case 0: // com.finance.assistant.ui.screens.viewmodel.AssistantViewModel 
          return (T) new AssistantViewModel(singletonCImpl.mockAssistantRepositoryProvider.get(), singletonCImpl.provideLLMRepositoryProvider.get());

          case 1: // com.finance.assistant.ui.screens.viewmodel.CashGapViewModel 
          return (T) new CashGapViewModel(singletonCImpl.cashGapDataRepositoryProvider.get());

          case 2: // com.finance.assistant.ui.screens.viewmodel.FeedViewModel 
          return (T) new FeedViewModel(singletonCImpl.feedDataRepositoryProvider.get());

          case 3: // com.finance.assistant.ui.screens.viewmodel.ForecastViewModel 
          return (T) new ForecastViewModel(singletonCImpl.forecastDataRepositoryProvider.get());

          case 4: // com.finance.assistant.ui.screens.viewmodel.HomeViewModel 
          return (T) new HomeViewModel(singletonCImpl.homeDataRepositoryProvider.get());

          case 5: // com.finance.assistant.ui.screens.viewmodel.PaymentConfirmationViewModel 
          return (T) new PaymentConfirmationViewModel(singletonCImpl.paymentConfirmationDataRepositoryProvider.get());

          case 6: // com.finance.assistant.ui.screens.viewmodel.RescheduleViewModel 
          return (T) new RescheduleViewModel(singletonCImpl.rescheduleDataRepositoryProvider.get());

          default: throw new AssertionError(id);
        }
      }
    }
  }

  private static final class ActivityRetainedCImpl extends FinanceAssistantApp_HiltComponents.ActivityRetainedC {
    private final SingletonCImpl singletonCImpl;

    private final ActivityRetainedCImpl activityRetainedCImpl = this;

    private Provider<ActivityRetainedLifecycle> provideActivityRetainedLifecycleProvider;

    private ActivityRetainedCImpl(SingletonCImpl singletonCImpl,
        SavedStateHandleHolder savedStateHandleHolderParam) {
      this.singletonCImpl = singletonCImpl;

      initialize(savedStateHandleHolderParam);

    }

    @SuppressWarnings("unchecked")
    private void initialize(final SavedStateHandleHolder savedStateHandleHolderParam) {
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

  private static final class ServiceCImpl extends FinanceAssistantApp_HiltComponents.ServiceC {
    private final SingletonCImpl singletonCImpl;

    private final ServiceCImpl serviceCImpl = this;

    private ServiceCImpl(SingletonCImpl singletonCImpl, Service serviceParam) {
      this.singletonCImpl = singletonCImpl;


    }
  }

  private static final class SingletonCImpl extends FinanceAssistantApp_HiltComponents.SingletonC {
    private final ApplicationContextModule applicationContextModule;

    private final SingletonCImpl singletonCImpl = this;

    private Provider<Gson> provideGsonProvider;

    private Provider<MockAssistantRepository> mockAssistantRepositoryProvider;

    private Provider<HttpLoggingInterceptor> provideLoggingInterceptorProvider;

    private Provider<OkHttpClient> provideOkHttpClientProvider;

    private Provider<OllamaApiService> provideOllamaApiServiceProvider;

    private Provider<LLMRepository> provideLLMRepositoryProvider;

    private Provider<CashGapDataRepository> cashGapDataRepositoryProvider;

    private Provider<FeedDataRepository> feedDataRepositoryProvider;

    private Provider<ForecastDataRepository> forecastDataRepositoryProvider;

    private Provider<HomeDataRepository> homeDataRepositoryProvider;

    private Provider<PaymentConfirmationDataRepository> paymentConfirmationDataRepositoryProvider;

    private Provider<RescheduleDataRepository> rescheduleDataRepositoryProvider;

    private SingletonCImpl(ApplicationContextModule applicationContextModuleParam) {
      this.applicationContextModule = applicationContextModuleParam;
      initialize(applicationContextModuleParam);

    }

    @SuppressWarnings("unchecked")
    private void initialize(final ApplicationContextModule applicationContextModuleParam) {
      this.provideGsonProvider = DoubleCheck.provider(new SwitchingProvider<Gson>(singletonCImpl, 1));
      this.mockAssistantRepositoryProvider = DoubleCheck.provider(new SwitchingProvider<MockAssistantRepository>(singletonCImpl, 0));
      this.provideLoggingInterceptorProvider = DoubleCheck.provider(new SwitchingProvider<HttpLoggingInterceptor>(singletonCImpl, 5));
      this.provideOkHttpClientProvider = DoubleCheck.provider(new SwitchingProvider<OkHttpClient>(singletonCImpl, 4));
      this.provideOllamaApiServiceProvider = DoubleCheck.provider(new SwitchingProvider<OllamaApiService>(singletonCImpl, 3));
      this.provideLLMRepositoryProvider = DoubleCheck.provider(new SwitchingProvider<LLMRepository>(singletonCImpl, 2));
      this.cashGapDataRepositoryProvider = DoubleCheck.provider(new SwitchingProvider<CashGapDataRepository>(singletonCImpl, 6));
      this.feedDataRepositoryProvider = DoubleCheck.provider(new SwitchingProvider<FeedDataRepository>(singletonCImpl, 7));
      this.forecastDataRepositoryProvider = DoubleCheck.provider(new SwitchingProvider<ForecastDataRepository>(singletonCImpl, 8));
      this.homeDataRepositoryProvider = DoubleCheck.provider(new SwitchingProvider<HomeDataRepository>(singletonCImpl, 9));
      this.paymentConfirmationDataRepositoryProvider = DoubleCheck.provider(new SwitchingProvider<PaymentConfirmationDataRepository>(singletonCImpl, 10));
      this.rescheduleDataRepositoryProvider = DoubleCheck.provider(new SwitchingProvider<RescheduleDataRepository>(singletonCImpl, 11));
    }

    @Override
    public void injectFinanceAssistantApp(FinanceAssistantApp financeAssistantApp) {
    }

    @Override
    public Set<Boolean> getDisableFragmentGetContextFix() {
      return Collections.<Boolean>emptySet();
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
          case 0: // com.finance.assistant.data.repository.MockAssistantRepository 
          return (T) new MockAssistantRepository(ApplicationContextModule_ProvideContextFactory.provideContext(singletonCImpl.applicationContextModule), singletonCImpl.provideGsonProvider.get());

          case 1: // com.google.gson.Gson 
          return (T) LLMModule_ProvideGsonFactory.provideGson();

          case 2: // com.finance.assistant.data.repository.LLMRepository 
          return (T) LLMModule_ProvideLLMRepositoryFactory.provideLLMRepository(singletonCImpl.provideOllamaApiServiceProvider.get(), singletonCImpl.provideGsonProvider.get(), LLMModule_ProvideOllamaModelNameFactory.provideOllamaModelName());

          case 3: // com.finance.assistant.data.remote.OllamaApiService 
          return (T) LLMModule_ProvideOllamaApiServiceFactory.provideOllamaApiService(singletonCImpl.provideOkHttpClientProvider.get(), LLMModule_ProvideOllamaBaseUrlFactory.provideOllamaBaseUrl(), singletonCImpl.provideGsonProvider.get());

          case 4: // okhttp3.OkHttpClient 
          return (T) LLMModule_ProvideOkHttpClientFactory.provideOkHttpClient(singletonCImpl.provideLoggingInterceptorProvider.get());

          case 5: // okhttp3.logging.HttpLoggingInterceptor 
          return (T) LLMModule_ProvideLoggingInterceptorFactory.provideLoggingInterceptor();

          case 6: // com.finance.assistant.data.repository.CashGapDataRepository 
          return (T) new CashGapDataRepository(ApplicationContextModule_ProvideContextFactory.provideContext(singletonCImpl.applicationContextModule), singletonCImpl.provideGsonProvider.get());

          case 7: // com.finance.assistant.data.repository.FeedDataRepository 
          return (T) new FeedDataRepository(ApplicationContextModule_ProvideContextFactory.provideContext(singletonCImpl.applicationContextModule), singletonCImpl.provideGsonProvider.get());

          case 8: // com.finance.assistant.data.repository.ForecastDataRepository 
          return (T) new ForecastDataRepository(ApplicationContextModule_ProvideContextFactory.provideContext(singletonCImpl.applicationContextModule), singletonCImpl.provideGsonProvider.get());

          case 9: // com.finance.assistant.data.repository.HomeDataRepository 
          return (T) new HomeDataRepository(ApplicationContextModule_ProvideContextFactory.provideContext(singletonCImpl.applicationContextModule), singletonCImpl.provideGsonProvider.get());

          case 10: // com.finance.assistant.data.repository.PaymentConfirmationDataRepository 
          return (T) new PaymentConfirmationDataRepository(ApplicationContextModule_ProvideContextFactory.provideContext(singletonCImpl.applicationContextModule), singletonCImpl.provideGsonProvider.get());

          case 11: // com.finance.assistant.data.repository.RescheduleDataRepository 
          return (T) new RescheduleDataRepository(ApplicationContextModule_ProvideContextFactory.provideContext(singletonCImpl.applicationContextModule), singletonCImpl.provideGsonProvider.get());

          default: throw new AssertionError(id);
        }
      }
    }
  }
}
