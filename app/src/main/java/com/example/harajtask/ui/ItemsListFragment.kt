package com.example.harajtask.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.harajtask.R
import com.example.harajtask.databinding.ItemListFragmentBinding
import com.example.harajtask.utils.ItemAdapter
import com.example.harajtask.utils.OnClickListener
import com.example.harajtask.viewmodel.ItemsListViewModel
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class ItemsListFragment : Fragment() {

    private val itemsListViewModel: ItemsListViewModel by viewModels()
    private lateinit var itemListFragmentBinding : ItemListFragmentBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,savedInstanceState: Bundle?): View? {
        itemListFragmentBinding = DataBindingUtil.inflate(inflater, R.layout.item_list_fragment,container,false)
        itemListFragmentBinding.lifecycleOwner = this
        setUpNavigation()
        observeItems(setUpAdapter())
        return itemListFragmentBinding.root
    }

    private fun setUpNavigation() {
        itemsListViewModel.navigateToSelectedItem.observe(viewLifecycleOwner, {
            if (null != it) {
                this.findNavController().navigate(
                    ItemsListFragmentDirections.actionCarListFragmentToCarDetailFragment(it)
                )
                itemsListViewModel.displayItemDetailsComplete()
            }
        })
    }

    private fun setUpAdapter(): ItemAdapter {
        val carsAdapter = ItemAdapter(OnClickListener {
            itemsListViewModel.displayItemsDetails(it)
        })

        itemListFragmentBinding.itemsRecyclerView.adapter = carsAdapter
        return carsAdapter
    }

    private fun observeItems(carsAdapter: ItemAdapter) {
        itemsListViewModel.itemProperties.observe(viewLifecycleOwner, {
            it.let {
                carsAdapter.submitList(it)
            }
        }
        )
    }

}