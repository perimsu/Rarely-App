package com.example.rarelyapp.ui.authentication.complete_account

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class RegisterScreenViewmodel : ViewModel() {

    private val _uiState = MutableStateFlow(RegisterScreenUiState())
    val uiState = _uiState.asStateFlow()

    fun onAction(action: RegisterScreenAction) {
        when (action) {
            is RegisterScreenAction.NameSurnameChanged -> {
                _uiState.update { it.copy(nameSurname = action.nameSurname) }
            }

            is RegisterScreenAction.EmailChanged -> {
                _uiState.update { it.copy(email = action.email) }
            }

            is RegisterScreenAction.PasswordChanged -> {
                _uiState.update { it.copy(password = action.password) }
            }

            is RegisterScreenAction.RememberMeChanged -> {
                _uiState.update { it.copy(rememberMe = action.rememberMe) }
            }

            is RegisterScreenAction.OnFacebookSignInClicked -> {

            }

            is RegisterScreenAction.OnGoogleSignInClicked -> {

            }

            is RegisterScreenAction.OnPlayStoreSignInClicked -> {

            }

            is RegisterScreenAction.OnRegisterClicked -> {

            }
        }
    }
}