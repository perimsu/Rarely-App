package com.example.rarelyapp.ui.authentication.complete_account

sealed interface RegisterScreenAction {
    data class NameSurnameChanged(val nameSurname: String) : RegisterScreenAction
    data class EmailChanged(val email: String) : RegisterScreenAction
    data class PasswordChanged(val password: String) : RegisterScreenAction
    data class RememberMeChanged(val rememberMe: Boolean) : RegisterScreenAction
    data object OnRegisterClicked : RegisterScreenAction
    data object OnGoogleSignInClicked : RegisterScreenAction
    data object OnFacebookSignInClicked : RegisterScreenAction
    data object OnPlayStoreSignInClicked : RegisterScreenAction
}