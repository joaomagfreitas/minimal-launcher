package link.joaomagfreitas.minimal_launcher.repositories

import android.content.Context
import android.content.Intent
import link.joaomagfreitas.minimal_launcher.models.DeviceAppModel

interface DeviceRepository {
    suspend fun queryApps(): List<DeviceAppModel>
}

class IpcDeviceRepository(
    private val context: Context,
) : DeviceRepository {
    override suspend fun queryApps(): List<DeviceAppModel> {
        val intent = Intent(Intent.ACTION_MAIN).apply {
            addCategory(Intent.CATEGORY_LAUNCHER)
        }

        return context
            .packageManager
            .queryIntentActivities(intent, 0)
            .map { info ->
                DeviceAppModel(
                    label = info.loadLabel(context.packageManager).toString(),
                    packageName = info.activityInfo.packageName,
                    activityName = info.activityInfo.name,
                )
            }
    }
}