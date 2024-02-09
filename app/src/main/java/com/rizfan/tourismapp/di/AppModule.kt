package com.rizfan.tourismapp.di

import com.rizfan.tourismapp.domain.usecase.TourismInteractor
import com.rizfan.tourismapp.domain.usecase.TourismUseCase
import dagger.Binds
import dagger.Module

@Module
abstract class AppModule {

    @Binds
    abstract fun provideTourismUseCase(tourismInteractor: TourismInteractor): TourismUseCase

}