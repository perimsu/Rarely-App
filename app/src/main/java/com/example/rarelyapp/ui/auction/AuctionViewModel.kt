package com.example.rarelyapp.ui.auction

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import com.example.rarelyapp.model.AuctionItem
import com.example.rarelyapp.R

class AuctionViewModel : ViewModel() {
    private val _uiState = MutableStateFlow(
        AuctionScreenState(
            items = listOf(
                AuctionItem(
                    id = "1",
                    name = "Hermes Birkin Bag",
                    description = "Exclusive luxury bag.",
                    startingPrice = "30.00",
                    currentBid = "30.00",
                    imageResId = R.drawable.birkin
                ),
                AuctionItem(
                    id = "2",
                    name = "Jean Michel Basquiat Art",
                    description = "Rare 1983 artwork.",
                    startingPrice = "450.00",
                    currentBid = "450.00",
                    imageResId = R.drawable.artwork
                )
            )
        )
    )
    val uiState: StateFlow<AuctionScreenState> = _uiState

    fun handleAction(action: AuctionScreenAction) {
        when (action) {
            is AuctionScreenAction.PlaceBid -> {
                val updatedItems = _uiState.value.items.map { item ->
                    if (item.id == action.itemId) {
                        item.copy(currentBid = action.bidValue)
                    } else item
                }
                _uiState.value = _uiState.value.copy(items = updatedItems)
            }
        }
    }
}
