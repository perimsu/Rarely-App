package com.example.rarelyapp.ui.base.main

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.example.rarelyapp.data.api.RetrofitClient
import com.example.rarelyapp.data.model.Product
import kotlinx.coroutines.launch
import androidx.compose.material3.CircularProgressIndicator
import androidx.navigation.NavController

@Composable
fun MyBagScreen() {
    // Ürün listesini tutmak için state değişkeni
    var products by remember { mutableStateOf<List<Product>>(emptyList()) }
    // Yüklenme durumunu takip etmek için state değişkeni
    var isLoading by remember { mutableStateOf(true) }
    // Coroutine kapsamını hatırlamak için scope
    val scope = rememberCoroutineScope()

    // Ürünlerin toplam fiyatını hesaplar
    val totalPrice = products.sumOf { it.price }

    // Ekran ilk yüklendiğinde ürünleri getirir
    LaunchedEffect(Unit) {
        scope.launch {
            try {
                // API'den ürünleri al ve ilk 8 ürünü listele
                products = RetrofitClient.api.getProducts().take(8)
            } catch (e: Exception) {
                // Hata durumunda hata mesajını yazdır
                e.printStackTrace()
            } finally {
                // Veri alımı tamamlandıktan sonra yüklenme durumunu kapat
                isLoading = false
            }
        }
    }

    // Ana düzen kutusu
    Box(modifier = Modifier.fillMaxSize()) {
        // Ana kolon, başlık ve ürünler listesi içerir
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {
            // Başlık metni
            Text(
                text = "MY BAG", // Sayfa başlığı
                modifier = Modifier
                    .fillMaxWidth() // Başlık genişliği ekranın tamamına yayılır
                    .padding(vertical = 16.dp), // Dikey boşluk eklenir
                textAlign = TextAlign.Center, // Metin ortalanır
                style = TextStyle(
                    fontSize = 24.sp, // Font boyutu
                    fontWeight = FontWeight.Bold, // Kalın yazı tipi
                    color = Color.Black // Siyah renk
                )
            )

            // Ürünleri göstermek için LazyColumn
            LazyColumn(
                modifier = Modifier.weight(1f), // Boşluğu esnek olarak doldurur
                verticalArrangement = Arrangement.spacedBy(8.dp) // Elemanlar arasında boşluk bırakır
            ) {
                // Ürün listesinde dolaş ve her ürün için bir BagItemCard oluştur
                items(products) { product ->
                    BagItemCard(product)
                }
            }

            // Toplam fiyat ve devam butonu kısmı
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 16.dp)
            ) {
                // Fiyat detayları için yatay düzen
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween, // Elemanları iki uçta hizalar
                    verticalAlignment = Alignment.CenterVertically // Elemanları dikey ortalar
                ) {
                    // "Total Price:" metni
                    Text(
                        text = "Total Price:",
                        style = TextStyle(
                            fontSize = 18.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color.Black
                        )
                    )
                    // Toplam fiyat
                    Text(
                        text = "$${String.format("%.2f", totalPrice)} USD",
                        style = TextStyle(
                            fontSize = 18.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color.Black
                        )
                    )
                }

                Spacer(modifier = Modifier.height(16.dp))

                // Continue to Payment butonu
                Button(
                    onClick = { /* TODO: Navigate to payment screen */ },
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(50.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color(0xFF18223D)
                    ),
                    shape = RoundedCornerShape(8.dp)
                ) {
                    Text(
                        text = "Continue to Payment",
                        style = TextStyle(
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color.White
                        )
                    )
                }
            }
        }

        // Yüklenme durumunu gösteren bir döngüsel ilerleme göstergesi
        if (isLoading) {
            CircularProgressIndicator(
                modifier = Modifier
                    .size(50.dp) // Göstergenin boyutu
                    .align(Alignment.Center), // Göstergenin ortalanması
                color = Color(0xFF18223D) // Göstergenin rengi
            )
        }
    }
}

@OptIn(ExperimentalGlideComposeApi::class)
@Composable
fun BagItemCard(product: Product) {
    // Ürün kartı düzeni
    Row(
        modifier = Modifier
            .fillMaxWidth() // Kart genişliği ekranın tamamını kaplar
            .clip(RoundedCornerShape(8.dp)) // Köşeler yuvarlanır
            .background(Color(0xFFFAE7E8)) // Arka plan rengi
            .padding(8.dp), // İçerik boşlukları
        verticalAlignment = Alignment.CenterVertically // Elemanlar dikeyde ortalanır
    ) {
        // GlideImage kullanarak ürün görselini yükler
        GlideImage(
            model = product.images.firstOrNull()?.replace("[\"", "")?.replace("\"]", ""), // İlk görseli yükler
            contentDescription = product.title, // Görsel açıklaması
            modifier = Modifier
                .size(80.dp) // Görsel boyutu
                .clip(RoundedCornerShape(8.dp)) // Görsel köşeleri yuvarlanır
        )

        Spacer(modifier = Modifier.width(12.dp)) // Görsel ile metin arasında boşluk bırakır

        // Ürün bilgilerini içeren sütun
        Column(
            modifier = Modifier
                .weight(1f) // Sütun genişliği esnek olarak doldurur
                .padding(horizontal = 8.dp) // Yatay boşluk eklenir
        ) {
            // Ürün adı
            Text(
                text = product.title, // Ürün başlığı
                style = TextStyle(
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.Black
                ),
                maxLines = 2 // Metni 2 satırla sınırlandırır
            )

            Spacer(modifier = Modifier.height(4.dp)) // Başlık ve fiyat arasında boşluk bırakır

            // Ürün fiyatı
            Text(
                text = "$${String.format("%.2f", product.price)} USD",
                style = TextStyle(
                    fontSize = 14.sp,
                    color = Color.Black
                )
            )
        }
    }
}