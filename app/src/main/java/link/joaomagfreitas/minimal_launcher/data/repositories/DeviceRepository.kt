package link.joaomagfreitas.minimal_launcher.data.repositories

import android.app.Activity
import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.content.Intent.FLAG_ACTIVITY_NEW_TASK
import android.content.pm.PackageManager
import link.joaomagfreitas.minimal_launcher.data.models.DeviceAppModel

interface DeviceRepository {
    suspend fun queryApps(): List<DeviceAppModel>
    suspend fun openApp(app: DeviceAppModel)
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
            .queryIntentActivities(intent, PackageManager.MATCH_ALL)
            .map { info ->
                DeviceAppModel(
                    label = info.loadLabel(context.packageManager).toString(),
                    packageName = info.activityInfo.packageName,
                    activityName = info.activityInfo.name,
                )
            }
    }

    override suspend fun openApp(app: DeviceAppModel) {
        val intent = Intent().apply {
            component = ComponentName(
                app.packageName,
                app.activityName,
            )

            if(context !is Activity) {
                setFlags(FLAG_ACTIVITY_NEW_TASK)
            }
        }

        context.startActivity(intent)
    }
}