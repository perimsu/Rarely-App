package com.example.rarelyapp.ui.base.main.payment.add_card

sealed interface AddCardScreenAction {
    data class EnterCardHolderName(val name: String) : AddCardScreenAction
    data class EnterCardNumber(val number: String) : AddCardScreenAction
    data class EnterExpiryDate(val date: String) : AddCardScreenAction
    data class EnterCVV(val cvv: String) : AddCardScreenAction
    data class SaveCardChecked(val checked: Boolean) : AddCardScreenAction
    object SaveCard : AddCardScreenAction
}
