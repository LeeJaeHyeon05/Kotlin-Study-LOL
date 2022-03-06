package com.example.firstapp.model

import androidx.lifecycle.ViewModel
import com.example.firstapp.data.repository.PatchRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class PatchViewModel @Inject constructor(private val patchRepository: PatchRepository) : ViewModel() {
    suspend fun getPatchVersionData() = withContext(Dispatchers.IO){
        return@withContext patchRepository.getPatchVersion()
    }

    fun getPatchURL(patchVersion: String) = patchRepository.getPatchURL(patchVersion)
}
