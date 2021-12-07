package com.example.firstapp.adapter.ChampTier

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.firstapp.R
import com.example.firstapp.databinding.ItemTier1Binding
import com.squareup.picasso.Picasso

/**
 * @author mmol93
 * @email ljws93@naver.com
 * @since 2021/11/10
 **/
class Tier1Adapter(val context: Context) : RecyclerView.Adapter<Tier1ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Tier1ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = DataBindingUtil.inflate<ItemTier1Binding>(
            layoutInflater,
            R.layout.item_tier1,
            parent,
            false
        )
        return Tier1ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: Tier1ViewHolder, position: Int) {
        Glide.with(context)
            .load("http://ddragon.leagueoflegends.com/cdn/11.23.1/img/champion/Aatrox.png")
            .placeholder(R.drawable.camille_chac).into(holder.champImage)
    }

    override fun getItemCount(): Int {
        return 4
    }
}

class Tier1ViewHolder(val binding: ItemTier1Binding) : RecyclerView.ViewHolder(binding.root) {
    var champImage = binding.champImage
}