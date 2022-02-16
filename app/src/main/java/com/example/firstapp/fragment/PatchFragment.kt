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

@AndroidEntryPoint
class PatchFragment : Fragment() {
    private val viewModel : PatchViewModel by viewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        lifecycleScope.launchWhenStarted {
            // 패치 버전 이력 데이터 가져오기
            val patchVersionData = viewModel.getPatchVersionData()
//            Timber.d("patchVersionData: $patchVersionData")

            // patch 데이터 가져오기(Jsoup 이용)
            val patchData = viewModel.getPatchData(patchVersionData[0])
        }
        return inflater.inflate(R.layout.fragment_patch, container, false)
    }
}