package com.example.mybank.screen

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController

@Composable
fun NotificationScreen(navController : NavHostController) {
    Text(
        text = "Notifications",
        fontSize = 28.sp,
        color = Color.White
    )
}