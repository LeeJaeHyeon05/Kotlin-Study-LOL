package com.example.firstapp.groupie

import android.view.View
import com.example.firstapp.R
import com.example.firstapp.databinding.ItemFilterBinding
import com.example.firstapp.model.ItemFilter
import com.xwray.groupie.viewbinding.BindableItem

class GroupieItemFilter(val itemFilter: ItemFilter) : BindableItem<ItemFilterBinding>() {

    override fun getLayout() = R.layout.item_filter

    override fun bind(binding: ItemFilterBinding, position: Int) {

        binding.itemFilterText.text = itemFilter.name
        when (itemFilter.selected) {
            true -> binding.itemFilterCheck.visibility = View.VISIBLE
            false -> binding.itemFilterCheck.visibility = View.GONE
        }
    }

    override fun initializeViewBinding(view: View): ItemFilterBinding = ItemFilterBinding.bind(view)

}