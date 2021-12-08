package com.example.firstapp.adapter.ChampTier

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.firstapp.R
import com.example.firstapp.databinding.ItemTierBinding
import com.example.firstapp.model.tier.TierChamp

/**
 * @author mmol93
 * @email ljws93@naver.com
 * @since 2021/11/10
 **/
class Tier1Adapter(val context: Context) : RecyclerView.Adapter<Tier1ViewHolder>() {
    // DiffUtil로 다른 부분만 업데이트 한다
    private val diiUtilCallback = object : DiffUtil.ItemCallback<TierChamp>(){
        override fun areItemsTheSame(oldItem: TierChamp, newItem: TierChamp): Boolean {
            return oldItem.championName == newItem.championName
        }

        override fun areContentsTheSame(oldItem: TierChamp, newItem: TierChamp): Boolean {
            return oldItem == newItem
        }
    }

    val differ = AsyncListDiffer(this, diiUtilCallback)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Tier1ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = DataBindingUtil.inflate<ItemTierBinding>(
            layoutInflater,
            R.layout.item_tier,
            parent,
            false
        )
        return Tier1ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: Tier1ViewHolder, position: Int) {
        Glide.with(context)
            .load("http://ddragon.leagueoflegends.com/cdn/11.22.1/img/champion/Aatrox.png")
            .placeholder(R.drawable.camille_chac).into(holder.champImage)
        holder.champName.text = differ.currentList[position].championName
        holder.chapWinRate.text = differ.currentList[position].winRate
    }

    override fun getItemCount(): Int {
        return differ.currentList.size
    }

}

class Tier1ViewHolder(val binding: ItemTierBinding) : RecyclerView.ViewHolder(binding.root) {
    val champImage = binding.champImage
    val champName = binding.champName
    val chapWinRate = binding.champWinRate
}