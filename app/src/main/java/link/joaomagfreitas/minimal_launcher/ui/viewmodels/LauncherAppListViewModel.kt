package link.joaomagfreitas.minimal_launcher.ui.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import link.joaomagfreitas.minimal_launcher.data.models.DeviceAppModel
import link.joaomagfreitas.minimal_launcher.data.models.LauncherAppListItemModel
import link.joaomagfreitas.minimal_launcher.di.locator
import link.joaomagfreitas.minimal_launcher.domain.state.LauncherAppListState
import link.joaomagfreitas.minimal_launcher.domain.usecases.GetDeviceAppList
import link.joaomagfreitas.minimal_launcher.domain.usecases.GetLauncherAppList
import link.joaomagfreitas.minimal_launcher.domain.usecases.OpenApp
import link.joaomagfreitas.minimal_launcher.domain.usecases.UpdateLauncherAppList

class LauncherAppListViewModel(
    private val openApp: OpenApp,
    private val getDeviceAppList: GetDeviceAppList,
    private val getLauncherAppList: GetLauncherAppList,
    private val updateLauncherAppList: UpdateLauncherAppList,
    private val scope: CoroutineScope,
) : ViewModel(scope) {
  val state =
      MutableStateFlow<LauncherAppListState>(
          LauncherAppListState.Loading(listOf()),
      )

  init {
    synchronize()
  }

  fun load() {
    scope.launch {
      val appListResult = runCatching { getLauncherAppList() }
      if (appListResult.isSuccess) {
        state.emit(
            LauncherAppListState.Loaded(appListResult.getOrThrow()),
        )

        synchronize()
        return@launch
      }

      state.emit(
          LauncherAppListState.Failure(
              items = state.value.items,
              error = Error(appListResult.exceptionOrNull()),
          ),
      )
    }
  }

  fun update(items: List<LauncherAppListItemModel>) {
    scope.launch { updateLauncherAppList(items) }
  }

  fun synchronize() {
    val items = state.value.items

    scope.launch {
      val deviceAppListResult = runCatching { getDeviceAppList() }
      if (deviceAppListResult.isSuccess) {
        val synchronizedItems =
            deviceAppListResult
                .getOrThrow()
                .mapIndexed { idx, app ->
                  val existingItem = items.find { it.app == app }
                  if (existingItem != null) {
                    return@mapIndexed existingItem
                  }

                  return@mapIndexed LauncherAppListItemModel(
                      order = -1,
                      enabled = true,
                      app = app,
                  )
                }
                .sortedBy { it.order }

        state.emit(
            LauncherAppListState.Synchronized(synchronizedItems),
        )

        update(items)
        return@launch
      }

      state.emit(
          LauncherAppListState.Failure(
              items = state.value.items,
              error = Error(deviceAppListResult.exceptionOrNull()),
          ),
      )
    }
  }

  fun open(app: DeviceAppModel) {
    scope.launch { openApp(app) }
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
        )
      }
    }
  }
}
