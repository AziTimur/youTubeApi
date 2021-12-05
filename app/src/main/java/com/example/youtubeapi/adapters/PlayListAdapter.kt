package com.example.youtubeapi.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ExpandableListView
import androidx.recyclerview.widget.RecyclerView
import com.example.youtubeapi.R
import com.example.youtubeapi.databinding.ItemPlaylistsBinding
import com.example.youtubeapi.loadImage
import com.example.youtubeapi.models.Items
import com.example.youtubeapi.models.PlayList
import com.example.youtubeapi.ui.MainActivity

class PlayListAdapter(
    private val playList: PlayList,
    private val clickListener: (id:String) -> Unit
) : RecyclerView.Adapter<PlayListAdapter.ViewHolder>() {
   override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
       return ViewHolder(ItemPlaylistsBinding.inflate(LayoutInflater.from(parent.context),parent,false))
   }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.onBind(playList.items[position])
    }

    override fun getItemCount(): Int {
        return playList.items.size
    }

    inner class ViewHolder(private val containerView: ItemPlaylistsBinding) :
        RecyclerView.ViewHolder(containerView.root) {

        fun onBind(playList: Items) {
            containerView.tvTitle.text = playList.snippet.title
            containerView.ivPlaylist.loadImage(playList.snippet.thumbnails.default.url)
            containerView.tvDesc.text = String.format("${playList.contentDetails.itemCount} ${itemView.context.getString(
                R.string.video_siries)}")

            itemView.setOnClickListener {
                clickListener(playList.id)
            }

        }
    }
}

