package link.joaomagfreitas.minimal_launcher.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import link.joaomagfreitas.minimal_launcher.ui.composables.AppScaffold
import link.joaomagfreitas.minimal_launcher.ui.composables.LauncherAppList
import link.joaomagfreitas.minimal_launcher.ui.composables.TopBar
import link.joaomagfreitas.minimal_launcher.ui.viewmodels.LauncherAppListViewModel

@Composable
fun LauncherScreen(
    viewModel: LauncherAppListViewModel = viewModel(
        factory = LauncherAppListViewModel.Factory
    )
) {
    val state by viewModel.state.collectAsStateWithLifecycle()
    var editMode by remember { mutableStateOf(false) }

    AppScaffold {
        Column(
            verticalArrangement = Arrangement.spacedBy(32.dp)
        ) {
            TopBar(
                editMode = editMode,
                onOpenSettings = {},
                onExitEditMode = {
                    editMode = false
                }
            )

            LauncherAppList(
                editMode = editMode,
                items = state.items,
                onOpen = { viewModel.open(it.app) },
                onUpdate = { viewModel.update(it) },
                onRequestEditMode = { editMode = true }
            )
        }
    }
}

@Composable
@Preview
fun LauncherScreenPreview() {
    LauncherScreen()
}