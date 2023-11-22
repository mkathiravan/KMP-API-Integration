package com.example.kmpmovieapiint.data.repository

import com.example.kmpmovieapiint.common.base.BaseRepository
import com.example.kmpmovieapiint.data.model.Cat
import com.example.kmpmovieapiint.data.network.ApiService
import kotlinx.coroutines.flow.flow

class CatRepository constructor(
    private val apiService: ApiService
) {
    suspend fun getCats() = flow<List<Cat>> {
        emit(apiService.getCats())
    }
}