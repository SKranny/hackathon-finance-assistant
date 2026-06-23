package com.finance.assistant.dev

import com.finance.assistant.domain.model.Transaction
import com.finance.assistant.domain.model.TransactionCategory
import com.finance.assistant.domain.model.TransactionSource
import com.finance.assistant.domain.model.expense.ExpenseSource
import com.finance.assistant.domain.model.expense.RecurringExpense
import com.finance.assistant.domain.model.expense.RecurringFrequency
import com.finance.assistant.domain.model.expense.UpcomingExpense
import com.finance.assistant.domain.model.profile.UserProfile
import java.time.LocalDate

object DevMocks {

    fun getMockTransactions(): List<Transaction> {
        val today = LocalDate.now()
        return listOf(
            Transaction(
                id = 1,
                title = "Пятёрочка",
                amount = 2500.0,
                category = TransactionCategory.FOOD,
                date = today.minusDays(1),
                source = TransactionSource.SMS,
                description = "Продукты"
            ),
            Transaction(
                id = 2,
                title = "Яндекс Такси",
                amount = 850.0,
                category = TransactionCategory.TRANSPORT,
                date = today.minusDays(2),
                source = TransactionSource.SMS,
                description = "Поездка"
            ),
            Transaction(
                id = 3,
                title = "Сбербанк",
                amount = 15000.0,
                category = TransactionCategory.HOUSING,
                date = today.minusDays(3),
                source = TransactionSource.MANUAL,
                description = "Аренда"
            ),
            Transaction(
                id = 4,
                title = "Мосэнергосбыт",
                amount = 3200.0,
                category = TransactionCategory.UTILITIES,
                date = today.minusDays(5),
                source = TransactionSource.EMAIL,
                description = "Электричество"
            ),
            Transaction(
                id = 5,
                title = "Netflix",
                amount = 999.0,
                category = TransactionCategory.SUBSCRIPTION,
                date = today.minusDays(7),
                source = TransactionSource.SMS,
                description = "Подписка"
            ),
            Transaction(
                id = 6,
                title = "Перевод Саше",
                amount = 5000.0,
                category = TransactionCategory.TRANSFER,
                date = today.minusDays(10),
                source = TransactionSource.MANUAL,
                description = "Долг"
            ),
            Transaction(
                id = 7,
                title = "Перевод Маме",
                amount = 10000.0,
                category = TransactionCategory.TRANSFER,
                date = today.minusDays(15),
                source = TransactionSource.MANUAL,
                description = "Помощь"
            ),
            Transaction(
                id = 8,
                title = "Зарплата",
                amount = -120000.0,
                category = TransactionCategory.SALARY,
                date = today.minusDays(20),
                source = TransactionSource.MANUAL,
                description = "Оклад"
            ),
            Transaction(
                id = 9,
                title = "Аптека",
                amount = 1500.0,
                category = TransactionCategory.HEALTHCARE,
                date = today.minusDays(12),
                source = TransactionSource.SMS,
                description = "Лекарства"
            ),
            Transaction(
                id = 10,
                title = "ivi",
                amount = 599.0,
                category = TransactionCategory.SUBSCRIPTION,
                date = today.minusDays(8),
                source = TransactionSource.SMS,
                description = "Подписка"
            ),
            Transaction(
                id = 11,
                title = "Магнит",
                amount = 3200.0,
                category = TransactionCategory.FOOD,
                date = today.minusDays(4),
                source = TransactionSource.SMS,
                description = "Продукты"
            ),
            Transaction(
                id = 12,
                title = "DNS",
                amount = 25000.0,
                category = TransactionCategory.SHOPPING,
                date = today.minusDays(6),
                source = TransactionSource.MANUAL,
                description = "Наушники"
            ),
            Transaction(
                id = 13,
                title = "Кинотеатр",
                amount = 1200.0,
                category = TransactionCategory.ENTERTAINMENT,
                date = today.minusDays(9),
                source = TransactionSource.SMS,
                description = "2 билета"
            ),
            Transaction(
                id = 14,
                title = "МТС",
                amount = 650.0,
                category = TransactionCategory.SUBSCRIPTION,
                date = today.minusDays(14),
                source = TransactionSource.SMS,
                description = "Связь"
            ),
            Transaction(
                id = 15,
                title = "Газпромбанк",
                amount = -50000.0,
                category = TransactionCategory.SALARY,
                date = today.minusDays(1),
                source = TransactionSource.MANUAL,
                description = "Аванс"
            ),
        )
    }

    fun getMockUserProfile(): UserProfile {
        val today = LocalDate.now()
        val nextSalary = today.withDayOfMonth(5).let {
            if (it.isBefore(today)) it.plusMonths(1) else it
        }

        return UserProfile(
            id = 1,
            name = "Тестовый пользователь",
            salary = 120000.0,
            salaryDay = 5,
            balance = 45000.0,
            nextSalaryDate = nextSalary,
        )
    }

    fun getMockUpcomingExpenses(): List<UpcomingExpense> {
        val today = LocalDate.now()
        return listOf(
            UpcomingExpense(
                id = 1,
                title = "Аренда квартиры",
                amount = 45000.0,
                dueDate = today.plusDays(3),
                category = "HOUSING",
                description = "Оплата за месяц",
                source = ExpenseSource.CALENDAR,
            ),
            UpcomingExpense(
                id = 2,
                title = "Оплата ЖКУ",
                amount = 8500.0,
                dueDate = today.plusDays(5),
                category = "UTILITIES",
                description = "Коммунальные услуги",
                source = ExpenseSource.DOCUMENT,
            ),
            UpcomingExpense(
                id = 3,
                title = "Курсы английского",
                amount = 12000.0,
                dueDate = today.plusDays(7),
                category = "EDUCATION",
                description = "Месячная оплата",
                source = ExpenseSource.EMAIL,
            ),
            UpcomingExpense(
                id = 4,
                title = "Автостраховка ОСАГО",
                amount = 8500.0,
                dueDate = today.plusDays(12),
                category = "TRANSPORT",
                description = "Годовая страховка",
                source = ExpenseSource.DOCUMENT,
            ),
            UpcomingExpense(
                id = 5,
                title = "Плановое ТО автомобиля",
                amount = 25000.0,
                dueDate = today.plusDays(20),
                category = "TRANSPORT",
                description = "Замена масла, фильтры",
                source = ExpenseSource.CALENDAR,
            ),
            UpcomingExpense(
                id = 6,
                title = "Налог на недвижимость",
                amount = 15000.0,
                dueDate = today.plusDays(25),
                category = "HOUSING",
                description = "Земельный налог",
                source = ExpenseSource.EMAIL,
            ),
            UpcomingExpense(
                id = 7,
                title = "Отпуск - билеты",
                amount = 45000.0,
                dueDate = today.plusDays(30),
                category = "ENTERTAINMENT",
                description = "Авиабилеты Алматы-Астана",
                source = ExpenseSource.MANUAL,
            ),
        )
    }

    fun getMockRecurringExpenses(): List<RecurringExpense> {
        val today = LocalDate.now()
        return listOf(
            RecurringExpense(
                id = 1,
                title = "Netflix",
                amount = 999.0,
                category = "ENTERTAINMENT",
                description = "Подписка на фильмы",
                frequency = RecurringFrequency.MONTHLY,
                startDate = today.minusMonths(6),
                lastPaidDate = today.minusDays(7),
                nextPaymentDate = today.plusDays(23),
                isActive = true,
                source = ExpenseSource.MANUAL,
            ),
            RecurringExpense(
                id = 2,
                title = "Spotify",
                amount = 449.0,
                category = "ENTERTAINMENT",
                description = "Музыка",
                frequency = RecurringFrequency.MONTHLY,
                startDate = today.minusMonths(12),
                lastPaidDate = today.minusDays(15),
                nextPaymentDate = today.plusDays(15),
                isActive = true,
                source = ExpenseSource.MANUAL,
            ),
            RecurringExpense(
                id = 3,
                title = "МТС",
                amount = 650.0,
                category = "UTILITIES",
                description = "Мобильная связь",
                frequency = RecurringFrequency.MONTHLY,
                startDate = today.minusYears(2),
                lastPaidDate = today.minusDays(14),
                nextPaymentDate = today.plusDays(16),
                isActive = true,
                source = ExpenseSource.MANUAL,
            ),
            RecurringExpense(
                id = 4,
                title = "YouTube Premium",
                amount = 299.0,
                category = "ENTERTAINMENT",
                description = "Без рекламы",
                frequency = RecurringFrequency.MONTHLY,
                startDate = today.minusMonths(3),
                lastPaidDate = today.minusDays(20),
                nextPaymentDate = today.plusDays(10),
                isActive = true,
                source = ExpenseSource.MANUAL,
            ),
            RecurringExpense(
                id = 5,
                title = "Яндекс Плюс",
                amount = 399.0,
                category = "ENTERTAINMENT",
                description = "Подписка на такси, музыку, кино",
                frequency = RecurringFrequency.MONTHLY,
                startDate = today.minusMonths(8),
                lastPaidDate = today.minusDays(60),
                nextPaymentDate = today.minusDays(30),
                isActive = true,
                source = ExpenseSource.MANUAL,
            ),
            RecurringExpense(
                id = 6,
                title = "VK Music",
                amount = 149.0,
                category = "ENTERTAINMENT",
                description = "Музыка ВКонтакте",
                frequency = RecurringFrequency.MONTHLY,
                startDate = today.minusMonths(18),
                lastPaidDate = today.minusDays(90),
                nextPaymentDate = today.minusDays(60),
                isActive = true,
                source = ExpenseSource.MANUAL,
            ),
            RecurringExpense(
                id = 7,
                title = "Облако Mail.ru",
                amount = 99.0,
                category = "UTILITIES",
                description = "Хранение данных",
                frequency = RecurringFrequency.MONTHLY,
                startDate = today.minusYears(1),
                lastPaidDate = today.minusMonths(3),
                nextPaymentDate = today.minusMonths(2),
                isActive = true,
                source = ExpenseSource.MANUAL,
            ),
        )
    }

    fun getMockCsvContent(): String {
        return """date;title;amount;category;description
${LocalDate.now().minusDays(1)};Пятёрочка;2500;FOOD;Продукты
${LocalDate.now().minusDays(2)};Яндекс Такси;850;TRANSPORT;Поездка
${LocalDate.now().minusDays(3)};Сбербанк;15000;HOUSING;Аренда
${LocalDate.now().minusDays(5)};Мосэнергосбыт;3200;UTILITIES;Электричество
${LocalDate.now().minusDays(7)};Netflix;999;SUBSCRIPTION;Подписка"""
    }
}
