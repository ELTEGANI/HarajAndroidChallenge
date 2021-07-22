package com.example.harajtask.utils

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