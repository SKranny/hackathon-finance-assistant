package com.finance.assistant.ui.screens.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.finance.assistant.data.model.PaymentConfirmationMockData
import com.finance.assistant.data.repository.PaymentConfirmationDataRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

data class PaymentConfirmationUiState(
    val data: PaymentConfirmationMockData? = null,
    val isLoading: Boolean = true,
)

@HiltViewModel
class PaymentConfirmationViewModel @Inject constructor(
    private val repository: PaymentConfirmationDataRepository,
) : ViewModel() {

    private val _uiState = MutableStateFlow(PaymentConfirmationUiState())
    val uiState: StateFlow<PaymentConfirmationUiState> = _uiState.asStateFlow()

    init {
        loadData()
    }

    private fun loadData() {
        viewModelScope.launch {
            _uiState.value = _uiState.value.copy(isLoading = true)
            try {
                val data = repository.getPaymentConfirmationData()
                _uiState.value = PaymentConfirmationUiState(data = data, isLoading = false)
            } catch (e: Exception) {
                _uiState.value = _uiState.value.copy(isLoading = false)
            }
        }
    }
}
