package com.greedygame.imageloader.viewModels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel


class ImagePreviewViewModel: ViewModel(){

   private val _url = MutableLiveData<String>()
   val url : LiveData<String> = _url

   private val _backPress = MutableLiveData<Boolean>()
   var backPress : LiveData<Boolean> = _backPress


   init {
      _url.value = " "
      _backPress.value = false
   }

   fun showImage(url :String){
       _url.value = url

   }

   fun onBackPressed(){
      _backPress.value = true
   }

   fun onBackPressedDone(){
      _backPress.value = false
   }


}