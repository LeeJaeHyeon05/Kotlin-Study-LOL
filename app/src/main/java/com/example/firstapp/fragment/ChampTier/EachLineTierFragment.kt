package com.example.firstapp.fragment.ChampTier

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import androidx.room.Room
import com.example.firstapp.R
import com.example.firstapp.adapter.ChampTier.TierGroupie
import com.example.firstapp.database.AppDatabase
import com.example.firstapp.databinding.FragmentTierMidBinding
import com.example.firstapp.model.TierViewModel
import com.example.firstapp.model.tier.TierChamp
import com.xwray.groupie.GroupieAdapter
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class EachLineTierFragment(val position: Int) : Fragment() {
    @Inject
    lateinit var database: AppDatabase

    // activityViewModels: Activity의 viewModel에 접근하도록 한다
    private val tierViewModel: TierViewModel by activityViewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = DataBindingUtil.inflate<FragmentTierMidBinding>(
            inflater,
            R.layout.fragment_tier_mid,
            container,
            false
        )

        // Groupie Adapter - test
        val tier1groupieAdapter = GroupieAdapter()
        val tier2groupieAdapter = GroupieAdapter()
        val tier3groupieAdapter = GroupieAdapter()
        val tier4groupieAdapter = GroupieAdapter()
        val tier5groupieAdapter = GroupieAdapter()

        // 각 recyclerView를 초기화
        binding.tier1Recycler.run{
            adapter = tier1groupieAdapter
            layoutManager = GridLayoutManager(context, 4, GridLayoutManager.VERTICAL, false)
            isNestedScrollingEnabled = false
        }

        binding.tier2Recycler.run{
            adapter = tier2groupieAdapter
            layoutManager = GridLayoutManager(context, 4, GridLayoutManager.VERTICAL, false)
            isNestedScrollingEnabled = false
        }

        binding.tier3Recycler.run{
            adapter = tier3groupieAdapter
            layoutManager = GridLayoutManager(context, 4, GridLayoutManager.VERTICAL, false)
            isNestedScrollingEnabled = false
        }

        binding.tier4Recycler.run{
            adapter = tier4groupieAdapter
            layoutManager = GridLayoutManager(context, 4, GridLayoutManager.VERTICAL, false)
            isNestedScrollingEnabled = false
        }

        binding.tier5Recycler.run{
            adapter = tier5groupieAdapter
            layoutManager = GridLayoutManager(context, 4, GridLayoutManager.VERTICAL, false)
            isNestedScrollingEnabled = false
        }

        fun setDataInAdapter(tierData: MutableLiveData<ArrayList<TierChamp>?>) {
            tierData.observe(viewLifecycleOwner, Observer {
                val tier1Champs = ArrayList<TierChamp>()
                val tier2Champs = ArrayList<TierChamp>()
                val tier3Champs = ArrayList<TierChamp>()
                val tier4Champs = ArrayList<TierChamp>()
                val tier5Champs = ArrayList<TierChamp>()

                // tier별로 각기 다른 adapter에 데이터를 set 한다
                it!!.forEach {
                    when (it.tier) {
                        "Tier 1" -> tier1Champs.add(it)
                        "Tier 2" -> tier2Champs.add(it)
                        "Tier 3" -> tier3Champs.add(it)
                        "Tier 4" -> tier4Champs.add(it)
                        "Tier 5" -> tier5Champs.add(it)
                    }
                }

                // Groupie adapter에 각 데이터 업데이트
                tier1Champs.map { TierGroupie(requireContext(), database, tier1Champs) }
                    .also { tier1groupieAdapter.update(it) }
                tier2Champs.map { TierGroupie(requireContext(), database, tier2Champs) }
                    .also { tier2groupieAdapter.update(it) }
                tier3Champs.map { TierGroupie(requireContext(), database, tier3Champs) }
                    .also { tier3groupieAdapter.update(it) }
                tier4Champs.map { TierGroupie(requireContext(), database, tier4Champs) }
                    .also { tier4groupieAdapter.update(it) }
                tier5Champs.map { TierGroupie(requireContext(), database, tier5Champs) }
                    .also { tier5groupieAdapter.update(it) }
            })
        }

        when (position) {
            // viewModel에서 지금 fragment에 해당하는 데이터 가져오기
            0 -> setDataInAdapter(tierViewModel.topTierData)
            1 -> setDataInAdapter(tierViewModel.jungleTierData)
            2 -> setDataInAdapter(tierViewModel.midTierData)
            3 -> setDataInAdapter(tierViewModel.adcTierData)
            4 -> setDataInAdapter(tierViewModel.supTierData)
        }

        return binding.root
    }
}