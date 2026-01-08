package com.mikewilcome.kmpblogsite.core.platform

class WasmPlatform : Platform {
    override val name: String = "Web with Kotlin/Js"
}

actual fun getPlatform(): Platform = WasmPlatform()
