package com.example.firstapp.fragment.skin

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2
import com.example.firstapp.R
import com.example.firstapp.adapter.skin.SkinPagerFragmentAdapter
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import timber.log.Timber

class SkinFragment : Fragment() {

    private lateinit var viewPager: ViewPager2
    private lateinit var tabLayout: TabLayout

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val view:View = inflater.inflate(R.layout.fragment_skin, container, false)
        viewPager = view.findViewById(R.id.skin_pager)
        tabLayout = view.findViewById(R.id.skin_tab_layout)
        return view
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        val pagerAdapter = SkinPagerFragmentAdapter(this)

        pagerAdapter.addFragment(SkinByChampionFragment())
        pagerAdapter.addFragment(SkinByThemeFragment())

        viewPager.adapter = pagerAdapter
        viewPager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback(){
            //이전에 추가된 콜백 제거
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                Timber.d("Page ${position+1}")
            }
        })

        val tabLayoutTextArray = arrayOf(getString(R.string.skin_tab_champion), getString(R.string.skin_tab_theme))
        TabLayoutMediator(tabLayout, viewPager){ tab, position ->
            tab.text = tabLayoutTextArray[position]
        }.attach()

    }

}