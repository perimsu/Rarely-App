package com.example.rarelyapp.ui.profile

sealed interface ProfileScreenAction {
    data class RareNameChanged(val name: String) : ProfileScreenAction
    data class RareDescriptionChanged(val description: String) : ProfileScreenAction
    data class RarePriceChanged(val price: String) : ProfileScreenAction
    object OnUploadClicked : ProfileScreenAction
}
