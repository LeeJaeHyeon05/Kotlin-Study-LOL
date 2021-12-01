package com.example.firstapp.model.champion

/**
 * @author hanago
 * @email kottodat@naver.com
 * @since 2021/11/15
 **/
data class ChampionVO(
    val type: String,
    val format: String,
    val version: String,
    val data: HashMap<String, Champion>
)

/**
 *  "version": "11.22.1",
"id": "Aatrox",
"key": "266",
"name": "Aatrox",
"title": "the Darkin Blade",
"blurb": "Once honored defenders of Shurima against the Void, Aatrox and his brethren would eventually become an even greater threat to Runeterra, and were defeated only by cunning mortal sorcery. But after centuries of imprisonment, Aatrox was the first to find...",
"info": {},
"image": {},
"tags": [],
"partype": "Blood Well",
"stats": {}
 */
data class Champion(
    val version: String,
    val id: String,
    val key: String,
    val name: String,
    val title: String,
    val blurb: String,
    val info: Info,
    val image: Image,
    val tags: List<String>,
    val partype: String,
    val stats: Stats,
)

data class Image(
    val full: String,
    val group: String,
    val h: Int,
    val sprite: String,
    val w: Int,
    val x: Int,
    val y: Int
)

data class Info(
    val attack: Int,
    val defense: Int,
    val difficulty: Int,
    val magic: Int
)

data class Stats(
    val armor: Float,
    val armorperlevel: Double,
    val attackdamage: Float,
    val attackdamageperlevel: Float,
    val attackrange: Float,
    val attackspeed: Double,
    val attackspeedperlevel: Double,
    val crit: Float,
    val critperlevel: Float,
    val hp: Float,
    val hpperlevel: Float,
    val hpregen: Float,
    val hpregenperlevel: Float,
    val movespeed: Float,
    val mp: Float,
    val mpperlevel: Float,
    val mpregen: Float,
    val mpregenperlevel: Float,
    val spellblock: Float,
    val spellblockperlevel: Double
)



