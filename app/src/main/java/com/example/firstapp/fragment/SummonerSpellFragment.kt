package com.example.firstapp.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import com.example.firstapp.adapter.summorSpell.ItemsViewModel
import com.example.firstapp.R
import com.example.firstapp.adapter.summorSpell.CustomAdapter
import com.example.firstapp.databinding.FragmentSummonerSpellBinding

class SummonerSpellFragment : Fragment() {

    //전역 변수로 바인딩 객체 선언
    private var mBinding: FragmentSummonerSpellBinding? = null
    //편의성을 위한 바인딩 변수 재 선언
    private val binding get() = mBinding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        mBinding = FragmentSummonerSpellBinding.inflate(inflater,container, false)

        //밑에 있는 스페이스 데코레이션 불러오기
        allSpaceDecoration()

        //첫번째 그리드 뷰 그리드 뷰로 몇개 할지 정하고 canScrollHorizontally 을 하고 return
        // false 로 움직임 차단
        val myLayoutManager = object : GridLayoutManager(requireContext(), 5) {
            override fun canScrollHorizontally(): Boolean {
                return false
            }
        }

        binding.recyclerView.layoutManager = myLayoutManager


        //두번째 그리드 뷰로 몇개 할지 정하고 canScrollHorizontally 을 하고 return false 로 움직임 차단
        val myLayoutManager2 = object : GridLayoutManager(requireContext(), 5) {
            override fun canScrollHorizontally(): Boolean {
                return false
            }
        }

        binding.recyclerView2.layoutManager = myLayoutManager2


        //첫번째 리사이클러뷰
        val data = ArrayList<ItemsViewModel>()
        //두번째 리사이클러뷰
        val data2 = ArrayList<ItemsViewModel>()

        //라인 1 어뎁터
        binding.recyclerView.run {
            adapter = CustomAdapter(data)
            layoutManager = myLayoutManager
        }

        //라인 2 어뎁터
        binding.recyclerView2.run {
            adapter = CustomAdapter(data2)
            layoutManager = myLayoutManager2
        }

        //데이터 추가하기
        data.add(ItemsViewModel(R.drawable.smite, R.string.smite, R.string.smiteDialogText, R.drawable.smite, R.string.smiteDialogTitle))
        data.add(ItemsViewModel(R.drawable.tel, R.string.tel, R.string.telDialogText, R.drawable.tel, R.string.telDialogTitle))
        data.add(ItemsViewModel(R.drawable.sheild, R.string.sheild, R.string.sheildDialogText, R.drawable.sheild, R.string.sheildDialogTitle))
        data.add(ItemsViewModel(R.drawable.flash, R.string.flash, R.string.fireDialogText, R.drawable.flash, R.string.flashDialogTitle))
        data.add(ItemsViewModel(R.drawable.heal, R.string.heal, R.string.healDialogText, R.drawable.heal, R.string.healDialogTitle))
        data.add(ItemsViewModel(R.drawable.fire, R.string.ignite, R.string.fireDialogText, R.drawable.fire, R.string.fireDialogTitle))
        data.add(ItemsViewModel(R.drawable.clean, R.string.clean, R.string.cleanDialogText, R.drawable.clean, R.string.cleanDialogTitle))
        data.add(ItemsViewModel(R.drawable.ghost, R.string.ghost, R.string.ghostDialogText, R.drawable.ghost, R.string.ghostDialogTitle))
        data.add(ItemsViewModel(R.drawable.exhasuted, R.string.exhasuted, R.string.exhaustedDialogText, R.drawable.exhasuted, R.string.exhaustedDialogTitle))



        //두번째 줄 데이터 추가하기
        data2.add(ItemsViewModel(R.drawable.totheking, R.string.totheking, R.string.tothekingDialogText, R.drawable.totheking, R.string.tothekingDialogTitle))
        data2.add(ItemsViewModel(R.drawable.aiblue, R.string.aiblue, R.string.throwforoDialogText, R.drawable.aiblue, R.string.throwforoDialogTitle))
        data2.add(ItemsViewModel(R.drawable.blue, R.string.blue, R.string.blueDialogText, R.drawable.blue, R.string.blueDialogTitle))

        return binding.root

    }

    //프래그먼트가 파괴 될때
    override fun onDestroy() {
        mBinding =null
        super.onDestroy()
    }

    private fun allSpaceDecoration() {
        //1아이템 가로 스페이스 늘리기
        val spaceDecoration = CustomAdapter.HorizontalSpaceItemDecoration(2)
        binding.recyclerView.addItemDecoration(spaceDecoration)
        //1아이템 top 스페이스 줄이기
        val spaceDecoration2 = CustomAdapter.TopSpaceItemDecoration(-190)
        binding.recyclerView.addItemDecoration(spaceDecoration2)

        //2아이템 가로 스페이스 늘리기
        val spaceDecoration3 = CustomAdapter.HorizontalSpaceItemDecoration(2)
        binding.recyclerView2.addItemDecoration(spaceDecoration3)
        //2아이템 top 스페이스 줄이기
        val spaceDecoration4 = CustomAdapter.TopSpaceItemDecoration(-190)
        binding.recyclerView2.addItemDecoration(spaceDecoration4)
    }
}
