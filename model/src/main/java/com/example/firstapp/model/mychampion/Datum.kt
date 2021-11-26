package com.example.firstapp.model.mychampion

import android.os.Parcelable

import kotlinx.parcelize.Parcelize

@Parcelize
data class Datum (
//    val version: Version,
    val id: String,
    val key: String,
    val name: String,
//    val title: String,
//    val blurb: String,
//    val info: Info,
//    val image: Image,
//    val tags: List<Tag>,
//    val partype: Partype,
//    val stats: Map<String, Double>
): Parcelable