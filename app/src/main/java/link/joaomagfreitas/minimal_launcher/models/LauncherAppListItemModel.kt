package link.joaomagfreitas.minimal_launcher.models

import kotlinx.serialization.Serializable

@Serializable
data class LauncherAppListItemModel(
    val order: Int,
    val enabled: Boolean,
    val app: DeviceAppModel
)
