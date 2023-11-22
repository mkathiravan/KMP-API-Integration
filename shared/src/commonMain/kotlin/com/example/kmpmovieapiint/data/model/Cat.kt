package com.example.kmpmovieapiint.data.model

@kotlinx.serialization.Serializable
data class Cat(
    val id: String? = null,
    val url: String? = null,
    val width: Int? = null,
    val height: Int? = null
)