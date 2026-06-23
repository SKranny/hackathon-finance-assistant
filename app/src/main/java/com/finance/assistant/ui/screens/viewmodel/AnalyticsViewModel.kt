package com.finance.assistant.ui.screens.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.finance.assistant.data.repository.TransactionRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

data class AnalyticsUiState(
    val predictedIncome: Double = 0.0,
    val predictedExpenses: Double = 0.0,
    val categoryBreakdown: Map<String, Double> = emptyMap(),
)

@HiltViewModel
class AnalyticsViewModel @Inject constructor(
    private val transactionRepository: TransactionRepository,
) : ViewModel() {

    private val _uiState = MutableStateFlow(AnalyticsUiState())
    val uiState: StateFlow<AnalyticsUiState> = _uiState.asStateFlow()

    init {
        viewModelScope.launch {
            transactionRepository.getAllTransactions().collect { transactions ->
                val income = transactions.filter { it.amount < 0 }.sumOf { -it.amount }
                val expenses = transactions.filter { it.amount > 0 }.sumOf { it.amount }
                val breakdown = transactions
                    .filter { it.amount > 0 }
                    .groupBy { it.category.name }
                    .mapValues { (_, list) -> list.sumOf { it.amount } }

                _uiState.update {
                    it.copy(
                        predictedIncome = income,
                        predictedExpenses = expenses,
                        categoryBreakdown = breakdown,
                    )
                }
            }
        }
    }
}
