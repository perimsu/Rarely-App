package com.example.rarelyapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.rarelyapp.ui.authentication.complete_account.CompleteProfileScreen
import com.example.rarelyapp.ui.authentication.complete_account.CompleteProfileScreenViewmodel
import com.example.rarelyapp.ui.theme.RarelyAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            RarelyAppTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    val completeProfileViewModel by viewModels<CompleteProfileScreenViewmodel>()
                    val uiState by completeProfileViewModel.uiState.collectAsStateWithLifecycle()
                    CompleteProfileScreen(
                        uiState = uiState,
                        onCompleteProfileSuccessful = { /*TODO*/ },
                        onAction = completeProfileViewModel::onAction
                    )
                }
            }
        }
    }
}

