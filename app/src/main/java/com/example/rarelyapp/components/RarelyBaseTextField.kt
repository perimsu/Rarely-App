package com.example.rarelyapp.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.rarelyapp.ui.theme.RarelyAppTheme

@Composable
fun RarelyBaseTextField(
    modifier: Modifier = Modifier,
    onValueChange: (String) -> Unit = {},
    singleLine: Boolean = true,
    maxLines: Int = 1,
    textStyle: TextStyle = MaterialTheme.typography.bodyLarge,
    placeholderText: String = "",
    text: String = "",
    textFieldHeader: String = "",
    visualTransformation: VisualTransformation = VisualTransformation.None,
    trailingIcon: @Composable (() -> Unit)? = null
) {

    Column(
        modifier = modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.Start
    ) {
        Text(
            text = textFieldHeader,
            style = textStyle
        )

        Spacer(modifier = Modifier.height(8.dp))

        BasicTextField(
            value = text,
            onValueChange = onValueChange,
            singleLine = singleLine,
            maxLines = maxLines,
            textStyle = textStyle,
            visualTransformation = visualTransformation,
            decorationBox = { innerTextField ->
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(Color.White, shape = RoundedCornerShape(50.dp))
                        .border(1.dp, Color.LightGray, shape = RoundedCornerShape(50.dp))
                        .padding(horizontal = 16.dp, vertical = 16.dp),
                    contentAlignment = Alignment.CenterStart
                ) {
                    if (text.isEmpty()) {
                        Text(
                            text = placeholderText,
                            style = textStyle,
                            color = Color.LightGray
                        )
                    }
                    if (trailingIcon != null) {
                        Box(modifier = Modifier.align(Alignment.CenterEnd)) {
                            trailingIcon()
                        }
                    }
                    innerTextField()
                }
            }
        )
    }
}

@Preview(showBackground = true, showSystemUi = false)
@Composable
private fun RoundedEmailTextFieldPreview() {
    RarelyAppTheme {
        RarelyBaseTextField(
            onValueChange = {},
            singleLine = true,
            maxLines = 1,
            textStyle = MaterialTheme.typography.bodyLarge,
            placeholderText = "E-mail",
            text = "",
            textFieldHeader = "Email",
            trailingIcon = {
                IconButton(onClick = {}) {
                    Icon(
                        imageVector = Icons.Default.Clear,
                        contentDescription = "Clear",
                        tint = Color.LightGray,
                        modifier = Modifier.size(16.dp)
                    )
                }
            }
        )
    }
}
