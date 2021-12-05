package com.example.firstapp.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.firstapp.databinding.ItemFilterBinding
import com.example.firstapp.model.ItemFilter

class ItemFilterListAdapter(private var dataSet: List<ItemFilter>) :
    RecyclerView.Adapter<ItemFilterListAdapter.ViewHolder>() {

    class ViewHolder(private val binding: ItemFilterBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(dataSet: List<ItemFilter>, position: Int) {
            binding.itemFilterText.text = dataSet[position].name
        }
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemFilterBinding.inflate(LayoutInflater.from(viewGroup.context), viewGroup, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        viewHolder.bind(dataSet, position)
    }

    override fun getItemCount() = dataSet.size

}
