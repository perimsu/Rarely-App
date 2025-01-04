package com.example.rarelyapp.ui.profile

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class ProfileScreenViewModel : ViewModel() {

    private val _uiState = MutableStateFlow(ProfileScreenUiState())
    val uiState = _uiState.asStateFlow()

    fun onAction(action: ProfileScreenAction) {
        when (action) {
            is ProfileScreenAction.RareNameChanged -> {
                _uiState.update { it.copy(rareName = action.name) }
            }
            is ProfileScreenAction.RareDescriptionChanged -> {
                _uiState.update { it.copy(rareDescription = action.description) }
            }
            is ProfileScreenAction.RarePriceChanged -> {
                _uiState.update { it.copy(rarePrice = action.price) }
            }
            is ProfileScreenAction.OnUploadClicked -> {
                // Yükleme işlemleri burada yapılır.
            }
        }
    }
}
