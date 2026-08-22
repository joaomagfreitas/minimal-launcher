package link.joaomagfreitas.minimal_launcher.ui.composables

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import link.joaomagfreitas.minimal_launcher.ui.theme.MinimalLauncherTheme

@Composable
fun AppScaffold(
    defaultPadding: PaddingValues = PaddingValues(16.dp),
    content: @Composable (() -> Unit),
) {
    MinimalLauncherTheme {
        Scaffold(
            modifier = Modifier.fillMaxSize()
        ) { innerPadding ->
            Surface(
                modifier = Modifier
                    .padding(innerPadding)
                    .padding(defaultPadding),
                content = content
            )
        }
    }
}

@Composable
@Preview
fun AppScaffoldPreview() {
    AppScaffold(
        defaultPadding = PaddingValues()
    ) {
        Text("Hello World")
    }
}