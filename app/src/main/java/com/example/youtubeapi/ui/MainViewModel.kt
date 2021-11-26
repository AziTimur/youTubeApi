package com.example.youtubeapi.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.youtubeapi.BuildConfig.API_KEY
import com.example.youtubeapi.`object`.Constant
import com.example.youtubeapi.models.PlayList
import com.example.youtubeapi.remote.RetrofitClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainViewModel:ViewModel() {
    private val youTubeApi=RetrofitClient.create()

    fun getPlayList():LiveData<PlayList>{
        return createCall()
    }

    private fun createCall(): LiveData<PlayList> {
        val data = MutableLiveData<PlayList>()
     youTubeApi.getPlayLists(Constant.PART,Constant.CHANNEL_ID, API_KEY)
             .enqueue(object : Callback<PlayList> {
                 override fun onResponse(call: Call<PlayList>, response: Response<PlayList>) {
                     if (response.isSuccessful && response.body() != null) {
                         data.value = response.body()
                     }
                 }
                 override fun onFailure(call: Call<PlayList>, t: Throwable) {
                     print(t.stackTrace)
                     // 404 не найдено // 403 - токен истек // 401 - нет доступа
                 }
             })
        return data
    }

}