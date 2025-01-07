package com.example.rarelyapp.ui.base.main

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.rarelyapp.R

@Composable
fun CategoriesScreen() {

    // Ana düzeni oluşturur, tüm ekranı kaplar.
    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        // Arka plan resmi.
        Image(
            painter = painterResource(id = R.drawable.authentication_flow_background),
            contentDescription = null, // Arka plan için açıklama gereksizdir.
            modifier = Modifier.fillMaxSize(), // Resmi tüm ekranı kaplayacak şekilde boyutlandırır.
            contentScale = ContentScale.Crop // Resmi kırparak tam ekran yapar.
        )
        // Ana sütun, başlık ve kategori listesini içerir.
        Column {
            // Ekranın başlığı.
            Text(
                text = "CATEGORIES", // Gösterilecek başlık metni.
                modifier = Modifier
                    .fillMaxWidth() // Başlığı ekranın tam genişliğine yayar.
                    .padding(vertical = 16.dp), // Dikeyde bir boşluk ekler.
                textAlign = TextAlign.Center, // Metni ortalar.
                style = TextStyle(fontSize = 21.sp, fontWeight = FontWeight.Bold, color = Color.Black) // Başlık için metin stili.
            )

            // Kategori listesini göstermek için bir LazyColumn.
            LazyColumn(
                contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp), // Kategori listesi için kenar boşlukları.
                verticalArrangement = Arrangement.spacedBy(8.dp) // Kategoriler arasında boşluk bırakır.
            ) {
                // categoryList'teki her bir kategori için CategoryItem bileşeni oluşturur.
                items(categoryList) { category ->
                    CategoryItem(category = category) // Kategori elemanını CategoryItem'e geçirir.
                }
            }
        }
    }
}

@Composable
fun CategoryItem(category: Category) {
    // Kategori kartını temsil eden kutu.
    Box(
        modifier = Modifier
            .fillMaxWidth() // Kartın genişliğini ekranın tamamına yayar.
            .height(130.dp) // Kartın yüksekliğini belirler.
            .clip(RoundedCornerShape(16.dp)) // Köşeleri yuvarlatır.
            .background(Color.LightGray) // Varsayılan arka plan rengi.
            .clickable { /* Tıklama işlemi */ } // Kartın tıklanabilir olmasını sağlar.
    ) {
        // Kartın arka plan görseli.
        Image(
            painter = painterResource(category.image), // Kategori görsel kaynağı.
            contentDescription = null, // Görsel açıklama gerekmez.
            contentScale = ContentScale.Crop, // Görseli karta uyacak şekilde kırpar.
            modifier = Modifier
                .fillMaxSize() // Görseli kartın tamamını kaplayacak şekilde boyutlandırır.
                .height(160.dp) // Görsel yüksekliği.
                .clip(RoundedCornerShape(16.dp)), // Görselin köşelerini yuvarlar.
            alignment = Alignment.Center // Görseli ortalar.
        )
        // Kartın üstüne yerleştirilen başlık metni.
        Text(
            text = category.title, // Kategori başlığı.
            style = TextStyle(fontSize = 20.sp, fontWeight = FontWeight.Bold, color = Color.White), // Metin stili.
            modifier = Modifier
                .align(Alignment.TopStart) // Başlığı sol üst köşeye hizalar.
                .padding(16.dp) // Başlık çevresine boşluk ekler.
        )
    }
}

// Kategori veri modelini tanımlayan sınıf.
data class Category(val title: String, val image: Int)

// Kategori listesini tanımlayan örnek veri.
val categoryList = listOf(
    Category("Art", R.drawable.cat1), // Sanat kategorisi.
    Category("Fashion", R.drawable.cat2), // Moda kategorisi.
    Category("Collabs", R.drawable.cat3), // İş birliği kategorisi.
    Category("Auction", R.drawable.cat4), // Müzayede kategorisi.
    Category("Green Collection", R.drawable.cat5) // Yeşil koleksiyon kategorisi.
)

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun PreviewCategories() {
    // CategoriesScreen bileşenini önizleme.
    CategoriesScreen()
}