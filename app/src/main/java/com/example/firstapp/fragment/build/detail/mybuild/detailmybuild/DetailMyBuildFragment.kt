package com.example.firstapp.fragment.build.detail.mybuild.detailmybuild

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.firstapp.databinding.FragmentBuildDetailMybuildBinding
import com.example.firstapp.fragment.build.BuildDetailActivity
import com.example.firstapp.fragment.build.detail.mybuild.MyBuildItemAdapter
import com.example.firstapp.model.MyBuild
import dagger.hilt.android.AndroidEntryPoint
import java.util.*

@AndroidEntryPoint
class DetailMyBuildFragment : Fragment() {

    private val viewModel : DetailMyBuildViewModel by viewModels()
    lateinit var binding : FragmentBuildDetailMybuildBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentBuildDetailMybuildBinding.inflate(inflater,container,false)
        setupUi()
        setupObserver()

        viewModel.getMyBuildListByChampionName("champion name")

        return binding.root
    }

    private fun setupObserver() {
        viewModel.list.observe(viewLifecycleOwner){
            val adapter = MyBuildItemAdapter()
            adapter.myBuildData = it
            binding.buildMyBuildRv.apply {
                this.adapter = adapter
                layoutManager = LinearLayoutManager(this.context)
            }
        }
//        detailMyBuildViewModel.getMyBuildData(context!!.applicationContext, "Champion Name")
//
//        val myBuildDataListObserver = Observer<MutableList<MyBuildRepositoryData>> {
//            adapterData.value = it
//            val adapter = MyBuildItemAdapter(adapterData)
//            binding.buildMyBuildRv.apply{
//                this.adapter = adapter
//                layoutManager = LinearLayoutManager(this.context)
//            }
//
//            // recyclerview를 초기화
//        }
//
//        detailMyBuildViewModel.myBuildDataList.observe(viewLifecycleOwner, myBuildDataListObserver)

    }

    private fun setupUi() {
        binding.fabAddMyBuild.setOnClickListener {
            (activity as BuildDetailActivity).openAddMyBuild()
        }
    }
}