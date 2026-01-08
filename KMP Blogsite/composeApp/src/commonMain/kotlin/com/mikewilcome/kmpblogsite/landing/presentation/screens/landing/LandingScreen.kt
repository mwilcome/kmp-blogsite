package com.mikewilcome.kmpblogsite.landing.presentation.screens.landing

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.mikewilcome.kmpblogsite.core.navigation.Route
import com.mikewilcome.kmpblogsite.core.presentation.theme.AppDimens

@Composable
fun LandingScreen(
    onNavigate: (Route) -> Unit
) {
    Column(
        verticalArrangement = Arrangement.spacedBy(AppDimens.sectionGap)
    ) {
        Hero(onNavigate)

        SectionDivider()

        FeaturedSection(onNavigate)

        SectionDivider()

        ElsewhereSection(onNavigate)
    }
}

@Composable
private fun Hero(
    onNavigate: (Route) -> Unit
) {
    Card(
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surfaceVariant)
    ) {
        BoxWithConstraints(
            modifier = Modifier
                .fillMaxWidth()
                .padding(AppDimens.heroPadding)
        ) {
            val isWide = maxWidth > 700.dp

            if (isWide) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(AppDimens.sectionGap),
                    verticalAlignment = Alignment.Top
                ) {
                    HeroMain(
                        modifier = Modifier.weight(3f),
                        onNavigate = onNavigate
                    )

                    HeroMeta(
                        modifier = Modifier.weight(2f)
                    )
                }
            } else {
                Column(
                    verticalArrangement = Arrangement.spacedBy(AppDimens.sectionGap)
                ) {
                    HeroMain(
                        modifier = Modifier.fillMaxWidth(),
                        onNavigate = onNavigate
                    )

                    HeroMeta(
                        modifier = Modifier.fillMaxWidth()
                    )
                }
            }
        }
    }
}

@Composable
private fun HeroMain(
    modifier: Modifier,
    onNavigate: (Route) -> Unit
) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(AppDimens.heroGap)
    ) {
        Text(
            text = "Principal Software Engineer",
            style = MaterialTheme.typography.titleMedium,
            color = MaterialTheme.colorScheme.onSurfaceVariant.copy(alpha = AppDimens.mutedTextAlpha)
        )

        Text(
            text = "Resume and selected work.",
            style = MaterialTheme.typography.headlineLarge,
            color = MaterialTheme.colorScheme.onSurfaceVariant
        )

        Text(
            text = "This site has a short overview of what I’ve worked on and a few UI experiments.",
            style = MaterialTheme.typography.bodyMedium,
            color = MaterialTheme.colorScheme.onSurfaceVariant.copy(alpha = AppDimens.mutedTextAlpha)
        )

        Row(horizontalArrangement = Arrangement.spacedBy(AppDimens.buttonGap)) {
            Button(onClick = { onNavigate(Route.Resume) }) { Text("View Resume") }
            TextButton(onClick = { onNavigate(Route.WorkIndex) }) { Text("See Work") }
        }
    }
}

@Composable
private fun HeroMeta(
    modifier: Modifier
) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(AppDimens.heroMetaGap)
    ) {
        Text(
            text = "Focus",
            style = MaterialTheme.typography.titleMedium,
            color = MaterialTheme.colorScheme.onSurfaceVariant
        )

        Text(
            text = "UI systems, state management, and cross-platform delivery.",
            style = MaterialTheme.typography.bodyMedium,
            color = MaterialTheme.colorScheme.onSurfaceVariant.copy(alpha = AppDimens.mutedTextAlpha)
        )

        Spacer(Modifier.height(AppDimens.heroMetaGap))

        Text(
            text = "Stack",
            style = MaterialTheme.typography.titleMedium,
            color = MaterialTheme.colorScheme.onSurfaceVariant
        )

        Text(
            text = "Kotlin, Compose, Java, Angular, SQL.",
            style = MaterialTheme.typography.bodyMedium,
            color = MaterialTheme.colorScheme.onSurfaceVariant.copy(alpha = AppDimens.mutedTextAlpha)
        )
    }
}

@Composable
private fun FeaturedSection(onNavigate: (Route) -> Unit) {
    Column(verticalArrangement = Arrangement.spacedBy(12.dp)) {
        Text("Featured", style = MaterialTheme.typography.headlineSmall)

        Text(
            text = "Selected projects with notes on what I built and what I used.",
            style = MaterialTheme.typography.bodyMedium,
            color = MaterialTheme.colorScheme.onSurfaceVariant.copy(alpha = AppDimens.mutedTextAlpha)
        )

        FeaturedRow(
            title = "The Crafting Llama",
            subtitle = "Custom website • Small business storefront",
            onClick = { onNavigate(Route.WorkDetail("crafting-llama")) }
        )

        HorizontalDivider(
            thickness = AppDimens.dividerThickness,
            color = MaterialTheme.colorScheme.outline.copy(alpha = 0.45f)
        )

        FeaturedRow(
            title = "Angular Labs",
            subtitle = "UI experiments • Signals and state",
            onClick = { onNavigate(Route.WorkDetail("angular-labs")) }
        )
    }
}

@Composable
private fun FeaturedRow(
    title: String,
    subtitle: String,
    onClick: () -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = AppDimens.listItemPaddingVertical),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Column(
            modifier = Modifier.weight(1f),
            verticalArrangement = Arrangement.spacedBy(6.dp)
        ) {
            Text(title, style = MaterialTheme.typography.headlineSmall)
            Text(
                subtitle,
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onSurfaceVariant.copy(alpha = AppDimens.mutedTextAlpha)
            )
        }

        TextButton(onClick = onClick) { Text("Open") }
    }
}

@Composable
private fun ElsewhereSection(onNavigate: (Route) -> Unit) {
    Column(verticalArrangement = Arrangement.spacedBy(12.dp)) {
        Text("Elsewhere", style = MaterialTheme.typography.headlineSmall)

        Text(
            text = "External links and contact.",
            style = MaterialTheme.typography.bodyMedium,
            color = MaterialTheme.colorScheme.onSurfaceVariant.copy(alpha = AppDimens.mutedTextAlpha)
        )

        Row(horizontalArrangement = Arrangement.spacedBy(AppDimens.buttonGap)) {
            TextButton(onClick = { onNavigate(Route.Links) }) { Text("Links") }
            TextButton(onClick = { onNavigate(Route.Contact) }) { Text("Contact") }
        }
    }
}

@Composable
private fun SectionDivider() {
    HorizontalDivider(
        thickness = AppDimens.dividerThickness,
        color = MaterialTheme.colorScheme.outline.copy(alpha = 0.55f)
    )
}
