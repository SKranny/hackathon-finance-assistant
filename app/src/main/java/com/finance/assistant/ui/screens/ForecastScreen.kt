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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.StrokeJoin
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.finance.assistant.ui.theme.DangerRed
import com.finance.assistant.ui.theme.DangerRedBorder
import com.finance.assistant.ui.theme.DangerRedSurface
import com.finance.assistant.ui.theme.DarkNearBlack
import com.finance.assistant.ui.theme.SuccessGreen
import com.finance.assistant.ui.theme.SurfaceGray
import com.finance.assistant.ui.theme.TextSecondary

// Original Figma design coordinate space for the chart area
private const val CHART_DESIGN_WIDTH = 320f
private const val CHART_DESIGN_HEIGHT = 190f

// Zero-balance baseline y position in design space
private const val BASELINE_Y_DESIGN = 120f

@Composable
fun ForecastScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(SurfaceGray)
    ) {
        // Screen title
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.White)
                .padding(start = 22.dp, end = 22.dp, top = 2.dp, bottom = 14.dp)
        ) {
            Text(
                text = "Прогноз баланса",
                fontSize = 20.sp,
                fontWeight = FontWeight.ExtraBold,
                color = DarkNearBlack,
                letterSpacing = (-0.4).sp
            )
        }

        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.White)
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(14.dp)
        ) {
            ForecastChartCard()
            ForecastAlertCard()
            CloseGapButton()
        }
    }
}

@Composable
private fun ForecastChartCard() {
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
                text = "Следующие 14 дней",
                fontSize = 13.sp,
                fontWeight = FontWeight.Bold,
                color = TextSecondary
            )
            MinBalanceBadge()
        }

        BalanceForecastChart(
            modifier = Modifier
                .fillMaxWidth()
                .height(190.dp)
        )

        ChartXAxisLabels()
    }
}

@Composable
private fun MinBalanceBadge() {
    Box(
        modifier = Modifier
            .background(DangerRedSurface, RoundedCornerShape(99.dp))
            .padding(horizontal = 9.dp, vertical = 4.dp)
    ) {
        Text(
            text = "мин. −40 000 ₽",
            fontSize = 12.sp,
            fontWeight = FontWeight.Bold,
            color = DangerRed
        )
    }
}

@Composable
private fun BalanceForecastChart(modifier: Modifier = Modifier) {
    BoxWithConstraints(modifier = modifier) {
        val chartWidth = maxWidth
        val chartHeight = maxHeight

        Canvas(modifier = Modifier.fillMaxSize()) {
            fun sx(designX: Float) = designX / CHART_DESIGN_WIDTH * size.width
            fun sy(designY: Float) = designY / CHART_DESIGN_HEIGHT * size.height

            // Zero-balance horizontal rule
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

            // Green forecast line — covers full path including the gap region (overdrawn by red below)
            // Design absolute coordinates derived from SVG at offset (0, 36): y = 36 + svgY
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

            // Red line — dip below baseline, drawn on top to replace the green in the gap region
            // Design absolute coordinates derived from SVG at offset (138, 120): y = 120 + svgY
            val redPath = Path().apply {
                moveTo(sx(138f), sy(120f))
                lineTo(sx(161f), sy(150f))
                lineTo(sx(193f), sy(150f))
                lineTo(sx(217f), sy(120f))
            }
            drawPath(redPath, DangerRed, style = lineStroke)

            // Red dot at the deepest gap point
            drawCircle(
                color = DangerRed,
                radius = 5.dp.toPx(),
                center = Offset(sx(177f), sy(150f))
            )

            // Green dot at salary income point
            drawCircle(
                color = SuccessGreen,
                radius = 5.dp.toPx(),
                center = Offset(sx(267f), sy(40f))
            )
        }

        // "зарплата" label above the salary dot — design position: left=238, top=18
        Text(
            text = "зарплата",
            fontSize = 10.sp,
            fontWeight = FontWeight.Bold,
            color = SuccessGreen,
            modifier = Modifier.offset(
                x = chartWidth * (238f / CHART_DESIGN_WIDTH),
                y = chartHeight * (18f / CHART_DESIGN_HEIGHT)
            )
        )

        // "9 июня" label below the gap dot — design position: left=148, top=160
        Text(
            text = "9 июня",
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
private fun ChartXAxisLabels() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 4.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        listOf("сегодня", "5 июня", "10 июня", "15").forEach { label ->
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
private fun ForecastAlertCard() {
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
                text = "провал",
                fontSize = 11.sp,
                fontWeight = FontWeight.Bold,
                color = DangerRed
            )
            Text(
                text = "−40k",
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
            text = "9 июня баланс уйдёт в минус. Причина — автоплатёж по ипотеке 5 июня.",
            fontSize = 13.sp,
            fontWeight = FontWeight.SemiBold,
            color = DarkNearBlack,
            lineHeight = 18.85.sp,
            modifier = Modifier.weight(1f)
        )
    }
}

@Composable
private fun CloseGapButton() {
    Button(
        onClick = {},
        modifier = Modifier
            .fillMaxWidth()
            .height(56.dp),
        shape = RoundedCornerShape(16.dp),
        colors = ButtonDefaults.buttonColors(containerColor = DangerRed)
    ) {
        Text(
            text = "Как закрыть разрыв",
            fontSize = 17.sp,
            fontWeight = FontWeight.Bold,
            color = Color.White
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun ForecastScreenPreview() {
    ForecastScreen()
}
