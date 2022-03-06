package com.example.firstapp.groupie

import android.view.View
import com.example.firstapp.R
import com.example.firstapp.databinding.ItemFilterHeaderBinding
import com.xwray.groupie.viewbinding.BindableItem

class GroupieItemFilterHeader(private val title: String) : BindableItem<ItemFilterHeaderBinding>() {

    override fun getLayout() = R.layout.item_filter_header

    override fun bind(binding: ItemFilterHeaderBinding, position: Int) {
        binding.group.text = title
    }

    override fun initializeViewBinding(view: View): ItemFilterHeaderBinding = ItemFilterHeaderBinding.bind(view)

}