package com.example.firstapp.data.repository

import com.example.firstapp.data.api.PatchApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext


class PatchRepository(private val patchApi: PatchApi) {

    val patchBaseURL = "https://www.leagueoflegends.com/ko-kr/news/game-updates/patch-"

    val imageURLList = mutableListOf<String?>()
    val patchSummaryList = mutableListOf<String?>()
    val summaryTextList = mutableListOf<String?>()

    suspend fun getPatchVersion(): List<String> = withContext(Dispatchers.IO){
        var htmlData = patchApi.getPatchVersionData().body()!!.string()
        htmlData = htmlData.replace("\"", "")
        htmlData = htmlData.replace("[", "")
        htmlData = htmlData.replace("]", "")
        val versionList = htmlData.split(",")

        return@withContext versionList
    }

    fun getPatchURL(patchVersion: String): String {
//        Log.d("PatchRepository", "patchVersion: $patchVersion")
        var patchVersionForURL = patchVersion.replace(".", "-")

        patchVersionForURL = patchVersionForURL.substring(0, patchVersionForURL.length - 2)
//        Log.d("PatchRepository", "patchVersionForURL: $patchVersionForURL")
        patchVersionForURL = "$patchVersionForURL-notes"

        return patchBaseURL + patchVersionForURL
    }
}
