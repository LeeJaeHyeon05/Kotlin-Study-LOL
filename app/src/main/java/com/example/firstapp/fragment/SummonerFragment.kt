package com.example.firstapp.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.firstapp.R
import com.example.firstapp.databinding.FragmentSummonerBinding

class SummonerFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val binding = FragmentSummonerBinding.inflate(inflater, container, false)

        return inflater.inflate(R.layout.fragment_summoner, container, false)
    }
}