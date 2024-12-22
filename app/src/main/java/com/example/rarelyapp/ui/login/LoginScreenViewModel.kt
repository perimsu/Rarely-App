package com.example.rarelyapp.ui.authentication.login

import androidx.lifecycle.ViewModel
import com.example.rarelyapp.ui.login.LoginScreenAction
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class LoginScreenViewModel : ViewModel() {

    private val _uiState = MutableStateFlow(LoginScreenUiState())
    val uiState = _uiState.asStateFlow()

    fun onAction(action: LoginScreenAction) {
        when (action) {
            is LoginScreenAction.EmailChanged -> {
                _uiState.update { it.copy(email = action.email) }
            }

            is LoginScreenAction.PasswordChanged -> {
                _uiState.update { it.copy(password = action.password) }
            }

            is LoginScreenAction.OnLoginClicked -> {
                // Login işlemi burada ele alınır.
            }

            is LoginScreenAction.OnGoogleSignInClicked -> {

            }

            is LoginScreenAction.OnFacebookSignInClicked -> {

            }

            is LoginScreenAction.OnPlayStoreSignInClicked -> {

            }
        }
    }
}
