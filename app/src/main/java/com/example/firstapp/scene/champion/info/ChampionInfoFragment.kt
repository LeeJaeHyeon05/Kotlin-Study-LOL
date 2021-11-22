package com.example.firstapp.scene.champion.info

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.firstapp.R
import com.example.firstapp.databinding.FragmentChampionInfoBinding
import com.xwray.groupie.GroupieAdapter
import dagger.hilt.android.AndroidEntryPoint

/**
 * @author hanago
 * @email kottodat@naver.com
 * @since 2021/11/21
 **/
@AndroidEntryPoint
class ChampionInfoFragment : DialogFragment(R.layout.fragment_champion_info) {

    private val adapter = GroupieAdapter()

    val viewModel: ChampionInfoViewModel by viewModels()

    override fun onResume() {
        super.onResume()
        // full Screen code
        dialog?.window?.setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT)
        dialog?.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        dialog?.window?.clearFlags(WindowManager.LayoutParams.FLAG_DIM_BEHIND)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val binding = FragmentChampionInfoBinding.bind(view)

        binding.rvContent.let {
            it.adapter = adapter
            it.layoutManager = LinearLayoutManager(requireContext())
        }

        viewModel.champions.observe(viewLifecycleOwner) { champions ->
            champions.find { it.name == championName }
                ?.let { championInfo ->
                    adapter.add(ChampionSummaryItem(championInfo))
                    adapter.add(ChampionTabMenuItem(championInfo))
                    adapter.add(ChampionDetailItem(championInfo))
                }
        }
    }




    val championName: String
        get() = arguments?.getString(keyChampionName, "") ?: ""

    companion object {
        const val keyChampionName = "keyChampionName"
        fun newInstance(name: String): ChampionInfoFragment {
            val args = Bundle()
            args.putString(keyChampionName, name)

            val fragment = ChampionInfoFragment()
            fragment.arguments = args
            return fragment
        }
    }
}