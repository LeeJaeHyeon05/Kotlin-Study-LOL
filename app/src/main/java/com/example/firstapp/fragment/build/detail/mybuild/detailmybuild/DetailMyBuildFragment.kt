package com.example.firstapp.fragment.build.detail.mybuild.detailmybuild

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.firstapp.R
import com.example.firstapp.databinding.FragmentBuildDetailMybuildBinding
import com.example.firstapp.fragment.build.BuildDetailActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetailMyBuildFragment : Fragment() {

    private val detailMyBuildViewModel : DetailMyBuildViewModel by viewModels()
    lateinit var binding : FragmentBuildDetailMybuildBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentBuildDetailMybuildBinding.inflate(inflater,container,false)

        val name = (activity as BuildDetailActivity).name
        detailMyBuildViewModel.championName = name

        setupObserver()

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.fabAddMyBuild.setOnClickListener {
            it.findNavController().navigate(R.id.nav_add_my_build)
        }
    }

    private fun setupObserver() {
        detailMyBuildViewModel.list.observe(viewLifecycleOwner){
            val adapter = MyBuildItemAdapter() {id -> delete(id)}
            if (it != null){
                adapter.differ.submitList(it)
                binding.buildMyBuildRv.apply {
                    this.adapter = adapter
                    layoutManager = LinearLayoutManager(this.context)
                }
            }
        }
    }

    private fun delete(id: Int) {
        detailMyBuildViewModel.deleteItem(id)
    }
}