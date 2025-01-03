package com.example.rarelyapp.ui.authentication.complete_account

import android.net.Uri
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.PickVisualMediaRequest
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.example.rarelyapp.R
import com.example.rarelyapp.components.ProfilePhotoPicker
import com.example.rarelyapp.components.RarelyBaseButton
import com.example.rarelyapp.components.RarelyBaseTextField
import com.example.rarelyapp.components.RarelyDropdownMenu
import com.example.rarelyapp.components.RarelyTitleText
import com.example.rarelyapp.ui.theme.RarelyAppTheme

@Composable
fun CompleteProfileScreen(
    uiState: CompleteProfileScreenUiState,
    onCompleteProfileSuccessful: () -> Unit,
    onAction: (CompleteProfileScreenAction) -> Unit
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
        CompleteProfileScreenContent(
            uiState = uiState,
            onCompleteProfileClicked = onCompleteProfileSuccessful,
            onAction = onAction
        )
    }
}

@Composable
fun CompleteProfileScreenContent(
    uiState: CompleteProfileScreenUiState,
    onAction: (CompleteProfileScreenAction) -> Unit,
    onCompleteProfileClicked: () -> Unit,
) {
    var selectedImageUri by remember { mutableStateOf<Uri?>(null) }
    var selectedGender by remember { mutableStateOf("") }
    val genders = listOf(
        stringResource(R.string.gender_male),
        stringResource(R.string.gender_female),
        stringResource(R.string.gender_other)
    )

    val photoPickerLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.PickVisualMedia()
    ) { uri: Uri? ->
        selectedImageUri = uri
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.height(96.dp))
        RarelyTitleText(
            stringResource(R.string.complete_profile_title),
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(16.dp))
        ProfilePhotoPicker(
            onClick = { photoPickerLauncher.launch(PickVisualMediaRequest(ActivityResultContracts.PickVisualMedia.ImageOnly)) },
            painter = if (selectedImageUri != null) rememberAsyncImagePainter(selectedImageUri) else painterResource(
                id = R.drawable.profile_photo_icon
            )
        )
        Spacer(modifier = Modifier.height(16.dp))
        Column(
            horizontalAlignment = Alignment.Start,
            verticalArrangement = Arrangement.Center
        ) {
            RarelyBaseTextField(
                text = uiState.username,
                onValueChange = { onAction(CompleteProfileScreenAction.UserNameChanged(it)) },
                textFieldHeader = stringResource(R.string.tf_header_username)
            )
            Spacer(modifier = Modifier.height(4.dp))
            RarelyBaseTextField(
                text = uiState.phoneNumber,
                onValueChange = { onAction(CompleteProfileScreenAction.PhoneNumberChanged(it)) },
                textFieldHeader = stringResource(R.string.tf_header_phoneNumber)
            )
            Spacer(modifier = Modifier.height(4.dp))
            RarelyDropdownMenu(
                text = uiState.gender,
                options = genders,
                onValueChangedEvent = {
                    onAction(CompleteProfileScreenAction.GenderChanged(it))
                }
            )

            Spacer(modifier = Modifier.height(16.dp))

            RarelyBaseButton(
                text = stringResource(R.string.button_enter),
                onClick = onCompleteProfileClicked
            )

        }
    }
}

@Preview(showBackground = true, showSystemUi = false)
@Composable
fun CompleteProfileScreenPreview() {
    RarelyAppTheme {
        CompleteProfileScreen(
            uiState = CompleteProfileScreenUiState(),
            onCompleteProfileSuccessful = {},
            onAction = {}
        )
    }
}