package com.example.firstapp.model

/**
 * FirstApp
 * Class: Champion
 * Created by 82102 on 2021-11-25.
 *
 * Description:
 */
@Parcelize
data class Champion (
    val type: Type,
    val format: String,
    val version: Version,
    val data: Map<String, Datum>
)

@Serializable
data class Datum (
    val version: Version,
    val id: String,
    val key: String,
    val name: String,
    val title: String,
    val blurb: String,
    val info: Info,
    val image: Image,
    val tags: List<Tag>,
    val partype: Partype,
    val stats: Map<String, Double>
)

@Serializable
data class Image (
    val full: String,
    val sprite: Sprite,
    val group: Type,
    val x: Long,
    val y: Long,
    val w: Long,
    val h: Long
)