package com.rustam.testgif.presentation.main

import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.rustam.testgif.databinding.GifItemBinding
import com.rustam.testgif.presentation.entities.UiGif

class GifItemViewHolder(private val binding: GifItemBinding) : RecyclerView.ViewHolder(binding.root) {

    fun bind(gif: UiGif, itemClickListener: (UiGif) -> Unit) {
        itemView.setOnClickListener {
            itemClickListener(gif)
        }

        with(binding) {
            Glide.with(binding.root)
                .load(gif.previewUrl)
                .into(imageView)
        }

    }

}