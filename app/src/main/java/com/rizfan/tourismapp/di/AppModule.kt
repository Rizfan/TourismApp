package com.rizfan.tourismapp.di

import com.rizfan.tourismapp.detail.DetailTourismViewModel
import com.rizfan.tourismapp.domain.usecase.TourismInteractor
import com.rizfan.tourismapp.domain.usecase.TourismUseCase
import com.rizfan.tourismapp.favorite.FavoriteViewModel
import com.rizfan.tourismapp.home.HomeViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val useCaseModule = module {
    factory<TourismUseCase> { TourismInteractor(get()) }
}

val viewModelModule = module {
    viewModel { HomeViewModel(get()) }
    viewModel { FavoriteViewModel(get()) }
    viewModel { DetailTourismViewModel(get()) }
}