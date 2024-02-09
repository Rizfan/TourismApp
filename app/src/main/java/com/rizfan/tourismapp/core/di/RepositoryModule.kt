package com.rizfan.tourismapp.core.di

import com.rizfan.tourismapp.core.data.TourismRepository
import com.rizfan.tourismapp.domain.repository.ITourismRepository
import dagger.Binds
import dagger.Module

@Module(includes = [NetworkModule::class, DatabaseModule::class])
abstract class RepositoryModule {

    @Binds
    abstract fun provideRepository(tourismRepository: TourismRepository): ITourismRepository

}