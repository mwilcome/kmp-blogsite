package com.mikewilcome.kmpblogsite.core.navigation

import androidx.compose.runtime.Composable
import com.mikewilcome.kmpblogsite.core.presentation.PlaceholderScreen
import com.mikewilcome.kmpblogsite.landing.presentation.screens.landing.LandingScreen

@Composable
fun NavGraph(router: Router) {
    when (val r = router.current) {
        Route.Landing -> LandingScreen(onNavigate = router::navigate)
        Route.About -> PlaceholderScreen("About")
        Route.WorkIndex -> PlaceholderScreen("Work (index)")
        is Route.WorkDetail -> PlaceholderScreen("Work (detail): ${r.slug}")
        Route.Resume -> PlaceholderScreen("Resume")
        Route.Links -> PlaceholderScreen("Links / Elsewhere")
        Route.Contact -> PlaceholderScreen("Contact")
    }
}
