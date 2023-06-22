package com.example.hcweather

import android.app.Application
import com.example.hcweather.di.appModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class MyApplication: Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@MyApplication) //Context of the App similar to flutter context
            modules(appModule)
        }
    }
}