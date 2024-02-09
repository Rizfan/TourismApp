package com.rizfan.tourismapp.domain.usecase

import com.rizfan.tourismapp.domain.model.Tourism
import com.rizfan.tourismapp.domain.repository.ITourismRepository
import javax.inject.Inject


class TourismInteractor @Inject constructor(private val tourismRepository: ITourismRepository): TourismUseCase {

    override fun getAllTourism() = tourismRepository.getAllTourism()

    override fun getFavoriteTourism() = tourismRepository.getFavoriteTourism()

    override fun setFavoriteTourism(tourism: Tourism, state: Boolean) = tourismRepository.setFavoriteTourism(tourism, state)
}