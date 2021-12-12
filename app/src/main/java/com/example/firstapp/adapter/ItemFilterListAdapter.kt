package com.example.firstapp.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.firstapp.databinding.ItemFilterBinding
import com.example.firstapp.model.ItemFilter

class ItemFilterListAdapter(private var dataSet: List<ItemFilter>, private var handleClickItemFilter: (String) -> Unit) :
    RecyclerView.Adapter<ItemFilterListAdapter.ViewHolder>() {

    class ViewHolder(private val binding: ItemFilterBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(dataSet: List<ItemFilter>, position: Int, handleClickItemFilter: (String) -> Unit) {
            binding.itemFilterText.text = dataSet[position].name
            when (dataSet[position].selected) {
                true -> binding.itemFilterCheck.visibility = View.VISIBLE
                false -> binding.itemFilterCheck.visibility = View.GONE
            }
            binding.itemFilterLayout.setOnClickListener {
                handleClickItemFilter(dataSet[position].key)
            }
        }
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemFilterBinding.inflate(LayoutInflater.from(viewGroup.context), viewGroup, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        viewHolder.bind(dataSet, position, handleClickItemFilter)
    }

    override fun getItemCount() = dataSet.size

}
