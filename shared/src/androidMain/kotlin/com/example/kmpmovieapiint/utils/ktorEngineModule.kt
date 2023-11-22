package com.example.kmpmovieapiint.utils;

import io.ktor.client.engine.android.Android
import org.koin.dsl.module


actual fun KtorEngineModule() = module{
    single { Android.create()  }
}