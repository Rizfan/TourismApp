package com.rizfan.tourismapp.domain.usecase

import com.rizfan.tourismapp.core.data.Resource
import com.rizfan.tourismapp.domain.model.Tourism
import io.reactivex.Flowable

interface TourismUseCase{
    fun getAllTourism(): Flowable<Resource<List<Tourism>>>
    fun getFavoriteTourism(): Flowable<List<Tourism>>
    fun setFavoriteTourism(tourism: Tourism, state: Boolean)
}