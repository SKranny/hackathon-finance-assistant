package com.finance.assistant.ui.navigation

sealed class Screen(val route: String) {
    data object Home : Screen("home")
    data object Feed : Screen("feed")
    data object Assistant : Screen("assistant")
    data object Forecast : Screen("forecast")
    data object CashGapDetail : Screen("cash_gap_detail")
    data object ReschedulePayment : Screen("reschedule_payment")
    data object PaymentConfirmation : Screen("payment_confirmation")

    fun createRoute(vararg args: Pair<String, String>): String {
        if (args.isEmpty()) return route
        val queryString = args.joinToString("&") { "${it.first}=${it.second}" }
        return "$route?$queryString"
    }

    companion object {
        const val ARG_INITIAL_TEXT = "initial_text"
    }
}
