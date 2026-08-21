package link.joaomagfreitas.minimal_launcher.usecases

import link.joaomagfreitas.minimal_launcher.models.DeviceAppModel
import link.joaomagfreitas.minimal_launcher.repositories.DeviceRepository

class GetDeviceAppList(
    private val repository: DeviceRepository,
) {
    suspend operator fun invoke(): List<DeviceAppModel> {
        return repository.queryApps()
    }
}