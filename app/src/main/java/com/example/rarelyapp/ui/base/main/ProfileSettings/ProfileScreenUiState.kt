package com.example.rarelyapp.ui.profile

data class ProfileScreenUiState(
    val userName: String = "Emily Johnson",
    val followingCount: Int = 45,
    val followerCount: Int = 30,
    val salesCount: Int = 14,
    val rareName: String = "",
    val rareDescription: String = "",
    val rarePrice: String = ""
)
