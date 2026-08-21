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
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.runtime.toMutableStateList
import androidx.compose.ui.Modifier
import androidx.compose.ui.hapticfeedback.HapticFeedbackType
import androidx.compose.ui.platform.LocalHapticFeedback
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import link.joaomagfreitas.minimal_launcher.R
import link.joaomagfreitas.minimal_launcher.models.DeviceAppModel
import link.joaomagfreitas.minimal_launcher.models.LauncherAppListItemModel
import link.joaomagfreitas.minimal_launcher.ui.theme.danger
import link.joaomagfreitas.minimal_launcher.ui.theme.neutral
import sh.calvin.reorderable.ReorderableItem
import sh.calvin.reorderable.rememberReorderableLazyListState

@Composable
fun LauncherAppList(
    items: List<LauncherAppListItemModel>,
    onOpen: (item: LauncherAppListItemModel) -> Unit,
    onUpdate: (items: List<LauncherAppListItemModel>) -> Unit,
    onRequestEditMode: () -> Unit,
    editMode: Boolean = false,
    itemsCap: Int = 6,
) {
    val localItems = remember(items) {
        items.toMutableStateList()
    }

    val haptic = LocalHapticFeedback.current
    val state = rememberLazyListState()
    val reorderableListState = rememberReorderableLazyListState(
        lazyListState = state
    ) { from, to ->
        localItems.add(to.index, localItems.removeAt(from.index))

        haptic.performHapticFeedback(HapticFeedbackType.SegmentFrequentTick)
    }

    val style = MaterialTheme.typography.bodyLarge
    val listItemsLimit = if (localItems.count() >= itemsCap) itemsCap else localItems.count()
    val listTilePaddingHeight = 24 * 2
    val labelHeight = style.fontSize.value
    val itemsSpacing = 32

    LaunchedEffect(localItems) {
        onUpdate(localItems)
    }

    LazyColumn(
        state = state,
        modifier = Modifier
            .height(((labelHeight + listTilePaddingHeight) * listItemsLimit + (itemsSpacing * listItemsLimit - 1)).dp)
            .fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(itemsSpacing.dp)
    ) {
        items(
            count = localItems.count(),
            key = { localItems[it].hashCode() },
            itemContent = { idx ->
                ReorderableItem(
                    state = reorderableListState,
                    key = localItems[idx].hashCode()
                ) {
                    val item = localItems[idx]

                    ListItem(
                        headlineContent = {
                            Text(
                                text = item.app.label,
                                style = style
                            )
                        },
                        leadingContent = if (editMode) {
                            {
                                if (item.enabled)
                                    IconButton(
                                        onClick = {
                                            localItems.removeAt(idx)
                                            localItems.add(
                                                item.copy(
                                                    order = localItems.count(),
                                                    enabled = false
                                                )
                                            )
                                        }
                                    ) {
                                        Icon(
                                            painter = painterResource(R.drawable.do_not_disturb_on_24px),
                                            contentDescription = stringResource(id = R.string.content_description_delete_app_from_list),
                                            tint = danger
                                        )
                                    }
                                else
                                    IconButton(
                                        onClick = {
                                            localItems[idx] = item.copy(
                                                enabled = true
                                            )
                                        }
                                    ) {
                                        Icon(
                                            painter = painterResource(R.drawable.add_circle_24px),
                                            contentDescription = stringResource(id = R.string.content_description_add_app_to_list),
                                            tint = neutral
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
                        modifier = Modifier
                            .longPressDraggableHandle(
                                onDragStarted = {
                                    if (!editMode) {
                                        onRequestEditMode()
                                    }

                                    haptic.performHapticFeedback(HapticFeedbackType.GestureThresholdActivate)
                                },
                                onDragStopped = {
                                    haptic.performHapticFeedback(HapticFeedbackType.GestureEnd)
                                },
                            )
                            .clickable(
                                enabled = !editMode,
                                onClick = {
                                    if (!editMode) {
                                        onOpen(localItems[idx])
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
private fun LauncherAppListPreview() {
    val apps = List(20) { "App$it" }.mapIndexed { idx, lb ->
        LauncherAppListItemModel(
            order = idx,
            enabled = idx % 2 == 0,
            app = DeviceAppModel(
                label = lb,
                packageName = "",
                activityName = ""
            ),
        )
    }

    AppScaffold {
        LauncherAppList(
            items = apps,
            editMode = true,
            onOpen = {},
            onUpdate = {},
            onRequestEditMode = {}
        )
    }
}