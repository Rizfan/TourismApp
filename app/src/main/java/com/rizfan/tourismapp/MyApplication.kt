package com.rizfan.tourismapp

import android.app.Application
import com.rizfan.tourismapp.core.di.CoreComponent
import com.rizfan.tourismapp.core.di.DaggerCoreComponent
import com.rizfan.tourismapp.di.AppComponent
import com.rizfan.tourismapp.di.DaggerAppComponent

open class MyApplication : Application() {

    private val coreComponent: CoreComponent by lazy {
        DaggerCoreComponent.factory().create(applicationContext)
    }

    val appComponent: AppComponent by lazy {
        DaggerAppComponent.factory().create(coreComponent)
    }
}