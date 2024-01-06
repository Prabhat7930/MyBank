package com.example.mybank

import androidx.compose.foundation.background
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import com.example.mybank.data.BottomNavItems
import com.example.mybank.utils.Screen

val navItems = listOf(
    BottomNavItems(
        title = "Home",
        icon = Icons.Rounded.Home
    ),

    BottomNavItems(
        title = "Wallet",
        icon = Icons.Rounded.Wallet
    ),

    BottomNavItems(
        title = "Notifications",
        icon = Icons.Rounded.Notifications
    ),

    BottomNavItems(
        title = "Account",
        icon = Icons.Rounded.AccountCircle
    )
)


@Composable
fun BottomNavBar(bottomNavController : NavHostController) {

    val selected = rememberSaveable{(mutableIntStateOf(0))}

    NavigationBar(
        modifier = Modifier
            .background(MaterialTheme.colorScheme.inverseSurface)
    ) {
        navItems.forEachIndexed { index, item ->
            NavigationBarItem(
                selected = selected.intValue == index,
                onClick = {
                    selected.intValue = index
                    when(selected.intValue) {
                        0 -> {
                            bottomNavController.navigate(Screen.Home.rout)
                        }
                        1 -> {
                            bottomNavController.navigate(Screen.Wallet.rout)
                        }
                        2 -> {
                            bottomNavController.navigate(Screen.Notifications.rout)
                        }
                        3 -> {
                            bottomNavController.navigate(Screen.Account.rout)
                        }
                    }
                },
                icon = {
                    Icon(
                        imageVector = item.icon,
                        contentDescription = item.title,
                        tint = MaterialTheme.colorScheme.onBackground
                    )
               },
                label = {
                    Text(
                        text = item.title,
                        color = MaterialTheme.colorScheme.onBackground
                    )
                }
            )

        }
    }

}
