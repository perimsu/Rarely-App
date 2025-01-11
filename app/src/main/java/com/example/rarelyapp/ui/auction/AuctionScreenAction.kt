package com.example.rarelyapp.ui.auction

sealed class AuctionScreenAction {
    data class PlaceBid(val itemId: String, val bidValue: String) : AuctionScreenAction()
}
