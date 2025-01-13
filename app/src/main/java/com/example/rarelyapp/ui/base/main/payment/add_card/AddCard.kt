
package com.example.rarelyapp.ui.base.main.payment.add_card

import androidx.compose.foundation.Image
import androidx.compose.material3.*
import androidx.compose.ui.text.input.PasswordVisualTransformation
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
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Text
import com.example.rarelyapp.components.RarelyTitleText
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import com.example.rarelyapp.components.RarelyBaseButton
import com.example.rarelyapp.components.RarelyBaseTextField

@Composable
fun AddCardScreen(
    uiState: AddCardScreenUiState,
    onAddCardClicked: () -> Unit,
    onAction: (AddCardScreenAction) -> Unit
) {
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
            AddCardScreenContent(
                uiState = uiState,
                onAddCardClicked = onAddCardClicked,
                onAction = onAction
            )
        }

        // Alt çubuk için sadece boşluk bırakıyoruz
        Spacer(modifier = Modifier.height(70.dp)) // Bu satır navbar boşluğunu bırakacaktır
    }
}

@Composable
fun AddCardScreenContent(
    uiState: AddCardScreenUiState,
    onAddCardClicked: () -> Unit,
    onAction: (AddCardScreenAction) -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        RarelyTitleText(
            text = stringResource(R.string.add_card),
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 16.dp)
        )

        Spacer(modifier = Modifier.height(32.dp))

        Image(
            painter = painterResource(id = R.drawable.card_image),
            contentDescription = "Card Image",
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp)
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Card Holder Name
        RarelyBaseTextField(
            text = uiState.cardHolderName,
            onValueChange = { onAction(AddCardScreenAction.EnterCardHolderName(it)) },
            textFieldHeader = "Card Holder Name"
        )

        Spacer(modifier = Modifier.height(8.dp))

        // Card Number
        RarelyBaseTextField(
            text = uiState.cardNumber,
            onValueChange = { onAction(AddCardScreenAction.EnterCardNumber(it)) },
            textFieldHeader = "Card Number",
            //  keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
        )

        Spacer(modifier = Modifier.height(8.dp))

        // Expiry Date and CVV
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            RarelyBaseTextField(
                text = uiState.expiryDate,
                onValueChange = { onAction(AddCardScreenAction.EnterExpiryDate(it)) },
                textFieldHeader = "Expiry Date",
                modifier = Modifier.weight(1f),
                //  keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
            )
            RarelyBaseTextField(
                text = uiState.cvv,
                onValueChange = { onAction(AddCardScreenAction.EnterCVV(it)) },
                textFieldHeader = "CVV",
                modifier = Modifier.weight(1f),
                visualTransformation = PasswordVisualTransformation(),
                // keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.NumberPassword)
            )
        }

        Spacer(modifier = Modifier.height(8.dp))

        // Save Card Checkbox
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth()
        ) {
            // Görseli ekliyoruz
            Image(
                painter = painterResource(id = R.drawable.saved_card), // Görsel kaynağını buraya koyun
                contentDescription = "Save Card Icon",
                modifier = Modifier
                    .size(24.dp) // Görselin boyutunu ayarlayın
                    .padding(end = 8.dp) // Yazı ile görsel arasındaki boşluğu ayarlayın
            )

            // Yazıyı koruyoruz
            Text(
                text = "Save Card",
                style = MaterialTheme.typography.bodyMedium// Yazı stili için uygun bir tema stili seçin
            )
        }

        Spacer(modifier = Modifier.weight(1f))

        RarelyBaseButton(
            text = "Add Card",
            onClick = onAddCardClicked,
            modifier = Modifier
                .fillMaxWidth(0.8f) // Butonun genişliğini %80'e indiriyoruz
                .padding(bottom = 16.dp) // Sayfanın altından boşluk bırakıyoruz
        )
    }
}

@Preview(showBackground = true)
@Composable
fun AddCardScreenPreview() {
    AddCardScreen(
        uiState = AddCardScreenUiState(),
        onAddCardClicked = {},
        onAction = {}
    )
}