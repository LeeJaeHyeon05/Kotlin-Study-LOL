package com.example.firstapp.fragment.build

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.firstapp.databinding.ItemBuildMainBinding

class BuildMainAdapter(val context : Context?, var champion_names : MutableList<String>): RecyclerView.Adapter<BuildMainAdapter.ItemViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder =
        ItemViewHolder(ItemBuildMainBinding.inflate(LayoutInflater.from(parent.context), parent, false))

    override fun getItemCount(): Int {
        return champion_names.size
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        holder.setData(champion_names[position])

        holder.binding.championImage.setOnClickListener {
            openDetailFragment()

        }
    }

    private fun openDetailFragment() {
        val intent = Intent(context, BuildDetailActivity::class.java)
        context?.startActivity(intent)
    }

    class ItemViewHolder(val binding: ItemBuildMainBinding): RecyclerView.ViewHolder(binding.root){
        fun setData(champion_name: String){
            binding.championName.text = champion_name
        }
    }
}