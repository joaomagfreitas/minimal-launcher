package link.joaomagfreitas.minimal_launcher.usecases

import link.joaomagfreitas.minimal_launcher.models.LauncherAppListItemModel
import link.joaomagfreitas.minimal_launcher.repositories.DeviceRepository
import link.joaomagfreitas.minimal_launcher.repositories.LauncherRepository

class GetLauncherAppList(
    private val deviceRepository: DeviceRepository,
    private val launcherRepository: LauncherRepository,
) {
    suspend operator fun invoke(): List<LauncherAppListItemModel> {
        return launcherRepository.getAppList()
    }
}