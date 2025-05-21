package com.srdc.plantapp

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class PlantApplication : Application() {
    override fun onCreate() {
        super.onCreate()

    }
}