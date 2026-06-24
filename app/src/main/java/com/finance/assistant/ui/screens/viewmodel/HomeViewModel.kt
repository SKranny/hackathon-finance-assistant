package com.finance.assistant.ui.screens.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.finance.assistant.data.repository.ExpenseRepository
import com.finance.assistant.data.repository.InsightRepository
import com.finance.assistant.data.repository.TransactionRepository
import com.finance.assistant.domain.model.FinancialInsight
import com.finance.assistant.domain.model.InsightSeverity
import com.finance.assistant.domain.model.InsightType
import com.finance.assistant.domain.model.expense.UpcomingExpense
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.util.Locale
import javax.inject.Inject

data class HomeUiState(
    val userName: String = "Артём",
    val freeBalance: Double = 0.0,
    val shortfallAmount: Double? = null,
    val shortfallDate: String? = null,
    val cashGapWarning: FinancialInsight? = null,
    val cashGapDays: Int = 0,
    val upcomingExpenses: List<UpcomingExpense> = emptyList(),
    val totalIncome: Double = 0.0,
    val totalExpenses: Double = 0.0,
    val insights: List<FinancialInsight> = emptyList(),
    val isLoading: Boolean = false,
)

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val transactionRepository: TransactionRepository,
    private val insightRepository: InsightRepository,
    private val expenseRepository: ExpenseRepository,
) : ViewModel() {

    private val _uiState = MutableStateFlow(HomeUiState())
    val uiState: StateFlow<HomeUiState> = _uiState.asStateFlow()

    private val shortDateFormatter = DateTimeFormatter.ofPattern("d MMMM", Locale("ru"))

    init {
        loadData()
    }

    private fun loadData() {
        viewModelScope.launch {
            combine(
                transactionRepository.getAllTransactions(),
                insightRepository.getAllInsights(),
                expenseRepository.getUpcomingExpenses(),
            ) { transactions, insights, upcoming ->
                val income = transactions.filter { it.amount < 0 }.sumOf { -it.amount }
                val expenses = transactions.filter { it.amount > 0 }.sumOf { it.amount }
                val balance = income - expenses

                val cashGap = insights.firstOrNull {
                    it.type == InsightType.CASH_GAP && it.severity == InsightSeverity.CRITICAL
                }
                val daysUntilGap = cashGap?.date?.let {
                    LocalDate.now().until(it).days.coerceAtLeast(0)
                } ?: 0

                HomeUiState(
                    freeBalance = balance,
                    shortfallAmount = cashGap?.relatedAmount,
                    shortfallDate = cashGap?.date?.format(shortDateFormatter),
                    cashGapWarning = cashGap,
                    cashGapDays = daysUntilGap,
                    upcomingExpenses = upcoming.take(5),
                    totalIncome = income,
                    totalExpenses = expenses,
                    insights = insights,
                )
            }.collect { state ->
                _uiState.value = state
            }
        }
    }

    fun refresh() {
        viewModelScope.launch {
            _uiState.update { it.copy(isLoading = true) }
            _uiState.update { it.copy(isLoading = false) }
        }
    }

    fun onCashGapActionClick() {
        // Navigate to cash gap resolution flow
    }

    fun onForecastClick() {
        // Navigate to forecast screen
    }
}
