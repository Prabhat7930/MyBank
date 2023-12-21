package com.example.mybank

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.height
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.mybank.data.BottomNavItems

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

@Preview
@Composable
fun BottomNavBar() {
    NavigationBar(
        modifier = Modifier
            .background(MaterialTheme.colorScheme.inverseSurface)
    ) {
        navItems.forEachIndexed { index, item ->
            NavigationBarItem(
                selected = index == 0,
                onClick = { /*todo*/ },
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
