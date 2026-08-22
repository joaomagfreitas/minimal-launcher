package link.joaomagfreitas.minimal_launcher.ui.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable

@Composable
fun MinimalLauncherTheme(content: @Composable () -> Unit) {
  MaterialTheme(
      colorScheme = monoFocusDarkColorScheme,
      typography = Typography,
      content = content,
  )
}
