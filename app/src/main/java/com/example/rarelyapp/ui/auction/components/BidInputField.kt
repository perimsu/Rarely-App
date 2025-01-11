package com.example.rarelyapp.ui.auction.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier

@Composable
fun BidInputField(onBidChanged: (String) -> Unit) {
    val bidValue = remember { mutableStateOf("") }
    TextField(
        value = bidValue.value,
        onValueChange = {
            bidValue.value = it
            onBidChanged(it)
        },
        label = { Text("Enter your bid") },
        modifier = Modifier.fillMaxWidth()
    )
}
