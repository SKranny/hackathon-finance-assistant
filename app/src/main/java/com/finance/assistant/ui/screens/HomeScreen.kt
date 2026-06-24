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
import com.finance.assistant.data.model.UpcomingEventData
import com.finance.assistant.ui.screens.viewmodel.HomeViewModel
import com.finance.assistant.ui.theme.DangerRed
import com.finance.assistant.ui.theme.DangerRedBorder
import com.finance.assistant.ui.theme.DangerRedSurface
import com.finance.assistant.ui.theme.DarkNearBlack
import com.finance.assistant.ui.theme.SuccessGreen
import com.finance.assistant.ui.theme.SurfaceGray
import com.finance.assistant.ui.theme.TextSecondary
import com.finance.assistant.ui.theme.WarnAmber
import java.text.NumberFormat
import java.util.Locale

@Composable
fun HomeScreen(
    viewModel: HomeViewModel = hiltViewModel(),
    onNavigateToCashGapDetail: () -> Unit = {},
) {
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(SurfaceGray)
            .verticalScroll(rememberScrollState()),
    ) {
        val shortfall = uiState.shortfallAmount
        DashboardHeader(
            userName = uiState.userName,
            avatarInitial = uiState.avatarInitial,
            availableBalance = formatMoney(uiState.freeBalance, uiState.currency),
            balanceDeltaLabel = if (shortfall != null) {
                "−${formatMoney(shortfall, uiState.currency)} к ${uiState.shortfallDate}"
            } else null,
        )

        Column(
            modifier = Modifier.padding(18.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp),
        ) {
            if (uiState.cashGapVisible) {
                CashGapAlertCard(
                    title = uiState.cashGapTitle,
                    body = uiState.cashGapBody,
                    onActionClick = onNavigateToCashGapDetail,
                )
            }

            UpcomingEventsSection(
                events = uiState.upcomingEvents,
                currency = uiState.currency,
                onForecastClick = { viewModel.onForecastClick() },
            )
        }
    }
}

private fun formatMoney(amount: Double, currency: String): String {
    val formatter = NumberFormat.getNumberInstance(Locale("ru"))
    formatter.minimumFractionDigits = 0
    formatter.maximumFractionDigits = 0
    return "${formatter.format(amount)} $currency"
}

@Composable
private fun DashboardHeader(
    userName: String,
    avatarInitial: String,
    availableBalance: String,
    balanceDeltaLabel: String?,
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

            AvatarBadge(initial = avatarInitial)
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

            if (balanceDeltaLabel != null) {
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

@Composable
private fun UpcomingEventsSection(
    events: List<UpcomingEventData>,
    currency: String,
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
                EventRow(event = event, currency = currency)
            }
        }
    }
}

@Composable
private fun EventRow(event: UpcomingEventData, currency: String) {
    val dotColor = when (event.colorType) {
        "danger" -> DangerRed
        "success" -> SuccessGreen
        else -> WarnAmber
    }

    val labelColor = dotColor
    val amountColor = if (event.amount > 0) SuccessGreen else DarkNearBlack
    val borderModifier = if (event.isDangerBorder) {
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
                .background(dotColor),
        )

        Column(
            modifier = Modifier.weight(1f),
            verticalArrangement = Arrangement.spacedBy(1.dp),
        ) {
            Text(
                text = "${event.date} · ${event.source}",
                fontSize = 12.sp,
                fontWeight = FontWeight.Bold,
                color = labelColor,
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
            text = formatAmountWithSign(event.amount, currency),
            fontSize = 16.sp,
            fontWeight = FontWeight.ExtraBold,
            color = amountColor,
            lineHeight = (16 * 1.35).sp,
        )
    }
}

private fun formatAmountWithSign(amount: Double, currency: String): String {
    val formatter = NumberFormat.getNumberInstance(Locale("ru"))
    formatter.minimumFractionDigits = 0
    formatter.maximumFractionDigits = 0
    val sign = if (amount > 0) "+" else ""
    return "$sign${formatter.format(amount)} $currency"
}
