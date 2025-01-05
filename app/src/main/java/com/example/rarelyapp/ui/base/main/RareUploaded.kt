import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.rarelyapp.R
import com.example.rarelyapp.R.drawable.authentication_flow_background
import com.example.rarelyapp.ui.theme.CustomColor
import com.example.rarelyapp.ui.theme.DarkBlue
import com.example.rarelyapp.ui.theme.Grey
import com.example.rarelyapp.ui.theme.RarelyAppTheme
import androidx.compose.ui.res.painterResource

@Composable
fun RareUploadScreen() {
    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        // Arka plan resmi
        Image(
            painter = painterResource(id = authentication_flow_background),
            contentDescription = "Background",
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop // Resmi tüm ekrana sığdır
        )

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            // Üst kısımda RARE UPLOAD metni
            Text(
                text = "RARE UPLOAD",
                fontSize = 24.sp,
                color = Color.Black,
                modifier = Modifier.padding(top = 32.dp)
            )

            // Mavi tik ve metin kısmı
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.padding(vertical = 32.dp)
            ) {
                Image(
                    painter = painterResource(R.drawable.okey),
                    contentDescription = "Check Mark",
                    modifier = Modifier
                        .size(200.dp)
                        .padding(bottom = 16.dp),
                    contentScale = ContentScale.Fit
                )
                Text(
                    text = "Your Rare has been successfully uploaded!",
                    fontSize = 18.sp,
                    color = Color.Black,
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                        .padding(horizontal = 16.dp)
                        .padding(bottom = 8.dp) // Bu şekilde ayrı ayrı ekleyebilirsiniz
                )

                // Küçük yazı
                Text(
                    text = "Your product has been successfully uploaded! If approved by our expert team after a detailed review within 48 hours, it will be sent to our center for authenticity verification. Once the authenticity verification is complete, your product will be returned to you and made visible on your profile!",
                    fontSize = 14.sp,
                    color = Color.Black,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.padding(horizontal = 16.dp)
                )
            }

            // Back butonu
            Button(
                onClick = { /* Back butonu tıklama işlemi */ },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 16.dp, horizontal = 70.dp)
                    .height(48.dp),
                shape = RoundedCornerShape(32.dp),
                colors = ButtonDefaults.buttonColors(containerColor = DarkBlue)
            ) {
                Text(text = "Back", fontSize = 16.sp, color = Color.White)
            }
        }
    }
}

@Preview
@Composable
fun RareUploadScreenPreview() {
    RarelyAppTheme {
        RareUploadScreen()
    }
}
