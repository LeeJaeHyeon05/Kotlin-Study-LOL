package com.example.firstapp.groupie

import android.view.View
import com.example.firstapp.R
import com.example.firstapp.databinding.ItemBinding
import com.example.firstapp.model.Item
import com.example.firstapp.util.getBaseImageUrl
import com.squareup.picasso.Picasso
import com.xwray.groupie.viewbinding.BindableItem

class GroupieItem(val item: Item) : BindableItem<ItemBinding>() {

    override fun getLayout() = R.layout.item

    override fun bind(binding: ItemBinding, position: Int) {
        Picasso.get().load("${getBaseImageUrl()}/item/${item.id}.png").into(binding.itemImage)
        binding.itemName.text = item.name
    }

    override fun initializeViewBinding(view: View): ItemBinding = ItemBinding.bind(view)

}