package com.example.firstapp.scene.champion

import androidx.fragment.app.FragmentManager
import com.example.firstapp.R
import com.example.firstapp.databinding.FragmentChampionRowItemBinding
import com.example.firstapp.model.champion.Champion
import com.example.firstapp.scene.champion.info.ChampionInfoFragment
import com.squareup.picasso.Picasso
import com.xwray.groupie.databinding.BindableItem

/**
 * @author hanago
 * @email kottodat@naver.com
 * @since 2021/11/19
 **/

class ChampionListItem(val fragmentManager: FragmentManager, private val championInfo: Champion) :
    BindableItem<FragmentChampionRowItemBinding>() {
    override fun bind(viewBinding: FragmentChampionRowItemBinding, position: Int) {
        viewBinding.tvName.text = championInfo.name
        viewBinding.tvScript.text = championInfo.title
        Picasso.get()
            .load("http://ddragon.leagueoflegends.com/cdn/11.22.1/img/champion/" + championInfo.image.full)
            .into(viewBinding.ivFullImage)

        viewBinding.root.setOnClickListener {


            ChampionInfoFragment.newInstance(championInfo.name)
                .show(fragmentManager, "")
        }
    }

    override fun getLayout() = R.layout.fragment_champion_row_item
}