package com.example.kotlin_demo.utils

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide

@BindingAdapter("imageUrl")
fun ImageView.imageUrl(url: String) {
    //Glide is a third party library to load image.
    Glide.with(this.context).load(url).into(this)
}