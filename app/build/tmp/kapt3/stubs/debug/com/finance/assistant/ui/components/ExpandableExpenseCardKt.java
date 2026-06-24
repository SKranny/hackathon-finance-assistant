package com.finance.assistant.ui.components;

@kotlin.Metadata(mv = {1, 9, 0}, k = 2, xi = 48, d1 = {"\u0000>\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u001aL\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u0014\b\u0002\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00010\u00072\u001a\b\u0002\u0010\t\u001a\u0014\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u00010\nH\u0007\u001a&\u0010\r\u001a\u00020\u00012\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000f2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00010\u0012H\u0003\u001a&\u0010\u0013\u001a\u00020\u00012\u0006\u0010\u0014\u001a\u00020\u000b2\u0006\u0010\u0015\u001a\u00020\f2\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00010\u0012H\u0003\u001a>\u0010\u0017\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0012\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00010\u00072\u0018\u0010\t\u001a\u0014\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u00010\nH\u0003\u00a8\u0006\u0019"}, d2 = {"ExpandableExpenseCard", "", "expense", "Lcom/finance/assistant/domain/model/alert/ScheduledExpenseCase;", "modifier", "Landroidx/compose/ui/Modifier;", "onResolveCase", "Lkotlin/Function1;", "Lcom/finance/assistant/domain/model/alert/CaseResolution;", "onStartSavingsPlan", "Lkotlin/Function2;", "Lcom/finance/assistant/domain/model/alert/SavingsRecommendation;", "", "ResolutionButton", "title", "", "description", "onClick", "Lkotlin/Function0;", "SavingsRecommendationSection", "recommendation", "targetAmount", "onStartPlan", "ScheduledExpenseDetails", "onResolve", "app_debug"})
public final class ExpandableExpenseCardKt {
    
    @androidx.compose.runtime.Composable()
    public static final void ExpandableExpenseCard(@org.jetbrains.annotations.NotNull()
    com.finance.assistant.domain.model.alert.ScheduledExpenseCase expense, @org.jetbrains.annotations.NotNull()
    androidx.compose.ui.Modifier modifier, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super com.finance.assistant.domain.model.alert.CaseResolution, kotlin.Unit> onResolveCase, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function2<? super com.finance.assistant.domain.model.alert.SavingsRecommendation, ? super java.lang.Double, kotlin.Unit> onStartSavingsPlan) {
    }
    
    @androidx.compose.runtime.Composable()
    private static final void ScheduledExpenseDetails(com.finance.assistant.domain.model.alert.ScheduledExpenseCase expense, kotlin.jvm.functions.Function1<? super com.finance.assistant.domain.model.alert.CaseResolution, kotlin.Unit> onResolve, kotlin.jvm.functions.Function2<? super com.finance.assistant.domain.model.alert.SavingsRecommendation, ? super java.lang.Double, kotlin.Unit> onStartSavingsPlan) {
    }
    
    @androidx.compose.runtime.Composable()
    private static final void ResolutionButton(java.lang.String title, java.lang.String description, kotlin.jvm.functions.Function0<kotlin.Unit> onClick) {
    }
    
    @androidx.compose.runtime.Composable()
    private static final void SavingsRecommendationSection(com.finance.assistant.domain.model.alert.SavingsRecommendation recommendation, double targetAmount, kotlin.jvm.functions.Function0<kotlin.Unit> onStartPlan) {
    }
}