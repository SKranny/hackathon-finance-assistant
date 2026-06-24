package com.finance.assistant.ui.screens.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.finance.assistant.data.model.RescheduleMockData
import com.finance.assistant.data.repository.RescheduleDataRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

data class RescheduleUiState(
    val data: RescheduleMockData? = null,
    val isLoading: Boolean = true,
)

@HiltViewModel
class RescheduleViewModel @Inject constructor(
    private val repository: RescheduleDataRepository,
) : ViewModel() {

    private val _uiState = MutableStateFlow(RescheduleUiState())
    val uiState: StateFlow<RescheduleUiState> = _uiState.asStateFlow()

    init {
        loadData()
    }

    private fun loadData() {
        viewModelScope.launch {
            _uiState.value = _uiState.value.copy(isLoading = true)
            try {
                val data = repository.getRescheduleData()
                _uiState.value = RescheduleUiState(data = data, isLoading = false)
            } catch (e: Exception) {
                _uiState.value = _uiState.value.copy(isLoading = false)
            }
        }
    }

    fun onConfirm() {
        // Handle confirmation
    }
}
