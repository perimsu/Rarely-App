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
import androidx.compose.foundation.clickable
import androidx.compose.foundation.shape.CircleShape
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController


@Composable
fun MyOrderScreen(navController: NavController) {
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
            Spacer(modifier = Modifier.height(16.dp))

            // Başlık
            Text(
                text = stringResource(id = R.string.my_orders),
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(top = 16.dp)
            )

            Spacer(modifier = Modifier.height(16.dp))

            Spacer(modifier = Modifier.height(16.dp))

            Column(
                modifier = Modifier.fillMaxWidth()
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    // "Active" yazısı ve altındaki daire
                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        Text(text = "Active", color = Color.Black, fontSize = 16.sp)
                        Spacer(modifier = Modifier.height(4.dp)) // Yazıyla daire arasında boşluk
                        Box(
                            modifier = Modifier
                                .size(12.dp)
                                .background(Color.Black, shape = CircleShape)
                        )
                    }

                    // "Completed" yazısı ve altındaki daire
                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        Text(text = "Completed", color = Color.Gray, fontSize = 16.sp)
                        Spacer(modifier = Modifier.height(4.dp))
                        Box(
                            modifier = Modifier
                                .size(12.dp)
                                .background(Color.Gray, shape = CircleShape)
                        )
                    }

                    // "Cancelled" yazısı ve altındaki daire
                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        Text(text = "Cancelled", color = Color.Gray, fontSize = 16.sp)
                        Spacer(modifier = Modifier.height(4.dp))
                        Box(
                            modifier = Modifier
                                .size(12.dp)
                                .background(Color.Gray, shape = CircleShape)
                        )
                    }
                }

                // Yatay Çizgi
                HorizontalDivider(
                    color = Color.Gray,
                    thickness = 1.dp,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 32.dp) // Çizgiyi kenarlardan uzaklaştırdık
                )
            }

            Spacer(modifier = Modifier.height(46.dp))

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
                    // Ürün Görseli (Button olarak kullanılacak)
                    Image(
                        painter = painterResource(id = R.drawable.louisbag),
                        contentDescription = "Product Image",
                        modifier = Modifier
                            .size(110.dp) // Görsel boyutu
                            .padding(0.dp),
                        contentScale = ContentScale.Fit // Görseli kırpmadan sığdırır
                    )

                    Spacer(modifier = Modifier.width(8.dp))

                    // Ürün Bilgileri
                    Column(
                        modifier = Modifier.fillMaxHeight(),
                        verticalArrangement = Arrangement.Center
                    ) {
                        Text(
                            text = "Louis Vuitton Belle",
                            color = Color.DarkGray,
                            fontSize = 16.sp
                        )
                        Spacer(modifier = Modifier.height(4.dp))
                        Text(
                            text = "1500 USD",
                            fontWeight = FontWeight.Bold,
                            fontSize = 14.sp
                        )
                    }

                    // Sağdaki Görsel
                    Image(
                        painter = painterResource(id = R.drawable.track_order_b),
                        contentDescription = "Product Image",
                        modifier = Modifier
                            .size(140.dp)
                            .padding(7.dp)
                            .clickable {
                                navController.navigate("track_order")
                            },
                        contentScale = ContentScale.Fit
                    )
                }
            }

            Spacer(modifier = Modifier.height(26.dp))

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
                    // Ürün Görseli (Button olarak kullanılacak)
                    Image(
                        painter = painterResource(id = R.drawable.vase),
                        contentDescription = "Product Image",
                        modifier = Modifier
                            .size(110.dp) // Görsel boyutu
                            .padding(0.dp),
                        contentScale = ContentScale.Fit // Görseli kırpmadan sığdırır
                    )

                    Spacer(modifier = Modifier.width(8.dp))

                    // Ürün Bilgileri
                    Column(
                        modifier = Modifier.fillMaxHeight(),
                        verticalArrangement = Arrangement.Center
                    ) {
                        Text(
                            text = "Liang Xiu Eternal   ",
                            color = Color.DarkGray,
                            fontSize = 16.sp
                        )
                        Spacer(modifier = Modifier.height(4.dp))
                        Text(
                            text = "3.000 USD",
                            fontWeight = FontWeight.Bold,
                            fontSize = 14.sp
                        )
                    }

                    // Sağdaki Görsel
                    Image(
                        painter = painterResource(id = R.drawable.track_order_b),
                        contentDescription = "Product Image",
                        modifier = Modifier
                            .size(140.dp)
                            .padding(7.dp)
                            .clickable {
                                navController.navigate("track_order")
                                println("Görsel tıklandı!")
                            },
                        contentScale = ContentScale.Fit
                    )
                }
            }

            Spacer(modifier = Modifier.height(26.dp))

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
                    // Ürün Görseli (Button olarak kullanılacak)
                    Image(
                        painter = painterResource(id = R.drawable.rolex2),
                        contentDescription = "Product Image",
                        modifier = Modifier
                            .size(110.dp) // Görsel boyutu
                            .padding(0.dp),
                        contentScale = ContentScale.Fit // Görseli kırpmadan sığdırır
                    )

                    Spacer(modifier = Modifier.width(8.dp))

                    // Ürün Bilgileri
                    Column(
                        modifier = Modifier.fillMaxHeight(),
                        verticalArrangement = Arrangement.Center
                    ) {
                        Text(
                            text = "Rolex Datejust 36  ",
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

                    // Sağdaki Görsel
                    Image(
                        painter = painterResource(id = R.drawable.track_order_b),
                        contentDescription = "Product Image",
                        modifier = Modifier
                            .size(140.dp)
                            .padding(7.dp)
                            .clickable {
                                navController.navigate("track_order")
                                println("Görsel tıklandı!")
                            },
                        contentScale = ContentScale.Fit
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun MyOrderScreenPreview() {
    MyOrderScreen(navController = rememberNavController())
}