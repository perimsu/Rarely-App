package com.example.rarelyapp.ui.auction

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.rarelyapp.ui.auction.components.AuctionHeader
import com.example.rarelyapp.ui.auction.components.AuctionItem

@Composable
fun AuctionScreen(viewModel: AuctionViewModel = viewModel()) {
    val state = viewModel.uiState.collectAsState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        AuctionHeader(title = "Rarely Auction")
        LazyColumn(
            modifier = Modifier.fillMaxSize()
        ) {
            items(state.value.items) { item ->
                AuctionItem(
                    item = item,
                    onPlaceBid = { bidValue ->
                        viewModel.handleAction(AuctionScreenAction.PlaceBid(item.id, bidValue))
                    }
                )
            }
        }
    }
}
