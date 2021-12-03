package com.example.firstapp.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.firstapp.databinding.ItemBinding
import com.example.firstapp.model.Item
import com.example.firstapp.util.getBaseImageUrl
import com.squareup.picasso.Picasso

class ItemListAdapter(private var dataSet: List<Item>) :
    RecyclerView.Adapter<ItemListAdapter.ViewHolder>() {

    class ViewHolder(private val binding: ItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(dataSet: List<Item>, position: Int) {
            Picasso.get().load("${getBaseImageUrl()}/item/${dataSet[position].id}.png").into(binding.itemImage)
            binding.itemName.text = dataSet[position].name
        }
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemBinding.inflate(LayoutInflater.from(viewGroup.context), viewGroup, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        viewHolder.bind(dataSet, position)
    }

    override fun getItemCount() = dataSet.size

    fun setData(newDataSet: List<Item>) {
        dataSet = newDataSet
        notifyDataSetChanged()
    }

}
