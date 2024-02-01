package com.rizfan.tourismapp.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.toLiveData
import com.rizfan.tourismapp.domain.usecase.TourismUseCase

class HomeViewModel(tourismUseCase: TourismUseCase) : ViewModel() {

    val tourism = tourismUseCase.getAllTourism().toLiveData()

}

