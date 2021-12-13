package com.example.firstapp.fragment.skin

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2
import com.example.firstapp.R
import com.example.firstapp.adapter.skin.SkinPagerFragmentAdapter
import com.example.firstapp.databinding.ActivityMainBinding
import com.google.android.material.tabs.TabLayout

class SkinFragmemt : Fragment() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)



//    private lateinit var viewPager: ViewPager2
//    private lateinit var tabLayout: TabLayout
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//    }
//
//    override fun onCreateView(
//        inflater: LayoutInflater,
//        container: ViewGroup?,
//        savedInstanceState: Bundle?
//    ): View? {
//        val view:View = inflater.inflate(R.layout.fragment_skin, container, false)
//        viewPager = view.findViewById(R.id.skin_pager)
//        tabLayout = view.findViewById(R.id.skin_tab_layout)
//        return view
//    }
//
//    override fun onActivityCreated(savedInstanceState: Bundle?) {
//        super.onActivityCreated(savedInstanceState)
//
//        val pagerAdapter = SkinPagerFragmentAdapter(requireActivity())
//
//        pagerAdapter.addFragment(SkinByChampionFragment())
//        pagerAdapter.addFragment(SkinByThemeFragment())
//
//        //adapter
//        viewPager.adapter = pagerAdapter
//        viewPager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback(){
//            override fun onPageSelected(position: Int) {
//                super.onPageSelected(position)
//
//            }
//        })
//
//        //tablayout attach

    }



}