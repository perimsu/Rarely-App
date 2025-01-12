package com.example.rarelyapp.ui.categories

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.rarelyapp.R
import com.example.rarelyapp.ui.theme.DarkBlue
import com.example.rarelyapp.ui.theme.aboreto
import com.example.rarelyapp.ui.theme.playfairdisplay

@Composable
fun CollaborationsScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .background(Color(0xFFFAF7F2))
            .padding(horizontal = 16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.height(24.dp))

        Text(
            text = "COLLABORATIONS",
            fontFamily = aboreto,
            color = DarkBlue,
            fontSize = 28.sp,
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(bottom = 24.dp)
        )

        LargeCollaborationsProductCard(
            imageResId = R.drawable.cartier,
            title = "Cartier Tank Francasie Watch",
            price = "10.000 USD"
        )

        Text(
            text = "Filter",
            fontFamily = playfairdisplay,
            fontWeight = FontWeight.Medium,
            fontSize = 14.sp,
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp)
        )

        val products = listOf(
            CollaborationsItem("Dior Saddle Bag", "4,700 USD", R.drawable.dior, R.drawable._00px_dior_logo_svg_1),
            CollaborationsItem("Chanel Ribbon Dress", "9,500 USD", R.drawable.chanel, R.drawable.chanel_logo_svg_1)
        )

        LazyRow(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            items(products) { product ->
                SmallCollaborationsProductCard(
                    title = product.title,
                    price = product.price,
                    brand = if (product.brandLogoResId == R.drawable._00px_dior_logo_svg_1) "Dior" else "CHANEL",
                    imageResId = product.imageResId,
                    brandLogoResId = product.brandLogoResId
                )
            }
        }
    }
}

@Composable
fun LargeCollaborationsProductCard(imageResId: Int, title: String, price: String) {
    var isFavorite by remember { mutableStateOf(false) }

    Card(
        shape = RoundedCornerShape(12.dp),
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 16.dp)
            .shadow(4.dp, shape = RoundedCornerShape(12.dp)),
        colors = CardDefaults.cardColors(containerColor = Color.White)
    ) {
        Column(modifier = Modifier.background(Color.White)) {
            Image(
                painter = painterResource(id = imageResId),
                contentDescription = title,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(382.dp)
            )
            Spacer(modifier = Modifier.height(8.dp))

            Column(modifier = Modifier.padding(16.dp)) {
                Text(
                    text = title,
                    fontFamily = playfairdisplay,
                    fontWeight = FontWeight.Medium,
                    fontSize = 16.sp
                )
                Text(
                    text = price,
                    fontFamily = playfairdisplay,
                    fontWeight = FontWeight.ExtraBold,
                    fontSize = 14.sp,
                    color = Color.Black,
                    modifier = Modifier.padding(vertical = 4.dp)
                )
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.rarely),
                            contentDescription = "Rarely Logo",
                            modifier = Modifier
                                .width(50.dp)
                                .height(20.dp)
                        )
                        Spacer(modifier = Modifier.width(4.dp))
                        Text(
                            text = "x",
                            fontFamily = playfairdisplay,
                            fontSize = 14.sp,
                            color = Color.Gray,
                            modifier = Modifier.padding(horizontal = 4.dp)
                        )
                        Image(
                            painter = painterResource(id = R.drawable.cartier_logo_svg_1),
                            contentDescription = "Cartier Logo",
                            modifier = Modifier
                                .width(50.dp)
                                .height(20.dp)
                        )
                    }

                    IconButton(onClick = { isFavorite = !isFavorite }) {
                        Icon(
                            painter = painterResource(id = R.drawable.favv_6),
                            contentDescription = "Favorite",
                            tint = if (isFavorite) Color.Red else Color.Gray,
                            modifier = Modifier.size(20.dp)
                        )
                    }
                }
            }
            Divider(
                color = Color.Gray,
                thickness = 1.dp,
                modifier = Modifier.fillMaxWidth()
                    .padding(top = 0.dp)
            )
        }
    }
}

@Composable
fun SmallCollaborationsProductCard(title: String, price: String, brand: String, imageResId: Int, brandLogoResId: Int) {
    var isFavorite by remember { mutableStateOf(false) }

    Card(
        shape = RoundedCornerShape(16.dp),
        modifier = Modifier
            .width(180.dp)
            .wrapContentHeight(),
        colors = CardDefaults.cardColors(containerColor = Color(0xFFFBEAE9))
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(180.dp)
            ) {
                Image(
                    painter = painterResource(id = imageResId),
                    contentDescription = title,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier.fillMaxSize()
                )
            }

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color(0xFFFBEAE9))
                    .padding(horizontal = 16.dp, vertical = 12.dp)
            ) {
                Column {
                    Text(
                        text = title,
                        fontFamily = playfairdisplay,
                        fontWeight = FontWeight.Medium,
                        fontSize = 14.sp,
                        color = Color(0xFF1F1F1F)
                    )

                    Text(
                        text = price,
                        fontFamily = playfairdisplay,
                        fontSize = 14.sp,
                        fontWeight = FontWeight.ExtraBold,
                        color = Color(0xFF1F1F1F),
                        modifier = Modifier.padding(top = 4.dp)
                    )

                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 8.dp),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Image(
                                painter = painterResource(id = R.drawable.rarely),
                                contentDescription = "Rarely Logo",
                                modifier = Modifier
                                    .width(40.dp)
                                    .height(16.dp)
                            )
                            Spacer(modifier = Modifier.width(4.dp))
                            Text(
                                text = "x",
                                fontFamily = playfairdisplay,
                                fontSize = 14.sp,
                                color = Color.Gray
                            )
                            Spacer(modifier = Modifier.width(4.dp))
                            Image(
                                painter = painterResource(id = brandLogoResId),
                                contentDescription = "$brand Logo",
                                modifier = Modifier
                                    .width(40.dp)
                                    .height(16.dp)
                            )
                        }

                        IconButton(onClick = { isFavorite = !isFavorite }) {
                            Icon(
                                painter = painterResource(id = R.drawable.favv_6),
                                contentDescription = "Favorite",
                                tint = if (isFavorite) Color.Red else Color.Gray,
                                modifier = Modifier.size(20.dp)
                            )
                        }
                    }
                }
            }
        }
    }
}

data class CollaborationsItem(
    val title: String,
    val price: String,
    val imageResId: Int,
    val brandLogoResId: Int
)

@Preview(showBackground = true)
@Composable
fun CollaborationsScreenPreview() {
    MaterialTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            CollaborationsScreen()
        }
    }
}
