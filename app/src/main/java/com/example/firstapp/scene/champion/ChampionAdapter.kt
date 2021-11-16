package com.example.firstapp.scene.champion

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.firstapp.databinding.FragmentChampionRowItemBinding
import com.squareup.picasso.Picasso

/**
 * @author hanago
 * @email kottodat@naver.com
 * @since 2021/11/10
 **/
class ChampionAdapter(private val championList: List<ChampionInfoVO>) :
    RecyclerView.Adapter<ChampionAdapter.ViewHolder>() {
    class ViewHolder(private val binding: FragmentChampionRowItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun onBindView(championInfo: ChampionInfoVO) {
            binding.tvName.text = championInfo.name
            binding.tvScript.text = championInfo.script
            Picasso.get()
                .load(championInfo.imgUrl)
                .into(binding.ivFullImage)
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return ViewHolder(FragmentChampionRowItemBinding.inflate(inflater))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.onBindView(championList[position])
    }

    override fun getItemCount(): Int = championList.size

}