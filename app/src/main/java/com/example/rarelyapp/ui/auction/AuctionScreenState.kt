package com.example.rarelyapp.ui.auction

import com.example.rarelyapp.model.AuctionItem

data class AuctionScreenState(
    val items: List<AuctionItem> = emptyList()
)
