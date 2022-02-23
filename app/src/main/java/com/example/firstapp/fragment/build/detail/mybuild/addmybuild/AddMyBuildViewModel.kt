package com.example.firstapp.fragment.build.detail.mybuild.addmybuild

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.firstapp.fragment.build.detail.mybuild.repository.MyBuildRepository
import com.example.firstapp.model.MyBuild
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AddMyBuildViewModel @Inject constructor(
    private val myBuildRepository: MyBuildRepository
) : ViewModel() {

    var myBuildNameET = MutableLiveData("test")
    var myBuildNoteET = MutableLiveData<String>()

    fun saveAddBuild(newBuild: MyBuild) =
        viewModelScope.launch {
            myBuildRepository.insert(newData = newBuild)
        }
}