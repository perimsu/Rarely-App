package com.example.rarelyapp.ui.base.main.payment

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.material3.*
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.Alignment
import androidx.compose.ui.res.painterResource
import com.example.rarelyapp.R
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import com.example.rarelyapp.components.RarelyTitleText
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import com.example.rarelyapp.components.RarelyBaseButton
import androidx.compose.ui.text.style.TextAlign
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController

@Composable
fun PaymentMethodsScreen() {
    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        // Arka plan görseli
        Image(
            painter = painterResource(id = R.drawable.authentication_flow_background),
            contentDescription = "Background",
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop
        )

        // İçerik
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(bottom = 70.dp) // Alt çubuk için boşluk bırak
        ) {
            PaymentMethodsContent(navController = rememberNavController())
        }

        // Alt navigasyon çubuğu için boşluk
        Spacer(modifier = Modifier.height(70.dp))
    }
}

@Composable
fun PaymentMethodsContent(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        RarelyTitleText(
            text = stringResource(R.string.payment_methods),
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 16.dp),
        )

        Spacer(modifier = Modifier.height(32.dp))

        Text(
            text = "Credit Card",
            style = MaterialTheme.typography.titleLarge,
            textAlign = TextAlign.Start,
            modifier = Modifier.fillMaxWidth()
        )

        // Ödeme işlemini onaylamak için görsel buton
        Image(
            painter = painterResource(id = R.drawable.payment_add_card),
            contentDescription = "Confirm Payment Button",
            modifier = Modifier
                .size(350.dp, 100.dp)
                .clickable {
                    navController.navigate("add_card")
                    // Yeni tıklama işlevi burada
                    // Örneğin, bir ödeme işlemi başlatılabilir veya başka bir ekran gösterilebilir
                }
        )
        Spacer(modifier = Modifier.weight(1f))

        // Add Card butonu
        RarelyBaseButton(
            text = stringResource(R.string.confirm_payment),
            onClick = {
                navController.navigate("payment_successful")
            },
            modifier = Modifier
                .fillMaxWidth(0.8f) // Buton genişliği
                .padding(vertical = 16.dp)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun PaymentMethodsScreenPreview() {
    PaymentMethodsScreen()
}