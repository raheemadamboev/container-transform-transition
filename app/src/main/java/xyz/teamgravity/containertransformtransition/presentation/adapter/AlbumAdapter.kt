package xyz.teamgravity.containertransformtransition.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import xyz.teamgravity.containertransformtransition.data.model.AlbumModel
import xyz.teamgravity.containertransformtransition.databinding.CardAlbumBinding

class AlbumAdapter(
    diff: AlbumDiff,
    private val listener: AlbumListener,
) : ListAdapter<AlbumModel, AlbumAdapter.AlbumViewHolder>(diff) {

    inner class AlbumViewHolder(private val binding: CardAlbumBinding) : RecyclerView.ViewHolder(binding.root) {

        init {
            binding.root.setOnClickListener {
                val position = adapterPosition
                if (position != RecyclerView.NO_POSITION) {
                    listener.onAlbumClick(getItem(position))
                }
            }
        }

        fun bind(model: AlbumModel) {
            binding.apply {
                imageI.setImageResource(model.cover)
                artistT.text = model.artist
                albumT.text = model.album
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AlbumViewHolder {
        return AlbumViewHolder(CardAlbumBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: AlbumViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    object AlbumDiff : DiffUtil.ItemCallback<AlbumModel>() {
        override fun areItemsTheSame(oldItem: AlbumModel, newItem: AlbumModel): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: AlbumModel, newItem: AlbumModel): Boolean {
            return oldItem == newItem
        }
    }

    interface AlbumListener {
        fun onAlbumClick(album: AlbumModel)
    }
}