package com.example.firstapp.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.PrimaryKey
import com.example.firstapp.model.Champion.Image

data class ItemJson(
    val type: String,
    val version: String,
    val data: Map<String, Data>,
)

@Entity(tableName = "item")
data class Data(
    @PrimaryKey var id: String,
    @ColumnInfo(name = "name") val name: String,
    @ColumnInfo(name = "description") val description: String,
    @ColumnInfo(name = "colloq") val colloq: String,
    @ColumnInfo(name = "plaintext") val plaintext: String,
    @ColumnInfo(name = "into") val into: List<String>?,
    @Ignore val image: Image?,
    @Ignore val gold: Gold?,
    @ColumnInfo(name = "tags") val tags: List<String>,
    @Ignore val maps: Map<String, Boolean>?,
    @Ignore val stats: Map<String, String>?,
) {
    constructor(id: String, name: String, description: String, colloq: String, plaintext: String, into: List<String>?, tags: List<String>) :
            this(id, name, description, colloq, plaintext, into, null, null, tags, null, null)
}

data class Image(
    val full: String,
    val sprite: String,
    val group: String,
    val x: Int,
    val y: Int,
    val w: Int,
    val h: Int
)

data class Gold(
    val base: Int,
    val purchasable: Boolean,
    val total: Int,
    val sell: Int
)