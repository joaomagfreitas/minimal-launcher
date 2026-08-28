package link.joaomagfreitas.minimal_launcher.data.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import kotlinx.serialization.Serializable

@Serializable
@Parcelize
data class LauncherAppListItemModel(
    val order: Int,
    val enabled: Boolean,
    val app: DeviceAppModel,
) : Parcelable
