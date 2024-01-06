package com.example.mybank.screen

import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.mybank.*

@Composable
fun HomeScreen(navController : NavHostController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(1.dp),
    ) {
        WalletSection()
        CardSection()
        Spacer(modifier = Modifier.height(16.dp))
        FinanceSection()
        CurrencySection()
    }
}