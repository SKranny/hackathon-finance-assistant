package com.finance.assistant.ui.navigation

sealed class Screen(val route: String) {
    data object Home : Screen("home")
    data object Feed : Screen("feed")
    data object Assistant : Screen("assistant")
    data object Forecast : Screen("forecast")
}
