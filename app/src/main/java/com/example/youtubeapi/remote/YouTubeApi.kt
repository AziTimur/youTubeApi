package com.example.youtubeapi.remote

import com.example.youtubeapi.models.PlayList
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface YouTubeApi {
    @GET("playLists")
    fun getPlayLists(
        @Query("part") part: String,
        @Query("channelId") channelId: String,
        @Query("key") apiKey: String
    ): Call<PlayList>
}