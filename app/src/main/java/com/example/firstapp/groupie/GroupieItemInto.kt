package com.example.firstapp.groupie

import android.view.View
import com.example.firstapp.R
import com.example.firstapp.databinding.ItemUpperbuildBinding
import com.example.firstapp.model.Item
import com.example.firstapp.util.getBaseImageUrl
import com.jakewharton.rxbinding4.view.clicks
import com.squareup.picasso.Picasso
import com.xwray.groupie.viewbinding.BindableItem
import java.util.concurrent.TimeUnit

class GroupieItemInto(val item: Item, private var handleClickItem: (String) -> Unit) : BindableItem<ItemUpperbuildBinding>() {

    override fun getLayout() = R.layout.item_upperbuild

    override fun bind(binding: ItemUpperbuildBinding, position: Int) {
        Picasso.get().load("${getBaseImageUrl()}/item/${item.id}.png").into(binding.itemImage)
        binding.itemName.text = item.name
        binding.itemImage.clicks()
            .throttleFirst(300, TimeUnit.MILLISECONDS)
            .subscribe { handleClickItem(item.id) }
    }

    override fun initializeViewBinding(view: View): ItemUpperbuildBinding = ItemUpperbuildBinding.bind(view)

}