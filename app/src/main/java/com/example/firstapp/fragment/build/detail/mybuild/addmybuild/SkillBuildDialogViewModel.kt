package com.example.firstapp.fragment.build.detail.mybuild.addmybuild

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import timber.log.Timber

class SkillBuildDialogViewModel : ViewModel() {

    private val _skillTree = MutableLiveData<MutableList<String>>()
    val skillTree: LiveData<MutableList<String>> get() = _skillTree

    fun changeSkillTree(index: Int, skill: String){
        val list = _skillTree.value

        if (list == null) {
            val newList = mutableListOf(skill)
            _skillTree.value = newList
            Timber.d("done new")
        }

        if(list != null) {
            if(index == list.size){
                list.add(skill)
                _skillTree.value = list!!
                Timber.d("done null1")
            } else if(index < list.size) {
                list[index] = skill
                _skillTree.value = list!!
                Timber.d("done null2")
            }
        }
    }
}