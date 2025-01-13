package com.example.rarelyapp.ui.auction

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
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
fun ArtAuctionDetailScreen() {
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

        Box(modifier = Modifier.fillMaxWidth()) {
            Image(
                painter = painterResource(id = R.drawable.artwork),
                contentDescription = "Jean Michel Basquiat - Monster 1983",
                modifier = Modifier
                    .fillMaxWidth()
                    .height(255.dp)
            )
        }

        Spacer(modifier = Modifier.height(24.dp))

        Text(
            text = "Jean Michel Basquiat - Monster 1983",
            fontFamily = playfairdisplay_italic,
            fontWeight = FontWeight.Bold,
            fontSize = 16.sp,
            textAlign = TextAlign.Start,
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 8.dp)
        )

        Text(
            text = "This striking piece by Jean-Michel Basquiat, showcases his iconic neo-expressionist style. It features bold lines, abstract forms, and symbolic elements that reflect Basquiat's raw and unfiltered artistic vision. Monster is a prime example of Basquiat’s exploration of identity, emotion, and cultural commentary, blending chaotic energy with a profound narrative depth.",
            fontFamily = gfs_didot_regular,
            fontSize = 12.sp,
            lineHeight = 20.sp,
            color = Color.DarkGray,
            modifier = Modifier.padding(bottom = 16.dp)
        )

        Text(
            text = "Condition: Maintained in excellent condition, this artwork is preserved to highlight its original colors and intricate details.",
            fontSize = 12.sp,
            fontFamily = playfairdisplay,
            color = Color.Gray,
            textAlign = TextAlign.Start,
            modifier = Modifier.padding(bottom = 6.dp)
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
                text = "Starting Price: 450.00 USD",
                fontWeight = FontWeight.Medium,
                fontFamily = gfs_didot_regular,
                fontSize = 16.sp,
                color = Color.Black
            )
        }

        Spacer(modifier = Modifier.height(16.dp))

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(48.dp)
                .background(
                    color = Color.White,
                    shape = RoundedCornerShape(12.dp)
                )
                .border(
                    width = 1.dp,
                    color = Color(0xFF001F54),
                    shape = RoundedCornerShape(24.dp)
                ),
            contentAlignment = Alignment.CenterStart
        ) {

        }

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = { /* Handle bid placement */ },
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
fun ArtAuctionDetailScreenPreview() {
    MaterialTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            ArtAuctionDetailScreen()
        }
    }
}