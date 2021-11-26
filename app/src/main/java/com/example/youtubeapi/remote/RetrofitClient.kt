package com.example.youtubeapi.remote

import com.example.youtubeapi.BuildConfig.BASE_URL
import okhttp3.OkHttp
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import java.util.concurrent.TimeUnit

class RetrofitClient {
    companion object{
        fun create(): YouTubeApi {
            val  interceptor=HttpLoggingInterceptor()
            interceptor.setLevel(HttpLoggingInterceptor.Level.BODY)
            val okHttpClient=OkHttpClient().newBuilder()
                    .connectTimeout(30,TimeUnit.SECONDS)
                    .writeTimeout(30,TimeUnit.SECONDS)
                    .readTimeout(30,TimeUnit.SECONDS)
                    .addInterceptor(interceptor)
                    .build()

            val  retrofitClient=Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
                    .baseUrl(BASE_URL)
                    .client(okHttpClient)
                    .build()
            return retrofitClient.create(YouTubeApi::class.java)
        }
    }
}