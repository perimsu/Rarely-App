package com.example.rarelyapp.ui.authentication.create_password

sealed interface CreatePasswordScreenAction {
    data class PasswordChanged(val password: String) : CreatePasswordScreenAction
    data class ConfirmPasswordChanged(val confirmPassword: String) : CreatePasswordScreenAction
    object OnCreatePasswordClicked : CreatePasswordScreenAction
}