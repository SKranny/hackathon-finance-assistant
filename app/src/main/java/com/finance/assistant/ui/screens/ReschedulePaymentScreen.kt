package com.finance.assistant.ui.screens

import androidx.compose.foundation.background
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
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.finance.assistant.ui.screens.viewmodel.RescheduleViewModel
import com.finance.assistant.ui.theme.DarkNearBlack
import com.finance.assistant.ui.theme.SuccessGreen
import com.finance.assistant.ui.theme.SurfaceGray
import com.finance.assistant.ui.theme.TextSecondary

private val DateLabelGray = Color(0xFFA39D92)
private val DividerColor = Color(0xFFE7E7EA)
private val SuccessGreenSurface = Color(0xFFEEF8F3)
private val ConfirmRed = Color(0xFFEF3124)

@Composable
fun ReschedulePaymentScreen(
    onBack: () -> Unit = {},
    onConfirm: () -> Unit = {},
    viewModel: RescheduleViewModel = hiltViewModel(),
) {
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()
    val data = uiState.data

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(SurfaceGray),
    ) {
        ScreenTopBar(
            title = data?.header?.title ?: "",
            onBack = onBack
        )

        if (data != null) {
            Column(
                modifier = Modifier
                    .weight(1f)
                    .background(Color.White)
                    .padding(horizontal = 24.dp, vertical = 18.dp),
                verticalArrangement = Arrangement.spacedBy(16.dp),
            ) {
                DateRescheduleCard(
                    originalDate = data.dateReschedule.originalDate,
                    originalDateLabel = data.dateReschedule.originalDateLabel,
                    newDate = data.dateReschedule.newDate,
                    newDateLabel = data.dateReschedule.newDateLabel,
                    paymentName = data.payment.name,
                    amount = data.payment.amount,
                    account = data.payment.account,
                    overpayment = data.payment.overpayment,
                )

                InfoBanner(message = data.infoMessage)
            }

            ConfirmButton(
                label = data.confirmButton.label,
                onClick = onConfirm
            )
        }
    }
}

@Composable
private fun ScreenTopBar(title: String, onBack: () -> Unit) {
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
            modifier = Modifier.clickable { onBack() },
        )
        Text(
            text = title,
            fontSize = 20.sp,
            fontWeight = FontWeight(800),
            color = DarkNearBlack,
            letterSpacing = (-0.4).sp,
        )
    }
}

@Composable
private fun DateRescheduleCard(
    originalDate: String,
    originalDateLabel: String,
    newDate: String,
    newDateLabel: String,
    paymentName: String,
    amount: String,
    account: String,
    overpayment: String,
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.White, RoundedCornerShape(24.dp))
            .padding(20.dp),
        verticalArrangement = Arrangement.spacedBy(6.dp),
    ) {
        DateTransitionRow(
            originalDate = originalDate,
            originalDateLabel = originalDateLabel,
            newDate = newDate,
            newDateLabel = newDateLabel,
        )

        Spacer(modifier = Modifier.height(6.dp))
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(1.dp)
                .background(DividerColor),
        )

        PaymentDetailRow(label = "Платёж", value = paymentName, valueColor = DarkNearBlack)
        PaymentDetailRow(label = "Сумма", value = amount, valueColor = DarkNearBlack)
        PaymentDetailRow(label = "Счёт", value = account, valueColor = DarkNearBlack)
        PaymentDetailRow(label = "Переплата", value = overpayment, valueColor = SuccessGreen)
    }
}

@Composable
private fun DateTransitionRow(
    originalDate: String,
    originalDateLabel: String,
    newDate: String,
    newDateLabel: String,
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 12.dp),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(2.dp),
        ) {
            Text(
                text = originalDateLabel,
                fontSize = 11.sp,
                fontWeight = FontWeight.Bold,
                color = DateLabelGray,
            )
            Text(
                text = originalDate,
                fontSize = 18.sp,
                fontWeight = FontWeight(800),
                color = DarkNearBlack,
            )
        }

        Text(
            text = "→",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            color = SuccessGreen,
            modifier = Modifier.padding(horizontal = 14.dp),
        )

        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(2.dp),
        ) {
            Text(
                text = newDateLabel,
                fontSize = 11.sp,
                fontWeight = FontWeight.Bold,
                color = SuccessGreen,
            )
            Text(
                text = newDate,
                fontSize = 18.sp,
                fontWeight = FontWeight(800),
                color = SuccessGreen,
            )
        }
    }
}

@Composable
private fun PaymentDetailRow(
    label: String,
    value: String,
    valueColor: Color,
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 7.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.Top,
    ) {
        Text(
            text = label,
            fontSize = 14.sp,
            fontWeight = FontWeight.SemiBold,
            color = TextSecondary,
        )
        Text(
            text = value,
            fontSize = 14.sp,
            fontWeight = FontWeight.Bold,
            color = valueColor,
        )
    }
}

@Composable
private fun InfoBanner(message: String) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(SuccessGreenSurface, RoundedCornerShape(16.dp))
            .padding(horizontal = 16.dp, vertical = 14.dp),
    ) {
        Text(
            text = message,
            fontSize = 14.sp,
            fontWeight = FontWeight.Medium,
            color = DarkNearBlack,
            lineHeight = 20.sp,
        )
    }
}

@Composable
private fun ConfirmButton(label: String, onClick: () -> Unit) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.White)
            .padding(horizontal = 24.dp, vertical = 16.dp),
    ) {
        Button(
            onClick = onClick,
            modifier = Modifier
                .fillMaxWidth()
                .height(56.dp),
            shape = RoundedCornerShape(28.dp),
            colors = ButtonDefaults.buttonColors(containerColor = ConfirmRed),
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
