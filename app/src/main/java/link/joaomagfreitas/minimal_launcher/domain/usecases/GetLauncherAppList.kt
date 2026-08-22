package link.joaomagfreitas.minimal_launcher.domain.usecases

import link.joaomagfreitas.minimal_launcher.data.models.LauncherAppListItemModel
import link.joaomagfreitas.minimal_launcher.data.repositories.LauncherRepository

class GetLauncherAppList(
    private val launcherRepository: LauncherRepository,
) {
  suspend operator fun invoke(): List<LauncherAppListItemModel> = launcherRepository.getAppList()
}
