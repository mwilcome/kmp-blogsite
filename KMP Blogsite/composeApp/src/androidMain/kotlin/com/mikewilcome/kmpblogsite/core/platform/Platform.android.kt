package com.mikewilcome.kmpblogsite.core.platform

actual fun getPlatform(): Platform = object : Platform {
    override val name: String = "Android"
}
