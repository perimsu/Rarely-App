package com.example.rarelyapp.model

data class AuctionItem(
    val id: String,
    val name: String,
    val description: String,
    val startingPrice: String,
    val currentBid: String,
    val imageResId: Int
)
