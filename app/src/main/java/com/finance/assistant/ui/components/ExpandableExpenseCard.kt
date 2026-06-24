package com.finance.assistant.ui.components

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ExpandMore
import androidx.compose.material.icons.filled.Savings
import androidx.compose.material.icons.filled.Warning
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.finance.assistant.domain.model.alert.CaseResolution
import com.finance.assistant.domain.model.alert.RiskLevel
import com.finance.assistant.domain.model.alert.SavingsRecommendation
import com.finance.assistant.domain.model.alert.ScheduledExpenseCase
import java.time.format.DateTimeFormatter

@Composable
fun ExpandableExpenseCard(
    expense: ScheduledExpenseCase,
    modifier: Modifier = Modifier,
    onResolveCase: (CaseResolution) -> Unit = {},
    onStartSavingsPlan: (SavingsRecommendation, Double) -> Unit = { _, _ -> },
) {
    var isExpanded by remember { mutableStateOf(false) }
    val rotationAngle by animateFloatAsState(
        targetValue = if (isExpanded) 180f else 0f,
        label = "rotation",
    )

    val containerColor = MaterialTheme.colorScheme.secondaryContainer

    Card(
        modifier = modifier
            .fillMaxWidth()
            .clickable { isExpanded = !isExpanded },
        colors = CardDefaults.cardColors(containerColor = containerColor),
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.weight(1f),
                ) {
                    Icon(
                        imageVector = if (expense.savingsRecommendation != null) Icons.Default.Savings else Icons.Default.Warning,
                        contentDescription = null,
                        modifier = Modifier.size(24.dp),
                        tint = MaterialTheme.colorScheme.onSurfaceVariant,
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Column {
                        Text(
                            text = expense.title,
                            style = MaterialTheme.typography.titleMedium,
                            fontWeight = FontWeight.Bold,
                        )
                        Text(
                            text = expense.category,
                            style = MaterialTheme.typography.bodySmall,
                            color = MaterialTheme.colorScheme.onSurfaceVariant,
                        )
                    }
                }
                Column(horizontalAlignment = Alignment.End) {
                    Text(
                        text = "%.2f ₽".format(expense.amount),
                        style = MaterialTheme.typography.titleMedium,
                        fontWeight = FontWeight.Bold,
                    )
                    Icon(
                        imageVector = Icons.Default.ExpandMore,
                        contentDescription = if (isExpanded) "Свернуть" else "Развернуть",
                        modifier = Modifier
                            .size(20.dp)
                            .rotate(rotationAngle),
                    )
                }
            }

            AnimatedVisibility(visible = isExpanded) {
                Column {
                    Spacer(modifier = Modifier.height(16.dp))
                    HorizontalDivider()
                    Spacer(modifier = Modifier.height(16.dp))

                    ScheduledExpenseDetails(
                        expense = expense,
                        onResolve = onResolveCase,
                        onStartSavingsPlan = onStartSavingsPlan,
                    )
                }
            }
        }
    }
}

@Composable
private fun ScheduledExpenseDetails(
    expense: ScheduledExpenseCase,
    onResolve: (CaseResolution) -> Unit,
    onStartSavingsPlan: (SavingsRecommendation, Double) -> Unit,
) {
    Column {
        Text(
            text = "Детали:",
            style = MaterialTheme.typography.titleSmall,
            fontWeight = FontWeight.Bold,
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = "Дата: ${expense.dueDate.format(DateTimeFormatter.ofPattern("dd MMM yyyy"))}",
            style = MaterialTheme.typography.bodyMedium,
        )
        Text(
            text = "Категория: ${expense.category}",
            style = MaterialTheme.typography.bodyMedium,
        )
        if (expense.isRecurring) {
            Text(
                text = "Повторяющееся",
                style = MaterialTheme.typography.bodyMedium,
            )
        }

        expense.savingsRecommendation?.let { recommendation ->
            Spacer(modifier = Modifier.height(16.dp))
            SavingsRecommendationSection(
                recommendation = recommendation,
                targetAmount = expense.amount,
                onStartPlan = { onStartSavingsPlan(recommendation, expense.amount) },
            )
        }

        if (expense.suggestedResolutions.isNotEmpty()) {
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = "Варианты решения:",
                style = MaterialTheme.typography.titleSmall,
                fontWeight = FontWeight.Bold,
            )
            Spacer(modifier = Modifier.height(8.dp))
            expense.suggestedResolutions.forEach { resolution ->
                ResolutionButton(
                    title = resolution.title,
                    description = resolution.description,
                    onClick = { onResolve(resolution) },
                )
            }
        }
    }
}

@Composable
private fun ResolutionButton(
    title: String,
    description: String,
    onClick: () -> Unit,
) {
    OutlinedButton(
        onClick = onClick,
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 4.dp),
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 4.dp),
            horizontalAlignment = Alignment.Start,
        ) {
            Text(
                text = title,
                style = MaterialTheme.typography.bodyMedium,
                fontWeight = FontWeight.Medium,
            )
            Text(
                text = description,
                style = MaterialTheme.typography.bodySmall,
                color = MaterialTheme.colorScheme.onSurfaceVariant,
            )
        }
    }
}

@Composable
private fun SavingsRecommendationSection(
    recommendation: SavingsRecommendation,
    targetAmount: Double,
    onStartPlan: () -> Unit,
) {
    val riskColor = when (recommendation.riskLevel) {
        RiskLevel.LOW -> MaterialTheme.colorScheme.primary
        RiskLevel.MEDIUM -> MaterialTheme.colorScheme.tertiary
        RiskLevel.HIGH -> MaterialTheme.colorScheme.error
    }

    Card(
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.primaryContainer,
        ),
        modifier = Modifier.fillMaxWidth(),
    ) {
        Column(modifier = Modifier.padding(12.dp)) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Text(
                    text = "💰 План накоплений",
                    style = MaterialTheme.typography.titleSmall,
                    fontWeight = FontWeight.Bold,
                )
                Spacer(modifier = Modifier.width(8.dp))
                Text(
                    text = when (recommendation.riskLevel) {
                        RiskLevel.LOW -> "🟢 Низкий риск"
                        RiskLevel.MEDIUM -> "🟡 Средний риск"
                        RiskLevel.HIGH -> "🔴 Высокий риск"
                    },
                    style = MaterialTheme.typography.labelSmall,
                    color = riskColor,
                )
            }
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = recommendation.recommendationText,
                style = MaterialTheme.typography.bodySmall,
            )
            Spacer(modifier = Modifier.height(8.dp))
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
            ) {
                Column {
                    Text(
                        text = "В день:",
                        style = MaterialTheme.typography.labelSmall,
                    )
                    Text(
                        text = "%.0f ₽".format(recommendation.suggestedDailyAmount),
                        style = MaterialTheme.typography.titleMedium,
                        fontWeight = FontWeight.Bold,
                    )
                }
                Column {
                    Text(
                        text = "В неделю:",
                        style = MaterialTheme.typography.labelSmall,
                    )
                    Text(
                        text = "%.0f ₽".format(recommendation.suggestedWeeklyAmount),
                        style = MaterialTheme.typography.titleMedium,
                        fontWeight = FontWeight.Bold,
                    )
                }
                Column {
                    Text(
                        text = "В месяц:",
                        style = MaterialTheme.typography.labelSmall,
                    )
                    Text(
                        text = "%.0f ₽".format(recommendation.suggestedMonthlyAmount),
                        style = MaterialTheme.typography.titleMedium,
                        fontWeight = FontWeight.Bold,
                    )
                }
            }
            Spacer(modifier = Modifier.height(12.dp))
            Button(
                onClick = onStartPlan,
                modifier = Modifier.fillMaxWidth(),
            ) {
                Text("Запустить план накоплений")
            }
        }
    }
}
