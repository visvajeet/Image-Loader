package com.greedygame.imageloader.pojo

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.greedygame.imageloader.image_loader.ImageLoader
import com.squareup.moshi.Json
import org.json.JSONArray
import org.json.JSONObject


data class ImageData(val id:String,
                     @Json(name = "urls")
                     val imagesUrl: Map<String,String>
)
