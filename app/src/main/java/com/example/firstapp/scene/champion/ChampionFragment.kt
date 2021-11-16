package com.example.firstapp.scene.champion

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.GridLayoutManager
import com.example.firstapp.R
import com.example.firstapp.databinding.FragmentChampionBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ChampionFragment : Fragment(R.layout.fragment_champion) {

    private val viewModel: ChampionViewModel by viewModels()

    private val adapter: ChampionAdapter by lazy { ChampionAdapter(champions) }
    private val champions: ArrayList<ChampionInfoVO> = ArrayList()

    private val args: ChampionFragmentArgs by lazy {
        ChampionFragmentArgs.fromBundle(arguments ?: Bundle())
    }
    private val spanCount = 2
    private val viewType by lazy { args.viewType }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val binding = FragmentChampionBinding.bind(view)

        binding.rvChampion.let {
            it.adapter = adapter
            it.layoutManager = GridLayoutManager(requireContext(), spanCount)
        }

        viewModel.champions.observe(viewLifecycleOwner) {
            champions.clear()
            champions.addAll(it)
            adapter.notifyDataSetChanged()
        }
        viewModel.dummy()
    }
}