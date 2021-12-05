package com.example.youtubeapi.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.youtubeapi.models.PlayList
import com.example.youtubeapi.remote.Resource
import com.example.youtubeapi.repository.Repository


class MainViewModel(private val repository: Repository) : ViewModel() {
//    fun getPlayList(): LiveData<PlayList> {
//        return repository.createCall()
//    }
    fun getPlayList(): LiveData<Resource<PlayList>> {
        return repository.fetchPlayLists()
    }
}
