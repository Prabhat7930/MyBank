package com.example.mybank.screen

import androidx.compose.foundation.layout.*
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
fun HomeScreen(navController : NavHostController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(1.dp),
    ) {
        WalletSection(navController)
        CardSection()
        Spacer(modifier = Modifier.height(16.dp))
        FinanceSection()
        CurrencySection()
    }
}