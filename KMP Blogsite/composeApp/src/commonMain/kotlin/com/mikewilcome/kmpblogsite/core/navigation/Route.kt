package com.mikewilcome.kmpblogsite.core.navigation

sealed class Route(val path: String) {
    data object Landing : Route("/")
    data object About : Route("/about")
    data object WorkIndex : Route("/work")
    data class WorkDetail(val slug: String) : Route("/work/:slug")
    data object Resume : Route("/resume")
    data object Links : Route("/links")
    data object Contact : Route("/contact")
}
