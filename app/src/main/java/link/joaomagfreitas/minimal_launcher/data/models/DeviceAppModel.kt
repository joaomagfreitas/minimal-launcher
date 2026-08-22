package link.joaomagfreitas.minimal_launcher.data.models

import kotlinx.serialization.Serializable

@Serializable
data class DeviceAppModel(
    val label: String,
    val packageName: String,
    val activityName: String,
)
