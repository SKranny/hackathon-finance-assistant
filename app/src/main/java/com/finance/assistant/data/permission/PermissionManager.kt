package com.finance.assistant.data.permission

import android.Manifest
import android.content.Context
import android.content.pm.PackageManager
import android.os.Build
import androidx.core.content.ContextCompat
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject
import javax.inject.Singleton

data class PermissionState(
    val permission: String,
    val isGranted: Boolean,
    val isDenied: Boolean,
    val isPermanentlyDenied: Boolean = false,
    val grantedAt: Long? = null,
)

@Singleton
class PermissionManager @Inject constructor(
    @ApplicationContext private val context: Context,
) {

    private val _permissionStates = MutableStateFlow<Map<String, PermissionState>>(emptyMap())
    val permissionStates: StateFlow<Map<String, PermissionState>> = _permissionStates.asStateFlow()

    private val _allPermissionsGranted = MutableStateFlow(false)
    val allPermissionsGranted: StateFlow<Boolean> = _allPermissionsGranted.asStateFlow()

    val requiredPermissions: List<PermissionRequirement> = listOf(
        PermissionRequirement(
            permission = Manifest.permission.READ_SMS,
            title = "Доступ к SMS",
            description = "Для автоматического сканирования финансовых SMS-уведомлений",
            isOptional = true,
            requiredFor = listOf("sms_scanning"),
        ),
        PermissionRequirement(
            permission = Manifest.permission.READ_CALENDAR,
            title = "Доступ к календарю",
            description = "Для отслеживания запланированных платежей",
            isOptional = true,
            requiredFor = listOf("calendar_events"),
        ),
        PermissionRequirement(
            permission = Manifest.permission.POST_NOTIFICATIONS,
            title = "Уведомления",
            description = "Для отправки напоминаний о платежах",
            isOptional = true,
            requiredFor = listOf("notifications"),
        ),
    )

    init {
        refreshPermissionStates()
    }

    fun refreshPermissionStates() {
        val states = mutableMapOf<String, PermissionState>()

        requiredPermissions.forEach { requirement ->
            states[requirement.permission] = getPermissionState(requirement.permission)
        }

        _permissionStates.value = states
        updateAllGrantedState()
    }

    private fun getPermissionState(permission: String): PermissionState {
        val isGranted = ContextCompat.checkSelfPermission(context, permission) == PackageManager.PERMISSION_GRANTED

        return PermissionState(
            permission = permission,
            isGranted = isGranted,
            isDenied = !isGranted,
        )
    }

    private fun updateAllGrantedState() {
        val criticalPermissions = requiredPermissions.filter { !it.isOptional }
        _allPermissionsGranted.value = criticalPermissions.all { req ->
            ContextCompat.checkSelfPermission(context, req.permission) == PackageManager.PERMISSION_GRANTED
        }
    }

    fun isPermissionGranted(permission: String): Boolean {
        return ContextCompat.checkSelfPermission(context, permission) == PackageManager.PERMISSION_GRANTED
    }

    fun getMissingRequiredPermissions(): List<PermissionRequirement> {
        return requiredPermissions.filter { req ->
            !req.isOptional && !isPermissionGranted(req.permission)
        }
    }

    fun getGrantedOptionalPermissions(): List<PermissionRequirement> {
        return requiredPermissions.filter { req ->
            req.isOptional && isPermissionGranted(req.permission)
        }
    }

    fun onPermissionResult(permission: String, granted: Boolean) {
        val currentStates = _permissionStates.value.toMutableMap()
        currentStates[permission] = PermissionState(
            permission = permission,
            isGranted = granted,
            isDenied = !granted,
            grantedAt = if (granted) System.currentTimeMillis() else null,
        )
        _permissionStates.value = currentStates
        updateAllGrantedState()
    }

    fun getFeaturePermissions(feature: String): List<String> {
        return requiredPermissions
            .filter { it.requiredFor.contains(feature) }
            .map { it.permission }
    }

    fun isFeatureAvailable(feature: String): Boolean {
        val requiredPerms = getFeaturePermissions(feature)
        if (requiredPerms.isEmpty()) return true

        return requiredPerms.all { perm ->
            !requiredPermissions.find { it.permission == perm }!!.isOptional ||
            isPermissionGranted(perm)
        }
    }

    fun getConsentHistory(): List<ConsentRecord> {
        val states = _permissionStates.value
        return states.values
            .filter { it.grantedAt != null }
            .map { state ->
                ConsentRecord(
                    permission = state.permission,
                    grantedAt = state.grantedAt!!,
                    feature = requiredPermissions.find { it.permission == state.permission }?.title ?: state.permission,
                )
            }
    }

    fun hasExplicitConsent(permission: String): Boolean {
        return _permissionStates.value[permission]?.grantedAt != null
    }
}

data class PermissionRequirement(
    val permission: String,
    val title: String,
    val description: String,
    val isOptional: Boolean,
    val requiredFor: List<String>,
)

data class ConsentRecord(
    val permission: String,
    val grantedAt: Long,
    val feature: String,
)
