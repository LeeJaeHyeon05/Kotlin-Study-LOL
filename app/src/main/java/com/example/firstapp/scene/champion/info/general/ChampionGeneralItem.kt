package com.example.firstapp.scene.champion.info.general

import com.example.firstapp.R
import com.example.firstapp.databinding.FragmentChampionGeneralBinding
import com.example.firstapp.model.champion.Champion
import com.example.firstapp.view.LiveDataBindableItem

/**
 * @author hanago
 * @email kottodat@naver.com
 * @since 2021/11/19
 **/

class ChampionGeneralItem(private val championInfo: Champion) :
    LiveDataBindableItem<FragmentChampionGeneralBinding>() {

    override fun bind(viewBinding: FragmentChampionGeneralBinding, position: Int) {
    }

    override fun getLayout() = R.layout.fragment_champion_general


}