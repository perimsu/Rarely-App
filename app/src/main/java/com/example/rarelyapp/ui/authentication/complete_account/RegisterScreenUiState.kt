package com.example.rarelyapp.ui.authentication.complete_account

data class RegisterScreenUiState(
    val nameSurname: String = "",
    val email: String = "",
    val password: String = "",
    val rememberMe: Boolean = false,
)
