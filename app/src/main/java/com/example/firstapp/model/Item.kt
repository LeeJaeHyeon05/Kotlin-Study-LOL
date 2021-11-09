package com.example.firstapp.model

data class ItemJson(
    val type: String,
    val version: String,
    val data: Map<String, Data>,
)

data class Data(
    val name: String,
    val description: String,
    val colloq: String,
    val plaintext: String,
    val into: List<String>,
    val image: Image,
    val gold: Gold,
    val tags: List<String>,
    val maps: Map<String, Boolean>,
    val stats: Map<String, String>,
)

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