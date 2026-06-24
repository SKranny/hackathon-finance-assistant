package com.finance.assistant.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.finance.assistant.data.model.CashGapExpense
import com.finance.assistant.data.model.CashGapSuggestion
import com.finance.assistant.ui.screens.viewmodel.CashGapViewModel
import com.finance.assistant.ui.theme.DangerRed
import com.finance.assistant.ui.theme.DarkNearBlack
import com.finance.assistant.ui.theme.SurfaceGray

private val AlertSalmon = Color(0xFFFF8B7E)
private val ExpenseSubtitle = Color(0xFFA39D92)
private val DividerColor = Color(0xFFF2F2F4)

@Composable
fun CashGapDetailScreen(
    onBack: () -> Unit = {},
    onPrimaryAction: () -> Unit = {},
    viewModel: CashGapViewModel = hiltViewModel(),
) {
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()
    val data = uiState.data

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(SurfaceGray),
    ) {
        TopBar(
            title = data?.header?.title ?: "",
            onBack = onBack
        )

        Column(
            modifier = Modifier
                .weight(1f)
                .verticalScroll(rememberScrollState())
                .background(Color.White)
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(13.dp),
        ) {
            if (data != null) {
                AlertCard(
                    dateLabel = data.alertCard.dateLabel,
                    description = data.alertCard.description
                )
                ExpensesCard(expenses = data.expenses)
                Text(
                    text = data.suggestionsHeader,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.ExtraBold,
                    color = DarkNearBlack,
                )
                data.suggestions.forEach { suggestion ->
                    if (suggestion.isRecommended) {
                        RecommendedSuggestionCard(
                            title = suggestion.title,
                            description = suggestion.description,
                        )
                    } else {
                        SuggestionCard(
                            title = suggestion.title,
                            description = suggestion.description,
                        )
                    }
                }
            }
        }

        PrimaryActionButton(
            label = data?.primaryAction?.label ?: "",
            onClick = onPrimaryAction,
        )
    }
}

@Composable
private fun TopBar(title: String, onBack: () -> Unit) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.White)
            .padding(start = 18.dp, end = 22.dp, top = 2.dp, bottom = 14.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(12.dp),
    ) {
        Text(
            text = "←",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            color = DarkNearBlack,
            modifier = Modifier.clickable(onClick = onBack),
        )
        Text(
            text = title,
            fontSize = 20.sp,
            fontWeight = FontWeight.ExtraBold,
            color = DarkNearBlack,
            letterSpacing = (-0.4).sp,
        )
    }
}

@Composable
private fun AlertCard(dateLabel: String, description: String) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(22.dp))
            .background(DarkNearBlack)
            .padding(18.dp),
        verticalArrangement = Arrangement.spacedBy(10.dp),
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(8.dp),
        ) {
            Box(
                modifier = Modifier
                    .size(8.dp)
                    .clip(CircleShape)
                    .background(AlertSalmon),
            )
            Text(
                text = dateLabel,
                fontSize = 13.sp,
                fontWeight = FontWeight.Bold,
                color = AlertSalmon,
            )
        }
        Text(
            text = description,
            fontSize = 16.sp,
            fontWeight = FontWeight.SemiBold,
            color = Color.White,
            lineHeight = 23.sp,
        )
    }
}

@Composable
private fun ExpensesCard(expenses: List<CashGapExpense>) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(16.dp))
            .background(Color.White)
            .padding(horizontal = 14.dp, vertical = 6.dp),
    ) {
        expenses.forEachIndexed { index, expense ->
            ExpenseRow(
                title = expense.title,
                subtitle = expense.subtitle,
                amount = formatAmount(expense.amount),
                amountColor = if (expense.amountColor == "danger") DangerRed else DarkNearBlack,
            )
            if (index < expenses.size - 1) {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(1.dp)
                        .background(DividerColor),
                )
            }
        }
    }
}

private fun formatAmount(amount: Double): String {
    val sign = if (amount < 0) "" else "+"
    return "$sign${String.format("%,.0f", kotlin.math.abs(amount))} ₽"
}

@Composable
private fun ExpenseRow(
    title: String,
    subtitle: String,
    amount: String,
    amountColor: Color,
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 11.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Column(verticalArrangement = Arrangement.spacedBy(2.dp)) {
            Text(
                text = title,
                fontSize = 14.sp,
                fontWeight = FontWeight.Bold,
                color = DarkNearBlack,
            )
            Text(
                text = subtitle,
                fontSize = 11.sp,
                fontWeight = FontWeight.Normal,
                color = ExpenseSubtitle,
            )
        }
        Text(
            text = amount,
            fontSize = 15.sp,
            fontWeight = FontWeight.ExtraBold,
            color = amountColor,
        )
    }
}

@Composable
private fun RecommendedSuggestionCard(title: String, description: String) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(18.dp))
            .border(width = 2.dp, color = DangerRed, shape = RoundedCornerShape(18.dp))
            .background(Color.White)
            .padding(15.dp),
        verticalArrangement = Arrangement.spacedBy(5.dp),
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.Top,
        ) {
            Text(
                text = title,
                fontSize = 15.sp,
                fontWeight = FontWeight.ExtraBold,
                color = DarkNearBlack,
                modifier = Modifier.weight(1f),
            )
            Spacer(modifier = Modifier.width(8.dp))
            Box(
                modifier = Modifier
                    .clip(RoundedCornerShape(99.dp))
                    .background(DangerRed)
                    .padding(horizontal = 8.dp, vertical = 3.dp),
            ) {
                Text(
                    text = "СОВЕТ",
                    fontSize = 10.sp,
                    fontWeight = FontWeight.ExtraBold,
                    color = Color.White,
                )
            }
        }
        Text(
            text = description,
            fontSize = 13.sp,
            fontWeight = FontWeight.Normal,
            color = ExpenseSubtitle,
            lineHeight = 18.sp,
        )
    }
}

@Composable
private fun SuggestionCard(title: String, description: String) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(18.dp))
            .background(Color.White)
            .padding(15.dp),
        verticalArrangement = Arrangement.spacedBy(5.dp),
    ) {
        Text(
            text = title,
            fontSize = 15.sp,
            fontWeight = FontWeight.ExtraBold,
            color = DarkNearBlack,
        )
        Text(
            text = description,
            fontSize = 13.sp,
            fontWeight = FontWeight.Normal,
            color = ExpenseSubtitle,
            lineHeight = 18.sp,
        )
    }
}

@Composable
private fun PrimaryActionButton(label: String, onClick: () -> Unit) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.White)
            .padding(horizontal = 16.dp, vertical = 12.dp),
    ) {
        Button(
            onClick = onClick,
            modifier = Modifier
                .fillMaxWidth()
                .height(54.dp),
            shape = RoundedCornerShape(99.dp),
            colors = ButtonDefaults.buttonColors(containerColor = DangerRed),
        ) {
            Text(
                text = label,
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White,
            )
        }
    }
}
