package com.mikewilcome.kmpblogsite

actual fun getPlatform(): Platform = object : Platform {
    override val name: String = "Android"
}
