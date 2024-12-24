package com.example.rarelyapp.ui.authentication.create_password

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.rarelyapp.R
import com.example.rarelyapp.components.RarelyBaseButton
import com.example.rarelyapp.components.RarelyBaseTextField
import com.example.rarelyapp.components.RarelyTitleText
import com.example.rarelyapp.ui.theme.RarelyAppTheme

@Composable
fun CreatePasswordScreen(
    uiState: CreatePasswordScreenUiState,
    onCreatePasswordClicked: () -> Unit,
    onAction: (CreatePasswordScreenAction) -> Unit
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
        CreatePasswordScreenContent(
            uiState = uiState,
            onCreatePasswordClicked = onCreatePasswordClicked,
            onAction = onAction
        )
    }
}

@Composable
fun CreatePasswordScreenContent(
    uiState: CreatePasswordScreenUiState,
    onCreatePasswordClicked: () -> Unit,
    onAction: (CreatePasswordScreenAction) -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.height(96.dp))
        RarelyTitleText(
            stringResource(R.string.create_Password),
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(48.dp))
        Column(
            horizontalAlignment = Alignment.Start,
            verticalArrangement = Arrangement.Center
        ) {
            var passwordVisible by remember { mutableStateOf(false) }
            RarelyBaseTextField(
                text = uiState.password,
                onValueChange = { onAction(CreatePasswordScreenAction.PasswordChanged(it)) },
                textFieldHeader = "Enter Password",
                visualTransformation = if (passwordVisible) VisualTransformation.None else PasswordVisualTransformation(),
                trailingIcon = {
                    Image(
                        painter = painterResource(id = R.drawable.ic_eye_closed),
                        contentDescription = null,
                        modifier = Modifier
                            .size(24.dp) // Set the size of the eye icon
                            .clickable { passwordVisible = !passwordVisible }
                    )
                }
            )

            Spacer(modifier = Modifier.height(16.dp))

            var confirmPasswordVisible by remember { mutableStateOf(false) }
            RarelyBaseTextField(
                text = uiState.confirmPassword,
                onValueChange = { onAction(CreatePasswordScreenAction.ConfirmPasswordChanged(it)) },
                textFieldHeader = "Confirm Password",
                visualTransformation = if (confirmPasswordVisible) VisualTransformation.None else PasswordVisualTransformation(),
                trailingIcon = {
                    Image(
                        painter = painterResource(id = R.drawable.ic_eye_closed),
                        contentDescription = null,
                        modifier = Modifier
                            .size(24.dp) // Set the size of the eye icon
                            .clickable { confirmPasswordVisible = !confirmPasswordVisible }
                    )
                }
            )

            Spacer(modifier = Modifier.height(24.dp))

            RarelyBaseButton(
                text = "Create Password",
                onClick = onCreatePasswordClicked
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun CreatePasswordScreenPreview() {
    RarelyAppTheme {
        CreatePasswordScreen(
            uiState = CreatePasswordScreenUiState(),
            onCreatePasswordClicked = {},
            onAction = {}
        )
    }
}
