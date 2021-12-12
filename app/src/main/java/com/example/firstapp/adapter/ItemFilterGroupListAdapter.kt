package com.example.firstapp.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.firstapp.databinding.ItemFilterGroupBinding
import com.example.firstapp.model.ItemFilterGroup

class ItemFilterGroupListAdapter(private var dataSet: ArrayList<ItemFilterGroup>, private var handleClickItemFilter: (String) -> Unit) :
    RecyclerView.Adapter<ItemFilterGroupListAdapter.ViewHolder>() {

    class ViewHolder(private val binding: ItemFilterGroupBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(dataSet: List<ItemFilterGroup>, position: Int, handleClickItemFilter: (String) -> Unit) {
            binding.group.text = dataSet[position].group
            binding.itemFilterRecyclerView.isNestedScrollingEnabled = false
            binding.itemFilterRecyclerView.run {
                adapter = ItemFilterListAdapter(dataSet[position].itemFilterList, handleClickItemFilter)
                layoutManager = LinearLayoutManager(context)
            }
        }
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemFilterGroupBinding.inflate(LayoutInflater.from(viewGroup.context), viewGroup, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        viewHolder.bind(dataSet, position, handleClickItemFilter)
    }

    override fun getItemCount() = dataSet.size

}
