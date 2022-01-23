package com.example.firstapp.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.JsonArray
import com.google.gson.JsonObject
import com.google.gson.annotations.SerializedName

data class ChampionAll(
    val type: String,
    val version: String,
    @SerializedName(value = "champions", alternate = ["data"])
    val champions: Map<String, Champion>,
)

@Entity(tableName = "champion")
data class Champion(
    @PrimaryKey
    @ColumnInfo(name = "id") var id: String,
    @ColumnInfo(name = "key") val key: String,
    @ColumnInfo(name = "name") val name: String,
    @ColumnInfo(name = "title") val title: String,
    @ColumnInfo(name = "blurb") val blurb: String,
    @ColumnInfo(name = "info") val info: JsonObject,
    @ColumnInfo(name = "image") val image: JsonObject,
    @ColumnInfo(name = "tags") val tags: JsonArray,
    @ColumnInfo(name = "partype") val partype: String,
    @ColumnInfo(name = "stats") val stats: JsonObject,
)