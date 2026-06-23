package com.finance.assistant.data.repository

import com.finance.assistant.data.objectbox.entity.session.ChatMessageEntity
import com.finance.assistant.data.objectbox.entity.session.ChatMessageEntity_
import com.finance.assistant.domain.model.assistant.ChatMessage
import com.finance.assistant.domain.model.assistant.MessageRole
import io.objectbox.Box
import io.objectbox.kotlin.flow
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.withContext
import java.time.Instant
import java.time.LocalDateTime
import java.time.ZoneId
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ChatRepository @Inject constructor(
    private val chatMessageBox: Box<ChatMessageEntity>,
) {

    suspend fun saveMessage(role: MessageRole, content: String): Long =
        withContext(Dispatchers.IO) {
            val entity = ChatMessageEntity(
                role = role.name,
                content = content,
                timestamp = System.currentTimeMillis(),
            )
            chatMessageBox.put(entity)
        }

    suspend fun markAsRead(id: Long) =
        withContext(Dispatchers.IO) {
            chatMessageBox.get(id)?.let {
                it.read = true
                chatMessageBox.put(it)
            }
        }

    suspend fun deleteMessage(id: Long) =
        withContext(Dispatchers.IO) {
            chatMessageBox.remove(id)
        }

    suspend fun clearHistory() =
        withContext(Dispatchers.IO) {
            chatMessageBox.removeAll()
        }

    @OptIn(ExperimentalCoroutinesApi::class)
    fun getMessages(): Flow<List<ChatMessage>> =
        chatMessageBox.query()
            .orderDesc(ChatMessageEntity_.timestamp)
            .build()
            .flow()
            .map { list -> list.map { it.toDomain() } }
            .flowOn(Dispatchers.IO)

    @OptIn(ExperimentalCoroutinesApi::class)
    fun getUnreadMessages(): Flow<List<ChatMessage>> =
        chatMessageBox.query()
            .equal(ChatMessageEntity_.read, false)
            .notEqual(ChatMessageEntity_.role, MessageRole.USER.name, io.objectbox.query.QueryBuilder.StringOrder.CASE_SENSITIVE)
            .orderDesc(ChatMessageEntity_.timestamp)
            .build()
            .flow()
            .map { list -> list.map { it.toDomain() } }
            .flowOn(Dispatchers.IO)

    suspend fun getRecentMessages(limit: Int = 50): List<ChatMessage> =
        withContext(Dispatchers.IO) {
            chatMessageBox.query()
                .orderDesc(ChatMessageEntity_.timestamp)
                .build()
                .find(0, limit.toLong())
                .reversed()
                .map { it.toDomain() }
        }

    private fun ChatMessageEntity.toDomain(): ChatMessage = ChatMessage(
        id = id,
        role = try { MessageRole.valueOf(role) } catch (e: Exception) { MessageRole.ASSISTANT },
        content = content,
        timestamp = LocalDateTime.ofInstant(
            Instant.ofEpochMilli(timestamp),
            ZoneId.systemDefault()
        ),
        isRead = read,
    )
}
