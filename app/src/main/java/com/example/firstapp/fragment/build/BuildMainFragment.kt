package com.example.firstapp.fragment.build

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.GridLayoutManager
import com.example.firstapp.R
import com.example.firstapp.databinding.FragmentBuildMainBinding
import com.example.waterexample.ui.base.BaseFragment
import kotlinx.coroutines.flow.collect


class BuildMainFragment : BaseFragment<FragmentBuildMainBinding>(R.layout.fragment_build_main) {

    private val viewModel: BuildViewModel by viewModels()

    private fun dummy(): MutableList<String> {
        val dummyList = mutableListOf<String>(
            "가렌", "갈리오", "갱플랭크", "그라가스",
            "그레이브즈", "그웬", "나르", "나미",
            "나서스", "노틸러스", "녹턴", "누누와 윌럼프",
            "니달리", "니코", "다리우스", "다이애나",
            "드레이븐", "라이즈", "라칸", "람머스",
            "럭스", "럼블", "레넥톤", "레오나",
            "렉사이", "렐", "렝가", "루시안",
            "룰루", "르블랑", "리신", "리븐",
            "리산드라", "릴리아", "마스터 이", "마오카이",
            "말자하", "말파이트", "모데카이저", "모르가나"
        )
        return dummyList
    }

    override fun init() {
        repeatOnStarted {
            viewModel.getChampion().collect { Champion ->
                val championList = Champion.data.values.toList()
                val adapter = BuildMainAdapter(this@BuildMainFragment.context, championList)
                binding.buildMainRv.adapter = adapter
                binding.buildMainRv.layoutManager = GridLayoutManager(
                    this@BuildMainFragment.context, 4, GridLayoutManager.VERTICAL, false
                )
            }
        }


    }
}