package com.greedygame.imageloader

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.greedygame.imageloader.image_loader.ImageLoader


class Utils{
    companion object {
        @BindingAdapter("imageUrl")
        @JvmStatic
        fun loadImage(view: ImageView, imageUrl: String) {
             ImageLoader.with(view.context).load(view, imageUrl)
           // Picasso.get().load(imageUrl).into(view)
        }
    }
}
