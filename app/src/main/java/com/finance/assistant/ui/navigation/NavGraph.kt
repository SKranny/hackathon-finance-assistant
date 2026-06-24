package com.finance.assistant.ui.navigation

import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AutoAwesome
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.ShowChart
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
import com.finance.assistant.ui.screens.AssistantScreen
import com.finance.assistant.ui.screens.CashGapDetailScreen
import com.finance.assistant.ui.screens.FeedScreen
import com.finance.assistant.ui.screens.ForecastScreen
import com.finance.assistant.ui.screens.HomeScreen
import com.finance.assistant.ui.screens.PaymentConfirmationScreen
import com.finance.assistant.ui.screens.ReschedulePaymentScreen

object InitialTextHolder {
    var text: String = ""
}

data class BottomNavItem(
    val label: String,
    val icon: ImageVector,
    val screen: Screen,
)

private val bottomNavItems = listOf(
    BottomNavItem("Главная", Icons.Default.Home, Screen.Home),
    BottomNavItem("Лента", Icons.Default.Notifications, Screen.Feed),
    BottomNavItem("Помощник", Icons.Default.AutoAwesome, Screen.Assistant),
    BottomNavItem("Прогноз", Icons.Default.ShowChart, Screen.Forecast),
)

@Composable
fun NavGraph(navController: NavHostController) {
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route

    val bottomBarScreens = listOf(
        Screen.Home.route,
        Screen.Feed.route,
        Screen.Assistant.route,
        Screen.Forecast.route,
    )
    val showBottomBar = currentRoute in bottomBarScreens

    Scaffold(
        bottomBar = {
            if (showBottomBar) {
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
            }
        },
    ) { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = Screen.Home.route,
            modifier = Modifier.padding(innerPadding),
        ) {
            composable(Screen.Home.route) {
                HomeScreen(
                    onNavigateToCashGapDetail = {
                        navController.navigate(Screen.CashGapDetail.route)
                    },
                )
            }
            composable(Screen.Feed.route) { FeedScreen() }
            composable(Screen.Assistant.route) { backStackEntry ->
                val initialText = InitialTextHolder.text
                InitialTextHolder.text = ""
                AssistantScreen(initialInputText = initialText)
            }
            composable(Screen.Forecast.route) {
                ForecastScreen(
                    onNavigateToAssistant = {
                        InitialTextHolder.text = "Как закрыть разрыв"
                        navController.navigate(Screen.Assistant.route) {
                            popUpTo(Screen.Home.route) { saveState = true }
                            launchSingleTop = true
                            restoreState = true
                        }
                    },
                )
            }
            composable(Screen.CashGapDetail.route) {
                CashGapDetailScreen(
                    onBack = { navController.popBackStack() },
                    onPrimaryAction = {
                        navController.navigate(Screen.ReschedulePayment.route)
                    },
                )
            }
            composable(Screen.ReschedulePayment.route) {
                ReschedulePaymentScreen(
                    onBack = { navController.popBackStack() },
                    onConfirm = {
                        navController.navigate(Screen.PaymentConfirmation.route) {
                            popUpTo(Screen.Home.route)
                        }
                    },
                )
            }
            composable(Screen.PaymentConfirmation.route) {
                PaymentConfirmationScreen(
                    onGoHome = {
                        navController.navigate(Screen.Home.route) {
                            popUpTo(Screen.Home.route) { inclusive = true }
                        }
                    },
                    onGoToFeed = {
                        navController.navigate(Screen.Feed.route) {
                            popUpTo(Screen.Home.route) { saveState = true }
                            launchSingleTop = true
                            restoreState = true
                        }
                    },
                )
            }
        }
    }
}
