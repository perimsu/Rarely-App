package com.example.rarelyapp.ui.profile

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.rarelyapp.R
import com.example.rarelyapp.ui.theme.DarkBlue
import com.example.rarelyapp.ui.theme.Grey
import com.example.rarelyapp.ui.theme.RarelyAppTheme

@Composable
fun ProfileScreen(
    uiState: ProfileScreenUiState,
    onAction: (ProfileScreenAction) -> Unit
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFF7F4EE))
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.Transparent)
        ) {
            //left Arrow
            Image(
                painter = painterResource(R.drawable.leftarrow),
                contentDescription = "Left Arrow",
                modifier = Modifier
                    .size(24.dp)
                    .padding(16.dp)
                    .align(Alignment.TopStart),
                contentScale = ContentScale.Fit
            )
        }
        Column(
            modifier = Modifier
                .verticalScroll(rememberScrollState())
                .fillMaxWidth()
        ) {
            Spacer(modifier = Modifier.height(8.dp))

            Image(
                painter = painterResource(R.drawable.emily),
                contentDescription = "Profile Picture",
                modifier = Modifier
                    .size(120.dp)
                    .clip(CircleShape)
                    .border(2.dp, Color.Gray, CircleShape)
                    .align(Alignment.CenterHorizontally),
                contentScale = ContentScale.Crop
            )

            Spacer(modifier = Modifier.height(4.dp))

            // User Name
            Text(
                text = uiState.userName,
                style = MaterialTheme.typography.titleLarge,
                modifier = Modifier.align(Alignment.CenterHorizontally)
            )
            Text(
                text = "@${uiState.userName}",
                style = MaterialTheme.typography.bodyMedium,
                color = Color(0xFFB6B6B6),
                modifier = Modifier.align(Alignment.CenterHorizontally)
            )

            Spacer(modifier = Modifier.height(8.dp))

            // Statistics
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                StatText("Following", uiState.followingCount)
                StatText("Followers", uiState.followerCount)
                StatText("Sales", uiState.salesCount)
            }

            Spacer(modifier = Modifier.height(8.dp))

            // Tab Section
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(60.dp)
                    .background(Color(0xFFF8E1E8), RoundedCornerShape(32.dp)) // Pembe arka plan
                    .padding(vertical = 8.dp, horizontal = 24.dp),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                TabButton(
                    text = "Upload Rare",
                    isSelected = true,
                    modifier = Modifier
                        .weight(1f)
                        .clip(RoundedCornerShape(16.dp))
                ) { }

                TabButton(
                    text = "My Rares",
                    isSelected = false,
                    modifier = Modifier
                        .weight(1f)
                        .clip(RoundedCornerShape(16.dp))
                ) { }
            }

            Spacer(modifier = Modifier.height(8.dp))


            Text(
                text = "Upload photos of your Rare (maximum 5):",
                style = MaterialTheme.typography.bodyMedium,
                modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp)
            )


            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp)
            ) {
                Box(
                    modifier = Modifier
                        .size(120.dp)
                        .background((Grey), RoundedCornerShape(16.dp))
                        .padding(8.dp)
                        .clickable { onAction(ProfileScreenAction.OnUploadClicked) },

                    contentAlignment = Alignment.TopEnd
                ) {
                    Icon(
                        painter = painterResource(R.drawable.plus),
                        contentDescription = "Add Photo",
                        tint = Color.Unspecified,
                        modifier = Modifier
                            .size(20.dp)
                            .align(Alignment.TopEnd)
                            .offset(x = (4).dp, y = (-4).dp)
                    )
                }
            }

            Spacer(modifier = Modifier.height(2.dp))


            LabeledTextField(
                label = "Name of your Rare",
                value = uiState.rareName,
                onValueChange = { onAction(ProfileScreenAction.RareNameChanged(it)) },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp)
                    .border(1.dp, Color.Gray, RoundedCornerShape(8.dp))
            )


            Spacer(modifier = Modifier.height((-4).dp))


            LabeledTextField(
                label = "Describe the features of your Rare",
                value = uiState.rareDescription,
                onValueChange = { onAction(ProfileScreenAction.RareDescriptionChanged(it)) },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp)
                    .border(1.dp, Color.Gray, RoundedCornerShape(8.dp))
            )


            Spacer(modifier = Modifier.height((-4).dp))

// Price
            LabeledTextField(
                label = "Price",
                value = uiState.rarePrice,
                onValueChange = { onAction(ProfileScreenAction.RarePriceChanged(it)) },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp)
                    .border(1.dp, Color.Gray, RoundedCornerShape(8.dp))
            )
            Spacer(modifier = Modifier.height(2.dp))

            // Upload Button
            Button(
                onClick = { onAction(ProfileScreenAction.OnUploadClicked) },
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .padding(horizontal = 16.dp)
                    .height(60.dp)
                    .width(200.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Color.Black)
            ) {
                Text(text = "Upload", color = Color.White)
            }


            Spacer(modifier = Modifier.height(2.dp))
        }
    }
}

@Composable
fun TabButton(
    text: String,
    isSelected: Boolean,
    modifier: Modifier = Modifier,
    onClick: () -> Unit
) {
    Box(
        modifier = modifier
            .padding(vertical = 1.dp, horizontal = 1.dp)
            .height(56.dp)
            .background(
                if (isSelected) DarkBlue
                else Color.Transparent,
                shape = RoundedCornerShape(32.dp)
            )
            .clickable(onClick = onClick),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = text,
            color = if (isSelected) Color.White else Color.Gray
        )
    }
}

@Composable
fun StatText(label: String, count: Int) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Text(text = "$count", style = MaterialTheme.typography.titleLarge, color = Color.Black)
        Text(text = label, style = MaterialTheme.typography.bodySmall, color = Color.Gray)
    }
}

@Composable
fun LabeledTextField(
    label: String,
    value: String,
    onValueChange: (String) -> Unit,
    keyboardOptions: KeyboardOptions = KeyboardOptions.Default,
    modifier: Modifier = Modifier
) {
    Column(modifier = Modifier.padding(vertical = 8.dp)) {
        Text(
            text = label,
            style = MaterialTheme.typography.bodyMedium,
            modifier = Modifier.padding(horizontal = 16.dp)
        )
        Box(
            modifier = Modifier
                .padding(horizontal = 16.dp)
                .fillMaxWidth()
                .background(Color.White, RoundedCornerShape(16.dp))
                .border(1.dp, Color.Gray, RoundedCornerShape(16.dp))
        ) {
            BasicTextField(
                value = value,
                onValueChange = onValueChange,
                keyboardOptions = keyboardOptions,
                textStyle = LocalTextStyle.current.copy(color = Color.Black),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp)
                    .background(Color.Transparent)
            )
        }
    }
}
data class ProfileScreenUiState(
    val userName: String = "Emily Johnson",
    val followingCount: Int = 45,
    val followerCount: Int = 30,
    val salesCount: Int = 14,
    val rareName: String = "",
    val rareDescription: String = "",
    val rarePrice: String = ""
)

sealed interface ProfileScreenAction {
    data class RareNameChanged(val name: String) : ProfileScreenAction
    data class RareDescriptionChanged(val description: String) : ProfileScreenAction
    data class RarePriceChanged(val price: String) : ProfileScreenAction
    object OnUploadClicked : ProfileScreenAction
}


@Preview
@Composable
fun ProfileScreenPreview()
{ RarelyAppTheme {
    ProfileScreen( uiState = ProfileScreenUiState(
        userName = "Emily Johnson",
        followingCount = 45,
        followerCount = 30,
        salesCount = 14,
        rareName = "",
        rareDescription = "",
        rarePrice = "" ),
        onAction = {} )
} }