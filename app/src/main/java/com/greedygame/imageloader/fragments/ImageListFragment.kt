package com.greedygame.imageloader.fragments

import android.os.Bundle
import android.os.Parcelable
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.greedygame.imageloader.R
import com.greedygame.imageloader.adapter.ImageLoadAdapter
import com.greedygame.imageloader.databinding.ImageListBinding
import com.greedygame.imageloader.network.ImageApi
import com.greedygame.imageloader.pojo.ImageData
import com.greedygame.imageloader.viewModels.ImageListViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class ImageListFragment : Fragment() {

    lateinit var binding: ImageListBinding
    lateinit var imageListViewModel: ImageListViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        binding = DataBindingUtil.inflate(inflater,R.layout.image_list,container,false)


        imageListViewModel = ViewModelProvider(this).get(ImageListViewModel::class.java)
        binding.viewModel = imageListViewModel
        binding.lifecycleOwner = this


        imageListViewModel.imageList.observe(this, Observer { it ->

                binding.recycleViewImages.adapter = ImageLoadAdapter(it, ImageLoadAdapter.ImageListListener {
                    imageListViewModel.onImageListClicked(it)
                })

        })

        imageListViewModel.isError.observe(this, Observer {
            if(it){
                Toast.makeText(this.activity,"Something went wrong please try again.",Toast.LENGTH_LONG).show()
                imageListViewModel.errorCleared()
            }
        })


        imageListViewModel.navigateToImagePreview.observe(this, Observer {
            it?.let {
                this.findNavController().navigate(ImageListFragmentDirections.actionImageListFragmentToImagePreviewFragment(it))
                imageListViewModel.onImagePreviewNavigated()
            }
        })




        return binding.root
    }





}
