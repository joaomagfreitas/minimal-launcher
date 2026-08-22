package link.joaomagfreitas.minimal_launcher.ui.composables

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import link.joaomagfreitas.minimal_launcher.R

@Composable
fun TopBar(
    editMode: Boolean = false,
    onOpenSettings: () -> Unit,
    onExitEditMode: () -> Unit,
) {
  Row(
      modifier = Modifier.fillMaxWidth(),
      horizontalArrangement = Arrangement.SpaceBetween,
  ) {
    DateTimeDisplay()
    if (editMode) {
      IconButton(
          onClick = onExitEditMode,
      ) {
        Icon(
            painter = painterResource(R.drawable.close_24px),
            contentDescription = stringResource(R.string.content_description_exit_edit_mode),
        )
      }
    } else {
      IconButton(
          onClick = onOpenSettings,
      ) {
        Icon(
            painter = painterResource(R.drawable.settings_24px),
            contentDescription = stringResource(R.string.content_description_exit_edit_mode),
        )
      }
    }
  }
}

@Composable
@Preview
fun TopBarPreview() {
  AppScaffold {
    TopBar(
        onOpenSettings = {},
        onExitEditMode = {},
    )
  }
}
