package com.example.firstapp.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.firstapp.databinding.ItemBinding
import com.example.firstapp.model.Data
import com.squareup.picasso.Picasso

class ItemListAdapter(private var dataSet: List<Data>) :
    RecyclerView.Adapter<ItemListAdapter.ViewHolder>() {

    class ViewHolder(private val binding: ItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(dataSet: List<Data>, position: Int) {
            Picasso.get().load("https://ddragon.leagueoflegends.com/cdn/11.22.1/img/item/${dataSet.get(position).id}.png").into(binding.itemImage)
            binding.itemName.text = dataSet.get(position).name
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

    fun setData(newDataSet: List<Data>) {
        dataSet = newDataSet
        notifyDataSetChanged()
    }

}
