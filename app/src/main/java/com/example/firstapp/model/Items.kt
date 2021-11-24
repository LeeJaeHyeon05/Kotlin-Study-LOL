package com.example.firstapp.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.JsonArray
import com.google.gson.JsonObject
import com.google.gson.annotations.SerializedName

data class ItemAll(
    val type: String,
    val version: String,
    @SerializedName(value = "items", alternate = ["data"])
    val items: Map<String, Items>,
)

@Entity(tableName = "item")
data class Items(
    @PrimaryKey var id: String,
    @ColumnInfo(name = "name") val name: String,
    @ColumnInfo(name = "description") val description: String,
    @ColumnInfo(name = "colloq") val colloq: String,
    @ColumnInfo(name = "plaintext") val plaintext: String,
    @ColumnInfo(name = "into") val into: JsonArray,
    @ColumnInfo(name = "image") var image: JsonObject,
    @ColumnInfo(name = "gold") var gold: JsonObject,
    @ColumnInfo(name = "tags") val tags: JsonArray,
    @ColumnInfo(name = "maps") var maps: JsonObject,
    @ColumnInfo(name = "stats") var stats: JsonObject
)

data class ItemImage(
    val full: String,
    val sprite: String,
    val group: String,
    val x: Int,
    val y: Int,
    val w: Int,
    val h: Int
)

data class ItemGold(
    val base: Int,
    val purchasable: Boolean,
    val total: Int,
    val sell: Int
)