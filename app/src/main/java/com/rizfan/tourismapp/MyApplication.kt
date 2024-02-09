package com.rizfan.tourismapp

import android.app.Application
import com.rizfan.tourismapp.core.di.databaseModule
import com.rizfan.tourismapp.core.di.networkModule
import com.rizfan.tourismapp.core.di.repositoryModule
import com.rizfan.tourismapp.di.useCaseModule
import com.rizfan.tourismapp.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class MyApplication: Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger(Level.NONE)
            androidContext(this@MyApplication)
            modules(
                listOf(
                    databaseModule,
                    networkModule,
                    repositoryModule,
                    useCaseModule,
                    viewModelModule
                )
            )
        }
    }
}