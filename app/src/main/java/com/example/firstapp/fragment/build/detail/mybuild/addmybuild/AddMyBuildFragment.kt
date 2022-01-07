package com.example.firstapp.fragment.build.detail.mybuild.addmybuild

import android.os.Bundle
import android.view.*
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.firstapp.R
import com.example.firstapp.databinding.FragmentAddMyBuildBinding
import com.example.firstapp.fragment.build.BuildDetailActivity
import com.example.firstapp.model.MyBuild
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AddMyBuildFragment : Fragment() {

    private val viewModel : AddMyBuildViewModel by viewModels()
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

                viewModel.getMyBuildList("champion name")
                val newList = viewModel.newList
                (activity as BuildDetailActivity).refreshMyBuildItemAdapter(newList.value!!)
            }
            android.R.id.home -> {
                (activity as BuildDetailActivity).closeAddMyBuild()
            }
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_add_my_build, container, false)
        binding.addMyBuildViewModel = viewModel
        binding.lifecycleOwner = this.viewLifecycleOwner

        setFunctions()
        setObservers()

        return binding.root
    }

    private fun setObservers() {

    }

    private fun setFunctions() {
        (activity as BuildDetailActivity).supportActionBar?.setDisplayHomeAsUpEnabled(true)

        binding.mbLayoutCustomItem.setOnClickListener {
            (activity as BuildDetailActivity).showItemBuildDialog()
        }

        binding.skillBuildTable.setOnClickListener {
            (activity as BuildDetailActivity).showSkillBuildDialog()
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    private fun saveAddBuild() {
//        현재 페이지에 있는 정보 저장
//        * 빌드 이름 String
//        -> 소환사 주문 Image 2개
//        -> 아이템 + 장신구 이미지 7개
//        -> 새로운 아이템 카테고리 RV
//        -> 스킬 순서
//        -> 룬
//        * 빌드 노트
        val newBuild = MyBuild(
            0,
            "champion name",
            binding.myBuildNameET.text.toString(),
            binding.myBuildNoteET.text.toString()
        )
        viewModel.saveAddBuild(newBuild)

        (activity as BuildDetailActivity).closeAddMyBuild()
    }
}