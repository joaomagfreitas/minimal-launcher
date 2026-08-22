package link.joaomagfreitas.minimal_launcher.ui.composables

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.tooling.preview.Preview
import kotlinx.coroutines.delay
import kotlinx.coroutines.isActive
import link.joaomagfreitas.minimal_launcher.ui.theme.neutral
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale
import kotlin.time.Duration.Companion.milliseconds

@Composable
@Preview
fun DateTimeDisplay() {
    var date by remember { mutableStateOf(Date()) }
    val timeFormatter = SimpleDateFormat("HH:mm", Locale.getDefault())
    val dateFormatter = SimpleDateFormat("EEEE, MMM d", Locale.getDefault())

    LaunchedEffect(Unit) {
        while (isActive) {
            val now = System.currentTimeMillis()
            val delayUntilNextMinute = 60_000L - (now % 60_000L)

            delay(delayUntilNextMinute.milliseconds)
            date = Date()
        }
    }

    return Column {
        Text(
            timeFormatter.format(date),
            style = MaterialTheme.typography.headlineLarge
        )

        Text(
            dateFormatter.format(date).uppercase(),
            style = MaterialTheme.typography.labelSmall,
            color = neutral
        )
    }
}