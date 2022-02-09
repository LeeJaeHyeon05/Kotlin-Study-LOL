package com.example.firstapp.data.repository

import com.example.firstapp.data.api.PatchApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class PatchRepository(val patchApi: PatchApi) {
    suspend fun getPatchVersion(): String? = withContext(Dispatchers.IO){
        return@withContext patchApi.getPatchVersionData().body()
    }
}