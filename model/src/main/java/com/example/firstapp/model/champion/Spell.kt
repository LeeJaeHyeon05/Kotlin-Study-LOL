package com.example.firstapp.model.champion

data class Spell(
    val cooldown: List<Float>,
    val cooldownBurn: String,
    val cost: List<Int>,
    val costBurn: String,
    val costType: String,
    val datavalues: Datavalues,
    val description: String,
    val effect: List<Any>,
    val effectBurn: List<Any>,
    val id: String,
    val image: ImageXX,
    val leveltip: Leveltip,
    val maxammo: String,
    val maxrank: Int,
    val name: String,
    val range: List<Int>,
    val rangeBurn: String,
    val resource: String,
    val tooltip: String,
    val vars: List<Any>
)