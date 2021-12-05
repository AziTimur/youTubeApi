package com.example.youtubeapi.di

import com.example.youtubeapi.repository.Repository
import org.koin.core.module.Module
import org.koin.dsl.module
import java.lang.reflect.Modifier

val repoModules:Module = module {
    single { Repository(get()) }
}