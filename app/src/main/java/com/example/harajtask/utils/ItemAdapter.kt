package com.example.harajtask.utils

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.harajtask.databinding.ItemListBinding

class ItemAdapter(private val onClickListener: OnClickListener):  ListAdapter<ItemsProperties,ItemAdapter.ViewHolder>(
    ItemDiffCallback()
){
    override fun onCreateViewHolder(parent: ViewGroup,viewType:Int): ViewHolder {
        return ViewHolder.from(parent)
    }


    override fun onBindViewHolder(holder: ViewHolder, position:Int){
        holder.bind(getItem(position),onClickListener)
    }


    class ViewHolder private constructor(private var itemListBinding: ItemListBinding):
        RecyclerView.ViewHolder(itemListBinding.root) {
        fun bind(
            itemsProperties: ItemsProperties,
            onClickListener: OnClickListener
        ) {
            itemListBinding.itemsProperties = itemsProperties
            itemListBinding.clickListener = onClickListener
            itemListBinding.executePendingBindings()
        }


        companion object {
            fun from(parent: ViewGroup): ViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = ItemListBinding.inflate(layoutInflater, parent, false)
                return ViewHolder(binding)
            }
        }

    }
}


class ItemDiffCallback: DiffUtil.ItemCallback<ItemsProperties>(){
    override fun areItemsTheSame(oldItem: ItemsProperties, newItem: ItemsProperties): Boolean {
        return oldItem.title == newItem.title
    }
    override fun areContentsTheSame(oldItem: ItemsProperties, newItem: ItemsProperties): Boolean {
        return oldItem == newItem
    }
}




class OnClickListener(val onClickListener:(itemsProperties: ItemsProperties)->Unit){
    fun onClick(itemsProperties: ItemsProperties) = onClickListener(itemsProperties)
}