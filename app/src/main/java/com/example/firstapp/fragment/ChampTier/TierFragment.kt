package com.example.firstapp.fragment.ChampTier

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.room.Room
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.firstapp.R
import com.example.firstapp.data.api.TierData
import com.example.firstapp.database.AppDatabase
import com.example.firstapp.databinding.FragmentTierBinding
import com.example.firstapp.model.TierViewModel
import com.example.firstapp.model.tier.TierChamp
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch
import timber.log.Timber
import javax.inject.Inject

/**
 * @author mmol93
 * @email ljws93@naver.com
 * @since 2021/11/10
 **/

@AndroidEntryPoint
class TierFragment : Fragment(R.layout.fragment_tier) {
    // activityViewModels: Activity의 viewModel에 접근하도록 한다
    private val tierViewModel: TierViewModel by activityViewModels()

    @Inject
    lateinit var database: AppDatabase

    @SuppressLint("UseCompatLoadingForDrawables")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // 챔피언 데이터를 받기 위한 객체
        // fragment 객체 생성
        val topFragment = EachLineTierFragment(0)
        val jungFragment = EachLineTierFragment(1)
        val midFragment = EachLineTierFragment(2)
        val botFragment = EachLineTierFragment(3)
        val supFragment = EachLineTierFragment(4)

        val fragments = arrayListOf<Fragment>(topFragment, jungFragment, midFragment, botFragment, supFragment)

        val binding = FragmentTierBinding.inflate(inflater, container, false)

        /* viewModel로 데이터 갱신하고
           각 fragment에 데이터 분배하기
         */
//        tierViewModel.tierDataList.observe(viewLifecycleOwner, Observer {
//            Timber.d("TierFragment에서 Jsoup 데이터 갱신함")
//        })


        // Room DB에서 데이터 가져와서 TierViewModel에 있는 각 라인의 MutableLiveData에 데이터 넣기
        separateTierDataForEachLine()


        val adapter = object : FragmentStateAdapter(this) {
            override fun getItemCount(): Int {
                return fragments.size
            }

            override fun createFragment(position: Int): Fragment {
                return fragments[position]
            }
        }
        binding.viewPager.adapter = adapter

        // tab과 viewPager2를 연결시킨다
        TabLayoutMediator(binding.tabs, binding.viewPager) { tab: TabLayout.Tab, i: Int ->
            if (i == 0) {
                tab.icon = requireContext().getDrawable(R.drawable.ic_top)
            } else if (i == 1) {
                tab.icon = requireContext().getDrawable(R.drawable.ic_jng)
            } else if (i == 2) {
                tab.icon = requireContext().getDrawable(R.drawable.ic_mid)
            } else if (i == 3) {
                tab.icon = requireContext().getDrawable(R.drawable.ic_adc)
            } else if (i == 4) {
                tab.icon = requireContext().getDrawable(R.drawable.ic_sup)
            }
        }.attach()

        return binding.root
    }

    // 이 부분은 context를 사용하기 때문에 viewModel에서 동작을 지정할 경우 메모리 누수가 일어날 수 있음
    // 그렇기 때문에 Fragment에서 데이터 정의 및 정리를 실시한다
    private fun separateTierDataForEachLine(){
        CoroutineScope(Dispatchers.IO).launch {
            val tierData = database.championTierDao().selectAll()

            val topTierData = ArrayList<TierChamp>()
            val jungleTierData = ArrayList<TierChamp>()
            val midTierData = ArrayList<TierChamp>()
            val adcTierData = ArrayList<TierChamp>()
            val supTierData = ArrayList<TierChamp>()

            tierData.forEach {
                when(it.line){
                    // top
                    1 -> {
                        topTierData.add(it)
                    }
                    // jungle
                    2 -> {
                        jungleTierData.add(it)
                    }
                    // mid
                    3 -> {
                        midTierData.add(it)
                    }
                    // adc
                    4 -> {
                        adcTierData.add(it)
                    }
                    // sup
                    5 -> {
                        supTierData.add(it)
                    }
                }
            }
            Log.d("TierFragment", "topTierData: $topTierData")
            Log.d("TierFragment", "jungleTierData: $jungleTierData")
            Log.d("TierFragment", "midTierData: $midTierData")
            Log.d("TierFragment", "adcTierData: $adcTierData")
            Log.d("TierFragment", "supTierData: $supTierData")

            coroutineScope {
                // viewModel 제어는 main Thread에서 해야한다
                launch(Dispatchers.Main) {
                    tierViewModel.topTierData.postValue(topTierData)
                    tierViewModel.jungleTierData.postValue(jungleTierData)
                    tierViewModel.midTierData.postValue(midTierData)
                    tierViewModel.adcTierData.postValue(adcTierData)
                    tierViewModel.supTierData.postValue(supTierData)
                }
            }
        }
    }
}