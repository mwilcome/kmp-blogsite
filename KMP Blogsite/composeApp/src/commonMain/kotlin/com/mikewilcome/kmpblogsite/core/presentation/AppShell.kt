package com.mikewilcome.kmpblogsite.core.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.mikewilcome.kmpblogsite.core.navigation.Route
import com.mikewilcome.kmpblogsite.core.navigation.Router
import com.mikewilcome.kmpblogsite.core.presentation.theme.AppDimens

@Composable
fun AppShell(
    router: Router,
    content: @Composable () -> Unit
) {
    val glow = Brush.radialGradient(
        colors = listOf(
            MaterialTheme.colorScheme.primary.copy(alpha = 0.16f),
            Color.Transparent
        )
    )

    val scrollState = rememberScrollState()

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background,
        contentColor = MaterialTheme.colorScheme.onBackground
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(glow)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .verticalScroll(scrollState)
            ) {
                Header(router)

                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = AppDimens.contentTopPadding),
                    contentAlignment = Alignment.TopCenter
                ) {
                    Box(
                        modifier = Modifier
                            .widthIn(max = AppDimens.pageMaxWidth)
                            .padding(
                                horizontal = AppDimens.pagePaddingHorizontal,
                                vertical = AppDimens.pagePaddingVertical
                            )
                    ) {
                        content()
                    }
                }
            }
        }
    }
}

@Composable
private fun Header(router: Router) {
    Box(
        modifier = Modifier.fillMaxWidth(),
        contentAlignment = Alignment.TopCenter
    ) {
        Column(
            modifier = Modifier
                .widthIn(max = AppDimens.pageMaxWidth)
                .padding(
                    horizontal = AppDimens.pagePaddingHorizontal,
                    vertical = AppDimens.headerPaddingVertical
                ),
            verticalArrangement = Arrangement.spacedBy(AppDimens.headerRowGap)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Mike Wilcome",
                    style = MaterialTheme.typography.titleMedium,
                    color = MaterialTheme.colorScheme.onBackground
                )

                Spacer(Modifier.weight(1f))

                FlowRow(
                    horizontalArrangement = Arrangement.spacedBy(4.dp, Alignment.End),
                    verticalArrangement = Arrangement.spacedBy(4.dp),
                    maxItemsInEachRow = 5
                ) {
                    HeaderLink("About") { router.navigate(Route.About) }
                    HeaderLink("Work") { router.navigate(Route.WorkIndex) }
                    HeaderLink("Resume") { router.navigate(Route.Resume) }
                    HeaderLink("Links") { router.navigate(Route.Links) }
                    HeaderLink("Contact") { router.navigate(Route.Contact) }
                }
            }

            HorizontalDivider(
                thickness = AppDimens.dividerThickness,
                color = MaterialTheme.colorScheme.outline.copy(alpha = AppDimens.dividerAlpha)
            )
        }
    }
}

@Composable
private fun HeaderLink(
    label: String,
    onClick: () -> Unit
) {
    TextButton(
        onClick = onClick,
        modifier = Modifier.wrapContentWidth(unbounded = true),
        contentPadding = PaddingValues(horizontal = 10.dp, vertical = 6.dp)
    ) {
        Text(
            text = label,
            style = MaterialTheme.typography.titleMedium,
            color = MaterialTheme.colorScheme.onBackground.copy(alpha = 0.8f),
            maxLines = 1,
            overflow = TextOverflow.Clip,
            softWrap = false
        )
    }
}
