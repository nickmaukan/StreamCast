package com.streamcast.app

import android.app.Application
import com.streamcast.app.data.AppDatabase

class StreamCastApp : Application() {

    val database: AppDatabase by lazy {
        AppDatabase.getInstance(this)
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
    }

    companion object {
        lateinit var instance: StreamCastApp
            private set
    }
}
