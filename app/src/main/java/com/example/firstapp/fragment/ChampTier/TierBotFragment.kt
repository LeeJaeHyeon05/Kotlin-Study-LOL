package com.example.firstapp.fragment.ChampTier

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.firstapp.databinding.FragmentTierBotBinding

/**
 * @author mmol93
 * @email ljws93@naver.com
 * @since 2021/11/10
 **/
class TierBotFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentTierBotBinding.inflate(inflater, container, false)
        return binding.root
    }
}