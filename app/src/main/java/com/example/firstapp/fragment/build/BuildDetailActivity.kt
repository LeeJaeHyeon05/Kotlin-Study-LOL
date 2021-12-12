package com.example.firstapp.fragment.build

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentActivity
import com.example.firstapp.R
import com.example.firstapp.databinding.ActivityBuildDetailBinding
import com.example.firstapp.fragment.build.detail.DetailViewPagerAdapter
import com.example.firstapp.fragment.build.detail.mybuild.AddMyBuildFragment
import com.example.firstapp.fragment.build.detail.mybuild.dialog.ItemBuildDialogFragment
import com.example.firstapp.fragment.build.detail.mybuild.dialog.SkillBuildDialogFragment
import com.google.android.material.tabs.TabLayoutMediator

class BuildDetailActivity : AppCompatActivity() {

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

    fun openAddMyBuild(){
        supportFragmentManager.beginTransaction()
            .add(R.id.buildDetailContainer, AddMyBuildFragment())
            .commit()
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