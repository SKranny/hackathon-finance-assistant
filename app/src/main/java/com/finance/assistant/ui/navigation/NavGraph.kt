package com.finance.assistant.ui.navigation

import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBalance
import androidx.compose.material.icons.filled.Analytics
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import com.finance.assistant.ui.screens.AnalyticsScreen
import com.finance.assistant.ui.screens.HomeScreen
import com.finance.assistant.ui.screens.SettingsScreen
import com.finance.assistant.ui.screens.TransactionsScreen

data class BottomNavItem(
    val label: String,
    val icon: ImageVector,
    val screen: Screen,
)

private val bottomNavItems = listOf(
    BottomNavItem("Главная", Icons.Default.Home, Screen.Home),
    BottomNavItem("Транзакции", Icons.Default.AccountBalance, Screen.Transactions),
    BottomNavItem("Аналитика", Icons.Default.Analytics, Screen.Analytics),
    BottomNavItem("Настройки", Icons.Default.Settings, Screen.Settings),
)

@Composable
fun NavGraph(navController: NavHostController) {
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route

    Scaffold(
        bottomBar = {
            NavigationBar {
                bottomNavItems.forEach { item ->
                    NavigationBarItem(
                        selected = currentRoute == item.screen.route,
                        onClick = {
                            if (currentRoute != item.screen.route) {
                                navController.navigate(item.screen.route) {
                                    popUpTo(Screen.Home.route) { saveState = true }
                                    launchSingleTop = true
                                    restoreState = true
                                }
                            }
                        },
                        icon = { Icon(item.icon, contentDescription = item.label) },
                        label = { Text(item.label) },
                    )
                }
            }
        },
    ) { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = Screen.Home.route,
            modifier = Modifier.padding(innerPadding),
        ) {
            composable(Screen.Home.route) { HomeScreen() }
            composable(Screen.Transactions.route) { TransactionsScreen() }
            composable(Screen.Analytics.route) { AnalyticsScreen() }
            composable(Screen.Settings.route) { SettingsScreen() }
        }
    }
}
