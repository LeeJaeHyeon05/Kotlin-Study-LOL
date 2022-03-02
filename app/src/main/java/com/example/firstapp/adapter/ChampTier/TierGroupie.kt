package com.example.firstapp.adapter.ChampTier

import android.content.Context
import com.bumptech.glide.Glide
import com.example.firstapp.R
import com.example.firstapp.database.AppDatabase
import com.example.firstapp.databinding.ItemTierBinding
import com.example.firstapp.model.tier.TierChamp
import com.example.firstapp.util.translateToEn
import com.xwray.groupie.databinding.BindableItem
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class TierGroupie(val context: Context, val database:AppDatabase, val tierData: ArrayList<TierChamp>): BindableItem<ItemTierBinding>(){
    override fun bind(binding: ItemTierBinding, position: Int) {
        val championName = tierData[position].championName

        CoroutineScope(Dispatchers.Main).launch {
            val championName_en = translateToEn(database, championName)
            Glide.with(context)
                .load("http://ddragon.leagueoflegends.com/cdn/11.22.1/img/champion/$championName_en.png")
                .placeholder(R.drawable.unknown).into(binding.champImage)
            binding.champName.text = tierData[position].championName
            binding.champWinRate.text = tierData[position].winRate
        }
    }

    override fun getLayout(): Int {
        return R.layout.item_tier
    }
}