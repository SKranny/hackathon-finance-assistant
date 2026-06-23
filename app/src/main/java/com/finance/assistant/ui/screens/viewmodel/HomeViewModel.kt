package com.finance.assistant.ui.screens.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.finance.assistant.data.repository.InsightRepository
import com.finance.assistant.data.repository.TransactionRepository
import com.finance.assistant.domain.model.FinancialInsight
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

data class HomeUiState(
    val totalIncome: Double = 0.0,
    val totalExpenses: Double = 0.0,
    val insights: List<FinancialInsight> = emptyList(),
    val isLoading: Boolean = false,
)

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val transactionRepository: TransactionRepository,
    private val insightRepository: InsightRepository,
) : ViewModel() {

    private val _uiState = MutableStateFlow(HomeUiState())
    val uiState: StateFlow<HomeUiState> = _uiState.asStateFlow()

    init {
        loadData()
    }

    private fun loadData() {
        viewModelScope.launch {
            combine(
                transactionRepository.getAllTransactions(),
                insightRepository.getAllInsights(),
            ) { transactions, insights ->
                val income = transactions.filter { it.amount < 0 }.sumOf { -it.amount }
                val expenses = transactions.filter { it.amount > 0 }.sumOf { it.amount }
                HomeUiState(
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
}
