package com.example.kmpmovieapiint.di

import com.example.kmpmovieapiint.data.network.ApiService
import com.example.kmpmovieapiint.data.repository.CatRepository
import com.example.kmpmovieapiint.data.repository.PostRepository
import io.ktor.client.HttpClient
import io.ktor.client.plugins.DefaultRequest
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.logging.DEFAULT
import io.ktor.client.plugins.logging.LogLevel
import io.ktor.client.plugins.logging.Logger
import io.ktor.client.plugins.logging.Logging
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json
import org.koin.core.context.startKoin
import org.koin.dsl.KoinAppDeclaration
import org.koin.dsl.module

fun init(appDeclaration: KoinAppDeclaration = {}) = startKoin {
    appDeclaration()
    modules(appModule())
}

fun initKoin() = init { }

fun appModule() = module {
    single { createJson() }
    single { createHttpClient(get()) }
    single { ApiService(get()) }
    factory { PostRepository(get()) }
    factory { CatRepository(get()) }
}

fun createJson(): Json = Json { isLenient = true; ignoreUnknownKeys = true }

fun createHttpClient(json: Json): HttpClient = HttpClient {

    install(ContentNegotiation) {
        json(json)
    }

    install(DefaultRequest) {
        headers.append("Content-Type", "application/json")
    }

    install(Logging)
    {
        logger = Logger.DEFAULT
        level = LogLevel.INFO
    }
}