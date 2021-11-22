package com.example.firstapp.scene.champion.info

import com.example.firstapp.R
import com.example.firstapp.databinding.FragmentChampionRowItemBinding
import com.example.firstapp.scene.champion.ChampionInfoVO
import com.squareup.picasso.Picasso
import com.xwray.groupie.databinding.BindableItem

/**
 * @author hanago
 * @email kottodat@naver.com
 * @since 2021/11/19
 **/

class ChampionGeneralFragment(private val championInfo: ChampionInfoVO) :
    BindableItem<FragmentChampionRowItemBinding>() {
    override fun bind(viewBinding: FragmentChampionRowItemBinding, position: Int) {
        viewBinding.tvName.text = championInfo.name
        viewBinding.tvScript.text = championInfo.script
        Picasso.get()
            .load(championInfo.imgUrl)
            .into(viewBinding.ivFullImage)
    }

    override fun getLayout() = R.layout.fragment_champion_summary
}