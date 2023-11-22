package com.example.kmpmovieapiint.koin_component

import com.example.kmpmovieapiint.data.network.ApiService
import com.example.kmpmovieapiint.data.repository.CatRepository
import com.example.kmpmovieapiint.data.repository.PostRepository
import com.example.kmpmovieapiint.di.initKoin
import org.koin.core.Koin
import org.koin.core.KoinApplication

fun KoinApplication.Companion.start(): KoinApplication = initKoin()

val Koin.apiService: ApiService get() = get()

val Koin.postRepository: PostRepository get() = get()

val Koin.catRepository: CatRepository get() = get()