package link.joaomagfreitas.minimal_launcher.usecases

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import link.joaomagfreitas.minimal_launcher.models.DeviceAppModel
import link.joaomagfreitas.minimal_launcher.repositories.DeviceRepository

class OpenApp(
    private val scope: CoroutineScope,
    private val repository: DeviceRepository,
) {
    fun invoke(app: DeviceAppModel) {
        scope.launch {
            repository.openApp(app)
        }
    }
}