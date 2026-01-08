package com.mikewilcome.kmpblogsite

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import com.mikewilcome.kmpblogsite.core.navigation.NavGraph
import com.mikewilcome.kmpblogsite.core.navigation.Router
import com.mikewilcome.kmpblogsite.core.presentation.AppShell
import com.mikewilcome.kmpblogsite.core.presentation.theme.AppTheme
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
@Preview
fun App() {
    AppTheme {
        val router = remember { Router() }

        AppShell(router = router) {
            NavGraph(router)
        }
    }
}
