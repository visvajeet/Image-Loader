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



    private val _imageList = MutableLiveData<ArrayList<ImageData>>()
    val imageList:LiveData<ArrayList<ImageData>> = _imageList


    private val _navigateToImagePreview = MutableLiveData<String>()
    val navigateToImagePreview:LiveData<String> = _navigateToImagePreview

    private val _isError =  MutableLiveData<Boolean>()
    val isError: LiveData<Boolean> = _isError

    private val _isLoading =  MutableLiveData<Boolean>()
    val isLoading: LiveData<Boolean> = _isLoading


    init {

        _isError.value = false
        _isLoading.value = false

         loadData()


    }



    fun onImageListClicked(url: String){
        _navigateToImagePreview.value = url
    }


    fun onImagePreviewNavigated(){
        _navigateToImagePreview.value = null
    }


    fun errorCleared(){
        _isError.value = false
    }

    fun loadingDone(){
        _isLoading.value = false
    }


    fun loadData(){

        _isLoading.value = true

        ImageApi.retrofitService.getProperties().enqueue( object: Callback<List<ImageData>> {

            override fun onFailure(call: Call<List<ImageData>>, t: Throwable) {
                Log.i("ERROR", t.message)
                _isError.value = true
                _isLoading.value = false
            }

            override fun onResponse(call: Call<List<ImageData>>, response: Response<List<ImageData>>) {
                _imageList.value = ((response.body() as ArrayList<ImageData>?)!!)
                _isLoading.value = false
            }
        })
    }








}