package com.sokhal.weatherapp

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform