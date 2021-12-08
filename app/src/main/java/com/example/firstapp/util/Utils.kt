package com.example.firstapp.util

import android.content.Context
import com.example.firstapp.BuildConfig
import java.io.IOException

fun getJsonDataFromAsset(context: Context, fileName: String): String {
    val jsonString: String
    try {
        jsonString = context.assets.open(fileName).bufferedReader().use { it.readText() }
    } catch (ioException: IOException) {
        ioException.printStackTrace()
        return "{}"
    }
    return jsonString
}

fun getBaseImageUrl(): String {
    var baseImageUrl = "https://ddragon.leagueoflegends.com/cdn/11.22.1/img"
    if (BuildConfig.DEBUG) baseImageUrl = baseImageUrl.replace("https:", "http:")
    return baseImageUrl
}