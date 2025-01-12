package com.example.rarelyapp.ui.auction

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.rarelyapp.R
import com.example.rarelyapp.ui.theme.DarkBlue
import com.example.rarelyapp.ui.theme.aboreto
import com.example.rarelyapp.ui.theme.gfs_didot_regular
import com.example.rarelyapp.ui.theme.playfairdisplay
import com.example.rarelyapp.ui.theme.playfairdisplay_italic
import com.example.rarelyapp.ui.theme.sloop_script_three

@Composable
fun AuctionDetailScreen() {
    var startingPrice by remember { mutableStateOf(30.00) }
    var userInput by remember { mutableStateOf("") }
    var errorMessage by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFFAF7F2))
            .padding(horizontal = 20.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.height(15.dp))

        Text(
            text = "Rarely",
            fontFamily = sloop_script_three,
            color = DarkBlue,
            fontSize = 32.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(top = 16.dp)
        )

        Text(
            text = "AUCTION",
            fontFamily = aboreto,
            color = DarkBlue,
            fontSize = 36.sp,
            letterSpacing = 2.sp,
            modifier = Modifier.padding(bottom = 24.dp)
        )

        Image(
            painter = painterResource(id = R.drawable.birkin),
            contentDescription = "Hermes Birkin Bag",
            modifier = Modifier
                .fillMaxWidth()
                .height(285.dp)
        )

        Spacer(modifier = Modifier.height(24.dp))

        Text(
            text = "Hermes The Fauborg Birkin 24 - 2021",
            fontFamily = playfairdisplay_italic,
            fontWeight = FontWeight.Bold,
            fontSize = 16.sp,
            textAlign = TextAlign.Start,
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 8.dp)
        )

        Text(
            text = "Part of the exclusive Faubourg collection, this Birkin bag stands out with its elegance and sophisticated craftsmanship. Produced in 2021, it is a limited edition piece. Crafted from high-quality leather with impeccable craftsmanship. The Faubourg Birkin redefines luxury with its iconic Hermes lock details and unique patterns. Comes with the original certificate and protective dust bag.",
            fontFamily = gfs_didot_regular,
            fontSize = 12.sp,
            lineHeight = 20.sp,
            color = Color.DarkGray,
            modifier = Modifier.padding(bottom = 16.dp)
        )

        Text(
            text = "Condition: Unused and in pristine condition.",
            fontSize = 12.sp,
            fontFamily = playfairdisplay,
            color = Color.Gray,
            textAlign = TextAlign.Start,
            modifier = Modifier.padding(bottom = 24.dp)
        )

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(
                    color = Color(0xFFF8E9E0),
                    shape = RoundedCornerShape(12.dp)
                )
                .padding(vertical = 6.dp),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = "Starting Price: %.2f USD".format(startingPrice),
                fontWeight = FontWeight.Medium,
                fontFamily = gfs_didot_regular,
                fontSize = 16.sp,
                color = Color.Black
            )
        }

        Spacer(modifier = Modifier.height(16.dp))

        TextField(
            value = userInput,
            onValueChange = { userInput = it },
            modifier = Modifier
                .fillMaxWidth()
                .height(48.dp)
                .background(
                    color = Color(0xFFFAF7F2),
                    shape = RoundedCornerShape(12.dp)
                )
                .border(
                    width = 1.dp,
                    color = Color(0xFF001F54),
                    shape = RoundedCornerShape(24.dp)
                ),
            singleLine = true
        )

        if (errorMessage.isNotEmpty()) {
            Text(
                text = errorMessage,
                color = Color.Red,
                fontSize = 12.sp,
                modifier = Modifier.padding(top = 8.dp)
            )
        }

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = {
                val bid = userInput.toDoubleOrNull()
                if (bid == null) {
                    errorMessage = "Please enter a valid number."
                } else if (bid <= startingPrice) {
                    errorMessage = "Your bid must be higher than the starting price."
                } else {
                    startingPrice = bid
                    errorMessage = ""
                }
            },
            modifier = Modifier
                .fillMaxWidth()
                .height(48.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = DarkBlue
            ),
            shape = RoundedCornerShape(24.dp)
        ) {
            Text(
                text = "Place A Bid",
                fontSize = 20.sp,
                fontWeight = FontWeight.Medium,
                fontFamily = playfairdisplay,
                color = Color.White
            )
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun AuctionDetailScreenPreview() {
    MaterialTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            AuctionDetailScreen()
        }
    }
}
