package com.finance.assistant.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.finance.assistant.ui.screens.viewmodel.PaymentConfirmationViewModel
import com.finance.assistant.ui.theme.DangerRed
import com.finance.assistant.ui.theme.DarkNearBlack
import com.finance.assistant.ui.theme.SuccessGreen
import com.finance.assistant.ui.theme.SurfaceGray
import com.finance.assistant.ui.theme.TextSecondary

private val SuccessIconSurface = Color(0xFFE9F6EF)

@Composable
fun PaymentConfirmationScreen(
    onGoHome: () -> Unit = {},
    onGoToFeed: () -> Unit = {},
    viewModel: PaymentConfirmationViewModel = hiltViewModel(),
) {
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()
    val data = uiState.data

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White),
    ) {
        Column(
            modifier = Modifier
                .weight(1f)
                .fillMaxWidth()
                .padding(horizontal = 40.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp, Alignment.CenterVertically),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            SuccessIcon(symbol = data?.successIcon?.symbol ?: "✓")

            Text(
                text = data?.title ?: "Платёж перенесён",
                fontSize = 24.sp,
                fontWeight = FontWeight(800),
                color = DarkNearBlack,
                textAlign = TextAlign.Center,
                letterSpacing = (-0.48).sp,
                lineHeight = (24 * 1.2).sp,
            )

            Text(
                text = data?.description ?: "",
                fontSize = 15.sp,
                fontWeight = FontWeight.Normal,
                color = TextSecondary,
                textAlign = TextAlign.Center,
                lineHeight = (15 * 1.5).sp,
            )
        }

        if (data != null) {
            ConfirmationActions(
                primaryLabel = data.actions.primary,
                secondaryLabel = data.actions.secondary,
                onGoHome = onGoHome,
                onGoToFeed = onGoToFeed,
            )
        }
    }
}

@Composable
private fun SuccessIcon(symbol: String) {
    Box(
        modifier = Modifier
            .size(88.dp)
            .background(SuccessIconSurface, CircleShape),
        contentAlignment = Alignment.Center,
    ) {
        Text(
            text = symbol,
            fontSize = 46.sp,
            fontWeight = FontWeight(800),
            color = SuccessGreen,
            lineHeight = (46 * 1.35).sp,
        )
    }
}

@Composable
private fun ConfirmationActions(
    primaryLabel: String,
    secondaryLabel: String,
    onGoHome: () -> Unit,
    onGoToFeed: () -> Unit,
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 24.dp, end = 24.dp, top = 12.dp, bottom = 30.dp),
        verticalArrangement = Arrangement.spacedBy(10.dp),
    ) {
        Button(
            onClick = onGoHome,
            modifier = Modifier
                .fillMaxWidth()
                .height(56.dp),
            shape = RoundedCornerShape(16.dp),
            colors = ButtonDefaults.buttonColors(containerColor = DangerRed),
        ) {
            Text(
                text = primaryLabel,
                fontSize = 17.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White,
                lineHeight = (17 * 1.35).sp,
            )
        }

        Button(
            onClick = onGoToFeed,
            modifier = Modifier
                .fillMaxWidth()
                .height(56.dp),
            shape = RoundedCornerShape(16.dp),
            colors = ButtonDefaults.buttonColors(containerColor = SurfaceGray),
        ) {
            Text(
                text = secondaryLabel,
                fontSize = 17.sp,
                fontWeight = FontWeight.Bold,
                color = DarkNearBlack,
                lineHeight = (17 * 1.35).sp,
            )
        }
    }
}
