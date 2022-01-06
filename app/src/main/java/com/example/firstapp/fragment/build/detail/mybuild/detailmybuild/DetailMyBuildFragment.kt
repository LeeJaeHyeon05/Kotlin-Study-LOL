package com.example.firstapp.fragment.build.detail.mybuild.detailmybuild

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.example.firstapp.databinding.FragmentBuildDetailMybuildBinding
import com.example.firstapp.fragment.build.BuildDetailActivity

class DetailMyBuildFragment : Fragment() {

    private val detailMyBuildViewModel : DetailMyBuildViewModel by viewModels()
//    private var adapterData = MutableLiveData<MutableList<MyBuildRepositoryData>>()
    lateinit var binding : FragmentBuildDetailMybuildBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentBuildDetailMybuildBinding.inflate(inflater,container,false)

        setViewModel()
        setFunctions()

        return binding.root
    }

    private fun setViewModel() {
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

    private fun setFunctions() {
        binding.fabAddMyBuild.setOnClickListener {
            (activity as BuildDetailActivity).openAddMyBuild()
        }
    }
}