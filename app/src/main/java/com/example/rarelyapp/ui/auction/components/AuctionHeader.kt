package com.example.rarelyapp.ui.auction.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.rarelyapp.R

@Composable
fun AuctionHeader(title: String) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 16.dp),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painter = painterResource(id = R.drawable.rarely), // Rarely görseli
            contentDescription = "Rarely",
            modifier = Modifier
                .height(40.dp)
                .padding(end = 8.dp)
        )

        Image(
            painter = painterResource(id = R.drawable.auction), // Auction görseli
            contentDescription = "Auction",
            modifier = Modifier
                .height(40.dp)
        )
    }
}
