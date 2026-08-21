package link.joaomagfreitas.minimal_launcher.state

import link.joaomagfreitas.minimal_launcher.models.LauncherAppListItemModel

sealed class LauncherAppListState(
    open val items: List<LauncherAppListItemModel>
) {
    data class Loading(
        override val items: List<LauncherAppListItemModel>
    ) : LauncherAppListState(items)

    data class Loaded(
        override val items: List<LauncherAppListItemModel>
    ) : LauncherAppListState(items)

    data class Synchronized(
        override val items: List<LauncherAppListItemModel>
    ) : LauncherAppListState(items)

    data class Failure(
        override val items: List<LauncherAppListItemModel>,
        val error: Error,
    ) : LauncherAppListState(items)
}