package com.example.youtubeapi.repository

import androidx.lifecycle.LiveData
import com.example.youtubeapi.models.PlayList
import com.example.youtubeapi.remote.RemoteDataSource
import com.example.youtubeapi.remote.Resource
import kotlinx.coroutines.Dispatchers
import androidx.lifecycle.liveData


class Repository(private val dataSource: RemoteDataSource) {

    fun fetchPlayLists():LiveData<Resource<PlayList>> = liveData(Dispatchers.IO){
        emit(Resource.loading(null))
        val response = dataSource.fetchPlayLists()
        emit(response)
    }

    fun fetchPlayListsDetails(id:String):LiveData<Resource<PlayList>> = liveData(Dispatchers.IO){
        emit(Resource.loading(null))
        val response = dataSource.fetchPlayListsDetails(id)
        emit(response)

    }

//    suspend fun createCall(): LiveData<PlayList> {
//        val data = MutableLiveData<PlayList>()
//
//        youTubeApi.getPlayLists(
//            Constant.PART, Constant.CHANNEL_ID, BuildConfig.API_KEY, Constant.MAX_RESULT
//        ).enqueue(object : Callback<PlayList> {
//            override fun onResponse(call: Call<PlayList>, response: Response<PlayList>) {
//                if (response.isSuccessful && response.body() != null) {
//                    data.value = response.body()
//                }
//            }
//
//            override fun onFailure(call: Call<PlayList>, t: Throwable) {
//                print(t.stackTrace)
//                // 404 не найдено // 403 - токен истек // 401 - нет доступа
//            }
//        })
//        return data
//
//
//    }
//
//    suspend fun createDetails(id: String): LiveData<PlayList>{
//        val data = MutableLiveData<PlayList>()
//        youTubeApi.getPlayListDetails(
//            Constant.PART, id,
//            BuildConfig.API_KEY,
//            Constant.MAX_RESULT
//        ).enqueue(object : Callback<PlayList> {
//            override fun onResponse(call: Call<PlayList>, response: Response<PlayList>) {
//                if (response.isSuccessful && response.body() != null) {
//                    data.value = response.body()
//                }
//            }
//
//            override fun onFailure(call: Call<PlayList>, t: Throwable) {
//                print(t.stackTrace)
//                // 404 не найдено // 403 - токен истек // 401 - нет доступа
//            }
//        })
//        return data
//    }
}
