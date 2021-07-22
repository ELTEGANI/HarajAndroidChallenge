package com.example.harajtask.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.harajtask.utils.CarsProperties
import com.example.harajtask.repository.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class CarListViewModel @Inject constructor(private val repository: Repository): ViewModel() {

    private val _carProperties = MutableLiveData<List<CarsProperties>>()
    val carProperties: LiveData<List<CarsProperties>>
        get() = _carProperties

    init {
        displayCarsListProperties()
    }

    private fun displayCarsListProperties(){
        viewModelScope.launch {
           _carProperties.value =  repository.retrieveAllCarsProperties()
        }
    }

}