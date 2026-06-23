package com.finance.assistant.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
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
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.finance.assistant.domain.model.Transaction
import com.finance.assistant.ui.screens.viewmodel.TransactionsViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TransactionsScreen(
    viewModel: TransactionsViewModel = hiltViewModel(),
) {
    val transactions by viewModel.transactions.collectAsStateWithLifecycle()

    Column(modifier = Modifier.fillMaxSize()) {
        TopAppBar(title = { Text("Транзакции") })

        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 16.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp),
        ) {
            items(transactions) { transaction ->
                TransactionCard(transaction = transaction)
            }
        }
    }
}

@Composable
private fun TransactionCard(transaction: Transaction) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surface,
        ),
    ) {
        Column(modifier = Modifier.padding(12.dp)) {
            Text(
                text = transaction.title,
                style = MaterialTheme.typography.titleMedium,
            )
            Text(
                text = "%.2f ₽".format(transaction.amount),
                style = MaterialTheme.typography.titleLarge,
                color = if (transaction.amount > 0) MaterialTheme.colorScheme.error
                        else MaterialTheme.colorScheme.primary,
            )
            Text(
                text = "${transaction.category.name} · ${transaction.date}",
                style = MaterialTheme.typography.bodySmall,
            )
        }
    }
}
