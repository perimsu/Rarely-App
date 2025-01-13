package com.example.rarelyapp.ui.categories

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
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
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.rarelyapp.R
import com.example.rarelyapp.ui.theme.DarkBlue
import com.example.rarelyapp.ui.theme.aboreto
import com.example.rarelyapp.ui.theme.playfairdisplay

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun ArtScreen(navController: NavHostController) {
    var sortOption by remember { mutableStateOf("Price") }
    var expanded by remember { mutableStateOf(false) }
    val products = listOf(
        ArtScreenItem("Painting", "700 USD", R.drawable.art1),
        ArtScreenItem("Painting", "4,000 USD", R.drawable.art2),
        ArtScreenItem("Painting", "3,500 USD", R.drawable.art3),
        ArtScreenItem("Painting", "2,000 USD", R.drawable.art4)
    )
    val sortedProducts = when (sortOption) {
        "Price" -> products.sortedBy { it.price.replace(",", "").replace("USD", "").trim().toIntOrNull() ?: 0 }
        "Price DESC" -> products.sortedByDescending { it.price.replace(",", "").replace("USD", "").trim().toIntOrNull() ?: 0 }
        "Name" -> products.sortedBy { it.title }
        else -> products
    }

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFFAF7F2))
            .padding(horizontal = 16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        item {
            Spacer(modifier = Modifier.height(24.dp))
            Text(
                text = "ART",
                fontFamily = aboreto,
                color = DarkBlue,
                fontSize = 28.sp,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 24.dp)
            )
        }
        item {
            LargeArtProductCard(
                imageResId = R.drawable.kintsugi_vase,
                title = "Stories Woven in Gold",
                price = "20.000 USD"
            )
        }

        item {
            Box(modifier = Modifier.fillMaxWidth()) {
                Text(
                    text = "Filter",
                    fontFamily = playfairdisplay,
                    fontWeight = FontWeight.Medium,
                    fontSize = 14.sp,
                    modifier = Modifier.clickable { expanded = true }
                )
                DropdownMenu(
                    expanded = expanded,
                    onDismissRequest = { expanded = false },
                    modifier = Modifier.width(200.dp)
                ) {
                    DropdownMenuItem(
                        onClick = {
                            sortOption = "Price"
                            expanded = false
                        },
                        text = { Text("Price: Low to High") }
                    )
                    DropdownMenuItem(
                        onClick = {
                            sortOption = "Price DESC"
                            expanded = false
                        },
                        text = { Text("Price: High to Low") }
                    )
                    DropdownMenuItem(
                        onClick = {
                            sortOption = "Name"
                            expanded = false
                        },
                        text = { Text("Name: A to Z") }
                    )
                }
            }

        }
        item {
            LazyVerticalGrid(
                columns = GridCells.Fixed(2),
                horizontalArrangement = Arrangement.spacedBy(16.dp),
                verticalArrangement = Arrangement.spacedBy(16.dp),
                modifier = Modifier
                    .fillMaxWidth()
                    .heightIn(min = 100.dp, max = 650.dp)
            ) {
                items(sortedProducts) { product ->
                    SmallArtProductCard(
                        title = product.title,
                        price = product.price,
                        imageResId = product.imageResId
                    )
                }
            }
        }
    }
}

@Composable
fun LargeArtProductCard(imageResId: Int, title: String, price: String) {
    var isFavorite by remember { mutableStateOf(false) }

    Card(
        shape = RoundedCornerShape(12.dp),
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 16.dp)
            .shadow(
                elevation = 8.dp,
                shape = RoundedCornerShape(12.dp)
            )
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

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = price,
                        fontFamily = playfairdisplay,
                        fontWeight = FontWeight.ExtraBold,
                        fontSize = 14.sp,
                        color = Color.Black,
                        modifier = Modifier.padding(vertical = 4.dp)
                    )

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
fun SmallArtProductCard(title: String, price: String, imageResId: Int) {
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
            Image(
                painter = painterResource(id = imageResId),
                contentDescription = title,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(180.dp)
            )

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color(0xFFFBEAE9))
                    .padding(16.dp)
            ) {
                Column {
                    Text(
                        text = title,
                        fontFamily = playfairdisplay,
                        fontWeight = FontWeight.Medium,
                        fontSize = 14.sp,
                        color = Color(0xFF1F1F1F)
                    )

                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 8.dp),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = price,
                            fontFamily = playfairdisplay,
                            fontWeight = FontWeight.Bold,
                            fontSize = 14.sp,
                            color = Color(0xFF1F1F1F)
                        )

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

data class ArtScreenItem(
    val title: String,
    val price: String,
    val imageResId: Int
)

@Preview(showBackground = true)
@Composable
fun ArtScreenPreview() {
    MaterialTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            ArtScreen(navController = rememberNavController())        }
    }
}