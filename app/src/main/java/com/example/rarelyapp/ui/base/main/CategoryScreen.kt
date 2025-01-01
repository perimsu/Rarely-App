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
fun CategoriesScreen() {

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
                text = "CATEGORIES",
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 16.dp),
                textAlign = TextAlign.Center,
                style = TextStyle(fontSize = 21.sp, fontWeight = FontWeight.Bold, color = Color.Black)
            )

            // Kategori listesi
            LazyColumn(
                contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                items(categoryList) { category ->
                    CategoryItem(category = category)
                }
            }
        }
    }

}

@Composable
fun CategoryItem(category: Category) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(130.dp)
            .clip(RoundedCornerShape(16.dp))
            .background(Color.LightGray) // Yedek bir arka plan
            .clickable { /* Tıklama işlemi */ }
    ) {
        // Arka plan görseli
        Image(
            painter = painterResource(category.image),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .fillMaxSize()
                .height(160.dp)
                .clip(RoundedCornerShape(16.dp)),
            alignment = Alignment.Center
        )
        // Başlık
        Text(
            text = category.title,
            style = TextStyle(fontSize = 20.sp, fontWeight = FontWeight.Bold, color = Color.White),
            modifier = Modifier
                .align(Alignment.TopStart) // Sol üst köşe hizalaması
                .padding(16.dp)
        )
    }
}

data class Category(val title: String, val image: Int)

val categoryList = listOf(
    Category("Art", R.drawable.cat1),
    Category("Fashion", R.drawable.cat2),
    Category("Collabs", R.drawable.cat3),
    Category("Auction", R.drawable.cat4),
    Category("Green Collection", R.drawable.cat5)
)

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun PreviewCategories() {
    CategoriesScreen()
}