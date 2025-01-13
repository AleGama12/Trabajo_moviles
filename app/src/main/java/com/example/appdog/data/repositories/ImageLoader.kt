package com.example.appdog.data.repositories

import android.widget.ImageView
import com.squareup.picasso.Picasso

object ImageLoader {
    fun loadImage(url: String, imageView: ImageView) {
        Picasso.get()
            .load(url)
            .fit()
            .centerCrop()
            .into(imageView)
    }
}