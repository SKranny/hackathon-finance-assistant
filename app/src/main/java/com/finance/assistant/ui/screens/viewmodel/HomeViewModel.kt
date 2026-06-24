package com.finance.assistant.ui.screens.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.finance.assistant.data.model.HomeMockData
import com.finance.assistant.data.model.UpcomingEventData
import com.finance.assistant.data.repository.HomeDataRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

data class HomeUiState(
    val userName: String = "",
    val avatarInitial: String = "",
    val freeBalance: Double = 0.0,
    val currency: String = "₽",
    val shortfallAmount: Double? = null,
    val shortfallDays: Int? = null,
    val shortfallDate: String? = null,
    val cashGapTitle: String = "",
    val cashGapBody: String = "",
    val cashGapVisible: Boolean = false,
    val upcomingEvents: List<UpcomingEventData> = emptyList(),
    val totalIncome: Double = 0.0,
    val totalExpenses: Double = 0.0,
    val isLoading: Boolean = true,
)

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val homeDataRepository: HomeDataRepository,
) : ViewModel() {

    private val _uiState = MutableStateFlow(HomeUiState())
    val uiState: StateFlow<HomeUiState> = _uiState.asStateFlow()

    init {
        loadMockData()
    }

    private fun loadMockData() {
        viewModelScope.launch {
            _uiState.value = _uiState.value.copy(isLoading = true)
            
            try {
                val data = homeDataRepository.getHomeData()
                _uiState.value = HomeUiState(
                    userName = data.user.name,
                    avatarInitial = data.user.avatarInitial,
                    freeBalance = data.balance.freeBalance,
                    currency = data.balance.currency,
                    shortfallAmount = data.balance.shortfallAmount,
                    shortfallDays = data.balance.shortfallDays,
                    shortfallDate = data.balance.shortfallDate,
                    cashGapTitle = data.cashGapAlert.title,
                    cashGapBody = data.cashGapAlert.body,
                    cashGapVisible = data.cashGapAlert.isVisible,
                    upcomingEvents = data.upcomingEvents,
                    totalIncome = data.summary.totalIncome,
                    totalExpenses = data.summary.totalExpenses,
                    isLoading = false,
                )
            } catch (e: Exception) {
                _uiState.value = _uiState.value.copy(isLoading = false)
            }
        }
    }

    fun refresh() {
        loadMockData()
    }

    fun onCashGapActionClick() {
        // Navigate to cash gap resolution flow
    }

    fun onForecastClick() {
        // Navigate to forecast screen
    }
}
