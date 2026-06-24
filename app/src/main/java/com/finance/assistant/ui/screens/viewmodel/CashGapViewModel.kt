package com.finance.assistant.ui.screens.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.finance.assistant.data.model.CashGapMockData
import com.finance.assistant.data.repository.CashGapDataRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

data class CashGapUiState(
    val data: CashGapMockData? = null,
    val isLoading: Boolean = true,
)

@HiltViewModel
class CashGapViewModel @Inject constructor(
    private val repository: CashGapDataRepository,
) : ViewModel() {

    private val _uiState = MutableStateFlow(CashGapUiState())
    val uiState: StateFlow<CashGapUiState> = _uiState.asStateFlow()

    init {
        loadData()
    }

    private fun loadData() {
        viewModelScope.launch {
            _uiState.value = _uiState.value.copy(isLoading = true)
            try {
                val data = repository.getCashGapData()
                _uiState.value = CashGapUiState(data = data, isLoading = false)
            } catch (e: Exception) {
                _uiState.value = _uiState.value.copy(isLoading = false)
            }
        }
    }

    fun onPrimaryActionClick() {
        // Navigate to reschedule payment
    }
}
