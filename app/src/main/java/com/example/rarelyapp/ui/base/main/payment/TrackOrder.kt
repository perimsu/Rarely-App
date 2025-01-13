package com.example.rarelyapp.ui.base.main.payment

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.rarelyapp.R
import androidx.compose.material3.HorizontalDivider

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding


@Composable
fun TrackOrderScreen() {
    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        // Arka plan resmi
        Image(
            painter = painterResource(id = R.drawable.authentication_flow_background),
            contentDescription = "Background",
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop
        )

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(bottom = 70.dp), // Alt gezinme çubuğu için boşluk bırak
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // Başlık
            Text(
                text = stringResource(id = R.string.track_order),
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(top = 16.dp)
            )

            Spacer(modifier = Modifier.height(16.dp))

            // Ürün Kartı
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(120.dp),
                shape = RoundedCornerShape(12.dp),
            ) {
                Row(
                    modifier = Modifier.fillMaxSize(),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    // Ürün Görseli
                    Image(
                        painter = painterResource(id = R.drawable.rolex2),
                        contentDescription = "Product Image",
                        modifier = Modifier
                            .padding(8.dp)
                            .size(100.dp),
                        contentScale = ContentScale.Crop
                    )

                    Spacer(modifier = Modifier.width(8.dp))

                    // Ürün Bilgileri
                    Column(
                        modifier = Modifier.fillMaxHeight(),
                        verticalArrangement = Arrangement.Center
                    ) {
                        Text(
                            text = "Rolex Datejust 36",
                            color = Color.DarkGray,
                            fontSize = 16.sp
                        )
                        Spacer(modifier = Modifier.height(4.dp))
                        Text(
                            text = "13.000 USD",
                            fontWeight = FontWeight.Bold,
                            fontSize = 14.sp
                        )
                    }
                }
            }

            Spacer(modifier = Modifier.height(16.dp))

            // Yatay çizgi
            HorizontalDivider(
                color = Color.Gray,
                thickness = 1.dp,
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(modifier = Modifier.height(10.dp))

            Text(
                text = stringResource(id = R.string.order_details),
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.fillMaxWidth()
                    .padding(8.dp)
            )
            Spacer(modifier = Modifier.height(4.dp))
            Column(
                modifier = Modifier.fillMaxWidth(),
                verticalArrangement = Arrangement.spacedBy(4.dp)
            ) {

                Text(
                    text = "Expected Delivery Date: 12th January 2025",
                    color = Color.DarkGray,
                    modifier = Modifier
                        .padding(8.dp))

                //Spacer(modifier = Modifier.height(8.dp))

                Text(
                    text = "Tracking ID: 12345-67890",
                    color = Color.DarkGray,
                    modifier = Modifier
                        .padding(8.dp))
            }

            Spacer(modifier = Modifier.height(32.dp))

            HorizontalDivider(
                color = Color.Gray,
                thickness = 1.dp,
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(modifier = Modifier.height(10.dp))

            Text(
                text = stringResource(id = R.string.order_status),
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.fillMaxWidth()
                    .padding(8.dp)
            )
            Spacer(modifier = Modifier.height(10.dp))

            //dikey çizgi

            Box(
                modifier = Modifier
                    .fillMaxHeight() // Yüksekliği dolduruyoruz
                    .fillMaxWidth() // Genişliği dolduruyoruz
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxHeight() // Row'un yüksekliği Box'ın yüksekliği kadar olacak
                        .align(Alignment.TopStart) // Sol üst hizalamayı sağlıyoruz
                        .padding(start = 16.dp)
                ) {
                    Box(
                        modifier = Modifier
                            .width(2.dp) // Çizginin genişliği
                            .height(250.dp) // Çizginin yüksekliği
                            .background(Color.DarkGray)
                    )

                    // Yazıları içeren liste
                    val textList = listOf(
                        "Order Placed",
                        "In Progress",
                        "Shipped",
                        "Delivered"
                    )

                    // Column içinde 4 görseli ve yanlarına yazıları sıralıyoruz
                    Column(
                        modifier = Modifier
                            .padding(start = 1.dp) // Çizgi ile görseller arasında boşluk bırakıyoruz
                            .align(Alignment.Top) // Column'ı en üst hizalıyoruz
                    ) {
                        // 4 tane görsel ve her birinin yanına yazı
                        repeat(4) { index ->
                            Row(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(bottom = 50.dp), // Görsellerin altına boşluk ekliyoruz
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                // Görsel
                                Image(
                                    painter = painterResource(id = R.drawable.saved_card), // Görselinizi burada ekleyin
                                    contentDescription = "Circle",
                                    modifier = Modifier
                                        .size(24.dp) // Görselin boyutu
                                )

                                Spacer(modifier = Modifier.width(8.dp)) // Görsel ile yazı arasına boşluk bırakıyoruz

                                // Yazı
                                Text(
                                    text = textList[index], // Yazıyı liste üzerinden alıyoruz
                                    fontSize = 16.sp
                                )
                            }
                        }
                    }
                }
            }

        }

    }
}

@Preview(showBackground = true)
@Composable
fun TrackOrderScreenPreview() {
    TrackOrderScreen()
}