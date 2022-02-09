package com.example.firstapp.data.repository

import android.util.Log
import com.example.firstapp.data.api.PatchApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class PatchRepository(val patchApi: PatchApi) {
    suspend fun getPatchVersion(): String? = withContext(Dispatchers.IO){
        Log.d("PatchRepository", "${patchApi.getPatchVersionData().body()}")
        return@withContext patchApi.getPatchVersionData().body()
    }
}