package com.example.rarelyapp.ui.base.main

import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Person
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.rarelyapp.ui.profile.ProfileScreen
import com.example.rarelyapp.ui.profile.ProfileScreenAction
import com.example.rarelyapp.ui.profile.ProfileScreenViewModel

@Composable
fun MainNavigation() {
    val navController = rememberNavController()
    Scaffold(
        bottomBar = {
            BottomAppBar {
                NavigationBar {
                    NavigationBarItem(
                        selected = false,
                        onClick = { navController.navigate("home") },
                        icon = { Icon(Icons.Default.Home, contentDescription = "home") },
                        label = { }
                    )
                    NavigationBarItem(
                        selected = false,
                        onClick = { navController.navigate("categories") },
                        icon = { Icon(Icons.Default.Menu, contentDescription = "Categories") },
                        label = {  }
                    )
                    NavigationBarItem(
                        selected = false,
                        onClick = { navController.navigate("favorites") },
                        icon = { Icon(Icons.Default.FavoriteBorder, contentDescription = "Favorites") },
                        label = {  }
                    )
                    NavigationBarItem(
                        selected = false,
                        onClick = { navController.navigate("myBag") },
                        icon = { Icon(Icons.Default.ShoppingCart, contentDescription = "My Bag") },
                        label = {  }
                    )
                    NavigationBarItem(
                        selected = false,
                        onClick = { navController.navigate("profile") },
                        icon = { Icon(Icons.Default.Person, contentDescription = "Profile") },
                        label = {  }
                    )
                }
            }
        }
    ) { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = "home",
            modifier = Modifier.padding(innerPadding)
        ) {
            composable("home") {
                HomeScreen()
            }
            composable("categories") {
                CategoriesScreen()
            }
            composable("favorites") {
                FavoritesScreen()
            }
            composable("myBag") {
                MyBagScreen()
            }
            composable("profile") {

                val viewModel = ProfileScreenViewModel() // ViewModel'i burada oluşturuyoruz
                val uiState = ProfileScreenUiState() // Varsayılan uiState

                // onAction fonksiyonunu oluşturuyoruz
                val onAction: (ProfileScreenAction) -> Unit = { action ->
                    viewModel.onAction(action)
                }

                ProfileScreen(
                    uiState = uiState,
                    onAction = onAction,
                    viewModel = viewModel
                )
            }
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun PreviewMainScreen() {
    MainNavigation()
}