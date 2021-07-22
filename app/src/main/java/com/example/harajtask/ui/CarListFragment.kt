package com.example.harajtask.ui

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import com.example.harajtask.R
import com.example.harajtask.databinding.CarListFragmentBinding
import com.example.harajtask.utils.CarsAdapter
import com.example.harajtask.viewmodel.CarListViewModel
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class CarListFragment : Fragment() {

    private val carListViewModel: CarListViewModel by viewModels()
    private lateinit var carListFragmentBinding: CarListFragmentBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,savedInstanceState: Bundle?): View? {
        carListFragmentBinding = DataBindingUtil.inflate(inflater, R.layout.car_list_fragment,container,false)
        carListFragmentBinding.lifecycleOwner = this

        val carsAdapter = CarsAdapter()

        carListFragmentBinding.carsList.adapter = carsAdapter

        carListViewModel.carProperties.observe(viewLifecycleOwner,{
            it.let {
                carsAdapter.submitList(it)
            }
          }
        )


        return carListFragmentBinding.root
    }

}