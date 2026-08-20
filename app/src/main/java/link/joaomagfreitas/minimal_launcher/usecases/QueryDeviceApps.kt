package link.joaomagfreitas.minimal_launcher.usecases

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import link.joaomagfreitas.minimal_launcher.models.DeviceAppModel
import link.joaomagfreitas.minimal_launcher.repositories.DeviceRepository

class QueryDeviceApps(
    private val repository: DeviceRepository,
) {
    fun invoke(): Flow<List<DeviceAppModel>> {
        return flow {
            emit(
                repository.queryApps()
            )
        }
    }
}