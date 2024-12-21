package com.example.rarelyapp.ui.authentication.complete_account

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class CompleteProfileScreenViewmodel : ViewModel() {

    private val _uiState = MutableStateFlow(CompleteProfileScreenUiState())
    val uiState = _uiState.asStateFlow()

    fun onAction(action: CompleteProfileScreenAction) {
        when (action) {
            is CompleteProfileScreenAction.UserNameChanged -> {
                _uiState.update { it.copy(username = action.username) }
            }

            is CompleteProfileScreenAction.PhoneNumberChanged -> {
                _uiState.update { it.copy(phoneNumber = action.phoneNumber) }
            }

            is CompleteProfileScreenAction.GenderChanged -> {
                _uiState.update { it.copy(gender = action.gender) }
            }

            is CompleteProfileScreenAction.OnCompleteProfileClicked -> {

            }

            is CompleteProfileScreenAction.OnProfilePictureSelected -> {

            }
        }
    }
}