package com.example.firstapp.fragment.build

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.GridLayoutManager
import com.example.firstapp.R
import com.example.firstapp.databinding.FragmentBuildMainBinding
import com.example.waterexample.ui.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect


@AndroidEntryPoint
class BuildMainFragment : BaseFragment<FragmentBuildMainBinding>(R.layout.fragment_build_main) {

    private val viewModel: BuildViewModel by viewModels()



    override fun init() {
        repeatOnStarted {
            viewModel.getChampion().collect { Champion ->
                val championList = Champion.data.values.toList().sortedBy { it.name }
                val adapter = BuildMainAdapter(this@BuildMainFragment.context, championList)
                binding.buildMainRv.adapter = adapter
                binding.buildMainRv.layoutManager = GridLayoutManager(
                    this@BuildMainFragment.context, 4, GridLayoutManager.VERTICAL, false
                )
            }
        }


    }
}