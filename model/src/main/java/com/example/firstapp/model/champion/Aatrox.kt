package com.example.firstapp.model.champion

data class Aatrox(
    val allytips: List<String>,
    val blurb: String,
    val enemytips: List<String>,
    val id: String,
    val image: Image,
    val info: Info,
    val key: String,
    val lore: String,
    val name: String,
    val partype: String,
    val passive: Passive,
    val recommended: List<Any>,
    val skins: List<Skin>,
    val spells: List<Spell>,
    val stats: Stats,
    val tags: List<String>,
    val title: String
)