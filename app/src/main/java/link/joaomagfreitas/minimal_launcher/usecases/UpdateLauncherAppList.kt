package link.joaomagfreitas.minimal_launcher.usecases

import link.joaomagfreitas.minimal_launcher.models.LauncherAppListItemModel
import link.joaomagfreitas.minimal_launcher.repositories.LauncherRepository

class UpdateLauncherAppList(
    private val repository: LauncherRepository
) {
    suspend fun invoke(items: List<LauncherAppListItemModel>) {
        repository.updateAppList(items)
    }
}