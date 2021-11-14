package com.example.firstapp.fragment

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.firstapp.R
import com.example.firstapp.databinding.FragmentChampionBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ChampionFragment : Fragment(R.layout.fragment_champion) {

    val viewModel: ChampionViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val binding = FragmentChampionBinding.bind(view)

        viewModel.champion.observe(viewLifecycleOwner) { res ->
            binding.tvName.text = res.data.Aatrox.name
        }
    }
}