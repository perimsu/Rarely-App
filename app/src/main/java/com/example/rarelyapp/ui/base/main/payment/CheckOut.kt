package com.example.rarelyapp.ui.base.main.payment

import androidx.compose.foundation.Image
//import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
//import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.rarelyapp.R

@Composable
fun CheckoutScreen(
    navController: NavController
    //onCreateNewAddress: () -> Unit,
    //onContinueToPayment: () -> Unit
) {
    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        // Arka plan
        Image(
            painter = painterResource(id = R.drawable.authentication_flow_background),
            contentDescription = "Background",
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize()
        )

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(bottom = 70.dp, start = 16.dp, end = 16.dp),
            verticalArrangement = Arrangement.Top
        ) {
            // Başlık
            // Başlık
            Text(
                text = stringResource(id = R.string.check_out),
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(top = 16.dp)
            )

            Spacer(modifier = Modifier.height(16.dp))

            // Adres başlığı
            Text(
                text = "Shipping Address",
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold
            )

            Spacer(modifier = Modifier.height(16.dp))

            // Adres listesi
            AddressItem("Home", "Mimar Sinan Caddesi No: 45, Beşiktaş, İstanbul", isSelected = true)
            AddressItem("Office", "Süleymanpaşa Sokak No: 22, Kadıköy, İstanbul", isSelected = false)

            Spacer(modifier = Modifier.height(16.dp))

            // Yeni adres butonu
            Button(
                onClick = {  },
                modifier = Modifier.fillMaxWidth(),
                colors = ButtonDefaults.buttonColors(containerColor = Color.DarkGray)
            ) {
                Text(text = "Create A New Address", color = Color.White)
            }

            Spacer(modifier = Modifier.height(24.dp))

            // Sipariş başlığı
            Text(
                text = "Order List",
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold
            )

            Spacer(modifier = Modifier.height(16.dp))

            // Sipariş listesi
            OrderItem("Louis Vuitton Belle Epoque Carryall", "1 piece", R.drawable.louisbag)
            OrderItem("Rolex Datejust 36", "1 piece", R.drawable.rolex2)
            OrderItem("Liang Xiu Eternal Blossoms", "1 piece", R.drawable.vase)

            Spacer(modifier = Modifier.weight(1f))

            // Devam et butonu
            Button(
                onClick = {
                    navController.navigate("payment_method")
                },
                modifier = Modifier.fillMaxWidth(),
                colors = ButtonDefaults.buttonColors(containerColor = Color.DarkGray)
            ) {
                Text(text = "Continue To Payment", color = Color.White)
            }
        }
    }
}

@Composable
fun AddressItem(title: String, address: String, isSelected: Boolean) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        // Konum simgesi
        Icon(
            painter = painterResource(id = R.drawable.local),
            contentDescription = null,
            modifier = Modifier.size(24.dp),
            tint = Color.DarkGray
        )
        Spacer(modifier = Modifier.width(8.dp))
        Column {
            Text(text = title, fontWeight = FontWeight.Bold, fontSize = 16.sp)
            Text(text = address, color = Color.Gray, fontSize = 14.sp)
        }
        Spacer(modifier = Modifier.weight(1f))
        if (isSelected) {
            Icon(
                painter = painterResource(id = R.drawable.addd2),
                contentDescription = null,
                modifier = Modifier.size(24.dp),
                //tint = Color.DarkGray
            )
        }
    }
}

@Composable
fun OrderItem(title: String, quantity: String, imageRes: Int) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(100.dp)
            .padding(vertical = 8.dp),
        shape = RoundedCornerShape(12.dp)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxSize()
        ) {
            // Ürün görseli
            Image(
                painter = painterResource(id = imageRes),
                contentDescription = "Product Image",
                modifier = Modifier
                    .size(80.dp)
                    .padding(8.dp),
                contentScale = ContentScale.Crop
            )
            Spacer(modifier = Modifier.width(8.dp))
            Column(
                verticalArrangement = Arrangement.Center,
                modifier = Modifier.fillMaxHeight()
            ) {
                Text(text = title, fontWeight = FontWeight.Bold, fontSize = 16.sp)
                Text(text = quantity, color = Color.Gray, fontSize = 14.sp)
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun CheckoutScreenPreview() {
    CheckoutScreen(navController = rememberNavController())
}//onCreateNewAddress = {}, onContinueToPayment = {}