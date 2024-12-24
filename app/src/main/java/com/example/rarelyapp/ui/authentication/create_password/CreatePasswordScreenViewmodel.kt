package com.example.rarelyapp.ui.authentication.create_password

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class CreatePasswordScreenViewmodel : ViewModel() {

    private val _uiState = MutableStateFlow(CreatePasswordScreenUiState())
    private val uiState = _uiState.asStateFlow()

    //password min 6 characters
    private fun isPasswordValid(password: String): Boolean {
        return password.length >= 6
    }

    //are the two passwords the same
    private fun passwordsMatching(password: String, confirmPassword: String): Boolean{
        return password == confirmPassword
    }

    fun onAction(action: CreatePasswordScreenAction){
        when (action) {
            is CreatePasswordScreenAction.PasswordChanged ->{
                _uiState.update { it.copy(password = action.password, passwordError="") }
            }
            is CreatePasswordScreenAction.ConfirmPasswordChanged ->{
                _uiState.update { it.copy(confirmPassword = action.confirmPassword, confirmPasswordError = "") }
            }
            is CreatePasswordScreenAction.OnCreatePasswordClicked -> {
                //to verify the password
                if (!isPasswordValid(uiState.value.password)) {
                    _uiState.update { it.copy(passwordError = "Password must be at least 6 characters") }
                }
                if (!passwordsMatching(uiState.value.password, uiState.value.confirmPassword)) {
                    _uiState.update { it.copy(confirmPasswordError = "Password do not match") }
                }

            }
        }
    }
}