package com.example.harajtask.utils

import android.annotation.SuppressLint
import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.harajtask.R


@BindingAdapter("imageUrl")
fun setImageUrl(imageView: ImageView, url: String) {
    Glide.with(imageView.context)
        .load(url)
        .apply(
            RequestOptions()
            .placeholder(R.drawable.loading_animation)
            .error(R.drawable.ic_broken_image))
        .into(imageView)
}


@BindingAdapter("timeDuration")
fun TextView.setTimeTextView(itemsProperties: ItemsProperties) {
    itemsProperties.let {
        text = convertLongToDate(itemsProperties.date.toLong())?.getTimeAgo()
    }
}

@SuppressLint("SetTextI18n")
@BindingAdapter("title")
fun TextView.setTitleTextView(itemsProperties: ItemsProperties) {
    itemsProperties.let {
        if(itemsProperties.title.length >= 30){
           text = itemsProperties.title.substring(0,20)+ "..."
        }else{
            text = itemsProperties.title
        }
    }
}