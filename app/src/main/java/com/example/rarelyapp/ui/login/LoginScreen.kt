package com.example.rarelyapp.ui.authentication.login

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.media3.effect.Crop
import com.example.rarelyapp.R
import com.example.rarelyapp.components.AuthProviderBox
import com.example.rarelyapp.components.RarelyBaseButton
import com.example.rarelyapp.components.RarelyBaseTextField
import com.example.rarelyapp.components.RarelyTitleText
import com.example.rarelyapp.ui.login.LoginScreenAction
import com.example.rarelyapp.ui.theme.RarelyAppTheme

@Composable
fun LoginScreen(
    uiState: LoginScreenUiState,
    onLoginSuccessful: () -> Unit,
    onClickSignUp: () -> Unit,
    onAction: (LoginScreenAction) -> Unit
) {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        val contentScale = null
        Image(
            painter = painterResource(id = R.drawable.authentication_flow_background),
            contentDescription = "Rarely logo",
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop
        )
        LoginScreenContent(
            uiState = uiState,
            onLoginSuccessful = onLoginSuccessful,
            onAction = onAction,
            onClickSignUp = onClickSignUp
        )
    }
}

@Composable
fun LoginScreenContent(
    uiState: LoginScreenUiState,
    onAction: (LoginScreenAction) -> Unit,
    onLoginSuccessful: () -> Unit,
    onClickSignUp: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Spacer(modifier = Modifier.height(96.dp))
        RarelyTitleText(stringResource(R.string.log_in), modifier = Modifier.fillMaxWidth())
        Spacer(modifier = Modifier.height(72.dp))
        Column(
            horizontalAlignment = Alignment.Start,
            verticalArrangement = Arrangement.Center
        ) {
            RarelyBaseTextField(
                text = uiState.email,
                onValueChange = { onAction(LoginScreenAction.EmailChanged(it)) },
                textFieldHeader = stringResource(R.string.tf_header_email)
            )
            Spacer(modifier = Modifier.height(4.dp))
            RarelyBaseTextField(
                text = uiState.password,
                visualTransformation = PasswordVisualTransformation(),
                onValueChange = { onAction(LoginScreenAction.PasswordChanged(it)) },
                textFieldHeader = stringResource(R.string.tf_header_password)
            )

            Spacer(modifier = Modifier.height(36.dp))

            RarelyBaseButton(
                text = stringResource(R.string.button_log_in),
                onClick = onLoginSuccessful
            )

            Spacer(modifier = Modifier.height(48.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly,
                verticalAlignment = Alignment.CenterVertically
            ) {
                AuthProviderBox(
                    authProviderLogoResource = R.drawable.auth_provider_play,
                    size = 22.dp
                )

                AuthProviderBox(
                    authProviderLogoResource = R.drawable.auth_provider_google,
                )

                AuthProviderBox(
                    authProviderLogoResource = R.drawable.auth_provider_facebook,
                )
            }
            Spacer(modifier = Modifier.height(32.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = stringResource(R.string.dont_have_an_account),
                    style = MaterialTheme.typography.bodyLarge
                )
                TextButton(
                    onClick = onClickSignUp,
                    modifier = Modifier.padding(start = 4.dp),
                    contentPadding = PaddingValues(0.dp),
                    colors = ButtonDefaults.textButtonColors(
                        contentColor = MaterialTheme.colorScheme.onBackground
                    )
                ) {
                    Text(
                        text = stringResource(R.string.redirect_to_sign_up),
                        style = MaterialTheme.typography.bodyLarge,
                        textDecoration = TextDecoration.Underline
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true, showSystemUi = false)
@Composable
fun LoginScreenPreview() {
    RarelyAppTheme {
        LoginScreen(
            uiState = LoginScreenUiState(),
            onLoginSuccessful = {},
            onAction = {},
            onClickSignUp = {}
        )
    }
}
