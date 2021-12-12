package com.example.firstapp.fragment.universe

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.firstapp.databinding.FragmentUniverseRegionBinding

class UniverseRegionFragment: Fragment() {

    private var _binding: FragmentUniverseRegionBinding?= null

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentUniverseRegionBinding.inflate(layoutInflater, container, false)
        val root: View = binding.root


        return root
    }
}