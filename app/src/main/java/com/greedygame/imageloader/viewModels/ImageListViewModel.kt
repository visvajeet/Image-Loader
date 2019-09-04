package com.greedygame.imageloader.viewModels

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.greedygame.imageloader.network.ImageApi
import com.greedygame.imageloader.pojo.ImageData
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ImageListViewModel : ViewModel(){


    private val _navigateToImagePreview = MutableLiveData<String>()
    val navigateToImagePreview:LiveData<String> = _navigateToImagePreview


    override fun onCleared() {
        super.onCleared()
    }



    fun onImageListClicked(url: String){
        _navigateToImagePreview.value = url
    }


    fun onImagePreviewNavigated(){
        _navigateToImagePreview.value = null
    }










}