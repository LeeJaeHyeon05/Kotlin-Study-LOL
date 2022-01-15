package com.example.firstapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import com.example.firstapp.adapter.summorSpell.CustomAdapter
import com.example.firstapp.adapter.summorSpell.ItemsViewModel
import com.example.firstapp.databinding.FragmentHowlingBinding
import com.example.firstapp.databinding.FragmentLolspallBinding
import com.example.firstapp.databinding.FragmentSummonerSpellBinding

class HowlingFragment : Fragment() {

    //전역 변수로 바인딩 객체 선언
    private var mBinding: FragmentHowlingBinding? = null
    //편의성을 위한 바인딩 변수 재 선언
    private val binding get() = mBinding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        mBinding = FragmentHowlingBinding.inflate(inflater,container, false)

        allSpaceDecoration()
        //두번째 그리드 뷰로 몇개 할지 정하고 canScrollHorizontally 을 하고 return false 로 움직임 차단
        val myLayoutManager2 = object : GridLayoutManager(requireContext(), 5) {
            override fun canScrollHorizontally(): Boolean {
                return false
            }
        }

        binding.recyclerView2.layoutManager = myLayoutManager2


        //두번째 리사이클러뷰
        val data2 = ArrayList<ItemsViewModel>()



        //라인 2 어뎁터
        binding.recyclerView2.run {
            adapter = CustomAdapter(data2)
            layoutManager = myLayoutManager2
        }

        //두번째 줄 데이터 추가하기
        data2.add(ItemsViewModel(R.drawable.totheking, R.string.totheking, R.string.tothekingDialogText, R.drawable.totheking, R.string.tothekingDialogTitle))
        data2.add(ItemsViewModel(R.drawable.aiblue, R.string.aiblue, R.string.throwforoDialogText, R.drawable.aiblue, R.string.throwforoDialogTitle))
        data2.add(ItemsViewModel(R.drawable.blue, R.string.blue, R.string.blueDialogText, R.drawable.blue, R.string.blueDialogTitle))

        return binding.root
    }
    private fun allSpaceDecoration() {
        //1아이템 가로 스페이스 늘리기
        val spaceDecoration = CustomAdapter.HorizontalSpaceItemDecoration(2)
        binding.recyclerView2.addItemDecoration(spaceDecoration)
        //1아이템 top 스페이스 줄이기
        val spaceDecoration2 = CustomAdapter.TopSpaceItemDecoration(-190)
        binding.recyclerView2.addItemDecoration(spaceDecoration2)

    }
}
