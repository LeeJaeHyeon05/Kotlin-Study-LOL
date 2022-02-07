package com.example.firstapp.fragment.build

import android.util.Log
import androidx.navigation.findNavController
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

        binding.championImage.setOnClickListener {
            it.findNavController().navigate(R.id.open_build_detail)
        }
    }

    override fun getLayout(): Int {
        return R.layout.item_build_main
    }
}