package com.example.kmpmovieapiint.android

import android.app.Application
import com.example.kmpmovieapiint.android.di.appModule
import com.example.kmpmovieapiint.di.init
import org.koin.android.ext.koin.androidContext

class BaseApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        init {
            androidContext(this@BaseApplication)
            modules(appModule)
        }
    }

}