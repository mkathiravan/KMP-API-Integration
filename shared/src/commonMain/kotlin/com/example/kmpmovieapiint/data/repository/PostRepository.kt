package com.example.kmpmovieapiint.data.repository

import com.example.kmpmovieapiint.common.base.BaseRepository
import com.example.kmpmovieapiint.data.network.ApiService

class PostRepository constructor(
    private val apiService: ApiService) : BaseRepository(){
        suspend fun getPosts() = safeApiCall {
            apiService.getPosts()
        }
}