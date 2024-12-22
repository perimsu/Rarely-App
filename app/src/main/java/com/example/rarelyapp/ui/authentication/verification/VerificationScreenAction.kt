package com.example.rarelyapp.ui.authentication.verification

sealed class VerificationScreenAction {
    data class EnterCode(val index: Int, val value: String) : VerificationScreenAction()
    data object ResendCode : VerificationScreenAction()
    data object SubmitCode : VerificationScreenAction()
}