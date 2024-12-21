package com.example.rarelyapp.ui.authentication.complete_account

sealed interface CompleteProfileScreenAction {
    data class UserNameChanged(val username: String) : CompleteProfileScreenAction
    data class PhoneNumberChanged(val phoneNumber: String) : CompleteProfileScreenAction
    data class GenderChanged(val gender: String) : CompleteProfileScreenAction
    data class OnProfilePictureSelected(val profilePicture: String) : CompleteProfileScreenAction
    data object OnCompleteProfileClicked : CompleteProfileScreenAction
}