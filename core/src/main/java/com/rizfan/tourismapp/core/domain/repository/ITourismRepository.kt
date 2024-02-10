package com.rizfan.tourismapp.core.domain.repository

import com.rizfan.tourismapp.core.data.Resource
import com.rizfan.tourismapp.core.domain.model.Tourism
import kotlinx.coroutines.flow.Flow

interface ITourismRepository {
    fun getAllTourism(): Flow<com.rizfan.tourismapp.core.data.Resource<List<Tourism>>>

    fun getFavoriteTourism(): Flow<List<Tourism>>

    fun setFavoriteTourism(tourism: Tourism, state: Boolean)

}