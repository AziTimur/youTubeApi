package com.example.youtubeapi.di

import com.example.youtubeapi.ui.MainViewModel
import com.example.youtubeapi.ui.ViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.module.Module
import org.koin.dsl.module

val viewModules:Module= module {
     viewModel{ MainViewModel(get()) }
     viewModel{ ViewModel(get()) }
}