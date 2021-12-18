package com.example.firstapp.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.JsonArray
import com.google.gson.JsonObject
import com.google.gson.annotations.SerializedName

data class SummonerAll(
    val type: String,
    val version: String,
    @SerializedName(value = "summoners", alternate = ["data"])
    val summoners: Map<String, Summoner>,
)

@Entity(tableName = "summoner")
data class Summoner(
    @PrimaryKey
    @ColumnInfo(name = "id") var id: String,
    @ColumnInfo(name = "name") val name: String,
    @ColumnInfo(name = "description") val description: String,
    @ColumnInfo(name = "tooltip") val tooltip: String,
    @ColumnInfo(name = "maxrank") val maxrank: Int,
    @ColumnInfo(name = "cooldown") val cooldown: JsonArray,
    @ColumnInfo(name = "cooldownBurn") val cooldownBurn: String,
    @ColumnInfo(name = "datavalues") val datavalues: JsonObject,
    @ColumnInfo(name = "effect") val effect: JsonArray,
    @ColumnInfo(name = "effectBurn") val effectBurn: JsonArray,
    @ColumnInfo(name = "vars") val vars: JsonArray,
    @ColumnInfo(name = "key") val key: String,
    @ColumnInfo(name = "summonerLevel") val summonerLevel: Int,
    @ColumnInfo(name = "modes") val modes: JsonArray,
    @ColumnInfo(name = "costType") val costType: String,
    @ColumnInfo(name = "maxammo") val maxammo: String,
    @ColumnInfo(name = "range") val range: JsonArray,
    @ColumnInfo(name = "rangeBurn") val rangeBurn: String,
    @ColumnInfo(name = "image") val image: JsonObject,
    @ColumnInfo(name = "resource") val resource: String,
)