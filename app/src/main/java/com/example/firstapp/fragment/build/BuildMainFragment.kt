package com.example.firstapp.fragment.build

import android.content.Intent
import android.view.*
import androidx.appcompat.widget.SearchView
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.GridLayoutManager
import com.example.firstapp.R
import com.example.firstapp.databinding.FragmentBuildMainBinding
import com.example.firstapp.fragment.bottomsheet.BuildFilterBottomSheet
import com.example.firstapp.model.BuildViewModel
import com.example.firstapp.model.ItemFilter
import com.example.waterexample.ui.base.BaseFragment
import com.xwray.groupie.GroupieAdapter
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect
import timber.log.Timber


@AndroidEntryPoint
class BuildMainFragment : BaseFragment<FragmentBuildMainBinding>(R.layout.fragment_build_main) {

    private val viewModel: BuildViewModel by viewModels()
    private val groupAdapter = GroupieAdapter()
    private lateinit var groupLayoutManager: GridLayoutManager





    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        menu.clear()
        inflater.inflate(R.menu.item_menu, menu)
        val menuItem: MenuItem = menu.findItem(R.id.action_search)
        val searchView: SearchView = menuItem.actionView as SearchView
        searchView.queryHint = getString(R.string.champion_name)
        searchView.setOnQueryTextFocusChangeListener { v, hasFocus -> menu.findItem(R.id.action_sort).isVisible = !hasFocus
            menu.findItem(R.id.action_info).isVisible = !hasFocus
        }
        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                Timber.i("query : %s", query)
                viewModel.setSearchQuery(query.orEmpty())
                return false
            }
            override fun onQueryTextChange(newText: String?): Boolean {
                Timber.i("query : %s", newText)
                viewModel.setSearchQuery(newText.orEmpty())
                return false
            } })
        super.onCreateOptionsMenu(menu, inflater)
    }
    override fun init() {
        setHasOptionsMenu(true)
        viewModel.getChampion()
        groupLayoutManager = GridLayoutManager(context, 4).apply {
            spanSizeLookup = groupAdapter.spanSizeLookup }
        binding.buildMainRv.apply { adapter = groupAdapter
            layoutManager = groupLayoutManager
        }
        repeatOnStarted {
            // 챔피언리스트
            viewModel.mChampionList.collect {Champion->
                groupAdapter.update(Champion)
            }
        }
    }



    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.action_info -> {
                val buildFilterBottomSheet = BuildFilterBottomSheet()
                buildFilterBottomSheet.show(
                    requireActivity().supportFragmentManager,
                    BuildFilterBottomSheet.TAG
                )
            }
        }

        return super.onOptionsItemSelected(item)
    }


}


