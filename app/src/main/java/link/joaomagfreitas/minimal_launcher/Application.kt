package link.joaomagfreitas.minimal_launcher

import android.app.Application
import link.joaomagfreitas.minimal_launcher.data.repositories.InternalStorageLauncherRepository
import link.joaomagfreitas.minimal_launcher.data.repositories.IpcDeviceRepository
import link.joaomagfreitas.minimal_launcher.di.locator
import link.joaomagfreitas.minimal_launcher.domain.usecases.GetDeviceAppList
import link.joaomagfreitas.minimal_launcher.domain.usecases.GetLauncherAppList
import link.joaomagfreitas.minimal_launcher.domain.usecases.OpenApp
import link.joaomagfreitas.minimal_launcher.domain.usecases.UpdateLauncherAppList

class Application : Application() {
  override fun onCreate() {
    super.onCreate()
    register()
  }

  private fun register() {
    val deviceRepository = IpcDeviceRepository(applicationContext)
    val launcherRepository = InternalStorageLauncherRepository(applicationContext)

    locator.store(OpenApp(deviceRepository))
    locator.store(GetDeviceAppList(deviceRepository))
    locator.store(GetLauncherAppList(launcherRepository))
    locator.store(UpdateLauncherAppList(launcherRepository))
  }
}
