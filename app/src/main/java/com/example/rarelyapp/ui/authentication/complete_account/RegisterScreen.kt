package com.example.rarelyapp.ui.authentication.complete_account

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.rarelyapp.R
import com.example.rarelyapp.components.AuthProviderBox
import com.example.rarelyapp.components.RarelyBaseButton
import com.example.rarelyapp.components.RarelyBaseTextField
import com.example.rarelyapp.components.RarelyTitleText
import com.example.rarelyapp.ui.theme.RarelyAppTheme

@Composable
fun RegisterScreen(
    uiState: RegisterScreenUiState,
    onRegisterSuccessful: () -> Unit,
    onClickSignIn: () -> Unit,
    onAction: (RegisterScreenAction) -> Unit
) {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Image(
            painter = painterResource(id = R.drawable.authentication_flow_background),
            contentDescription = "Rarely logo",
            modifier = Modifier.fillMaxSize()
        )
        RegisterScreenContent(
            uiState = uiState,
            onRegisterSuccessful = onRegisterSuccessful,
            onAction = onAction,
            onClickSignIn = onClickSignIn
        )
    }
}

@Composable
fun RegisterScreenContent(
    uiState: RegisterScreenUiState,
    onAction: (RegisterScreenAction) -> Unit,
    onRegisterSuccessful: () -> Unit,
    onClickSignIn: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Spacer(modifier = Modifier.height(96.dp))
        RarelyTitleText(stringResource(R.string.create_account), modifier = Modifier.fillMaxWidth())
        Spacer(modifier = Modifier.height(72.dp))
        Column(
            horizontalAlignment = Alignment.Start,
            verticalArrangement = Arrangement.Center
        ) {
            RarelyBaseTextField(
                text = uiState.nameSurname,
                onValueChange = { onAction(RegisterScreenAction.NameSurnameChanged(it)) },
                textFieldHeader = stringResource(R.string.tf_header_name_surname)
            )
            Spacer(modifier = Modifier.height(4.dp))
            RarelyBaseTextField(
                text = uiState.email,
                onValueChange = { onAction(RegisterScreenAction.EmailChanged(it)) },
                textFieldHeader = stringResource(R.string.tf_header_email)
            )
            Spacer(modifier = Modifier.height(4.dp))
            RarelyBaseTextField(
                text = uiState.password,
                visualTransformation = PasswordVisualTransformation(),
                onValueChange = { onAction(RegisterScreenAction.PasswordChanged(it)) },
                textFieldHeader = stringResource(R.string.tf_header_password)
            )

            Spacer(modifier = Modifier.height(36.dp))

            RarelyBaseButton(
                text = stringResource(R.string.button_create_account),
                onClick = onRegisterSuccessful
            )

            Spacer(modifier = Modifier.height(8.dp))

            Row(
                verticalAlignment = Alignment.CenterVertically,
            ) {
                /*Text(
                    text = stringResource(R.string.checkbox_remember_me),
                    style = MaterialTheme.typography.bodyLarge.copy(fontSize = 14.sp)
                )*/
                Checkbox(
                    checked = uiState.rememberMe,
                    onCheckedChange = { onAction(RegisterScreenAction.RememberMeChanged(it)) },
                )
            }

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
                    text = stringResource(R.string.already_have_an_account),
                    style = MaterialTheme.typography.bodyLarge
                )
                TextButton(
                    onClick = onClickSignIn,
                    modifier = Modifier.padding(start = 4.dp),
                    contentPadding = PaddingValues(0.dp),
                    colors = ButtonDefaults.textButtonColors(
                        contentColor = MaterialTheme.colorScheme.onBackground
                    )
                ) {
                    Text(
                        text = stringResource(R.string.redirect_to_sign_in),
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
fun RegisterScreenPreview() {
    RarelyAppTheme {
        RegisterScreen(
            uiState = RegisterScreenUiState(),
            onRegisterSuccessful = {},
            onAction = {},
            onClickSignIn = {}
        )
    }
}