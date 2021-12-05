package com.example.firstapp.fragment.build.detail

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.firstapp.databinding.FragmentBuildDetailMybuildBinding
import com.example.firstapp.fragment.build.BuildDetailActivity
import com.example.firstapp.fragment.build.detail.MyBuild.MyBuildItemAdapter

class DetailMyBuildFragment : Fragment() {

    var buildDetailActivity : BuildDetailActivity? = null
    lateinit var binding : FragmentBuildDetailMybuildBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentBuildDetailMybuildBinding.inflate(inflater,container,false)

//        val adapter = MyBuildItemAdapter()
//        binding.buildMyBuildRv.adapter = adapter
//        binding.buildMyBuildRv.layoutManager = LinearLayoutManager(this.context)

        binding.fabAddMyBuild.setOnClickListener {
            buildDetailActivity!!.openAddMyBuild()
        }
        return binding.root
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        buildDetailActivity = context as BuildDetailActivity
    }

}