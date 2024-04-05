package com.delasystems.androidcomposescaffoldnav

import android.app.Application
import com.delasystems.androidcomposescaffoldnav.data.AppContainer
import com.delasystems.androidcomposescaffoldnav.data.DefaultAppContainer

class BucketListApplication: Application() {
    lateinit var container: AppContainer

    // initiate the app container
    override fun onCreate() {
        super.onCreate()
        container = DefaultAppContainer()
    }
}