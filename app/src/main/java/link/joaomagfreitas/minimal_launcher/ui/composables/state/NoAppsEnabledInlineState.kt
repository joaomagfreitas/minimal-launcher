package link.joaomagfreitas.minimal_launcher.ui.composables.state

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import link.joaomagfreitas.minimal_launcher.R

@Composable
fun NoAppsEnabledInlineState(onRequestEditMode: () -> Unit) {
  InlineState(
      icon =
          InlineStateStateIconConfiguration(
              icon = R.drawable.apps_outage_24px,
              tint = MaterialTheme.colorScheme.error,
              contentDescription = stringResource(R.string.content_description_no_apps_enabled),
          ),
      title = stringResource(R.string.inline_state_no_apps_enabled_title),
      description = stringResource(R.string.inline_state_no_apps_enabled_description),
      primaryAction =
          InlineStateStateActionConfiguration(
              label = stringResource(R.string.inline_state_no_apps_enabled_primary_label),
              onClick = onRequestEditMode,
          ),
  )
}
