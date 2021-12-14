package com.example.firstapp.fragment.universe

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.firstapp.R
import com.example.firstapp.adapter.universe.UniverseRegionTabAdapter
import com.example.firstapp.databinding.FragmentUniverseRegionBinding
import com.example.firstapp.model.universe.UniverseRegion

class UniverseRegionFragment: Fragment() {

    private var _binding: FragmentUniverseRegionBinding?= null

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentUniverseRegionBinding.inflate(layoutInflater, container, false)
        val root: View = binding.root

        val regionItems: ArrayList<UniverseRegion> = arrayListOf()
        initItems(regionItems)

        val adapter = UniverseRegionTabAdapter(context, regionItems)
        binding.recyclerviewUniverseRegion.apply {
            this.adapter = adapter
            layoutManager = LinearLayoutManager(context)
            setHasFixedSize(true)
        }

        return root
    }

    private fun initItems(items: ArrayList<UniverseRegion>) {
        items.add(UniverseRegion(R.drawable.background_shadowisles,R.drawable.ic_shadow_small,resources.getString(R.string.universe_region_void)))
        items.add(UniverseRegion(R.drawable.background_shadowisles,R.drawable.ic_shadow_small,resources.getString(R.string.universe_region_shadowisles)))
        items.add(UniverseRegion(R.drawable.background_shadowisles,R.drawable.ic_shadow_small,resources.getString(R.string.universe_region_noxus)))
        items.add(UniverseRegion(R.drawable.background_shadowisles,R.drawable.ic_shadow_small,resources.getString(R.string.universe_region_demacia)))
        items.add(UniverseRegion(R.drawable.background_shadowisles,R.drawable.ic_shadow_small,resources.getString(R.string.universe_region_bandle_city)))
        items.add(UniverseRegion(R.drawable.background_shadowisles,R.drawable.ic_shadow_small,resources.getString(R.string.universe_region_bilgewater)))
    }
}