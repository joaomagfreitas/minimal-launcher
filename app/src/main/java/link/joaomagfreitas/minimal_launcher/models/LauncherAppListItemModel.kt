package link.joaomagfreitas.minimal_launcher.models

data class LauncherAppListItemModel(
    val order: Int,
    val enabled: Boolean,
    val app: DeviceAppModel
)
