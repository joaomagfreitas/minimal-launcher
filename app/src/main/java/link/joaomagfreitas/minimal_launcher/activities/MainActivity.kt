package link.joaomagfreitas.minimal_launcher.activities

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import link.joaomagfreitas.minimal_launcher.ui.screens.LauncherScreen
import link.joaomagfreitas.minimal_launcher.ui.wrappers.setTransparentSystemNavigationBar

class MainActivity : ComponentActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    enableEdgeToEdge()
    window.setTransparentSystemNavigationBar()

    setContent { LauncherScreen() }
  }
}
