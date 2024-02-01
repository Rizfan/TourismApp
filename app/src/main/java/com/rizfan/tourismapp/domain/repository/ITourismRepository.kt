package com.rizfan.tourismapp.domain.repository

import com.rizfan.tourismapp.core.data.Resource
import com.rizfan.tourismapp.domain.model.Tourism
import io.reactivex.Flowable

interface ITourismRepository {
    fun getAllTourism(): Flowable<Resource<List<Tourism>>>

    fun getFavoriteTourism(): Flowable<List<Tourism>>

    fun setFavoriteTourism(tourism: Tourism, state: Boolean)

}