package com.example.youtubeapi.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.youtubeapi.models.PlayList
import com.example.youtubeapi.remote.Resource
import com.example.youtubeapi.repository.Repository

class ViewModel(private val repository: Repository): ViewModel() {
    fun getPlayListDetails(id:String): LiveData<Resource<PlayList>> {
        return repository.fetchPlayListsDetails(id)
    }
}