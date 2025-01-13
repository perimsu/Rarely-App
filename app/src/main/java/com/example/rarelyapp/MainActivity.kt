package com.example.rarelyapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier

import com.example.rarelyapp.ui.authentication.complete_account.CompleteProfileScreen
import com.example.rarelyapp.ui.authentication.complete_account.CompleteProfileScreenViewmodel
import com.example.rarelyapp.ui.base.main.MainNavigation


import com.example.rarelyapp.ui.theme.RarelyAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            RarelyAppTheme {
                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                    content = { paddingValues ->
                        Box(
                            modifier = Modifier
                                .fillMaxSize()
                                .padding(paddingValues)
                        ) {
                            FashionScreen()
                        }
                    }
                )

                MainNavigation()
            }
        }
    }
}

class FashionScreen {

}
