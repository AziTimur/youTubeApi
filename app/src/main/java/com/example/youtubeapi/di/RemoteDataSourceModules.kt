package com.example.youtubeapi.di

import com.example.youtubeapi.remote.RemoteDataSource
import org.koin.dsl.module

val remoteDataSource = module {
    factory { RemoteDataSource(get()) }
}