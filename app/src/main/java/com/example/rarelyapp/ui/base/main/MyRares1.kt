import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.rarelyapp.R
import com.example.rarelyapp.ui.theme.Back
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
data class RareItem(val name: String, val description: String, val price: String, val imageRes: Int)
val AboretoFont = FontFamily(
    Font(R.font.aboreto_regular)
)
@Composable
fun MyRaresScreen() {
    val rareItems = listOf(
        RareItem("Gucci 1960", "Lizard Mesh Crystal", "5.000 USD", R.drawable.rare1),
        RareItem("Serpenti Tubogas", "Watch", "20.000 USD", R.drawable.rare2),
        RareItem("Enternal Gleam", "Amelia Crawford", "5.000 USD", R.drawable.rare3),
        RareItem("Sparkling Balloons", "Amelia Crawford", "5.000 USD", R.drawable.rare4),
        RareItem("Vintage English Teapot", "", "5.000 USD", R.drawable.rare5),
        RareItem("Vintage A Bedside", "Lamp", "5.000 USD", R.drawable.rare6),
        RareItem("", "", "4.000 USD", R.drawable.rare7),
        RareItem("", "", "3.000 USD", R.drawable.rare8)
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Back)
            .padding(8.dp),
        horizontalAlignment = Alignment.CenterHorizontally // Tüm içeriği yatayda ortala
    ) {
        Text(
            text = "MY RARES",
            fontSize = 30.sp,
            color = Color.Black,
            fontFamily = AboretoFont,
            modifier = Modifier
                .padding(bottom = 8.dp)
        )

        LazyColumn(
            verticalArrangement = Arrangement.spacedBy(2.dp), // Dikey boşlukları ayarla
            horizontalAlignment = Alignment.CenterHorizontally, // İçeriği yatayda ortala
            modifier = Modifier.fillMaxSize()
        ) {
            itemsIndexed(rareItems) { index, item ->
                if (index % 2 == 0) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth(),
                        horizontalArrangement = Arrangement.Center // Tüm Row içeriğini ortala
                    ) {
                        RareItemCard(item, isLastItem = index + 1 == rareItems.size)
                        if (index + 1 < rareItems.size) {
                            Spacer(modifier = Modifier.width(32.dp)) // İki kart arasındaki yatay boşluk
                            RareItemCard(
                                rareItems[index + 1],
                                isLastItem = index + 2 == rareItems.size
                            )
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun RareItemCard(item: RareItem, isLastItem: Boolean) {
    Column(
        modifier = Modifier
            .width(150.dp) // Fotoğraf kart genişliği
            .padding(4.dp),
        horizontalAlignment = Alignment.Start // Yazıları sola hizaladım
    ) {
        Box(
            modifier = Modifier
                .size(150.dp) // Fotoğraf boyutunu sabitledim
        ) {
            Image(
                painter = painterResource(item.imageRes),
                contentDescription = item.name,
                contentScale = ContentScale.Crop,
                modifier = Modifier.fillMaxSize()
            )
        }
        Column(
            modifier = Modifier.padding(top = 8.dp) // Yazılar fotoğrafın altına doğru hizalandı
        ) {
            Text(
                text = item.name,
                fontSize = 12.sp,
                fontWeight = FontWeight.Normal,
                color = Color.Black,
                modifier = Modifier.padding(bottom = 2.dp)
            )
            Text(
                text = item.description,
                fontSize = 10.sp,
                fontWeight = FontWeight.Normal,
                color = Color.Gray,
                modifier = Modifier.padding(bottom = 2.dp)
            )
            Text(
                text = item.price,
                fontSize = 12.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black
            )
        }
    }
}

@Preview
@Composable
fun MyRaresScreenPreview() {
    MyRaresScreen()
}


