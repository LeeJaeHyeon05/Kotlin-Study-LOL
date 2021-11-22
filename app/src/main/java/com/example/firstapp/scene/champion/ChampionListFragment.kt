package com.example.firstapp.scene.champion

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.GridLayoutManager
import com.example.firstapp.R
import com.example.firstapp.databinding.FragmentChampionListBinding
import com.xwray.groupie.GroupieAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ChampionListFragment : Fragment(R.layout.fragment_champion_list) {

    private val viewModel: ChampionListViewModel by viewModels()

    private val adapter: GroupieAdapter = GroupieAdapter()

    private val args: ChampionListFragmentArgs by lazy {
        ChampionListFragmentArgs.fromBundle(arguments ?: Bundle())
    }
    private val spanCount = 2
    private val viewType by lazy { args.viewType }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val binding = FragmentChampionListBinding.bind(view)

        binding.rvChampion.let {
            it.adapter = adapter
            it.layoutManager = GridLayoutManager(requireContext(), spanCount)
        }

        viewModel.champions.observe(viewLifecycleOwner) { champions ->
            champions.map { ChampionListItem(childFragmentManager, it) }
                .also { adapter.update(it) }
        }
    }
}