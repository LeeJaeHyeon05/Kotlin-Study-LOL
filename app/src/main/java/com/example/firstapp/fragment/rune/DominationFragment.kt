package com.example.firstapp.fragment.rune

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import com.example.firstapp.R
import com.example.firstapp.adapter.summorSpell.CustomAdapter
import com.example.firstapp.databinding.FragmentRuneDominationBinding

class DominationFragment : Fragment() {

    lateinit var multiAdapter:RuneAdapter
    val datas = mutableListOf<Item>()

    private var mBinding: FragmentRuneDominationBinding? = null
    private val binding get() = mBinding!!


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        mBinding = FragmentRuneDominationBinding.inflate(inflater,container,false)

        initRecycler()

        return binding.root
    }


    private fun initRecycler() {
        multiAdapter = RuneAdapter(requireContext())
        binding.dominationRecyclerView.adapter = multiAdapter


        datas.apply {
            add(Item(R.drawable.whimsy, BIG_POSITION))
            add(Item(R.drawable.whimsy, BIG_POSITION))
            add(Item(R.drawable.whimsy, BIG_POSITION))
            add(Item(R.drawable.whimsy, BIG_POSITION))
            add(Item(R.drawable.whimsy, BIG_POSITION))
            add(Item(R.drawable.whimsy, BIG_POSITION))
            add(Item(R.drawable.whimsy, BIG_POSITION))
            add(Item(R.drawable.whimsy, BIG_POSITION))
            add(Item(R.drawable.whimsy, BIG_POSITION))
            add(Item(R.drawable.whimsy, BIG_POSITION))



        }


        multiAdapter.datas = datas
        multiAdapter.notifyDataSetChanged()
    }


    override fun onDestroy() {
        super.onDestroy()
        mBinding = null
    }
}