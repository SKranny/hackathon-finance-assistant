package com.finance.assistant.domain.usecase

import com.finance.assistant.data.repository.CaseRepository
import com.finance.assistant.data.repository.ChatRepository
import com.finance.assistant.data.repository.ExpenseRepository
import com.finance.assistant.data.repository.UserRepository
import com.finance.assistant.domain.model.assistant.ActionType
import com.finance.assistant.domain.model.assistant.AssistantAction
import com.finance.assistant.domain.model.assistant.AssistantContext
import com.finance.assistant.domain.model.assistant.AssistantResponse
import com.finance.assistant.domain.model.assistant.ChatAction
import com.finance.assistant.domain.model.assistant.ChatMessage
import com.finance.assistant.domain.model.assistant.MessageRole
import com.finance.assistant.domain.model.expense.RecurringExpense
import com.finance.assistant.domain.model.expense.UpcomingExpense
import com.finance.assistant.domain.model.forecast.BalanceForecast
import kotlinx.coroutines.flow.first
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class AssistantUseCase @Inject constructor(
    private val chatRepository: ChatRepository,
    private val userRepository: UserRepository,
    private val expenseRepository: ExpenseRepository,
    private val caseRepository: CaseRepository,
    private val balanceForecastUseCase: BalanceForecastUseCase,
) {

    suspend fun sendMessage(userMessage: String): AssistantResponse {
        chatRepository.saveMessage(MessageRole.USER, userMessage)

        val context = getContext()
        val response = generateResponse(userMessage, context)
        val action = parseAction(userMessage, context)

        val message = chatRepository.saveMessage(MessageRole.ASSISTANT, response)
        val actions = action?.let { listOf(it) } ?: emptyList()

        return AssistantResponse(
            message = ChatMessage(
                id = message,
                role = MessageRole.ASSISTANT,
                content = response,
            ),
            suggestedActions = actions,
            context = context,
        )
    }

    suspend fun executeAction(actionType: ActionType, params: Map<String, String>): Result<String> {
        return when (actionType) {
            ActionType.RESCHEDULE_EXPENSE -> {
                val expenseId = params["expenseId"]?.toLongOrNull() ?: return Result.failure(Exception("Missing expenseId"))
                val newDateStr = params["newDate"] ?: return Result.failure(Exception("Missing newDate"))
                val newDate = LocalDate.parse(newDateStr)

                rescheduleExpense(expenseId, newDate)
            }
            ActionType.CANCEL_SUBSCRIPTION -> {
                val subscriptionId = params["subscriptionId"]?.toLongOrNull() ?: return Result.failure(Exception("Missing subscriptionId"))
                cancelSubscription(subscriptionId)
            }
            ActionType.SET_REMINDER -> {
                val expenseId = params["expenseId"]?.toLongOrNull() ?: return Result.failure(Exception("Missing expenseId"))
                val reminderDateStr = params["reminderDate"] ?: return Result.failure(Exception("Missing reminderDate"))
                val reminderDate = LocalDate.parse(reminderDateStr)

                setReminder(expenseId, reminderDate)
            }
            else -> Result.success("Действие выполнено")
        }
    }

    private suspend fun rescheduleExpense(expenseId: Long, newDate: LocalDate): Result<String> {
        val expense = expenseRepository.getUpcomingExpenseById(expenseId)
            ?: return Result.failure(Exception("Expense not found"))

        val updatedExpense = expense.copy(dueDate = newDate)
        expenseRepository.updateUpcomingExpense(updatedExpense)

        return Result.success("Расход '${expense.title}' перенесён на ${newDate.format(DateTimeFormatter.ofPattern("dd.MM.yyyy"))}")
    }

    private suspend fun cancelSubscription(subscriptionId: Long): Result<String> {
        expenseRepository.deactivateRecurringExpense(subscriptionId)
        return Result.success("Подписка отменена")
    }

    private suspend fun setReminder(expenseId: Long, reminderDate: LocalDate): Result<String> {
        return Result.success("Напоминание установлено на ${reminderDate.format(DateTimeFormatter.ofPattern("dd.MM.yyyy"))}")
    }

    private suspend fun getContext(): AssistantContext {
        val profile = userRepository.getProfile()
        val upcomingCount = expenseRepository.getUpcomingExpenses().first().size
        val activeCases = caseRepository.getActiveCases().first().size
        val forecast = balanceForecastUseCase.calculateForecast(30)

        val monthlyExpenses = forecast.forecastPoints.sumOf { it.projectedExpenses }

        return AssistantContext(
            currentBalance = profile?.balance ?: 0.0,
            monthlyIncome = profile?.salary ?: 0.0,
            monthlyExpenses = monthlyExpenses,
            upcomingExpenses = upcomingCount,
            activeCases = activeCases,
            nextSalaryDate = profile?.nextSalaryDate?.format(DateTimeFormatter.ofPattern("dd.MM.yyyy")),
        )
    }

    private fun generateResponse(userMessage: String, context: AssistantContext): String {
        val lowerMessage = userMessage.lowercase()

        return when {
            lowerMessage.contains("баланс") || lowerMessage.contains("деньги") ->
                "Ваш текущий баланс: ${formatMoney(context.currentBalance)} ₽. Следующая зарплата: ${context.nextSalaryDate ?: "не указана"}."

            lowerMessage.contains("расход") || lowerMessage.contains("трат") ->
                "У вас ${context.upcomingExpenses} предстоящих расходов. Месячные расходы: ${formatMoney(context.monthlyExpenses)} ₽."

            lowerMessage.contains("зарплат") ->
                "Ваш доход: ${formatMoney(context.monthlyIncome)} ₽. Следующая зарплата ожидается ${context.nextSalaryDate ?: "не указана"}."

            lowerMessage.contains("помощь") || lowerMessage.contains("help") ->
                "Я могу помочь:\n• Перенести расходы\n• Отменить подписки\n• Показать прогноз баланса\n• Настроить напоминания"

            else ->
                "Понимаю. Чем могу помочь с вашими финансами?"
        }
    }

    private fun parseAction(userMessage: String, context: AssistantContext): AssistantAction? {
        val lowerMessage = userMessage.lowercase()

        return when {
            lowerMessage.contains("перенести") && lowerMessage.contains("расход") ->
                AssistantAction(
                    title = "Перенести расход",
                    description = "Выберите расход для переноса",
                    type = ActionType.RESCHEDULE_EXPENSE,
                    data = emptyMap(),
                )
            lowerMessage.contains("отменить") && lowerMessage.contains("подписк") ->
                AssistantAction(
                    title = "Отменить подписку",
                    description = "Выберите подписку для отмены",
                    type = ActionType.CANCEL_SUBSCRIPTION,
                    data = emptyMap(),
                )
            else -> null
        }
    }

    private fun formatMoney(amount: Double): String {
        return "%,.2f".format(amount).replace(",", " ")
    }
}
