package com.finance.assistant.ui.screens.viewmodel;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B\u001f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0002\u0010\bJ\b\u0010\u0013\u001a\u00020\u0014H\u0002J\u0006\u0010\u0015\u001a\u00020\u0014J\u0006\u0010\u0016\u001a\u00020\u0014J\u0006\u0010\u0017\u001a\u00020\u0014R\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\f\u001a\n \u000e*\u0004\u0018\u00010\r0\rX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0010\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012\u00a8\u0006\u0018"}, d2 = {"Lcom/finance/assistant/ui/screens/viewmodel/HomeViewModel;", "Landroidx/lifecycle/ViewModel;", "transactionRepository", "Lcom/finance/assistant/data/repository/TransactionRepository;", "insightRepository", "Lcom/finance/assistant/data/repository/InsightRepository;", "expenseRepository", "Lcom/finance/assistant/data/repository/ExpenseRepository;", "(Lcom/finance/assistant/data/repository/TransactionRepository;Lcom/finance/assistant/data/repository/InsightRepository;Lcom/finance/assistant/data/repository/ExpenseRepository;)V", "_uiState", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lcom/finance/assistant/ui/screens/viewmodel/HomeUiState;", "shortDateFormatter", "Ljava/time/format/DateTimeFormatter;", "kotlin.jvm.PlatformType", "uiState", "Lkotlinx/coroutines/flow/StateFlow;", "getUiState", "()Lkotlinx/coroutines/flow/StateFlow;", "loadData", "", "onCashGapActionClick", "onForecastClick", "refresh", "app_debug"})
@dagger.hilt.android.lifecycle.HiltViewModel()
public final class HomeViewModel extends androidx.lifecycle.ViewModel {
    @org.jetbrains.annotations.NotNull()
    private final com.finance.assistant.data.repository.TransactionRepository transactionRepository = null;
    @org.jetbrains.annotations.NotNull()
    private final com.finance.assistant.data.repository.InsightRepository insightRepository = null;
    @org.jetbrains.annotations.NotNull()
    private final com.finance.assistant.data.repository.ExpenseRepository expenseRepository = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.MutableStateFlow<com.finance.assistant.ui.screens.viewmodel.HomeUiState> _uiState = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<com.finance.assistant.ui.screens.viewmodel.HomeUiState> uiState = null;
    private final java.time.format.DateTimeFormatter shortDateFormatter = null;
    
    @javax.inject.Inject()
    public HomeViewModel(@org.jetbrains.annotations.NotNull()
    com.finance.assistant.data.repository.TransactionRepository transactionRepository, @org.jetbrains.annotations.NotNull()
    com.finance.assistant.data.repository.InsightRepository insightRepository, @org.jetbrains.annotations.NotNull()
    com.finance.assistant.data.repository.ExpenseRepository expenseRepository) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<com.finance.assistant.ui.screens.viewmodel.HomeUiState> getUiState() {
        return null;
    }
    
    private final void loadData() {
    }
    
    public final void refresh() {
    }
    
    public final void onCashGapActionClick() {
    }
    
    public final void onForecastClick() {
    }
}