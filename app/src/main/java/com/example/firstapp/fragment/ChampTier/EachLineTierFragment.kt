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
import com.example.firstapp.adapter.ChampTier.Tier1Adapter
import com.example.firstapp.database.AppDatabase
import com.example.firstapp.databinding.FragmentTierMidBinding
import com.example.firstapp.model.TierViewModel
import com.example.firstapp.model.tier.TierChamp
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

        Log.d("viewPager2", "current position: $position")

        // RecyclerView 초기화
        binding.tier1Recycler.layoutManager =
            GridLayoutManager(context, 4, GridLayoutManager.VERTICAL, false)
        binding.tier2Recycler.layoutManager =
            GridLayoutManager(context, 4, GridLayoutManager.VERTICAL, false)
        binding.tier3Recycler.layoutManager =
            GridLayoutManager(context, 4, GridLayoutManager.VERTICAL, false)
        binding.tier4Recycler.layoutManager =
            GridLayoutManager(context, 4, GridLayoutManager.VERTICAL, false)
        binding.tier5Recycler.layoutManager =
            GridLayoutManager(context, 4, GridLayoutManager.VERTICAL, false)

        val firstTierAdapter = Tier1Adapter(requireContext(), database)
        val secondTierAdapter = Tier1Adapter(requireContext(), database)
        val thirdTierAdapter = Tier1Adapter(requireContext(), database)
        val forthTierAdapter = Tier1Adapter(requireContext(), database)
        val fifthTierAdapter = Tier1Adapter(requireContext(), database)

        binding.tier1Recycler.let {
            it.adapter = firstTierAdapter
            // 각각의 Tier 어댑터가 스크롤될 수 있는게 아니라 모든 데이터를 다 View에 담아서 보여주게 설정
            // 이렇게 안하면 일부 Tier의 Adapter의 사이즈가 작아지면서 스크롤 가능한 형태로 보여준다
            it.isNestedScrollingEnabled = false
        }
        binding.tier2Recycler.let {
            it.adapter = secondTierAdapter
            it.isNestedScrollingEnabled = false
        }
        binding.tier3Recycler.let {
            it.adapter = thirdTierAdapter
            it.isNestedScrollingEnabled = false
        }
        binding.tier4Recycler.let {
            it.adapter = forthTierAdapter
            it.isNestedScrollingEnabled = false
        }
        binding.tier5Recycler.let {
            it.adapter = fifthTierAdapter
            it.isNestedScrollingEnabled = false
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

                // 이를 이제 각 adapter에 넣는다
                // adapter에 데이터를 set 하면서 차이가 있는 부분만 변경한다
                firstTierAdapter.differ.submitList(tier1Champs)
                secondTierAdapter.differ.submitList(tier2Champs)
                thirdTierAdapter.differ.submitList(tier3Champs)
                forthTierAdapter.differ.submitList(tier4Champs)
                fifthTierAdapter.differ.submitList(tier5Champs)
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