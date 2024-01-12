package com.rizfan.tourismapp.core.ui

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.rizfan.tourismapp.core.di.Injection
import com.rizfan.tourismapp.detail.DetailTourismViewModel
import com.rizfan.tourismapp.domain.usecase.TourismUseCase
import com.rizfan.tourismapp.favorite.FavoriteViewModel
import com.rizfan.tourismapp.home.HomeViewModel

class ViewModelFactory private constructor(private val tourismRepository: TourismUseCase) :
    ViewModelProvider.NewInstanceFactory() {

    companion object {
        @Volatile
        private var instance: ViewModelFactory? = null

        fun getInstance(context: Context): ViewModelFactory =
            instance
                ?: synchronized(this) {
                instance
                    ?: ViewModelFactory(
                        Injection.provideTourismUseCase(context)
                    )
            }
    }

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T =
        when {
            modelClass.isAssignableFrom(HomeViewModel::class.java) -> {
                HomeViewModel(tourismRepository) as T
            }
            modelClass.isAssignableFrom(FavoriteViewModel::class.java) -> {
                FavoriteViewModel(tourismRepository) as T
            }
            modelClass.isAssignableFrom(DetailTourismViewModel::class.java) -> {
                DetailTourismViewModel(tourismRepository) as T
            }
            else -> throw Throwable("Unknown ViewModel class: " + modelClass.name)
        }
}