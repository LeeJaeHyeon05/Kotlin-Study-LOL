package com.example.firstapp.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.example.firstapp.R
import com.example.firstapp.model.PatchViewModel
import dagger.hilt.android.AndroidEntryPoint
import timber.log.Timber

@AndroidEntryPoint
class PatchFragment : Fragment() {
    private val viewModel : PatchViewModel by viewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        lifecycleScope.launchWhenStarted {
            val patchVersionData = viewModel.getPatchVersionData()
            Timber.d("patchVersionData: $patchVersionData")
        }
        return inflater.inflate(R.layout.fragment_patch, container, false)
    }
}