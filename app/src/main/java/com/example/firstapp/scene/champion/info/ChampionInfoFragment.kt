package com.example.firstapp.scene.champion.info

import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Build
import android.os.Bundle
import android.util.TypedValue
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import androidx.annotation.Dimension
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.MutableLiveData
import com.example.firstapp.R
import com.example.firstapp.databinding.FragmentChampionInfoBinding
import com.example.firstapp.model.champion.Champion
import com.example.firstapp.scene.champion.info.general.ChampionGeneralItem
import com.squareup.picasso.Picasso
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
    val selectedTab: MutableLiveData<Int> = MutableLiveData(0)

    override fun onResume() {
        super.onResume()
        // full Screen code
        dialog?.window?.setLayout(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.MATCH_PARENT
        )
        dialog?.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        dialog?.window?.clearFlags(WindowManager.LayoutParams.FLAG_DIM_BEHIND)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val binding = FragmentChampionInfoBinding.bind(view)

        binding.vpContent.let {
            it.adapter = adapter
        }

        viewModel.champions.observe(viewLifecycleOwner) { champions ->
            champions[championName]?.let{
                summary(binding,it)

                adapter.add(ChampionGeneralItem(it))
                adapter.add(ChampionGeneralItem(it))
                adapter.add(ChampionGeneralItem(it))
                adapter.add(ChampionGeneralItem(it))
                adapter.add(ChampionGeneralItem(it))
            }

        }

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            binding.scRoot.setOnScrollChangeListener { _, _, scrollY, _, _ ->

                if (scrollY > dpToPx(requireContext(),120)) {
                    binding.llStickyTab.visibility = View.VISIBLE
                } else {
                    binding.llStickyTab.visibility = View.GONE
                }

                (binding.clSummary.layoutParams as ConstraintLayout.LayoutParams).let{
                    it.topMargin = -scrollY / 2
                    binding.clSummary.layoutParams = it
                }

            }
        }
    }


    fun summary(viewBinding: FragmentChampionInfoBinding, champion: Champion){
        viewBinding.tvName.text = champion.name
        viewBinding.tvScript.text = champion.title
        Picasso.get()
            .load("http://ddragon.leagueoflegends.com/cdn/11.22.1/img/champion/" + champion.image.full)
            .into(viewBinding.ivThumbnail)
    }

    private val championName: String
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

    fun dpToPx(context: Context, @Dimension(unit = Dimension.DP) dp: Int): Float {
        val r = context.resources
        return TypedValue.applyDimension(
            TypedValue.COMPLEX_UNIT_DIP,
            dp.toFloat(),
            r.displayMetrics
        )
    }

}