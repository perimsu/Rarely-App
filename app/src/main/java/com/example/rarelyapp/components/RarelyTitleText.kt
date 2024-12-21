package com.example.rarelyapp.components

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import com.example.rarelyapp.ui.theme.RarelyAppTheme

@Composable
fun RarelyTitleText(
    text: String,
    modifier: Modifier = Modifier,
    color: Color = MaterialTheme.colorScheme.onBackground,
    textAlign: TextAlign = TextAlign.Center
) {
    Text(
        text = text,
        style = MaterialTheme.typography.displaySmall,
        modifier = modifier,
        textAlign = textAlign,
        color = color
    )
}

@Preview(showBackground = true)
@Composable
private fun RarelyTitleTextPreview() {
    RarelyAppTheme {
        RarelyTitleText(
            text = "CREATE ACCOUNT",
            modifier = Modifier,
            color = MaterialTheme.colorScheme.onBackground,
        )
    }
}