package com.example.firstapp.adapter.build

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.firstapp.fragment.build.BuildFilter
import com.example.firstapp.fragment.build.buildItemContentFragment

/**
 * FirstApp
 * Class: buildFragmentAdapter
 * Created by 최우성 on 2022-01-14.
 *
 * Description:
 * 빌드 바텀시트의 뷰페이저 어뎁터이다.
 */

//생성자가 들어가야하는 이유 알아야해
class BuildFragmentAdapter(BuildGroupData:  ArrayList<List<BuildFilter>>, fragmentActivity: FragmentActivity) : FragmentStateAdapter(fragmentActivity) {


    val fragmentList = BuildGroupData.map{buildItemContentFragment(it)}



    override fun getItemCount() = fragmentList.size

    override fun createFragment(position: Int): Fragment  = fragmentList[position]
}