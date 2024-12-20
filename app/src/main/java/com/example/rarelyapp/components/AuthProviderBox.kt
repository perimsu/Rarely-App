package com.example.rarelyapp.components

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.rarelyapp.R
import com.example.rarelyapp.ui.theme.RarelyAppTheme

@Composable
fun AuthProviderBox(
    modifier: Modifier = Modifier,
    backgroundColor: Color = MaterialTheme.colorScheme.background,
    @DrawableRes
    authProviderLogoResource: Int
) {
    Box(
        modifier = modifier
            .clip(CircleShape)
            .background(backgroundColor, CircleShape)
    ) {
        Image(
            painter = painterResource(id = authProviderLogoResource),
            contentDescription = null,
            modifier = Modifier.padding(16.dp)
        )
    }
}

@Preview(showBackground = true, showSystemUi = false)
@Composable
fun AuthProviderBoxPreview() {
    RarelyAppTheme {
        AuthProviderBox(
            modifier = Modifier,
            backgroundColor = MaterialTheme.colorScheme.background,
            authProviderLogoResource = R.drawable.auth_provider_google
        )
    }
}