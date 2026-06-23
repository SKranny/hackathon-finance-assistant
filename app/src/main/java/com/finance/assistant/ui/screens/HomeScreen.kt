package com.finance.assistant.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.finance.assistant.domain.model.FinancialInsight
import com.finance.assistant.domain.model.InsightSeverity
import com.finance.assistant.ui.screens.viewmodel.HomeViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    viewModel: HomeViewModel = hiltViewModel(),
) {
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()

    Column(modifier = Modifier.fillMaxSize()) {
        TopAppBar(title = { Text("Финансовый помощник") })

        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 16.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp),
        ) {
            item {
                Spacer(modifier = Modifier.height(8.dp))
                BalanceCard(
                    totalIncome = uiState.totalIncome,
                    totalExpenses = uiState.totalExpenses,
                )
            }

            item {
                Text(
                    text = "Уведомления",
                    style = MaterialTheme.typography.titleLarge,
                    modifier = Modifier.padding(top = 8.dp),
                )
            }

            items(uiState.insights) { insight ->
                InsightCard(insight = insight)
            }

            item { Spacer(modifier = Modifier.height(16.dp)) }
        }
    }
}

@Composable
private fun BalanceCard(totalIncome: Double, totalExpenses: Double) {
    val balance = totalIncome - totalExpenses

    Card(
        modifier = Modifier.fillMaxWidth(),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.primaryContainer,
        ),
    ) {
        Column(modifier = Modifier.padding(20.dp)) {
            Text(
                text = "Баланс",
                style = MaterialTheme.typography.titleMedium,
            )
            Text(
                text = "%.2f ₽".format(balance),
                style = MaterialTheme.typography.headlineLarge,
                fontWeight = FontWeight.Bold,
            )
            Spacer(modifier = Modifier.height(8.dp))
            Row(modifier = Modifier.fillMaxWidth()) {
                Column(modifier = Modifier.weight(1f)) {
                    Text(text = "Доходы", style = MaterialTheme.typography.bodySmall)
                    Text(
                        text = "%.2f ₽".format(totalIncome),
                        style = MaterialTheme.typography.titleMedium,
                        color = MaterialTheme.colorScheme.primary,
                    )
                }
                Column(modifier = Modifier.weight(1f)) {
                    Text(text = "Расходы", style = MaterialTheme.typography.bodySmall)
                    Text(
                        text = "%.2f ₽".format(totalExpenses),
                        style = MaterialTheme.typography.titleMedium,
                        color = MaterialTheme.colorScheme.error,
                    )
                }
            }
        }
    }
}

@Composable
private fun InsightCard(insight: FinancialInsight) {
    val containerColor = when (insight.severity) {
        InsightSeverity.CRITICAL -> MaterialTheme.colorScheme.errorContainer
        InsightSeverity.WARNING -> MaterialTheme.colorScheme.tertiaryContainer
        InsightSeverity.INFO -> MaterialTheme.colorScheme.surfaceVariant
    }

    Card(
        modifier = Modifier.fillMaxWidth(),
        colors = CardDefaults.cardColors(containerColor = containerColor),
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(
                text = insight.title,
                style = MaterialTheme.typography.titleMedium,
            )
            if (insight.description.isNotBlank()) {
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    text = insight.description,
                    style = MaterialTheme.typography.bodyMedium,
                )
            }
        }
    }
}
