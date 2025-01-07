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
import androidx.compose.material3.CircularProgressIndicator
import android.util.Log
import com.bumptech.glide.integration.compose.Placeholder
import java.net.SocketTimeoutException
import java.net.UnknownHostException
import kotlinx.coroutines.withTimeout

@OptIn(ExperimentalGlideComposeApi::class)
@Composable
fun HomeScreen() {

    // "products" listesi API'den alınan ürünleri tutar.
    var products by remember { mutableStateOf<List<Product>>(emptyList()) }

    // Yüklenme durumunu kontrol eden değişken.
    var isLoading by remember { mutableStateOf(true) }

    // Hata mesajını tutan değişken.
    var error by remember { mutableStateOf<String?>(null) }

    // Coroutine'leri başlatmak için scope oluşturuyoruz.
    val scope = rememberCoroutineScope()

    // Kompozisyon ilk oluşturulduğunda çalışır, veriyi API'den çeker.
    LaunchedEffect(Unit) {
        scope.launch {
            isLoading = true
            try {
                // Veriyi çekmek için 5 saniyelik bir timeout ayarlanmıştır.
                withTimeout(5000) {
                    products = RetrofitClient.api.getProducts()
                }
            } catch (e: Exception) {
                // Hataları yakalar ve uygun hata mesajını ayarlar.
                error = when (e) {
                    is SocketTimeoutException -> "Bağlantı zaman aşımına uğradı"
                    is UnknownHostException -> "İnternet bağlantınızı kontrol edin"
                    else -> "Bir hata oluştu: ${e.localizedMessage}"
                }
                Log.e("HomeScreen", "Error loading products", e)
            } finally {
                // Yüklenme durumunu sona erdirir.
                isLoading = false
            }
        }
    }

    // "You May Also Like" bölümü için önerilen ürünler.
    val recommendedItems = listOf(
        Pair(R.drawable.home_pd_1, "Miu Miu Pink Cardigan"),
        Pair(R.drawable.home_pd_2, "Jeff Koons Rabbit Sculpture"),
        Pair(R.drawable.home_pd_3, "Breitling Navitimer 1.1 Watch")
    )

    // "Top Collectors" bölümü için veriler.
    val topCollectors = listOf(
        Pair(R.drawable.pp_1, "@mirandalove34"),
        Pair(R.drawable.pp_2, "@babybluee465"),
        Pair(R.drawable.pp_3, "@jackhouston"),
        Pair(R.drawable.pp_4, "@pinkcandyy")
    )

    // Top Collectors arka plan görselleri.
    val topCollectorsBg = listOf(
        R.drawable.pp_1_bg,
        R.drawable.pp_2_bg,
        R.drawable.pp_3_bg,
        R.drawable.pp_4_bg
    )

    // Dikey kaydırma durumu.
    val scrollState = rememberScrollState()

    // Ana ekran düzeni.
    Box(modifier = Modifier.fillMaxSize()) {
        Column(
            modifier = Modifier
                .padding(16.dp)
                .verticalScroll(scrollState)
        ) {
            // "Explore" başlığı.
            Text(
                text = "Explore",
                style = MaterialTheme.typography.titleMedium,
                modifier = Modifier.padding(vertical = 8.dp),
                textAlign = TextAlign.Center
            )

            Spacer(modifier = Modifier.height(8.dp))

            // Arama çubuğu.
            TextField(
                value = "",
                onValueChange = {},
                placeholder = { Text("Search") },
                leadingIcon = { Icon(Icons.Default.Search, contentDescription = null) },
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(16.dp))

            // "Top Collections" başlığı.
            Text(text = "Top Collections", style = MaterialTheme.typography.titleMedium)

            Spacer(modifier = Modifier.height(4.dp))

            // İlk 5 ürün için LazyRow.
            LazyRow(
                modifier = Modifier
                    .background(Color(0xFFD9D9D9))
                    .padding(4.dp)
            ) {
                items(products.take(5)) { product ->
                    GlideImage(
                        model = product.images.firstOrNull()?.replace("[\"", "")?.replace("\"]", ""),
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

            // 6-9. ürünler için LazyRow.
            LazyRow(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color(0xFFD9D9D9))
                    .padding(4.dp)
            ) {
                items(products.drop(5).take(4)) { product ->
                    GlideImage(
                        model = product.images.firstOrNull()?.replace("[\"", "")?.replace("\"]", ""),
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

            // 10-13. ürünler için LazyRow.
            LazyRow(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color(0xFFD9D9D9))
                    .padding(4.dp)
            ) {
                items(products.drop(9).take(4)) { product ->
                    GlideImage(
                        model = product.images.firstOrNull()?.replace("[\"", "")?.replace("\"]", ""),
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

            // "You May Also Like" bölümü.
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

            // "Top Collectors" bölümü.
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
                        // Arka plan resmi.
                        Image(
                            painter = painterResource(id = bgRes),
                            contentDescription = null,
                            contentScale = ContentScale.Crop,
                            modifier = Modifier.fillMaxSize()
                        )

                        // Koleksiyoncunun bilgilerini içeren düzen.
                        Column(
                            modifier = Modifier
                                .fillMaxSize()
                                .padding(8.dp),
                            horizontalAlignment = Alignment.CenterHorizontally,
                            verticalArrangement = Arrangement.Center
                        ) {
                            // Profil fotoğrafı.
                            Image(
                                painter = painterResource(id = collector.first),
                                contentDescription = null,
                                modifier = Modifier
                                    .size(60.dp)
                                    .clip(CircleShape)
                            )

                            Spacer(modifier = Modifier.height(8.dp))

                            // Kullanıcı adı.
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

        // Hata mesajını ekranda gösterir.
        error?.let { errorMessage ->
            Text(
                text = errorMessage,
                color = Color.Red,
                modifier = Modifier
                    .align(Alignment.Center)
                    .padding(16.dp)
            )
        }

        // Yüklenme göstergesi.
        if (isLoading) {
            CircularProgressIndicator(
                modifier = Modifier
                    .size(50.dp)
                    .align(Alignment.Center),
                color = Color(0xFF18223D)
            )
        }
    }
}

// Önizleme fonksiyonu. Bu fonksiyon HomeScreen bileşeninin nasıl görüneceğini hızlıca test etmenizi sağlar.
@Preview(showBackground = true, showSystemUi = true)
@Composable
fun HomeScreenPreview() {
    HomeScreen()
}