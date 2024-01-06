package com.example.mybank

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.SystemBarStyle
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.toArgb
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.mybank.screen.MainScreen
import com.example.mybank.screen.SearchScreen
import com.example.mybank.ui.theme.MyBankTheme
import com.example.mybank.utils.Screen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyBankTheme {
                // A surface container using the 'background' color from the theme
                SetupBarColor(!isSystemInDarkTheme())
                Surface(
                    modifier = Modifier.fillMaxSize()
                ) {
                    val navController = rememberNavController()
                    val searchNavController = rememberNavController()

                    NavHost(
                        navController = navController,
                        startDestination = Screen.Main.rout
                    ) {
                        composable(Screen.Main.rout) {
                            MainScreen(navController = navController)
                        }

                        composable(Screen.Search.rout) {
                            SearchScreen(navController = navController)
                        }
                    }
                }
            }
        }


    }
    @Composable
    private fun SetupBarColor(lightThem : Boolean) {
        val barColor = MaterialTheme.colorScheme.background.toArgb()
        LaunchedEffect(lightThem) {
            if (lightThem) {
                enableEdgeToEdge(
                    statusBarStyle = SystemBarStyle.light(
                        barColor, barColor,
                    ),
                    navigationBarStyle = SystemBarStyle.light(
                        barColor, barColor
                    ),
                )
            }
            else {
                enableEdgeToEdge(
                    statusBarStyle = SystemBarStyle.dark(
                        barColor,
                    ),
                    navigationBarStyle = SystemBarStyle.dark(
                        barColor,
                    ),
                )
            }
        }

    }
}


