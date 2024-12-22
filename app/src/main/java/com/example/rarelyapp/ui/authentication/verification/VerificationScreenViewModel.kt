package com.example.rarelyapp.ui.authentication.verification

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class VerificationScreenViewModel : ViewModel() {
    var uiState = mutableStateOf(VerificationScreenUiState())
        private set

    fun handleAction(action: VerificationScreenAction) {
        when (action) {
            is VerificationScreenAction.EnterCode -> {
                val updatedCodes = uiState.value.codeInputs.toMutableList()
                updatedCodes[action.index] = action.value
                uiState.value = uiState.value.copy(codeInputs = updatedCodes)
            }

            VerificationScreenAction.ResendCode -> {
                // TODO: resend code logic here
            }

            VerificationScreenAction.SubmitCode -> {
                // TODO: submission logic here
                uiState.value = uiState.value.copy(isSubmitting = true)
            }
        }
    }
}
