package com.example.firstapp.util

import android.content.Context
import com.example.firstapp.BuildConfig
import org.jsoup.Jsoup
import org.jsoup.nodes.Document
import org.jsoup.safety.Whitelist
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
    var baseImageUrl = "https://ddragon.leagueoflegends.com/cdn/11.23.1/img"
    if (BuildConfig.DEBUG) baseImageUrl = baseImageUrl.replace("https:", "http:")
    return baseImageUrl
}

val tagToColorMap: Map<String, String> = mapOf(
    "active" to "#FFA500",
    "attackSpeed" to "#FFFF00",
    "attention" to "#FFFFFF",
    "keywordStealth" to "#FF00FF",
    "magicDamage" to "#87CEFA",
    "OnHit" to "#FFFFFF",
    "passive" to "#FFD700",
    "physicalDamage" to "#FF4500",
    "rarityLegendary" to "#FFA500",
    "rarityMythic" to "#FF8C00",
    "scaleArmor" to "#FFFF00",
    "scaleHealth" to "#008000",
    "scaleMana" to "#87CEFA",
    "scaleMR" to "#FF00FF",
    "shield" to "#00BFFF",
    "speed" to "#FFFF00",
    "status" to "#DA70D6",
)

fun getItemDescriptionToHtml(itemDescription: String): String {
    var doc: Document = Jsoup.parse(itemDescription)

    tagToColorMap.forEach {
        var elements = doc.getElementsByTag(it.key)
        for (element in elements) {
            element.html("<span style='color: ${it.value};'>${element.html()}</span>")
        }
    }

    var rulesElements = doc.getElementsByTag("rules")
    for (rulesElement in rulesElements) {
        rulesElement.html("<i>${rulesElement.html()}</i>")
    }

    return Jsoup.clean(doc.html(), Whitelist.relaxed().addAttributes("span", "style"))
}