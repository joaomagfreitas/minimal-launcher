package link.joaomagfreitas.minimal_launcher.ui.wrappers

import android.os.Build
import android.view.Window

fun Window.setTransparentSystemNavigationBar() {
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
        isNavigationBarContrastEnforced = false
    }
}