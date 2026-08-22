package link.joaomagfreitas.minimal_launcher.domain.usecases

import link.joaomagfreitas.minimal_launcher.data.models.DeviceAppModel
import link.joaomagfreitas.minimal_launcher.data.repositories.DeviceRepository

class OpenApp(
    private val repository: DeviceRepository,
) {
    suspend operator fun invoke(app: DeviceAppModel) {
        repository.openApp(app)
    }
}
