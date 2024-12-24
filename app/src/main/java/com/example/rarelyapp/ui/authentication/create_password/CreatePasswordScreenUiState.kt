package com.example.rarelyapp.ui.authentication.create_password

data class CreatePasswordScreenUiState(
    val password: String = "",
    val confirmPassword: String = "",
    val passwordError: String = "",
    val confirmPasswordError: String = ""
)
