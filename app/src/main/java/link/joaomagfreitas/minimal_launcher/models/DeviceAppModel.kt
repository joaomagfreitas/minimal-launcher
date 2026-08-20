package link.joaomagfreitas.minimal_launcher.models

import kotlinx.serialization.Serializable

@Serializable
data class DeviceAppModel(
    val label: String,
    val packageName: String,
    val activityName: String,
)
