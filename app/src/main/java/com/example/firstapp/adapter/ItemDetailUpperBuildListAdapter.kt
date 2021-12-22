package com.example.firstapp.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.firstapp.databinding.ItemUpperbuildBinding
import com.example.firstapp.model.Item
import com.example.firstapp.util.getBaseImageUrl
import com.squareup.picasso.Picasso

class ItemDetailUpperBuildListAdapter(private var dataSet: List<Item>, private var handleClickItem: (String) -> Unit) :
    RecyclerView.Adapter<ItemDetailUpperBuildListAdapter.ViewHolder>() {

    class ViewHolder(private val binding: ItemUpperbuildBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(dataSet: List<Item>, position: Int, handleClickItem: (String) -> Unit) {
            Picasso.get().load("${getBaseImageUrl()}/item/${dataSet[position].id}.png").into(binding.itemImage)
            binding.itemName.text = dataSet[position].name
            binding.itemImage.setOnClickListener {
                handleClickItem(dataSet[position].id)
            }
        }
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemUpperbuildBinding.inflate(LayoutInflater.from(viewGroup.context), viewGroup, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        viewHolder.bind(dataSet, position, handleClickItem)
    }

    override fun getItemCount() = dataSet.size

}
