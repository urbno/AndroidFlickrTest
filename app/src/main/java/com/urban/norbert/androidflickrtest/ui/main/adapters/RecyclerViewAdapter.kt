package com.urban.norbert.androidflickrtest.ui.main.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import com.urban.norbert.androidflickrtest.R
import com.urban.norbert.androidflickrtest.model.Photo

class RecyclerViewAdapter(private val imageClickListener: (photo: Photo) -> Unit) :
    PagingDataAdapter<Photo, RecyclerViewAdapter.ImageViewHolder>(PhotosComparator) {

    override fun onBindViewHolder(holder: ImageViewHolder, position: Int) {
        getItem(position)?.let { holder.bindItem(it) }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImageViewHolder =
        ImageViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.image_item, parent, false)
        )

    inner class ImageViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        fun bindItem(photo: Photo) {
            val image = itemView.findViewById<ImageView>(R.id.image_thumbnail)
            photo.url_h?.let {
                if (photo.url_h.isNotEmpty()) {
                    val url = photo.url_h.replace("\\/", "/")
                    image.setOnClickListener {
                        imageClickListener(photo)
                    }
                    Picasso.get().load(url).into(image)
                }
            }
        }
    }

    private object PhotosComparator : DiffUtil.ItemCallback<Photo>() {
        override fun areItemsTheSame(oldItem: Photo, newItem: Photo): Boolean =
            oldItem.id == newItem.id


        override fun areContentsTheSame(oldItem: Photo, newItem: Photo): Boolean =
            oldItem == newItem
    }
}