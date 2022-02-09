package com.example.firstapp.model

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.example.firstapp.data.repository.PatchRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import javax.inject.Inject

@HiltViewModel
class PatchViewModel @Inject constructor(private val patchRepository: PatchRepository) : ViewModel() {
    val patchVersionData = liveData<String>(Dispatchers.IO) {
        patchRepository.getPatchVersion()
    }
}