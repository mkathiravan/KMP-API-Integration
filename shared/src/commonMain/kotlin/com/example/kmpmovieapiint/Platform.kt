package com.example.kmpmovieapiint

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform