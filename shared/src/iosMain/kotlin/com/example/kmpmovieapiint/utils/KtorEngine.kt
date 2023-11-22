package com.example.kmpmovieapiint.utils

import io.ktor.client.engine.darwin.Darwin
import org.koin.dsl.module

actual fun KtorEngineModule() = module{
    single { Darwin.create() }
}