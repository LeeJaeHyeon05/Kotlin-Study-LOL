package com.example.firstapp.fragment.build

import android.content.Intent
import com.example.firstapp.R
import com.example.firstapp.databinding.ItemBuildMainBinding
import com.example.firstapp.model.mychampion.Datum
import com.xwray.groupie.databinding.BindableItem

/**
 * FirstApp
 * Class: BuildItem
 * Created by 최우성 on 2021-12-20.
 *
 * Description: Groupie를 사용하기위해 만듬
 *
 */
class BuildItem(val dataNum: Datum) : BindableItem<ItemBuildMainBinding>() {


    override fun bind(binding: ItemBuildMainBinding, position: Int) {
        binding.championData = dataNum

        //TODO
        // 하나님 있을때 한번 물어보자
        binding.championImage.setOnClickListener {
            val intent = Intent(binding.championImage.context, BuildDetailActivity::class.java)
            binding.championImage.context?.startActivity(intent)

        }
    }

    override fun getLayout(): Int {
        return R.layout.item_build_main
    }
}