package com.finance.assistant.ui.screens

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.StrokeJoin
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.finance.assistant.ui.screens.viewmodel.ForecastViewModel
import com.finance.assistant.ui.theme.DangerRed
import com.finance.assistant.ui.theme.DangerRedBorder
import com.finance.assistant.ui.theme.DangerRedSurface
import com.finance.assistant.ui.theme.DarkNearBlack
import com.finance.assistant.ui.theme.SuccessGreen
import com.finance.assistant.ui.theme.SurfaceGray
import com.finance.assistant.ui.theme.TextSecondary

private const val CHART_DESIGN_WIDTH = 320f
private const val CHART_DESIGN_HEIGHT = 190f
private const val BASELINE_Y_DESIGN = 120f

@Composable
fun ForecastScreen(
    viewModel: ForecastViewModel = hiltViewModel(),
    onNavigateToAssistant: () -> Unit = {},
) {
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()
    val data = uiState.data

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(SurfaceGray)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.White)
                .padding(start = 22.dp, end = 22.dp, top = 2.dp, bottom = 14.dp)
        ) {
            Text(
                text = data?.header?.title ?: "Прогноз баланса",
                fontSize = 20.sp,
                fontWeight = FontWeight.ExtraBold,
                color = DarkNearBlack,
                letterSpacing = (-0.4).sp
            )
        }

        if (data != null) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color.White)
                    .padding(16.dp),
                verticalArrangement = Arrangement.spacedBy(14.dp)
            ) {
                ForecastChartCard(
                    title = data.chart.title,
                    minBalance = data.chart.minBalance,
                    xAxisLabels = data.chart.xAxisLabels,
                    gapLabel = data.chart.gapLabel,
                    salaryLabel = data.chart.salaryLabel,
                )
                ForecastAlertCard(
                    minBalanceLabel = data.alert.minBalanceLabel,
                    minBalanceValue = data.alert.minBalanceValue,
                    description = data.alert.description
                )
                CloseGapButton(
                    label = data.action.label,
                    onClick = onNavigateToAssistant,
                )
            }
        }
    }
}

@Composable
private fun ForecastChartCard(
    title: String,
    minBalance: String,
    xAxisLabels: List<String>,
    gapLabel: String,
    salaryLabel: String,
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.White, RoundedCornerShape(22.dp))
            .padding(start = 16.dp, end = 16.dp, top = 18.dp, bottom = 12.dp),
        verticalArrangement = Arrangement.spacedBy(6.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = title,
                fontSize = 13.sp,
                fontWeight = FontWeight.Bold,
                color = TextSecondary
            )
            MinBalanceBadge(text = minBalance)
        }

        BalanceForecastChart(
            modifier = Modifier
                .fillMaxWidth()
                .height(190.dp),
            gapLabel = gapLabel,
            salaryLabel = salaryLabel,
        )

        ChartXAxisLabels(labels = xAxisLabels)
    }
}

@Composable
private fun MinBalanceBadge(text: String) {
    Box(
        modifier = Modifier
            .background(DangerRedSurface, RoundedCornerShape(99.dp))
            .padding(horizontal = 9.dp, vertical = 4.dp)
    ) {
        Text(
            text = text,
            fontSize = 12.sp,
            fontWeight = FontWeight.Bold,
            color = DangerRed
        )
    }
}

@Composable
private fun BalanceForecastChart(
    modifier: Modifier = Modifier,
    gapLabel: String,
    salaryLabel: String,
) {
    BoxWithConstraints(modifier = modifier) {
        val chartWidth = maxWidth
        val chartHeight = maxHeight

        Canvas(modifier = Modifier.fillMaxSize()) {
            fun sx(designX: Float) = designX / CHART_DESIGN_WIDTH * size.width
            fun sy(designY: Float) = designY / CHART_DESIGN_HEIGHT * size.height

            drawLine(
                color = Color(0xFFE7E7EA),
                start = Offset(0f, sy(BASELINE_Y_DESIGN)),
                end = Offset(size.width, sy(BASELINE_Y_DESIGN)),
                strokeWidth = 2f
            )

            val lineStroke = Stroke(
                width = 3.dp.toPx(),
                cap = StrokeCap.Round,
                join = StrokeJoin.Round
            )

            val greenPath = Path().apply {
                moveTo(sx(0f), sy(70f))
                lineTo(sx(55f), sy(80f))
                lineTo(sx(92f), sy(90f))
                lineTo(sx(138f), sy(120f))
                lineTo(sx(161f), sy(150f))
                lineTo(sx(193f), sy(150f))
                lineTo(sx(217f), sy(120f))
                lineTo(sx(267f), sy(40f))
                lineTo(sx(313f), sy(36f))
            }
            drawPath(greenPath, SuccessGreen, style = lineStroke)

            val redPath = Path().apply {
                moveTo(sx(138f), sy(120f))
                lineTo(sx(161f), sy(150f))
                lineTo(sx(193f), sy(150f))
                lineTo(sx(217f), sy(120f))
            }
            drawPath(redPath, DangerRed, style = lineStroke)

            drawCircle(
                color = DangerRed,
                radius = 5.dp.toPx(),
                center = Offset(sx(177f), sy(150f))
            )

            drawCircle(
                color = SuccessGreen,
                radius = 5.dp.toPx(),
                center = Offset(sx(267f), sy(40f))
            )
        }

        Text(
            text = salaryLabel,
            fontSize = 10.sp,
            fontWeight = FontWeight.Bold,
            color = SuccessGreen,
            modifier = Modifier.offset(
                x = chartWidth * (238f / CHART_DESIGN_WIDTH),
                y = chartHeight * (18f / CHART_DESIGN_HEIGHT)
            )
        )

        Text(
            text = gapLabel,
            fontSize = 10.sp,
            fontWeight = FontWeight.Bold,
            color = DangerRed,
            modifier = Modifier.offset(
                x = chartWidth * (148f / CHART_DESIGN_WIDTH),
                y = chartHeight * (160f / CHART_DESIGN_HEIGHT)
            )
        )
    }
}

@Composable
private fun ChartXAxisLabels(labels: List<String>) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 4.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        labels.forEach { label ->
            Text(
                text = label,
                fontSize = 11.sp,
                fontWeight = FontWeight.SemiBold,
                color = Color(0xFFA39D92)
            )
        }
    }
}

@Composable
private fun ForecastAlertCard(
    minBalanceLabel: String,
    minBalanceValue: String,
    description: String,
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(DangerRedSurface, RoundedCornerShape(18.dp))
            .padding(15.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(13.dp)
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(2.dp)
        ) {
            Text(
                text = minBalanceLabel,
                fontSize = 11.sp,
                fontWeight = FontWeight.Bold,
                color = DangerRed
            )
            Text(
                text = minBalanceValue,
                fontSize = 22.sp,
                fontWeight = FontWeight.ExtraBold,
                color = DangerRed
            )
        }

        Box(
            modifier = Modifier
                .width(1.dp)
                .height(36.dp)
                .background(DangerRedBorder)
        )

        Text(
            text = description,
            fontSize = 13.sp,
            fontWeight = FontWeight.SemiBold,
            color = DarkNearBlack,
            lineHeight = 18.85.sp,
            modifier = Modifier.weight(1f)
        )
    }
}

@Composable
private fun CloseGapButton(label: String, onClick: () -> Unit) {
    Button(
        onClick = onClick,
        modifier = Modifier
            .fillMaxWidth()
            .height(56.dp),
        shape = RoundedCornerShape(16.dp),
        colors = ButtonDefaults.buttonColors(containerColor = DangerRed)
    ) {
        Text(
            text = label,
            fontSize = 17.sp,
            fontWeight = FontWeight.Bold,
            color = Color.White
        )
    }
}
