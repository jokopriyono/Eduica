package com.developer.eduica

import android.app.Application
import com.marcinorlowski.fonty.Fonty

class MyApplication : Application() {
    override fun onCreate() {
        super.onCreate()

        Fonty
            .context(this)
            .italicTypeface("Sacramento.ttf")
            .build()
    }
}