package com.finance.assistant.ui.screens;

@kotlin.Metadata(mv = {1, 9, 0}, k = 2, xi = 48, d1 = {"\u00006\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\"\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\tH\u0003\u001a\u0016\u0010\u000b\u001a\u00020\u00052\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\t0\rH\u0003\u001a\u001e\u0010\u000e\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\t2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00050\u0011H\u0003\u001a \u0010\u0012\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\t2\u0006\u0010\u0014\u001a\u00020\t2\u0006\u0010\u0015\u001a\u00020\tH\u0003\u001a6\u0010\u0016\u001a\u00020\u00052\u0006\u0010\u0017\u001a\u00020\t2\u0006\u0010\u0018\u001a\u00020\t2\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\t0\r2\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\tH\u0003\u001a\"\u0010\u001a\u001a\u00020\u00052\b\b\u0002\u0010\u001b\u001a\u00020\u001c2\u000e\b\u0002\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00050\u0011H\u0007\u001a\u0010\u0010\u001e\u001a\u00020\u00052\u0006\u0010\u001f\u001a\u00020\tH\u0003\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T\u00a2\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0082T\u00a2\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0001X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006 "}, d2 = {"BASELINE_Y_DESIGN", "", "CHART_DESIGN_HEIGHT", "CHART_DESIGN_WIDTH", "BalanceForecastChart", "", "modifier", "Landroidx/compose/ui/Modifier;", "gapLabel", "", "salaryLabel", "ChartXAxisLabels", "labels", "", "CloseGapButton", "label", "onClick", "Lkotlin/Function0;", "ForecastAlertCard", "minBalanceLabel", "minBalanceValue", "description", "ForecastChartCard", "title", "minBalance", "xAxisLabels", "ForecastScreen", "viewModel", "Lcom/finance/assistant/ui/screens/viewmodel/ForecastViewModel;", "onNavigateToAssistant", "MinBalanceBadge", "text", "app_debug"})
public final class ForecastScreenKt {
    private static final float CHART_DESIGN_WIDTH = 320.0F;
    private static final float CHART_DESIGN_HEIGHT = 190.0F;
    private static final float BASELINE_Y_DESIGN = 120.0F;
    
    @androidx.compose.runtime.Composable()
    public static final void ForecastScreen(@org.jetbrains.annotations.NotNull()
    com.finance.assistant.ui.screens.viewmodel.ForecastViewModel viewModel, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<kotlin.Unit> onNavigateToAssistant) {
    }
    
    @androidx.compose.runtime.Composable()
    private static final void ForecastChartCard(java.lang.String title, java.lang.String minBalance, java.util.List<java.lang.String> xAxisLabels, java.lang.String gapLabel, java.lang.String salaryLabel) {
    }
    
    @androidx.compose.runtime.Composable()
    private static final void MinBalanceBadge(java.lang.String text) {
    }
    
    @androidx.compose.runtime.Composable()
    private static final void BalanceForecastChart(androidx.compose.ui.Modifier modifier, java.lang.String gapLabel, java.lang.String salaryLabel) {
    }
    
    @androidx.compose.runtime.Composable()
    private static final void ChartXAxisLabels(java.util.List<java.lang.String> labels) {
    }
    
    @androidx.compose.runtime.Composable()
    private static final void ForecastAlertCard(java.lang.String minBalanceLabel, java.lang.String minBalanceValue, java.lang.String description) {
    }
    
    @androidx.compose.runtime.Composable()
    private static final void CloseGapButton(java.lang.String label, kotlin.jvm.functions.Function0<kotlin.Unit> onClick) {
    }
}