package com.example.firstapp.fragment.build.detail.mybuild

import android.os.Bundle
import android.view.*
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.example.firstapp.R
import com.example.firstapp.databinding.FragmentAddMyBuildBinding
import com.example.firstapp.fragment.build.BuildDetailActivity
import com.example.firstapp.fragment.build.detail.mybuild.viewmodel.AddMyBuildViewModel

class AddMyBuildFragment : Fragment() {

    private val addMyBuildViewModel : AddMyBuildViewModel by viewModels()
    private lateinit var binding: FragmentAddMyBuildBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        menu.clear()
        inflater.inflate(R.menu.add_build_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.save_add_build -> {
                saveAddBuild()
            }
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_add_my_build, container, false)

        (activity as BuildDetailActivity).supportActionBar?.setDisplayHomeAsUpEnabled(true)

        binding.mbLayoutCustomItem.setOnClickListener {
            (activity as BuildDetailActivity).showItemBuildDialog()
        }

        binding.skillBuildTable.setOnClickListener {
            (activity as BuildDetailActivity).showSkillBuildDialog()
        }

        val myBuildNameETObserver = Observer<String>{
            binding.myBuildNameET.setText(it)
        }
        addMyBuildViewModel.myBuildNameET.observe(viewLifecycleOwner, myBuildNameETObserver)


        return binding.root
    }

    private fun saveAddBuild(){
//        현재 페이지에 있는 정보 저장
//        -> 빌드 이름 String
//        -> 소환사 주문 Image 2개
//        -> 아이템 + 장신구 이미지 7개
//        -> 새로운 아이템 카테고리 RV
//        -> 스킬 순서
//        -> 룬
//        -> 빌드 노트
    }
}