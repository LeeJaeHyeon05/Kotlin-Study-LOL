package com.example.firstapp.fragment.build.detail.mybuild

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.viewModels
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.firstapp.R
import com.example.firstapp.databinding.FragmentBuildDetailMybuildBinding
import com.example.firstapp.fragment.build.BuildDetailActivity
import com.example.firstapp.fragment.build.detail.mybuild.repository.MyBuildRepositoryData
import com.example.firstapp.fragment.build.detail.mybuild.viewmodel.AddMyBuildViewModel
import com.example.firstapp.fragment.build.detail.mybuild.viewmodel.DetailMyBuildViewModel

class DetailMyBuildFragment : Fragment() {

    private val detailMyBuildViewModel : DetailMyBuildViewModel by viewModels()
    private var adapterData = MutableLiveData<MutableList<MyBuildRepositoryData>>()
    lateinit var binding : FragmentBuildDetailMybuildBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentBuildDetailMybuildBinding.inflate(inflater,container,false)

        detailMyBuildViewModel.getMyBuildData(context!!.applicationContext, "Champion Name")

        val myBuildDataListObserver = Observer<MutableList<MyBuildRepositoryData>> {
            adapterData.value = it
            val adapter = MyBuildItemAdapter(adapterData)
            binding.buildMyBuildRv.apply{
                this.adapter = adapter
                layoutManager = LinearLayoutManager(this.context)
            }

            // recyclerview를 초기화
        }

        detailMyBuildViewModel.myBuildDataList.observe(viewLifecycleOwner, myBuildDataListObserver)

        binding.fabAddMyBuild.setOnClickListener {
            (activity as BuildDetailActivity).openAddMyBuild()
        }

        return binding.root
    }
}