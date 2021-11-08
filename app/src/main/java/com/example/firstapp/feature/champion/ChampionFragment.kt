package com.example.firstapp.feature.champion

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.firstapp.R

/**
 * @author hanago
 * @email kottodat@naver.com
 * @since 2021/11/08
 **/
class ChampionFragment : Fragment() {

    private val viewType: Int by lazy {
        arguments?.getInt(KEY_VIEW_TYPE) ?: 0
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_champion, container, false)
        return view
    }

    companion object {

        const val KEY_VIEW_TYPE = "key_view_type"
        const val VIEW_TYPE_DEFAULT = 0

        @JvmStatic
        fun newInstance(viewType: Int = VIEW_TYPE_DEFAULT) =
            ChampionFragment().apply {
                arguments = Bundle().apply {
                    putInt(KEY_VIEW_TYPE, viewType)
                }
            }
    }
}