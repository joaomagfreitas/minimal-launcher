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
import androidx.compose.ui.platform.LocalLocale
import androidx.compose.ui.tooling.preview.Preview
import java.text.SimpleDateFormat
import java.util.Date
import kotlin.time.Duration.Companion.milliseconds
import kotlinx.coroutines.delay
import kotlinx.coroutines.isActive
import link.joaomagfreitas.minimal_launcher.ui.theme.neutral

private const val MINUTE_IN_MS = 60_000L

@Composable
fun DateTimeDisplay() {
  var date by remember { mutableStateOf(Date()) }
  val locale = LocalLocale.current.platformLocale
  val timeFormatter = SimpleDateFormat("HH:mm", locale)
  val dateFormatter = SimpleDateFormat("EEEE, MMM d", locale)

  LaunchedEffect(Unit) {
    while (isActive) {
      val now = System.currentTimeMillis()
      val delayUntilNextMinute = MINUTE_IN_MS - (now % MINUTE_IN_MS)

      delay(delayUntilNextMinute.milliseconds)
      date = Date()
    }
  }

  return Column {
    Text(
        timeFormatter.format(date),
        style = MaterialTheme.typography.headlineLarge,
    )

    Text(
        dateFormatter.format(date).uppercase(),
        style = MaterialTheme.typography.labelSmall,
        color = neutral,
    )
  }
}

@Composable
@Preview
private fun DateTimeDisplayPreview() {
  DateTimeDisplay()
}
