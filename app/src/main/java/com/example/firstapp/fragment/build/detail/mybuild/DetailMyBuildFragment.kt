package com.example.firstapp.fragment.build.detail.mybuild

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentManager
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import com.example.firstapp.R
import com.example.firstapp.databinding.FragmentBuildDetailMybuildBinding
import com.example.firstapp.fragment.build.BuildDetailActivity

class DetailMyBuildFragment : Fragment() {

    lateinit var binding : FragmentBuildDetailMybuildBinding
    private lateinit var navController: NavController

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentBuildDetailMybuildBinding.inflate(inflater,container,false)

//        val adapter = MyBuildItemAdapter()
//        binding.buildMyBuildRv.adapter = adapter
//        binding.buildMyBuildRv.layoutManager = LinearLayoutManager(this.context)

        binding.fabAddMyBuild.setOnClickListener {
            (activity as BuildDetailActivity).openAddMyBuild()
        }

        return binding.root
    }
}