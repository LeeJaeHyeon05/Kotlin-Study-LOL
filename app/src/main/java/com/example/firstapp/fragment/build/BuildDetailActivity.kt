package com.example.firstapp.fragment.build

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.firstapp.R
import com.example.firstapp.databinding.ActivityBuildDetailBinding
import com.example.firstapp.fragment.build.detail.DetailViewPagerAdapter
import com.example.firstapp.fragment.build.detail.mybuild.addmybuild.AddMyBuildFragment
import com.example.firstapp.fragment.build.detail.mybuild.addmybuild.ItemBuildDialogFragment
import com.example.firstapp.fragment.build.detail.mybuild.addmybuild.SkillBuildDialogFragment
import com.google.android.material.tabs.TabLayoutMediator
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class BuildDetailActivity : AppCompatActivity() {

    val binding by lazy { ActivityBuildDetailBinding.inflate(layoutInflater) }
    private lateinit var addMyBuildFragment : AddMyBuildFragment


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        setViewPager()
    }

    private fun setViewPager(){
        val viewPagerAdapter = DetailViewPagerAdapter(this)
        binding.viewPager.adapter = viewPagerAdapter

        val tabTitles = arrayListOf("빌드", "프로 빌드", "기타 빌드" , "통계", "카운터", "팁", "내 빌드")
        TabLayoutMediator(binding.tabLayout, binding.viewPager){ tab , position ->
            tab.text = tabTitles[position]
        }.attach()
    }

    fun openAddMyBuild(){
        addMyBuildFragment = AddMyBuildFragment()
        supportFragmentManager.beginTransaction()
            .add(R.id.buildDetailContainer, addMyBuildFragment)
            .addToBackStack(null)
            .commit()
    }

    fun closeAddMyBuild(){
        supportFragmentManager.beginTransaction()
            .remove(addMyBuildFragment)
            .commit()
        //fragment refresh 해주기
    }

    fun showSkillBuildDialog(){
        val dialog = SkillBuildDialogFragment()
        dialog.show(supportFragmentManager, "Skill Build")
    }

    fun showItemBuildDialog(){
        val dialog = ItemBuildDialogFragment()
        dialog.show(supportFragmentManager, "Item Build")
    }
}