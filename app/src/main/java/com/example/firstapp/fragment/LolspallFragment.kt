package com.example.firstapp.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import com.example.firstapp.R
import com.example.firstapp.adapter.summorSpell.CustomAdapter
import com.example.firstapp.adapter.summorSpell.ItemsViewModel
import com.example.firstapp.databinding.FragmentLolspallBinding

class LolspallFragment : Fragment() {

    //전역 변수로 바인딩 객체 선언
    private var mBinding: FragmentLolspallBinding? = null
    //편의성을 위한 바인딩 변수 재 선언
    private val binding get() = mBinding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        mBinding = FragmentLolspallBinding.inflate(inflater,container, false)

        allSpaceDecoration()
        val myLayoutManager = object : GridLayoutManager(requireContext(), 5) {
            override fun canScrollHorizontally(): Boolean {
                return false
            }
        }
        binding.recyclerView.layoutManager = myLayoutManager

        //첫번째 리사이클러뷰
        val data = ArrayList<ItemsViewModel>()

        //라인 1 어뎁터
        binding.recyclerView.run {
            adapter = CustomAdapter(data)
            layoutManager = myLayoutManager
        }

        //데이터 추가하기
        data.add(ItemsViewModel(
            R.drawable.smite,
            R.string.smite,
            R.string.smiteDialogText,
            R.drawable.smite,
            R.string.smiteDialogTitle
        ))
        data.add(ItemsViewModel(
            R.drawable.tel,
            R.string.tel,
            R.string.telDialogText,
            R.drawable.tel,
            R.string.telDialogTitle
        ))
        data.add(ItemsViewModel(
            R.drawable.sheild,
            R.string.sheild,
            R.string.sheildDialogText,
            R.drawable.sheild,
            R.string.sheildDialogTitle
        ))
        data.add(ItemsViewModel(
            R.drawable.flash,
            R.string.flash,
            R.string.fireDialogText,
            R.drawable.flash,
            R.string.flashDialogTitle
        ))
        data.add(ItemsViewModel(
            R.drawable.heal,
            R.string.heal,
            R.string.healDialogText,
            R.drawable.heal,
            R.string.healDialogTitle
        ))
        data.add(ItemsViewModel(
            R.drawable.fire,
            R.string.ignite,
            R.string.fireDialogText,
            R.drawable.fire,
            R.string.fireDialogTitle
        ))
        data.add(ItemsViewModel(
            R.drawable.clean,
            R.string.clean,
            R.string.cleanDialogText,
            R.drawable.clean,
            R.string.cleanDialogTitle
        ))
        data.add(ItemsViewModel(
            R.drawable.ghost,
            R.string.ghost,
            R.string.ghostDialogText,
            R.drawable.ghost,
            R.string.ghostDialogTitle
        ))
        data.add(ItemsViewModel(
            R.drawable.exhasuted,
            R.string.exhasuted,
            R.string.exhaustedDialogText,
            R.drawable.exhasuted,
            R.string.exhaustedDialogTitle
        ))


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

    }

}
