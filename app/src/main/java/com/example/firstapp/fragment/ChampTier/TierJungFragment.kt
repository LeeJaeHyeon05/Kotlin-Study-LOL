package com.example.firstapp.fragment.ChampTier

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import com.example.firstapp.R
import com.example.firstapp.adapter.ChampTier.Tier1Adapter
import com.example.firstapp.databinding.FragmentTierJungBinding
import com.example.firstapp.databinding.FragmentTierTopBinding
import com.example.firstapp.model.TierViewModel
import com.example.firstapp.model.tier.TierChamp

/**
 * @author mmol93
 * @email ljws93@naver.com
 * @since 2021/11/10
 **/
class TierJungFragment:Fragment() {
    // activityViewModels: Activity의 viewModel에 접근하도록 한다
    private val tierViewModel: TierViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = DataBindingUtil.inflate<FragmentTierJungBinding>(
            inflater,
            R.layout.fragment_tier_jung,
            container,
            false
        )

        // RecyclerView 초기화
        binding.tier1Recycler.layoutManager = GridLayoutManager(context, 4, GridLayoutManager.VERTICAL, false)
        binding.tier2Recycler.layoutManager = GridLayoutManager(context, 4, GridLayoutManager.VERTICAL, false)
        binding.tier3Recycler.layoutManager = GridLayoutManager(context, 4, GridLayoutManager.VERTICAL, false)
        binding.tier4Recycler.layoutManager = GridLayoutManager(context, 4, GridLayoutManager.VERTICAL, false)
        binding.tier5Recycler.layoutManager = GridLayoutManager(context, 4, GridLayoutManager.VERTICAL, false)

        val firstTierAdapter = Tier1Adapter(requireContext())
        val secondTierAdapter = Tier1Adapter(requireContext())
        val thirdTierAdapter = Tier1Adapter(requireContext())
        val forthTierAdapter = Tier1Adapter(requireContext())
        val fifthTierAdapter = Tier1Adapter(requireContext())

        binding.tier2Recycler.let{
            it.adapter = secondTierAdapter
            it.isNestedScrollingEnabled = false
        }
        binding.tier3Recycler.let {
            it.adapter = thirdTierAdapter
            it.isNestedScrollingEnabled = false
        }
        binding.tier4Recycler.let{
            it.adapter = forthTierAdapter
            it.isNestedScrollingEnabled = false
        }
        binding.tier5Recycler.let {
            it.adapter = fifthTierAdapter
            it.isNestedScrollingEnabled = false
        }

        // viewModel에서 지금 fragment에 해당하는 데이터 가져오기
        tierViewModel.jungleTierData.observe(viewLifecycleOwner, Observer {
            val tier1Champs = ArrayList<TierChamp>()
            val tier2Champs = ArrayList<TierChamp>()
            val tier3Champs = ArrayList<TierChamp>()
            val tier4Champs = ArrayList<TierChamp>()
            val tier5Champs = ArrayList<TierChamp>()

            // tier별로 각기 다른 adapter에 데이터를 set 한다
            it!!.forEach {
                when(it.tier){
                    "Tier 1" -> tier1Champs.add(it)
                    "Tier 2" -> tier2Champs.add(it)
                    "Tier 3" -> tier3Champs.add(it)
                    "Tier 4" -> tier4Champs.add(it)
                    "Tier 5" -> tier5Champs.add(it)
                }
            }

            // 이를 이제 각 adapter에 넣는다

            // adapter에 데이터를 set 하면서 차이가 있는 부분만 변경한다

            firstTierAdapter.differ.submitList(tier1Champs)
            secondTierAdapter.differ.submitList(tier2Champs)
            thirdTierAdapter.differ.submitList(tier3Champs)
            forthTierAdapter.differ.submitList(tier4Champs)
            fifthTierAdapter.differ.submitList(tier5Champs)
        })

        return binding.root
    }
}