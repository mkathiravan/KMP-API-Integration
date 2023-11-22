package com.example.kmpmovieapiint.data.network

import com.example.kmpmovieapiint.data.model.Cat
import com.example.kmpmovieapiint.data.model.Post
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.client.request.url

class ApiService(private val client: HttpClient) {
    private val baseUrl: String = "https://jsonplaceholder.typicode.com"
    private val catUrl: String = "https://api.thecatapi.com/v1/images/search?limit=20"

    suspend fun getPosts(): List<Post> {
        return client.get {
            url("$baseUrl/posts")
        }.body()
    }

    suspend fun getCats(): List<Cat> {
        return client.get {
            url(catUrl)

        }.body()
    }
}