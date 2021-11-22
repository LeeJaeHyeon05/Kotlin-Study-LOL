package com.example.firstapp.scene.champion.info

import com.example.firstapp.R
import com.example.firstapp.databinding.FragmentChampionTabMenuBinding
import com.example.firstapp.scene.champion.ChampionInfoVO
import com.squareup.picasso.Picasso
import com.xwray.groupie.databinding.BindableItem

/**
 * @author hanago
 * @email kottodat@naver.com
 * @since 2021/11/19
 **/

class ChampionTabMenuItem(private val championInfo: ChampionInfoVO) :
    BindableItem<FragmentChampionTabMenuBinding>() {
    override fun bind(viewBinding: FragmentChampionTabMenuBinding, position: Int) {
    }

    override fun getLayout() = R.layout.fragment_champion_tab_menu
}