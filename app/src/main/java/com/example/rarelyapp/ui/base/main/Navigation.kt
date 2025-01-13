package com.example.rarelyapp.ui.base.main

import AuctionViewModel
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Person
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.rarelyapp.ui.auction.AuctionDetailScreen
import com.example.rarelyapp.ui.base.main.payment.CheckoutScreen
import com.example.rarelyapp.ui.base.main.payment.MyOrderScreen
import com.example.rarelyapp.ui.base.main.payment.PaymentMethodsContent
import com.example.rarelyapp.ui.base.main.payment.PaymentSuccessfulScreen
import com.example.rarelyapp.ui.base.main.payment.TrackOrderScreen
import com.example.rarelyapp.ui.base.main.payment.add_card.AddCardScreen
import com.example.rarelyapp.ui.base.main.payment.add_card.AddCardScreenUiState
import com.example.rarelyapp.ui.categories.ArtScreen
import com.example.rarelyapp.ui.categories.CollaborationsScreen
import com.example.rarelyapp.ui.categories.FashionScreen
import com.example.rarelyapp.ui.categories.GreenCollectionScreen

@Composable
fun MainNavigation() {
    val navController = rememberNavController()

    // AuctionViewModel'i burada tanımlayın
    val auctionViewModel = remember { AuctionViewModel() }

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
                CategoriesScreen(navController)
            }
            composable("favorites") {
                FavoritesScreen()
            }
            composable("myBag") {
                MyBagScreen()
            }
            composable("profile") {
                // ProfileScreen()
            }

            composable(route = "my_orders") {
                MyOrderScreen(navController)
            }

            // Track Order Screen
            composable(route = "track_order") {
                TrackOrderScreen()
            }

            // Payment Method Screen
            composable(route = "payment_method") {
                PaymentMethodsContent(navController)
            }

            // Payment Successful Screen
            composable(route = "payment_successful") {
                PaymentSuccessfulScreen(navController)
            }

            // Add Card Screen
            composable(route = "add_card") {
                AddCardScreen(
                    uiState = AddCardScreenUiState(),
                    onAddCardClicked = { /* Add Card Action */ },
                    onAction = { /* Handle Actions */ }
                )
            }
            composable(route = "CheckoutScreen") {
                CheckoutScreen(navController)
            }

            composable("art_screen") {
                ArtScreen(navController)
            }
            composable("fashion_screen") {
                FashionScreen(navController)
            }
            composable("collabs_screen") {
                CollaborationsScreen(navController)
            }
            composable("auction_screen") {
                AuctionDetailScreen(navController = navController, auctionViewModel = auctionViewModel)
            }
            composable("green_collection_screen") {
                GreenCollectionScreen(navController)
            }
        }
    }
}


@Preview(showBackground = true, showSystemUi = true)
@Composable
fun PreviewMainScreen() {
    MainNavigation()
}