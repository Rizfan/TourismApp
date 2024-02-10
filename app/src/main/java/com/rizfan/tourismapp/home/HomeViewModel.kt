package com.rizfan.tourismapp.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.rizfan.tourismapp.core.domain.usecase.TourismUseCase

class HomeViewModel(tourismUseCase: TourismUseCase) : ViewModel() {

    val tourism = tourismUseCase.getAllTourism().asLiveData()

}

