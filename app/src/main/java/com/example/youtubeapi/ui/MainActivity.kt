package com.example.youtubeapi.ui

import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.example.youtubeapi.base.Base
import com.example.youtubeapi.databinding.ActivityMainBinding

class MainActivity : Base<ActivityMainBinding>(){
    private  lateinit var mainViewModel: MainViewModel

    override fun setUI() {
        mainViewModel=ViewModelProvider(this)[MainViewModel::class.java]

    }

    override fun setUpLiveData() {
        mainViewModel.getPlayList().observe(this){
            viewBinding.titleTv.text=it.kind
            Toast.makeText(this,it.kind,Toast.LENGTH_SHORT).show()
        }
    }

    override fun clickListener() {
        TODO("Not yet implemented")
    }

    override fun checkInternet() {
        TODO("Not yet implemented")
    }

    override fun inflateViewBinding(): ActivityMainBinding {
        return ActivityMainBinding.inflate(layoutInflater)
    }

}