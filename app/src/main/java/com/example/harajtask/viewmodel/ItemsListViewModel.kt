package com.example.harajtask.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.harajtask.utils.ItemsProperties
import com.example.harajtask.repository.ItemsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class ItemsListViewModel @Inject constructor(private val itemsRepository: ItemsRepository): ViewModel() {

    private val _itemProperties = MutableLiveData<List<ItemsProperties>>()
    val itemProperties: LiveData<List<ItemsProperties>>
        get() = _itemProperties

    private val _navigateToSelectedItem = MutableLiveData<ItemsProperties?>()
    val navigateToSelectedItem: MutableLiveData<ItemsProperties?>
        get() = _navigateToSelectedItem


    init {
        displayCarsListProperties()
    }

    private fun displayCarsListProperties(){
        viewModelScope.launch {
           _itemProperties.value =  itemsRepository.retrieveAllCarsProperties()
        }
    }

    fun displayItemsDetails(itemsProperties: ItemsProperties) {
        _navigateToSelectedItem.value = itemsProperties
    }

    fun displayItemDetailsComplete() {
        _navigateToSelectedItem.value = null
    }

}