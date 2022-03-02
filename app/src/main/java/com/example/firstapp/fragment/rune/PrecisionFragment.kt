package com.example.firstapp.fragment.rune

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.firstapp.R
import com.example.firstapp.databinding.FragmentRunePrecisionBinding

class PrecisionFragment : Fragment() {

    private var mBinding: FragmentRunePrecisionBinding? = null
    private val binding get() = mBinding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        mBinding = FragmentRunePrecisionBinding.inflate(inflater, container, false)



        return binding.root
    }

}