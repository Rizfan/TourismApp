package com.rizfan.tourismapp.core.domain.usecase

import com.rizfan.tourismapp.core.data.Resource
import com.rizfan.tourismapp.core.domain.model.Tourism
import kotlinx.coroutines.flow.Flow

interface TourismUseCase{
    fun getAllTourism(): Flow<com.rizfan.tourismapp.core.data.Resource<List<Tourism>>>
    fun getFavoriteTourism(): Flow<List<Tourism>>
    fun setFavoriteTourism(tourism: Tourism, state: Boolean)
}