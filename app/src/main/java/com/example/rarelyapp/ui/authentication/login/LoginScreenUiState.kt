package com.example.rarelyapp.ui.authentication.login

data class LoginScreenUiState(
    val email: String = "",
    val password: String = "",
    val rememberMe : Boolean = false,
)
