package com.example.firstapp.fragment.build.detail.mybuild.addmybuild

import android.os.Bundle
import android.view.*
import android.widget.TextView
import androidx.core.view.size
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import com.example.firstapp.R
import com.example.firstapp.databinding.FragmentAddMyBuildBinding
import com.example.firstapp.fragment.build.BuildDetailActivity
import com.example.firstapp.fragment.build.detail.mybuild.detailmybuild.DetailMyBuildViewModel
import com.example.firstapp.model.MyBuild
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AddMyBuildFragment : Fragment() {

    private val addMyBuildViewModel : AddMyBuildViewModel by viewModels()
    private val detailMyBuildViewModel : DetailMyBuildViewModel by activityViewModels()
    private val skillBuildDialogViewModel : SkillBuildDialogViewModel by activityViewModels()
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
                //DetailMyBuildFragment의 List 업데이트 해줄 것!
                //detailMyBuildViewModel.getMyBuildListByChampionName("champion name")
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
    ): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_add_my_build, container, false)
        binding.addMyBuildViewModel = addMyBuildViewModel
        binding.lifecycleOwner = this.viewLifecycleOwner

        setFunctions()
        setObservers()

        return binding.root
    }

    private fun setObservers() {
        skillBuildDialogViewModel.isSaved.observe(viewLifecycleOwner){
            if(it){
                setSkillTree()
            }
        }
    }

    private fun setSkillTree() {
        listOf(
            binding.QRow,
            binding.WRow,
            binding.ERow,
            binding.RRow
        ).forEach {
            for(i in 1 until it.childCount){
                (it.getChildAt(i) as TextView).text = ""
            }
        }

        skillBuildDialogViewModel.skillTree.value?.forEachIndexed { index, skill ->
            val num = index + 1
            when (skill) {
                "Q" -> {
                    (binding.QRow.getChildAt(num) as TextView).text = "$num"
                }
                "W" -> {
                    (binding.WRow.getChildAt(num) as TextView).text = "$num"
                }
                "E" -> {
                    (binding.ERow.getChildAt(num) as TextView).text = "$num"
                }
                "R" -> {
                    (binding.RRow.getChildAt(num) as TextView).text = "$num"
                }
            }
        }
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

    private fun saveAddBuild() {
//        현재 페이지에 있는 정보 저장
//        * 빌드 이름 String
//        -> 소환사 주문 Image 2개
//        -> 아이템 + 장신구 이미지 7개
//        -> 새로운 아이템 카테고리 RV
//        * 스킬 순서
//        -> 룬
//        * 빌드 노트
        val newBuild = MyBuild(
            id = 0,
            champion = "champion name",
            name = binding.myBuildNameET.text.toString(),
            skillTree = skillBuildDialogViewModel.skillTree.value,
            notes = binding.myBuildNoteET.text.toString()
        )
        addMyBuildViewModel.saveAddBuild(newBuild)

        (activity as BuildDetailActivity).closeAddMyBuild()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding.unbind()
    }
}