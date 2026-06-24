package com.finance.assistant.data.permission;

@javax.inject.Singleton()
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00180\u0013J\u0014\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\n0\u00132\u0006\u0010\u001a\u001a\u00020\nJ\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013J\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013J\u0010\u0010\u001d\u001a\u00020\u000b2\u0006\u0010\u001e\u001a\u00020\nH\u0002J\u000e\u0010\u001f\u001a\u00020\u00072\u0006\u0010\u001e\u001a\u00020\nJ\u000e\u0010 \u001a\u00020\u00072\u0006\u0010\u001a\u001a\u00020\nJ\u000e\u0010!\u001a\u00020\u00072\u0006\u0010\u001e\u001a\u00020\nJ\u0016\u0010\"\u001a\u00020#2\u0006\u0010\u001e\u001a\u00020\n2\u0006\u0010$\u001a\u00020\u0007J\u0006\u0010%\u001a\u00020#J\b\u0010&\u001a\u00020#H\u0002R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R \u0010\b\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\t0\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00070\r\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R#\u0010\u0010\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\t0\r\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000fR\u0017\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016\u00a8\u0006\'"}, d2 = {"Lcom/finance/assistant/data/permission/PermissionManager;", "", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "_allPermissionsGranted", "Lkotlinx/coroutines/flow/MutableStateFlow;", "", "_permissionStates", "", "", "Lcom/finance/assistant/data/permission/PermissionState;", "allPermissionsGranted", "Lkotlinx/coroutines/flow/StateFlow;", "getAllPermissionsGranted", "()Lkotlinx/coroutines/flow/StateFlow;", "permissionStates", "getPermissionStates", "requiredPermissions", "", "Lcom/finance/assistant/data/permission/PermissionRequirement;", "getRequiredPermissions", "()Ljava/util/List;", "getConsentHistory", "Lcom/finance/assistant/data/permission/ConsentRecord;", "getFeaturePermissions", "feature", "getGrantedOptionalPermissions", "getMissingRequiredPermissions", "getPermissionState", "permission", "hasExplicitConsent", "isFeatureAvailable", "isPermissionGranted", "onPermissionResult", "", "granted", "refreshPermissionStates", "updateAllGrantedState", "app_debug"})
public final class PermissionManager {
    @org.jetbrains.annotations.NotNull()
    private final android.content.Context context = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.MutableStateFlow<java.util.Map<java.lang.String, com.finance.assistant.data.permission.PermissionState>> _permissionStates = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<java.util.Map<java.lang.String, com.finance.assistant.data.permission.PermissionState>> permissionStates = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.MutableStateFlow<java.lang.Boolean> _allPermissionsGranted = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<java.lang.Boolean> allPermissionsGranted = null;
    @org.jetbrains.annotations.NotNull()
    private final java.util.List<com.finance.assistant.data.permission.PermissionRequirement> requiredPermissions = null;
    
    @javax.inject.Inject()
    public PermissionManager(@dagger.hilt.android.qualifiers.ApplicationContext()
    @org.jetbrains.annotations.NotNull()
    android.content.Context context) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<java.util.Map<java.lang.String, com.finance.assistant.data.permission.PermissionState>> getPermissionStates() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<java.lang.Boolean> getAllPermissionsGranted() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<com.finance.assistant.data.permission.PermissionRequirement> getRequiredPermissions() {
        return null;
    }
    
    public final void refreshPermissionStates() {
    }
    
    private final com.finance.assistant.data.permission.PermissionState getPermissionState(java.lang.String permission) {
        return null;
    }
    
    private final void updateAllGrantedState() {
    }
    
    public final boolean isPermissionGranted(@org.jetbrains.annotations.NotNull()
    java.lang.String permission) {
        return false;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<com.finance.assistant.data.permission.PermissionRequirement> getMissingRequiredPermissions() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<com.finance.assistant.data.permission.PermissionRequirement> getGrantedOptionalPermissions() {
        return null;
    }
    
    public final void onPermissionResult(@org.jetbrains.annotations.NotNull()
    java.lang.String permission, boolean granted) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<java.lang.String> getFeaturePermissions(@org.jetbrains.annotations.NotNull()
    java.lang.String feature) {
        return null;
    }
    
    public final boolean isFeatureAvailable(@org.jetbrains.annotations.NotNull()
    java.lang.String feature) {
        return false;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<com.finance.assistant.data.permission.ConsentRecord> getConsentHistory() {
        return null;
    }
    
    public final boolean hasExplicitConsent(@org.jetbrains.annotations.NotNull()
    java.lang.String permission) {
        return false;
    }
}