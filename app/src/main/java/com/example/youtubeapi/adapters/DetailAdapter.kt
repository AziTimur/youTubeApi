package com.example.youtubeapi.adapters

import android.os.Build
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.recyclerview.widget.RecyclerView
import com.example.youtubeapi.R
import com.example.youtubeapi.databinding.ItemPlaylistsBinding
import com.example.youtubeapi.loadImage
import com.example.youtubeapi.models.Items
import com.example.youtubeapi.models.PlayList
import java.time.OffsetDateTime
import java.time.ZoneId
import java.time.ZoneOffset
import java.time.ZonedDateTime
import java.time.format.DateTimeFormatter
import kotlin.reflect.KFunction1

class DetailAdapter(private val clickListener: KFunction1<Items, Unit>)
    : RecyclerView.Adapter<DetailAdapter.ViewHolder>() {

//    private lateinit var viewBinding: ItemPlaylistDetailsBinding
//    private val playList: ArrayList<PlayList> = arrayListOf()
     var playList: PlayList ? = null
    set(value) {
        field = value
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
//        viewBinding = ItemPlaylistDetailsBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(ItemPlaylistsBinding.inflate(LayoutInflater.from(parent.context),parent,false))

    }

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        playList?.items?.get(position)?.let { holder.onBind(it) }
    }

    override fun getItemCount(): Int {
        return playList?.items?.size!!
    }

//
//    fun addPlayList(list: ArrayList<PlayList>?) {
//        if (list != null) {
//            playList.addAll(list)
//        }
//        notifyDataSetChanged()
//    }

    inner class ViewHolder(private val containerView: ItemPlaylistsBinding) :
        RecyclerView.ViewHolder(containerView.root) {

        @RequiresApi(Build.VERSION_CODES.O)
        fun onBind(playList: Items) {
            containerView.tvTitle.text = playList.snippet.title
            containerView.ivPlaylist.loadImage(playList.snippet.thumbnails.default.url)
            val date = playList.snippet.publishedAt
            val zonedDateTime = ZonedDateTime.parse(date)
            val offsetDateTime = OffsetDateTime.parse(date)
            val localOffsetDateTime = offsetDateTime.withOffsetSameInstant(ZoneOffset.ofHours(-2))
            val localZonedDateTime = zonedDateTime.withZoneSameInstant(ZoneId.of("Brazil/DeNoronha"))
            containerView.tvDesc.text = String.format(localOffsetDateTime.format(
                DateTimeFormatter.ofPattern("dd-MM-uuuu ")))
            itemView.setOnClickListener {
                clickListener(playList)
            }

        }
    }
}