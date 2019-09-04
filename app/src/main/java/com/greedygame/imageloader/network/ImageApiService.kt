package com.greedygame.imageloader.network

import com.greedygame.imageloader.pojo.ImageData
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET


private const val ACCESS_KEY = "b8797ed87e4568f14bd3da4aec088534c47da92913e57b81d41ac85de9e9a7c0"
private const val BASE_URL = "https://api.unsplash.com/"

private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

private val retrofit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .baseUrl(BASE_URL)
    .build()


interface ImageApiService {
    @GET("photos/?client_id=$ACCESS_KEY")
    fun getProperties():
            Call<List<ImageData>>
}

object ImageApi {
    val retrofitService : ImageApiService by lazy {
        retrofit.create(ImageApiService::class.java)
    }
}