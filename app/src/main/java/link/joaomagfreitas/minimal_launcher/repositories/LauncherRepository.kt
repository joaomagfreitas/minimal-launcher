package link.joaomagfreitas.minimal_launcher.repositories

import android.content.Context
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import kotlinx.serialization.json.Json
import link.joaomagfreitas.minimal_launcher.models.LauncherAppListItemModel
import java.io.File

interface LauncherRepository {
    suspend fun getAppList(): Result<List<LauncherAppListItemModel>>
    suspend fun updateAppList(items: List<LauncherAppListItemModel>)
}

class InternalStorageLauncherRepository(
    private val context: Context,
) : LauncherRepository {
    override suspend fun getAppList(): Result<List<LauncherAppListItemModel>> {
        return runCatching {
            withContext(Dispatchers.IO) {
                val file = appsListJsonFile
                Json.decodeFromString(file.readText())
            }
        }
    }

    override suspend fun updateAppList(items: List<LauncherAppListItemModel>) {
        withContext(Dispatchers.IO) {
            val file = appsListJsonFile
            file.writeText(Json.encodeToString(items))
        }
    }

    private val appsListJsonFile: File
        get() = File(context.filesDir, "launcher_apps.json")
}