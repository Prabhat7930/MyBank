package com.example.mybank.screen

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SearchBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.mybank.*
import com.example.mybank.utils.Screen

@Composable
fun MainScreen(navController : NavHostController) {
    val bottomNavController = rememberNavController()
    Scaffold(
        bottomBar = {
            BottomNavBar(bottomNavController = bottomNavController)
        }
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(it)
        ) {
            NavHost(
                navController = bottomNavController,
                startDestination = Screen.Home.rout
            ) {
                composable(Screen.Home.rout) {
                    HomeScreen(navController = navController)
                }
                composable(Screen.Wallet.rout) {
                    WalletScreen(navController = navController)
                }
                composable(Screen.Notifications.rout) {
                    NotificationScreen(navController = navController)
                }
                composable(Screen.Account.rout) {
                    AccountScreen(navController = navController)
                }
            }
        }
    }
}