package com.greedygame.imageloader.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.greedygame.imageloader.R
import com.greedygame.imageloader.databinding.ImagePreviewBinding
import com.greedygame.imageloader.viewModels.ImagePreviewViewModel



class ImagePreviewFragment : Fragment() {

    lateinit var binding: ImagePreviewBinding
    lateinit var viewModel: ImagePreviewViewModel


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        binding = DataBindingUtil.inflate(inflater,R.layout.image_preview,container,false)
        viewModel  = ViewModelProvider(this).get(ImagePreviewViewModel::class.java)
        binding.viewModel = viewModel
        binding.lifecycleOwner = this

        val args = arguments?.let { ImagePreviewFragmentArgs.fromBundle(it) }

        viewModel.showImage(args?.url!!)

        viewModel.backPress.observe(this, Observer {
            if(it){
                this.findNavController().navigate(ImagePreviewFragmentDirections.actionImagePreviewFragmentToImageListFragment())
                viewModel.onBackPressedDone()
            }
        })

        binding.imageButtonBack.setOnClickListener {
            viewModel.onBackPressed()
        }

        return binding.root
    }


}
