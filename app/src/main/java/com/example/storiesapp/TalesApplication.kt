package com.example.storiesapp

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class TalesApplication : Application() {
    companion object {
        lateinit var instance : TalesApplication
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
    }
}
