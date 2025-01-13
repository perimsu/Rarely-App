
package com.example.rarelyapp.ui.base.main.payment.add_card

data class AddCardScreenUiState(
    val cardHolderName: String = "",
    val cardNumber: String = "",
    val expiryDate: String = "",
    val cvv: String = "",
    val cardHolderNameError: String = "",
    val cardNumberError: String = "",
    val expiryDateError: String = "",
    val cvvError: String = "",
    val saveCardChecked: Boolean = false
)
