package com.example.firstapp.scene.champion.info

import com.example.firstapp.R
import com.example.firstapp.databinding.FragmentChampionSummaryBinding
import com.example.firstapp.model.champion.Champion
import com.squareup.picasso.Picasso
import com.xwray.groupie.databinding.BindableItem

/**
 * @author hanago
 * @email kottodat@naver.com
 * @since 2021/11/19
 **/

class ChampionSummaryItem(private val championInfo: Champion) :
    BindableItem<FragmentChampionSummaryBinding>() {
    override fun bind(viewBinding: FragmentChampionSummaryBinding, position: Int) {
        viewBinding.tvName.text = championInfo.name
        viewBinding.tvScript.text = championInfo.title
        Picasso.get()
            .load("http://ddragon.leagueoflegends.com/cdn/11.23.1/img/champion/" + championInfo.image.full)
            .into(viewBinding.ivThumbnail)
    }

    override fun getLayout() = R.layout.fragment_champion_summary
}