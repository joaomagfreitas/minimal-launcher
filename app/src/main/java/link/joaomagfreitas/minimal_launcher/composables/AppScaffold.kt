package link.joaomagfreitas.minimal_launcher.composables

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import link.joaomagfreitas.minimal_launcher.ui.theme.MinimalLauncherTheme

@Composable
fun AppScaffold(
    content: @Composable ((PaddingValues) -> Unit)
) {
    MinimalLauncherTheme {
        Scaffold(modifier = Modifier.fillMaxSize(), content = content)
    }
}