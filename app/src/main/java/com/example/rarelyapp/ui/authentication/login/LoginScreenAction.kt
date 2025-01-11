package com.example.rarelyapp.ui.authentication.login

sealed interface LoginScreenAction {
    data class EmailChanged(val email: String) : LoginScreenAction
    data class PasswordChanged(val password: String) : LoginScreenAction
    data object OnLoginClicked : LoginScreenAction
    data object OnGoogleSignInClicked : LoginScreenAction
    data object OnFacebookSignInClicked : LoginScreenAction
    data object OnPlayStoreSignInClicked : LoginScreenAction
}