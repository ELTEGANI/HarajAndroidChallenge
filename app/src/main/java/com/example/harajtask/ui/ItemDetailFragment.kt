package com.example.harajtask.ui

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.harajtask.R
import com.example.harajtask.databinding.ItemDetailFragmentBinding
import com.example.harajtask.utils.ItemsProperties
import com.example.harajtask.viewmodel.ItemDetailViewModel


class ItemDetailFragment : Fragment() {

    private lateinit var itemDetailFragmentBinding : ItemDetailFragmentBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        itemDetailFragmentBinding = DataBindingUtil.inflate(inflater, R.layout.item_detail_fragment,container,false)
        itemDetailFragmentBinding.lifecycleOwner = this
        displayItemDetails(ItemDetailFragmentArgs.fromBundle(requireArguments()).selectedItem)
        shareTitlePost()
        return itemDetailFragmentBinding.root
    }

    private fun shareTitlePost() {
        itemDetailFragmentBinding.shareIconImageView.setOnClickListener {
            val sendIntent: Intent = Intent().apply {
                action = Intent.ACTION_SEND
                putExtra(Intent.EXTRA_TEXT, itemDetailFragmentBinding.titleTextView.text.toString())
                type = "text/plain"
            }
            val shareIntent = Intent.createChooser(sendIntent, null)
            startActivity(shareIntent)
        }
    }

    private fun displayItemDetails(itemDetail: ItemsProperties) {
        itemDetailFragmentBinding.titleTextView.text = itemDetail.title
        itemDetailFragmentBinding.durationTextView.text = itemDetail.date
        itemDetailFragmentBinding.userNameTextView.text = itemDetail.username
        itemDetailFragmentBinding.locationTextView.text = itemDetail.city
        itemDetailFragmentBinding.descriptionTextView.text = itemDetail.body
        Glide.with(itemDetailFragmentBinding.itemImageView.context)
            .load(itemDetail.thumbURL)
            .apply(
                RequestOptions()
                    .placeholder(R.drawable.loading_animation)
                    .error(R.drawable.ic_broken_image)
            )
            .into(itemDetailFragmentBinding.itemImageView)
    }


}