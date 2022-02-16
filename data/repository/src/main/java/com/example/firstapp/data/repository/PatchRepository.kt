package com.example.firstapp.data.repository

import android.util.Log
import com.example.firstapp.data.api.PatchApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import org.jsoup.Jsoup


class PatchRepository(private val patchApi: PatchApi) {

    val patchBaseURL = "https://www.leagueoflegends.com/ko-kr/news/game-updates/patch-"

    suspend fun getPatchVersion(): List<String> = withContext(Dispatchers.IO){
        var htmlData = patchApi.getPatchVersionData().body()!!.string()
        htmlData = htmlData.replace("\"", "")
        htmlData = htmlData.replace("[", "")
        htmlData = htmlData.replace("]", "")
        val versionList = htmlData.split(",")

        return@withContext versionList
    }

    suspend fun getPatchData(patchVersion: String){
//        Log.d("PatchRepository", "patchVersion: $patchVersion")
        var patchVersionForURL = patchVersion.replace(".", "-")

        patchVersionForURL = patchVersionForURL.substring(0, patchVersionForURL.length-2)
//        Log.d("PatchRepository", "patchVersionForURL: $patchVersionForURL")
        patchVersionForURL = "$patchVersionForURL-notes"

        val patchURL = patchBaseURL + patchVersionForURL

        val webDoc = Jsoup.connect(patchURL).get()

        Log.d("PatchRepository", "HTML BODY: $webDoc")

        val champImageLink =
            webDoc.getElementsByClass("reference-link")

        Log.d("PatchRepository", "champImageLink: ${champImageLink[0].getElementsByTag("img")}")
    }
}