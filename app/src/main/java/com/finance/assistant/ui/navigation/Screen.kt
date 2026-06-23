package com.finance.assistant.ui.navigation

sealed class Screen(val route: String) {
    data object Home : Screen("home")
    data object Transactions : Screen("transactions")
    data object Analytics : Screen("analytics")
    data object Settings : Screen("settings")
}
