package com.rizfan.tourismapp.core.data.source.remote

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.rizfan.tourismapp.core.data.source.remote.network.ApiResponse
import com.rizfan.tourismapp.core.data.source.remote.network.ApiService
import com.rizfan.tourismapp.core.data.source.remote.response.ListTourismResponse
import com.rizfan.tourismapp.core.data.source.remote.response.TourismResponse
import retrofit2.Callback

class RemoteDataSource private constructor(private val apiService : ApiService) {
    companion object {
        @Volatile
        private var instance: RemoteDataSource? = null

        fun getInstance(service: ApiService): RemoteDataSource =
            instance ?: synchronized(this) {
                instance ?: RemoteDataSource(service)
            }
    }

    fun getAllTourism(): LiveData<ApiResponse<List<TourismResponse>>> {
        val resultData = MutableLiveData<ApiResponse<List<TourismResponse>>>()

        //get data from remote api
        val client = apiService.getList()
        client.enqueue(object : Callback<ListTourismResponse> {
            override fun onResponse(
                call: retrofit2.Call<ListTourismResponse>,
                response: retrofit2.Response<ListTourismResponse>
            ) {
                val dataArray = response.body()?.places
                resultData.value =
                    if (dataArray != null) ApiResponse.Success(dataArray) else ApiResponse.Empty
            }

            override fun onFailure(call: retrofit2.Call<ListTourismResponse>, t: Throwable) {
                resultData.value = ApiResponse.Error(t.message.toString())
                Log.e("RemoteDataSource", t.message.toString())
            }
        })

        return resultData
    }
}

