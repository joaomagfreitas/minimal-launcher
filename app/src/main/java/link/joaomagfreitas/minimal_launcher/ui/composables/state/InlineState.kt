package link.joaomagfreitas.minimal_launcher.ui.composables.state

import androidx.annotation.DrawableRes
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import link.joaomagfreitas.minimal_launcher.R
import link.joaomagfreitas.minimal_launcher.ui.theme.neutral

data class InlineStateStateIconConfiguration(
    @param:DrawableRes val icon: Int,
    val contentDescription: String,
    val tint: Color? = null,
)

data class InlineStateStateActionConfiguration(
    val label: String,
    val onClick: () -> Unit,
)

@Composable
fun InlineState(
    title: String,
    description: String,
    icon: InlineStateStateIconConfiguration,
    primaryAction: InlineStateStateActionConfiguration? = null,
    secondaryAction: InlineStateStateActionConfiguration? = null,
) {
  Column(
      horizontalAlignment = Alignment.CenterHorizontally,
      verticalArrangement = Arrangement.spacedBy(16.dp),
      modifier = Modifier.fillMaxWidth(),
  ) {
    Box(
        contentAlignment = Alignment.Center,
        modifier =
            Modifier.background(
                    color = MaterialTheme.colorScheme.surfaceContainerHigh,
                    shape = RoundedCornerShape(1000.dp),
                )
                .padding(12.dp),
    ) {
      Icon(
          painter = painterResource(icon.icon),
          contentDescription = icon.contentDescription,
          tint = icon.tint ?: MaterialTheme.colorScheme.onSurface,
          modifier = Modifier.size(32.dp),
      )
    }

    Text(
        title,
        style = MaterialTheme.typography.headlineMedium,
    )

    Text(
        description,
        style = MaterialTheme.typography.bodyMedium,
        color = neutral,
    )

    if (primaryAction != null)
        Button(
            modifier = Modifier.fillMaxWidth(),
            onClick = primaryAction.onClick,
        ) {
          Text(
              primaryAction.label.uppercase(),
              style = MaterialTheme.typography.labelLarge,
          )
        }

    if (secondaryAction != null)
        OutlinedButton(
            modifier = Modifier.fillMaxWidth(),
            onClick = secondaryAction.onClick,
        ) {
          Text(
              secondaryAction.label.uppercase(),
              style = MaterialTheme.typography.labelLarge,
          )
        }
  }
}

@Preview
@Composable
private fun InlineStatePreview() {
  _root_ide_package_.link.joaomagfreitas.minimal_launcher.ui.composables.AppScaffold {
    InlineState(
        icon =
            InlineStateStateIconConfiguration(
                icon = R.drawable.add_circle_24px,
                contentDescription = "",
            ),
        title = "Title",
        description = "Description",
        primaryAction =
            InlineStateStateActionConfiguration(
                label = "Primary",
                onClick = {},
            ),
        secondaryAction =
            InlineStateStateActionConfiguration(
                label = "Secondary",
                onClick = {},
            ),
    )
  }
}
