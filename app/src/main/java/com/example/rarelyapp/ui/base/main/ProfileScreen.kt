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
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModel
import com.example.rarelyapp.R
import com.example.rarelyapp.ui.base.main.ProfileScreenUiState
import com.example.rarelyapp.ui.theme.DarkBlue
import com.example.rarelyapp.ui.theme.Grey
import com.example.rarelyapp.ui.theme.RarelyAppTheme
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

@Composable
fun ProfileScreen(
    uiState: ProfileScreenUiState,
    onAction: (ProfileScreenAction) -> Unit,
    viewModel: ProfileScreenViewModel
) {

    val uiState by viewModel.uiState.collectAsState()

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
            Spacer(modifier = Modifier.height(8.dp))
            //left Arrow
            Image(
                painter = painterResource(R.drawable.leftarrow),
                contentDescription = "Profile Picture",
                modifier = Modifier
                    .size(35.dp)
                    .clip(RectangleShape)
                    .align(Alignment.TopStart),
                contentScale = ContentScale.Crop
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



public sealed interface ProfileScreenAction {
    data class RareNameChanged(val name: String) : ProfileScreenAction
    data class RareDescriptionChanged(val description: String) : ProfileScreenAction
    data class RarePriceChanged(val price: String) : ProfileScreenAction
    object OnUploadClicked : ProfileScreenAction
}


public class ProfileScreenViewModel : ViewModel() {

    private val _uiState = MutableStateFlow(ProfileScreenUiState())
    val uiState = _uiState.asStateFlow()

    fun onAction(action: ProfileScreenAction) {
        when (action) {
            is ProfileScreenAction.RareNameChanged -> {
                _uiState.update { it.copy(rareName = action.name) }
            }
            is ProfileScreenAction.RareDescriptionChanged -> {
                _uiState.update { it.copy(rareDescription = action.description) }
            }
            is ProfileScreenAction.RarePriceChanged -> {
                _uiState.update { it.copy(rarePrice = action.price) }
            }
            is ProfileScreenAction.OnUploadClicked -> {
                // Yükleme işlemleri burada yapılır.
            }
        }
    }
}

@Preview
@Composable
fun ProfileScreenPreview() {
    val uiState = ProfileScreenUiState() // varsayılan değerlerle oluşturulmuş uiState
    val viewModel = ProfileScreenViewModel() // ViewModel örneği

    // onAction fonksiyonunun tanımlanması
    val onAction: (ProfileScreenAction) -> Unit = { action ->
        viewModel.onAction(action)
    }

    RarelyAppTheme {
        ProfileScreen(
            uiState = uiState,  // uiState parametresini geçiriyoruz
            onAction = onAction, // onAction fonksiyonunu geçiriyoruz
            viewModel = viewModel  // viewModel parametresini geçiriyoruz
        )
    }
}