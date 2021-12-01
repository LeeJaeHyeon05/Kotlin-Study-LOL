package com.example.firstapp.fragment.build.detail

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.firstapp.R
import com.example.firstapp.databinding.FragmentBuildDetailMybuildBinding
import com.example.firstapp.databinding.FragmentBuildMainBinding

class DetailMyBuildFragment : Fragment() {

    lateinit var binding : FragmentBuildDetailMybuildBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentBuildDetailMybuildBinding.inflate(inflater,container,false)

        binding.fabAddMyBuild.setOnClickListener {
            //move to fragment_add_my_build
        }
        return binding.root
    }

}