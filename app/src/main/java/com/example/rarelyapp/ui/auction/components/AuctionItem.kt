package com.example.rarelyapp.ui.auction.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.rarelyapp.model.AuctionItem

@Composable
fun AuctionItem(item: AuctionItem, onPlaceBid: (String) -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        Image(
            painter = painterResource(id = item.imageResId),
            contentDescription = item.name,
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp)
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(text = item.name)
        Text(text = item.description)
        Text(text = "Starting Price: ${item.startingPrice}")
        Spacer(modifier = Modifier.height(8.dp))
        // Placeholder for BidInputField and BidButton
    }
}
