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
import com.finance.assistant.data.model.InsightData
import com.finance.assistant.ui.screens.viewmodel.FeedViewModel
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
fun FeedScreen(
    viewModel: FeedViewModel = hiltViewModel(),
) {
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(SurfaceGray),
    ) {
        FeedHeader(
            title = uiState.header?.title ?: "",
            subtitle = "${uiState.insights.size} ${uiState.header?.subtitle ?: ""}"
        )
        InsightCardList(
            insights = uiState.insights,
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState()),
        )
    }
}

@Composable
private fun FeedHeader(
    title: String,
    subtitle: String,
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.White)
            .padding(start = 22.dp, end = 22.dp, top = 2.dp, bottom = 14.dp),
        verticalArrangement = Arrangement.spacedBy(2.dp),
    ) {
        Text(
            text = title,
            fontSize = 24.sp,
            fontWeight = FontWeight.ExtraBold,
            color = DarkNearBlack,
            letterSpacing = (-0.48).sp,
            lineHeight = (24 * 1.35).sp,
        )
        Text(
            text = subtitle,
            fontSize = 13.sp,
            fontWeight = FontWeight.SemiBold,
            color = TextSecondary,
            lineHeight = (13 * 1.35).sp,
        )
    }
}

@Composable
private fun InsightCardList(
    insights: List<InsightData>,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier
            .background(Color.White)
            .padding(start = 18.dp, end = 18.dp, top = 16.dp, bottom = 8.dp),
        verticalArrangement = Arrangement.spacedBy(13.dp),
    ) {
        insights.forEach { insight ->
            InsightCard(insight = insight)
        }
    }
}

@Composable
private fun InsightCard(insight: InsightData) {
    val colors = getInsightColors(insight.severity)

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(20.dp))
            .border(1.dp, colors.border, RoundedCornerShape(20.dp))
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
                    .background(colors.iconBackground),
            )
            Text(
                text = "Кейс ${insight.caseNumber} · ${insight.label}",
                fontSize = 12.sp,
                fontWeight = FontWeight.Bold,
                color = colors.label,
                lineHeight = (12 * 1.35).sp,
            )
        }
        Text(
            text = insight.title,
            fontSize = 16.sp,
            fontWeight = FontWeight.ExtraBold,
            color = DarkNearBlack,
            lineHeight = (16 * 1.35).sp,
            modifier = Modifier.fillMaxWidth(),
        )
        Text(
            text = insight.description,
            fontSize = 13.sp,
            fontWeight = FontWeight.Normal,
            color = TextSecondary,
            lineHeight = (13 * 1.45).sp,
            modifier = Modifier.fillMaxWidth(),
        )
    }
}

private data class InsightColors(
    val label: Color,
    val iconBackground: Color,
    val border: Color,
)

private fun getInsightColors(severity: String): InsightColors {
    return when (severity.uppercase()) {
        "CRITICAL" -> InsightColors(
            label = DangerRed,
            iconBackground = DangerRedSurface,
            border = DangerRedBorder,
        )
        "WARNING" -> InsightColors(
            label = WarnAmber,
            iconBackground = WarnAmberSurface,
            border = WarnAmberBorder,
        )
        else -> InsightColors(
            label = InsightBlue,
            iconBackground = InsightBlueSurface,
            border = InsightBlueBorder,
        )
    }
}
