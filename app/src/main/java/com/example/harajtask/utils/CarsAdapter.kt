package com.example.harajtask.utils

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.harajtask.databinding.CarItemListBinding

class CarsAdapter:  ListAdapter<CarsProperties,CarsAdapter.ViewHolder>(
    CarsDiffCallback()
){
    override fun onCreateViewHolder(parent: ViewGroup,viewType:Int): ViewHolder {
        return ViewHolder.from(parent)
    }


    override fun onBindViewHolder(holder: ViewHolder, position:Int){
        holder.bind(getItem(position)!!)
    }


    class ViewHolder private constructor(private var carsItemListBinding: CarItemListBinding):
        RecyclerView.ViewHolder(carsItemListBinding.root) {
        fun bind(
            carsProperties: CarsProperties
        ) {
            carsItemListBinding.carsProperities = carsProperties
            carsItemListBinding.executePendingBindings()
        }


        companion object {
            fun from(parent: ViewGroup): ViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = CarItemListBinding.inflate(layoutInflater, parent, false)
                return ViewHolder(binding)
            }
        }
    }
}


class CarsDiffCallback: DiffUtil.ItemCallback<CarsProperties>(){
    override fun areItemsTheSame(oldItem: CarsProperties, newItem: CarsProperties): Boolean {
        return oldItem.title == newItem.title
    }
    override fun areContentsTheSame(oldItem: CarsProperties, newItem: CarsProperties): Boolean {
        return oldItem == newItem
    }
}




//class ExpenseListener(val onClickListener:()->Unit){
//    fun onClick(expense: Expenses) = onClickListener(expense)
//}