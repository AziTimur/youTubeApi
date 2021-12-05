package com.example.youtubeapi.ui

import android.content.Intent
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.youtubeapi.adapters.PlayListAdapter
import com.example.youtubeapi.base.Base
import com.example.youtubeapi.databinding.ActivityMainBinding
import com.example.youtubeapi.models.Items
import com.example.youtubeapi.models.PlayList
import com.example.youtubeapi.remote.Status
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : Base<ActivityMainBinding>(){
    private lateinit var playList:PlayList
    private val mainViewModel: MainViewModel by viewModel()
    private  val  adapter: PlayListAdapter by lazy {
        PlayListAdapter(playList,this::clickListener)
    }


    override fun setUI() {

    }
    private fun initRecyclerView() {

        viewBinding.rvPlaylist.apply {
            layoutManager = LinearLayoutManager(this@MainActivity,LinearLayoutManager.VERTICAL,false)
            adapter = this@MainActivity.adapter
        }
        adapter.notifyDataSetChanged()
    }

    override fun setupLiveData() {
        mainViewModel.getPlayList().observe(this) {Resource ->
            when(Resource.status){
                Status.LOADING -> {
                    //progressBar
                }
                Status.SUCCESS ->{
                    if (Resource.data != null){
                        playList = Resource.data
                    }
                    initRecyclerView()
                }
                Status.ERROR -> {
                    // Error toast
                }
            }
        }
    }

    private fun clickListener(id: String) {
        Intent(this, SecondActivity::class.java).apply {
            putExtra(IMAGE_KEY,id)
            startActivity(this)
        }
    }

    override fun checkInternet() {
    }

    override fun inflateViewBinding(): ActivityMainBinding {
        return ActivityMainBinding.inflate(layoutInflater)
    }

    override fun setupClickListener() {

    }
    companion object{
        const val IMAGE_KEY="SDCD"
    }
}