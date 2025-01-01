package com.example.rarelyapp.ui.base.main

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.rarelyapp.R

@Composable
fun FavoritesScreen() {

    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        Image(
            painter = painterResource(id = R.drawable.authentication_flow_background),
            contentDescription = null,
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop
        )
        Column {
            // Başlık
            Text(
                text = "FAVORITES",
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 16.dp),
                textAlign = TextAlign.Center,
                style = TextStyle(
                    fontSize = 21.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.Black
                )
            )

            // Favori listesi
            LazyColumn(
                contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                items(favoriteItemList) { item ->
                    FavoriteItemCard(favoriteItem = item)
                }
            }
        }
    }
}

@Composable
fun FavoriteItemCard(favoriteItem: FavoriteItem) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(16.dp))
            .background(Color(0xFFFAE7E8))
            .padding(8.dp)
            .clickable { /* Tıklama işlemi */ },
        verticalAlignment = Alignment.CenterVertically
    ) {
        // Ürün Görseli
        Image(
            painter = painterResource(id = favoriteItem.image),
            contentDescription = null,
            modifier = Modifier
                .size(80.dp)
                .clip(RoundedCornerShape(12.dp))
        )

        Spacer(modifier = Modifier.width(12.dp))

        // Ürün Bilgileri
        Column(
            modifier = Modifier.weight(1f)
        ) {
            Text(
                text = favoriteItem.name,
                style = TextStyle(
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.Black
                )
            )
            Text(
                text = "${favoriteItem.price} USD",
                style = TextStyle(fontSize = 14.sp, color = Color.Gray)
            )
            Text(
                text = favoriteItem.status,
                style = TextStyle(fontSize = 12.sp, color = Color.Gray)
            )
        }

        Spacer(modifier = Modifier.width(8.dp))

        // "To My Bag" metni ve küçültülmüş buton
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            // "To My Bag" metni
            Text(
                text = "To My Bag",
                style = TextStyle(
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.Black
                )
            )

            Spacer(modifier = Modifier.width(8.dp))

            // "Add to Bag" Butonu
            Box(
                modifier = Modifier
                    .size(30.dp) // Buton boyutunu küçültüyoruz
                    .clip(RoundedCornerShape(15.dp)) // Butonun yuvarlak köşeleri
                    .background(Color(0xFF18223D))
                    .clickable { /* Tıklama işlemi */ },
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = "+",
                    style = TextStyle(
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.White
                    )
                )
            }
        }
    }
}


// Veri modeli
data class FavoriteItem(
    val name: String,
    val price: String,
    val status: String,
    val image: Int
)

// Örnek veri
val favoriteItemList = listOf(
    FavoriteItem("Ocean's Reflection", "7000", "In the favorite list of 3 people", R.drawable.fav1),
    FavoriteItem("Whispering Pathways", "1000", "Not in anyone's favorites", R.drawable.fav2),
    FavoriteItem(
        "Louis Vuitton Belle Époque Carryall",
        "1500",
        "In the favorite list of 7 people",
        R.drawable.fav3
    ),
    FavoriteItem(
        "Rolex Datejust 36",
        "13,000",
        "In the favorite list of 5 people",
        R.drawable.fav4
    ),
    FavoriteItem(
        "Liang Xiu Eternal Blossoms",
        "3000",
        "Not in anyone's favorites",
        R.drawable.fav5
    ),
    FavoriteItem(
        "Miu Miu Arcade leather bag",
        "3500",
        "In the favorite list of 7 people",
        R.drawable.fav6
    )
)

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun PreviewFavoritesScreen() {
    FavoritesScreen()
}