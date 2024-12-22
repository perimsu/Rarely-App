package com.example.rarelyapp.ui.authentication.verification

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.rarelyapp.R
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun VerificationScreen(viewModel: VerificationScreenViewModel = viewModel()) {
    val uiState = viewModel.uiState.value
    val focusRequesters = List(4) { FocusRequester() }

    Box(modifier = Modifier.fillMaxSize()) {
        Image(
            painter = painterResource(id = R.drawable.authentication_flow_background),
            contentDescription = "Rarely logo",
            modifier = Modifier.fillMaxSize()
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
                text = stringResource(id = R.string.verification_code_title),
                fontSize = 32.sp,
                fontFamily = FontFamily(Font(R.font.aboreto_regular)),
                color = Color(0xFF18233D),
                textAlign = TextAlign.Center,
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(16.dp))

            Text(
                modifier = Modifier.padding(12.dp),
                text = stringResource(id = R.string.email),
                fontFamily = FontFamily(Font(R.font.gfs_didot_regular)),
                fontSize = 16.sp,
                color = Color(0xFF4E4E50),
            )

            Row(
                modifier = Modifier.fillMaxWidth()
                    .padding(top = 30.dp, start = 52.dp),
                horizontalArrangement = Arrangement.spacedBy(8.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                repeat(4) { index ->
                    OutlinedTextField(
                        value = uiState.codeInputs[index],
                        onValueChange = { value ->
                            if (value.length <= 1) {
                                viewModel.handleAction(
                                    VerificationScreenAction.EnterCode(index, value)
                                )
                                if (value.isNotEmpty() && index < 3) {
                                    focusRequesters[index + 1].requestFocus()
                                }
                            }
                        },
                        modifier = Modifier
                            .size(60.dp)
                            .focusRequester(focusRequesters[index]),
                        shape = CircleShape,
                        textStyle = TextStyle(
                            fontSize = 24.sp,
                            textAlign = TextAlign.Center,
                            color = Color.Black,
                            fontWeight = FontWeight.Bold
                        ),
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
                    )

                    LaunchedEffect(uiState.codeInputs[index]) {
                        if (uiState.codeInputs[index].isEmpty() && index > 0) {
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
            TextButton(onClick = { viewModel.handleAction(VerificationScreenAction.ResendCode) }) {

                Text(
                    text = stringResource(id = R.string.send_again),
                    fontFamily = FontFamily(Font(R.font.gfs_didot_regular)),
                    fontSize = 16.sp,
                    color = Color(0xFF4E4E50),
                    style = TextStyle(textDecoration = TextDecoration.Underline)
                )
            }
            Button(
                onClick = { viewModel.handleAction(VerificationScreenAction.SubmitCode) },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(57.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFF18233D),
                    contentColor = Color.White
                )
            ) {
                Text(
                    text = stringResource(id = R.string.enter),
                    fontSize = 16.sp,
                    fontFamily = FontFamily(Font(R.font.gfs_didot_regular)),
                    color = Color.White
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
