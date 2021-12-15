package com.example.firstapp.fragment.build

import android.os.Bundle
import android.view.*
import androidx.appcompat.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.GridLayoutManager
import com.example.firstapp.R
import com.example.firstapp.databinding.FragmentBuildMainBinding
import com.example.waterexample.ui.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect


@AndroidEntryPoint
class BuildMainFragment : BaseFragment<FragmentBuildMainBinding>(R.layout.fragment_build_main) {

    private val viewModel: BuildViewModel by viewModels()

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        menu.clear()
        inflater.inflate(R.menu.item_menu, menu)
        menuItem = menu.getItem(2)

        val menuItem: MenuItem = menu.findItem(R.id.action_search)
        val searchView: SearchView = menuItem.actionView as SearchView
        inflater.

         menuItem = menu.getItem(number);
        menuItem.setIcon(some_icon);
        menuItem.setTitle(some_text);
        searchView.queryHint = getString(R.string.champion_name)

        searchView.setOnQueryTextFocusChangeListener { v, hasFocus ->
            menu.findItem(R.id.action_sort).isVisible = !hasFocus
        }




        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun init() {
        setHasOptionsMenu(true)


        repeatOnStarted {
            viewModel.getChampion().collect { Champion ->
                val championList = Champion.data.values.toList().sortedBy { it.name }
                val adapter = BuildMainAdapter(this@BuildMainFragment.context, championList)
                binding.buildMainRv.adapter = adapter
                binding.buildMainRv.layoutManager = GridLayoutManager(
                    this@BuildMainFragment.context, 4, GridLayoutManager.VERTICAL, false
                )
            }
        }


    }
}