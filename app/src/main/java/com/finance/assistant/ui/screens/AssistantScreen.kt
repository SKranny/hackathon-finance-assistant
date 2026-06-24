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
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.Send
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.finance.assistant.domain.model.assistant.AssistantAction
import com.finance.assistant.domain.model.assistant.ChatMessage
import com.finance.assistant.domain.model.assistant.MessageRole
import com.finance.assistant.ui.screens.viewmodel.AssistantViewModel
import com.finance.assistant.ui.screens.viewmodel.displayLabel
import com.finance.assistant.ui.theme.DangerRed
import com.finance.assistant.ui.theme.DangerRedBorder
import com.finance.assistant.ui.theme.DarkNearBlack
import com.finance.assistant.ui.theme.SuccessGreen
import com.finance.assistant.ui.theme.SurfaceGray
import com.finance.assistant.ui.theme.TextSecondary

@Composable
fun AssistantScreen(viewModel: AssistantViewModel = hiltViewModel()) {
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(SurfaceGray)
            .imePadding(),
    ) {
        AssistantHeader()
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(1.dp)
                .background(Color(0xFFF2F2F4)),
        )
        ChatMessageList(
            messages = uiState.messages,
            messageActions = uiState.messageActions,
            onActionClick = { messageId, action -> viewModel.executeAction(messageId, action) },
            modifier = Modifier.weight(1f),
        )
        ChatInputBar(
            inputText = uiState.inputText,
            isLoading = uiState.isLoading,
            onInputChanged = viewModel::onInputChanged,
            onSend = viewModel::sendMessage,
        )
    }
}

@Composable
private fun AssistantHeader() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.White)
            .padding(start = 22.dp, end = 22.dp, top = 2.dp, bottom = 14.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(11.dp),
    ) {
        Box(
            modifier = Modifier
                .size(38.dp)
                .clip(RoundedCornerShape(11.dp))
                .background(DangerRed),
            contentAlignment = Alignment.Center,
        ) {
            Text(
                text = "✦",
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White,
                lineHeight = (18 * 1.35).sp,
            )
        }
        Column(verticalArrangement = Arrangement.spacedBy(1.dp)) {
            Text(
                text = "Помощник",
                fontSize = 16.sp,
                fontWeight = FontWeight.ExtraBold,
                color = DarkNearBlack,
                lineHeight = (16 * 1.35).sp,
            )
            Text(
                text = "читает почту и календарь",
                fontSize = 12.sp,
                fontWeight = FontWeight.SemiBold,
                color = SuccessGreen,
                lineHeight = (12 * 1.35).sp,
            )
        }
    }
}

@Composable
private fun ChatMessageList(
    messages: List<ChatMessage>,
    messageActions: Map<Long, List<AssistantAction>>,
    onActionClick: (Long, AssistantAction) -> Unit,
    modifier: Modifier = Modifier,
) {
    val listState = rememberLazyListState()

    LaunchedEffect(messages.size) {
        if (messages.isNotEmpty()) {
            listState.animateScrollToItem(messages.lastIndex)
        }
    }

    LazyColumn(
        state = listState,
        modifier = modifier
            .fillMaxWidth()
            .background(SurfaceGray)
            .padding(horizontal = 16.dp),
        verticalArrangement = Arrangement.spacedBy(11.dp),
        contentPadding = androidx.compose.foundation.layout.PaddingValues(
            top = 16.dp,
            bottom = 8.dp,
        ),
    ) {
        items(messages, key = { it.id }) { message ->
            val actions = messageActions[message.id] ?: emptyList()
            when (message.role) {
                MessageRole.USER -> UserMessageBubble(message)
                else -> BotMessageBubble(
                    message = message,
                    actions = actions,
                    onActionClick = { action -> onActionClick(message.id, action) },
                )
            }
        }
    }
}

@Composable
private fun BotMessageBubble(
    message: ChatMessage,
    actions: List<AssistantAction>,
    onActionClick: (AssistantAction) -> Unit,
) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.Start,
    ) {
        Column(
            modifier = Modifier
                .widthIn(max = 260.dp)
                .clip(RoundedCornerShape(18.dp))
                .background(Color.White)
                .padding(horizontal = 15.dp, vertical = 13.dp),
            verticalArrangement = Arrangement.spacedBy(11.dp),
        ) {
            Text(
                text = message.content,
                fontSize = 14.sp,
                fontWeight = FontWeight.Normal,
                color = DarkNearBlack,
                lineHeight = (14 * 1.45).sp,
            )
            actions.forEach { action ->
                ActionButton(
                    label = action.title.ifBlank { action.type.displayLabel() },
                    onClick = { onActionClick(action) },
                )
            }
        }
    }
}

@Composable
private fun UserMessageBubble(message: ChatMessage) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.End,
    ) {
        Box(
            modifier = Modifier
                .clip(RoundedCornerShape(18.dp))
                .background(DangerRed)
                .padding(horizontal = 15.dp, vertical = 13.dp),
        ) {
            Text(
                text = message.content,
                fontSize = 14.sp,
                fontWeight = FontWeight.Normal,
                color = Color.White,
                lineHeight = (14 * 1.45).sp,
            )
        }
    }
}

@Composable
private fun ActionButton(label: String, onClick: () -> Unit) {
    TextButton(
        onClick = onClick,
        modifier = Modifier
            .size(width = 150.dp, height = 36.dp)
            .clip(RoundedCornerShape(11.dp))
            .border(1.5.dp, DangerRedBorder, RoundedCornerShape(11.dp)),
        contentPadding = androidx.compose.foundation.layout.PaddingValues(horizontal = 14.dp),
    ) {
        Text(
            text = label,
            fontSize = 13.sp,
            fontWeight = FontWeight.Bold,
            color = DangerRed,
            lineHeight = (13 * 1.35).sp,
        )
    }
}

@Composable
private fun ChatInputBar(
    inputText: String,
    isLoading: Boolean,
    onInputChanged: (String) -> Unit,
    onSend: () -> Unit,
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.White)
            .padding(horizontal = 16.dp, vertical = 10.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(10.dp),
    ) {
        BasicTextField(
            value = inputText,
            onValueChange = onInputChanged,
            modifier = Modifier
                .weight(1f)
                .height(42.dp)
                .clip(RoundedCornerShape(14.dp))
                .background(SurfaceGray)
                .padding(horizontal = 14.dp),
            textStyle = TextStyle(
                fontSize = 14.sp,
                fontWeight = FontWeight.Normal,
                color = DarkNearBlack,
                lineHeight = (14 * 1.45).sp,
            ),
            cursorBrush = SolidColor(DangerRed),
            singleLine = true,
            decorationBox = { innerTextField ->
                Box(contentAlignment = Alignment.CenterStart) {
                    if (inputText.isEmpty()) {
                        Text(
                            text = "Спроси о деньгах...",
                            fontSize = 14.sp,
                            fontWeight = FontWeight.Normal,
                            color = TextSecondary,
                        )
                    }
                    innerTextField()
                }
            },
        )
        IconButton(
            onClick = onSend,
            enabled = inputText.isNotBlank() && !isLoading,
            modifier = Modifier
                .size(42.dp)
                .clip(CircleShape)
                .background(if (inputText.isNotBlank() && !isLoading) DangerRed else Color(0xFFB6B6BB)),
        ) {
            Icon(
                imageVector = Icons.AutoMirrored.Filled.Send,
                contentDescription = "Отправить",
                tint = Color.White,
                modifier = Modifier.size(18.dp),
            )
        }
    }
}
