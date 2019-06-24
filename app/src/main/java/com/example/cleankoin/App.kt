package com.example.cleankoin

import android.app.Application
import com.example.cleankoin.di.dataModule
import com.example.cleankoin.di.interactor
import com.example.cleankoin.di.viewModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class App: Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin{
            androidLogger()
            androidContext(this@App)
            modules(dataModule + interactor + viewModule)
        }
    }
}