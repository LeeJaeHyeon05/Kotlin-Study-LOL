package com.example.firstapp.scene.champion.info

import androidx.lifecycle.MutableLiveData
import com.example.firstapp.R
import com.example.firstapp.databinding.FragmentChampionTabMenuBinding
import com.example.firstapp.model.champion.Champion
import com.xwray.groupie.databinding.BindableItem

/**
 * @author hanago
 * @email kottodat@naver.com
 * @since 2021/11/19
 **/

class ChampionTabMenuItem(private val championInfo: Champion, val selectedTab: MutableLiveData<Int>) :
    BindableItem<FragmentChampionTabMenuBinding>() {
    override fun bind(viewBinding: FragmentChampionTabMenuBinding, position: Int) {
        viewBinding.tvBasic.setOnClickListener { selectedTab.postValue(0) }
        viewBinding.tvSkill.setOnClickListener { selectedTab.postValue(1) }
        viewBinding.tvStory.setOnClickListener { selectedTab.postValue(2) }
        viewBinding.tvSkin.setOnClickListener { selectedTab.postValue(3) }
        viewBinding.tvRelease.setOnClickListener { selectedTab.postValue(4) }
    }

    override fun getLayout() = R.layout.fragment_champion_tab_menu
}