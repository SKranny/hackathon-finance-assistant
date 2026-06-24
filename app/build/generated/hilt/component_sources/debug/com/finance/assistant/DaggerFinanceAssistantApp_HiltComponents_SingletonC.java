package com.finance.assistant;

import android.app.Activity;
import android.app.Service;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.SavedStateHandle;
import androidx.lifecycle.ViewModel;
import com.finance.assistant.data.local.FinanceDatabase;
import com.finance.assistant.data.local.dao.FinancialInsightDao;
import com.finance.assistant.data.local.dao.TransactionDao;
import com.finance.assistant.data.objectbox.ObjectBoxManager;
import com.finance.assistant.data.objectbox.entity.RecurringExpenseEntity;
import com.finance.assistant.data.objectbox.entity.UpcomingExpenseEntity;
import com.finance.assistant.data.objectbox.entity.UserProfileEntity;
import com.finance.assistant.data.objectbox.entity.session.ChatMessageEntity;
import com.finance.assistant.data.objectbox.entity.session.FinanceCaseEntity;
import com.finance.assistant.data.repository.CaseRepository;
import com.finance.assistant.data.repository.ChatRepository;
import com.finance.assistant.data.repository.ExpenseRepository;
import com.finance.assistant.data.repository.InsightRepository;
import com.finance.assistant.data.repository.TransactionRepository;
import com.finance.assistant.data.repository.UserRepository;
import com.finance.assistant.di.AppModule_ProvideFinanceDatabaseFactory;
import com.finance.assistant.di.AppModule_ProvideFinancialInsightDaoFactory;
import com.finance.assistant.di.AppModule_ProvideTransactionDaoFactory;
import com.finance.assistant.di.ObjectBoxModule_ProvideBoxStoreFactory;
import com.finance.assistant.di.ObjectBoxModule_ProvideChatMessageBoxFactory;
import com.finance.assistant.di.ObjectBoxModule_ProvideFinanceCaseBoxFactory;
import com.finance.assistant.di.ObjectBoxModule_ProvideRecurringExpenseBoxFactory;
import com.finance.assistant.di.ObjectBoxModule_ProvideUpcomingExpenseBoxFactory;
import com.finance.assistant.di.ObjectBoxModule_ProvideUserProfileBoxFactory;
import com.finance.assistant.domain.usecase.AssistantUseCase;
import com.finance.assistant.domain.usecase.BalanceForecastUseCase;
import com.finance.assistant.ui.screens.viewmodel.AssistantViewModel;
import com.finance.assistant.ui.screens.viewmodel.AssistantViewModel_HiltModules;
import com.finance.assistant.ui.screens.viewmodel.AssistantViewModel_HiltModules_BindsModule_Binds_LazyMapKey;
import com.finance.assistant.ui.screens.viewmodel.AssistantViewModel_HiltModules_KeyModule_Provide_LazyMapKey;
import com.finance.assistant.ui.screens.viewmodel.HomeViewModel;
import com.finance.assistant.ui.screens.viewmodel.HomeViewModel_HiltModules;
import com.finance.assistant.ui.screens.viewmodel.HomeViewModel_HiltModules_BindsModule_Binds_LazyMapKey;
import com.finance.assistant.ui.screens.viewmodel.HomeViewModel_HiltModules_KeyModule_Provide_LazyMapKey;
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
import io.objectbox.Box;
import io.objectbox.BoxStore;
import java.util.Collections;
import java.util.Map;
import java.util.Set;
import javax.annotation.processing.Generated;

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
      return LazyClassKeyMap.<Boolean>of(MapBuilder.<String, Boolean>newMapBuilder(2).put(AssistantViewModel_HiltModules_KeyModule_Provide_LazyMapKey.lazyClassKeyName, AssistantViewModel_HiltModules.KeyModule.provide()).put(HomeViewModel_HiltModules_KeyModule_Provide_LazyMapKey.lazyClassKeyName, HomeViewModel_HiltModules.KeyModule.provide()).build());
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

    private Provider<HomeViewModel> homeViewModelProvider;

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
      this.homeViewModelProvider = new SwitchingProvider<>(singletonCImpl, activityRetainedCImpl, viewModelCImpl, 1);
    }

    @Override
    public Map<Class<?>, javax.inject.Provider<ViewModel>> getHiltViewModelMap() {
      return LazyClassKeyMap.<javax.inject.Provider<ViewModel>>of(MapBuilder.<String, javax.inject.Provider<ViewModel>>newMapBuilder(2).put(AssistantViewModel_HiltModules_BindsModule_Binds_LazyMapKey.lazyClassKeyName, ((Provider) assistantViewModelProvider)).put(HomeViewModel_HiltModules_BindsModule_Binds_LazyMapKey.lazyClassKeyName, ((Provider) homeViewModelProvider)).build());
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
          return (T) new AssistantViewModel(singletonCImpl.chatRepositoryProvider.get(), singletonCImpl.assistantUseCaseProvider.get());

          case 1: // com.finance.assistant.ui.screens.viewmodel.HomeViewModel 
          return (T) new HomeViewModel(singletonCImpl.transactionRepositoryProvider.get(), singletonCImpl.insightRepositoryProvider.get(), singletonCImpl.expenseRepositoryProvider.get());

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

    private Provider<ObjectBoxManager> objectBoxManagerProvider;

    private Provider<BoxStore> provideBoxStoreProvider;

    private Provider<Box<ChatMessageEntity>> provideChatMessageBoxProvider;

    private Provider<ChatRepository> chatRepositoryProvider;

    private Provider<Box<UserProfileEntity>> provideUserProfileBoxProvider;

    private Provider<UserRepository> userRepositoryProvider;

    private Provider<Box<UpcomingExpenseEntity>> provideUpcomingExpenseBoxProvider;

    private Provider<Box<RecurringExpenseEntity>> provideRecurringExpenseBoxProvider;

    private Provider<ExpenseRepository> expenseRepositoryProvider;

    private Provider<Box<FinanceCaseEntity>> provideFinanceCaseBoxProvider;

    private Provider<CaseRepository> caseRepositoryProvider;

    private Provider<BalanceForecastUseCase> balanceForecastUseCaseProvider;

    private Provider<AssistantUseCase> assistantUseCaseProvider;

    private Provider<FinanceDatabase> provideFinanceDatabaseProvider;

    private Provider<TransactionRepository> transactionRepositoryProvider;

    private Provider<InsightRepository> insightRepositoryProvider;

    private SingletonCImpl(ApplicationContextModule applicationContextModuleParam) {
      this.applicationContextModule = applicationContextModuleParam;
      initialize(applicationContextModuleParam);

    }

    private TransactionDao transactionDao() {
      return AppModule_ProvideTransactionDaoFactory.provideTransactionDao(provideFinanceDatabaseProvider.get());
    }

    private FinancialInsightDao financialInsightDao() {
      return AppModule_ProvideFinancialInsightDaoFactory.provideFinancialInsightDao(provideFinanceDatabaseProvider.get());
    }

    @SuppressWarnings("unchecked")
    private void initialize(final ApplicationContextModule applicationContextModuleParam) {
      this.objectBoxManagerProvider = DoubleCheck.provider(new SwitchingProvider<ObjectBoxManager>(singletonCImpl, 3));
      this.provideBoxStoreProvider = DoubleCheck.provider(new SwitchingProvider<BoxStore>(singletonCImpl, 2));
      this.provideChatMessageBoxProvider = DoubleCheck.provider(new SwitchingProvider<Box<ChatMessageEntity>>(singletonCImpl, 1));
      this.chatRepositoryProvider = DoubleCheck.provider(new SwitchingProvider<ChatRepository>(singletonCImpl, 0));
      this.provideUserProfileBoxProvider = DoubleCheck.provider(new SwitchingProvider<Box<UserProfileEntity>>(singletonCImpl, 6));
      this.userRepositoryProvider = DoubleCheck.provider(new SwitchingProvider<UserRepository>(singletonCImpl, 5));
      this.provideUpcomingExpenseBoxProvider = DoubleCheck.provider(new SwitchingProvider<Box<UpcomingExpenseEntity>>(singletonCImpl, 8));
      this.provideRecurringExpenseBoxProvider = DoubleCheck.provider(new SwitchingProvider<Box<RecurringExpenseEntity>>(singletonCImpl, 9));
      this.expenseRepositoryProvider = DoubleCheck.provider(new SwitchingProvider<ExpenseRepository>(singletonCImpl, 7));
      this.provideFinanceCaseBoxProvider = DoubleCheck.provider(new SwitchingProvider<Box<FinanceCaseEntity>>(singletonCImpl, 11));
      this.caseRepositoryProvider = DoubleCheck.provider(new SwitchingProvider<CaseRepository>(singletonCImpl, 10));
      this.balanceForecastUseCaseProvider = DoubleCheck.provider(new SwitchingProvider<BalanceForecastUseCase>(singletonCImpl, 12));
      this.assistantUseCaseProvider = DoubleCheck.provider(new SwitchingProvider<AssistantUseCase>(singletonCImpl, 4));
      this.provideFinanceDatabaseProvider = DoubleCheck.provider(new SwitchingProvider<FinanceDatabase>(singletonCImpl, 14));
      this.transactionRepositoryProvider = DoubleCheck.provider(new SwitchingProvider<TransactionRepository>(singletonCImpl, 13));
      this.insightRepositoryProvider = DoubleCheck.provider(new SwitchingProvider<InsightRepository>(singletonCImpl, 15));
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
          case 0: // com.finance.assistant.data.repository.ChatRepository 
          return (T) new ChatRepository(singletonCImpl.provideChatMessageBoxProvider.get());

          case 1: // io.objectbox.Box<com.finance.assistant.data.objectbox.entity.session.ChatMessageEntity> 
          return (T) ObjectBoxModule_ProvideChatMessageBoxFactory.provideChatMessageBox(singletonCImpl.provideBoxStoreProvider.get());

          case 2: // io.objectbox.BoxStore 
          return (T) ObjectBoxModule_ProvideBoxStoreFactory.provideBoxStore(singletonCImpl.objectBoxManagerProvider.get());

          case 3: // com.finance.assistant.data.objectbox.ObjectBoxManager 
          return (T) new ObjectBoxManager(ApplicationContextModule_ProvideContextFactory.provideContext(singletonCImpl.applicationContextModule));

          case 4: // com.finance.assistant.domain.usecase.AssistantUseCase 
          return (T) new AssistantUseCase(singletonCImpl.chatRepositoryProvider.get(), singletonCImpl.userRepositoryProvider.get(), singletonCImpl.expenseRepositoryProvider.get(), singletonCImpl.caseRepositoryProvider.get(), singletonCImpl.balanceForecastUseCaseProvider.get());

          case 5: // com.finance.assistant.data.repository.UserRepository 
          return (T) new UserRepository(singletonCImpl.provideUserProfileBoxProvider.get());

          case 6: // io.objectbox.Box<com.finance.assistant.data.objectbox.entity.UserProfileEntity> 
          return (T) ObjectBoxModule_ProvideUserProfileBoxFactory.provideUserProfileBox(singletonCImpl.provideBoxStoreProvider.get());

          case 7: // com.finance.assistant.data.repository.ExpenseRepository 
          return (T) new ExpenseRepository(singletonCImpl.provideUpcomingExpenseBoxProvider.get(), singletonCImpl.provideRecurringExpenseBoxProvider.get());

          case 8: // io.objectbox.Box<com.finance.assistant.data.objectbox.entity.UpcomingExpenseEntity> 
          return (T) ObjectBoxModule_ProvideUpcomingExpenseBoxFactory.provideUpcomingExpenseBox(singletonCImpl.provideBoxStoreProvider.get());

          case 9: // io.objectbox.Box<com.finance.assistant.data.objectbox.entity.RecurringExpenseEntity> 
          return (T) ObjectBoxModule_ProvideRecurringExpenseBoxFactory.provideRecurringExpenseBox(singletonCImpl.provideBoxStoreProvider.get());

          case 10: // com.finance.assistant.data.repository.CaseRepository 
          return (T) new CaseRepository(singletonCImpl.provideFinanceCaseBoxProvider.get(), singletonCImpl.provideUpcomingExpenseBoxProvider.get());

          case 11: // io.objectbox.Box<com.finance.assistant.data.objectbox.entity.session.FinanceCaseEntity> 
          return (T) ObjectBoxModule_ProvideFinanceCaseBoxFactory.provideFinanceCaseBox(singletonCImpl.provideBoxStoreProvider.get());

          case 12: // com.finance.assistant.domain.usecase.BalanceForecastUseCase 
          return (T) new BalanceForecastUseCase(singletonCImpl.userRepositoryProvider.get(), singletonCImpl.expenseRepositoryProvider.get());

          case 13: // com.finance.assistant.data.repository.TransactionRepository 
          return (T) new TransactionRepository(singletonCImpl.transactionDao());

          case 14: // com.finance.assistant.data.local.FinanceDatabase 
          return (T) AppModule_ProvideFinanceDatabaseFactory.provideFinanceDatabase(ApplicationContextModule_ProvideContextFactory.provideContext(singletonCImpl.applicationContextModule));

          case 15: // com.finance.assistant.data.repository.InsightRepository 
          return (T) new InsightRepository(singletonCImpl.financialInsightDao());

          default: throw new AssertionError(id);
        }
      }
    }
  }
}
