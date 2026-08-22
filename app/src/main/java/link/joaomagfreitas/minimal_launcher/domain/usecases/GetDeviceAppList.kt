package link.joaomagfreitas.minimal_launcher.domain.usecases

import link.joaomagfreitas.minimal_launcher.data.models.DeviceAppModel
import link.joaomagfreitas.minimal_launcher.data.repositories.DeviceRepository

class GetDeviceAppList(
    private val repository: DeviceRepository,
) {
    suspend operator fun invoke(): List<DeviceAppModel> = repository.queryApps()
}
