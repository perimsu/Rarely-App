package com.example.rarelyapp.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.rarelyapp.R
import com.example.rarelyapp.ui.theme.RarelyAppTheme

@Composable
fun ProfilePhotoPicker(
    modifier: Modifier = Modifier,
    onClick: () -> Unit = {},
) {
    Box(modifier = modifier) {
        Image(
            painter = painterResource(id = R.drawable.profile_photo_icon),
            contentDescription = "Profile photo picker",
            modifier = modifier
        )
        IconButton(
            onClick = onClick,
            modifier = Modifier

                .align(Alignment.BottomEnd)
                .offset(x = 4.dp)
        ) {
            Box(
                modifier = Modifier
                    .shadow(elevation = 4.dp, shape = CircleShape)
                    .clip(CircleShape)
                    .background(MaterialTheme.colorScheme.background, CircleShape)
                    .padding(4.dp),
                contentAlignment = Alignment.Center,
            ) {
                Icon(
                    imageVector = Icons.Default.Edit,
                    contentDescription = "Profile photo picker"
                )
            }
        }
    }
}

@Preview(showBackground = true, showSystemUi = false)
@Composable
fun ProfilePhotoPickerPreview() {
    RarelyAppTheme {
        ProfilePhotoPicker()
    }
}