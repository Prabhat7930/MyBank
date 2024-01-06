package com.example.mybank.utils

sealed class Screen(val rout : String) {
    data object Main : Screen("main")
    data object Home : Screen("home")
    data object Wallet : Screen("wallet")
    data object Notifications : Screen("notification")
    data object Account : Screen("account")
    data object Search : Screen("search")

}