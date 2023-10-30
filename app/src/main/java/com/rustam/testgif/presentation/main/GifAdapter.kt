package com.rustam.testgif.presentation.main

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.rustam.testgif.databinding.GifItemBinding
import com.rustam.testgif.presentation.entities.UiGif

class GifAdapter : RecyclerView.Adapter<GifItemViewHolder>() {

    var gifs: List<UiGif> = emptyList()
        set(newValue) {
            field = newValue
            notifyDataSetChanged()
        }

    var itemClickListener: (UiGif) -> Unit = {}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GifItemViewHolder =
        GifItemViewHolder(
            GifItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )


    override fun onBindViewHolder(viewHolder: GifItemViewHolder, position: Int) {
        val gif = gifs[position]
        viewHolder.bind(gif, itemClickListener)
    }

    override fun getItemCount(): Int = gifs.size

}