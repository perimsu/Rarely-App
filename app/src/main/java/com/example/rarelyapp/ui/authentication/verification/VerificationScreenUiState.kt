package com.example.rarelyapp.ui.authentication.verification

data class VerificationScreenUiState(
    val codeInputs: List<String> = List(4) { "" },
    val isSubmitting: Boolean = false,
    val errorMessage: String? = null
)
