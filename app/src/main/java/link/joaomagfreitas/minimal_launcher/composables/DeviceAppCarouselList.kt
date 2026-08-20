package link.joaomagfreitas.minimal_launcher.composables

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.ListItem
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.hapticfeedback.HapticFeedbackType
import androidx.compose.ui.platform.LocalHapticFeedback
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import link.joaomagfreitas.minimal_launcher.R
import link.joaomagfreitas.minimal_launcher.models.DeviceAppModel
import link.joaomagfreitas.minimal_launcher.ui.theme.danger
import link.joaomagfreitas.minimal_launcher.ui.theme.neutral
import sh.calvin.reorderable.ReorderableItem
import sh.calvin.reorderable.rememberReorderableLazyListState

@Composable
fun DeviceAppCarouselList(
    apps: List<DeviceAppModel>,
    onOpen: (app: DeviceAppModel) -> Unit,
    onDelete: (app: DeviceAppModel) -> Unit,
    onOrder: (apps: List<DeviceAppModel>) -> Unit,
    editMode: Boolean = false,
    itemsCap: Int = 6,
) {
    var apps by remember {
        mutableStateOf(apps)
    }

    val haptic = LocalHapticFeedback.current
    val state = rememberLazyListState()
    val reorderableListState = rememberReorderableLazyListState(
        lazyListState = state
    ) { from, to ->
        apps = apps.toMutableList().apply {
            add(to.index, removeAt(from.index))
        }

        haptic.performHapticFeedback(HapticFeedbackType.SegmentFrequentTick)
        onOrder(apps)
    }

    val style = MaterialTheme.typography.bodyLarge
    val listItemsLimit = if (apps.count() >= itemsCap) itemsCap else apps.count()
    val listTilePaddingHeight = 24 * 2
    val labelHeight = style.fontSize.value
    val itemsSpacing = 32

    LazyColumn(
        state = state,
        modifier = Modifier
            .height(((labelHeight + listTilePaddingHeight) * listItemsLimit + (itemsSpacing * listItemsLimit - 1)).dp)
            .fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(itemsSpacing.dp)
    ) {

        items(
            count = apps.count(),
            key = { apps[it].hashCode() },
            itemContent = { idx ->
                ReorderableItem(
                    state = reorderableListState,
                    key = apps[idx].hashCode()
                ) {
                    ListItem(
                        headlineContent = {
                            Text(
                                text = apps[idx].label,
                                style = style
                            )
                        },
                        leadingContent = if (editMode) {
                            {
                                IconButton(
                                    onClick = { onDelete(apps[idx]) }
                                ) {
                                    Icon(
                                        painter = painterResource(R.drawable.do_not_disturb_on_24px),
                                        contentDescription = stringResource(id = R.string.content_description_delete_app_from_list),
                                        tint = danger
                                    )
                                }
                            }
                        } else null,
                        trailingContent = if (editMode) {
                            {
                                Icon(
                                    painter = painterResource(R.drawable.drag_handle_24px),
                                    contentDescription = stringResource(id = R.string.content_description_drag_app_in_list),
                                    tint = neutral
                                )
                            }
                        } else null,
                        modifier = if (editMode)
                            Modifier.draggableHandle(
                                onDragStarted = {
                                    haptic.performHapticFeedback(HapticFeedbackType.GestureThresholdActivate)
                                },
                                onDragStopped = {
                                    haptic.performHapticFeedback(HapticFeedbackType.GestureEnd)
                                },
                            ) else Modifier
                            .clickable(
                                onClick = {
                                    if (!editMode) {
                                        onOpen(apps[idx])
                                    }
                                }
                            )
                    )
                }
            }
        )
    }
}

@Composable
@Preview
private fun DeviceAppCarouselListPreview() {
    val apps = List(20) { "App$it" }.map { lb ->
        DeviceAppModel(
            label = lb,
            packageName = "",
            activityName = ""
        )
    }

    AppScaffold {
        DeviceAppCarouselList(
            apps = apps,
            editMode = true,
            onOpen = {},
            onDelete = {},
            onOrder = {}
        )
    }
}