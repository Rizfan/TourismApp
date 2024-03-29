package com.rizfan.tourismapp.detail

import androidx.lifecycle.ViewModel
import com.rizfan.tourismapp.domain.model.Tourism
import com.rizfan.tourismapp.domain.usecase.TourismUseCase

class DetailTourismViewModel(private val tourismUseCase : TourismUseCase) : ViewModel() {
    fun setFavoriteTourism(tourism: Tourism, newStatus:Boolean) = tourismUseCase.setFavoriteTourism(tourism, newStatus)
}

