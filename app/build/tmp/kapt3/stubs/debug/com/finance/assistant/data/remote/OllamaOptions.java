package com.finance.assistant.data.remote;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0002\b\u0014\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B1\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\u0002\u0010\bJ\t\u0010\u0013\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0014\u001a\u00020\u0005H\u00c6\u0003J\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003\u00a2\u0006\u0002\u0010\u0011J\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003\u00a2\u0006\u0002\u0010\u000eJ:\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005H\u00c6\u0001\u00a2\u0006\u0002\u0010\u0018J\u0013\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u001c\u001a\u00020\u0005H\u00d6\u0001J\t\u0010\u001d\u001a\u00020\u001eH\u00d6\u0001R\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0015\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\r\u0010\u000eR\u0015\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b\u0010\u0010\u0011\u00a8\u0006\u001f"}, d2 = {"Lcom/finance/assistant/data/remote/OllamaOptions;", "", "temperature", "", "numPredict", "", "top_p", "top_k", "(FILjava/lang/Float;Ljava/lang/Integer;)V", "getNumPredict", "()I", "getTemperature", "()F", "getTop_k", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getTop_p", "()Ljava/lang/Float;", "Ljava/lang/Float;", "component1", "component2", "component3", "component4", "copy", "(FILjava/lang/Float;Ljava/lang/Integer;)Lcom/finance/assistant/data/remote/OllamaOptions;", "equals", "", "other", "hashCode", "toString", "", "app_debug"})
public final class OllamaOptions {
    private final float temperature = 0.0F;
    @com.google.gson.annotations.SerializedName(value = "num_predict")
    private final int numPredict = 0;
    @org.jetbrains.annotations.Nullable()
    private final java.lang.Float top_p = null;
    @org.jetbrains.annotations.Nullable()
    private final java.lang.Integer top_k = null;
    
    public final float component1() {
        return 0.0F;
    }
    
    public final int component2() {
        return 0;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Float component3() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Integer component4() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.finance.assistant.data.remote.OllamaOptions copy(float temperature, int numPredict, @org.jetbrains.annotations.Nullable()
    java.lang.Float top_p, @org.jetbrains.annotations.Nullable()
    java.lang.Integer top_k) {
        return null;
    }
    
    @java.lang.Override()
    public boolean equals(@org.jetbrains.annotations.Nullable()
    java.lang.Object other) {
        return false;
    }
    
    @java.lang.Override()
    public int hashCode() {
        return 0;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public java.lang.String toString() {
        return null;
    }
    
    public OllamaOptions(float temperature, int numPredict, @org.jetbrains.annotations.Nullable()
    java.lang.Float top_p, @org.jetbrains.annotations.Nullable()
    java.lang.Integer top_k) {
        super();
    }
    
    public final float getTemperature() {
        return 0.0F;
    }
    
    public final int getNumPredict() {
        return 0;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Float getTop_p() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Integer getTop_k() {
        return null;
    }
    
    public OllamaOptions() {
        super();
    }
}