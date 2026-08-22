package link.joaomagfreitas.minimal_launcher.domain.usecases

import link.joaomagfreitas.minimal_launcher.data.models.LauncherAppListItemModel
import link.joaomagfreitas.minimal_launcher.data.repositories.LauncherRepository

class UpdateLauncherAppList(
    private val repository: LauncherRepository,
) {
  suspend operator fun invoke(items: List<LauncherAppListItemModel>) {
    repository.updateAppList(items)
  }
}
