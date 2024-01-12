package com.rizfan.tourismapp.favorite

import androidx.lifecycle.ViewModel
import com.rizfan.tourismapp.domain.usecase.TourismUseCase

class FavoriteViewModel(tourismUseCase: TourismUseCase) : ViewModel() {

    val favoriteTourism = tourismUseCase.getFavoriteTourism()

}

