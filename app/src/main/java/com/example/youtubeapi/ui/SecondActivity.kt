package com.example.youtubeapi.ui

import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.youtubeapi.adapters.DetailAdapter
import com.example.youtubeapi.base.Base
import com.example.youtubeapi.databinding.ActivityMain2Binding
import com.example.youtubeapi.databinding.ActivityMainBinding
import com.example.youtubeapi.models.Items
import com.example.youtubeapi.models.PlayList
import com.example.youtubeapi.remote.Status
import org.koin.androidx.viewmodel.ext.android.viewModel

class SecondActivity : Base<ActivityMain2Binding>(){
    private lateinit var playList: PlayList
    private  val viewModel: ViewModel by viewModel()
    private val detailAdapter: DetailAdapter by lazy { DetailAdapter(this::clickListener) }
    private var playListId: String? = null
    private var id = ""


    override fun setUI() {
        id = intent.getStringExtra(MainActivity.IMAGE_KEY).toString()
    }
    private fun initRecyclerView(playList: PlayList) {

        viewBinding.rvPlaylistDetails.apply {
            layoutManager = LinearLayoutManager(this@SecondActivity,
                LinearLayoutManager.VERTICAL,false)
            this@SecondActivity.detailAdapter.playList = playList
            adapter = this@SecondActivity.detailAdapter
        }
        detailAdapter.notifyDataSetChanged()
    }

    override fun setupLiveData() {
        viewModel.getPlayListDetails(id).observe(this) {Resource ->
            when(Resource.status){
                Status.LOADING -> {
                    //progressBar
                }
                Status.SUCCESS ->{

                    Resource.data?.let { initRecyclerView(it) }
                }
                Status.ERROR -> {
                    // Error toast
                }
            }
        }
    }

    private fun clickListener(id: Items) {

    }

    override fun checkInternet() {

    }

    override fun inflateViewBinding(): ActivityMain2Binding {
        return ActivityMain2Binding.inflate(layoutInflater)
    }

    override fun setupClickListener() {

    }
}