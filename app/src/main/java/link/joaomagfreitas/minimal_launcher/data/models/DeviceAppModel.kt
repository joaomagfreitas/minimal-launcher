package link.joaomagfreitas.minimal_launcher.data.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import kotlinx.serialization.Serializable

@Serializable
@Parcelize
data class DeviceAppModel(
    val label: String,
    val packageName: String,
    val activityName: String,
) : Parcelable
