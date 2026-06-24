package com.finance.assistant.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.finance.assistant.ui.theme.DangerRed
import com.finance.assistant.ui.theme.DangerRedBorder
import com.finance.assistant.ui.theme.DangerRedSurface
import com.finance.assistant.ui.theme.DarkNearBlack
import com.finance.assistant.ui.theme.InsightBlue
import com.finance.assistant.ui.theme.InsightBlueBorder
import com.finance.assistant.ui.theme.InsightBlueSurface
import com.finance.assistant.ui.theme.SurfaceGray
import com.finance.assistant.ui.theme.TextSecondary
import com.finance.assistant.ui.theme.WarnAmber
import com.finance.assistant.ui.theme.WarnAmberBorder
import com.finance.assistant.ui.theme.WarnAmberSurface

@Composable
fun FeedScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(SurfaceGray),
    ) {
        FeedHeader()
        InsightCardList(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState()),
        )
    }
}

@Composable
private fun FeedHeader() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.White)
            .padding(start = 22.dp, end = 22.dp, top = 2.dp, bottom = 14.dp),
        verticalArrangement = Arrangement.spacedBy(2.dp),
    ) {
        Text(
            text = "Лента",
            fontSize = 24.sp,
            fontWeight = FontWeight.ExtraBold,
            color = DarkNearBlack,
            letterSpacing = (-0.48).sp,
            lineHeight = (24 * 1.35).sp,
        )
        Text(
            text = "5 инсайтов от помощника",
            fontSize = 13.sp,
            fontWeight = FontWeight.SemiBold,
            color = TextSecondary,
            lineHeight = (13 * 1.35).sp,
        )
    }
}

@Composable
private fun InsightCardList(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .background(Color.White)
            .padding(start = 18.dp, end = 18.dp, top = 16.dp, bottom = 8.dp),
        verticalArrangement = Arrangement.spacedBy(13.dp),
    ) {
        InsightCard(
            label = "Кейс 1 · Срочно · через 6 дней",
            labelColor = DangerRed,
            iconBackground = DangerRedSurface,
            borderColor = DangerRedBorder,
            title = "Кассовый разрыв до зарплаты",
            description = "3–5 июня уйдёт 112 000 ₽, не хватит ≈40 000 ₽.",
        )
        InsightCard(
            label = "Кейс 2 · Подписки-зомби",
            labelColor = WarnAmber,
            iconBackground = WarnAmberSurface,
            borderColor = WarnAmberBorder,
            title = "4 подписки на 3 200 ₽/мес",
            description = "Двумя ты не пользуешься с марта. 38 400 ₽ в год.",
        )
        InsightCard(
            label = "Кейс 3 · Крупная покупка · 28 июня",
            labelColor = InsightBlue,
            iconBackground = InsightBlueSurface,
            borderColor = InsightBlueBorder,
            title = "ТО машины — 60 000 ₽",
            description = "Предлагаю отложить 15 000 ₽ × 4 недели.",
        )
        InsightCard(
            label = "Кейс 4 · Поездка · 24–26 июня",
            labelColor = InsightBlue,
            iconBackground = InsightBlueSurface,
            borderColor = InsightBlueBorder,
            title = "Алматы → Астана",
            description = "Прошлые поездки: ~25 000 ₽ сверх обычного.",
        )
        InsightCard(
            label = "Кейс 5 · Дедлайн · через 5 дней",
            labelColor = WarnAmber,
            iconBackground = WarnAmberSurface,
            borderColor = WarnAmberBorder,
            title = "Налог 45 000 ₽",
            description = "На счёте 30 000 ₽. Не хватает 15 000 ₽.",
        )
    }
}

@Composable
private fun InsightCard(
    label: String,
    labelColor: Color,
    iconBackground: Color,
    borderColor: Color,
    title: String,
    description: String,
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(20.dp))
            .border(1.dp, borderColor, RoundedCornerShape(20.dp))
            .background(Color.White)
            .padding(15.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp),
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(9.dp),
        ) {
            Box(
                modifier = Modifier
                    .size(30.dp)
                    .clip(RoundedCornerShape(9.dp))
                    .background(iconBackground),
            )
            Text(
                text = label,
                fontSize = 12.sp,
                fontWeight = FontWeight.Bold,
                color = labelColor,
                lineHeight = (12 * 1.35).sp,
            )
        }
        Text(
            text = title,
            fontSize = 16.sp,
            fontWeight = FontWeight.ExtraBold,
            color = DarkNearBlack,
            lineHeight = (16 * 1.35).sp,
            modifier = Modifier.fillMaxWidth(),
        )
        Text(
            text = description,
            fontSize = 13.sp,
            fontWeight = FontWeight.Normal,
            color = TextSecondary,
            lineHeight = (13 * 1.45).sp,
            modifier = Modifier.fillMaxWidth(),
        )
    }
}
