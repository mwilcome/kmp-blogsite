package com.mikewilcome.kmpblogsite.core.presentation.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

private val DarkColors = darkColorScheme(
    primary = Color(0xFFA29BFF),
    onPrimary = Color(0xFF0F0C1A),

    background = Color(0xFF0D0D12),
    onBackground = Color(0xFFF5F2FF),

    surface = Color(0xFF12121B),
    onSurface = Color(0xFFF5F2FF),

    surfaceVariant = Color(0xFF1F1F2E),
    onSurfaceVariant = Color(0xFFE0DCf8),

    outline = Color(0xFF404060),
    outlineVariant = Color(0xFF2A2A3A)
)

@Composable
fun AppTheme(
    content: @Composable () -> Unit
) {
    MaterialTheme(
        colorScheme = DarkColors,
        typography = appTypography(),
        content = content
    )
}
