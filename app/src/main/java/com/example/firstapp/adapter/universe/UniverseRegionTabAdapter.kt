package com.example.firstapp.adapter.universe

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.firstapp.databinding.FragmentUniverseRegionItemBinding
import com.example.firstapp.model.universe.UniverseRegion

class UniverseRegionTabAdapter(val context: Context?, var itemList: ArrayList<UniverseRegion>): RecyclerView.Adapter<UniverseRegionTabAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder =
        ViewHolder(FragmentUniverseRegionItemBinding.inflate(LayoutInflater.from(parent.context), parent, false))

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.setData(itemList[position])
    }

    override fun getItemCount(): Int =
        itemList.size

    class ViewHolder(val binding: FragmentUniverseRegionItemBinding): RecyclerView.ViewHolder(binding.root) {
        fun setData(item: UniverseRegion) {
            binding.regionBackgroundImg.setImageResource(item.img)
            binding.regionIcon.setBackgroundResource(item.icon)
            binding.regionName.text = item.name
        }
    }
}