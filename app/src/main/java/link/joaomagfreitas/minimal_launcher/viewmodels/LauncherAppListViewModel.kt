package link.joaomagfreitas.minimal_launcher.viewmodels

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import link.joaomagfreitas.minimal_launcher.models.DeviceAppModel
import link.joaomagfreitas.minimal_launcher.models.LauncherAppListItemModel
import link.joaomagfreitas.minimal_launcher.state.LauncherAppListState
import link.joaomagfreitas.minimal_launcher.usecases.GetDeviceAppList
import link.joaomagfreitas.minimal_launcher.usecases.GetLauncherAppList
import link.joaomagfreitas.minimal_launcher.usecases.OpenApp
import link.joaomagfreitas.minimal_launcher.usecases.UpdateLauncherAppList

class LauncherAppListViewModel(
    private val openApp: OpenApp,
    private val getDeviceAppList: GetDeviceAppList,
    private val getLauncherAppList: GetLauncherAppList,
    private val updateLauncherAppList: UpdateLauncherAppList,
    private val scope: CoroutineScope,
) : ViewModel(scope) {
    val state = mutableStateOf<LauncherAppListState>(
        LauncherAppListState.Loading(listOf())
    )

    fun load() {
        scope.launch {
            val appListResult = runCatching { getLauncherAppList() }
            if (appListResult.isSuccess) {
                state.value = LauncherAppListState.Loaded(appListResult.getOrThrow())
                synchronize()
                return@launch
            }

            state.value = LauncherAppListState.Failure(
                items = state.value.items,
                error = Error(appListResult.exceptionOrNull())
            )
        }
    }

    fun update(items: List<LauncherAppListItemModel>) {
        scope.launch {
            updateLauncherAppList(items)
        }
    }

    fun synchronize() {
        val items = state.value.items

        scope.launch {
            val deviceAppListResult = runCatching { getDeviceAppList() }
            if (deviceAppListResult.isSuccess) {
                val synchronizedItems = deviceAppListResult.getOrThrow().mapIndexed { idx, app ->
                    val existingItem = items.find { it.app == app }
                    if (existingItem != null) {
                        return@mapIndexed existingItem
                    }

                    return@mapIndexed LauncherAppListItemModel(
                        order = -1,
                        enabled = true,
                        app = app
                    )
                }.sortedBy { it.order }

                state.value = LauncherAppListState.Synchronized(synchronizedItems)
                update(items)
                return@launch
            }

            state.value = LauncherAppListState.Failure(
                items = state.value.items,
                error = Error(deviceAppListResult.exceptionOrNull())
            )
        }
    }

    fun open(app: DeviceAppModel) {
        scope.launch {
            openApp(app)
        }
    }
}