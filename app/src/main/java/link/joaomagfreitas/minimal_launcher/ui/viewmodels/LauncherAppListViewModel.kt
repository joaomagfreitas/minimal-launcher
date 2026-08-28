package link.joaomagfreitas.minimal_launcher.ui.viewmodels

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.createSavedStateHandle
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import link.joaomagfreitas.minimal_launcher.data.models.DeviceAppModel
import link.joaomagfreitas.minimal_launcher.data.models.LauncherAppListItemModel
import link.joaomagfreitas.minimal_launcher.di.locator
import link.joaomagfreitas.minimal_launcher.domain.usecases.GetDeviceAppList
import link.joaomagfreitas.minimal_launcher.domain.usecases.GetLauncherAppList
import link.joaomagfreitas.minimal_launcher.domain.usecases.OpenApp
import link.joaomagfreitas.minimal_launcher.domain.usecases.UpdateLauncherAppList
import link.joaomagfreitas.minimal_launcher.ui.state.LauncherAppListState

class LauncherAppListViewModel(
    private val openApp: OpenApp,
    private val getDeviceAppList: GetDeviceAppList,
    private val getLauncherAppList: GetLauncherAppList,
    private val updateLauncherAppList: UpdateLauncherAppList,
    private val scope: CoroutineScope,
    private val savedStateHandle: SavedStateHandle,
) : ViewModel(scope) {
  val state =
      savedStateHandle.getMutableStateFlow<LauncherAppListState>(
          "state",
          LauncherAppListState.Loading(
              listOf(),
              synchronized = false,
          ),
      )

  init {
    load()
  }

  fun load() {
    scope.launch {
      val launcherAppsResult = runCatching { getLauncherAppList() }
      val deviceAppsResult = runCatching { getDeviceAppList() }

      if (launcherAppsResult.isSuccess && deviceAppsResult.isSuccess) {
        state.emit(
            LauncherAppListState.Loaded(
                merge(
                    items = launcherAppsResult.getOrThrow(),
                    apps = deviceAppsResult.getOrThrow(),
                ),
                synchronized = true,
            ),
        )

        return@launch
      }

      if (launcherAppsResult.isSuccess) {
        state.emit(
            LauncherAppListState.Loaded(
                launcherAppsResult.getOrThrow(),
                synchronized = false,
            )
        )

        return@launch
      }

      if (deviceAppsResult.isSuccess) {
        return@launch update(
            merge(
                items = emptyList(),
                apps = deviceAppsResult.getOrThrow(),
            )
        )
      }

      state.emit(
          LauncherAppListState.Failure(
              items = state.value.items,
              error = Error(deviceAppsResult.exceptionOrNull()),
              synchronized = false,
          )
      )
    }
  }

  fun update(items: List<LauncherAppListItemModel>) {
    scope.launch {
      updateLauncherAppList(items)
      state.emit(
          LauncherAppListState.Loaded(
              items = items,
              synchronized = false,
          )
      )
    }
  }

  fun open(app: DeviceAppModel) {
    scope.launch { openApp(app) }
  }

  private fun merge(
      items: List<LauncherAppListItemModel>,
      apps: List<DeviceAppModel>,
  ): List<LauncherAppListItemModel> {
    val merged = mutableListOf<LauncherAppListItemModel>()
    for (app in apps) {
      val item =
          items.find { it.app == app }
              ?: LauncherAppListItemModel(
                  order = Int.MAX_VALUE,
                  enabled = false,
                  app = app,
              )

      merged.add(item)
    }

    return merged.sortedBy { it.order }
  }

  companion object {
    val Factory: ViewModelProvider.Factory = viewModelFactory {
      initializer {
        LauncherAppListViewModel(
            openApp = locator.get(),
            getDeviceAppList = locator.get(),
            getLauncherAppList = locator.get(),
            updateLauncherAppList = locator.get(),
            scope = CoroutineScope(Dispatchers.Default),
            savedStateHandle = createSavedStateHandle(),
        )
      }
    }
  }
}
