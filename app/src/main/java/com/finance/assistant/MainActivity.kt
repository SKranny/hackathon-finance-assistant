package com.finance.assistant

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.navigation.compose.rememberNavController
import com.finance.assistant.ui.navigation.NavGraph
import com.finance.assistant.ui.theme.FinanceAssistantTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            FinanceAssistantTheme {
                val navController = rememberNavController()
                NavGraph(navController = navController)
            }
        }
    }
}
