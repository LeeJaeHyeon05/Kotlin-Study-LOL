package com.example.firstapp.scene.champion.info

import com.example.firstapp.R
import com.example.firstapp.databinding.FragmentChampionRowItemBinding
import com.example.firstapp.databinding.FragmentChampionSummaryBinding
import com.example.firstapp.scene.champion.ChampionInfoVO
import com.squareup.picasso.Picasso
import com.xwray.groupie.databinding.BindableItem

/**
 * @author hanago
 * @email kottodat@naver.com
 * @since 2021/11/19
 **/

class ChampionSummaryItem(private val championInfo: ChampionInfoVO) :
    BindableItem<FragmentChampionSummaryBinding>() {
    override fun bind(viewBinding: FragmentChampionSummaryBinding, position: Int) {
        viewBinding.tvName.text = championInfo.name
        viewBinding.tvScript.text = championInfo.script
        Picasso.get()
            .load(championInfo.imgUrl)
            .into(viewBinding.ivThumbnail)
    }

    override fun getLayout() = R.layout.fragment_champion_summary
}