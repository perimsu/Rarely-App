package com.example.rarelyapp.ui.base.main

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import kotlinx.coroutines.launch
import com.example.rarelyapp.R
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.example.rarelyapp.data.api.RetrofitClient
import com.example.rarelyapp.data.model.Product

@OptIn(ExperimentalGlideComposeApi::class)
@Composable
fun HomeScreen() {

    var products by remember { mutableStateOf<List<Product>>(emptyList()) }
    val scope = rememberCoroutineScope()


    LaunchedEffect(Unit) {
        scope.launch {
            try {
                products = RetrofitClient.api.getProducts()
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }

    val recommendedItems = listOf(
        Pair(R.drawable.home_pd_1, "Miu Miu Pink Cardigan"),
        Pair(R.drawable.home_pd_2, "Jeff Koons Rabbit Sculpture"),
        Pair(R.drawable.home_pd_3, "Breitling Navitimer 1.1 Watch")
    )

    val topCollectors = listOf(
        Pair(R.drawable.pp_1, "@mirandalove34"),
        Pair(R.drawable.pp_2, "@babybluee465"),
        Pair(R.drawable.pp_3, "@jackhouston"),
        Pair(R.drawable.pp_4, "@pinkcandyy")
    )

    val topCollectorsBg = listOf(
        R.drawable.pp_1_bg,
        R.drawable.pp_2_bg,
        R.drawable.pp_3_bg,
        R.drawable.pp_4_bg
    )

    // Vertical scroll state
    val scrollState = rememberScrollState()

    Column(
        modifier = Modifier
            .padding(16.dp)
            .verticalScroll(scrollState)
    ) {
        Text(
            text = "Explore",
            style = MaterialTheme.typography.titleMedium,
            modifier = Modifier.padding(vertical = 8.dp),
            textAlign = TextAlign.Center
        )
        Spacer(modifier = Modifier.height(8.dp))
        TextField(
            value = "",
            onValueChange = {},
            placeholder = { Text("Search") },
            leadingIcon = { Icon(Icons.Default.Search, contentDescription = null) },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(16.dp))
        Text(text = "Top Collections", style = MaterialTheme.typography.titleMedium)
        Spacer(modifier = Modifier.height(4.dp))
        LazyRow(
            modifier = Modifier
                .background(Color(0xFFD9D9D9))
                .padding(4.dp)
        ) {
            items(products.take(5)) { product ->
                GlideImage(
                    model = product.image,
                    contentDescription = product.title,
                    modifier = Modifier
                        .size(75.dp)
                        .padding(4.dp)
                        .clip(RoundedCornerShape(8.dp))
                        .background(Color.Gray)
                )
            }
        }

        Spacer(modifier = Modifier.height(4.dp))
        LazyRow(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color(0xFFD9D9D9))
                .padding(4.dp)
        ) {
            items(products.drop(5).take(4)) { product ->
                GlideImage(
                    model = product.image,
                    contentDescription = product.title,
                    modifier = Modifier
                        .size(75.dp)
                        .padding(4.dp)
                        .clip(RoundedCornerShape(8.dp))
                        .background(Color.Gray)
                )
            }
        }

        Spacer(modifier = Modifier.height(4.dp))
        LazyRow(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color(0xFFD9D9D9))
                .padding(4.dp)
        ) {
            items(products.drop(9).take(4)) { product ->
                GlideImage(
                    model = product.image,
                    contentDescription = product.title,
                    modifier = Modifier
                        .size(75.dp)
                        .padding(4.dp)
                        .clip(RoundedCornerShape(8.dp))
                        .background(Color.Gray)
                )
            }
        }
        Spacer(modifier = Modifier.height(16.dp))

        // "You May Also Like" Section
        Text(text = "You May Also Like", style = MaterialTheme.typography.titleMedium)
        Spacer(modifier = Modifier.height(8.dp))
        LazyRow {
            items(recommendedItems) { item ->
                Column(
                    modifier = Modifier
                        .padding(8.dp)
                        .clip(RoundedCornerShape(8.dp))
                        .background(Color(0xFFFAE7E8))
                        .width(150.dp)
                ) {
                    Image(
                        painter = painterResource(id = item.first),
                        contentDescription = null,
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(140.dp)
                            .clip(RoundedCornerShape(8.dp))
                            .align(Alignment.CenterHorizontally)
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    Text(
                        text = item.second,
                        style = MaterialTheme.typography.bodyMedium,
                        modifier = Modifier.padding(8.dp),
                        textAlign = TextAlign.Center
                    )
                }
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        // "Top Collectors" Section
        Text(text = "Top Collectors", style = MaterialTheme.typography.titleMedium)
        Spacer(modifier = Modifier.height(8.dp))
        LazyRow {
            items(topCollectors.zip(topCollectorsBg)) { (collector, bgRes) ->
                Box(
                    modifier = Modifier
                        .padding(8.dp)
                        .width(110.dp)
                        .height(125.dp)
                        .clip(RoundedCornerShape(8.dp))
                ) {
                    Image(
                        painter = painterResource(id = bgRes),
                        contentDescription = null,
                        contentScale = ContentScale.Crop,
                        modifier = Modifier.fillMaxSize()
                    )
                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(8.dp),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center
                    ) {
                        Image(
                            painter = painterResource(id = collector.first),
                            contentDescription = null,
                            modifier = Modifier
                                .size(60.dp)
                                .clip(CircleShape)
                        )
                        Spacer(modifier = Modifier.height(8.dp))
                        Text(
                            text = collector.second,
                            color = Color.White,
                            style = MaterialTheme.typography.bodySmall,
                            textAlign = TextAlign.Center
                        )
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun HomeScreenPreview() {
    HomeScreen()
}