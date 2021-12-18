package com.example.firstapp.util

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.viewpager2.widget.ViewPager2

fun ViewPager2.getCurrentFragment(childFragmentManager: FragmentManager): Fragment? {
    return childFragmentManager.findFragmentByTag("$currentItem")
}