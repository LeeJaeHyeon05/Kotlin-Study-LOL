package com.example.firstapp.model.champion

data class Stats(
    val armor: Int,
    val armorperlevel: Double,
    val attackdamage: Int,
    val attackdamageperlevel: Int,
    val attackrange: Int,
    val attackspeed: Double,
    val attackspeedperlevel: Double,
    val crit: Int,
    val critperlevel: Int,
    val hp: Int,
    val hpperlevel: Int,
    val hpregen: Int,
    val hpregenperlevel: Int,
    val movespeed: Int,
    val mp: Int,
    val mpperlevel: Int,
    val mpregen: Int,
    val mpregenperlevel: Int,
    val spellblock: Int,
    val spellblockperlevel: Double
)