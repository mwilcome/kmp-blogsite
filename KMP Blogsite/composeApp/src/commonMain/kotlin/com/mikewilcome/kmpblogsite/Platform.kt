package com.mikewilcome.kmpblogsite

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform