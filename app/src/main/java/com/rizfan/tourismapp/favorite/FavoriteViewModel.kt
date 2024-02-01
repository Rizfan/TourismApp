package com.rizfan.tourismapp.favorite

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.rizfan.tourismapp.domain.usecase.TourismUseCase

class FavoriteViewModel(tourismUseCase: TourismUseCase) : ViewModel() {

    val favoriteTourism = tourismUseCase.getFavoriteTourism().asLiveData()

}

