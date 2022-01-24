package com.example.firstapp.fragment.build.detail.mybuild.detailmybuild

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.firstapp.databinding.FragmentBuildDetailMybuildBinding
import com.example.firstapp.fragment.build.BuildDetailActivity
import dagger.hilt.android.AndroidEntryPoint
import timber.log.Timber

@AndroidEntryPoint
class DetailMyBuildFragment : Fragment() {

    private val detailMyBuildViewModel : DetailMyBuildViewModel by activityViewModels()
    lateinit var binding : FragmentBuildDetailMybuildBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentBuildDetailMybuildBinding.inflate(inflater,container,false)
        setupUi()
        setupObserver()

        detailMyBuildViewModel.getMyBuildListByChampionName("champion name")

        return binding.root
    }

    private fun setupObserver() {
        detailMyBuildViewModel.list.observe(viewLifecycleOwner){
            val adapter = MyBuildItemAdapter(requireContext())
            adapter.myBuildData = it
            binding.buildMyBuildRv.apply {
                this.adapter = adapter
                layoutManager = LinearLayoutManager(this.context)
            }
        }
    }

    private fun setupUi() {
        binding.fabAddMyBuild.setOnClickListener {
            (activity as BuildDetailActivity).openAddMyBuild()
        }
    }

    override fun onResume() {
        super.onResume()
        Timber.d("Resumed")
    }

    override fun onStop() {
        super.onStop()
        Timber.d("Stopped")
    }
}