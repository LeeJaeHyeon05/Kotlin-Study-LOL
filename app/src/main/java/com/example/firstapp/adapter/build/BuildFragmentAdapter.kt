package com.example.firstapp.adapter.build

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.firstapp.fragment.build.BuildFilter
import com.example.firstapp.fragment.build.BuildItemContentFragment
import kotlinx.coroutines.flow.StateFlow

/**
 * FirstApp
 * Class: buildFragmentAdapter
 * Created by 최우성 on 2022-01-14.
 *
 * Description:
 * 빌드 바텀시트의 뷰페이저 어뎁터이다.
 */




class BuildFragmentAdapter(fragmentSize: Int, fragmentActivity: FragmentActivity) : FragmentStateAdapter(fragmentActivity) {



    //add BuildItemContentFragment for fragmentSize
    val fragmentList = (0 until fragmentSize).map {BuildItemContentFragment(it)}



    override fun getItemCount() = fragmentList.size


    override fun createFragment(position: Int): Fragment  = fragmentList[position]
}