package com.rizfan.tourismapp.domain.repository

import androidx.lifecycle.LiveData
import com.rizfan.tourismapp.core.data.Resource
import com.rizfan.tourismapp.domain.model.Tourism

interface ITourismRepository {
    fun getAllTourism(): LiveData<Resource<List<Tourism>>>

    fun getFavoriteTourism(): LiveData<List<Tourism>>

    fun setFavoriteTourism(tourism: Tourism, state: Boolean)

}