package com.example.rarelyapp.ui.authentication

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.material3.OutlinedTextField
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.runtime.LaunchedEffect
import com.example.rarelyapp.R

@Composable
fun VerificationScreen() {
    val background: Painter = painterResource(id = R.drawable.r)
    val codeInputs = remember { mutableStateListOf("", "", "", "") }
    val focusRequesters = List(4) { FocusRequester() }

    Box(modifier = Modifier.fillMaxSize()) {
        Image(
            modifier = Modifier
                .fillMaxSize()
                .alpha(0.1f),
            painter = background,
            contentDescription = null,
        )

        Column(
            modifier = Modifier
                .background(Color(0xFFFCF7F0))
                .fillMaxSize()
                .padding(16.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                modifier = Modifier.fillMaxWidth(),
                text = stringResource(id = R.string.verification_code_title),
                fontFamily = FontFamily(Font(R.font.aboreto_regular)),
                fontSize = 32.sp,
                color = Color(0xFF18233D),
                textAlign = TextAlign.Center
            )

            Text(
                modifier = Modifier.padding(12.dp),
                text = stringResource(id = R.string.email),
                fontFamily = FontFamily(Font(R.font.gfs_didot_regular)),
                fontSize = 16.sp,
                color = Color(0xFF4E4E50),
            )

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 30.dp, start = 52.dp),
                horizontalArrangement = Arrangement.spacedBy(8.dp),
                verticalAlignment = Alignment.Top
            ) {
                repeat(4) { index ->
                    OutlinedTextField(
                        value = codeInputs[index],
                        onValueChange = { newValue ->
                            if (newValue.length <= 1) {
                                codeInputs[index] = newValue
                                if (newValue.isNotEmpty() && index < 3) {
                                    focusRequesters[index + 1].requestFocus()
                                }
                            }
                        },
                        modifier = Modifier
                            .size(60.dp)
                            .focusRequester(focusRequesters[index]),
                        shape = CircleShape,
                        textStyle = TextStyle(
                            color = Color(0xFF18233D),
                            fontWeight = FontWeight.Bold,
                            fontSize = 24.sp,
                            textAlign = TextAlign.Center
                        ),
                        singleLine = true,
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                    )


                    LaunchedEffect(codeInputs[index]) {
                        if (codeInputs[index].isEmpty() && index > 0) {
                            focusRequesters[index - 1].requestFocus()
                        }
                    }
                }
            }

            Spacer(modifier = Modifier.height(16.dp))

            Text(
                text = stringResource(id = R.string.code_message),
                fontFamily = FontFamily(Font(R.font.gfs_didot_regular)),
                fontSize = 16.sp,
                color = Color(0xFF4E4E50),
            )

            Text(
                //TODO: make user send verification code
                text = stringResource(id = R.string.send_again),
                fontFamily = FontFamily(Font(R.font.gfs_didot_regular)),
                fontSize = 16.sp,
                color = Color(0xFF4E4E50),
                style = TextStyle(textDecoration = TextDecoration.Underline)
            )

            Spacer(modifier = Modifier.height(16.dp))

            Button(
                //TODO: add onClick after authentication is complete
                onClick = { /*TODO*/ },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(57.dp)
                    .clickable { },
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFF18233D), contentColor = Color.White
                )
            ) {
                Text(
                    //TODO: create navigation and navigate the user to create password page
                    text = stringResource(id = R.string.enter),
                    fontFamily = FontFamily(Font(R.font.gfs_didot_regular)),
                    fontSize = 16.sp,
                    color = Color(0xFFFFFFFF),
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun VerificationScreenPreview() {
    VerificationScreen()
}
