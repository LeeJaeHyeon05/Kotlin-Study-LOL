package com.example.firstapp.fragment

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.*
import android.webkit.WebViewClient
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.example.firstapp.R
import com.example.firstapp.databinding.FragmentPatchBinding
import com.example.firstapp.model.PatchViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.*
import timber.log.Timber


@AndroidEntryPoint
class PatchFragment : Fragment() {
    private lateinit var binding: FragmentPatchBinding
    private val viewModel: PatchViewModel by viewModels()
    lateinit var deferred: Deferred<List<String>>
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_patch, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentPatchBinding.bind(view)
        setHasOptionsMenu(true)
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        menu.clear()
        inflater.inflate(R.menu.patch_menu, menu)
        lifecycleScope.launchWhenStarted {
            // 패치 버전 이력 데이터 가져오기
            val newPatchVersionData = getPatchData()
            // 가져온 패치 데이터를 사용하여 toolBar에 스피너 만들기
            makeSpinner(newPatchVersionData, menu)
        }
    }
    suspend fun getPatchData(): List<String>{
        coroutineScope {
            deferred = async(Dispatchers.Main) {
                val allPatchVersionData = viewModel.getPatchVersionData()
                val newPatchVersionData = listOf(
                    allPatchVersionData[0],
                    allPatchVersionData[1],
                    allPatchVersionData[2],
                    allPatchVersionData[3]
                )
                return@async newPatchVersionData
            }
        }
        return deferred.await()
    }

    fun makeSpinner(newPatchVersionData: List<String>, menu: Menu){
        val spinnerAdapter = ArrayAdapter(
            requireContext(),
            android.R.layout.simple_spinner_item,
            newPatchVersionData
        )
        spinnerAdapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line)
        val item = menu.findItem(R.id.menu_spinner)
        val spinner = item.actionView as Spinner
        spinner.adapter = spinnerAdapter
        val spinnerListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                paretn: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                when (paretn?.id){
                    R.id.menu_spinner -> {
                        Timber.d("data: ${newPatchVersionData[position]}")
                        val patchURL = viewModel.getPatchURL(newPatchVersionData[position])
                        initWebView(patchURL)
                    }
                }
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
            }
        }
        spinner.onItemSelectedListener = spinnerListener
    }

    @SuppressLint("SetJavaScriptEnabled")
    fun initWebView(url: String){
        binding.webView.apply {
            webViewClient = WebViewClient()
            loadUrl(url)
        }
        binding.webView.settings.apply {
            javaScriptEnabled = true
            javaScriptCanOpenWindowsAutomatically = true
        }
    }
}
