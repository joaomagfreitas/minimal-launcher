package link.joaomagfreitas.minimal_launcher.ui.state

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import kotlinx.serialization.Serializable
import link.joaomagfreitas.minimal_launcher.data.models.LauncherAppListItemModel

@Serializable
@Parcelize
sealed class LauncherAppListState(
    open val items: List<LauncherAppListItemModel>,
    open val synchronized: Boolean,
) : Parcelable {
  val noAppsEnabled: Boolean
    get() = this is Loaded && !items.any { it.enabled }

  val noAppsLoaded: Boolean
    get() = items.isEmpty()

  data class Loading(
      override val items: List<LauncherAppListItemModel>,
      override val synchronized: Boolean,
  ) : LauncherAppListState(items, synchronized)

  data class Loaded(
      override val items: List<LauncherAppListItemModel>,
      override val synchronized: Boolean,
  ) : LauncherAppListState(items, synchronized)

  data class Failure(
      override val items: List<LauncherAppListItemModel>,
      override val synchronized: Boolean,
      val error: Error,
  ) : LauncherAppListState(items, synchronized)
}
