package com.example.firstapp.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.PrimaryKey
import com.google.gson.JsonArray
import com.google.gson.JsonObject
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class ItemAll(
    val type: String,
    val version: String,
    @SerializedName(value = "items", alternate = ["data"])
    val items: Map<String, Item>,
)

@Entity(tableName = "item")
data class Item(
    @PrimaryKey
    @ColumnInfo(name = "id") var id: String,
    @ColumnInfo(name = "name") val name: String,
    @ColumnInfo(name = "description") val description: String,
    @ColumnInfo(name = "colloq") val colloq: String,
    @ColumnInfo(name = "plaintext") val plaintext: String,
    @ColumnInfo(name = "into") val into: JsonArray,
    @ColumnInfo(name = "image") val image: JsonObject,
    @ColumnInfo(name = "gold") val gold: JsonObject,
    @ColumnInfo(name = "tags") val tags: JsonArray,
    @ColumnInfo(name = "maps") val maps: JsonObject,
    @ColumnInfo(name = "stats") val stats: JsonObject,

    @Expose(serialize = false, deserialize = false)
    @Ignore var itemImage: ItemImage?,

    @Expose(serialize = false, deserialize = false)
    @Ignore var itemGold: ItemGold?,
) {
    constructor(
        id: String,
        name: String,
        description: String,
        colloq: String,
        plaintext: String,
        into: JsonArray,
        image: JsonObject,
        gold: JsonObject,
        tags: JsonArray,
        maps: JsonObject,
        stats: JsonObject
    ) : this(
        id,
        name,
        description,
        colloq,
        plaintext,
        into,
        image,
        gold,
        tags,
        maps,
        stats,
        null,
        null
    )
}

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