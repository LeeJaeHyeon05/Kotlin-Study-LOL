package com.example.firstapp.fragment.ChampTier

import android.annotation.SuppressLint
import android.os.Bundle
import android.os.Parcel
import android.os.Parcelable
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.setFragmentResult
import androidx.lifecycle.Observer
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.firstapp.App
import com.example.firstapp.R
import com.example.firstapp.adapter.ChampTier.TierPagerAdapter
import com.example.firstapp.data.repository.TierRepository
import com.example.firstapp.databinding.FragmentTierBinding
import com.example.firstapp.model.ApiResponse
import com.example.firstapp.model.ItemViewModel
import com.example.firstapp.model.TierViewModel
import com.example.firstapp.model.tier.TierLine
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
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

    @SuppressLint("UseCompatLoadingForDrawables")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // 챔피언 데이터를 받기 위한 객체
        // fragment 객체 생성
        val topFragment = TierTopFragment()
        val botFragment = TierBotFragment()
        val midFragment = TierMidFragment()
        val supFragment = TierSupFragment()
        val jungFragment = TierJungFragment()

        val binding = FragmentTierBinding.inflate(inflater, container, false)
        val fragmentList = arrayOf(topFragment, jungFragment, midFragment, botFragment, supFragment)

        val adapter = object : FragmentStateAdapter(this) {
            override fun getItemCount(): Int {
                return fragmentList.size
            }

            override fun createFragment(position: Int): Fragment {
                return fragmentList[position]
            }

            //
            override fun getItemId(position: Int): Long {
                return super.getItemId(position)
            }

            //
            override fun containsItem(itemId: Long): Boolean {
                return super.containsItem(itemId)
            }
        }

        val pagerAdapter = TierPagerAdapter(this)

        binding.viewPager.adapter = adapter

        /* viewModel로 데이터 갱신하고
           각 fragment에 데이터 분배하기
         */
        tierViewModel.tierDataList.observe(viewLifecycleOwner, Observer {
            // todo 받아온 데이터를 각각의 fragment에 넣기
            val topTierData = it.top
            val midTierData = it.mid
            val jungleTierData = it.jungle
            val adcTierData = it.adc
            val supTierData = it.sup

            val parcelTopTierData = BaseParcelable(topTierData!!)

            Log.d("jsoup", "topTierData: $topTierData")

            setFragmentResult("tierDataKey", bundleOf("topTierKey" to parcelTopTierData))
            setFragmentResult("tierDataKey", bundleOf("topString" to "from Fragment"))
            adapter.notifyDataSetChanged()
        })

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
}

class BaseParcelable : Parcelable {

    var value: Any

    constructor(value: Any) {
        this.value = value
    }

    constructor(parcel: Parcel) {
        this.value = Any()
    }

    override fun writeToParcel(dest: Parcel?, flags: Int) {}

    override fun describeContents(): Int = 0

    companion object CREATOR : Parcelable.Creator<BaseParcelable> {

        override fun createFromParcel(parcel: Parcel): BaseParcelable {
            return BaseParcelable(parcel)
        }

        override fun newArray(size: Int): Array<BaseParcelable?> {
            return arrayOfNulls(size)
        }
    }
}