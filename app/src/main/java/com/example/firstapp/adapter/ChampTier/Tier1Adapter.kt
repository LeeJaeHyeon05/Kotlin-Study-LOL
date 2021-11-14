package com.example.firstapp.adapter.ChampTier

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.firstapp.R
import com.example.firstapp.databinding.ItemTier1Binding

class Tier1Adapter:RecyclerView.Adapter<Tier1ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Tier1ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = DataBindingUtil.inflate<ItemTier1Binding>(layoutInflater, R.layout.item_tier1, parent, false)
        return Tier1ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: Tier1ViewHolder, position: Int) {
        holder.bind()
    }

    override fun getItemCount(): Int {
        return 4
    }
}

class Tier1ViewHolder(val binding : ItemTier1Binding):RecyclerView.ViewHolder(binding.root){
    fun bind(){

    }
}