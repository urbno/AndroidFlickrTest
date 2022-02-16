package com.urban.norbert.androidflickrtest.ui.main.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ProgressBar
import android.widget.TextView
import androidx.core.view.isVisible
import androidx.paging.LoadState
import androidx.paging.LoadStateAdapter
import androidx.recyclerview.widget.RecyclerView
import com.urban.norbert.androidflickrtest.R

class PhotoLoadStateAdapter(private val retry: () -> Unit) :
    LoadStateAdapter<PhotoLoadStateAdapter.LoadStateViewHolder>() {

    inner class LoadStateViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        init {
            itemView.findViewById<Button>(R.id.button_retry).setOnClickListener {
                retry.invoke()
            }
        }
        fun bind(loadState: LoadState) {
            itemView.findViewById<ProgressBar>(R.id.progress_bar).isVisible =
                loadState is LoadState.Loading
            itemView.findViewById<TextView>(R.id.text_view_error).isVisible =
                loadState !is LoadState.Loading
            itemView.findViewById<Button>(R.id.button_retry).isVisible =
                loadState !is LoadState.Loading
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, loadState: LoadState): LoadStateViewHolder =
        LoadStateViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.flickr_photo_load_state_footer, parent, false)
        )

    override fun onBindViewHolder(holder: LoadStateViewHolder, loadState: LoadState) {
        holder.bind(loadState)
    }
}