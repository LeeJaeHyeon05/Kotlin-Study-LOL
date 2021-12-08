package com.example.firstapp.scene.champion.info

import androidx.lifecycle.MutableLiveData
import com.example.firstapp.R
import com.example.firstapp.databinding.FragmentChampionDetailBinding
import com.example.firstapp.model.champion.Champion
import com.example.firstapp.scene.champion.info.general.ChampionGeneralFragment
import com.example.firstapp.view.LiveDataBindableItem
import com.xwray.groupie.GroupieAdapter

/**
 * @author hanago
 * @email kottodat@naver.com
 * @since 2021/11/19
 **/

class ChampionDetailItem(
    private val championInfo: Champion,
    val selectedTab: MutableLiveData<Int>
) :
    LiveDataBindableItem<FragmentChampionDetailBinding>() {
    override fun bind(viewBinding: FragmentChampionDetailBinding, position: Int) {

        val pagerAdapter = GroupieAdapter()

        viewBinding.rvContent.run {
            adapter = pagerAdapter
        }

        // todo 각 메뉴별 해당 정보를 출력하는 페이지로 변경할것
        val arrItems = arrayListOf(
            ChampionGeneralFragment(championInfo),
            ChampionGeneralFragment(championInfo),
            ChampionGeneralFragment(championInfo),
            ChampionGeneralFragment(championInfo),
            ChampionGeneralFragment(championInfo)
        )
        pagerAdapter.update(arrItems)
        selectedTab.observe(this) {
            viewBinding.rvContent.currentItem = it
        }

    }

    override fun getLayout() = R.layout.fragment_champion_detail
}