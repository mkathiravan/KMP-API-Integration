package com.example.kmpmovieapiint.data.model

import kotlinx.serialization.Serializable

@Serializable
data class Post(
    val id: Int,
    val body: String
)
