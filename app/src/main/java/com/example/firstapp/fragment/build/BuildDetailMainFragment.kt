package com.example.firstapp.fragment.build

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.NavHostFragment
import com.example.firstapp.R
import com.example.firstapp.databinding.FragmentBuildDetailMainBinding
import com.example.firstapp.fragment.build.detail.DetailViewPagerAdapter
import com.google.android.material.tabs.TabLayoutMediator
import timber.log.Timber


class BuildDetailMainFragment : Fragment() {

    private lateinit var binding : FragmentBuildDetailMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> {
                (activity as BuildDetailActivity).onBackPressed()
            }
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentBuildDetailMainBinding.inflate(layoutInflater)

        (activity as BuildDetailActivity).setSupportActionBar(binding.toolbar)
        (activity as BuildDetailActivity).supportActionBar?.apply {
            setDisplayHomeAsUpEnabled(true)
            setDisplayShowHomeEnabled(true)
        }

        setViewPager()

        return binding.root
    }

    private fun setViewPager() {
        val viewPagerAdapter = DetailViewPagerAdapter(this.requireActivity())
        binding.viewPager.adapter = viewPagerAdapter

        val tabTitles = arrayListOf("빌드", "프로 빌드", "기타 빌드", "통계", "카운터", "팁", "내 빌드")
        TabLayoutMediator(binding.tabLayout, binding.viewPager) { tab, position ->
            tab.text = tabTitles[position]
        }.attach()
    }
}