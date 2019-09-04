package com.greedygame.imageloader.pojo

import com.squareup.moshi.Json


data class ImageData(val id:String,
                     @Json(name = "urls")
                     val imagesUrl: Map<String,String>
)
