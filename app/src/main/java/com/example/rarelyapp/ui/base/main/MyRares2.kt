import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.tooling.preview.Preview
import com.example.rarelyapp.R
import com.example.rarelyapp.ui.theme.Back
import com.example.rarelyapp.ui.theme.Pink80
import com.example.rarelyapp.ui.theme.pink


data class CommentItem(val author: String, val text: String)

@Composable
fun MyRares2Screen() {
    val comments = listOf(
        CommentItem("Sue Miller", "I want to buy it"),
        CommentItem("Lily Parker", "I will buy it if we agree"),
        CommentItem("Emily Grace", "love itttttt"),
        CommentItem("Amelia Joe", "this must be mineeee"),
    )

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(Back)
            .padding(8.dp)
    ) {
        item {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(
                    text = "MY RARES",
                    fontSize = 30.sp,
                    fontFamily = AboretoFont,
                    color = Color.Black,
                    modifier = Modifier
                        .align(Alignment.CenterHorizontally)
                        .padding(bottom = 16.dp)
                )

                Image(
                    painter = painterResource(R.drawable.rare1),
                    contentDescription = "Gucci 1960 Lizard Mesh Crystal",
                    modifier = Modifier
                        .fillMaxWidth() // Görseli tam genişlikte yapma
                        .align(Alignment.CenterHorizontally),
                    contentScale = ContentScale.Crop
                )

                Spacer(modifier = Modifier.height(8.dp))

                Column(
                    horizontalAlignment = Alignment.CenterHorizontally, // Sol hizalama
                    modifier = Modifier.padding(horizontal = 16.dp)
                ) {
                    Text(
                        text = "Gucci 1960 Lizard Mesh Crystal",
                        fontSize = 16.sp,
                        color = Color.Black,
                        modifier = Modifier.padding(vertical = 4.dp)
                    )
                    Text(
                        text = "5.000 USD",
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.Black,
                        modifier = Modifier.padding(vertical = 4.dp)
                    )

                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 8.dp),
                        horizontalArrangement = Arrangement.Start // Sol hizalama
                    ) {
                        Spacer(modifier = Modifier.width(8.dp)) // Sol boşluk ekleme
                        IconWithCount(R.drawable.fav, count = 120)
                        Spacer(modifier = Modifier.width(16.dp))
                        IconWithCount(R.drawable.chart, count = 45)
                        Spacer(modifier = Modifier.width(16.dp))
                        IconWithCount(R.drawable.sent, count = 30)
                    }

                    Text(
                        text = "Sue Miller and others likes your rare",
                        fontSize = 14.sp,
                        color = Color.Black,
                        modifier = Modifier
                            .padding(vertical = 8.dp)
                            .align(Alignment.Start) // Metni sola hizalama
                    )

                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(bottom = 8.dp), // Yorumların üstündeki çizgi ile yorumlar arasında boşluk
                        contentAlignment = Alignment.CenterStart
                    ) {
                        Divider(
                            color = Color.Gray,
                            thickness = 1.dp,
                            modifier = Modifier.width(250.dp) // Çizginin genişliğini burada belirledik
                        )
                    }
                }
            }
        }

        // Yorumlar
        items(comments) { comment ->
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(pink, RoundedCornerShape(16.dp)) // Köşe şekillerini arttırma
                    .padding(horizontal = 16.dp, vertical = 8.dp) // Yorumları ortalama ve kısaltma
            ) {
                Text(
                    text = "${comment.author}: ${comment.text}",
                    fontSize = 14.sp,
                    color = Color.Black,
                    modifier = Modifier.padding(vertical = 2.dp)
                )
            }
            Spacer(modifier = Modifier.height(8.dp))
        }
    }
}

@Composable
fun IconWithCount(resourceId: Int, count: Int) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.clickable { /* Handle click */ }
    ) {
        Image(
            painter = painterResource(resourceId),
            contentDescription = null,
            modifier = Modifier.size(24.dp)
        )
        Spacer(modifier = Modifier.width(4.dp))
        Text(
            text = "$count",
            fontSize = 14.sp,
            color = Color.Black
        )
    }
}

@Preview
@Composable
fun MyRares2ScreenPreview() {
    MyRares2Screen()
}
