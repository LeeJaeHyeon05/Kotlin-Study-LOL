package com.example.firstapp.fragment.build

import android.os.Bundle
import androidx.fragment.app.FragmentActivity
import com.example.firstapp.databinding.ActivityBuildDetailBinding
import com.example.firstapp.fragment.build.detail.DetailViewPagerAdapter
import com.google.android.material.tabs.TabLayoutMediator

class BuildDetailActivity : FragmentActivity() {

    val binding by lazy { ActivityBuildDetailBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val adapter = DetailViewPagerAdapter(this)
        binding.viewPager.adapter = adapter

        val tabTitles = arrayListOf<String>("빌드", "프로 빌드", "기타 빌드" , "통계", "카운터", "팁", "내 빌드")
        TabLayoutMediator(binding.tabLayout, binding.viewPager){ tab , position ->
            tab.text = tabTitles[position]
        }.attach()
    }
}