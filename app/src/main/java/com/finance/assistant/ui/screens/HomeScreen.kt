package com.finance.assistant.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
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
import com.finance.assistant.ui.screens.viewmodel.HomeViewModel
import com.finance.assistant.ui.theme.DangerRed
import com.finance.assistant.ui.theme.DangerRedBorder
import com.finance.assistant.ui.theme.DangerRedSurface
import com.finance.assistant.ui.theme.DarkNearBlack
import com.finance.assistant.ui.theme.SuccessGreen
import com.finance.assistant.ui.theme.SurfaceGray
import com.finance.assistant.ui.theme.TextSecondary
import com.finance.assistant.ui.theme.WarnAmber

@Composable
fun HomeScreen(
    viewModel: HomeViewModel = hiltViewModel(),
) {
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(SurfaceGray)
            .verticalScroll(rememberScrollState()),
    ) {
        DashboardHeader(
            userName = "Артём",
            availableBalance = "103 200 ₽",
            balanceDeltaLabel = "−40 000 ₽ к 9 июня",
        )

        Column(
            modifier = Modifier.padding(18.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp),
        ) {
            CashGapAlertCard(
                title = "Кассовый разрыв через 6 дней",
                body = "3–5 июня спишется 112 000 ₽. Не хватит ≈40 000 ₽ до зарплаты.",
                onActionClick = { viewModel.onCashGapActionClick() },
            )

            UpcomingEventsSection(
                events = listOf(
                    UpcomingEvent(
                        dotColor = WarnAmber,
                        dateLabel = "3 июня · Календарь",
                        dateLabelColor = WarnAmber,
                        title = "Оплата садика",
                        amount = "−27 000 ₽",
                        amountColor = DarkNearBlack,
                        hasDangerBorder = false,
                    ),
                    UpcomingEvent(
                        dotColor = DangerRed,
                        dateLabel = "5 июня · Почта",
                        dateLabelColor = DangerRed,
                        title = "Ипотека",
                        amount = "−85 000 ₽",
                        amountColor = DangerRed,
                        hasDangerBorder = true,
                    ),
                    UpcomingEvent(
                        dotColor = SuccessGreen,
                        dateLabel = "10 июня · Зарплата",
                        dateLabelColor = SuccessGreen,
                        title = "Поступление",
                        amount = "+180 000 ₽",
                        amountColor = SuccessGreen,
                        hasDangerBorder = false,
                    ),
                ),
                onForecastClick = { viewModel.onForecastClick() },
            )
        }
    }
}

@Composable
private fun DashboardHeader(
    userName: String,
    availableBalance: String,
    balanceDeltaLabel: String,
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.White)
            .padding(start = 22.dp, end = 22.dp, top = 6.dp, bottom = 20.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp),
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Column(verticalArrangement = Arrangement.spacedBy(2.dp)) {
                Text(
                    text = "Привет, $userName 👋",
                    fontSize = 14.sp,
                    fontWeight = FontWeight.SemiBold,
                    color = TextSecondary,
                    lineHeight = (14 * 1.35).sp,
                )
                Text(
                    text = "Свободно до зарплаты",
                    fontSize = 22.sp,
                    fontWeight = FontWeight.ExtraBold,
                    color = DarkNearBlack,
                    letterSpacing = (-0.44).sp,
                    lineHeight = (22 * 1.35).sp,
                )
            }

            AvatarBadge(initial = "А")
        }

        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(10.dp),
        ) {
            Text(
                text = availableBalance,
                fontSize = 38.sp,
                fontWeight = FontWeight.ExtraBold,
                color = DarkNearBlack,
                letterSpacing = (-0.76).sp,
                lineHeight = (38 * 1.35).sp,
            )

            Box(
                modifier = Modifier
                    .clip(RoundedCornerShape(99.dp))
                    .background(DangerRedSurface)
                    .padding(horizontal = 9.dp, vertical = 4.dp),
            ) {
                Text(
                    text = balanceDeltaLabel,
                    fontSize = 13.sp,
                    fontWeight = FontWeight.Bold,
                    color = DangerRed,
                    lineHeight = (13 * 1.35).sp,
                )
            }
        }
    }
}

@Composable
fun AvatarBadge(initial: String) {
    Box(
        modifier = Modifier
            .size(42.dp)
            .clip(CircleShape)
            .background(DarkNearBlack),
        contentAlignment = Alignment.Center,
    ) {
        Text(
            text = initial,
            fontSize = 15.sp,
            fontWeight = FontWeight.Bold,
            color = Color.White,
            lineHeight = (15 * 1.35).sp,
        )
    }
}

@Composable
private fun CashGapAlertCard(
    title: String,
    body: String,
    onActionClick: () -> Unit,
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(22.dp))
            .border(1.dp, DangerRedBorder, RoundedCornerShape(22.dp))
            .background(Color.White)
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(9.dp),
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(8.dp),
        ) {
            Box(
                modifier = Modifier
                    .size(9.dp)
                    .clip(CircleShape)
                    .background(DangerRed),
            )
            Text(
                text = title,
                fontSize = 13.sp,
                fontWeight = FontWeight.Bold,
                color = DangerRed,
                lineHeight = (13 * 1.35).sp,
            )
        }

        Text(
            text = body,
            fontSize = 15.sp,
            fontWeight = FontWeight.SemiBold,
            color = DarkNearBlack,
            lineHeight = (15 * 1.45).sp,
            modifier = Modifier.fillMaxWidth(),
        )

        Button(
            onClick = onActionClick,
            modifier = Modifier
                .fillMaxWidth()
                .height(44.dp),
            shape = RoundedCornerShape(13.dp),
            colors = ButtonDefaults.buttonColors(containerColor = DangerRed),
        ) {
            Text(
                text = "Разобраться  →",
                fontSize = 15.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White,
                lineHeight = (15 * 1.35).sp,
            )
        }
    }
}

private data class UpcomingEvent(
    val dotColor: Color,
    val dateLabel: String,
    val dateLabelColor: Color,
    val title: String,
    val amount: String,
    val amountColor: Color,
    val hasDangerBorder: Boolean,
)

@Composable
private fun UpcomingEventsSection(
    events: List<UpcomingEvent>,
    onForecastClick: () -> Unit,
) {
    Column(verticalArrangement = Arrangement.spacedBy(0.dp)) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 4.dp, vertical = 10.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Text(
                text = "Что тебя ждёт",
                fontSize = 17.sp,
                fontWeight = FontWeight.ExtraBold,
                color = DarkNearBlack,
                lineHeight = (17 * 1.35).sp,
            )
            Text(
                text = "Прогноз →",
                fontSize = 13.sp,
                fontWeight = FontWeight.Bold,
                color = DangerRed,
                lineHeight = (13 * 1.35).sp,
            )
        }

        Column(verticalArrangement = Arrangement.spacedBy(0.dp)) {
            events.forEach { event ->
                EventRow(event = event)
            }
        }
    }
}

@Composable
private fun EventRow(event: UpcomingEvent) {
    val borderModifier = if (event.hasDangerBorder) {
        Modifier.border(1.dp, DangerRedBorder, RoundedCornerShape(16.dp))
    } else {
        Modifier
    }

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(16.dp))
            .then(borderModifier)
            .background(Color.White)
            .padding(horizontal = 14.dp, vertical = 13.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(12.dp),
    ) {
        Box(
            modifier = Modifier
                .size(8.dp)
                .clip(CircleShape)
                .background(event.dotColor),
        )

        Column(
            modifier = Modifier.weight(1f),
            verticalArrangement = Arrangement.spacedBy(1.dp),
        ) {
            Text(
                text = event.dateLabel,
                fontSize = 12.sp,
                fontWeight = FontWeight.Bold,
                color = event.dateLabelColor,
                lineHeight = (12 * 1.35).sp,
            )
            Text(
                text = event.title,
                fontSize = 15.sp,
                fontWeight = FontWeight.Bold,
                color = DarkNearBlack,
                lineHeight = (15 * 1.35).sp,
            )
        }

        Text(
            text = event.amount,
            fontSize = 16.sp,
            fontWeight = FontWeight.ExtraBold,
            color = event.amountColor,
            lineHeight = (16 * 1.35).sp,
        )
    }
}
