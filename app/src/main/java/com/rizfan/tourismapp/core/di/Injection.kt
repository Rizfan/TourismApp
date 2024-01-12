package com.rizfan.tourismapp.core.di

import android.content.Context
import com.rizfan.tourismapp.core.data.TourismRepository
import com.rizfan.tourismapp.core.data.source.local.LocalDataSource
import com.rizfan.tourismapp.core.data.source.local.room.TourismDatabase
import com.rizfan.tourismapp.core.data.source.remote.RemoteDataSource
import com.rizfan.tourismapp.core.data.source.remote.network.ApiConfig
import com.rizfan.tourismapp.core.utils.AppExecutors
import com.rizfan.tourismapp.domain.usecase.TourismInteractor
import com.rizfan.tourismapp.domain.usecase.TourismUseCase

object Injection {
    fun provideRepository(context: Context): TourismRepository {
        val database = TourismDatabase.getInstance(context)

        val remoteDataSource = RemoteDataSource.getInstance(ApiConfig.provideApiService())
        val localDataSource = LocalDataSource.getInstance(database.tourismDao())
        val appExecutors = AppExecutors()

        return TourismRepository.getInstance(remoteDataSource, localDataSource, appExecutors)
    }
    fun provideTourismUseCase(context: Context): TourismUseCase {
        val repository = provideRepository(context)
        return TourismInteractor(repository)
    }
}
