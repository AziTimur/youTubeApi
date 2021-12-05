package com.example.youtubeapi.remote

import com.example.youtubeapi.BuildConfig
import com.example.youtubeapi.`object`.Constant
import com.example.youtubeapi.base.BaseDataSource

class RemoteDataSource(private val youTubeApi: YouTubeApi): BaseDataSource() {

    suspend fun fetchPlayLists() = getResult{
        youTubeApi.getPlayLists(Constant.PART,Constant.CHANNEL_ID, BuildConfig.API_KEY, Constant.MAX_RESULT)
    }
    suspend fun fetchPlayListsDetails(id:String) = getResult{
        youTubeApi.getPlayListDetails(Constant.PART,id, BuildConfig.API_KEY, Constant.MAX_RESULT)
    }
}