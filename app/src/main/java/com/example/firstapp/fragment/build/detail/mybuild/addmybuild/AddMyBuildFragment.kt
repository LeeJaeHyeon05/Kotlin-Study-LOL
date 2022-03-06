package com.example.firstapp.fragment.build.detail.mybuild.addmybuild

import android.graphics.Color
import android.os.Bundle
import android.view.*
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.navArgs
import com.example.firstapp.R
import com.example.firstapp.database.Converters
import com.example.firstapp.databinding.FragmentAddMyBuildBinding
import com.example.firstapp.fragment.build.BuildDetailActivity
import com.example.firstapp.model.MyBuild
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class AddMyBuildFragment : Fragment() {

    private val addMyBuildViewModel : AddMyBuildViewModel by viewModels()
    private val skillBuildDialogViewModel : SkillBuildDialogViewModel by activityViewModels()
    private lateinit var binding: FragmentAddMyBuildBinding

    val args: AddMyBuildFragmentArgs by navArgs()

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
                NavHostFragment.findNavController(this).navigateUp()

            }
            android.R.id.home -> {
                NavHostFragment.findNavController(this).navigateUp()
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

        (activity as BuildDetailActivity).setSupportActionBar(binding.toolbar)
        (activity as BuildDetailActivity).supportActionBar?.apply {
            title = "Add Build ${(activity as BuildDetailActivity).name}"
        }


        addMyBuildViewModel.myBuildNameET.value = "#${args.num} " + (activity as BuildDetailActivity).name + "'s builds"

        setFunctions()
        setObservers()

        return binding.root
    }

    private fun setObservers() {
        skillBuildDialogViewModel.skillTreeDisplay.observe(viewLifecycleOwner){
            listOf(
                binding.QRow,
                binding.WRow,
                binding.ERow,
                binding.RRow
            ).forEach {
                for(i in 1 until it.childCount){
                    (it.getChildAt(i) as TextView).apply {
                        text = ""
                        setBackgroundResource(R.color.brightGray)
                        setTextColor(ContextCompat.getColor(requireContext(), R.color.white))
                    }
                }
            }

            skillBuildDialogViewModel.skillTreeDisplay.value?.forEachIndexed { index, skill ->
                val num = index + 1
                when (skill) {
                    "Q" -> {
                        (binding.QRow.getChildAt(num) as TextView).apply {
                            text = "$num"
                            setBackgroundResource(R.color.beige)
                            setTextColor(ContextCompat.getColor(requireContext(), R.color.black))
                        }
                    }
                    "W" -> {
                        (binding.WRow.getChildAt(num) as TextView).apply {
                            text = "$num"
                            setBackgroundResource(R.color.beige)
                            setTextColor(ContextCompat.getColor(requireContext(), R.color.black))
                        }
                    }
                    "E" -> {
                        (binding.ERow.getChildAt(num) as TextView).apply {
                            text = "$num"
                            setBackgroundResource(R.color.beige)
                            setTextColor(ContextCompat.getColor(requireContext(), R.color.black))
                        }
                    }
                    "R" -> {
                        (binding.RRow.getChildAt(num) as TextView).apply {
                            text = "$num"
                            setBackgroundResource(R.color.beige)
                            setTextColor(ContextCompat.getColor(requireContext(), R.color.black))
                        }
                    }
                }
            }
        }
    }

    private fun setFunctions() {
        (activity as BuildDetailActivity).supportActionBar?.setDisplayHomeAsUpEnabled(true)

        binding.addMyItemBuild.setOnClickListener {
            NavHostFragment.findNavController(this).navigate(R.id.open_item_build_dialog)
        }

        binding.skillBuildTable.setOnClickListener {
            NavHostFragment.findNavController(this).navigate(R.id.open_skill_build_dialog)
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
        val skillTreeList = Converters().jsonToJsonArray(skillBuildDialogViewModel.skillTreeDisplay.value.toString())

        val newBuild = MyBuild(
            id = 0,
            champion = (activity as BuildDetailActivity).name,
            name = binding.myBuildNameET.text.toString(),
            skillTree = skillTreeList,
            notes = binding.myBuildNoteET.text.toString()
        )
        addMyBuildViewModel.saveAddBuild(newBuild)

    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding.unbind()
    }
}