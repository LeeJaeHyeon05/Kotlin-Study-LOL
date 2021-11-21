package com.example.firstapp.fragment.ChampTier

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.firstapp.R
import com.example.firstapp.databinding.FragmentTierMidBinding

/**
 * @author mmol93
 * @email ljws93@naver.com
 * @since 2021/11/10
 **/
class TierMidFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentTierMidBinding.inflate(inflater, container, false)
        return binding.root
    }
}