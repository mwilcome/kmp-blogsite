package com.mikewilcome.kmpblogsite.core.platform

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform
