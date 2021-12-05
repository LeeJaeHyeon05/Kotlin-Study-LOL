package com.example.firstapp.fragment.build.detail.MyBuild

import android.app.AlertDialog
import android.content.Context
import android.graphics.Color
import android.os.Build
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import com.example.firstapp.R
import com.example.firstapp.databinding.FragmentAddMyBuildBinding
import com.example.firstapp.fragment.build.BuildDetailActivity

class AddMyBuildFragment : Fragment() {

    private lateinit var myBuildViewModel: MyBuildViewModel
    private var _binding: FragmentAddMyBuildBinding? = null

    private val binding get() = _binding!!

    private var buildDetailActivity : BuildDetailActivity? = null


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        myBuildViewModel = ViewModelProvider(this).get(MyBuildViewModel::class.java)
        _binding = FragmentAddMyBuildBinding.inflate(inflater, container, false)

        inflateToolbar()

        binding.mbLayoutCustomItem.setOnClickListener {
            buildDetailActivity!!.showItemBuildDialog()
        }

        binding.skillBuildTable.setOnClickListener {
            buildDetailActivity!!.showSkillBuildDialog()
        }

        return binding.root
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        buildDetailActivity = context as BuildDetailActivity
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    private fun inflateToolbar(){
        binding.addBuildToolbar.apply {
            inflateMenu(R.menu.add_build_menu)
            setOnMenuItemClickListener {
                when(it.itemId){
                    R.id.save_add_build -> {
                        saveAddBuild()
                        true
                    }
                    else -> {false}
                }
            }
        }
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