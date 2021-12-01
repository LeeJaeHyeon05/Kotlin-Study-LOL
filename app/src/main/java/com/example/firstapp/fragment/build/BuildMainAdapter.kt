package com.example.firstapp.fragment.build

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.firstapp.databinding.ItemBuildMainBinding
import com.example.firstapp.model.mychampion.Datum

class BuildMainAdapter(val context : Context?, var championList : List<Datum>): RecyclerView.Adapter<BuildMainAdapter.ItemViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder =
        ItemViewHolder(ItemBuildMainBinding.inflate(LayoutInflater.from(parent.context), parent, false))

    override fun getItemCount(): Int {
        return championList.size
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        holder.setData(championList[position])

        holder.binding.championImage.setOnClickListener {
            openDetailFragment()

        }
    }

    private fun openDetailFragment() {
        val intent = Intent(context, BuildDetailActivity::class.java)
        context?.startActivity(intent)
    }

    class ItemViewHolder(val binding: ItemBuildMainBinding): RecyclerView.ViewHolder(binding.root){
        fun setData(championData: Datum){
            binding.championData = championData
        }
    }
}