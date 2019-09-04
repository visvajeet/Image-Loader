/*
 * Copyright 2018, The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.greedygame.imageloader.adapter

import android.os.Handler
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.greedygame.imageloader.databinding.ImageItemBinding
import com.greedygame.imageloader.pojo.ImageData


class ImageLoadAdapter(private val items: List<ImageData>, private val listener: ImageListListener ) : RecyclerView.Adapter<ImageLoadAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ImageItemBinding.inflate(inflater)
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(items[position],listener)
    }


    inner class ViewHolder(private val binding: ImageItemBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(
            item: ImageData,
            listener: ImageListListener
        ) {
           binding.item = item
           binding.clickListener = listener
           binding.executePendingBindings()
        }

    }

    class ImageListListener(val clickListener:(image: String) -> Unit){
        fun onCLick(image:ImageData){
            Handler().postDelayed({
                clickListener(image.imagesUrl["regular"] ?: error(""))
            }, 100)

        }
    }






}
