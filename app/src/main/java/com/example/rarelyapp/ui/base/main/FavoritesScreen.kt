package com.example.rarelyapp.ui.base.main

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
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
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.rarelyapp.R
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.example.rarelyapp.data.api.RetrofitClient
import com.example.rarelyapp.data.model.Product
import kotlinx.coroutines.launch
import androidx.compose.material3.CircularProgressIndicator
import kotlin.random.Random

@Composable
fun FavoritesScreen() {
    // API'den alınan ürünleri tutan liste.
    var products by remember { mutableStateOf<List<Product>>(emptyList()) }

    // Veri yükleniyor mu durumunu tutar.
    var isLoading by remember { mutableStateOf(true) }

    // Coroutine işlemleri için bir scope oluşturur.
    val scope = rememberCoroutineScope()

    // Kompozisyon ilk oluşturulduğunda çalışacak ve ürün verilerini alacaktır.
    LaunchedEffect(Unit) {
        scope.launch {
            try {
                // Retrofit ile ürünleri al ve ilk 5 tanesini göster.
                products = RetrofitClient.api.getProducts().take(5)
                Log.d("FavoritesScreen", "Products: $products")
            } catch (e: Exception) {
                // Hata durumunda log kaydı oluşturur.
                Log.d("FavoritesScreen", "Products e: ${e.message}")
                e.printStackTrace()
            } finally {
                // Veri yükleme tamamlandı.
                isLoading = false
            }
        }
    }

    // Ana düzeni oluşturan Box.
    Box(modifier = Modifier.fillMaxSize()) {
        // Arka plan resmi.
        Image(
            painter = painterResource(id = R.drawable.authentication_flow_background),
            contentDescription = null,
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop
        )

        // Ana içerik.
        Column {
            // Başlık.
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

            // Ürünleri listeleyen LazyColumn.
            LazyColumn(
                contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                // Her ürün için FavoriteItemCard bileşeni oluşturur.
                items(products) { product ->
                    FavoriteItemCard(product)
                }
            }
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

@OptIn(ExperimentalGlideComposeApi::class)
@Composable
fun FavoriteItemCard(product: Product) {
    // Ürün kartı düzeni.
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(16.dp))
            .background(Color(0xFFFAE7E8))
            .padding(8.dp)
            .clickable { /* Tıklama işlemi */ },
        verticalAlignment = Alignment.CenterVertically
    ) {
        // Ürünün görseli.
        GlideImage(
            model = product.images.firstOrNull()?.replace("[\"", "")?.replace("\"]", ""),
            contentDescription = product.title,
            modifier = Modifier
                .size(80.dp)
                .clip(RoundedCornerShape(12.dp))
        )

        Spacer(modifier = Modifier.width(12.dp))

        // Ürün bilgilerini içeren sütun.
        Column(
            modifier = Modifier.weight(1f)
        ) {
            // Ürün başlığı.
            Text(
                text = product.title,
                style = TextStyle(
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.Black
                )
            )

            // Ürün fiyatı.
            Text(
                text = "$${product.price} USD",
                style = TextStyle(fontSize = 14.sp, color = Color.Gray)
            )

            // Favori listesinde kaç kişinin olduğu bilgisi.
            Text(
                text = "In the favorite list of ${Random.nextInt(1, 100)} people",
                style = TextStyle(fontSize = 12.sp, color = Color.Gray)
            )
        }

        Spacer(modifier = Modifier.width(8.dp))

        // Sepete ekleme düğmesi.
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            // "To My Bag" metni.
            Text(
                text = "To My Bag",
                style = TextStyle(
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.Black
                )
            )

            Spacer(modifier = Modifier.width(8.dp))

            // "+" simgesi içeren yuvarlak düğme.
            Box(
                modifier = Modifier
                    .size(30.dp)
                    .clip(RoundedCornerShape(15.dp))
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

// Önizleme fonksiyonu. Bu fonksiyon Favoriler ekranının nasıl görüneceğini hızlıca test etmenizi sağlar.
@Preview(showBackground = true, showSystemUi = true)
@Composable
fun PreviewFavoritesScreen() {
    FavoritesScreen()
}