package com.example.rarelyapp.ui.base.main.payment.add_card

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class AddCardScreenViewModel : ViewModel() {

    private val _uiState = MutableStateFlow(AddCardScreenUiState())
    val uiState = _uiState.asStateFlow()

    fun onAction(action: AddCardScreenAction) {
        when (action) {
            is AddCardScreenAction.EnterCardHolderName -> {
                _uiState.value = _uiState.value.copy(cardHolderName = action.name)
            }
            is AddCardScreenAction.EnterCardNumber -> {
                _uiState.value = _uiState.value.copy(cardNumber = action.number)
            }
            is AddCardScreenAction.EnterExpiryDate -> {
                _uiState.value = _uiState.value.copy(expiryDate = action.date)
            }
            is AddCardScreenAction.EnterCVV -> {
                _uiState.value = _uiState.value.copy(cvv = action.cvv)
            }
            is AddCardScreenAction.SaveCard -> {
                // Burada kartı kaydetme işlemi yapılabilir (örneğin bir API çağrısı)
            }

            is AddCardScreenAction.SaveCardChecked -> TODO()
        }
    }
}