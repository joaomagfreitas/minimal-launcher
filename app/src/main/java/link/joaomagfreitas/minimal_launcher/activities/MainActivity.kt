package link.joaomagfreitas.minimal_launcher.activities

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import link.joaomagfreitas.minimal_launcher.composables.AppScaffold
import link.joaomagfreitas.minimal_launcher.composables.DateTimeDisplay

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {
            AppScaffold { innerPadding ->
                DateTimeDisplay()
            }
        }
    }
}