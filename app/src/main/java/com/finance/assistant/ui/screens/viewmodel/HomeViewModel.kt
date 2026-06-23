package com.finance.assistant.ui.screens.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.finance.assistant.data.repository.CaseRepository
import com.finance.assistant.data.repository.TransactionRepository
import com.finance.assistant.domain.model.alert.CaseResolution
import com.finance.assistant.domain.model.alert.ScheduledExpenseCase
import com.finance.assistant.domain.model.alert.SavingsRecommendation
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
    val scheduledExpenses: List<ScheduledExpenseCase> = emptyList(),
    val isLoading: Boolean = false,
    val savingsPlanStarted: Boolean = false,
)

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val transactionRepository: TransactionRepository,
    private val caseRepository: CaseRepository,
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
                caseRepository.getActiveCases(),
            ) { transactions, cases ->
                val income = transactions.filter { it.amount < 0 }.sumOf { -it.amount }
                val expenses = transactions.filter { it.amount > 0 }.sumOf { it.amount }
                val scheduledExpenses = cases.filterIsInstance<ScheduledExpenseCase>()
                HomeUiState(
                    totalIncome = income,
                    totalExpenses = expenses,
                    scheduledExpenses = scheduledExpenses,
                )
            }.collect { state ->
                _uiState.value = state
            }
        }
    }

    fun resolveCase(case: ScheduledExpenseCase, resolution: CaseResolution) {
        viewModelScope.launch {
            _uiState.update { it.copy(isLoading = true) }
            try {
                caseRepository.markCaseResolved(case.id)
                _uiState.update { state ->
                    state.copy(
                        isLoading = false,
                        scheduledExpenses = state.scheduledExpenses.filter { it.id != case.id },
                    )
                }
            } catch (e: Exception) {
                _uiState.update { it.copy(isLoading = false) }
            }
        }
    }

    fun startSavingsPlan(case: ScheduledExpenseCase, recommendation: SavingsRecommendation, targetAmount: Double) {
        viewModelScope.launch {
            _uiState.update { it.copy(savingsPlanStarted = true) }
            try {
            } finally {
                _uiState.update { it.copy(savingsPlanStarted = false) }
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
