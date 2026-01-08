package com.mikewilcome.kmpblogsite.core.navigation

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue

class Router(start: Route = Route.Landing) {
    var current: Route by mutableStateOf(start)
        private set

    fun navigate(to: Route) {
        current = to
    }
}
