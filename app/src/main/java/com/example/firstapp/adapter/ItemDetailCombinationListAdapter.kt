package com.example.firstapp.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.firstapp.databinding.ItemCombinationBinding
import com.example.firstapp.model.Item
import com.example.firstapp.util.getBaseImageUrl
import com.squareup.picasso.Picasso

class ItemDetailCombinationListAdapter(private var dataSet: List<Item>, private var handleClickItem: (String) -> Unit) :
    RecyclerView.Adapter<ItemDetailCombinationListAdapter.ViewHolder>() {

    class ViewHolder(private val binding: ItemCombinationBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(dataSet: List<Item>, position: Int, handleClickItem: (String) -> Unit) {
            Picasso.get().load("${getBaseImageUrl()}/item/${dataSet[position].id}.png").into(binding.itemImage)
            binding.itemName.text = dataSet[position].name
            binding.itemImage.setOnClickListener {
                handleClickItem(dataSet[position].id)
            }
            binding.itemPrice.text = "${dataSet[position].itemGold?.total} (${dataSet[position].itemGold?.base})"
        }
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemCombinationBinding.inflate(LayoutInflater.from(viewGroup.context), viewGroup, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        viewHolder.bind(dataSet, position, handleClickItem)
    }

    override fun getItemCount() = dataSet.size

}
