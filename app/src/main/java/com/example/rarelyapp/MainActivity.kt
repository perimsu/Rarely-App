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
import com.example.rarelyapp.ui.authentication.register.RegisterScreen
import com.example.rarelyapp.ui.authentication.register.RegisterScreenViewmodel
import com.example.rarelyapp.ui.theme.RarelyAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            RarelyAppTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    val registerViewModel by viewModels<RegisterScreenViewmodel>()
                    val uiState by registerViewModel.uiState.collectAsStateWithLifecycle()
                    RegisterScreen(
                        uiState = uiState,
                        onRegisterSuccessfull = { },
                        onAction = registerViewModel::onAction
                    )
                }
            }
        }
    }
}

