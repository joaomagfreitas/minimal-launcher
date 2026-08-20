package link.joaomagfreitas.minimal_launcher.usecases

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import link.joaomagfreitas.minimal_launcher.models.LauncherAppListItemModel
import link.joaomagfreitas.minimal_launcher.repositories.DeviceRepository
import link.joaomagfreitas.minimal_launcher.repositories.LauncherRepository

class GetLauncherAppList(
    private val deviceRepository: DeviceRepository,
    private val launcherRepository: LauncherRepository,
) {
    fun invoke(): Flow<List<LauncherAppListItemModel>> {
        return flow {
            val listResult = launcherRepository.getAppList()
            if (listResult.isSuccess) {
                emit(listResult.getOrThrow())
                return@flow
            }

            val queryResult = deviceRepository.queryApps()
            if (queryResult.isSuccess) {
                val items = queryResult.getOrThrow().mapIndexed { idx, app ->
                    LauncherAppListItemModel(
                        order = idx,
                        enabled = true,
                        app = app
                    )
                }

                emit(items)
                launcherRepository.updateAppList(items)
                return@flow
            }

            // TODO: handle errors
        }
    }
}