package com.example.firstapp.scene.champion

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.example.firstapp.R
import com.example.firstapp.databinding.FragmentChampionRowItemBinding
import com.example.firstapp.scene.champion.info.ChampionInfoFragment
import com.squareup.picasso.Picasso
import com.xwray.groupie.databinding.BindableItem

/**
 * @author hanago
 * @email kottodat@naver.com
 * @since 2021/11/19
 **/

class ChampionListItem(val fragmentManager: FragmentManager, private val championInfo: ChampionInfoVO) :
    BindableItem<FragmentChampionRowItemBinding>() {
    override fun bind(viewBinding: FragmentChampionRowItemBinding, position: Int) {
        viewBinding.tvName.text = championInfo.name
        viewBinding.tvScript.text = championInfo.script
        Picasso.get()
            .load(championInfo.imgUrl)
            .into(viewBinding.ivFullImage)

        viewBinding.root.setOnClickListener {


            ChampionInfoFragment.newInstance(championInfo.name)
                .show(fragmentManager, "")
        }
    }

    override fun getLayout() = R.layout.fragment_champion_row_item
}