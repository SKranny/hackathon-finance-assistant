package com.finance.assistant.ui.screens.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.finance.assistant.data.model.FeedHeader
import com.finance.assistant.data.model.InsightData
import com.finance.assistant.data.repository.FeedDataRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

data class FeedUiState(
    val header: FeedHeader? = null,
    val insights: List<InsightData> = emptyList(),
    val isLoading: Boolean = true,
)

@HiltViewModel
class FeedViewModel @Inject constructor(
    private val feedDataRepository: FeedDataRepository,
) : ViewModel() {

    private val _uiState = MutableStateFlow(FeedUiState())
    val uiState: StateFlow<FeedUiState> = _uiState.asStateFlow()

    init {
        loadMockData()
    }

    private fun loadMockData() {
        viewModelScope.launch {
            _uiState.value = _uiState.value.copy(isLoading = true)

            try {
                val data = feedDataRepository.getFeedData()
                _uiState.value = FeedUiState(
                    header = data.header,
                    insights = data.insights,
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
}
