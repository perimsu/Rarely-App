package com.example.rarelyapp.ui.base.main.payment

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
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
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.rarelyapp.R
import com.example.rarelyapp.components.RarelyTitleText

@Composable
fun PaymentSuccessfulScreen(navController: NavController) {
    Box(
        modifier = Modifier
            .fillMaxSize()
    ) {
        // Arka plan görseli
        Image(
            painter = painterResource(id = R.drawable.authentication_flow_background),
            contentDescription = null,
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop
        )

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(bottom = 70.dp), // Alt çubuğa yer bırakmak için padding ekledik
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            RarelyTitleText(
                text = stringResource(R.string.payment_successful),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 16.dp)
            )

            Spacer(modifier = Modifier.weight(1f))

            Image(
                painter = painterResource(id = R.drawable.addd2),
                contentDescription = "Success",
                modifier = Modifier.size(150.dp)
            )

            Spacer(modifier = Modifier.height(24.dp))

            Text(
                text = stringResource(id = R.string.payment_successful2),
                style = MaterialTheme.typography.titleMedium,
                color = Color.Black
            )

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = stringResource(id = R.string.payment_successful3),
                style = MaterialTheme.typography.bodyMedium,
                color = Color.Gray
            )

            Spacer(modifier = Modifier.height(24.dp))

            Text(
                text = "Your Order Number: 123456789",  // Statik numara
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.Bold
            )

            Spacer(modifier = Modifier.weight(1f))

            Image(
                painter = painterResource(id = R.drawable.view_order),
                contentDescription = "Button",
                modifier = Modifier
                    .size(200.dp, 50.dp)
                    .clickable {
                        navController.navigate("my_orders")
                    }
            )
            Spacer(modifier = Modifier.height(10.dp))
        }

        // Boşluk ekleyerek alt çubuğun yerini koruduk
        Spacer(modifier = Modifier
            .fillMaxWidth()
            .height(70.dp) // NavBar'ın yerini koruyacak boşluk
        )
    }
}

@Preview(showBackground = true)
@Composable
fun PaymentSuccessfulScreenPreview() {
    PaymentSuccessfulScreen(navController = rememberNavController())
}